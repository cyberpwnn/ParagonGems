package ninja.bytecode.paragongems.common;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import ninja.bytecode.paragongems.util.IGem;

public class ParagonGemOreGenerator implements IWorldGenerator
{
	public static boolean DEBUG_GENERATOR_NO_STONE = true;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		Biome a = world.getBiome(new BlockPos(chunkX >> 4, 0, chunkZ >> 4));
		Biome b = world.getBiome(new BlockPos((chunkX >> 4) + 15, 0, chunkZ >> 4));
		Biome c = world.getBiome(new BlockPos((chunkX >> 4) + 15, 0, (chunkZ >> 4) + 15));
		Biome d = world.getBiome(new BlockPos(chunkX >> 4, 0, (chunkZ >> 4) + 15));

		for(IGem i : ProxyCommon.getGems())
		{
			if(i.hasOre() && (i.canGenerate(a) || i.canGenerate(b) || i.canGenerate(c) || i.canGenerate(d)))
			{
				i.generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
			}
		}
	}
}
