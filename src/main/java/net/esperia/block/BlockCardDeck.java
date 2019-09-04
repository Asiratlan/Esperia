package net.esperia.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.esperia.Esperia;
import net.esperia.ItemsRegistry;
import net.esperia.item.ItemCard;
import net.esperia.tileentity.TileEntityCardDeck;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCardDeck extends BlockContainer {
	public static final PropertyEnum<EnumFacing> FACING = PropertyDirection.create("facing");
	protected static final AxisAlignedBB CARD_DECK_AABB = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.188D, 0.6875D);
	
	public BlockCardDeck(String registryName) {
		super(Material.WOOD, MapColor.AIR);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
		setHardness(2.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
	}

	/**
	 * Returns a new instance of a block's tile entity class. Called on placing
	 * the block.
	 */
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCardDeck();
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks
	 * for render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean causesSuffocation(IBlockState state) {
		return true;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else if (playerIn.isSpectator()) {
			return true;
		} else {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityCardDeck) {
				//Open Container with ItemCubo in Hand
				if (playerIn.getHeldItem(hand).getItem() == ItemsRegistry.item_hrp) {
					playerIn.openGui(Esperia.instance(), 12, worldIn, pos.getX(), pos.getY(), pos.getZ());
				//Insert Card in deck 
				} else if (playerIn.getHeldItem(hand).getItem() instanceof ItemCard) {
					ItemStack card = playerIn.getHeldItem(hand).copy();
					int index = ((TileEntityCardDeck) tileentity).getCompatibleSlot(card);
					if (index >= 0) {
						ItemStack card1 = ((TileEntityCardDeck) tileentity).getStackInSlot(index);
						if (card1.isEmpty()) {
							card.setCount(1);
							((TileEntityCardDeck) tileentity).setInventorySlotContents(index, card);
						} else {
							card1.grow(1);
						}
						playerIn.getHeldItem(hand).shrink(1);
					} else {
						playerIn.sendMessage(new TextComponentString("Le paquet est plein").setStyle(new Style().setColor(TextFormatting.YELLOW)));

					}
				//Draw Card
				} else {
					ItemStack random_slot = ((TileEntityCardDeck) tileentity).getRandomCard();
					if (!random_slot.isEmpty()) {
						ItemStack card_drawn = random_slot.copy();
						card_drawn.setCount(1);
						playerIn.addItemStackToInventory(card_drawn);
						random_slot.shrink(1);
					} else {
						playerIn.sendMessage(new TextComponentString("Le paquet est vide").setStyle(new Style().setColor(TextFormatting.YELLOW)));
					}
				}
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * Called by ItemBlocks just before a block is actually set in the world, to
	 * allow for adjustments to the IBlockstate
	 */
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
            float hitZ, int meta, EntityLivingBase placer) {

        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
    
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getFront(meta);
		return this.getDefaultState().withProperty(FACING, enumfacing);
	}

	/**
	 * Called before the Block is set to air in the world. Called regardless of
	 * if the player's tool can actually collect this block
	 */
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (worldIn.getTileEntity(pos) instanceof TileEntityCardDeck) {
			TileEntityCardDeck tileentity = (TileEntityCardDeck) worldIn.getTileEntity(pos);
			tileentity.setDestroyedByCreativePlayer(player.capabilities.isCreativeMode);
			tileentity.fillWithLoot(player);
		}
	}

	/**
	 * Spawns this Block's drops into the World as EntityItems.
	 */
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
	}

	/**
	 * Called by ItemBlocks after a block is set in the world, to allow
	 * post-place logic
	 */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityCardDeck) {
				((TileEntityCardDeck) tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	/**
	 * Called serverside after this block is replaced with another in Chunk, but
	 * before the Tile Entity is updated
	 */
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof TileEntityCardDeck) {
			TileEntityCardDeck tileentityshulkerbox = (TileEntityCardDeck) tileentity;

			if (!tileentityshulkerbox.isCleared() && tileentityshulkerbox.shouldDrop()) {
				ItemStack itemstack = new ItemStack(Item.getItemFromBlock(this));
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound.setTag("BlockEntityTag", ((TileEntityCardDeck) tileentity).saveToNbt(nbttagcompound1));
				itemstack.setTagCompound(nbttagcompound);

				if (tileentityshulkerbox.hasCustomName()) {
					itemstack.setStackDisplayName(tileentityshulkerbox.getName());
					tileentityshulkerbox.setCustomName("");
				}

				spawnAsEntity(worldIn, pos, itemstack);
			}

			worldIn.updateComparatorOutputLevel(pos, state.getBlock());
		}

		super.breakBlock(worldIn, pos, state);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
		super.addInformation(stack, player, tooltip, advanced);
		NBTTagCompound nbttagcompound = stack.getTagCompound();

		if (nbttagcompound != null && nbttagcompound.hasKey("BlockEntityTag", 10)) {
			NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("BlockEntityTag");

			if (nbttagcompound1.hasKey("LootTable", 8)) {
				tooltip.add("???????");
			}

			if (nbttagcompound1.hasKey("Items", 9)) {
				NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);
				ItemStackHelper.loadAllItems(nbttagcompound1, nonnulllist);
				int i = 0;
				int j = 0;

				for (ItemStack itemstack : nonnulllist) {
					if (!itemstack.isEmpty()) {
						++j;

						if (i <= 4) {
							++i;
							tooltip.add(String.format("%s x%d", itemstack.getDisplayName(), itemstack.getCount()));
						}
					}
				}
			}
		}
	}

	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CARD_DECK_AABB;
	}

	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstoneFromInventory((IInventory) worldIn.getTileEntity(pos));
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		ItemStack itemstack = super.getItem(worldIn, pos, state);
		TileEntityCardDeck tileentity = (TileEntityCardDeck) worldIn.getTileEntity(pos);
		NBTTagCompound nbttagcompound = tileentity.saveToNbt(new NBTTagCompound());

		if (!nbttagcompound.hasNoTags()) {
			itemstack.setTagInfo("BlockEntityTag", nbttagcompound);
		}

		return itemstack;
	}

	/**
	 * Returns the blockstate with the given rotation from the passed
	 * blockstate. If inapplicable, returns the passed blockstate.
	 */
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 */
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, this.getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}