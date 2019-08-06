package ninja.bytecode.paragongems.common;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ninja.bytecode.paragongems.ParagonGems;
import ninja.bytecode.paragongems.base.BlockGemOre;
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
		for(IGem i : getGems())
		{
			BlockGemOre bg = new BlockGemOre(i);
			i.setGemOre(bg);
			bg.setCreativeTab(tab);

			ItemGem ig = new ItemGem(i);
			ig.setCreativeTab(tab);
			i.setGemItem(ig);

			Item ib = new ItemBlock(bg);
			ib.setRegistryName(bg.getRegistryName());
			i.setGemOreItem(ib);
		}
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e)
	{
		for(IGem i : getGems())
		{
			e.getRegistry().register(i.getGemItem());
			e.getRegistry().register(i.getGemOreItem());
		}
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> e)
	{
		for(IGem i : getGems())
		{
			e.getRegistry().register(i.getGemOre());
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

	public static List<Gem> getGems()
	{
		return gems;
	}
}
