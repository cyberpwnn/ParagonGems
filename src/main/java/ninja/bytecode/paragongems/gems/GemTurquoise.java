package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemTurquoise extends Gem
{
	public GemTurquoise()
	{
		super("turquoise", "Turquoise");
		setOreHeightRange(60, 90);
		setRainfallRequirements(0.7f, 1f);
		setTemperatureRequirements(0f, 2f);
	}
}
