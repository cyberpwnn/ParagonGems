package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemRuby extends Gem
{
	public GemRuby()
	{
		super("ruby", "Ruby");
		setOreHeightRange(16, 26);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(-1f, 0.5f);
	}
}
