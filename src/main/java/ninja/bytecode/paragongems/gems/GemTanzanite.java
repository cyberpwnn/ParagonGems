package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemTanzanite extends Gem
{
	public GemTanzanite()
	{
		super("tanzanite", "Tanzanite");
		setTemperatureRequirements(1.9f, 2f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(65, 72);
	}
}
