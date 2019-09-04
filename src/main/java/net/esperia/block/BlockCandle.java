package net.esperia.block;

import java.util.Date;
import java.util.Random;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.esperia.Variables;
import net.esperia.item.ItemCandle;
import net.esperia.tileentity.TileEntityLightBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandle extends Block implements ITileEntityProvider {

	public static final PropertyInteger SIZE = PropertyInteger.create("size", 0, 3);

	public static final AxisAlignedBB[] CANDLE_AABB = { new AxisAlignedBB(0.375F, 0.0F, 0.375F, 0.625F, 0.5F, 0.625F), new AxisAlignedBB(0.375F, 0.0F, 0.375F, 0.625F, 0.5F * 0.75F, 0.625F),
			new AxisAlignedBB(0.375F, 0.0F, 0.375F, 0.625F, 0.5F * 0.50F, 0.625F), new AxisAlignedBB(0.375F, 0.0F, 0.375F, 0.625F, 0.5F * 0.25F, 0.625F) };
	private final boolean burning;
	private String registryName;

	public BlockCandle(String registryName, boolean burn) {
		super(Material.WOOD);
		setRegistryName(Esperia.MOD_ID, registryName);
		this.burning = burn;
		useNeighborBrightness = true;
		this.registryName = registryName;

		setTickRandomly(true);
		setHardness(0.1F);

		if (this.burning) {
			setLightLevel(0.70F);
			setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		} else {
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
			setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		}
		this.setDefaultState(this.blockState.getBaseState().withProperty(SIZE, 0));
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
				worldIn.setBlockState(pos, BlocksRegistry.candle_off.getDefaultState().withProperty(SIZE, state.getValue(SIZE)), 2);
			}

			int size = state.getValue(SIZE);
			if (worldIn.getTileEntity(pos) != null) {
				Date date_begin = ((TileEntityLightBlock) worldIn.getTileEntity(pos)).getDate();
				// Obtient le nombre de minutes depuis l'allumage ou dernier changement de
				// phase.
				long timer = (new Date().getTime() - date_begin.getTime()) / (60 * 1000) % 60;
				if (timer >= Variables.CANDLE_CYCLE_TIME) {
					if (size == 3) {
						worldIn.removeTileEntity(pos);
						worldIn.setBlockToAir(pos);
					} else {
						worldIn.setBlockState(pos, state.withProperty(SIZE, size + 1));
						((TileEntityLightBlock) worldIn.getTileEntity(pos)).setDate(new Date());
					}
				}
			}
		}
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		if (!super.canPlaceBlockAt(worldIn, pos))
			return false;

		return worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getMaterial().isOpaque();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (this.burning && playerIn.getHeldItemMainhand().isEmpty()) {
			worldIn.setBlockState(pos, BlocksRegistry.candle_off.getDefaultState().withProperty(SIZE, state.getValue(SIZE)), 2);
		} else if (playerIn.getHeldItemMainhand() != null && (playerIn.getHeldItemMainhand().getItem() == Items.FLINT_AND_STEEL)) {
			playerIn.getHeldItemMainhand().damageItem(1, playerIn);
			worldIn.setBlockState(pos, BlocksRegistry.candle_on.getDefaultState().withProperty(SIZE, state.getValue(SIZE)), 2);
			((TileEntityLightBlock) worldIn.getTileEntity(pos)).setDate();
		}

		return true;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int size = state.getValue(SIZE);
		return CANDLE_AABB[size];
	}

	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (this.burning) {
			int size = 4 - stateIn.getValue(SIZE);
			float sizeMul = size / 4F;
			double partX = pos.getX() + 0.5F;
			double partY = pos.getY() + (0.7F * sizeMul);
			double partZ = pos.getZ() + 0.5F;
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, partX, partY, partZ, 0, 0, 0);
			worldIn.spawnParticle(EnumParticleTypes.FLAME, partX, partY, partZ, 0, 0, 0);
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

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(BlocksRegistry.candle_off, 1, state.getValue(SIZE));
	}

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(SIZE, meta);
	}

	public int getMetaFromState(IBlockState state) {
		return state.getValue(SIZE);
	}

	public int damageDropped(IBlockState state) {
		return state.getValue(SIZE);
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { SIZE });
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityLightBlock();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
		for (int i = 0; i < 4; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	public String getUnlocalizedName(int meta) {
		return this.getUnlocalizedName() + "." + getObjectNames()[meta];
	}

	public int getObjectCount() {
		return 4;
	}

	public String[] getObjectNames() {
		return new String[] { "complete", "three-quarter", "half", "quarter" };
	}

	public void registerItemModel(Item itemBlock) {
		for (int meta = 0; meta < getObjectCount(); meta++) {
			Esperia.proxy.registerItemRenderer(itemBlock, meta, getRegistryName().getResourcePath() + "_" + getObjectNames()[meta]);
		}
	}

	public Item createItemBlock() {
		return new ItemCandle(this, getRegistryName().getResourcePath());
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}
