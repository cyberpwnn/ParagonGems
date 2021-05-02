package ninja.bytecode.paragongems.gems;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.BiomeDesert;
import ninja.bytecode.paragongems.util.Gem;

public class GemAgate extends Gem
{
	public GemAgate()
	{
		super("agate", "Agate");
		setOreHeightRange(12, 32);
		setRainfallRequirements(0.0f, 0.25f);
		setTemperatureRequirements(0.6f, 2f);
	}
}
