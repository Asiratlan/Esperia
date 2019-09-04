package net.esperia.item;

import net.esperia.Esperia;
import net.esperia.block.BlockStandingSignEsperia;
import net.esperia.block.BlockWallSignEsperia;
import net.esperia.network.HRPSignEsperiaGuiPacket;
import net.esperia.network.StoneSignEsperiaGuiPacket;
import net.esperia.tileentity.TileEntityHRPSignEsperia;
import net.esperia.tileentity.TileEntityStoneSignEsperia;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemSignEsperia extends Item {

    private Material material;
    public String registryName;

    public ItemSignEsperia(String registryName, Material material) {
        this.registryName = registryName;
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.MISC);
        this.material = material;
    }

    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }

    
    //public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos,
      //      EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {}
    
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
    	
        IBlockState iblockstate = worldIn.getBlockState(pos);
        boolean flag = iblockstate.getBlock().isReplaceable(worldIn, pos);

        if (facing != EnumFacing.DOWN && (iblockstate.getMaterial().isSolid() || flag)
                && (!flag || facing == EnumFacing.UP)) {
            pos = pos.offset(facing);
            ItemStack itemstack = player.getHeldItem(hand);
            
            if (player.canPlayerEdit(pos, facing, itemstack)
                    && (net.esperia.BlocksRegistry.hrp_standing_sign.canPlaceBlockAt(worldIn, pos) || net.esperia.BlocksRegistry.stone_standing_sign.canPlaceBlockAt(worldIn, pos))) {
                if (worldIn.isRemote) {
                    return EnumActionResult.SUCCESS;
                } else {
                    pos = flag ? pos.down() : pos;

                    if (facing == EnumFacing.UP) {
                        int i = MathHelper
                                .floor((double) ((player.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
                        if (this.material == Material.ROCK) {
                            worldIn.setBlockState(pos, net.esperia.BlocksRegistry.stone_standing_sign.getDefaultState()
                                    .withProperty(BlockStandingSignEsperia.ROTATION, Integer.valueOf(i)), 11);
                        } else {
                            worldIn.setBlockState(pos, net.esperia.BlocksRegistry.hrp_standing_sign.getDefaultState()
                                    .withProperty(BlockStandingSignEsperia.ROTATION, Integer.valueOf(i)), 11);
                        }
                    } else {
                        if (this.material == Material.ROCK) {
                            worldIn.setBlockState(pos, net.esperia.BlocksRegistry.stone_wall_sign.getDefaultState()
                                    .withProperty(BlockWallSignEsperia.FACING, facing), 11);
                        } else {
                            worldIn.setBlockState(pos, net.esperia.BlocksRegistry.hrp_wall_sign.getDefaultState()
                                    .withProperty(BlockWallSignEsperia.FACING, facing), 11);
                        }
                    }

                    itemstack.shrink(1);
                    TileEntity tileentity = worldIn.getTileEntity(pos);

                    if (tileentity instanceof TileEntityHRPSignEsperia
                            && !ItemBlock.setTileEntityNBT(worldIn, player, pos, itemstack)) {
                        // playerIn.openEditSign((TileEntitySignEsperia)tileentity);
                        // playerIn.openGui(Esperia.instance(),
                        // GuiHandler.GUI_HRP_SIGN, worldIn, pos.getX(),
                        // pos.getY(), pos.getZ());
                        Esperia.network.sendTo(new HRPSignEsperiaGuiPacket((TileEntityHRPSignEsperia) tileentity),
                                (EntityPlayerMP) player);
                    } else if (tileentity instanceof TileEntityStoneSignEsperia
                            && !ItemBlock.setTileEntityNBT(worldIn, player, pos, itemstack)) {
                        // playerIn.openEditSign((TileEntitySignEsperia)tileentity);
                        // playerIn.openGui(Esperia.instance(),
                        // GuiHandler.GUI_HRP_SIGN, worldIn, pos.getX(),
                        // pos.getY(), pos.getZ());
                        Esperia.network.sendTo(new StoneSignEsperiaGuiPacket((TileEntityStoneSignEsperia) tileentity),
                                (EntityPlayerMP) player);
                    }

                    return EnumActionResult.SUCCESS;
                }
            } else {
                return EnumActionResult.FAIL;
            }
        } else {
            return EnumActionResult.FAIL;
        }
    }        
}
