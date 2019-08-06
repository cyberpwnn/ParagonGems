package ninja.bytecode.paragongems.common;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ninja.bytecode.paragongems.ParagonGems;
import ninja.bytecode.paragongems.base.ItemGem;
import ninja.bytecode.paragongems.base.ParagonCreativeTab;
import ninja.bytecode.paragongems.util.BaseProxy;
import ninja.bytecode.paragongems.util.Gem;
import ninja.bytecode.paragongems.util.IGem;
import ninja.bytecode.paragongems.util.IProxy;
import ninja.bytecode.paragongems.util.Utilities;

@Mod.EventBusSubscriber(modid = ParagonGems.MODID)
public class ProxyCommon extends BaseProxy implements IProxy
{
	private final static List<Gem> gems = Utilities.getInstances(Gem.class, ParagonGems.GEMS);
	private final static ParagonCreativeTab tab = new ParagonCreativeTab();

	@Override
	public void onPreInit(FMLPreInitializationEvent e)
	{
		getLogger().info("Common Pre Init");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e)
	{
		for(IGem i : getGems())
		{
			ItemGem ig = new ItemGem(i);
			ig.setCreativeTab(tab);
			i.setGemItem(ig);
			e.getRegistry().register(ig);
		}
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

	protected static List<Gem> getGems()
	{
		return gems;
	}
}
