package net.esperia.item.tools;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemSimplePickaxe extends ItemPickaxe {

    public String registryName;

    public ItemSimplePickaxe(String registryName,ToolMaterial material) {
        super(material);
        this.registryName = registryName;
        setRegistryName(Esperia.MOD_ID, registryName);
        setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        setCreativeTab(CreativeTabs.TOOLS);
    }
@Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {

        if (itemStack.getItemDamage() == itemStack.getMaxDamage()) {
            return ItemStack.EMPTY;
        } else {
            return new ItemStack(itemStack.getItem(), itemStack.getCount(), (itemStack.getItemDamage() + 1));
        }
    }
    public void registerItemModel() {
        Esperia.proxy.registerItemRenderer(this, 0, registryName);
    }

}
