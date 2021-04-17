package ninja.bytecode.paragongems.modifiers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import ninja.bytecode.paragongems.base.GemTinkerModifier;
import slimeknights.tconstruct.library.tools.TinkerToolCore;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.shared.TinkerCommons;
import slimeknights.tconstruct.tools.TinkerTools;

import java.util.Random;
import java.util.UUID;

public class ModDecaying extends GemTinkerModifier {
    private static Random random = new Random();
    public ModDecaying() {
        super("decaying", TextFormatting.DARK_RED, 5, 1);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if(world.isRemote)
        {
            return;
        }

        if(random.nextInt(128 / (((getLevel(tool)-1) * 4) + 1)) == 0)
        {
            if(entity instanceof EntityPlayerMP)
            {
                EntityPlayerMP b = (EntityPlayerMP) entity;

                ItemStack t = b.inventory.getStackInSlot(itemSlot);

                if(t.getItem().equals(tool.getItem()))
                {
                    ToolHelper.damageTool(t, 1, b);
                }
            }
        }
    }
}
