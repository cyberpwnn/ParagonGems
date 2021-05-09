package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemAmethyst extends Gem
{
	public GemAmethyst()
	{
		super("amethyst", "Amethyst");
		setOreHeightRange(48, 92);
		setRainfallRequirements(0.25f, 1f);
		setTemperatureRequirements(-1f, 0.5f);
	}
}
