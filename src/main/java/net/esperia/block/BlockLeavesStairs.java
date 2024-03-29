package net.esperia.block;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLeavesStairs extends Block {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyEnum<EnumHalf> HALF = PropertyEnum.<EnumHalf>create("half", EnumHalf.class);
	public static final PropertyEnum<EnumShape> SHAPE = PropertyEnum.<EnumShape>create("shape", EnumShape.class);
	/**
	 * B: .. T: xx B: .. T: xx
	 */
	protected static final AxisAlignedBB AABB_SLAB_TOP = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	/**
	 * B: .. T: x. B: .. T: x.
	 */
	protected static final AxisAlignedBB AABB_QTR_TOP_WEST = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 1.0D);
	/**
	 * B: .. T: .x B: .. T: .x
	 */
	protected static final AxisAlignedBB AABB_QTR_TOP_EAST = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);
	/**
	 * B: .. T: xx B: .. T: ..
	 */
	protected static final AxisAlignedBB AABB_QTR_TOP_NORTH = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	/**
	 * B: .. T: .. B: .. T: xx
	 */
	protected static final AxisAlignedBB AABB_QTR_TOP_SOUTH = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	/**
	 * B: .. T: x. B: .. T: ..
	 */
	protected static final AxisAlignedBB AABB_OCT_TOP_NW = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 0.5D, 1.0D, 0.5D);
	/**
	 * B: .. T: .x B: .. T: ..
	 */
	protected static final AxisAlignedBB AABB_OCT_TOP_NE = new AxisAlignedBB(0.5D, 0.5D, 0.0D, 1.0D, 1.0D, 0.5D);
	/**
	 * B: .. T: .. B: .. T: x.
	 */
	protected static final AxisAlignedBB AABB_OCT_TOP_SW = new AxisAlignedBB(0.0D, 0.5D, 0.5D, 0.5D, 1.0D, 1.0D);
	/**
	 * B: .. T: .. B: .. T: .x
	 */
	protected static final AxisAlignedBB AABB_OCT_TOP_SE = new AxisAlignedBB(0.5D, 0.5D, 0.5D, 1.0D, 1.0D, 1.0D);
	/**
	 * B: xx T: .. B: xx T: ..
	 */
	protected static final AxisAlignedBB AABB_SLAB_BOTTOM = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	/**
	 * B: x. T: .. B: x. T: ..
	 */
	protected static final AxisAlignedBB AABB_QTR_BOT_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 1.0D);
	/**
	 * B: .x T: .. B: .x T: ..
	 */
	protected static final AxisAlignedBB AABB_QTR_BOT_EAST = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	/**
	 * B: xx T: .. B: .. T: ..
	 */
	protected static final AxisAlignedBB AABB_QTR_BOT_NORTH = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	/**
	 * B: .. T: .. B: xx T: ..
	 */
	protected static final AxisAlignedBB AABB_QTR_BOT_SOUTH = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);
	/**
	 * B: x. T: .. B: .. T: ..
	 */
	protected static final AxisAlignedBB AABB_OCT_BOT_NW = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.5D, 0.5D, 0.5D);
	/**
	 * B: .x T: .. B: .. T: ..
	 */
	protected static final AxisAlignedBB AABB_OCT_BOT_NE = new AxisAlignedBB(0.5D, 0.0D, 0.0D, 1.0D, 0.5D, 0.5D);
	/**
	 * B: .. T: .. B: x. T: ..
	 */
	protected static final AxisAlignedBB AABB_OCT_BOT_SW = new AxisAlignedBB(0.0D, 0.0D, 0.5D, 0.5D, 0.5D, 1.0D);
	/**
	 * B: .. T: .. B: .x T: ..
	 */
	protected static final AxisAlignedBB AABB_OCT_BOT_SE = new AxisAlignedBB(0.5D, 0.0D, 0.5D, 1.0D, 0.5D, 1.0D);

	public BlockLeavesStairs(String registryName) {
		super(Material.WOOD);
		this.setRegistryName(new ResourceLocation(Esperia.MOD_ID, registryName));
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setSoundType(SoundType.PLANT);
		this.setResistance(1.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(HALF, EnumHalf.BOTTOM).withProperty(SHAPE, EnumShape.STRAIGHT));
	}

	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
		if (!isActualState) {
			state = this.getActualState(state, worldIn, pos);
		}

		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(state)) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, axisalignedbb);
		}
	}

	private static List<AxisAlignedBB> getCollisionBoxList(IBlockState bstate) {
		List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
		boolean flag = bstate.getValue(HALF) == EnumHalf.TOP;
		list.add(flag ? AABB_SLAB_TOP : AABB_SLAB_BOTTOM);
		EnumShape blockstairs$enumshape = (EnumShape) bstate.getValue(SHAPE);

		if (blockstairs$enumshape == EnumShape.STRAIGHT || blockstairs$enumshape == EnumShape.INNER_LEFT || blockstairs$enumshape == EnumShape.INNER_RIGHT) {
			list.add(getCollQuarterBlock(bstate));
		}

		if (blockstairs$enumshape != EnumShape.STRAIGHT) {
			list.add(getCollEighthBlock(bstate));
		}

		return list;
	}

	/**
	 * Returns a bounding box representing a quarter of a block (two eight-size
	 * cubes back to back). Used in all stair shapes except OUTER.
	 */
	private static AxisAlignedBB getCollQuarterBlock(IBlockState bstate) {
		boolean flag = bstate.getValue(HALF) == EnumHalf.TOP;

		switch ((EnumFacing) bstate.getValue(FACING)) {
		case NORTH:
		default:
			return flag ? AABB_QTR_BOT_NORTH : AABB_QTR_TOP_NORTH;
		case SOUTH:
			return flag ? AABB_QTR_BOT_SOUTH : AABB_QTR_TOP_SOUTH;
		case WEST:
			return flag ? AABB_QTR_BOT_WEST : AABB_QTR_TOP_WEST;
		case EAST:
			return flag ? AABB_QTR_BOT_EAST : AABB_QTR_TOP_EAST;
		}
	}

	/**
	 * Returns a bounding box representing an eighth of a block (a block whose
	 * three dimensions are halved). Used in all stair shapes except STRAIGHT
	 * (gets added alone in the case of OUTER; alone with a quarter block in
	 * case of INSIDE).
	 */
	private static AxisAlignedBB getCollEighthBlock(IBlockState bstate) {
		EnumFacing enumfacing = (EnumFacing) bstate.getValue(FACING);
		EnumFacing enumfacing1;

		switch ((EnumShape) bstate.getValue(SHAPE)) {
		case OUTER_LEFT:
		default:
			enumfacing1 = enumfacing;
			break;
		case OUTER_RIGHT:
			enumfacing1 = enumfacing.rotateY();
			break;
		case INNER_RIGHT:
			enumfacing1 = enumfacing.getOpposite();
			break;
		case INNER_LEFT:
			enumfacing1 = enumfacing.rotateYCCW();
		}

		boolean flag = bstate.getValue(HALF) == EnumHalf.TOP;

		switch (enumfacing1) {
		case NORTH:
		default:
			return flag ? AABB_OCT_BOT_NW : AABB_OCT_TOP_NW;
		case SOUTH:
			return flag ? AABB_OCT_BOT_SE : AABB_OCT_TOP_SE;
		case WEST:
			return flag ? AABB_OCT_BOT_SW : AABB_OCT_TOP_SW;
		case EAST:
			return flag ? AABB_OCT_BOT_NE : AABB_OCT_TOP_NE;
		}
	}

	/**
	 * Get the geometry of the queried face at the given position and state.
	 * This is used to decide whether things like buttons are allowed to be
	 * placed on the face, or how glass panes connect to the face, among other
	 * things.
	 * <p>
	 * Common values are {@code SOLID}, which is the default, and
	 * {@code UNDEFINED}, which represents something that does not fit the other
	 * descriptions and will generally cause other things not to connect to the
	 * face.
	 * 
	 * @return an approximation of the form of the given face
	 */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		state = this.getActualState(state, worldIn, pos);

		if (face.getAxis() == EnumFacing.Axis.Y) {
			return face == EnumFacing.UP == (state.getValue(HALF) == EnumHalf.TOP) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
		} else {
			EnumShape blockstairs$enumshape = (EnumShape) state.getValue(SHAPE);

			if (blockstairs$enumshape != EnumShape.OUTER_LEFT && blockstairs$enumshape != EnumShape.OUTER_RIGHT) {
				EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);

				switch (blockstairs$enumshape) {
				case INNER_RIGHT:
					return enumfacing != face && enumfacing != face.rotateYCCW() ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
				case INNER_LEFT:
					return enumfacing != face && enumfacing != face.rotateY() ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
				case STRAIGHT:
					return enumfacing == face ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
				default:
					return BlockFaceShape.UNDEFINED;
				}
			} else {
				return BlockFaceShape.UNDEFINED;
			}
		}
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks
	 * for render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/**
	 * Determines if the block is solid enough on the top side to support other
	 * blocks, like redstone components.
	 */
	public boolean isTopSolid(IBlockState state) {
		return state.getValue(HALF) == EnumHalf.TOP;
	}

	/**
	 * Called by ItemBlocks just before a block is actually set in the world, to
	 * allow for adjustments to the IBlockstate
	 */
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		IBlockState iblockstate = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
		iblockstate = iblockstate.withProperty(FACING, placer.getHorizontalFacing()).withProperty(SHAPE, EnumShape.STRAIGHT);
		return facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double) hitY <= 0.5D) ? iblockstate.withProperty(HALF, EnumHalf.BOTTOM) : iblockstate.withProperty(HALF, EnumHalf.TOP);
	}

	/**
	 * Ray traces through the blocks collision from start vector to end vector
	 * returning a ray trace hit.
	 */
	@Nullable
	public RayTraceResult collisionRayTrace(IBlockState blockState, World worldIn, BlockPos pos, Vec3d start, Vec3d end) {
		List<RayTraceResult> list = Lists.<RayTraceResult>newArrayList();

		for (AxisAlignedBB axisalignedbb : getCollisionBoxList(this.getActualState(blockState, worldIn, pos))) {
			list.add(this.rayTrace(pos, start, end, axisalignedbb));
		}

		RayTraceResult raytraceresult1 = null;
		double d1 = 0.0D;

		for (RayTraceResult raytraceresult : list) {
			if (raytraceresult != null) {
				double d0 = raytraceresult.hitVec.squareDistanceTo(end);

				if (d0 > d1) {
					raytraceresult1 = raytraceresult;
					d1 = d0;
				}
			}
		}

		return raytraceresult1;
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState().withProperty(HALF, (meta & 4) > 0 ? EnumHalf.TOP : EnumHalf.BOTTOM);
		iblockstate = iblockstate.withProperty(FACING, EnumFacing.getFront(5 - (meta & 3)));
		return iblockstate;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		if (state.getValue(HALF) == EnumHalf.TOP) {
			i |= 4;
		}

		i = i | 5 - ((EnumFacing) state.getValue(FACING)).getIndex();
		return i;
	}

	/**
	 * Get the actual Block state of this Block at the given position. This
	 * applies properties not visible in the metadata, such as fence
	 * connections.
	 */
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(SHAPE, getStairsShape(state, worldIn, pos));
	}

	private static EnumShape getStairsShape(IBlockState p_185706_0_, IBlockAccess p_185706_1_, BlockPos p_185706_2_) {
		EnumFacing enumfacing = (EnumFacing) p_185706_0_.getValue(FACING);
		IBlockState iblockstate = p_185706_1_.getBlockState(p_185706_2_.offset(enumfacing));

		if (isBlockStairs(iblockstate) && p_185706_0_.getValue(HALF) == iblockstate.getValue(HALF)) {
			EnumFacing enumfacing1 = (EnumFacing) iblockstate.getValue(FACING);

			if (enumfacing1.getAxis() != ((EnumFacing) p_185706_0_.getValue(FACING)).getAxis() && isDifferentStairs(p_185706_0_, p_185706_1_, p_185706_2_, enumfacing1.getOpposite())) {
				if (enumfacing1 == enumfacing.rotateYCCW()) {
					return EnumShape.OUTER_LEFT;
				}

				return EnumShape.OUTER_RIGHT;
			}
		}

		IBlockState iblockstate1 = p_185706_1_.getBlockState(p_185706_2_.offset(enumfacing.getOpposite()));

		if (isBlockStairs(iblockstate1) && p_185706_0_.getValue(HALF) == iblockstate1.getValue(HALF)) {
			EnumFacing enumfacing2 = (EnumFacing) iblockstate1.getValue(FACING);

			if (enumfacing2.getAxis() != ((EnumFacing) p_185706_0_.getValue(FACING)).getAxis() && isDifferentStairs(p_185706_0_, p_185706_1_, p_185706_2_, enumfacing2)) {
				if (enumfacing2 == enumfacing.rotateYCCW()) {
					return EnumShape.INNER_LEFT;
				}

				return EnumShape.INNER_RIGHT;
			}
		}

		return EnumShape.STRAIGHT;
	}

	private static boolean isDifferentStairs(IBlockState p_185704_0_, IBlockAccess p_185704_1_, BlockPos p_185704_2_, EnumFacing p_185704_3_) {
		IBlockState iblockstate = p_185704_1_.getBlockState(p_185704_2_.offset(p_185704_3_));
		return !isBlockStairs(iblockstate) || iblockstate.getValue(FACING) != p_185704_0_.getValue(FACING) || iblockstate.getValue(HALF) != p_185704_0_.getValue(HALF);
	}

	public static boolean isBlockStairs(IBlockState state) {
		return state.getBlock() instanceof BlockStairs;
	}

	/**
	 * Returns the blockstate with the given rotation from the passed
	 * blockstate. If inapplicable, returns the passed blockstate.
	 */
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 */
	@SuppressWarnings("incomplete-switch")
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
		EnumShape blockstairs$enumshape = (EnumShape) state.getValue(SHAPE);

		switch (mirrorIn) {
		case LEFT_RIGHT:

			if (enumfacing.getAxis() == EnumFacing.Axis.Z) {
				switch (blockstairs$enumshape) {
				case OUTER_LEFT:
					return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.OUTER_RIGHT);
				case OUTER_RIGHT:
					return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.OUTER_LEFT);
				case INNER_RIGHT:
					return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.INNER_LEFT);
				case INNER_LEFT:
					return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.INNER_RIGHT);
				default:
					return state.withRotation(Rotation.CLOCKWISE_180);
				}
			}

			break;
		case FRONT_BACK:

			if (enumfacing.getAxis() == EnumFacing.Axis.X) {
				switch (blockstairs$enumshape) {
				case OUTER_LEFT:
					return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.OUTER_RIGHT);
				case OUTER_RIGHT:
					return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.OUTER_LEFT);
				case INNER_RIGHT:
					return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.INNER_RIGHT);
				case INNER_LEFT:
					return state.withRotation(Rotation.CLOCKWISE_180).withProperty(SHAPE, EnumShape.INNER_LEFT);
				case STRAIGHT:
					return state.withRotation(Rotation.CLOCKWISE_180);
				}
			}
		}

		return super.withMirror(state, mirrorIn);
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, HALF, SHAPE });
	}

	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
		if (net.minecraftforge.common.ForgeModContainer.disableStairSlabCulling)
			return super.doesSideBlockRendering(state, world, pos, face);

		if (state.isOpaqueCube())
			return true;

		state = this.getActualState(state, world, pos);

		EnumHalf half = state.getValue(HALF);
		EnumFacing side = state.getValue(FACING);
		EnumShape shape = state.getValue(SHAPE);
		if (face == EnumFacing.UP)
			return half == EnumHalf.TOP;
		if (face == EnumFacing.DOWN)
			return half == EnumHalf.BOTTOM;
		if (shape == EnumShape.OUTER_LEFT || shape == EnumShape.OUTER_RIGHT)
			return false;
		if (face == side)
			return true;
		if (shape == EnumShape.INNER_LEFT && face.rotateY() == side)
			return true;
		if (shape == EnumShape.INNER_RIGHT && face.rotateYCCW() == side)
			return true;
		return false;
	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, this.getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	public static enum EnumHalf implements IStringSerializable {
		TOP("top"), BOTTOM("bottom");

		private final String name;

		private EnumHalf(String name) {
			this.name = name;
		}

		public String toString() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}
	}

	public static enum EnumShape implements IStringSerializable {
		STRAIGHT("straight"), INNER_LEFT("inner_left"), INNER_RIGHT("inner_right"), OUTER_LEFT("outer_left"), OUTER_RIGHT("outer_right");

		private final String name;

		private EnumShape(String name) {
			this.name = name;
		}

		public String toString() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}
	}
}