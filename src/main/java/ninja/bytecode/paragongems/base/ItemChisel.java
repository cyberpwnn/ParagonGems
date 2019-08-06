package ninja.bytecode.paragongems.base;

import net.minecraft.item.Item;
import ninja.bytecode.paragongems.util.IChisel;

public class ItemChisel extends Item
{
	public ItemChisel(IChisel chisel)
	{
		setUnlocalizedName(chisel.getID());
		setRegistryName(chisel.getID());
	}
}
