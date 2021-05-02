package ninja.bytecode.paragongems.base;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.util.IGem;

import javax.annotation.Nullable;
import java.util.List;

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

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);

		if(gem.getModifier() != null)
		{
			tooltip.add("Tool Modifier: " + gem.getModifier().getLocalizedName());
		}

		tooltip.add("Found between " + gem.getOreMinimumHeight() + " - " + gem.getOreMaximumHeight());
		tooltip.add("Rainfall " + gem.getMinimumRainfall() + " - " + gem.getMaximumRainfall());
		tooltip.add("Temperature " + gem.getMinimumTemperature() + " - " + gem.getMaximumTemperature());
	}
}
