package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemAmethyst extends Gem
{
	public GemAmethyst()
	{
		super("amethyst", "Amethyst");
		setTemperatureRequirements(0.9f, 1.2f);
		setRainfallRequirements(0.75f, 1f);
		setOreHeightRange(1, 32);
	}
}
