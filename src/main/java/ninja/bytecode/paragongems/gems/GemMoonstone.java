package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemMoonstone extends Gem
{
	public GemMoonstone()
	{
		super("moonstone", "Moonstone");
		setOreHeightRange(78, 122);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(-1f, 0f);
	}
}
