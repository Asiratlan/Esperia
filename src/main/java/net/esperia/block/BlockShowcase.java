package net.esperia.block;

import javax.annotation.Nullable;

import net.esperia.tileentity.TileEntityShowcase;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockShowcase extends BlockSimple {
	// basically a bunch of stuff uses these keys so might as well slap them
	// here
	public static final String KEY_ITEM = "ShowcaseItem";
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	private static final PropertyBool LEFT = PropertyBool.create("left");
	private static final PropertyBool RIGHT = PropertyBool.create("right");

	public BlockShowcase(String name) {
		super(name, Material.ROCK, SoundType.WOOD, 1f);
		setResistance(1f);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0, 0, 0, 1, 6 / 16d, 1);

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityShowcase();
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntity tile = world.getTileEntity(pos);
		if (tile instanceof TileEntityShowcase) {
			TileEntityShowcase showcase = (TileEntityShowcase) tile;

			if (player.getHeldItemMainhand().isEmpty()) {
				player.addItemStackToInventory(showcase.displayedStack.copy());
				showcase.displayedStack = ItemStack.EMPTY;
				IBlockState hahaYes = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, hahaYes, hahaYes, 2);
				showcase.markDirty();
				return true;
			} else if (showcase.displayedStack.isEmpty()) {
				showcase.displayedStack = player.getHeldItemMainhand().copy();
				showcase.displayedStack.setCount(1);
				if (!player.isCreative()) {
					player.getHeldItemMainhand().shrink(1);
				}
				IBlockState hahaYes = world.getBlockState(pos);
				world.notifyBlockUpdate(pos, hahaYes, hahaYes, 2);
				showcase.markDirty();
				return true;
			}
		}

		return false;
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntity tile = world.getTileEntity(pos);
		if (tile instanceof TileEntityShowcase) {
			spawnAsEntity(world, pos.east(), ((TileEntityShowcase) tile).displayedStack);
		}

		super.breakBlock(world, pos, state);
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}

	@Override
	public int getLightOpacity(IBlockState state) {
		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, LEFT, RIGHT });
	}

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
		return face == EnumFacing.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
			enumfacing = EnumFacing.NORTH;
		}

		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		IBlockState actualState = world.getBlockState(pos);
		switch (world.getBlockState(pos).getValue(FACING)) {
		case NORTH:
			actualState = actualState.withProperty(LEFT, world.getBlockState(pos.west()).getBlock() == this);
			actualState = actualState.withProperty(RIGHT, world.getBlockState(pos.east()).getBlock() == this);
			break;
		case SOUTH:
			actualState = actualState.withProperty(LEFT, world.getBlockState(pos.east()).getBlock() == this);
			actualState = actualState.withProperty(RIGHT, world.getBlockState(pos.west()).getBlock() == this);
			break;
		case WEST:
			actualState = actualState.withProperty(LEFT, world.getBlockState(pos.south()).getBlock() == this);
			actualState = actualState.withProperty(RIGHT, world.getBlockState(pos.north()).getBlock() == this);
			break;
		case EAST:
			actualState = actualState.withProperty(LEFT, world.getBlockState(pos.north()).getBlock() == this);
			actualState = actualState.withProperty(RIGHT, world.getBlockState(pos.south()).getBlock() == this);
			break;
		}
		return actualState;
	}
}
