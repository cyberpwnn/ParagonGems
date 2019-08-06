package ninja.bytecode.paragongems.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ParagonCreativeTab extends CreativeTabs
{

	public ParagonCreativeTab()
	{
		super("Paragon Gems");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return new ItemStack(Items.EMERALD);
	}
}
