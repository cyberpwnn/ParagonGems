package ninja.bytecode.paragongems.modifiers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.base.GemTinkerModifier;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.util.Random;

public class ModDamageInoculation extends GemTinkerModifier {
    private static Random random = new Random();

    public ModDamageInoculation() {
        super("damage-inoculation", TextFormatting.RED, 5, 48);
    }

    public void setDamage(ItemStack is, int points) {
        if (is.hasTagCompound()) {
            NBTTagCompound c = TinkerUtil.getModifierTag(is, getIdentifier());
            c.setInteger("pg-damage", points);
        }
    }

    public int getDamage(ItemStack is) {
        if (is.hasTagCompound()) {
            NBTTagCompound c = TinkerUtil.getModifierTag(is, getIdentifier());
            return c.getInteger("pg-damage");
        }

        return 0;
    }

    public void setUpdating(ItemStack is, boolean points) {
        if (is.hasTagCompound()) {
            NBTTagCompound c = TinkerUtil.getModifierTag(is, getIdentifier());
            c.setBoolean("pg-updating", points);
        }
    }

    public boolean isUpdating(ItemStack is) {
        if (is.hasTagCompound()) {
            NBTTagCompound c = TinkerUtil.getModifierTag(is, getIdentifier());
            return c.getBoolean("pg-updating");
        }

        return false;
    }

    @Override
    public String getTooltip(NBTTagCompound modifierTag, boolean detailed) {
        StringBuilder sb = new StringBuilder();

        ModifierNBT data = ModifierNBT.readTag(modifierTag);

        sb.append(getLocalizedName());
        if(data.level > 1) {
            sb.append(" ");
            sb.append(TinkerUtil.getRomanNumeral(data.level));
        }

        int d = modifierTag.getInteger("pg-damage");

        return sb.toString() + " (" + d  + ")";
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (world.isRemote) {
            return;
        }

        if (random.nextInt(336 / (((getLevel(tool) - 1) * 4) + 1)) == 0) {
            if (entity instanceof EntityPlayerMP) {
                EntityPlayerMP b = (EntityPlayerMP) entity;

                ItemStack t = b.inventory.getStackInSlot(itemSlot);

                if (t.getItem().equals(tool.getItem())) {
                    int d = getDamage(tool);
                    setUpdating(tool, true);
                    int amt = (int) ((3 * getLevel(tool)) + (d * 0.1));
                    if(d > amt)
                    {
                        ToolHelper.damageTool(t, amt, b);
                        d-=amt;
                    }

                    else if(d < -amt)
                    {
                        ToolHelper.healTool(t, amt, b);
                        d+=amt;
                    }

                    setUpdating(tool, false);
                    setDamage(tool, d);
                }
            }
        }
    }

    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        if (isUpdating(tool))
        {
            return newAmount;
        }

        setDamage(tool, getDamage(tool) + (newAmount * getLevel(tool)));
        return newAmount;
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        if (isUpdating(tool))
        {
            return newDamage;
        }

        setDamage(tool, getDamage(tool) - (newDamage * getLevel(tool)));
        return newDamage;
    }
}