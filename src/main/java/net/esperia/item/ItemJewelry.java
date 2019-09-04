package net.esperia.item;

import net.esperia.Esperia;
import net.esperia.itemcontainer.InventaireJewelry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemJewelry extends ItemContainer {

	private String[] jewelries = { "necklace", "ring", "bracelet", "earring" };

	public ItemJewelry(String registryName) {
		super(registryName, 9);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			for (int i = 0; i < jewelries.length; i++) {
				items.add(new ItemStack(this, 1, i));
			}
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.openGui(Esperia.instance(), 13, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
		return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	public static void setInventory(ItemStack item, IInventory content) {
		// Small Fail Safe, must have a size of 9
		if (content.getSizeInventory() == 9) {
			NBTTagCompound comp = new NBTTagCompound();
			NBTTagList nbtlist = new NBTTagList();
			for (int i = 0; i < 9; i++) {
				ItemStack stack = content.getStackInSlot(i).copy();
				stack.setCount(1);
				if (!(stack.getItem() instanceof ItemSimpleTool)) {
					if (stack.getItem() instanceof ItemContainer) {
						if (stack.hasTagCompound()) {
							NBTTagList empty = new NBTTagList();
							stack.getTagCompound().setTag("Inventory", empty);
						}
					}
					NBTTagCompound comp1 = new NBTTagCompound();
					comp1.setInteger("Slot", i);
					stack.writeToNBT(comp1);
					nbtlist.appendTag(comp1);
				}
			}
			comp.setTag("Inventory", nbtlist);
			item.setTagCompound(comp);
		}
	}

	public void registerItemModel() {
		for (int i = 0; i < jewelries.length; i++) {
			Esperia.proxy.registerItemRenderer(this, i, this.getRegistryName().getResourcePath() + "_" + jewelries[i]);
		}
	}

	public String getUnlocalizedName(ItemStack stack) {
		return this.getRegistryName().getResourcePath() + "." + jewelries[stack.getMetadata()];
	}

}
