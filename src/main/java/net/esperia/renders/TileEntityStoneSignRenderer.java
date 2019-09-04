package net.esperia.renders;

import java.util.List;

import net.esperia.tileentity.TileEntityStoneSignEsperia;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.model.ModelSign;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class TileEntityStoneSignRenderer extends TileEntitySpecialRenderer<TileEntityStoneSignEsperia> {
	
	private static final ResourceLocation SIGN_TEXTURE = new ResourceLocation("esperia",
			"textures/blocks/rocksign.png");
	/** The ModelSign instance for use in this renderer */
	private final ModelSign model = new ModelSign();

	public void render(TileEntityStoneSignEsperia te, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
		Block block = te.getBlockType();
		GlStateManager.pushMatrix();
		float f = 0.6666667F;

		if (block == net.esperia.BlocksRegistry.stone_standing_sign) {
			GlStateManager.translate((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
			float f1 = (float) (te.getBlockMetadata() * 360) / 16.0F;
			GlStateManager.rotate(-f1, 0.0F, 1.0F, 0.0F);
			this.model.signStick.showModel = true;
		} else {
			int k = te.getBlockMetadata();
			float f2 = 0.0F;

			if (k == 2) {
				f2 = 180.0F;
			}

			if (k == 4) {
				f2 = 90.0F;
			}

			if (k == 5) {
				f2 = -90.0F;
			}

			GlStateManager.translate((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
			GlStateManager.rotate(-f2, 0.0F, 1.0F, 0.0F);
			GlStateManager.translate(0.0F, -0.3125F, -0.4375F);
			this.model.signStick.showModel = false;
		}

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
		GlStateManager.scale(0.6666667F, -0.6666667F, -0.6666667F);
		this.model.renderSign();
		GlStateManager.popMatrix();
		FontRenderer fontrenderer = this.getFontRenderer();
		float f3 = 0.010416667F;
		GlStateManager.translate(0.0F, 0.33333334F, 0.046666667F);
		GlStateManager.scale(0.010416667F, -0.010416667F, 0.010416667F);
		GlStateManager.glNormal3f(0.0F, 0.0F, -0.010416667F);
		GlStateManager.depthMask(false);
		int i = 0;

		if (destroyStage < 0) {
			for (int j = 0; j < te.signText.length; ++j) {
				if (te.signText[j] != null) {
					ITextComponent itextcomponent = te.signText[j];
					List<ITextComponent> list = GuiUtilRenderComponents.splitText(itextcomponent, 90, fontrenderer,
							false, true);
					String s = list != null && !list.isEmpty() ? ((ITextComponent) list.get(0)).getFormattedText() : "";

					// int color = Integer.parseInt("FFFF40", 16);

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

		GlStateManager.rotate(180, 0, 1, 0);
		GlStateManager.translate(0.0F, 0.0F, 10.0F);

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
