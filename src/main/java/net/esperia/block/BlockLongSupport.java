package net.esperia.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Bloc support en équerre.
 *
 * @author Mc-Fr
 */
public class BlockLongSupport extends BlockOrientable {
	/** Indique si ce support est long */
	private static final PropertyBool HOLD = PropertyBool.create("hold");

	/**
	 * Crée un support.
	 * 
	 */
	public BlockLongSupport(String registryName) {
		super(registryName, Material.WOOD, SoundType.WOOD, 1, 0, "axe", 0, CreativeTabs.DECORATIONS);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		EnumFacing face = facing.getAxis() != Axis.Y ? facing : EnumFacing.getHorizontal(MathHelper.floor((placer.rotationYaw * 4 / 360) + 0.5) & 3).getOpposite();
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, face);
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
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		IBlockState actualState = world.getBlockState(pos);
			switch (world.getBlockState(pos).getValue(FACING)) {
			case NORTH:
				actualState = actualState.withProperty(HOLD, world.getBlockState(pos.down().north()).getMaterial() != Material.AIR);
				break;
			case SOUTH:
				actualState = actualState.withProperty(HOLD, world.getBlockState(pos.down().south()).getMaterial() != Material.AIR);
				break;
			case WEST:
				actualState = actualState.withProperty(HOLD, world.getBlockState(pos.down().west()).getMaterial() != Material.AIR);
				break;
			case EAST:
				actualState = actualState.withProperty(HOLD, world.getBlockState(pos.down().east()).getMaterial() != Material.AIR);
				break;
			default:
				break;
			}
		return actualState;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		
			return new BlockStateContainer(this, new IProperty[] { FACING, HOLD });
		}
}
