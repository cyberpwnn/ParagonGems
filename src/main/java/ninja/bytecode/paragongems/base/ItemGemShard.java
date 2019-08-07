package ninja.bytecode.paragongems.base;

import net.minecraft.item.Item;
import ninja.bytecode.paragongems.util.IGem;

public class ItemGemShard extends Item
{
	private IGem gem;

	public ItemGemShard(IGem gem)
	{
		setUnlocalizedName("item_" + gem.getID() + "_shard");
		setRegistryName("item_" + gem.getID() + "_shard");
		this.gem = gem;
	}

	public IGem getGem()
	{
		return gem;
	}
}
