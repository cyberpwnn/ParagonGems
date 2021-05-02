package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemZircon extends Gem
{
	public GemZircon()
	{
		super("zircon", "Zircon");
		setOreHeightRange(16, 52);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(-1f, 2f);
	}
}
