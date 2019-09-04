package net.esperia.renders;

import net.esperia.tileentity.TileEntityBibliotheque;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;

public class TileEntityInventoryRenderHelper extends TileEntityItemStackRenderer {

	private TileEntityBibliotheque tileEntityBibliotheque = new TileEntityBibliotheque();

	@Override
	public void renderByItem(ItemStack itemStack) {
		/* Block block = Block.getBlockFromItem(itemStack.getItem());

		if (block != null && block.equals(net.esperia.Blocks.bibliotheque)) {

			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.tileEntityBibliotheque, 0.0D, 0.0D, 0.0D, 0.0F);

		} else {*/
			super.renderByItem(itemStack);

		//}

	}

}
