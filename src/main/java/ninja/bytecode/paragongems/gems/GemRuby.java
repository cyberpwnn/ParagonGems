package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemRuby extends Gem
{
	public GemRuby()
	{
		super("ruby", "Ruby");
		setTemperatureRequirements(0.7f, 1.4f);
		setRainfallRequirements(0.2f, 0.8f);
		setOreHeightRange(1, 17);
	}
}
