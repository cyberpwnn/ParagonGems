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
import ninja.bytecode.paragongems.base.BlockGem;
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
			ItemGem ig = new ItemGem(i);
			ig.setCreativeTab(tab);
			i.setGemItem(ig);
			i("Registering Gem: " + i.getName());

			if(i.hasOre())
			{
				i("Registering Ore: " + i.getName());
				BlockGemOre bg = new BlockGemOre(i);
				Item ib = new ItemBlock(bg);
				ib.setRegistryName(bg.getRegistryName());
				bg.setCreativeTab(tab);
				i.setGemOre(bg);
				i.setGemOreItem(ib);
			}

			if(i.hasResourceBlock())
			{
				i("Registering Resource Block: " + i.getName());
				BlockGem bg = new BlockGem(i);
				Item ib = new ItemBlock(bg);
				ib.setRegistryName(bg.getRegistryName());
				bg.setCreativeTab(tab);
				i.setGemBlock(bg);
				i.setGemBlockItem(ib);
			}
		}
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e)
	{
		for(IGem i : getGems())
		{
			e.getRegistry().register(i.getGemItem());

			if(i.hasOre())
			{
				e.getRegistry().register(i.getGemOreItem());
			}

			if(i.hasResourceBlock())
			{
				e.getRegistry().register(i.getGemBlockItem());
			}
		}
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> e)
	{
		for(IGem i : getGems())
		{
			if(i.hasOre())
			{
				e.getRegistry().register(i.getGemOre());
			}

			if(i.hasResourceBlock())
			{
				e.getRegistry().register(i.getGemBlock());
			}
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
