package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemTanzanite extends Gem
{
	public GemTanzanite()
	{
		super("tanzanite", "Tanzanite");
		setOreHeightRange(24, 80);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(0.5f, 2f);
	}
}
