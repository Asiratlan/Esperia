package net.esperia.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.esperia.item.ItemKey;
import net.esperia.tileentity.TileEntityEsperiaLockable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BlockTrapDoorLockable extends BlockTrapDoor implements ITileEntityProvider {

	public BlockTrapDoorLockable(String registryName, Material materialIn) {
		super(materialIn);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, Boolean.valueOf(false)).withProperty(HALF, BlockTrapDoor.DoorHalf.BOTTOM));
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityEsperiaLockable();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (playerIn.getHeldItemMainhand() != null && playerIn.getHeldItemMainhand().getItem() instanceof ItemKey)
			return false;

		TileEntity tileEntityBefore = worldIn.getTileEntity(pos);
		TileEntity tileEntityAfter = null;
		TileEntityEsperiaLockable tileLockableBefore = null;
		TileEntityEsperiaLockable tileLockableAfter = null;

		if (tileEntityBefore != null && tileEntityBefore instanceof TileEntityEsperiaLockable) {
			tileLockableBefore = (TileEntityEsperiaLockable) tileEntityBefore;
			Long key = tileLockableBefore.getKey();

			if (this.blockMaterial == Material.IRON) {
				return true;
			} else {
				if (tileLockableBefore.getOpen()) {
					state = state.cycleProperty(OPEN);
					worldIn.setBlockState(pos, state, 2);
					this.playSound(playerIn, worldIn, pos, ((Boolean) state.getValue(OPEN)).booleanValue());

					tileEntityAfter = worldIn.getTileEntity(pos);
					if (tileEntityAfter != null && tileEntityAfter instanceof TileEntityEsperiaLockable) {
						tileLockableAfter = (TileEntityEsperiaLockable) tileEntityAfter;
						tileLockableAfter.setKey(key);
						return true;
					}
				} else {
					if (!worldIn.isRemote && hand == EnumHand.MAIN_HAND)
						playerIn.sendMessage(new TextComponentString("(HRP : La trappe est verrouillée.)").setStyle(new Style().setColor(TextFormatting.BLUE)));
					return false;
				}
				return false;
			}
		}
		return false;
	}
	
	private Item getItem() {
		return this == BlocksRegistry.iron_trapdoor_lockable ? Item.getItemFromBlock(Blocks.IRON_TRAPDOOR)
				: (this == BlocksRegistry.spruce_trapdoor_lockable ? Item.getItemFromBlock(BlocksRegistry.spruce_trapdoor)
						: (this == BlocksRegistry.birch_trapdoor_lockable ? Item.getItemFromBlock(BlocksRegistry.birch_trapdoor)
								: (this == BlocksRegistry.jungle_trapdoor_lockable ? Item.getItemFromBlock(BlocksRegistry.jungle_trapdoor)
										: (this == BlocksRegistry.acacia_trapdoor_lockable ? Item.getItemFromBlock(BlocksRegistry.acacia_trapdoor)
												: (this == BlocksRegistry.dark_oak_trapdoor_lockable ? Item.getItemFromBlock(BlocksRegistry.dark_oak_trapdoor)
														: Item.getItemFromBlock(Blocks.TRAPDOOR))))));
	}
	
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.getItem();
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote) {
			TileEntity tileEntityBefore = worldIn.getTileEntity(pos);
			TileEntity tileEntityAfter = null;
			TileEntityEsperiaLockable tileLockableBefore = null;
			TileEntityEsperiaLockable tileLockableAfter = null;

			if (tileEntityBefore != null && tileEntityBefore instanceof TileEntityEsperiaLockable) {
				tileLockableBefore = (TileEntityEsperiaLockable) tileEntityBefore;
				Long key = tileLockableBefore.getKey();

				boolean flag = worldIn.isBlockPowered(pos);

				if (flag || blockIn.getDefaultState().canProvidePower()) {
					boolean flag1 = ((Boolean) state.getValue(OPEN)).booleanValue();

					if (flag1 != flag) {

						if (tileLockableBefore.getOpen()) {
							worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
							this.playSound((EntityPlayer) null, worldIn, pos, flag);

							tileEntityAfter = worldIn.getTileEntity(pos);
							if (tileEntityAfter != null && tileEntityAfter instanceof TileEntityEsperiaLockable) {
								tileLockableAfter = (TileEntityEsperiaLockable) tileEntityAfter;
								tileLockableAfter.setKey(key);
							}
						}
					}
				}
			}
		}
	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.addIgnoreToModel(this, BlockDoorLockable.POWERED);
		Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

}
