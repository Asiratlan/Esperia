package net.esperia.renders;

import net.esperia.Esperia;
import net.esperia.entity.EntityBee;
import net.esperia.models.ModelBee;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBee extends RenderLiving<EntityBee> {
	
	private static final ResourceLocation beeTextures = new ResourceLocation("esperia", "textures/entity/bee/bee.png");
	
	public RenderBee(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelBee(), 0.5F);
		this.shadowSize = 0.1F;
	}
/*
	public void renderBee(EntityBee par1EntityBee, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(par1EntityBee, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		this.renderBee((EntityBee) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	/*
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.renderBee((EntityBee) par1Entity, par2, par4, par6, par8, par9);
	}*/

	protected ResourceLocation getBeeTexture(EntityBee par1EntityBoar) {
        return new ResourceLocation(Esperia.MOD_ID+":textures/entity/bee/bee.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBee entity) {
		return this.getBeeTexture((EntityBee) entity);
	}
}
