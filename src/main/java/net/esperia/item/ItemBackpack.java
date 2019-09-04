package net.esperia.item;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemBackpack extends net.minecraft.item.ItemArmor {
	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 100, 100, 100, 100 };
	public static final ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("backpack", Esperia.MOD_ID + ":backpack", 5, new int[] { 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

	public ItemBackpack(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String registryName) {
		super(ARMOR, renderIndexIn, equipmentSlotIn);
		setRegistryName(Esperia.MOD_ID, registryName);
		setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
		setCreativeTab(CreativeTabs.COMBAT);
		this.maxStackSize = 1;
		this.setCreativeTab(null);
	}

	public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.openGui(Esperia.instance(), 4, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
		return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}
}
