package ninja.bytecode.paragongems.util;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy
{
	public Logger getLogger();

	public void onPreInit(FMLPreInitializationEvent e);

	public void onInit(FMLInitializationEvent e);

	public void onPostEvent(FMLPostInitializationEvent e);
}
