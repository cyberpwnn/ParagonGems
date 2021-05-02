package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemSapphire extends Gem
{
	public GemSapphire()
	{
		super("sapphire", "Sapphire");
		setOreHeightRange(70, 126);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(-1f, 1f);
	}
}
