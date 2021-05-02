package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemTopaz extends Gem
{
	public GemTopaz()
	{
		super("topaz", "Topaz");
		setOreHeightRange(52, 80);
		setRainfallRequirements(0.7f, 1f);
		setTemperatureRequirements(0.5f, 2f);
	}
}
