package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemJasper extends Gem
{
	public GemJasper()
	{
		super("jasper", "Jasper");
		setOreHeightRange(22, 92);
		setRainfallRequirements(0f, 0.5f);
		setTemperatureRequirements(0.5f, 2f);
	}
}
