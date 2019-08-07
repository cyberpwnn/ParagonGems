package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemDiopside extends Gem
{
	public GemDiopside()
	{
		super("diopside", "Diopside");
		setTemperatureRequirements(-0.5f, 2f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(121, 140);
	}
}
