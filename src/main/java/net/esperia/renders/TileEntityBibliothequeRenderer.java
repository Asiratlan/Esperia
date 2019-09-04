package net.esperia.renders;

import org.lwjgl.opengl.GL11;

import net.esperia.block.BlockBibliotheque;
import net.esperia.models.ModelBibliotheque;
import net.esperia.tileentity.TileEntityBibliotheque;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityBibliothequeRenderer extends TileEntitySpecialRenderer {


	ModelBibliotheque biblioModel;

	public TileEntityBibliothequeRenderer() {
		biblioModel = new ModelBibliotheque();
	}

	public void renderBiblioAt(TileEntityBibliotheque te, double x, double y, double z, float tick) {

		int orientationMeta = (te.getBlockMetadata());
		int angleDegre = 0;
		switch (orientationMeta) {
		case 2:
			angleDegre = 0;
			break;
		case 3:
			angleDegre = 180;
			break;
		case 4:
			angleDegre = 270;
			break;
		case 5:
			angleDegre = 90;
			break;
		}

		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5D, y + 0.75D, z + 0.5D);

		GL11.glRotatef(180, 0F, 0F, 1F);

		GL11.glRotatef(angleDegre, 0.0F, 1.0F, 0.0F);

		int type = te.getBlockMetadata() & 3;
		String bibliotype = ((BlockBibliotheque)te.getBlockType()).type;
		ResourceLocation RES_BIBLIO = new ResourceLocation("esperia", "textures/blocks/bibliotheque_" + bibliotype +".png");
		this.bindTexture(RES_BIBLIO);

		/*
		 * switch(type) { case 0: bindTexture(RES_BIBLIO_OAK); break; case 1:
		 * bindTexture(RES_BIBLIO_SPRUCE); break; case 2:
		 * bindTexture(RES_BIBLIO_BIRCH); break; case 3:
		 * bindTexture(RES_BIBLIO_JUNGLE); break; }
		 */

		this.biblioModel.renderBiblio();

		for (int i = 0; i < te.getSizeInventory(); i++) {
			if (te.hasBook(i)) {
				this.biblioModel.renderLivre(i);
			}
		}

		GL11.glEnable(2896);
		GL11.glPopMatrix();
	}

	@Override
	public void render(TileEntity tileentity, double d, double d1, double d2, float partialTicks,
			int destroyStage, float alpha) {
		renderBiblioAt((TileEntityBibliotheque) tileentity, d, d1, d2, partialTicks);
	}
}
