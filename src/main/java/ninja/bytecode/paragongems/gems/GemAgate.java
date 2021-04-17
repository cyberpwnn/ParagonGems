package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.modifiers.ModFlightRisk;
import ninja.bytecode.paragongems.util.Gem;

public class GemAgate extends Gem
{
	public GemAgate()
	{
		super("agate", "Agate");
		setModifier(new ModFlightRisk().using(this));
	}
}
