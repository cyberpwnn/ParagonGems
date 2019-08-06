package ninja.bytecode.paragongems.base;

import net.minecraft.item.Item;
import ninja.bytecode.paragongems.util.IGem;

public class ItemGem extends Item
{
	public ItemGem(IGem gem)
	{
		setUnlocalizedName("item_" + gem.getID());
		setRegistryName("item_" + gem.getID());
	}
}
