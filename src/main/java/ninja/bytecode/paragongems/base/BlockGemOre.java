package ninja.bytecode.paragongems.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import ninja.bytecode.paragongems.common.ProxyCommon;
import ninja.bytecode.paragongems.util.Gem;
import ninja.bytecode.paragongems.util.IGem;

public class BlockGemOre extends BlockOre
{

	public BlockGemOre(IGem i)
	{
		super();
		setUnlocalizedName("block_" + i.getID() + "_ore");
		setRegistryName("block_" + i.getID() + "_ore");
	}

}
