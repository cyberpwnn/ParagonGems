package ninja.bytecode.paragongems.util;

import ninja.bytecode.paragongems.base.ItemChisel;

public interface IChisel
{
	public String getID();

	public String getName();

	public void setChiselItem(ItemChisel chisel);

	public ItemChisel getChiselItem();
}
