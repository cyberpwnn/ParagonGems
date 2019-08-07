package ninja.bytecode.paragongems.chisels;

import ninja.bytecode.paragongems.util.Chisel;

public class ChiselSpinel extends Chisel
{
	public ChiselSpinel()
	{
		super("chisel_spinel", "Spinel Tipped Chisel");
		setFortuneLevel(1);
		setMetal(true);
		setTickMod(-5);
		setEfficiencyMod(-3);
	}
}