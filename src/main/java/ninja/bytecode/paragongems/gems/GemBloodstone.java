package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.modifiers.ModOrgan;
import ninja.bytecode.paragongems.util.Gem;

public class GemBloodstone extends Gem
{
	public GemBloodstone()
	{
		super("bloodstone", "Bloodstone");
		setModifier(new ModOrgan().using(this));
	}
}
