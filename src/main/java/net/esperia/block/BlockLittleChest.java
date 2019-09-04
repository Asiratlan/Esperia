package net.esperia.block;

import net.esperia.Esperia;
import net.esperia.tileentity.TileEntityLittleChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Caissette.
 *
 * @author Mc-Fr
 */
public class BlockLittleChest extends BlockContainer {
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	private static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.1, 0, 0.3, 0.9, 0.5, 1);
	private static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.1, 0, 0, 0.9, 0.5, 0.7);
	private static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.3, 0, 0.1, 1, 0.5, 0.9);
	private static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0, 0, 0.1, 0.7, 0.5, 0.9);

	public BlockLittleChest(String registryName, Material materialIn, SoundType sound) {
		super(materialIn);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		this.setSoundType(sound);
                 setHardness(2.0F);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (!(source.getBlockState(pos).getBlock() instanceof BlockLittleChest))
			return NULL_AABB;

		switch (source.getBlockState(pos).getValue(FACING)) {
		case NORTH:
			return AABB_NORTH;
		case EAST:
			return AABB_EAST;
		case SOUTH:
			return AABB_SOUTH;
		case WEST:
			return AABB_WEST;
		default:
			return state.getBoundingBox(source, pos);
		}
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(FACING, EnumFacing.Plane.HORIZONTAL.facings()[meta & 3]);
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
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityLittleChest();
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {

		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof IInventory) {
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}

		super.breakBlock(worldIn, pos, state);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote)
			return true;

		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof TileEntityLittleChest) {
			TileEntityLittleChest tileentitybiblio = (TileEntityLittleChest) tile;

			if (tileentitybiblio != null) {
				playerIn.openGui(Esperia.instance(), 7, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
		}

		return true;
	}

}
