package net.esperia.item;

import net.esperia.Esperia;
import net.esperia.block.BlockStalactite;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Item de la note murale.
 *
 * @author Mc-Fr
 */
public class ItemStalactite extends net.minecraft.item.ItemBlock {

	public ItemStalactite(Block block, String registryName) {
		super(block);
		setRegistryName(Esperia.MOD_ID, registryName);
		setCreativeTab(CreativeTabs.DECORATIONS);
		setMaxStackSize(16);
	}
	
	public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return ((BlockStalactite)this.block).getUnlocalizedName(stack.getMetadata());
    }
    
    public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
	}
}
