package ninja.bytecode.paragongems.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ninja.bytecode.paragongems.ParagonGems;
import ninja.bytecode.paragongems.base.BlockGem;
import ninja.bytecode.paragongems.base.BlockGemOre;
import ninja.bytecode.paragongems.base.ItemChisel;
import ninja.bytecode.paragongems.base.ItemGem;
import ninja.bytecode.paragongems.base.ParagonCreativeTab;
import ninja.bytecode.paragongems.util.BaseProxy;
import ninja.bytecode.paragongems.util.Chisel;
import ninja.bytecode.paragongems.util.Gem;
import ninja.bytecode.paragongems.util.IChisel;
import ninja.bytecode.paragongems.util.IGem;
import ninja.bytecode.paragongems.util.IProxy;
import ninja.bytecode.paragongems.util.Utilities;

@Mod.EventBusSubscriber(modid = ParagonGems.MODID)
public class ProxyCommon extends BaseProxy implements IProxy
{
	private final static Map<String, SoundEvent> sounds = new HashMap<>();
	private final static List<IGem> gems = Utilities.getInstances(Gem.class, ParagonGems.GEMS);
	private final static List<IChisel> chisels = Utilities.getInstances(Chisel.class, ParagonGems.CHISELS);
	private final static ParagonCreativeTab tab = new ParagonCreativeTab();

	@Override
	public void onPreInit(FMLPreInitializationEvent e)
	{
		getLogger().info("Common Pre Init");
		for(IChisel i : getChisels())
		{
			ItemChisel chisel = new ItemChisel(i);
			chisel.setCreativeTab(tab);
			i.setChiselItem(chisel);
			i("Registering Chisel: " + i.getName());
		}

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
	public static void registerSounds(RegistryEvent.Register<SoundEvent> e)
	{
		register(e, "hit", "ting", "break", "gems");
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> e)
	{
		for(IChisel i : getChisels())
		{
			e.getRegistry().register(i.getChiselItem());
		}

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

	public static SoundEvent getHitSound()
	{
		return sounds.get("hit");
	}

	public static SoundEvent getTingSound()
	{
		return sounds.get("ting");
	}

	public static SoundEvent getBreakSound()
	{
		return sounds.get("break");
	}

	public static SoundEvent getGemSound()
	{
		return sounds.get("gems");
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

	private static void register(RegistryEvent.Register<SoundEvent> e, String... fs)
	{
		for(String res : fs)
		{
			sounds.put(res, new SoundEvent(new ResourceLocation(ParagonGems.MODID, res)));
			sounds.get(res).setRegistryName(res);
			e.getRegistry().register(sounds.get(res));
		}
	}

	public static List<IChisel> getChisels()
	{
		return chisels;
	}

	public static List<IGem> getGems()
	{
		return gems;
	}
}
