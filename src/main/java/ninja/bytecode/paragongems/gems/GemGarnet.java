package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemGarnet extends Gem
{
	public GemGarnet()
	{
		super("garnet", "Garnet");
		setTemperatureRequirements(-0.5f, 0.5f);
		setRainfallRequirements(0.25f, 1f);
		setOreHeightRange(1, 21);
	}
}
