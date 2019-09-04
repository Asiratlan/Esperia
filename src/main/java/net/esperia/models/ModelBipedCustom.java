package net.esperia.models;

import net.esperia.capabilities.playerposition.IPlayerPosition;
import net.esperia.capabilities.playerposition.PlayerPositionProvider;
import net.esperia.enumerator.EnumPosition;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBipedCustom extends ModelBiped {

	public ModelBipedCustom() {
		this(0.0F);
	}

	public ModelBipedCustom(float modelSize) {
		this(modelSize, 0.0F, 64, 32);
	}

	public ModelBipedCustom(float modelSize, float p_i1149_2_, int textureWidthIn, int textureHeightIn) {
		super(modelSize, p_i1149_2_, textureWidthIn, textureHeightIn);
	}

	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}

	/**
	 * Sets the model's various rotation angles. For bipeds, par1 and par2 are
	 * used for animating the movement of arms and legs, where par1 represents
	 * the time(so that arms and legs swing back and forth) and par2 represents
	 * how "far" arms and legs can swing at most.
	 */
	@SuppressWarnings("incomplete-switch")
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		IPlayerPosition position = entityIn.getCapability(PlayerPositionProvider.POSITION_CAP, null);

		float f = 1.0F;

		if (f < 1.0F) {
			f = 1.0F;
		}

		float legModifier = 0.0F;
		float armModifier = 0.0F;
		if (position.getEnumPosition().equals(EnumPosition.LAY)) {
			legModifier = 8.0F;
			armModifier = 8.0F;
		} else if (position.getEnumPosition().equals(EnumPosition.FACEDOWN)) {
			legModifier = 5.0F;
			// armModifier = 2.0F;
		}

		// Pour afficher le joueur assis - couch� - sur le ventre
		// IPlayerPosition position =
		// entityIn.getCapability(PlayerPositionProvider.POSITION_CAP, null);
		if (position != null) {
			if (position.getEnumPosition().equals(EnumPosition.SIT)) {
				this.bipedRightArm.rotateAngleX += -((float) Math.PI / 5F);
				this.bipedLeftArm.rotateAngleX += -((float) Math.PI / 5F);
				this.bipedRightLeg.rotateAngleX = -1.4137167F;
				this.bipedRightLeg.rotateAngleY = ((float) Math.PI / 10F);
				this.bipedRightLeg.rotateAngleZ = 0.07853982F;
				this.bipedLeftLeg.rotateAngleX = -1.4137167F;
				this.bipedLeftLeg.rotateAngleY = -((float) Math.PI / 10F);
				this.bipedLeftLeg.rotateAngleZ = -0.07853982F;
			} else if (position.getEnumPosition().equals(EnumPosition.LAY)) {

				this.bipedBody.rotateAngleX += -((float) Math.PI / 4F);
				this.bipedRightArm.rotationPointZ -= 1.7F;
				this.bipedRightArm.rotationPointY -= 1.3F;
				this.bipedRightArm.rotationPointX -= 0.3F;
				this.bipedRightArm.rotateAngleX += -((float) (2 * Math.PI) / 3F);
				this.bipedRightArm.rotateAngleY += 0.05F;
				this.bipedLeftArm.rotationPointZ -= 1.7F;
				this.bipedLeftArm.rotationPointY -= 1.3F;
				this.bipedLeftArm.rotationPointX += 0.3F;
				this.bipedLeftArm.rotateAngleX += -((float) (2 * Math.PI) / 3F);
				this.bipedLeftArm.rotateAngleY -= 0.05F;
				this.bipedRightLeg.rotationPointY -= 6.0F;
				this.bipedLeftLeg.rotationPointY -= 6.0F;
				this.bipedRightLeg.rotationPointZ -= 6.15F;
				this.bipedLeftLeg.rotationPointZ -= 6.15F;
				this.bipedRightLeg.rotateAngleX += -((float) Math.PI / 2F);
				this.bipedLeftLeg.rotateAngleX += -((float) Math.PI / 2F);
			} else if (position.getEnumPosition().equals(EnumPosition.FACEDOWN)) {
				this.bipedBody.rotateAngleX -= -((float) Math.PI / 4F);
				this.bipedRightArm.rotationPointZ += 1.7F;
				this.bipedRightArm.rotationPointY -= 1.3F;
				this.bipedRightArm.rotationPointX += 0.3F;
				this.bipedRightArm.rotateAngleX += -((float) (2 * Math.PI) / 3F);
				this.bipedRightArm.rotateAngleY -= 0.05F;
				this.bipedLeftArm.rotationPointZ += 1.7F;
				this.bipedLeftArm.rotationPointY -= 1.3F;
				this.bipedLeftArm.rotationPointX -= 0.3F;
				this.bipedLeftArm.rotateAngleX += -((float) (2 * Math.PI) / 3F);
				this.bipedLeftArm.rotateAngleY += 0.05F;
				this.bipedRightLeg.rotationPointY -= 6.0F;
				this.bipedLeftLeg.rotationPointY -= 6.0F;
				this.bipedRightLeg.rotationPointZ += 6.15F;
				this.bipedLeftLeg.rotationPointZ += 6.15F;
				this.bipedRightLeg.rotateAngleX -= -((float) Math.PI / 2F);
				this.bipedLeftLeg.rotateAngleX -= -((float) Math.PI / 2F);

			}
		}
	}

	public void setInvisible(boolean invisible) {
		this.bipedHead.showModel = invisible;
		this.bipedHeadwear.showModel = invisible;
		this.bipedBody.showModel = invisible;
		this.bipedRightArm.showModel = invisible;
		this.bipedLeftArm.showModel = invisible;
		this.bipedRightLeg.showModel = invisible;
		this.bipedLeftLeg.showModel = invisible;
	}

	public void setModelAttributes(ModelBase model) {
		super.setModelAttributes(model);

		if (model instanceof ModelBipedCustom) {
			ModelBipedCustom modelbiped = (ModelBipedCustom) model;
			this.leftArmPose = modelbiped.leftArmPose;
			this.rightArmPose = modelbiped.rightArmPose;
			this.isSneak = modelbiped.isSneak;
		}
	}

}