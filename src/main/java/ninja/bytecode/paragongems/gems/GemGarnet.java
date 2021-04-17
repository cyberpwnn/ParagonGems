package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.modifiers.ModRegenerative;
import ninja.bytecode.paragongems.util.Gem;

public class GemGarnet extends Gem
{
	public GemGarnet()
	{
		super("garnet", "Garnet");
		setModifier(new ModRegenerative().using(this));
	}
}
