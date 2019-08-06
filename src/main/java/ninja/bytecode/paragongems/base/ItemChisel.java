package ninja.bytecode.paragongems.base;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldServer;
import ninja.bytecode.paragongems.common.ProxyCommon;
import ninja.bytecode.paragongems.util.IChisel;

public class ItemChisel extends Item
{
	private static final Random random = new Random();
	private IChisel chisel;

	public ItemChisel(IChisel chisel)
	{
		setUnlocalizedName(chisel.getID());
		setRegistryName(chisel.getID());
		this.chisel = chisel;
		setMaxStackSize(1);
		setMaxDamage(6 - chisel.getFortuneLevel());
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if(entityLiving instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP) entityLiving;

			if(player.getCooldownTracker().hasCooldown(this))
			{
				return false;
			}

			RayTraceResult rt = player.rayTrace(5, Minecraft.getMinecraft().getRenderPartialTicks());
			WorldServer world = player.getServerWorld();
			IBlockState state = world.getBlockState(rt.getBlockPos());
			Block hit = state.getBlock();
			player.getCooldownTracker().setCooldown(this, 9 - chisel.getFortuneLevel());

			if(hit instanceof BlockOre)
			{
				Item dropped = hit.getItemDropped(state, random, chisel.getFortuneLevel());
				int count = hit.quantityDropped(state, chisel.getFortuneLevel(), random) + random.nextInt(2);

				if(!(dropped instanceof ItemBlock))
				{
					System.out.println(stack.getItemDamage());

					if(stack.getItemDamage() == stack.getMaxDamage() - 1)
					{
						int xp = hit.getExpDrop(state, world, rt.getBlockPos(), chisel.getFortuneLevel());
						stack.setItemDamage(0);
						Vec3d vp = player.getPositionEyes(Minecraft.getMinecraft().getRenderPartialTicks());
						Vec3d vb = new Vec3d(rt.getBlockPos().getX(), rt.getBlockPos().getY(), rt.getBlockPos().getZ());
						Vec3d vs = vb.subtract(vp).normalize();
						world.setBlockState(rt.getBlockPos(), Blocks.STONE.getDefaultState());
						ItemStack is = new ItemStack(dropped, count);
						is.setItemDamage(hit.damageDropped(state));
						EntityItem item = new EntityItem(player.getEntityWorld(), rt.getBlockPos().getX() - vs.x, rt.getBlockPos().getY() - vs.y, rt.getBlockPos().getZ() - vs.z, is);
						world.playSound(null, rt.getBlockPos().getX(), rt.getBlockPos().getY(), rt.getBlockPos().getZ(), chisel.isMetal() ? ProxyCommon.getTingSound() : ProxyCommon.getHitSound(), SoundCategory.BLOCKS, 1f, (random.nextFloat() / 4f) + 0.9f);
						world.playSound(null, rt.getBlockPos().getX(), rt.getBlockPos().getY(), rt.getBlockPos().getZ(), ProxyCommon.getBreakSound(), SoundCategory.BLOCKS, 1f, (random.nextFloat() / 4f) + 0.9f);
						world.playSound(null, rt.getBlockPos().getX(), rt.getBlockPos().getY(), rt.getBlockPos().getZ(), ProxyCommon.getGemSound(), SoundCategory.BLOCKS, 1f, (random.nextFloat() / 4f) + 0.9f);
						player.getEntityWorld().spawnEntity(item);

						if(xp > 0)
						{
							player.getEntityWorld().spawnEntity(new EntityXPOrb(player.getEntityWorld(), rt.getBlockPos().getX() - vs.x, rt.getBlockPos().getY() - vs.y, rt.getBlockPos().getZ() - vs.z, xp));
						}
					}

					else
					{
						stack.setItemDamage(stack.getItemDamage() + 1);
						world.playSound(null, rt.getBlockPos().getX(), rt.getBlockPos().getY(), rt.getBlockPos().getZ(), chisel.isMetal() ? ProxyCommon.getTingSound() : ProxyCommon.getHitSound(), SoundCategory.BLOCKS, 1f, (random.nextFloat() / 4f) + 0.9f);
					}
				}
			}

			return true;
		}

		return false;
	}
}
