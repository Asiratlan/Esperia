package net.esperia.block;

import java.util.Random;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.esperia.ItemsRegistry;
import net.esperia.entity.EntityBee;
import net.esperia.tileentity.TileEntityHive;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHive extends BlockContainer {
	public static final PropertyInteger SIZE = PropertyInteger.create("size", 0, 8);
	private String registryName;
	
	public BlockHive(String name) {
		super(Material.WOOD);
		this.registryName = name;
		this.setUnlocalizedName(Esperia.MOD_ID + "." + name);
		this.setRegistryName(Esperia.MOD_ID, name);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.MISC);
		this.setDefaultState(this.blockState.getBaseState().withProperty(SIZE, 0));
	}

	/**f
	 * each class overrdies this to return a new <className>
	 */
	@Override
	public TileEntity createNewTileEntity(World par1World, int meta) {
		TileEntityHive spawner = new TileEntityHive();

		spawner.getSpawnerBaseLogic().setEntityName("bee");
		return spawner;
	}

	@Override
	public void onBlockDestroyedByPlayer(World par1World, BlockPos pos, IBlockState par5) {
		if (!par1World.isRemote) {
			int r = 5 + new Random().nextInt(11);
			for (int i = 0; i < r; i++) {
				EntityBee var6 = new EntityBee(par1World);
				var6.setLocationAndAngles(pos.getX() + 0.5D, pos.getY(), pos.getZ() + 0.5D, 0.0F, 0.0F);
				var6.setRuche(pos.getX(), pos.getZ());
				par1World.spawnEntity(var6);
			}
		}

		super.onBlockDestroyedByPlayer(par1World, pos, par5);
	}

	@Override
	public boolean onBlockActivated(World par1World, BlockPos pos, IBlockState state, EntityPlayer par5EntityPlayer, EnumHand hand, EnumFacing side, float hitX,
			float hitY, float hitZ) {
		// R�cup�ration du nombre de miel dans le ruche
		int quantityHoney = state.getValue(this.getSizeProperty()).intValue();
		// ystem.out.println("quantityHoney " + quantityHoney);
		if (quantityHoney != 0 && par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.honey, quantityHoney, 0))) {
			// Le nombre de miel passe � 0
			if (quantityHoney / 2 >= 1)
				par5EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wax, quantityHoney / 2, 0));
			state = this.getDefaultState().withProperty(this.getSizeProperty(), Integer.valueOf(0));
			par1World.setBlockState(pos, state, 2);
		}

		return true;

	}

	@Override
	public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random) {
		int quantityHoney = state.getValue(this.getSizeProperty()).intValue();
		int quantityFlowers = 0;
		int quantityProduction = 0;
		boolean prod = false;
		int quantityRuches = getBlocksAround(par1World, pos, BlocksRegistry.hive, 6);
		quantityFlowers += getBlocksAround(par1World, pos, Block.getBlockFromName("yellow_flower"), 3);
		quantityFlowers += getBlocksAround(par1World, pos, Block.getBlockFromName("red_flower"), 3);
		quantityFlowers += getBlocksAround(par1World, pos, BlocksRegistry.flower_violets, 3);
		quantityFlowers += getBlocksAround(par1World, pos, BlocksRegistry.flower_goldenrod, 3);

		if (quantityFlowers >= 5) {
			prod = true;
			quantityFlowers -= 5;
			quantityProduction += (quantityFlowers * 0.05);
			quantityProduction -= (quantityRuches * 0.15);
		}
		// par1World.setBlockMetadataWithNotify(par2, par3, par4, , 2); //
		// Augmentation du miel
		state = state.withProperty(this.getSizeProperty(), Integer.valueOf(quantityHoney + quantityProduction));
		par1World.setBlockState(pos, state, 2);
	}

	public int getBlocksAround(World par1World, BlockPos pos, Block par4, int par5) {
		int var4 = 0;
		for (int var1 = pos.getX() - par5; var1 <= pos.getX() + par5; var1++) {
			for (int var2 = pos.getY() - par5; var2 <= pos.getY() + par5; var2++) {
				for (int var3 = pos.getZ() - par5; var3 <= pos.getZ() + par5; var3++) {
					if (par1World.getBlockState(pos).getBlock() == par4) {
						var4++;
					}
				}
			}
		}
		return var4;
	}

	/**
	 * Returns true if the specified block can be connected by a fence
	 */
	public boolean canConnectRucheTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		IBlockState block = par1IBlockAccess.getBlockState(new BlockPos(par2, par3, par4));

		if (block != null && block.isOpaqueCube()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		if (blockState.getBlock() == BlocksRegistry.hive_cube) {
			return super.getBoundingBox(blockState, worldIn, pos);
		}
		float unit = 1F / 16F;
		float Offset1 = 0;
		float Offset2 = 0;
		if (canConnectRucheTo(worldIn, pos.getX() - 1, pos.getY(), pos.getZ())) {
			Offset1 = -2 * unit;
		} else if (canConnectRucheTo(worldIn, pos.getX() + 1, pos.getY(), pos.getZ())) {
			Offset1 = 2 * unit;
		}

		if (canConnectRucheTo(worldIn, pos.getX(), pos.getY(), pos.getZ() - 1)) {
			Offset2 = -2 * unit;
		} else if (canConnectRucheTo(worldIn, pos.getX(), pos.getY(), pos.getZ() + 1)) {
			Offset2 = 2 * unit;
		}

		float var9 = 0.18F;
		float var10 = 0.82F;
		float var11 = 0.18F;
		float var12 = 0.82F;

		return new AxisAlignedBB(pos.getX() + var9 + Offset1, pos.getY() + 0.1F, pos.getZ() + var11 + Offset2, pos.getX() + var10 + Offset1, pos.getY() + 0.85F, pos.getZ() + var12 + Offset2);
	}

	/*
	 * @Override public void setBlockBoundsBasedOnState(IBlockAccess
	 * par1IBlockAccess, int par2, int par3, int par4) { if
	 * (blockState.getBlock() == BlocksRegistry.ruche_cube) {
	 * super.setBlockBoundsBasedOnState(par1IBlockAccess, par2, par3, par4); }
	 * else { float unit = 1F / 16F; float Offset1 = 0; float Offset2 = 0; if
	 * (canConnectRucheTo(par1IBlockAccess, par2 - 1, par3, par4)) { Offset1 =
	 * -2 * unit; } else if (canConnectRucheTo(par1IBlockAccess, par2 + 1, par3,
	 * par4)) { Offset1 = 2 * unit; }
	 * 
	 * if (canConnectRucheTo(par1IBlockAccess, par2, par3, par4 - 1)) { Offset2
	 * = -2 * unit; } else if (canConnectRucheTo(par1IBlockAccess, par2, par3,
	 * par4 + 1)) { Offset2 = 2 * unit; }
	 * 
	 * float var9 = 0.18F; float var10 = 0.82F; float var11 = 0.18F; float var12
	 * = 0.82F;
	 * 
	 * this.setBlockBounds(var9 + Offset1, 0.1F, var11 + Offset2, var10 +
	 * Offset1, 0.85F, var12 + Offset2); } }
	 */

	protected PropertyInteger getSizeProperty() {
		return SIZE;
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(BlocksRegistry.hive_cube);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(SIZE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(SIZE);
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(SIZE);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { SIZE });
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, registryName);
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
}
