package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemGourd extends ItemSimple {

    public ItemGourd(String registryName) {
        super(registryName);
    }

    @Override
    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);
        ItemStack itemStackIn = playerIn.getHeldItem(hand);
        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemStackIn, raytraceresult);
        if (ret != null) {
            return ret;
        }

        if (raytraceresult == null) {
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        } else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK) {
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        } else {
            BlockPos blockpos = raytraceresult.getBlockPos();

            if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
                return new ActionResult(EnumActionResult.FAIL, itemStackIn);
            } else if (true) {
                if (!playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemStackIn)) {
                    return new ActionResult(EnumActionResult.FAIL, itemStackIn);
                } else {
                    IBlockState iblockstate = worldIn.getBlockState(blockpos);
                    Material material = iblockstate.getMaterial();

                    if (material == Material.WATER && ((Integer) iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0) {
                        playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                        return new ActionResult(EnumActionResult.SUCCESS, this.fillBucket(itemStackIn, playerIn, net.esperia.ItemsRegistry.gourd));
                    } else {
                        return new ActionResult(EnumActionResult.FAIL, itemStackIn);
                    }
                }
            }
        }

        return new ActionResult(EnumActionResult.FAIL, itemStackIn);
    }

    private ItemStack fillBucket(ItemStack emptyBuckets, EntityPlayer player, Item fullBucket) {
        if (player.capabilities.isCreativeMode) {
            return emptyBuckets;
        } else {
            emptyBuckets.shrink(1);

            if (emptyBuckets.isEmpty()) {
                return new ItemStack(fullBucket);
            } else {
                if (!player.inventory.addItemStackToInventory(new ItemStack(fullBucket))) {
                    player.dropItem(new ItemStack(fullBucket), false);
                }

                return emptyBuckets;
            }
        }
    }
}
