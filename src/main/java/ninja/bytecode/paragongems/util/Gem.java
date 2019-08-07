package ninja.bytecode.paragongems.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.Biome;
import ninja.bytecode.paragongems.base.BlockGem;
import ninja.bytecode.paragongems.base.BlockGemOre;
import ninja.bytecode.paragongems.base.ItemGem;
import ninja.bytecode.paragongems.base.ItemGemShard;
import ninja.bytecode.paragongems.common.ProxyCommon;

public class Gem implements IGem
{
	private final String id;
	private final String name;
	private ItemGem gem;
	private ItemGemShard gemShard;
	private BlockGemOre ore;
	private BlockGem block;
	private Item itemBlockOre;
	private Item itemBlock;
	private float minTemperature;
	private float maxTemperature;
	private float minRainfall;
	private float maxRainfall;
	private float hardness;
	private float resistance;
	private int minXp;
	private int maxXp;
	private int shardCount;
	private int harvestLevel;
	private boolean oregen;
	private boolean shards;
	private boolean resourceblock;

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
		setShardCount(3);
		setGenerateOre(true);
		setUseResourceBlocks(true);
		setUseShards(true);
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
		this.itemBlockOre = ib;

	}

	@Override
	public Item getGemOreItem()
	{
		return itemBlockOre;
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

	@Override
	public boolean hasResourceBlock()
	{
		return resourceblock;
	}

	@Override
	public void setUseResourceBlocks(boolean rb)
	{
		this.resourceblock = rb;
	}

	@Override
	public void setGemBlock(BlockGem block)
	{
		this.block = block;
	}

	@Override
	public BlockGem getGemBlock()
	{
		return block;
	}

	@Override
	public void setGemBlockItem(Item ib)
	{
		this.itemBlock = ib;
	}

	@Override
	public Item getGemBlockItem()
	{
		return itemBlock;
	}

	@Override
	public void setGemShardItem(ItemGemShard gem)
	{
		this.gemShard = gem;
	}

	@Override
	public ItemGemShard getGemShardItem()
	{
		return gemShard;
	}

	@Override
	public boolean hasShard()
	{
		return shards;
	}

	@Override
	public void setUseShards(boolean rb)
	{
		this.shards = rb;
	}

	@Override
	public int getShardCount()
	{
		return shardCount;
	}

	@Override
	public void setShardCount(int rb)
	{
		this.shardCount = rb;
	}

	public static IGem getGem(Block item)
	{
		if(item instanceof BlockGemOre)
		{
			((BlockGemOre) item).getGem();
		}

		else if(item instanceof BlockGem)
		{
			((BlockGem) item).getGem();
		}

		return null;
	}

	public static IGem getGem(Item item)
	{
		if(item instanceof ItemGem)
		{
			((ItemGem) item).getGem();
		}

		else if(item instanceof ItemGemShard)
		{
			((ItemGemShard) item).getGem();
		}

		else if(item instanceof ItemBlock && ((ItemBlock) item).getBlock() instanceof BlockGemOre)
		{
			((BlockGemOre) ((ItemBlock) item).getBlock()).getGem();
		}

		else if(item instanceof ItemBlock && ((ItemBlock) item).getBlock() instanceof BlockGem)
		{
			((BlockGem) ((ItemBlock) item).getBlock()).getGem();
		}

		return null;
	}

	public static IGem getRandomGem()
	{
		return ProxyCommon.getGems().get(ProxyCommon.random.nextInt(ProxyCommon.getGems().size()));
	}

	public static IGem getGem(String id)
	{
		for(IGem i : ProxyCommon.getGems())
		{
			if(i.getID().equals(id))
			{
				return i;
			}
		}

		return null;
	}

	public static <T extends IGem> T getGem(Class<T> gem)
	{
		for(IGem i : ProxyCommon.getGems())
		{
			if(i.equals(gem.getClass()))
			{
				return (T) i;
			}
		}

		return null;
	}
}
