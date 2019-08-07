package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemTurquoise extends Gem
{
	public GemTurquoise()
	{
		super("turquoise", "Turquoise");
		setTemperatureRequirements(-0.5f, 0f);
		setRainfallRequirements(0f, 0.2f);
		setOreHeightRange(38, 91);
	}
}
