package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.modifiers.ModDomination;
import ninja.bytecode.paragongems.util.Gem;

public class GemOnyx extends Gem
{
	public GemOnyx()
	{
		super("onyx", "Onyx");
		setModifier(new ModDomination().using(this));
	}
}
