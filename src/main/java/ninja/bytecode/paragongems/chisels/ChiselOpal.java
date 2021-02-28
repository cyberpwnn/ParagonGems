package ninja.bytecode.paragongems.chisels;

import ninja.bytecode.paragongems.util.Chisel;

public class ChiselOpal extends Chisel
{
	public ChiselOpal()
	{
		super("chisel_opal", "Opal Tipped Chisel");
		setFortuneLevel(7);
		setMetal(true);
		setTickMod(8);
		setDescription("This chisel is tipped with Opal. Find more material per ore block very quickly.");
		setEfficiencyMod(1);
		setModification(true);
	}
}
