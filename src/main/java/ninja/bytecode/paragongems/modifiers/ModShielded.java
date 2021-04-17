package ninja.bytecode.paragongems.modifiers;

import io.netty.util.internal.MathUtil;
import net.minecraft.client.audio.Sound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.base.GemTinkerModifier;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.tinkering.TinkersItem;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

import javax.annotation.Nullable;
import java.util.Random;

public class ModShielded extends GemTinkerModifier {
    private static final int shieldsPerLevel = 25;
    private static Random random = new Random();
    public ModShielded() {
        super("shielded", TextFormatting.BLUE, 5, 24);
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

        int shields = modifierTag.getInteger("pg-shield");
        int inhib = modifierTag.getInteger("pg-shield-inhibitor");

        if(shields <= 0)
        {
            return sb.toString() + " (Broken)";
        }

        if(shields >=(data.level * shieldsPerLevel))
        {
            return sb.toString() + " (Full)";
        }

        return sb.toString() + " (" + shields + " / " + (data.level * shieldsPerLevel) + ")";
    }

    public void setShield(ItemStack is, int points)
    {
        if(is.hasTagCompound())
        {
            NBTTagCompound c = TinkerUtil.getModifierTag(is, getIdentifier());
            c.setInteger("pg-shield", Math.min(Math.max(0, points), getLevel(is) * shieldsPerLevel));
        }
    }

    public int getShield(ItemStack is)
    {
        if(is.hasTagCompound())
        {
            NBTTagCompound c = TinkerUtil.getModifierTag(is, getIdentifier());
            return c.getInteger("pg-shield");
        }

        return 0;
    }

    public void setShieldInhibitor(ItemStack is, int points)
    {
        if(is.hasTagCompound())
        {
            NBTTagCompound c = TinkerUtil.getModifierTag(is, getIdentifier());
            c.setInteger("pg-shield-inhibitor", Math.min(Math.max(0, points), 30 - ( getLevel(is) * 4)));
        }
    }

    public int getShieldInhibitor(ItemStack is)
    {
        if(is.hasTagCompound())
        {
            NBTTagCompound c = TinkerUtil.getModifierTag(is, getIdentifier());
            return c.getInteger("pg-shield-inhibitor");
        }

        return 0;
    }

    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        float hp = Math.abs(newAmount);

        int shield = getShield(tool);
        int max = getLevel(tool) * shieldsPerLevel;
        int to = max - shield;

        if(hp > to)
        {
            entity.sendMessage(new TextComponentString("Shield Healed from tool to max "));
            return (int) (hp - to);
        }

        else
        {
            setShield(tool, (int) (shield + hp));
            entity.sendMessage(new TextComponentString("Shield Healed from tool by " + (shield+hp)));
        }

        return 0;
    }

    @Override
    public int onToolDamage(ItemStack tool, int damage, int newDamage, EntityLivingBase entity) {
        int shield = getShield(tool);
        int shieldDamage = shield - Math.max(shield - newDamage, 0);
        if(shieldDamage > 0)
        {
            setShield(tool, getShield(tool) - shieldDamage);
        }

        setShieldInhibitor(tool, getShieldInhibitor(tool) + 3);
        return newDamage - shieldDamage;
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(world.isRemote)
        {
            return;
        }

        if(entity instanceof EntityPlayerMP && random.nextDouble() < 0.03 + (getLevel(tool) * 0.0135))
        {
            EntityPlayerMP b = (EntityPlayerMP) entity;
            ItemStack t = b.inventory.getStackInSlot(itemSlot);

            if(t.getItemDamage() <= 0)
            {
                t.setItemDamage(1);
            }

            int sh = getShield(t);
            int inh = getShieldInhibitor(t);

            if(inh > 0)
            {
                setShieldInhibitor(t, inh - 1);
            }

            if(inh <= 0)
            {
                setShield(t, sh + 1);
            }
        }
    }
}
