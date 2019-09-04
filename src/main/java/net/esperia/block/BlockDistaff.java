package net.esperia.block;

import java.util.Random;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.minecraft.block.BlockAir;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDistaff extends net.minecraft.block.BlockReed {
	
    public static final PropertyBool TOP = PropertyBool.create("top");

	public BlockDistaff(String registryName){
		super();
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {		
		return state.withProperty(TOP, world.getBlockState(pos.up()).getBlock() instanceof BlockAir);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { AGE, TOP });
	}
	

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.addIgnoreToModel(BlocksRegistry.distaff, this.AGE);
		Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
	}
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return new ItemStack(BlocksRegistry.distaff, 0,0).getItem();
    }
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		
		return new ItemStack(BlocksRegistry.distaff);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (worldIn.getBlockState(pos.down()).getBlock() == BlocksRegistry.distaff || this.checkForDrop(worldIn, pos, state))
        {
            if (worldIn.isAirBlock(pos.up()))
            {
                int i;

                for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i)
                {
                    ;
                }

                if (i < 2)
                {
                    int j = ((Integer)state.getValue(AGE)).intValue();

                    if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true))
                    {
                    if (j == 15)
                    {
                        worldIn.setBlockState(pos.up(), this.getDefaultState());
                        worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 4);
                    }
                    else
                    {
                        worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 4);
                    }
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                    }
                }
            }
        }
    }
}
