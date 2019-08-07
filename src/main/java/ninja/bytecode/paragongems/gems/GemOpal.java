package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemOpal extends Gem
{
	public GemOpal()
	{
		super("opal", "Opal");
		setTemperatureRequirements(1.8f, 2f);
		setRainfallRequirements(0f, 0.2f);
		setOreHeightRange(1, 55);
	}
}
