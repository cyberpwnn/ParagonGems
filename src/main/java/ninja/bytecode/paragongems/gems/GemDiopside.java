package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemDiopside extends Gem
{
	public GemDiopside()
	{
		super("diopside", "Diopside");
		setOreHeightRange(6, 35);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(0f, 0.75f);
	}
}
