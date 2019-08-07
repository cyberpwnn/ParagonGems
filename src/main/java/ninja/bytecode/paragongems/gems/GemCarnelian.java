package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemCarnelian extends Gem
{
	public GemCarnelian()
	{
		super("carnelian", "Carnelean");
		setTemperatureRequirements(1.3f, 2f);
		setRainfallRequirements(0f, 0.5f);
		setOreHeightRange(24, 41);
	}
}
