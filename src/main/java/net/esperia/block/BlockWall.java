package net.esperia.block;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.esperia.Esperia;
import net.esperia.util.MultipleItemObject;
import net.esperia.util.SpecialItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWall extends Block implements MultipleItemObject, SpecialItemBlock {

	public static final PropertyEnum<Variants> VARIANT = PropertyEnum.<Variants>create("variant", Variants.class);
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    protected static final AxisAlignedBB[] AABB_BY_INDEX = new AxisAlignedBB[] {new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.0D, 0.0D, 0.25D, 0.75D, 1.0D, 1.0D), new AxisAlignedBB(0.25D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 0.6875D, 0.875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.75D, 1.0D, 1.0D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 1.0D, 0.875D, 0.6875D), new AxisAlignedBB(0.0D, 0.0D, 0.25D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.75D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
    protected static final AxisAlignedBB[] CLIP_AABB_BY_INDEX = new AxisAlignedBB[] {AABB_BY_INDEX[0].setMaxY(1.5D), AABB_BY_INDEX[1].setMaxY(1.5D), AABB_BY_INDEX[2].setMaxY(1.5D), AABB_BY_INDEX[3].setMaxY(1.5D), AABB_BY_INDEX[4].setMaxY(1.5D), AABB_BY_INDEX[5].setMaxY(1.5D), AABB_BY_INDEX[6].setMaxY(1.5D), AABB_BY_INDEX[7].setMaxY(1.5D), AABB_BY_INDEX[8].setMaxY(1.5D), AABB_BY_INDEX[9].setMaxY(1.5D), AABB_BY_INDEX[10].setMaxY(1.5D), AABB_BY_INDEX[11].setMaxY(1.5D), AABB_BY_INDEX[12].setMaxY(1.5D), AABB_BY_INDEX[13].setMaxY(1.5D), AABB_BY_INDEX[14].setMaxY(1.5D), AABB_BY_INDEX[15].setMaxY(1.5D)};

	public BlockWall(Block modelBlock, String registryName, Material material) {
		super(material);
		this.setDefaultState(this.blockState.getBaseState().withProperty(UP, Boolean.valueOf(false)).withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)).withProperty(VARIANT, Variants.NORMAL));       
		setUnlocalizedName(registryName);
		setRegistryName(registryName);
        this.setHardness(20);
        this.setResistance(30 / 3.0F);
        this.setSoundType(modelBlock.getSoundType());
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}


	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
			list.add(new ItemStack(this, 1, 0));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((Variants) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, Variants.byMetadata(meta));
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        state = this.getActualState(state, source, pos);
        return AABB_BY_INDEX[getAABBIndex(state)];
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        blockState = this.getActualState(blockState, worldIn, pos);
        return CLIP_AABB_BY_INDEX[getAABBIndex(blockState)];
    }

    private static int getAABBIndex(IBlockState state)
    {
        int i = 0;

        if (((Boolean)state.getValue(NORTH)).booleanValue())
        {
            i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }

        if (((Boolean)state.getValue(EAST)).booleanValue())
        {
            i |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }

        if (((Boolean)state.getValue(SOUTH)).booleanValue())
        {
            i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }

        if (((Boolean)state.getValue(WEST)).booleanValue())
        {
            i |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }

        return i;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return side == EnumFacing.DOWN ? super.shouldSideBeRendered(blockState, blockAccess, pos, side) : true;
    }

    /**
     * Gets the localized name of this block. Used for the statistics page.
     */
    public String getLocalizedName()
    {
        return I18n.translateToLocal(this.getUnlocalizedName() + "." + Variants.NORMAL.getUnlocalizedName() + ".name");
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

	private boolean canConnectTo(IBlockAccess worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        Block block = iblockstate.getBlock();
        return block == Blocks.BARRIER ? false : (block != this && !(block instanceof BlockFenceGate) ? (block.getMaterial(iblockstate).isOpaque() && iblockstate.isFullCube() ? block.getMaterial(iblockstate) != Material.GOURD : false) : true);
    }
	
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        boolean flag = this.canConnectTo(worldIn, pos.north());
        boolean flag1 = this.canConnectTo(worldIn, pos.east());
        boolean flag2 = this.canConnectTo(worldIn, pos.south());
        boolean flag3 = this.canConnectTo(worldIn, pos.west());
        boolean flag4 = flag && !flag1 && flag2 && !flag3 || !flag && flag1 && !flag2 && flag3;
        return state.withProperty(UP, Boolean.valueOf(!flag4 || !worldIn.isAirBlock(pos.up()))).withProperty(NORTH, Boolean.valueOf(flag)).withProperty(EAST, Boolean.valueOf(flag1)).withProperty(SOUTH, Boolean.valueOf(flag2)).withProperty(WEST, Boolean.valueOf(flag3));
    }


	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Variants) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { UP, NORTH, EAST, WEST, SOUTH, VARIANT });
	}

	@Override
	public int getObjectCount() {
		return Variants.values().length;
	}

	@Override
	public String[] getObjectNames() {
		List<String> variants = Stream.of(Variants.values()).map(Variants::name).collect(Collectors.toList());
		return variants.toArray(new String[variants.size()]);
	}
	
	public void registerItemModel(Item itemBlock) {
			Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath() + "_" + getObjectNames()[0].toLowerCase());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	public static enum Variants implements IStringSerializable {
		NORMAL(0, "normal", "normal"), SUB(1, "sub", "sub");

		private static final BlockWall.Variants[] META_LOOKUP = new BlockWall.Variants[values().length];
		private final int meta;
		private final String name;
		private final String unlocalizedName;

		private Variants(int meta, String name, String unlocalizedName) {
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		public int getMetadata() {
			return this.meta;
		}

		public String toString() {
			return this.name;
		}

		public static Variants byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}

		static {
			for (Variants blockwall$variants : values()) {
				META_LOOKUP[blockwall$variants.getMetadata()] = blockwall$variants;
			}
		}
	}
}
