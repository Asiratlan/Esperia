package net.esperia.block;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.esperia.util.MultipleItemObject;
import net.esperia.util.SpecialItemBlock;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockStoneSlab extends BlockSlab implements MultipleItemObject, SpecialItemBlock {

	private static final PropertyEnum<Variants> VARIANT = PropertyEnum.create("color", Variants.class);

	public BlockStoneSlab(Material materialIn, SoundType sound, String registryName) {
		super(materialIn);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setSoundType(sound);
        setHardness(1.25F);
        setResistance(7.0F);
        useNeighborBrightness = true;
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName() + "." + Variants.values()[meta];
	}

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		return VARIANT;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return Variants.byMetadata(stack.getMetadata());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		for (Variants variant : Variants.values())
        {
			list.add(new ItemStack(this, 1, variant.getMetadata()));
        }
	}
	
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(BlocksRegistry.stone_slab);
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(BlocksRegistry.stone_slab, 1, ((Variants) state.getValue(VARIANT)).getMetadata());
	}

	public IBlockState getStateFromMeta(int meta) {

		IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, Variants.byMetadata(meta & 7));

		if (!this.isDouble()) {
			iblockstate = iblockstate.withProperty(HALF,
					(meta & 8) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);
		}

		return iblockstate;
	}

	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((Variants) state.getValue(VARIANT)).getMetadata();

		if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
			i |= 8;
		}

		return i;
	}

	public void registerItemModel(Item itemBlock) {
		for (int meta = 0; meta < getObjectCount(); meta++) {
			Esperia.proxy.registerItemRenderer(itemBlock, meta, getRegistryName().getResourcePath() + "_" + getObjectNames()[meta].toLowerCase());
		}
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	protected BlockStateContainer createBlockState() {
		return this.isDouble() ? new BlockStateContainer(this, new IProperty[] { VARIANT })
				: new BlockStateContainer(this, new IProperty[] { HALF, VARIANT });
	}

	public int damageDropped(IBlockState state) {
		return ((Variants) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	public int getObjectCount() {
		return Variants.values().length;
	}

	@Override
	public String[] getObjectNames() {
		List<String> colors = Stream.of(Variants.values()).map(Variants::name).collect(Collectors.toList());
		return colors.toArray(new String[colors.size()]);
	}

	public static class Double extends BlockStoneSlab {
		public Double(Material materialIn, SoundType sound, String registryName) {
			super(materialIn, sound,  registryName);
		}

		public boolean isDouble() {
			return true;
		}
	}

	public static class Half extends BlockStoneSlab {
		public Half(Material materialIn, SoundType sound, String registryName) {
			super(materialIn, sound, registryName);
		}

		public boolean isDouble() {
			return false;
		}
	}

	public enum Variants implements IStringSerializable {
		SLATE(0, "slate"), 
		DIORITE(1, "diorite"), ANDESITE(2, "andesite"), GRANITE(3, "granite"),
		DIOBRICK(4, "diobrick"), ANDEBRICK(5, "andebrick"), GRABRICK(6, "grabrick");

		private final int meta;
		private final String name;
		private static final Variants[] META_LOOKUP = new Variants[values().length];

		private Variants(int meta, String name) {
			this.name = name;
			this.meta = meta;
		}

		@Override
		public String getName() {
			return name;
		}

		public int getMetadata() {
			return this.meta;
		}

		static {
			for (Variants enumdyecolor : values()) {
				META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
			}
		}

		public static Variants byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}
	}

}
