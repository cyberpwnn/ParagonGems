package ninja.bytecode.paragongems.server;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ninja.bytecode.paragongems.common.ProxyCommon;
import ninja.bytecode.paragongems.util.IProxy;

public class ProxyServer extends ProxyCommon implements IProxy
{
	@SideOnly(Side.SERVER)
	@Override
	public void onPreInit(FMLPreInitializationEvent e)
	{
		super.onPreInit(e);
		getLogger().info("Server Pre Init");
	}

	@SideOnly(Side.SERVER)
	@Override
	public void onInit(FMLInitializationEvent e)
	{
		super.onInit(e);
		getLogger().info("Server Init");
	}

	@SideOnly(Side.SERVER)
	@Override
	public void onPostEvent(FMLPostInitializationEvent e)
	{
		super.onPostEvent(e);
		getLogger().info("Server Post Init");
	}
}
