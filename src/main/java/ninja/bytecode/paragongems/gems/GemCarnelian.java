package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemCarnelian extends Gem
{
	public GemCarnelian()
	{
		super("carnelian", "Carnelean");
		setOreHeightRange(22, 52);
		setRainfallRequirements(0.25f, 1f);
		setTemperatureRequirements(0.3f, 1.5f);
	}
}
