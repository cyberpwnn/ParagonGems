package ninja.bytecode.paragongems.gems;

import ninja.bytecode.paragongems.modifiers.ModDecaying;
import ninja.bytecode.paragongems.modifiers.ModFlightRisk;
import ninja.bytecode.paragongems.util.Gem;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class GemCarnelian extends Gem
{
	public GemCarnelian()
	{
		super("carnelian", "Carnelean");
		setModifier(new ModDecaying().using(this));
	}
}
