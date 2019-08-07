package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemZircon extends Gem
{
	public GemZircon()
	{
		super("zircon", "Zircon");
		setTemperatureRequirements(-0.1f, 1.5f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(18, 31);
	}
}
