package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.common.util.EnumHelper;

public class ItemChain extends net.minecraft.item.ItemArmor {
	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };
	public static final ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("chains", Esperia.MOD_ID + ":chains", 5,
			new int[] { 1, 3, 2, 1 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F);

	public ItemChain(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String registryName) {
		super(ARMOR, renderIndexIn, equipmentSlotIn);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		setCreativeTab(CreativeTabs.COMBAT);
	}
	
	public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
}
}
