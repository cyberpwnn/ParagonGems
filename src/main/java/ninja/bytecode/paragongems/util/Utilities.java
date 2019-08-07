package ninja.bytecode.paragongems.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import ninja.bytecode.paragongems.ParagonGems;
import ninja.bytecode.paragongems.common.ProxyCommon;

public class Utilities
{
	public static <T> List<T> getInstances(Class<? extends T> baseClass, String packageName)
	{
		try
		{
			List<T> m = new ArrayList<>();
			for(Class<?> i : getClasses(packageName))
			{
				try
				{
					m.add((T) i.getConstructor().newInstance());
				}

				catch(Throwable e)
				{
					e.printStackTrace();
				}
			}

			return m;
		}

		catch(Throwable e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Scans all classes accessible from the context class loader which belong to
	 * the given package and subpackages.
	 *
	 * @param packageName
	 *            The base package
	 * @return The classes
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while(resources.hasMoreElements())
		{
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for(File directory : dirs)
		{
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 *
	 * @param directory
	 *            The base directory
	 * @param packageName
	 *            The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException
	{
		List<Class> classes = new ArrayList<Class>();
		if(!directory.exists())
		{
			return classes;
		}
		File[] files = directory.listFiles();
		for(File file : files)
		{
			if(file.isDirectory())
			{
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			}
			else if(file.getName().endsWith(".class"))
			{
				classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}

	public static void generateResources()
	{
		File master = new File(System.getProperty("user.dir"));
		System.out.println("Main Project Directory: " + master.getAbsolutePath());
		File res = new File(master, "src/main/resources");

		if(res.exists())
		{
			try
			{
				// Lang
				File lang = new File(res, "assets/" + ParagonGems.MODID + "/lang/en_us.lang");
				lang.getParentFile().mkdirs();
				PrintWriter pw = new PrintWriter(new FileOutputStream(lang));

				pw.println("itemGroup.paragongems=Paragon Gems");

				for(IChisel i : ProxyCommon.getChisels())
				{
					pw.println("item." + i.getID() + ".name=" + i.getName());
				}

				for(IGem i : ProxyCommon.getGems())
				{
					pw.println("item.item_" + i.getID() + "_shard.name=" + i.getName() + " Shard");
					pw.println("item.item_" + i.getID() + ".name=" + i.getName());
					pw.println("tile.block_" + i.getID() + "_ore.name=" + i.getName() + " Ore");
					pw.println("tile.block_" + i.getID() + ".name=" + i.getName() + " Block");
				}

				pw.close();
				System.out.println("Updated " + lang.getPath());

				// Block States
				File blockStateModels2 = new File(res, "assets/" + ParagonGems.MODID + "/blockstates");
				File blockStateModelDemo2 = new File(blockStateModels2, "block_gemx.json");

				if(blockStateModelDemo2.exists())
				{
					String text = VIO.readAll(blockStateModelDemo2);

					for(IGem i : ProxyCommon.getGems())
					{
						File gemJSON = new File(blockStateModels2, "block_" + i.getID() + ".json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qgemx\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}

				// Block States Ore
				File blockStateModels = new File(res, "assets/" + ParagonGems.MODID + "/blockstates");
				File blockStateModelDemo = new File(blockStateModels, "block_gemx_ore.json");

				if(blockStateModelDemo.exists())
				{
					String text = VIO.readAll(blockStateModelDemo);

					for(IGem i : ProxyCommon.getGems())
					{
						File gemJSON = new File(blockStateModels, "block_" + i.getID() + "_ore.json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qgemx\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}

				// Block Models
				File blockModels2 = new File(res, "assets/" + ParagonGems.MODID + "/models/block");
				File blockModelDemo2 = new File(blockModels2, "block_gemx.json");

				if(blockModelDemo2.exists())
				{
					String text = VIO.readAll(blockModelDemo2);

					for(IGem i : ProxyCommon.getGems())
					{
						File gemJSON = new File(blockModels2, "block_" + i.getID() + ".json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qgemx\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}

				// Block Models (Ore)
				File blockModels = new File(res, "assets/" + ParagonGems.MODID + "/models/block");
				File blockModelDemo = new File(blockModels, "block_gemx_ore.json");

				if(blockModelDemo.exists())
				{
					String text = VIO.readAll(blockModelDemo);

					for(IGem i : ProxyCommon.getGems())
					{
						File gemJSON = new File(blockModels, "block_" + i.getID() + "_ore.json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qgemx\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}

				// Item Block Models
				File itemBlockModels2 = new File(res, "assets/" + ParagonGems.MODID + "/models/item");
				File itemBlockModelDemo2 = new File(itemBlockModels2, "block_gemx.json");

				if(itemBlockModelDemo2.exists())
				{
					String text = VIO.readAll(itemBlockModelDemo2);

					for(IGem i : ProxyCommon.getGems())
					{
						File gemJSON = new File(itemBlockModels2, "block_" + i.getID() + ".json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qgemx\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}

				// Item Block Models (ore)
				File itemBlockModels = new File(res, "assets/" + ParagonGems.MODID + "/models/item");
				File itemBlockModelDemo = new File(itemBlockModels, "block_gemx_ore.json");

				if(itemBlockModelDemo.exists())
				{
					String text = VIO.readAll(itemBlockModelDemo);

					for(IGem i : ProxyCommon.getGems())
					{
						File gemJSON = new File(itemBlockModels, "block_" + i.getID() + "_ore.json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qgemx\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}

				// Item Models chisels
				File itemModels2 = new File(res, "assets/" + ParagonGems.MODID + "/models/item");
				File itemModelDemo2 = new File(itemModels2, "item_chix.json");

				if(itemModelDemo2.exists())
				{
					String text = VIO.readAll(itemModelDemo2);

					for(IChisel i : ProxyCommon.getChisels())
					{
						File gemJSON = new File(itemModels2, i.getID() + ".json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qchix\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}

				// Item Models (shards)
				File itemModels3 = new File(res, "assets/" + ParagonGems.MODID + "/models/item");
				File itemModelDemo3 = new File(itemModels3, "item_gemx_shard.json");

				if(itemModelDemo3.exists())
				{
					String text = VIO.readAll(itemModelDemo3);

					for(IGem i : ProxyCommon.getGems())
					{
						File gemJSON = new File(itemModels3, "item_" + i.getID() + "_shard.json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qgemx\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}

				// Item Models
				File itemModels = new File(res, "assets/" + ParagonGems.MODID + "/models/item");
				File itemModelDemo = new File(itemModels, "item_gemx.json");

				if(itemModelDemo.exists())
				{
					String text = VIO.readAll(itemModelDemo);

					for(IGem i : ProxyCommon.getGems())
					{
						File gemJSON = new File(itemModels, "item_" + i.getID() + ".json");
						VIO.writeAll(gemJSON, text.replaceAll("\\Qgemx\\E", i.getID()));
						System.out.println("Updated " + gemJSON.getPath());
					}
				}
			}

			catch(Throwable e)
			{
				e.printStackTrace();
			}
		}

		else
		{
			System.out.print("Cannot find src/main/resources folder!");
		}
	}
}
