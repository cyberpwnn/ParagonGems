package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemOnyx extends Gem
{
	public GemOnyx()
	{
		super("onyx", "Onyx");
		setTemperatureRequirements(0.8f, 2f);
		setRainfallRequirements(0.75f, 1f);
		setOreHeightRange(55, 90);
	}
}
