package net.esperia.block;

import java.util.Random;

import net.esperia.Esperia;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockOre extends net.minecraft.block.BlockOre {

    private Item item;
    private int minDrop = 0;
    private int maxDrop = 0;

    public BlockOre(String registryName, Item item) {
        super(Material.ROCK.getMaterialMapColor());
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setHardness(3.0F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        this.item = item;
        this.minDrop = 1;
        this.maxDrop = 1;
    }

    public BlockOre(String registryName, Item item, int minDrop, int maxDrop) {
        super(Material.ROCK.getMaterialMapColor());
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setHardness(3.0F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        this.item = item;
        this.minDrop = minDrop;
        this.maxDrop = maxDrop;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return item;
    }

    @Override
    public int quantityDropped(Random random) {
        return random.nextInt(maxDrop) + minDrop;
    }

    public void registerItemModel(Item itemBlock) {
        Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

}
