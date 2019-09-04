package net.esperia.renders;

import net.esperia.Esperia;
import net.esperia.entity.EntityBoar;
import net.esperia.models.ModelBoar;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBoar extends RenderLiving<EntityBoar> {

	private static final ResourceLocation sanglierTextures = new ResourceLocation("esperia",
			"textures/entity/boar/boar.png");
	private static final ResourceLocation sanglierTextures_1 = new ResourceLocation("esperia",
			"textures/entity/boar/boar_1.png");
	private static final ResourceLocation sanglierTextures_2 = new ResourceLocation("esperia",
			"textures/entity/boar/boar_2.png");
	private static final ResourceLocation sanglierTextures_3 = new ResourceLocation("esperia",
			"textures/entity/boar/boar_3.png");

	public RenderBoar(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelBoar(), 0.5F);
		// setRenderPassModel(modelbase1);
	}

	protected ResourceLocation getSanglierTextures(EntityBoar par1EntityBoar) {
        return new ResourceLocation(Esperia.MOD_ID+":textures/entity/boar/boar.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBoar entity) {
		return this.getSanglierTextures((EntityBoar) entity);
	}
}
