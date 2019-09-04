package net.esperia.block;

import java.util.Date;
import java.util.Random;

import net.esperia.Variables;
import net.esperia.enumerator.EnumLanternColor;
import net.esperia.item.ItemCandle;
import net.esperia.tileentity.TileEntityLightBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Lanterne colorée.
 * 
 * @author Mc-Fr
 */
public class BlockLantern extends BlockSimple implements ITileEntityProvider {
	public static final PropertyInteger ORIENTATION = PropertyInteger.create("orientation", 0, 3);
	public static final PropertyEnum<EnumPosition> POSITION = PropertyEnum.create("position", EnumPosition.class);

	/** La couleur */
	private final EnumLanternColor color;
	/** Indique si la lanterne est en papier */
	private final boolean isPaper;
	private final boolean burning;

	/**
	 * Crée une lanterne.
	 * 
	 * @param color
	 *            la couleur
	 * @param isPaper
	 *            en papier ou non
	 */

	public BlockLantern(EnumLanternColor color, boolean isPaper, boolean burning) {
		super((isPaper ? "paper_" : "") + "lantern_" + color.getName() + (!burning ? "_off" : ""), isPaper ? Material.CLOTH : Material.GLASS, isPaper ? SoundType.CLOTH : SoundType.GLASS, 0.5f);
		setDefaultState(this.blockState.getBaseState().withProperty(ORIENTATION, 0).withProperty(POSITION, EnumPosition.BOTTOM));
		if (burning) {
			setLightLevel(0.875f);
			setTickRandomly(true);
			setCreativeTab(null);
		}
		this.color = color;
		this.isPaper = isPaper;
		this.burning = burning;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		// if (!worldIn.isRemote) {
		super.updateTick(worldIn, pos, state, rand);
		if (this.burning) {
			if (worldIn.isRaining() && worldIn.getChunkFromBlockCoords(pos).getBiome(pos, worldIn.getBiomeProvider()).canRain() && //
				   (worldIn.canBlockSeeSky(pos) || //
					worldIn.canBlockSeeSky(pos.north()) || //
					worldIn.canBlockSeeSky(pos.east()) || //
					worldIn.canBlockSeeSky(pos.south()) || //
					worldIn.canBlockSeeSky(pos.west()))) {
				worldIn.setBlockState(pos, getLanternType(false).getDefaultState().withProperty(ORIENTATION, state.getValue(ORIENTATION)).withProperty(POSITION, state.getValue(POSITION)));
			}
			
			if (worldIn.getTileEntity(pos) != null) {
				Date date_begin = ((TileEntityLightBlock) worldIn.getTileEntity(pos)).getDate();
				// Obtient le nombre de minutes depuis l'allumage ou dernier
				// changement de phase.
				if (date_begin == null)
					return;
				long timer = (new Date().getTime() - date_begin.getTime()) / (60 * 1000) % 60;
				if (timer >= Variables.LANTERN_LIT_TIME) {
					worldIn.setBlockState(pos, getLanternType(false).getDefaultState().withProperty(ORIENTATION, state.getValue(ORIENTATION)).withProperty(POSITION, state.getValue(POSITION)));
					((TileEntityLightBlock) worldIn.getTileEntity(pos)).setDate(new Date());
				}
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (this.burning && playerIn.getHeldItemMainhand().isEmpty()) {
			worldIn.setBlockState(pos, getLanternType(false).getDefaultState().withProperty(ORIENTATION, state.getValue(ORIENTATION)).withProperty(POSITION, state.getValue(POSITION)));
		} else if (playerIn.getHeldItemMainhand() != null && (playerIn.getHeldItemMainhand().getItem() instanceof ItemCandle)) {
			if(!playerIn.isCreative()){
				playerIn.getHeldItemMainhand().shrink(1);
			}
			worldIn.setBlockState(pos, getLanternType(true).getDefaultState().withProperty(ORIENTATION, state.getValue(ORIENTATION)).withProperty(POSITION, state.getValue(POSITION)));
			((TileEntityLightBlock) worldIn.getTileEntity(pos)).setDate();
		}

		return true;
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		EnumPosition position = EnumPosition.fromFacing(facing);
		int face = position.isOnWall() ? facing.getHorizontalIndex() : getFacingIndex(placer);
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(POSITION, position).withProperty(ORIENTATION, face);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!canPlaceBlockAt(worldIn, pos)) {
			// dropBlockAsItem(world, pos, state, 0);
			// world.setBlockToAir(pos);
		} else
			super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
	}

	/**
	 * Retourne l'orientation en fonction de la rotation du joueur.
	 * 
	 * @param placer
	 *            le joueur
	 * @return l'orientation
	 */
	private int getFacingIndex(EntityLivingBase placer) {
		int rotation = MathHelper.floor((placer.rotationYaw + 180) * 16 / 360 + 0.5) & 15;

		if (rotation == 0 || rotation == 8)
			return 0;
		if (rotation == 4 || rotation == 12)
			return 1;
		if (rotation >= 1 && rotation <= 3 || rotation >= 9 && rotation <= 11)
			return 2;
		return 3;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		double f = 0.25, h = 0.5;

		if (state.getValue(POSITION) == EnumPosition.BOTTOM)
			return new AxisAlignedBB(h - f, 0, h - f, h + f, 0.5625, h + f);
		else if (state.getValue(POSITION) == EnumPosition.TOP)
			return new AxisAlignedBB(h - f, 0.4375f, h - f, h + f, 1, h + f);
		else {
			switch (state.getValue(ORIENTATION)) {
			case 0:
				return new AxisAlignedBB(h - f, 0.2, 0, h + f, 0.8, h);
			case 1:
				return new AxisAlignedBB(h, 0.2, h - f, 1, 0.8, h + f);
			case 2:
				return new AxisAlignedBB(h - f, 0.2, h, h + f, 0.8, 1);
			case 3:
				return new AxisAlignedBB(0, 0.2, h - f, h, 0.8, h + f);
			default:
				return NULL_AABB;
			}
		}
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
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, POSITION, ORIENTATION);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(ORIENTATION, meta & 3).withProperty(POSITION, EnumPosition.fromIndex((meta & 0b1100) >> 2));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(POSITION).ordinal() << 2) | (state.getValue(ORIENTATION) & 3);
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityLightBlock();
	}

	public BlockLantern getLanternType(boolean burning) {

		return (BlockLantern) Block.REGISTRY.getObject(new ResourceLocation("esperia", (this.isPaper ? "paper_" : "") + "lantern_" + this.color.getName() + (!burning ? "_off" : "")));
	}
	
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/**
	 * Positions du bloc lanterne :
	 * <ul>
	 * <li>bas</li>
	 * <li>mur</li>
	 * <li>haut</li>
	 * </ul>
	 *
	 * @author Mc-Fr
	 */
	private static enum EnumPosition implements IStringSerializable {
		BOTTOM("bottom"), WALL("wall"), TOP("top");

		private final String name;

		private EnumPosition(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public boolean isOnWall() {
			return this == WALL;
		}

		public static EnumPosition fromFacing(EnumFacing facing) {
			if (facing == EnumFacing.DOWN)
				return TOP;
			if (facing == EnumFacing.UP)
				return BOTTOM;
			return WALL;
		}

		public static EnumPosition fromIndex(int index) {
			return values()[index % values().length];
		}
	}
}
