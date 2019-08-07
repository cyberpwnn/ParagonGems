package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemBeryl extends Gem
{
	public GemBeryl()
	{
		super("beryl", "Beryl");
		setTemperatureRequirements(0.6f, 1.2f);
		setRainfallRequirements(0f, 0.2f);
		setOreHeightRange(30, 50);
	}
}
