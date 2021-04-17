package ninja.bytecode.paragongems.modifiers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.base.GemTinkerModifier;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.util.Random;

public class ModRegenerative extends GemTinkerModifier {
    private static Random random = new Random();
    public ModRegenerative() {
        super("regenerative", TextFormatting.GREEN, 5, 1);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(world.isRemote)
        {
            return;
        }

        if(random.nextInt(376 / (((getLevel(tool)-1) * 4) + 1)) == 0)
        {
            if(entity instanceof EntityPlayerMP)
            {
                EntityPlayerMP b = (EntityPlayerMP) entity;

                ItemStack t = b.inventory.getStackInSlot(itemSlot);

                if(t.getItem().equals(tool.getItem()))
                {
                    ToolHelper.healTool(t, 1, b);
                }
            }
        }
    }
}
