package ninja.bytecode.paragongems.util;

import ninja.bytecode.paragongems.base.ItemChisel;

public class Chisel implements IChisel
{
	private final String id;
	private final String name;
	private ItemChisel chisel;

	public Chisel(String id, String name)
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
	public void setChiselItem(ItemChisel chisel)
	{
		this.chisel = chisel;
	}

	@Override
	public ItemChisel getChiselItem()
	{
		return chisel;
	}
}
