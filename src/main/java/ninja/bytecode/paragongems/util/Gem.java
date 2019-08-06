package ninja.bytecode.paragongems.util;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import ninja.bytecode.paragongems.base.BlockGemOre;
import ninja.bytecode.paragongems.base.ItemGem;

public class Gem implements IGem
{
	private final String id;
	private final String name;
	private ItemGem gem;
	private BlockGemOre ore;
	private Item ib;
	private float minTemperature;
	private float maxTemperature;
	private float minRainfall;
	private float maxRainfall;
	private float hardness;
	private float resistance;
	private int minXp;
	private int maxXp;
	private int harvestLevel;
	private boolean oregen;

	public Gem(String id, String name)
	{
		this.id = id;
		this.name = name;
		setTemperatureRequirements(-1f, 2f);
		setRainfallRequirements(0f, 1f);
		setXPDrop(3, 7);
		setHardness(3F);
		setResistance(5F);
		setHarvestLevel(2);
		setGenerateOre(true);
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
	public void setGemOreItem(Item ib)
	{
		this.ib = ib;

	}

	@Override
	public Item getGemOreItem()
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

	@Override
	public int getMinXP()
	{
		return minXp;
	}

	@Override
	public int getMaxXP()
	{
		return maxXp;
	}

	@Override
	public void setXPDrop(int min, int max)
	{
		this.maxXp = max;
		this.minXp = min;
	}

	@Override
	public int dropXP(Random random)
	{
		if(minXp < maxXp && maxXp > 0)
		{
			return random.nextInt((getMaxXP() - getMinXP()) + 1) + getMinXP();
		}

		return 0;
	}

	@Override
	public float getResistance()
	{
		return resistance;
	}

	@Override
	public float getHardness()
	{
		return hardness;
	}

	@Override
	public void setHardness(float h)
	{
		this.hardness = h;
	}

	@Override
	public void setResistance(float r)
	{
		this.resistance = r;
	}

	@Override
	public int getHarvestLevel()
	{
		return harvestLevel;
	}

	@Override
	public void setHarvestLevel(int level)
	{
		this.harvestLevel = level;
	}

	@Override
	public boolean hasOre()
	{
		return oregen;
	}

	@Override
	public void setGenerateOre(boolean oregen)
	{
		this.oregen = oregen;
	}
}
