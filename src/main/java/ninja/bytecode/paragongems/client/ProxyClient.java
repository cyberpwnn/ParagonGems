package ninja.bytecode.paragongems.client;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ninja.bytecode.paragongems.common.ProxyCommon;
import ninja.bytecode.paragongems.util.IProxy;

public class ProxyClient extends ProxyCommon implements IProxy
{
	@SideOnly(Side.CLIENT)
	@Override
	public void onPreInit(FMLPreInitializationEvent e)
	{
		super.onPreInit(e);
		getLogger().info("Client Pre Init");
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void onInit(FMLInitializationEvent e)
	{
		super.onInit(e);
		getLogger().info("Client Init");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void onPostEvent(FMLPostInitializationEvent e)
	{
		super.onPostEvent(e);
		getLogger().info("Client Post Init");
	}
}
