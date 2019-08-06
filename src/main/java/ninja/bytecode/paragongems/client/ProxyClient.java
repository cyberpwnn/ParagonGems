package ninja.bytecode.paragongems.client;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ninja.bytecode.paragongems.ParagonGems;
import ninja.bytecode.paragongems.common.ProxyCommon;
import ninja.bytecode.paragongems.util.IGem;
import ninja.bytecode.paragongems.util.IProxy;

@Mod.EventBusSubscriber(modid = ParagonGems.MODID)
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

	@SubscribeEvent
	public static void registerItemRenders(ModelRegistryEvent event)
	{
		for(IGem i : ProxyCommon.getGems())
		{
			ModelLoader.setCustomModelResourceLocation(i.getGemItem(), 0, new ModelResourceLocation(i.getGemItem().getRegistryName(), "inventory"));
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(i.getGemOre()), 0, new ModelResourceLocation(Item.getItemFromBlock(i.getGemOre()).getRegistryName(), "inventory"));
		}
	}

}
