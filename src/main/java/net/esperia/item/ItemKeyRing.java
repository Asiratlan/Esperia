package net.esperia.item;

import java.util.List;

import javax.annotation.Nullable;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKeyRing extends ItemContainer {

    public ItemKeyRing(String registryName, int size) {
        super(registryName, size);
        this.setCreativeTab(null);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        int nbCles = 0;
        if (stack.hasTagCompound()) {
            nbCles = stack.getTagCompound().getTagList("Inventory", Constants.NBT.TAG_COMPOUND).tagCount();
        }

        if (nbCles > 0) {
            String pluriel = (nbCles > 1) ? "s" : "";
            tooltip.add("Contient " + nbCles + " clef" + pluriel);
        }
    }
    
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side,
            float hitX, float hitY, float hitZ, EnumHand hand) {

        Block block = worldIn.getBlockState(pos).getBlock();
        ItemStack stack = playerIn.getHeldItem(hand);
        if (!playerIn.isSneaking() && block instanceof BlockDoor || block instanceof BlockTrapDoor) {
            if (stack.hasTagCompound()) {
                NBTTagList inv = stack.getTagCompound().getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
                if (inv.tagCount() > 0) {
                    for (int i = 0; i < inv.tagCount(); i++) {
                        NBTTagCompound comp1 = inv.getCompoundTagAt(i);
                        ItemStack cle = new ItemStack(comp1); // a = loadFromNBT...
                        if (ItemKey.unlockDoor(worldIn, pos, playerIn, block, cle) == EnumActionResult.PASS) {
                            return EnumActionResult.FAIL;
                        }
                    }
                }
            }
        }
        else {
    		playerIn.openGui(Esperia.instance(), size, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
            return EnumActionResult.PASS;
        }
        return EnumActionResult.PASS;
    }
    
    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelResourceLocation emptyModel = new ModelResourceLocation(Esperia.MOD_ID + ":keychain_empty", "inventory");
        ModelResourceLocation filledModel = new ModelResourceLocation(Esperia.MOD_ID + ":keychain", "inventory");

        ModelBakery.registerItemVariants(this, emptyModel, filledModel);

        ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                if (haveKeys(stack)) {
                    return filledModel;
                } else {
                    return emptyModel;
                }
            }
        });
    }
    
    private boolean haveKeys(ItemStack stack) {
        if (stack.hasTagCompound()){
            NBTTagList inv = stack.getTagCompound().getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
            return inv.tagCount() > 0;
        }
        return false;
    }
    
    @Override
    public void registerItemModel() {
    	initModel();
    }

}
