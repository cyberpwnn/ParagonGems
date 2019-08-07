package ninja.bytecode.paragongems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.common.ProxyCommon;
import ninja.bytecode.paragongems.util.IGem;

public class CommandParagon extends CommandBase
{
	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] params) throws CommandException
	{
		if(sender instanceof EntityPlayerMP)
		{
			EntityPlayerMP p = (EntityPlayerMP) sender;
			World w = p.getServerWorld();
			int chunkX = p.getPosition().getX() >> 4;
			int chunkZ = p.getPosition().getZ() >> 4;

			if(params.length == 0)
			{
				String message = "/paragon localfracture - Look for local ore Y levels";
				TextComponentString text = new TextComponentString(message);
				text.getStyle().setColor(TextFormatting.GRAY);
				sender.sendMessage(text);
			}

			if(params.length >= 1)
			{
				if(params[0].equalsIgnoreCase("local") || params[0].equalsIgnoreCase("localfracture"))
				{
					HashMap<IGem, Integer> hm = new HashMap<IGem, Integer>();

					for(IGem i : ProxyCommon.getGems())
					{
						int g = i.getYLevel(w, chunkX, chunkZ);
						if(g >= 0)
						{
							hm.put(i, g);
						}
					}

					for(int i = 0; i < 15; i++)
					{
						String message = "   ";
						TextComponentString text = new TextComponentString(message);
						text.getStyle().setColor(TextFormatting.GRAY);
						sender.sendMessage(text);
					}

					for(Map.Entry<IGem, Integer> en : sortByValue(hm).entrySet())
					{
						IGem gem = en.getKey();
						int y = en.getValue();
						String message = gem.getName() + ": " + y;
						TextComponentString text = new TextComponentString(message);
						text.getStyle().setColor(TextFormatting.GRAY);
						sender.sendMessage(text);
					}
				}
			}
		}
	}

	@Override
	public String getName()
	{
		return "paragon";
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return "General Usage";
	}

	public static HashMap<IGem, Integer> sortByValue(HashMap<IGem, Integer> hm)
	{
		List<Map.Entry<IGem, Integer>> list = new LinkedList<Map.Entry<IGem, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<IGem, Integer>>()
		{
			@Override
			public int compare(Map.Entry<IGem, Integer> o1, Map.Entry<IGem, Integer> o2)
			{
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		HashMap<IGem, Integer> temp = new LinkedHashMap<IGem, Integer>();
		for(Map.Entry<IGem, Integer> aa : list)
		{
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
}