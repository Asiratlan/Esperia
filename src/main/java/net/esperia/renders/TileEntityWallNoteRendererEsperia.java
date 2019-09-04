package net.esperia.renders;

import java.util.List;

import net.esperia.models.ModelWallNote;
import net.esperia.tileentity.TileEntityWallNoteEsperia;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class TileEntityWallNoteRendererEsperia extends TileEntitySpecialRenderer<TileEntityWallNoteEsperia>{

	private static final ResourceLocation SIGN_TEXTURE = new ResourceLocation("esperia",
			"textures/entity/wall_note/wall_note.png");

	/** The ModelSign instance for use in this renderer */
	private final ModelWallNote model = new ModelWallNote();

	@Override
	public void render(TileEntityWallNoteEsperia te, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		int meta = te.getBlockMetadata();
	    float angle = 0;

	    GlStateManager.pushMatrix();

	    if (meta == 2)
	      angle = 180;
	    if (meta == 4)
	      angle = -90;
	    if (meta == 5)
	      angle = 90;

	    GlStateManager.translate((float) x + 0.5f, (float) y + 0.5f, (float) z + 0.5f);
	    GlStateManager.rotate(angle, 0, 1, 0);
	    GlStateManager.translate(0, -0.3125f, -0.49f);

		if (destroyStage >= 0) {
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scale(4.0F, 2.0F, 1.0F);
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		} else {
				this.bindTexture(SIGN_TEXTURE);
		}

		GlStateManager.enableRescaleNormal();
		GlStateManager.pushMatrix();
		float scale = 0.5f;
	    GlStateManager.scale(scale / 2, -scale, -scale);
	    this.model.renderModel();
	    GlStateManager.popMatrix();
	    GlStateManager.translate(0, 0.33333334f, 0.01f);
	    scale = 0.005f;
	    GlStateManager.scale(scale, -scale, scale);
		GlStateManager.glNormal3f(0.0F, 0.0F, -0.010416667F);
		GlStateManager.depthMask(false);
		int i = 0;
		
		FontRenderer fontrenderer = this.getFontRenderer();
		if (destroyStage < 0) {
			for (int j = 0; j < te.signText.length; ++j) {
				if (te.signText[j] != null) {
					ITextComponent itextcomponent = te.signText[j];
					List<ITextComponent> list = GuiUtilRenderComponents.splitText(itextcomponent, 90, fontrenderer,
							false, true);
					String s = list != null && !list.isEmpty() ? ((ITextComponent) list.get(0)).getFormattedText() : "";

					if (j == te.lineBeingEdited) {
						s = "> " + s + " <";

						fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, j * 10 - te.signText.length * 5,
								Integer.parseInt(te.getColor().getHexacode(), 16));
					} else {
						fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, j * 10 - te.signText.length * 5,
								Integer.parseInt(te.getColor().getHexacode(), 16));
					}
				}
			}
		}

		GlStateManager.depthMask(true);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.popMatrix();

		if (destroyStage >= 0) {
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
	}

	
}
