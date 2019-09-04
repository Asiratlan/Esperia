package net.esperia.block;

import net.esperia.ItemsRegistry;
import net.esperia.item.ItemRepairWheel;
import net.esperia.item.ItemSimpleTool;
import net.esperia.item.tools.ItemSimpleAxe;
import net.esperia.item.tools.ItemSimpleHoe;
import net.esperia.item.tools.ItemSimplePickaxe;
import net.esperia.item.tools.ItemSimpleSpade;
import net.esperia.item.tools.ItemSimpleSword;
import net.esperia.tileentity.TileEntityRepair;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRepairWheel extends BlockSimple implements ITileEntityProvider {
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);

	public BlockRepairWheel(String name) {
		super(name, Material.WOOD, SoundType.WOOD, 1.5F);
		this.setTickRandomly(true);
		this.setCreativeTab(CreativeTabs.MISC);
		setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false));
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityRepair();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote)
			return true;
		ItemStack stack = playerIn.getHeldItem(hand);
		int count = ((TileEntityRepair) worldIn.getTileEntity(pos)).getCharges();
		if (playerIn.getHeldItem(hand).getItem() == ItemsRegistry.item_hrp) {
			playerIn.sendMessage(new TextComponentString("La roue peut encore réparer " + count + " outils.").setStyle(new Style().setColor(TextFormatting.YELLOW)));
			return true;
		}

		else if (playerIn.getHeldItem(hand).getItem() instanceof ItemRepairWheel) {
			((TileEntityRepair) worldIn.getTileEntity(pos)).setCharges(60);
			if (!playerIn.isCreative())
				playerIn.getHeldItem(hand).shrink(1);
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(POWERED, true));
			return true;
		}

		else if (count > 0) {
			if (isItemRepairable(stack.getItem())) {
				if (stack.getItemDamage() > stack.getMaxDamage() / 3) {
					NBTTagCompound nbt;
					int charges = 0;
					if (stack.hasTagCompound()) {
						nbt = stack.getTagCompound();
						charges = nbt.getInteger("charges");
					} else {
						nbt = new NBTTagCompound();
					}
					if (charges < 6) {
						int new_damage = (int) (stack.getMaxDamage() * getRepairFactor(charges));
						stack.setItemDamage(stack.getMaxDamage() - new_damage);
						nbt.setInteger("charges", ++charges);
						stack.setTagCompound(nbt);
						((TileEntityRepair) worldIn.getTileEntity(pos)).decrCharge();
						if (((TileEntityRepair) worldIn.getTileEntity(pos)).getCharges() == 0) {
							worldIn.setBlockState(pos, this.getDefaultState().withProperty(POWERED, false));
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	public double getRepairFactor(int charge) {
		return charge >= 6 ? 0 : charge >= 4 ? 0.33 : charge >= 2 ? 0.66 : 0.99;
	}

	public boolean isItemRepairable(Item i) {
		if (i instanceof ItemSimpleTool || i instanceof ItemShears) {
			return true;
		}
		if (i instanceof ItemSimplePickaxe || i instanceof ItemSimpleAxe || i instanceof ItemSimpleHoe || i instanceof ItemSimpleSpade || i instanceof ItemSimpleSword) {
			return true;
		}
		if (i instanceof ItemPickaxe || i instanceof ItemAxe || i instanceof ItemHoe || i instanceof ItemSpade || i instanceof ItemSword) {
			return true;
		}

		return false;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { POWERED });
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(POWERED) ? 1 : 0;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(POWERED, meta == 1 ? true : false);
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}
}
