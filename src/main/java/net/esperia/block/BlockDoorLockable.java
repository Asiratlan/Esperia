package net.esperia.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.esperia.item.ItemKey;
import net.esperia.item.ItemKeyRing;
import net.esperia.tileentity.TileEntityEsperiaLockable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDoorLockable extends BlockDoor implements ITileEntityProvider {

	public BlockDoorLockable(String registryName, Material materialIn) {
		super(materialIn);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		setCreativeTab(null);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(OPEN, Boolean.valueOf(false)).withProperty(HINGE, BlockDoor.EnumHingePosition.LEFT)
				.withProperty(POWERED, Boolean.valueOf(false)).withProperty(HALF, BlockDoor.EnumDoorHalf.LOWER));
		setHardness(0.5f);
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.getBlock() == net.esperia.BlocksRegistry.iron_door_lockable ? MapColor.IRON
				: (state.getBlock() == net.esperia.BlocksRegistry.oak_door_lockable ? BlockPlanks.EnumType.OAK.getMapColor()
						: (state.getBlock() == net.esperia.BlocksRegistry.spruce_door_lockable ? BlockPlanks.EnumType.SPRUCE.getMapColor()
								: (state.getBlock() == net.esperia.BlocksRegistry.birch_door_lockable ? BlockPlanks.EnumType.BIRCH.getMapColor()
										: (state.getBlock() == net.esperia.BlocksRegistry.jungle_door_lockable ? BlockPlanks.EnumType.JUNGLE.getMapColor()
												: (state.getBlock() == net.esperia.BlocksRegistry.acacia_door_lockable ? BlockPlanks.EnumType.ACACIA.getMapColor()
														: (state.getBlock() == net.esperia.BlocksRegistry.dark_oak_door_lockable ? BlockPlanks.EnumType.DARK_OAK.getMapColor()
																: super.getMapColor(state, worldIn, pos)))))));
	}

	private Item getItem() {
		return this == BlocksRegistry.iron_door_lockable ? Items.IRON_DOOR
				: (this == BlocksRegistry.spruce_door_lockable ? Items.SPRUCE_DOOR
						: (this == BlocksRegistry.birch_door_lockable ? Items.BIRCH_DOOR
								: (this == BlocksRegistry.jungle_door_lockable ? Items.JUNGLE_DOOR
										: (this == BlocksRegistry.acacia_door_lockable ? Items.ACACIA_DOOR
												: (this == BlocksRegistry.dark_oak_door_lockable ? Items.DARK_OAK_DOOR
														: (this == BlocksRegistry.door_strong_lockable ? BlocksRegistry.door_strong_item : Items.OAK_DOOR))))));
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityEsperiaLockable();
	}

	public EnumDoorHalf getEnumDoorHalf(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getValue(HALF);
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

		if (playerIn.getHeldItemMainhand() != ItemStack.EMPTY && playerIn.getHeldItemMainhand().getItem() instanceof ItemKey || playerIn.getHeldItemMainhand().getItem() instanceof ItemKeyRing)
			return false;

		TileEntity tileEntityMainBefore = worldIn.getTileEntity(pos);
		TileEntity tileEntityComplBefore = null;
		TileEntity tileEntityMainAfter = null;
		TileEntity tileEntityComplAfter = null;
		TileEntityEsperiaLockable tileLockableMainBefore = null;
		TileEntityEsperiaLockable tileLockableComplBefore = null;
		TileEntityEsperiaLockable tileLockableMainAfter = null;
		TileEntityEsperiaLockable tileLockableComplAfter = null;

		if (tileEntityMainBefore != null && tileEntityMainBefore instanceof TileEntityEsperiaLockable) {
			tileLockableMainBefore = (TileEntityEsperiaLockable) tileEntityMainBefore;
			tileEntityComplBefore = worldIn.getTileEntity(tileLockableMainBefore.getComplHalfDoor(worldIn));
			if (tileEntityComplBefore != null && tileEntityComplBefore instanceof TileEntityEsperiaLockable)
				tileLockableComplBefore = (TileEntityEsperiaLockable) tileEntityComplBefore;

			Long keyMain = tileLockableMainBefore.getKey();
			Long keyCompl = tileLockableComplBefore.getKey();

			if (this.blockMaterial == Material.IRON) {
				return false; // Allow items to interact with the door
			} else {
				BlockPos blockpos = state.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
				IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

				if (iblockstate.getBlock() != this) {
					return false;
				} else {
					if (tileLockableMainBefore.getOpen()) {
						state = iblockstate.cycleProperty(OPEN);
						worldIn.setBlockState(blockpos, state, 10);
						worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
						worldIn.playEvent(playerIn, ((Boolean) state.getValue(OPEN)).booleanValue() ? this.getOpenSound() : this.getCloseSound(), pos, 0);

						tileEntityMainAfter = worldIn.getTileEntity(pos);
						if (tileEntityMainAfter != null && tileEntityMainAfter instanceof TileEntityEsperiaLockable) {
							tileLockableMainAfter = (TileEntityEsperiaLockable) tileEntityMainAfter;

							tileEntityComplAfter = worldIn.getTileEntity(tileLockableMainAfter.getComplHalfDoor(worldIn));
							if (tileEntityComplAfter != null && tileEntityComplAfter instanceof TileEntityEsperiaLockable) {
								tileLockableComplAfter = (TileEntityEsperiaLockable) tileEntityComplAfter;
								tileLockableMainAfter.setKey(keyMain);
								tileLockableComplAfter.setKey(keyCompl);
							}
						}

						return true;
					} else {
						if (!worldIn.isRemote && hand == EnumHand.MAIN_HAND)
							playerIn.sendMessage(new TextComponentString("(La porte est verrouillée.)").setStyle(new Style().setColor(TextFormatting.BLUE)));
						return false;
					}
				}
			}

		}
		return false;
	}

	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.getItem();
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER) {
			BlockPos blockpos = pos.down();
			IBlockState iblockstate = worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() != this) {
				worldIn.setBlockToAir(pos);
			} else if (blockIn != this) {
				iblockstate.neighborChanged(worldIn, blockpos, blockIn, fromPos);
			}
		} else {
			boolean flag1 = false;
			BlockPos blockpos1 = pos.up();
			IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

			if (iblockstate1.getBlock() != this) {
				worldIn.setBlockToAir(pos);
				flag1 = true;
			}

			if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP)) {
				worldIn.setBlockToAir(pos);
				flag1 = true;

				if (iblockstate1.getBlock() == this) {
					worldIn.setBlockToAir(blockpos1);
				}
			}

			if (flag1) {
				if (!worldIn.isRemote) {
					this.dropBlockAsItem(worldIn, pos, state, 0);
				}
			} else // ici !!!!!!
			{
				boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos1);

				if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower()) && flag != ((Boolean) iblockstate1.getValue(POWERED)).booleanValue()) {
					TileEntity tileEntityMainBefore = worldIn.getTileEntity(pos);
					TileEntity tileEntityComplBefore = null;
					TileEntity tileEntityMainAfter = null;
					TileEntity tileEntityComplAfter = null;
					TileEntityEsperiaLockable tileLockableMainBefore = null;
					TileEntityEsperiaLockable tileLockableComplBefore = null;
					TileEntityEsperiaLockable tileLockableMainAfter = null;
					TileEntityEsperiaLockable tileLockableComplAfter = null;

					if (tileEntityMainBefore != null && tileEntityMainBefore instanceof TileEntityEsperiaLockable) {
						tileLockableMainBefore = (TileEntityEsperiaLockable) tileEntityMainBefore;
						tileEntityComplBefore = worldIn.getTileEntity(blockpos1);
						if (tileEntityComplBefore != null && tileEntityComplBefore instanceof TileEntityEsperiaLockable)
							tileLockableComplBefore = (TileEntityEsperiaLockable) tileEntityComplBefore;

						Long keyMain = tileLockableMainBefore.getKey();
						Long keyCompl = tileLockableComplBefore.getKey();

						if (tileLockableMainBefore.getOpen()) {
							worldIn.setBlockState(blockpos1, iblockstate1.withProperty(POWERED, Boolean.valueOf(flag)), 2);

							if (flag != ((Boolean) state.getValue(OPEN)).booleanValue()) {

								worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
								worldIn.markBlockRangeForRenderUpdate(pos, pos);
								worldIn.playEvent((EntityPlayer) null, flag ? this.getOpenSound() : this.getCloseSound(), pos, 0);

								tileEntityMainAfter = worldIn.getTileEntity(pos);
								if (tileEntityMainAfter != null && tileEntityMainAfter instanceof TileEntityEsperiaLockable) {
									tileLockableMainAfter = (TileEntityEsperiaLockable) tileEntityMainAfter;

									tileEntityComplAfter = worldIn.getTileEntity(blockpos1);
									if (tileEntityComplAfter != null && tileEntityComplAfter instanceof TileEntityEsperiaLockable) {
										tileLockableComplAfter = (TileEntityEsperiaLockable) tileEntityComplAfter;
										tileLockableMainAfter.setKey(keyMain);
										tileLockableComplAfter.setKey(keyCompl);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private int getCloseSound() {
		return this.blockMaterial == Material.IRON ? 1011 : 1012;
	}

	private int getOpenSound() {
		return this.blockMaterial == Material.IRON ? 1005 : 1006;
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		super.breakBlock(world, pos, state);
		world.removeTileEntity(pos);
	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.addIgnoreToModel(this, BlockDoorLockable.POWERED);
		Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

}
