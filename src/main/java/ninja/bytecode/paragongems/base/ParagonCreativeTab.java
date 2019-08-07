package ninja.bytecode.paragongems.base;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ninja.bytecode.paragongems.ParagonGems;
import ninja.bytecode.paragongems.common.ProxyCommon;
import ninja.bytecode.paragongems.util.IGem;

public class ParagonCreativeTab extends CreativeTabs
{
	private ItemStack icon;

	public ParagonCreativeTab(IGem gem)
	{
		super(ParagonGems.MODID);

		for(IGem i : ProxyCommon.getGems())
		{
			if(i.getID().equals(gem.getID()))
			{
				icon = new ItemStack(i.getGemItem());
			}
		}

		icon = new ItemStack(Items.EMERALD);
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return icon;
	}

	@Override
	public boolean hasSearchBar()
	{
		return true;
	}
}
