package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.modifiers.ModShielded;
import ninja.bytecode.paragongems.util.Gem;

public class GemAmethyst extends Gem
{
	public GemAmethyst()
	{
		super("amethyst", "Amethyst");
		setModifier(new ModShielded().using(this));
	}
}
