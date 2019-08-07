package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemSpinel extends Gem
{
	public GemSpinel()
	{
		super("spinel", "Spinel");
		setTemperatureRequirements(-0.5f, -2f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(40, 100);
		setOregenDimension(1);
	}
}
