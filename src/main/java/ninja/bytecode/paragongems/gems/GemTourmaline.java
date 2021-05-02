package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemTourmaline extends Gem
{
	public GemTourmaline()
	{
		super("tourmaline", "Tourmaline");
		setOreHeightRange(12, 32);
		setRainfallRequirements(0f, 0.1f);
		setTemperatureRequirements(0.5f, 2f);
	}
}
