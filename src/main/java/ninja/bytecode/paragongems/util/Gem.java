package ninja.bytecode.paragongems.util;

import ninja.bytecode.paragongems.base.ItemGem;

public class Gem implements IGem
{
	private final String id;
	private final String name;
	private ItemGem gem;

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
}
