package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHayBall extends net.minecraft.block.BlockRotatedPillar {
    
	public String registryName;

	public BlockHayBall(String registryName)
    {
        super(Material.GRASS, MapColor.YELLOW);
        this.registryName = registryName;
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setHardness(0.5F);
        setSoundType(SoundType.PLANT);
    }

    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
    {
        entityIn.fall(fallDistance, 0.2F);
    }
    
    public void registerItemModel(Item itemBlock) {
  		Esperia.proxy.registerItemRenderer(itemBlock, 0, registryName);
  	}
  	
  	public Item createItemBlock() {
  		return new ItemBlock(this).setRegistryName(getRegistryName());
  	}
}
