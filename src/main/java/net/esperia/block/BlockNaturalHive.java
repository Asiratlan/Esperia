package net.esperia.block;

import net.esperia.Esperia;
import net.esperia.tileentity.TileEntityHive;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNaturalHive extends BlockContainer {

	public static final PropertyEnum<EnumFacing> FACING = PropertyEnum.create("facing", EnumFacing.class);
	public static final PropertyInteger SIZE = PropertyInteger.create("size", 0, 1);

	private String registryName;
	
	public BlockNaturalHive(String name) {
		super(Material.WOOD);
		this.registryName = name;
		this.setUnlocalizedName(Esperia.MOD_ID + "." + name);
		this.setRegistryName(Esperia.MOD_ID, name);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.MISC);
		setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
		setDefaultState(this.blockState.getBaseState().withProperty(SIZE, 0));
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return null;
	}
	
	//XX00 SOUTH
	//XX01 EAST
	//XX10 NORTH
	//XX11 WEST
	// Where XX = number of charge

	@Override
	public IBlockState getStateFromMeta(int meta) {		
		return this.getDefaultState().withProperty(SIZE, meta / 8).withProperty(FACING, EnumFacing.values()[meta & 7]);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return (state.getValue(SIZE) * 8) + state.getValue(FACING).getIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, SIZE });
	}

	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, facing);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		TileEntityHive spawner = new TileEntityHive();
		spawner.getSpawnerBaseLogic().setEntityName("esperia.bee");
		return spawner;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, registryName);
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

}
