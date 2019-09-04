package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ItemDoor extends net.minecraft.item.ItemDoor {

	public ItemDoor(String registryName, Block block) {
		super(block);
		setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		this.setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
}
}
