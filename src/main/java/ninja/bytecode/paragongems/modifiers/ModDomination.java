package ninja.bytecode.paragongems.modifiers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.base.GemTinkerModifier;

import java.util.UUID;

public class ModDomination extends GemTinkerModifier {
    private static final double percentPerLevel = 0.25;

    public ModDomination() {
        super("domination", TextFormatting.YELLOW, 5, 10);
    }

    public boolean canFlee(ItemStack tool) {
        return Math.random() < (getLevel(tool) * percentPerLevel);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean
            wasCritical, boolean wasHit) {
        if(wasCritical && wasHit)
        {
            int l = getLevel(tool);
            float extraDamage = (float) (damage * (l * percentPerLevel));
            target.attackEntityFrom(DamageSource.GENERIC, extraDamage);
            target.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 1f, 1.4f);
        }
    }

}
