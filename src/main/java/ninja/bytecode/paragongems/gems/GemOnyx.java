package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemOnyx extends Gem
{
	public GemOnyx()
	{
		super("onyx", "Onyx");
		setOreHeightRange(3, 21);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(-1f, 0.5f);
	}
}
