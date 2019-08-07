package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemTourmaline extends Gem
{
	public GemTourmaline()
	{
		super("tourmaline", "Tourmaline");
		setTemperatureRequirements(1.9f, 2f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(67, 69);
	}
}
