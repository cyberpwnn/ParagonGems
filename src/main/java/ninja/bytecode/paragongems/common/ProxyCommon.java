package ninja.bytecode.paragongems.common;

import java.util.List;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ninja.bytecode.paragongems.ParagonGems;
import ninja.bytecode.paragongems.util.Gem;
import ninja.bytecode.paragongems.util.IProxy;
import ninja.bytecode.paragongems.util.Utilities;

public class ProxyCommon implements IProxy
{
	private final List<Gem> gems = Utilities.getInstances(Gem.class, ParagonGems.GEMS);

	@Override
	public void onPreInit(FMLPreInitializationEvent e)
	{
		getLogger().info("Common Pre Init");
	}

	@Override
	public void onInit(FMLInitializationEvent e)
	{
		getLogger().info("Common Init");
	}

	@Override
	public void onPostEvent(FMLPostInitializationEvent e)
	{
		getLogger().info("Common Post Init");
	}

	@Override
	public Logger getLogger()
	{
		return ParagonGems.logger;
	}

	public List<Gem> getGems()
	{
		return gems;
	}
}
