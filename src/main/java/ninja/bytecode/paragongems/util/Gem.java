package ninja.bytecode.paragongems.util;

import java.util.Random;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import ninja.bytecode.paragongems.base.*;
import ninja.bytecode.paragongems.common.ParagonGemOreGenerator;
import ninja.bytecode.paragongems.common.ProxyCommon;

public class Gem implements IGem
{
	private static final double GLOBAL_GEN_MULTIPLIER = 0.775;
	private final String id;
	private GemTinkerModifier modifier;
	private final String name;
	private ItemGem gem;
	private ItemGemRock gemRock;
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
	private int oregenDimension;
	private int minXp;
	private int maxXp;
	private int minHeight;
	private int maxHeight;
	private int harvestLevel;
	private double genChance;
	private boolean oregen;
	private boolean rocks;
	private boolean resourceblock;
	private long hash;

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
		setUseResourceBlocks(true);
		setUseRocks(true);
		setOregenDimension(0);
		setOreHeightRange(1, 254);
		setGenChance(0.15);
		hash = UUID.nameUUIDFromBytes((getID() + "-o-" + getName()).getBytes()).getMostSignificantBits() + 10000 * Short.MAX_VALUE;
		System.out.println(getName() + " Gem's Hash = " + hash);
	}

	public void setGenChance(double genChance)
	{
		this.genChance = genChance;
	}

	public double getGenChance()
	{
		return genChance;
	}

	public void setModifier(GemTinkerModifier modifier)
	{
		this.modifier = modifier;
	}

	public GemTinkerModifier getModifier()
	{
		return modifier;
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
	public void setGemRockItem(ItemGemRock gem)
	{
		this.gemRock = gem;
	}

	@Override
	public ItemGemRock getGemRockItem()
	{
		return gemRock;
	}

	@Override
	public boolean hasRocks()
	{
		return rocks;
	}

	@Override
	public void setUseRocks(boolean rb)
	{
		this.rocks = rb;
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

		else if(item instanceof ItemGemRock)
		{
			((ItemGemRock) item).getGem();
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
			if(i.getClass().equals(gem))
			{
				return (T) i;
			}
		}

		return null;
	}

	@Override
	public int getOregenDimension()
	{
		return oregenDimension;
	}

	@Override
	public void setOregenDimension(int dim)
	{
		this.oregenDimension = dim;
	}

	@Override
	public int getOreMinimumHeight()
	{
		return minHeight;
	}

	@Override
	public int getOreMaximumHeight()
	{
		return maxHeight;
	}

	@Override
	public void setOreHeightRange(int min, int max)
	{
		this.maxHeight = max;
		this.minHeight = min;
	}

	@Override
	public int getYLevel(World world, int chunkX, int chunkZ)
	{
		int dim = world.provider.getDimension();

		if((dim > 1 || dim < -1 && oregenDimension == 0) || dim == oregenDimension)
		{
			Block replacer = oregenDimension == 0 ? Blocks.STONE : oregenDimension == -1 ? Blocks.NETHERRACK : oregenDimension == 1 ? Blocks.END_STONE : Blocks.STONE;
			SimplexNoiseGenerator superHeight = new SimplexNoiseGenerator(hash - world.getSeed());
			SimplexNoiseGenerator subHeight = new SimplexNoiseGenerator(hash + world.getSeed());
			SimplexNoiseGenerator gate = new SimplexNoiseGenerator(hash - world.getSeed());
			double im = 0;
			double ih = 0;
			for(int ii = 0; ii < 16; ii += 14)
			{
				for(int jj = 0; jj < 16; jj += 14)
				{
					int i = (chunkX << 4) + ii + 1;
					int j = (chunkZ << 4) + jj + 1;
					gate.noise(i / 8D, j / 8D);
					double r = getOreMaximumHeight() - getOreMinimumHeight();
					double a = getOreMinimumHeight() + (((superHeight.noise(i / 3000D, j / 3000D) / 2D) + 0.5D) * r);
					double b = 4.155D * ((subHeight.noise(j / 8.534D, i / 8.534D) / 2D) + 0.5D);
					im += ((a - 4.155D) + b);
					ih += world.getHeight(i, j);
				}
			}

			int y = (int) Math.round(im / 4D);
			int h = (int) Math.round(ih / 4D);

			if(h < y)
			{
				return -y;
			}

			return y;
		}

		return -1;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		int dim = world.provider.getDimension();

		if((dim > 1 || dim < -1 && oregenDimension == 0) || dim == oregenDimension)
		{
			Block replacer = oregenDimension == 0 ? Blocks.STONE : oregenDimension == -1 ? Blocks.NETHERRACK : oregenDimension == 1 ? Blocks.END_STONE : Blocks.STONE;
			SimplexNoiseGenerator superHeight = new SimplexNoiseGenerator(hash - world.getSeed());
			SimplexNoiseGenerator subHeight = new SimplexNoiseGenerator(hash + world.getSeed());
			SimplexNoiseGenerator gate = new SimplexNoiseGenerator(hash - world.getSeed());

			for(int ii = 0; ii < 16; ii++)
			{
				for(int jj = 0; jj < 16; jj++)
				{
					int i = (chunkX << 4) + ii + 1;
					int j = (chunkZ << 4) + jj + 1;

					if(gate.noise(i / 8D, j / 8D) > getGenChance() * GLOBAL_GEN_MULTIPLIER)
					{
						continue;
					}

					double r = getOreMaximumHeight() - getOreMinimumHeight();
					double a = getOreMinimumHeight() + (((superHeight.noise(i / 3000D, j / 3000D) / 2D) + 0.5D) * r);
					double b = 4.155D * ((subHeight.noise(j / 8.534D, i / 8.534D) / 2D) + 0.5D);
					BlockPos p = new BlockPos(i, (int) Math.round((a - 4.155D) + b), j);

					if(ParagonGemOreGenerator.DEBUG_GENERATOR_NO_STONE || world.getBlockState(p).getBlock().equals(replacer))
					{
						world.setBlockState(p, getGemOre().getDefaultState());
					}
				}
			}
		}
	}
}
