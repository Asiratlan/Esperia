package net.esperia.renders;

import net.esperia.Esperia;
import net.esperia.entity.EntityDeer;
import net.esperia.models.ModelDeer;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDeer extends RenderLiving<EntityDeer>
{
    public RenderDeer(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelDeer(), 0.3F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityDeer entity)
    {
        return new ResourceLocation(Esperia.MOD_ID+":textures/entity/deer/deer.png");
    }
}