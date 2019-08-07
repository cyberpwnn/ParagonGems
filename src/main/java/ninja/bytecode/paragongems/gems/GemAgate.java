package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemAgate extends Gem
{
	public GemAgate()
	{
		super("agate", "Agate");
		setTemperatureRequirements(1.7f, 2f);
		setRainfallRequirements(0f, 0.2f);
		setOreHeightRange(43, 70);
	}
}
