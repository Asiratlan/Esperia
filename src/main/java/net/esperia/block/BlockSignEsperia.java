package net.esperia.block;

import java.util.Random;

import net.esperia.Esperia;
import net.esperia.ItemsRegistry;
import net.esperia.tileentity.TileEntityHRPSignEsperia;
import net.esperia.tileentity.TileEntityStoneSignEsperia;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSignEsperia extends BlockContainer {

	protected static final AxisAlignedBB SIGN_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);

	private String registryName;

	public BlockSignEsperia(String registryName, Material material, SoundType sound) {
		super(material);
    	this.registryName = registryName;
		this.setRegistryName(Esperia.MOD_ID, registryName);
		this.setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		this.blockSoundType = sound;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SIGN_AABB;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks
	 * for render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/**
	 * Return true if an entity can be spawned inside the block (used to get the
	 * player's bed spawn location)
	 */
	public boolean canSpawnInBlock() {
		return true;
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub

		if (this.blockMaterial == Material.ROCK)
			return new TileEntityStoneSignEsperia();
		else
			return new TileEntityHRPSignEsperia();

	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(state.getBlock());
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		
			return new ItemStack(this.blockMaterial == Material.ROCK ? ItemsRegistry.sign_stone_item : ItemsRegistry.sign_hrp_item);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		//GuiEditHRPSignEsperia guiSign;
		if (worldIn.isRemote) {
			return true;
		} else {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			/*
			 * if (tileentity instanceof TileEntitySignEsperia) {
			 * playerIn.openGui(Esperia.instance(), GuiHandler.GUI_HRP_SIGN,
			 * worldIn, pos.getX(), pos.getY(), pos.getZ()); }
			 */

			return tileentity instanceof TileEntityHRPSignEsperia
					? ((TileEntityHRPSignEsperia) tileentity).executeCommand(playerIn) : (tileentity instanceof TileEntityStoneSignEsperia
							? ((TileEntityStoneSignEsperia) tileentity).executeCommand(playerIn) : false);
		}
	}

	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return !this.hasInvalidNeighbor(worldIn, pos) && super.canPlaceBlockAt(worldIn, pos);
	}
	
	/*@Override
	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, registryName);
	}

	@Override
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}*/

}
