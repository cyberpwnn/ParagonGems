package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemMoonstone extends Gem
{
	public GemMoonstone()
	{
		super("moonstone", "Moonstone");
		setTemperatureRequirements(-0.5f, 1f);
		setRainfallRequirements(0f, 1f);
		setOreHeightRange(155, 254);
	}
}
