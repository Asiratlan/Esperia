package net.esperia.block;

import net.esperia.BlocksRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Feu de camp (éteint).
 *
 * @author Mc-Fr
 */
public class BlockCampfire extends BlockCampfireBase {

    public BlockCampfire() {
        super(false);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
            EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = playerIn.getHeldItem(hand);
        if (heldItem == null) {
            heldItem = playerIn.getHeldItem(EnumHand.OFF_HAND);
        }

        if (heldItem != null) {
            if (heldItem.getItem() == Items.COAL) {
                replaceByLitFirecamp(worldIn, pos, BlockLitCampFire.MAX_STAGE);
                heldItem.shrink(1);

                return true;
            } else if (heldItem.getItem() == Items.FLINT_AND_STEEL) {
                replaceByLitFirecamp(worldIn, pos, BlockLitCampFire.MAX_STAGE);
                heldItem.damageItem(1, playerIn);

                return true;
            } else if (heldItem.getItem() == Items.STICK) {
                replaceByLitFirecamp(worldIn, pos, 0);
                heldItem.shrink(1);

                return true;
            }
        }

        return false;
    }

    /**
     * Remplace ce bloc par un feu de camp allumé.
     *
     * @param world le monde
     * @param pos la position
     * @param meta le metadata
     */
    private void replaceByLitFirecamp(World world, BlockPos pos, int meta) {
        world.setBlockState(pos, BlocksRegistry.lit_campfire.getDefaultState().withProperty(BlockLitCampFire.STAGE, meta));
    }
}
