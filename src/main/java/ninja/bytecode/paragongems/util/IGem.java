package ninja.bytecode.paragongems.util;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import ninja.bytecode.paragongems.base.*;

/**
 * Represents a gem which can be used to register items and blocks for each gem
 * type
 *
 * @author cyberpwn
 */
public interface IGem
{
	/**
	 * Get the id for this gem. For example "sapphire"
	 *
	 * @return the gem base id
	 */
	public String getID();

	/**
	 * Get the single word name of this gem type such as "Sapphire"
	 *
	 * @return the gem type name
	 */
	public String getName();

	public void setGemItem(ItemGem gem);

	public void setGemRockItem(ItemGemRock gem);

	public void setGemOre(BlockGemOre block);

	public BlockGemOre getGemOre();

	public void setGemBlock(BlockGem block);

	public BlockGem getGemBlock();

	public ItemGem getGemItem();

	public ItemGemRock getGemRockItem();

	public void setGemOreItem(Item ib);

	public Item getGemOreItem();

	public void setGemBlockItem(Item ib);

	public Item getGemBlockItem();

	public void setTemperatureRequirements(float min, float max);

	public float getMinimumTemperature();

	public float getMaximumTemperature();

	public void setRainfallRequirements(float min, float max);

	public float getMinimumRainfall();

	public float getMaximumRainfall();

	public boolean canGenerate(Biome b);

	public int getMinXP();

	public int getMaxXP();

	public void setXPDrop(int min, int max);

	public float getResistance();

	public float getHardness();

	public void setHardness(float h);

	public void setResistance(float r);

	public int getHarvestLevel();

	public void setHarvestLevel(int level);

	public int dropXP(Random random);

	public boolean hasOre();

	public void setGenerateOre(boolean oregen);

	public boolean hasResourceBlock();

	public void setUseResourceBlocks(boolean rb);

	public boolean hasRocks();

	public void setUseRocks(boolean rb);

	public int getOregenDimension();

	public void setOregenDimension(int dim);

	public int getOreMinimumHeight();

	public int getOreMaximumHeight();

	public void setOreHeightRange(int min, int max);

	public int getYLevel(World world, int chunkX, int chunkZ);

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider);

    IChisel getChisel();
}
