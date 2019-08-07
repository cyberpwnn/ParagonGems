package ninja.bytecode.paragongems.base;

import net.minecraft.item.Item;
import ninja.bytecode.paragongems.util.IGem;

public class ItemGem extends Item
{
	private IGem gem;

	public ItemGem(IGem gem)
	{
		setUnlocalizedName("item_" + gem.getID());
		setRegistryName("item_" + gem.getID());
		this.gem = gem;
	}

	public IGem getGem()
	{
		return gem;
	}
}
