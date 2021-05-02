package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemOpal extends Gem
{
	public GemOpal()
	{
		super("opal", "Opal");
		setOreHeightRange(72, 122);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(0.5f, 2f);
	}
}
