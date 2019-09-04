package net.esperia.item;

import net.esperia.Esperia;
import net.esperia.block.BlockCandle;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Item de la note murale.
 *
 * @author Mc-Fr
 */
public class ItemCandle extends net.minecraft.item.ItemBlock {

	public ItemCandle(Block block, String registryName) {
		super(block);
		setRegistryName(Esperia.MOD_ID, registryName + "_item");
		setCreativeTab(CreativeTabs.DECORATIONS);
		setMaxStackSize(16);
	}

	public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
	}

	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return ((BlockCandle) this.block).getUnlocalizedName(stack.getMetadata());
	}
}
