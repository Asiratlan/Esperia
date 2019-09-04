package net.esperia.renders;

import net.esperia.Esperia;
import net.esperia.entity.EntityFox;
import net.esperia.models.ModelFox;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFox extends RenderLiving<EntityFox>
{
    public RenderFox(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelFox(), 0.3F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityFox entity)
    {
        return new ResourceLocation(Esperia.MOD_ID+":textures/entity/fox/fox.png");
    }
}