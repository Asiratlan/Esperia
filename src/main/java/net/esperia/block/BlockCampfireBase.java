package net.esperia.block;

import java.util.Random;

import net.esperia.Esperia;
import net.esperia.item.ItemBlockSpecial;
import net.esperia.tileentity.TileEntityCampfire;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Bloc de base des feux de camp.
 *
 * @author Mc-Fr
 */
abstract class BlockCampfireBase extends BlockSimple implements ITileEntityProvider {

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 0.1D, 0.8D);

    /**
     * Crée un feu de camp.
     *
     * @param isBurning allumé ou éteint
     */
    public BlockCampfireBase(boolean isBurning) {
        super((isBurning ? "lit_" : "") + "campfire", Material.WOOD, SoundType.WOOD, 1);
        setCreativeTab(null);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
    }
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
         return AABB;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCampfire();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setTileEntity(pos, createNewTileEntity(worldIn, stack.getMetadata()));
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this, 1, getMetaFromState(state));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return null;
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return getItem(world, pos, state);
    }

    @Override
    public void registerItemModel(Item itemBlock) {
        Esperia.proxy.registerItemRenderer(itemBlock, 0, this.getRegistryName().getResourcePath());
    }

    @Override
    public Item createItemBlock() {
        return new ItemBlockSpecial(this.getRegistryName().getResourcePath(), this, CreativeTabs.DECORATIONS);
    }
    
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
