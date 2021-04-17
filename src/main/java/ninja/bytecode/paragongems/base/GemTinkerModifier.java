package ninja.bytecode.paragongems.base;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextFormatting;
import ninja.bytecode.paragongems.util.IGem;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierNBT;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class GemTinkerModifier extends ModifierTrait {
    public int count;
    public IGem gem;
    public GemTinkerModifier(String id, TextFormatting color, int maxLevel, int countPerLevel) {
        super("pg-" + id, Util.enumChatFormattingToColor(color), maxLevel, countPerLevel);
    }

    public GemTinkerModifier using(IGem gem, int count)
    {
        this.count = count;
        this.gem = gem;
        return this;
    }

    public GemTinkerModifier using(IGem gem)
    {
        return using(gem, 1);
    }

    public int getLevel(ItemStack item) {
        if (item.isEmpty()) {
            return 0;
        }

        NBTTagCompound tag = TinkerUtil.getModifierTag(item, getIdentifier());
        int level = ModifierNBT.readTag(tag).level;

        if(level == 0) {
            tag = TinkerUtil.getModifierTag(item, getIdentifier());
            level = ModifierNBT.readTag(tag).level;
        }

        return level;
    }
}