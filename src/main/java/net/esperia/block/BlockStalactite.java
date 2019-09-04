package net.esperia.block;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.esperia.Esperia;
import net.esperia.enumerator.IEnumType;
import net.esperia.util.MultipleItemObject;
import net.esperia.util.SpecialItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Stalactites/stalagmites.
 *
 * @author Mc-Fr
 */
public class BlockStalactite extends BlockSimple implements MultipleItemObject, SpecialItemBlock {
	public static final PropertyEnum<EnumBlockHalf> HALF = PropertyEnum.create("half", EnumBlockHalf.class);
	public static final PropertyEnum<EnumSize> SIZE = PropertyEnum.create("size", EnumSize.class);

	private static final AxisAlignedBB BOTTOM_HALF_AABB = new AxisAlignedBB(0, 0, 0, 1, 0.5, 1);
	private static final AxisAlignedBB TOP_HALF_AABB = new AxisAlignedBB(0, 0.5, 0, 1, 1, 1);

	/**
	 * Crée une stalactite/stalagmite.
	 * 
	 * @param name
	 *            le nom
	 * @param material
	 *            le matériau
	 * @param sound
	 *            le type de son
	 * @param hardness
	 *            la dureté
	 * @param resistance
	 *            la résistance aux explosions
	 * @param tool
	 *            l'outil nécessaire
	 * @param harvestLevel
	 *            le niveau de récolte
	 */
	public BlockStalactite(String name, Material material, SoundType sound, float hardness) {
		super(name + "_stalactite", material, sound, hardness);
		setDefaultState(this.blockState.getBaseState().withProperty(SIZE, EnumSize.SMALL).withProperty(HALF, EnumBlockHalf.BOTTOM));
		setCreativeTab(CreativeTabs.DECORATIONS);
		setUnlocalizedName(Esperia.MOD_ID + "." + name + "_stalactite");
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return getBoundingBox(state);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return getBoundingBox(blockState);
	}

	/**
	 * Retourne la hitbox en fonction de l'état.
	 * 
	 * @param state
	 *            l'état
	 * @return la hitbox
	 */
	private AxisAlignedBB getBoundingBox(IBlockState state) {
		if (state.getValue(SIZE) == EnumSize.SMALL) {
			if (state.getValue(HALF) == EnumBlockHalf.BOTTOM)
				return BOTTOM_HALF_AABB;
			else
				return TOP_HALF_AABB;
		}

		return FULL_BLOCK_AABB;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	public String[] getObjectNames() {
		List<String> variants = Stream.of(EnumSize.values()).map(EnumSize::name).collect(Collectors.toList());
		return variants.toArray(new String[variants.size()]);
		// return EnumSize.values()[meta & 7].getName();
	}

	@Override
	public int getObjectCount() {
		return EnumSize.values().length;
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
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (EnumSize size : EnumSize.values()) {
			items.add(new ItemStack(this, 1, size.getMetadata()));
		}
	}
	
	public String getUnlocalizedName(int meta) {
		return this.getUnlocalizedName() + "." + getObjectNames()[meta].toLowerCase();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, getMetaFromState(state) & 3);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, HALF, SIZE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState() //
				.withProperty(HALF, (meta & 4) == 0 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP) //
				.withProperty(SIZE, EnumSize.byMetadata(meta & 3));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(SIZE).getMetadata() | (state.getValue(HALF) == EnumBlockHalf.BOTTOM ? 0 : 4);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.up()).getMaterial().isSolid() && !(up(worldIn, pos) instanceof BlockStalactite)
				|| worldIn.getBlockState(pos.down()).getMaterial().isSolid() && !(down(worldIn, pos) instanceof BlockStalactite);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!canPlaceBlockAt(worldIn, pos)) {
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		IBlockState state = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(HALF, EnumBlockHalf.BOTTOM);
		return (facing == EnumFacing.UP || hitY <= 0.5) && !worldIn.isAirBlock(pos.down()) && !(down(worldIn, pos) instanceof BlockStalactite) //
				|| (facing == EnumFacing.DOWN || hitY > 0.5) && (worldIn.isAirBlock(pos.up()) || up(worldIn, pos) instanceof BlockStalactite) //
						? state : state.withProperty(HALF, EnumBlockHalf.TOP);
	}
	
	public void registerItemModel(Item itemBlock) {
		for (int meta = 0; meta < getObjectCount(); meta++) {
			Esperia.proxy.registerItemRenderer(itemBlock, meta, getRegistryName().getResourcePath() + "_" + getObjectNames()[meta].toLowerCase());
		}
	}

	/**
	 * Retourne le bloc au-dessus de la position donnée.
	 * 
	 * @param world
	 *            le monde
	 * @param pos
	 *            la position
	 * @return le bloc
	 */
	private Block up(World world, BlockPos pos) {
		return world.getBlockState(pos.up()).getBlock();
	}

	/**
	 * Retourne le bloc en-dessous de la position donnée.
	 * 
	 * @param world
	 *            le monde
	 * @param pos
	 *            la position
	 * @return le bloc
	 */
	private Block down(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).getBlock();
	}
	
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/**
	 * Les tailles de stalactites/stalagmites :
	 * <ul>
	 * <li>petite</li>
	 * <li>moyenne</li>
	 * <li>grande</li>
	 * </ul>
	 *
	 * @author Mc-Fr
	 */
	public static enum EnumSize implements IEnumType<EnumSize> {
		SMALL("small"), 
		MEDIUM("medium"), 
		BIG("big");
		
		private final String name;

		private EnumSize(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public int getMetadata() {
			return ordinal();
		}

		@Override
		public String toString() {
			return getName();
		}

		public static EnumSize byMetadata(int meta) {
			return values()[meta % values().length];
		}
	}
}
