package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.modifiers.ModRegenerative;
import ninja.bytecode.paragongems.util.Gem;

public class GemGarnet extends Gem
{
	public GemGarnet()
	{
		super("garnet", "Garnet");
		setModifier(new ModRegenerative().using(this));
		setOreHeightRange(42, 72);
		setRainfallRequirements(0f, 1f);
		setTemperatureRequirements(-1f, 0.5f);
	}
}
