package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemSpinel extends Gem
{
	public GemSpinel()
	{
		super("spinel", "Spinel");
		setOreHeightRange(42, 69);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(0.5f, 2f);
	}
}
