package ninja.bytecode.paragongems.base;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.util.IGem;

public class BlockGemOre extends BlockOre
{
	private IGem gem;

	public BlockGemOre(IGem i)
	{
		super();
		gem = i;
		setUnlocalizedName("block_" + i.getID() + "_ore");
		setRegistryName("block_" + i.getID() + "_ore");
		setHardness(gem.getHardness());
		setResistance(gem.getResistance());
		setHarvestLevel("pickaxe", gem.getHarvestLevel());
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return gem.getGemItem();
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
	{
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		if(this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
		{
			return gem.dropXP(rand);
		}

		return 0;
	}
}
