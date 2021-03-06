package ninja.bytecode.paragongems.util;

import ninja.bytecode.paragongems.base.ItemChisel;

public class Chisel implements IChisel
{
	private final String id;
	private final String name;
	private String description;
	private int fortuneLevel;
	private ItemChisel chisel;
	private boolean mod;
	private boolean metal;
	private int tickmod;
	private int efficiencymod;
	private IGem tip;

	public Chisel(String id, String name)
	{
		this.id = id;
		this.name = name;
		setFortuneLevel(1);
		setMetal(false);
		setDescription("A chisel used to release ores from stone.");
		setTickMod(0);
		setEfficiencyMod(0);
		setModification(false);
	}

	public IGem getTip() {
		return tip;
	}

	public void setTip(IGem tip) {
		this.tip = tip;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
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

	@Override
	public void setTickMod(int level)
	{
		this.tickmod = level;
	}

	@Override
	public int getTickMod()
	{
		return tickmod;
	}

	@Override
	public void setEfficiencyMod(int level)
	{
		this.efficiencymod = level;
	}

	@Override
	public int getEfficiencyMod()
	{
		return efficiencymod;
	}

	@Override
	public boolean isModification()
	{
		return mod;
	}

	@Override
	public void setModification(boolean mod)
	{
		this.mod = mod;
	}
}
