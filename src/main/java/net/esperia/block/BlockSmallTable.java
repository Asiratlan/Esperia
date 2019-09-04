package net.esperia.block;

import net.esperia.Esperia;
import net.esperia.tileentity.TileEntityFurniture;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
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

public class BlockSmallTable extends BlockContainer {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	private static final PropertyBool WALL = PropertyBool.create("wall");

	public BlockSmallTable(String registryName, Material materialIn, SoundType sound) {
		super(materialIn);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		this.setSoundType(sound);
                 setHardness(2.0F);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(WALL, false));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.SOLID;
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof IInventory) {
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote)
			return true;

		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof TileEntityFurniture) {
			TileEntityFurniture tileentitybiblio = (TileEntityFurniture) tile;

			if (tileentitybiblio != null) {
				playerIn.openGui(Esperia.instance(), 6, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
		}

		return true;
	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, WALL });
	}

	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		IBlockState actualState = world.getBlockState(pos);
		switch (world.getBlockState(pos).getValue(FACING)) {
		case NORTH:
			actualState = actualState.withProperty(WALL, world.getBlockState(pos.south()).isFullBlock());
			break;
		case SOUTH:
			actualState = actualState.withProperty(WALL, world.getBlockState(pos.north()).isFullBlock());
			break;
		case WEST:
			actualState = actualState.withProperty(WALL, world.getBlockState(pos.east()).isFullBlock());
			break;
		case EAST:
			actualState = actualState.withProperty(WALL, world.getBlockState(pos.west()).isFullBlock());
			break;
		}
		return actualState;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		TileEntityFurniture te = new TileEntityFurniture();
		te.setCustomName("Table de Chevet");
		return te;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		float xtrans = 0F;
		float ztrans = 0F;

        //state = this.getActualState(state, source, pos);

		if (state.getValue(WALL)) {
			switch (state.getValue(FACING)) {
			case NORTH:
				ztrans += 0.15F;
				break;
			case SOUTH:
				ztrans -= 0.15F;
				break;
			case WEST:
				xtrans += 0.15F;
				break;
			case EAST:
				xtrans -= 0.15F;
				break;
			}
			return new AxisAlignedBB(0.875F + xtrans, 0.575F, 0.875F + ztrans, 0.125F + xtrans, 0F, 0.125F + ztrans);
		}
		else {
			return new AxisAlignedBB(0.875F, 0.575F, 0.875F , 0.125F , 0F, 0.125F );

		}
	}

}
