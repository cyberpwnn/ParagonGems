package ninja.bytecode.paragongems.util;

import ninja.bytecode.paragongems.base.ItemChisel;

public class Chisel implements IChisel
{
	private final String id;
	private final String name;
	private int fortuneLevel;
	private ItemChisel chisel;
	private boolean metal;

	public Chisel(String id, String name)
	{
		this.id = id;
		this.name = name;
		setFortuneLevel(1);
		setMetal(false);
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
	public void setChiselItem(ItemChisel chisel)
	{
		this.chisel = chisel;
	}

	@Override
	public ItemChisel getChiselItem()
	{
		return chisel;
	}

	@Override
	public int getFortuneLevel()
	{
		return fortuneLevel;
	}

	@Override
	public void setFortuneLevel(int level)
	{
		this.fortuneLevel = level;
	}

	@Override
	public boolean isMetal()
	{
		return metal;
	}

	@Override
	public void setMetal(boolean metal)
	{
		this.metal = metal;
	}
}
