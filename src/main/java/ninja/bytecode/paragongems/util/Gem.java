package ninja.bytecode.paragongems.util;

import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.Biome;
import ninja.bytecode.paragongems.base.BlockGemOre;
import ninja.bytecode.paragongems.base.ItemGem;

public class Gem implements IGem
{
	private final String id;
	private final String name;
	private ItemGem gem;
	private BlockGemOre ore;
	private ItemBlock ib;
	private float minTemperature;
	private float maxTemperature;
	private float minRainfall;
	private float maxRainfall;

	public Gem(String id, String name)
	{
		this.id = id;
		this.name = name;
		setTemperatureRequirements(-1f, 2f);
		setRainfallRequirements(0f, 1f);
	}

	@Override
	public String getID()
	{
		return id;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public void setGemItem(ItemGem gem)
	{
		this.gem = gem;

	}

	@Override
	public ItemGem getGemItem()
	{
		return gem;
	}

	@Override
	public void setGemOre(BlockGemOre block)
	{
		this.ore = block;

	}

	@Override
	public BlockGemOre getGemOre()
	{
		return ore;
	}

	@Override
	public void setGemOreItem(ItemBlock ib)
	{
		this.ib = ib;

	}

	@Override
	public ItemBlock getGemOreItem()
	{
		return ib;
	}

	@Override
	public void setTemperatureRequirements(float min, float max)
	{
		this.minTemperature = min;
		this.maxTemperature = max;
	}

	@Override
	public float getMinimumTemperature()
	{
		return minTemperature;
	}

	@Override
	public float getMaximumTemperature()
	{
		return maxTemperature;
	}

	@Override
	public void setRainfallRequirements(float min, float max)
	{
		this.minRainfall = min;
		this.maxRainfall = max;
	}

	@Override
	public float getMinimumRainfall()
	{
		return minRainfall;
	}

	@Override
	public float getMaximumRainfall()
	{
		return maxRainfall;
	}

	@Override
	public boolean canGenerate(Biome b)
	{
		return b.getDefaultTemperature() > getMinimumTemperature() && b.getDefaultTemperature() < getMaximumTemperature() && b.getRainfall() > getMinimumRainfall() && b.getRainfall() < getMaximumRainfall();
	}
}
