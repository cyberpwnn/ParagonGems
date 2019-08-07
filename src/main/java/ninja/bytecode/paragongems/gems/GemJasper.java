package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemJasper extends Gem
{
	public GemJasper()
	{
		super("jasper", "Jasper");
		setTemperatureRequirements(-0.5f, 0.3f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(62, 75);
	}
}
