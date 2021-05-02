package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.modifiers.ModOrgan;
import ninja.bytecode.paragongems.util.Gem;

public class GemBloodstone extends Gem
{
	public GemBloodstone()
	{
		super("bloodstone", "Bloodstone");
		setModifier(new ModOrgan().using(this));
		setOreHeightRange(62, 99);
		setRainfallRequirements(0f, 0.1f);
		setTemperatureRequirements(0.5f, 1.5f);
	}
}
