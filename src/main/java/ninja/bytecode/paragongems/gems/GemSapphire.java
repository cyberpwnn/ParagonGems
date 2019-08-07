package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemSapphire extends Gem
{
	public GemSapphire()
	{
		super("sapphire", "Sapphire");
		setTemperatureRequirements(-0.5f, -0.1f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(50, 100);
	}
}
