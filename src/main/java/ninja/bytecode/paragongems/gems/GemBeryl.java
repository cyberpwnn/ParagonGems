package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemBeryl extends Gem
{
	public GemBeryl()
	{
		super("beryl", "Beryl");
		setOreHeightRange(48, 79);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(-0.5f, 0.5f);
	}
}
