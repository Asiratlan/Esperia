package net.esperia.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
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
public class BlockSupport extends BlockOrientable {
	/** Indique si ce support est long */
	private static final PropertyBool HOLD = PropertyBool.create("hold");

	/**
	 * Crée un support.
	 * 
	 * @param isLong
	 *            le support est-il long ?
	 */
	public BlockSupport(String registryName) {
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

}
