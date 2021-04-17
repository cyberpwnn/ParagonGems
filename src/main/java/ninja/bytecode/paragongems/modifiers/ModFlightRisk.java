package ninja.bytecode.paragongems.modifiers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.base.GemTinkerModifier;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModFlightRisk extends GemTinkerModifier {
    private static final String[] msgs = new String[]{
            "At last! I'm Free!",
            "LET ME GO!",
            "Peace... I'm out.",
            "Get your grubby hands off of me.",
            "That's it, I can't take this anymore!",
            "Get away from me!",
            "Quit touching me",
            "Pick me up, I fucking dare you.",
            "You're obsessed with me",
            "Stop touching me",
            "It's not you... It's me",
            "Ok... that time you dropped me."
    };
    private static final double percentPerLevel = 0.00036;

    public ModFlightRisk() {
        super("flight-risk", TextFormatting.DARK_RED, 5, 1);
    }

    public boolean canFlee(ItemStack tool) {
        return Math.random() < (getLevel(tool) * percentPerLevel);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        super.onUpdate(tool, world, entity, itemSlot, isSelected);

        if(isSelected)
        {
            if(entity instanceof EntityLivingBase)
            {
                if(canFlee(tool))
                {
                    flee(world, tool, (EntityLivingBase) entity);
                }
            }
        }
    }

    public void flee(World world, ItemStack item, EntityLivingBase player) {
        if(world.isRemote)
        {
            return;
        }

        player.sendMessage(new TextComponentString("<" + item.getDisplayName() + "> " + msgs[(int) ((msgs.length-1) * Math.random())]));
        player.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.AIR));
        EntityItem entityitem = new EntityItem(player.getEntityWorld(), player.posX, player.posY + 0.9, player.posZ, item);
        entityitem.setPickupDelay(60);
        entityitem.setGlowing(true);
        Vec3d v = player.getLookVec();
        entityitem.setVelocity(v.x, v.y, v.z);
        entityitem.setUniqueId(UUID.randomUUID());
        world.spawnEntity(entityitem);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase
            player, boolean wasEffective) {
        if (canFlee(tool)) {
            flee(world, tool, player);
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean
            wasCritical, boolean wasHit) {
        if (canFlee(tool)) {
            flee(player.world, tool, player);
        }
    }

}
