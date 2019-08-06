package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemRuby extends Gem
{
	public GemRuby()
	{
		super("ruby", "Ruby");
		setRainfallRequirements(0f, 0.1f);
		setTemperatureRequirements(0.65f, 2f);
	}
}
