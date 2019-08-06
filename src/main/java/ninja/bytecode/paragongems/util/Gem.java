package ninja.bytecode.paragongems.util;

import net.minecraft.item.ItemBlock;
import ninja.bytecode.paragongems.base.BlockGemOre;
import ninja.bytecode.paragongems.base.ItemGem;

public class Gem implements IGem
{
	private final String id;
	private final String name;
	private ItemGem gem;
	private BlockGemOre ore;
	private ItemBlock ib;

	public Gem(String id, String name)
	{
		this.id = id;
		this.name = name;
	}

	@Override
	public String getID()
	{
		return id;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setGemItem(ItemGem gem)
	{
		this.gem = gem;

	}

	@Override
	public ItemGem getGemItem()
	{
		return gem;
	}

	@Override
	public void setGemOre(BlockGemOre block)
	{
		this.ore = block;
		
	}

	@Override
	public BlockGemOre getGemOre()
	{
		return ore;
	}

	@Override
	public void setGemOreItem(ItemBlock ib)
	{
		this.ib = ib;
		
	}

	@Override
	public ItemBlock getGemOreItem()
	{
		return ib;
	}
}
