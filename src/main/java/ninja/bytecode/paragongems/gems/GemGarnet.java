package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.util.Gem;

public class GemGarnet extends Gem
{
	public GemGarnet()
	{
		super("garnet", "Garnet");
		setOreHeightRange(42, 72);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(-1f, 0.5f);
	}
}
