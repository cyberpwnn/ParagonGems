package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemTopaz extends Gem
{
	public GemTopaz()
	{
		super("topaz", "Topaz");
		setTemperatureRequirements(-0.5f, 0.8f);
		setRainfallRequirements(0f, 0.3f);
		setOreHeightRange(39, 57);
	}
}
