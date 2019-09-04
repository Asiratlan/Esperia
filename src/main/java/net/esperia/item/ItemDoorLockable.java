package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;

public class ItemDoorLockable extends ItemDoor {

	public ItemDoorLockable(String registryName, Block block) {
		super(block);
		setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		this.setCreativeTab(null);
		// TODO Auto-generated constructor stub
	}
	
	public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
}

}
