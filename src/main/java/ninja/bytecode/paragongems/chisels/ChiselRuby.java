package ninja.bytecode.paragongems.chisels;

import ninja.bytecode.paragongems.util.Chisel;

public class ChiselRuby extends Chisel
{
	public ChiselRuby()
	{
		super("chisel_ruby", "Ruby Tipped Chisel");
		setFortuneLevel(3);
		setMetal(true);
		setTickMod(3);
		setDescription("This chisel is tipped with Ruby. Find more material per ore block.");
		setEfficiencyMod(7);
		setModification(true);
	}
}
