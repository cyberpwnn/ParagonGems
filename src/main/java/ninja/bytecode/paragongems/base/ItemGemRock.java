package ninja.bytecode.paragongems.base;

import net.minecraft.item.Item;
import ninja.bytecode.paragongems.util.IGem;

public class ItemGemRock extends Item
{
	private IGem gem;

	public ItemGemRock(IGem gem)
	{
		setUnlocalizedName("item_" + gem.getID() + "_rock");
		setRegistryName("item_" + gem.getID() + "_rock");
		this.gem = gem;
	}

	public IGem getGem()
	{
		return gem;
	}
}
