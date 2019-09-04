package net.esperia.block;

import net.esperia.Esperia;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockButton extends net.minecraft.block.BlockButton {

	private boolean wooden;

	public BlockButton(boolean wooden, String name) {
		super(wooden);
		this.wooden = wooden;
		setRegistryName(Esperia.MOD_ID, name);
		setUnlocalizedName(Esperia.MOD_ID + "." + name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public void playClickSound(EntityPlayer player, World worldIn, BlockPos pos) {
		worldIn.playSound(player, pos, wooden ? SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);

	}

	@Override
	public void playReleaseSound(World worldIn, BlockPos pos) {
		worldIn.playSound((EntityPlayer) null, pos, wooden ? SoundEvents.BLOCK_WOOD_BUTTON_CLICK_OFF : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);

	}
	
	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

}
