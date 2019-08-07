package ninja.bytecode.paragongems.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import ninja.bytecode.paragongems.util.IGem;

public class BlockGem extends Block
{
	private IGem gem;

	public BlockGem(IGem i)
	{
		super(Material.IRON);
		gem = i;
		setUnlocalizedName("block_" + i.getID());
		setRegistryName("block_" + i.getID());
		setHardness(gem.getHardness() + 2F);
		setResistance(gem.getResistance() + 5F);
		setHarvestLevel("pickaxe", gem.getHarvestLevel());
		setSoundType(SoundType.METAL);
	}

	public IGem getGem()
	{
		return gem;
	}
}
