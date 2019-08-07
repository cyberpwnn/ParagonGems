package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemBloodstone extends Gem
{
	public GemBloodstone()
	{
		super("bloodstone", "Bloodstone");
		setTemperatureRequirements(0f, 2f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(30, 60);
		setOregenDimension(-1);
	}
}
