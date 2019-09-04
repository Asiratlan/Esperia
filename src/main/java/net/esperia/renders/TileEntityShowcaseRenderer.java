package net.esperia.renders;

import com.jcraft.jorbis.Block;

import net.esperia.block.BlockShowcase;
import net.esperia.tileentity.TileEntityShowcase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

public class TileEntityShowcaseRenderer extends TileEntitySpecialRenderer<TileEntityShowcase> {
	@Override
	public void render(TileEntityShowcase te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		if (te == null)
			return;

		ItemStack displayedStack = te.displayedStack;

		if (!displayedStack.isEmpty()) {
			GlStateManager.pushMatrix();
			//float xValue = facing == EnumFacing.SOUTH || facing == EnumFacing.NORTH ? 0.4F : 0.4F;
			float yValue = displayedStack.getItem() instanceof ItemBlock ? 0.075F : -0.025F;
			//float zValue = facing == EnumFacing.SOUTH || facing == EnumFacing.NORTH ? 0.4F : 0.4F;

			GlStateManager.translate(x + 0.5, y + yValue, z + 0.5);
			
			if (!Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(displayedStack, getWorld(), null).isGui3d()) {
				GlStateManager.translate(0, 0.2, 0);
			}
			
			EnumFacing facing = Minecraft.getMinecraft().world.getBlockState(te.getPos()).getValue(BlockShowcase.FACING);
			float angle = facing.getHorizontalAngle() * -1;
		
			//Y Rotation According to the Facing of the block
			GlStateManager.rotate(angle, 0, 1, 0);	
			//Rotation to match the surface of the Display Case
			GlStateManager.rotate(290, 1, 0, 0);
			GlStateManager.translate(0, -0.0125, 0.06);

			try {
				
				Minecraft.getMinecraft().getRenderItem().renderItem(displayedStack, ItemCameraTransforms.TransformType.GROUND);
			} catch (Exception oof) {
				//SimpleTrophies.LOG.error("Problem rendering item on a trophy TESR", oof);
			}

			GlStateManager.enableBlend(); // fix a stateleak in renderitem >.>

			GlStateManager.popMatrix();
		}

		RayTraceResult hit = rendererDispatcher.cameraHitResult;
		if (hit != null && te.getPos().equals(hit.getBlockPos())) {
			setLightmapDisabled(true);
			
			String name = te.getLocalizedName();
			if (!name.isEmpty()) {
				drawNameplate(te, name, x, y, z, 12);
			}

			setLightmapDisabled(false);
		}
	}
}
