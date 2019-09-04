package net.esperia.events;

import net.esperia.Esperia;
import net.esperia.capabilities.emoteplayer.EmotePlayerProvider;
import net.esperia.capabilities.emoteplayer.IEmotePlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderModelPlayerEvent {


	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void preRenderLiving(RenderLivingEvent.Specials.Pre<EntityPlayer> event) {
		boolean isThirdPersonFrontal = event.getRenderer().getRenderManager().options.thirdPersonView == 2;
		Entity entity = event.getEntity();
		if (entity instanceof EntityPlayer) {

			if (!Minecraft.getMinecraft().player.isCreative())
				event.setCanceled(true);

			EntityPlayer player = (EntityPlayer) event.getEntity();
			FontRenderer fontRendererIn = event.getRenderer().getFontRendererFromRenderManager();

			IEmotePlayer icone = player.getCapability(EmotePlayerProvider.PLAYER_EMOTE, null);
			if (icone.getEmote() != 0) {
				GlStateManager.pushMatrix();
				GlStateManager.translate(event.getX(), event.getY() + event.getEntity().height + 0.5F, event.getZ());
				GlStateManager.glNormal3f(0.0F, 1.0F, 0.0F);
				GlStateManager.rotate(-event.getRenderer().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
				GlStateManager.rotate(
						(float) (isThirdPersonFrontal ? -1 : 1) * event.getRenderer().getRenderManager().playerViewX,
						1.0F, 0.0F, 0.0F);
				GlStateManager.scale(-0.025F, -0.025F, 0.025F);
				GlStateManager.disableLighting();
				
				int i = 0;
				GlStateManager.disableTexture2D();
				Tessellator tessellator = Tessellator.getInstance();
				BufferBuilder vertexbuffer = tessellator.getBuffer();
				switch (icone.getEmote()) {
				case 1:
					Minecraft.getMinecraft().getTextureManager()
							.bindTexture(new ResourceLocation(Esperia.MOD_ID, "textures/icones/icone_rp.png"));
					break;
				case 2:
					Minecraft.getMinecraft().getTextureManager()
							.bindTexture(new ResourceLocation(Esperia.MOD_ID, "textures/icones/icone_action.png"));
					break;
				case 3:
					Minecraft.getMinecraft().getTextureManager()
							.bindTexture(new ResourceLocation(Esperia.MOD_ID, "textures/icones/icone_hrp.png"));
					break;
				default:
					Minecraft.getMinecraft().getTextureManager()
							.bindTexture(new ResourceLocation(Esperia.MOD_ID, "textures/icones/icone_rp.png"));
					break;
				}
				vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
				vertexbuffer.pos((double) (-12), (double) (-12), 0.0D).tex(0, 0).color(255, 255, 255, 100).endVertex();
				vertexbuffer.pos((double) (-12), (double) (12), 0.0D).tex(0, 1).color(255, 255, 255, 100).endVertex();
				vertexbuffer.pos((double) (12), (double) (12), 0.0D).tex(1, 1).color(255, 255, 255, 100).endVertex();
				vertexbuffer.pos((double) (12), (double) (-12), 0.0D).tex(1, 0).color(255, 255, 255, 100).endVertex();

				GlStateManager.enableTexture2D();
				tessellator.draw();

				if (!player.isSneaking()) {
					GlStateManager.enableDepth();
				}
				
				GlStateManager.enableLighting();
				GlStateManager.disableBlend();
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				GlStateManager.popMatrix();
			}
		}
	}
}
