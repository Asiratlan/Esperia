package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlass extends net.minecraft.block.BlockGlass {

    public BlockGlass(Material materialIn, boolean ignoreSimilarity, String registryName) {
        super(materialIn, ignoreSimilarity);
        setHardness(2.0F);
        setSoundType(SoundType.GLASS);
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
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
        Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

}
