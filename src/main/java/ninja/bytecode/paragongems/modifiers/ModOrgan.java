package ninja.bytecode.paragongems.modifiers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.base.GemTinkerModifier;

import java.util.Random;

public class ModOrgan extends GemTinkerModifier {
    private static final float duraPerHpPerLevel = 5f;
    public ModOrgan() {
        super("organ", TextFormatting.DARK_AQUA, 5, 12);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        super.onUpdate(tool, world, entity, itemSlot, isSelected);
        tool.setItemDamage(1);
    }

        @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if(newDamage <= 0)
        {
           return newDamage;
        }

        float hp = newDamage / duraPerHpPerLevel;
        entity.attackEntityFrom(DamageSource.GENERIC, hp);
        return 0;
    }

    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        float hp = Math.abs(newAmount / duraPerHpPerLevel);
        entity.heal(hp);
        entity.sendMessage(new TextComponentString("you healed for " + hp + " because " + tool.getDisplayName() + " was healed (organ)"));
        return 0;
    }
}
