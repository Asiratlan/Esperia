package net.esperia.item;

import java.util.List;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockSpecial extends net.minecraft.item.ItemBlockSpecial {

	public ItemBlockSpecial(String name, Block block, CreativeTabs creativeTabs) {
		super(block);
		setRegistryName(name);
		setUnlocalizedName(Esperia.MOD_ID + "." + name);
		setCreativeTab(creativeTabs);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		super.addInformation(stack, worldIn, tooltip, advanced);
	}
	
	public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
	}
}
