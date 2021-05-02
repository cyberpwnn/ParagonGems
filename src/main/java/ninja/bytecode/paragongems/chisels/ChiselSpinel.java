package ninja.bytecode.paragongems.chisels;

import ninja.bytecode.paragongems.gems.GemRuby;
import ninja.bytecode.paragongems.gems.GemSpinel;
import ninja.bytecode.paragongems.util.Chisel;

public class ChiselSpinel extends Chisel
{
	public ChiselSpinel()
	{
		super("chisel_spinel", "Spinel Tipped Chisel");
		setFortuneLevel(1);
		setMetal(true);
		setTickMod(-4);
		setDescription("This chisel is tipped with Spinel. Get material out of ores quickly.");
		setEfficiencyMod(-3);
		setModification(true);
		setTip(new GemSpinel());
	}
}
