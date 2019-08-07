package ninja.bytecode.paragongems.util;

import ninja.bytecode.paragongems.base.ItemChisel;

public interface IChisel
{
	public String getID();

	public String getName();

	public void setFortuneLevel(int level);

	public int getFortuneLevel();

	public void setTickMod(int level);

	public int getTickMod();

	public void setEfficiencyMod(int level);

	public int getEfficiencyMod();

	public void setChiselItem(ItemChisel chisel);

	public ItemChisel getChiselItem();

	public boolean isMetal();

	public boolean isModification();

	public void setModification(boolean mod);

	public void setMetal(boolean metal);
}
