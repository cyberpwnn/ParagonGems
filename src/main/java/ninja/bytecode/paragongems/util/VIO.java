package ninja.bytecode.paragongems.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Enumeration;
import java.util.function.Consumer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class VIO
{
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String decompress(String gz) throws IOException
	{
		ByteArrayInputStream bin = new ByteArrayInputStream(Base64.getUrlDecoder().decode(gz));
		GZIPInputStream gzi = new GZIPInputStream(bin);
		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		VIO.fullTransfer(gzi, boas, 256);
		gzi.close();

		return new String(boas.toByteArray(), StandardCharsets.UTF_8);
	}

	public static byte[] sdecompress(String compressed) throws IOException
	{
		ByteArrayInputStream bin = new ByteArrayInputStream(Base64.getUrlDecoder().decode(compressed));
		GZIPInputStream gzi = new GZIPInputStream(bin);
		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		VIO.fullTransfer(gzi, boas, 256);
		gzi.close();

		return boas.toByteArray();
	}

	public static String scompress(byte[] data) throws IOException
	{
		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		GZIPOutputStream gzo = new CustomOutputStream(boas, 9);
		gzo.write(data);
		gzo.flush();
		gzo.close();

		return Base64.getUrlEncoder().encodeToString(boas.toByteArray());
	}

	public static String compress(String text) throws IOException
	{
		ByteArrayOutputStream boas = new ByteArrayOutputStream();
		GZIPOutputStream gzo = new CustomOutputStream(boas, 9);
		gzo.write(text.getBytes(StandardCharsets.UTF_8));
		gzo.flush();
		gzo.close();

		return Base64.getUrlEncoder().encodeToString(boas.toByteArray());
	}

	public static String encode(byte[] data)
	{
		return Base64.getUrlEncoder().encodeToString(data);
	}

	public static byte[] decode(String u)
	{
		return Base64.getUrlDecoder().decode(u);
	}

	public static String hash(String b)
	{
		try
		{
			MessageDigest d = MessageDigest.getInstance("SHA-256");
			return bytesToHex(d.digest(b.getBytes(StandardCharsets.UTF_8)));
		}

		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}

		return "¯\\_(ツ)_/¯";
	}

	public static String bytesToHex(byte[] bytes)
	{
		char[] hexChars = new char[bytes.length * 2];
		for(int j = 0; j < bytes.length; j++)
		{
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}

		return new String(hexChars).toUpperCase();
	}

	public static String hash(File f)
	{
		try
		{
			MessageDigest d = MessageDigest.getInstance("SHA-256");
			FileInputStream fin = new FileInputStream(f);
			DigestInputStream din = new DigestInputStream(fin, d);
			VIO.fullTransfer(din, new VoidOutputStream(), 16891);
			String hash = bytesToHex(d.digest());
			din.close();

			return hash;
		}

		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}

		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		catch(IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Transfers the length of the buffer amount of data from the input stream to
	 * the output stream
	 *
	 * @param in
	 *            the input
	 * @param out
	 *            the output
	 * @param amount
	 *            the buffer and size to use
	 * @return the actual transfered amount
	 * @throws IOException
	 *             shit happens
	 */
	public static int transfer(InputStream in, OutputStream out, byte[] buffer) throws IOException
	{
		int r = in.read(buffer);

		if(r != -1)
		{
			out.write(buffer, 0, r);
		}

		return r;
	}

	/**
	 * Transfers the length of the buffer amount of data from the input stream to
	 * the output stream
	 *
	 * @param in
	 *            the input
	 * @param out
	 *            the output
	 * @param targetBuffer
	 *            the buffer and size to use
	 * @param totalSize
	 *            the total amount to transfer
	 * @return the actual transfered amount
	 * @throws IOException
	 *             shit happens
	 */
	public static long transfer(InputStream in, OutputStream out, int targetBuffer, long totalSize) throws IOException
	{
		long total = totalSize;
		long wrote = 0;
		byte[] buf = new byte[targetBuffer];
		int r = 0;

		while((r = in.read(buf, 0, (int) (total < targetBuffer ? total : targetBuffer))) != -1)
		{
			total -= r;
			out.write(buf, 0, r);
			wrote += r;

			if(total <= 0)
			{
				break;
			}
		}

		return wrote;
	}

	/**
	 * Transfers the length of the buffer amount of data from the input stream to
	 * the output stream
	 *
	 * @param in
	 *            the input
	 * @param out
	 *            the output
	 * @param targetBuffer
	 *            the buffer and size to use
	 * @param totalSize
	 *            the total amount to transfer
	 * @param progress
	 *            the progress callback
	 * @return the actual transfered amount
	 * @throws IOException
	 *             shit happens
	 */
	public static long transfer(InputStream in, OutputStream out, int targetBuffer, long totalSize, Callback<Double> progress) throws IOException
	{
		long total = totalSize;
		long wrote = 0;
		byte[] buf = new byte[targetBuffer];
		int r = 0;
		ChronoLatch cl = new ChronoLatch(200, false);
		progress.run((double) wrote / (double) totalSize);

		while((r = in.read(buf, 0, (int) (total < targetBuffer ? total : targetBuffer))) != -1)
		{
			total -= r;
			out.write(buf, 0, r);
			wrote += r;

			if(cl.flip())
			{
				progress.run((double) wrote / (double) totalSize);
			}

			if(total <= 0)
			{
				break;
			}
		}

		progress.run((double) wrote / (double) totalSize);

		return wrote;
	}

	/**
	 * Fully move data from a finite inputstream to an output stream using a buffer
	 * size of 8192. This does NOT close streams.
	 *
	 * @param in
	 * @param out
	 * @return total size transfered
	 * @throws IOException
	 */
	public static long fillTransfer(InputStream in, OutputStream out) throws IOException
	{
		return fullTransfer(in, out, 8192);
	}

	public static void deleteUp(File f)
	{
		if(f.exists())
		{
			f.delete();

			if(f.getParentFile().list().length == 0)
			{
				deleteUp(f.getParentFile());
			}
		}
	}

	/**
	 * Fully move data from a finite inputstream to an output stream using a given
	 * buffer size. This does NOT close streams.
	 *
	 * @param in
	 *            the input stream to read from
	 * @param out
	 *            the output stream to write to
	 * @param bufferSize
	 *            the target buffer size
	 * @return total size transfered
	 * @throws IOException
	 *             shit happens
	 */
	public static long fullTransfer(InputStream in, OutputStream out, int bufferSize) throws IOException
	{
		long wrote = 0;
		byte[] buf = new byte[bufferSize];
		int r = 0;

		while((r = in.read(buf)) != -1)
		{
			out.write(buf, 0, r);
			wrote += r;
		}

		return wrote;
	}

	/**
	 * Recursive delete (deleting folders)
	 *
	 * @param f
	 *            the file to delete (and subfiles if folder)
	 */
	public static void delete(File f)
	{
		if(f == null || !f.exists())
		{
			return;
		}

		if(f.isDirectory())
		{
			for(File i : f.listFiles())
			{
				delete(i);
			}
		}

		f.delete();
	}

	public static long size(File file)
	{
		long s = 0;

		if(file.exists())
		{
			if(file.isDirectory())
			{
				for(File i : file.listFiles())
				{
					s += size(i);
				}
			}

			else
			{
				s += file.length();
			}
		}

		return s;
	}

	public static long count(File file)
	{
		long s = 0;

		if(file.exists())
		{
			if(file.isDirectory())
			{
				for(File i : file.listFiles())
				{
					s += count(i);
				}
			}

			else
			{
				s++;
			}
		}

		return s;
	}

	public static long transfer(InputStream in, OutputStream out, byte[] buf, int totalSize) throws IOException
	{
		long total = totalSize;
		long wrote = 0;
		int r = 0;

		while((r = in.read(buf, 0, (int) (total < buf.length ? total : buf.length))) != -1)
		{
			total -= r;
			out.write(buf, 0, r);
			wrote += r;

			if(total <= 0)
			{
				break;
			}
		}

		return wrote;
	}

	public static void readEntry(File zipfile, String entryname, Consumer<InputStream> v) throws ZipException, IOException
	{
		ZipFile file = new ZipFile(zipfile);
		Throwable x = null;

		try
		{
			Enumeration<? extends ZipEntry> entries = file.entries();
			while(entries.hasMoreElements())
			{
				ZipEntry entry = entries.nextElement();

				if(entryname.equals(entry.getName()))
				{
					InputStream in = file.getInputStream(entry);
					v.accept(in);
				}
			}
		}

		catch(Exception ex)
		{
			x = ex.getCause();
		}

		finally
		{
			file.close();
		}

		if(x != null)
		{
			throw new IOException("Failed to read zip entry, however it has been closed safely.", x);
		}
	}

	public static void writeAll(File f, Object c) throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileWriter(f));
		pw.println(c.toString());
		pw.close();
	}

	public static String readAll(File f) throws IOException
	{
		BufferedReader bu = new BufferedReader(new FileReader(f));
		String c = "";
		String l = "";

		while((l = bu.readLine()) != null)
		{
			c += l + "\n";
		}

		bu.close();

		return c;
	}

	public static String readAll(InputStream in) throws IOException
	{
		BufferedReader bu = new BufferedReader(new InputStreamReader(in));
		String c = "";
		String l = "";

		while((l = bu.readLine()) != null)
		{
			c += l + "\n";
		}

		bu.close();

		return c;
	}
}
