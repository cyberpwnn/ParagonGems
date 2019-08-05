package ninja.bytecode.paragongems;

import static ninja.bytecode.paragongems.ParagonGems.*;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ninja.bytecode.paragongems.util.IProxy;

@Mod.EventBusSubscriber(modid = ParagonGems.MODID)
@Mod(modid = MODID, name = NAME, version = VERSION)
public class ParagonGems
{
	public static final String CLIENT = "ninja.bytecode.paragongems.client.ProxyClient";
	public static final String SERVER = "ninja.bytecode.paragongems.server.ProxyServer";
	public static final String MODID = "paragongems";
	public static final String NAME = "Paragon Gems";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = CLIENT, serverSide = SERVER)
	public static IProxy proxy;
	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		proxy.onPreInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.onInit(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.onPostEvent(event);
	}
}
