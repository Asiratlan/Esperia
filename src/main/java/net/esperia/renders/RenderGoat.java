package net.esperia.renders;

import net.esperia.Esperia;
import net.esperia.entity.EntityGoat;
import net.esperia.models.ModelGoat;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGoat extends RenderLiving<EntityGoat>{

	public RenderGoat(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelGoat(), 0.5F);
	}
	
	protected ResourceLocation getGoatTexture(EntityGoat par1EntityBoar) {
        return new ResourceLocation(Esperia.MOD_ID+":textures/entity/goat/goat.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGoat entity) {
		return this.getGoatTexture((EntityGoat) entity);
	}

}