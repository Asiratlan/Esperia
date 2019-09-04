package net.esperia.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
 * Cette classe représente un bloc pouvant être orienté vers les quatre points
 * cardinaux.
 * 
 * @author Mc-Fr
 */
public class BlockOrientable extends BlockSimple {
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	/**
	 * Crée un nouveau bloc.
	 * 
	 * @param name
	 *            le nom interne
	 * @param material
	 *            le matériau
	 * @param sound
	 *            le type de son
	 * @param hardness
	 *            la dureté
	 * @param resistance
	 *            la résistance
	 * @param tool
	 *            l'outils nécessaire pour le récupérer
	 * @param harvestLevel
	 *            le niveau de l'outils
	 * @param tab
	 *            l'onglet du menu Créatif
	 */
	public BlockOrientable(String name, Material material, SoundType sound, float hardness, float resistance, String tool, int harvestLevel, CreativeTabs tab) {
		this(name, material, material.getMaterialMapColor(), sound, hardness, resistance, tool, harvestLevel, tab);
	}

	/**
	 * Crée un nouveau bloc.
	 * 
	 * @param name
	 *            le nom interne
	 * @param material
	 *            le matériau
	 * @param mapColor
	 *            la couleur sur les cartes
	 * @param sound
	 *            le type de son
	 * @param hardness
	 *            la dureté
	 * @param resistance
	 *            la résistance
	 * @param tool
	 *            l'outils nécessaire pour le récupérer
	 * @param harvestLevel
	 *            le niveau de l'outils
	 * @param tab
	 *            l'onglet du menu Créatif
	 */
	public BlockOrientable(String name, Material material, MapColor mapColor, SoundType sound, float hardness, float resistance, String tool, int harvestLevel, CreativeTabs tab) {
		super(name, material, sound, hardness);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	public BlockOrientable(String name, Material material, SoundType sound, float hardness) {
		super(name, material, sound, hardness);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING,
				EnumFacing.getHorizontal(MathHelper.floor((placer.rotationYaw * 4 / 360) + 0.5) & 3).getOpposite());
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(FACING, EnumFacing.Plane.HORIZONTAL.facings()[meta & 3]);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(FACING).getHorizontalIndex();
	}
}
