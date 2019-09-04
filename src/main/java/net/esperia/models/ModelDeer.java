// Date: 10/09/2017 20:32:12
package net.esperia.models;

import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelDeer extends ModelQuadruped {
	// fields
	ModelRenderer neck;
	ModelRenderer front_right_2;
	ModelRenderer front_right_3;
	ModelRenderer front_left_2;
	ModelRenderer front_left_3;
	ModelRenderer behind_right_2;
	ModelRenderer behind_right_3;
	ModelRenderer behind_left_2;
	ModelRenderer behind_left_3;
	ModelRenderer tail;
	ModelRenderer horn_left;
	ModelRenderer horn_right;
    ModelRenderer ear_left;
    ModelRenderer ear_right;

	public ModelDeer() {
		super(12, 0.0F);
		body = new ModelRenderer(this, 0, 0);
	      body.addBox(-3F, 0F, 0F, 6, 8, 16);
	      body.setRotationPoint(0F, 5F, -7F);
	      body.setTextureSize(64, 32);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      neck = new ModelRenderer(this, 0, 0);
	      neck.addBox(-2F, -10F, -2F, 4, 9, 4);
	      neck.setRotationPoint(0F, 9F, -6F);
	      neck.setTextureSize(64, 32);
	      neck.mirror = true;
	      setRotation(neck, 0.2617994F, 0F, 0F);
	      head = new ModelRenderer(this, 28, 0);
	      head.addBox(-3F, -2F, -5F, 5, 4, 7);
	      head.setRotationPoint(0.5F, -1F, -8F);
	      head.setTextureSize(64, 32);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      leg1 = new ModelRenderer(this, 52, 23);
	      leg1.addBox(-1F, -2F, -2F, 2, 5, 4);
	      leg1.setRotationPoint(-3F, 12F, -4.9F);
	      leg1.setTextureSize(64, 32);
	      leg1.mirror = true;
	      setRotation(leg1, 0F, 0F, 0F);
	      front_right_2 = new ModelRenderer(this, 54, 16);
	      front_right_2.addBox(-1F, 0F, -2F, 2, 4, 3);
	      front_right_2.setRotationPoint(-3F, 15F, -4.9F);
	      front_right_2.setTextureSize(64, 32);
	      front_right_2.mirror = true;
	      setRotation(front_right_2, 0F, 0F, 0F);
	      front_right_3 = new ModelRenderer(this, 56, 9);
	      front_right_3.addBox(-1F, 0F, -1F, 2, 5, 2);
	      front_right_3.setRotationPoint(-3F, 19F, -5.9F);
	      front_right_3.setTextureSize(64, 32);
	      front_right_3.mirror = true;
	      setRotation(front_right_3, 0F, 0F, 0F);
	      leg2.mirror = true;
	      leg2 = new ModelRenderer(this, 52, 23);
	      leg2.addBox(-1F, -2F, -2F, 2, 5, 4);
	      leg2.setRotationPoint(3F, 12F, -4.9F);
	      leg2.setTextureSize(64, 32);
	      leg2.mirror = true;
	      setRotation(leg2, 0F, 0F, 0F);
	      leg2.mirror = false;
	      front_left_2 = new ModelRenderer(this, 54, 16);
	      front_left_2.addBox(-1F, 0F, -2F, 2, 4, 3);
	      front_left_2.setRotationPoint(3F, 15F, -4.9F);
	      front_left_2.setTextureSize(64, 32);
	      front_left_2.mirror = true;
	      setRotation(front_left_2, 0F, 0F, 0F);
	      front_left_2.mirror = false;
	      front_left_3 = new ModelRenderer(this, 56, 9);
	      front_left_3.addBox(-1F, 0F, -1F, 2, 5, 2);
	      front_left_3.setRotationPoint(3F, 19F, -5.9F);
	      front_left_3.setTextureSize(64, 32);
	      front_left_3.mirror = true;
	      setRotation(front_left_3, 0F, 0F, 0F);
	      front_left_3.mirror = false;
	      leg3 = new ModelRenderer(this, 40, 23);
	      leg3.addBox(-1F, -2F, -2F, 2, 5, 4);
	      leg3.setRotationPoint(-3F, 12F, 6F);
	      leg3.setTextureSize(64, 32);
	      leg3.mirror = true;
	      setRotation(leg3, 0F, 0F, 0F);
	      behind_right_2 = new ModelRenderer(this, 44, 16);
	      behind_right_2.addBox(-1F, 0F, -2F, 2, 4, 3);
	      behind_right_2.setRotationPoint(-3F, 15F, 6F);
	      behind_right_2.setTextureSize(64, 32);
	      behind_right_2.mirror = true;
	      setRotation(behind_right_2, 0F, 0F, 0F);
	      behind_right_3 = new ModelRenderer(this, 32, 25);
	      behind_right_3.addBox(-1F, 0F, -1F, 2, 5, 2);
	      behind_right_3.setRotationPoint(-3F, 19F, 6F);
	      behind_right_3.setTextureSize(64, 32);
	      behind_right_3.mirror = true;
	      setRotation(behind_right_3, 0F, 0F, 0F);
	      leg4.mirror = true;
	      leg4 = new ModelRenderer(this, 40, 23);
	      leg4.addBox(-1F, -2F, -2F, 2, 5, 4);
	      leg4.setRotationPoint(3F, 12F, 6F);
	      leg4.setTextureSize(64, 32);
	      leg4.mirror = true;
	      setRotation(leg4, 0F, 0F, 0F);
	      leg4.mirror = false;
	      behind_left_2 = new ModelRenderer(this, 44, 16);
	      behind_left_2.addBox(-1F, 0F, -2F, 2, 4, 3);
	      behind_left_2.setRotationPoint(3F, 15F, 6F);
	      behind_left_2.setTextureSize(64, 32);
	      behind_left_2.mirror = true;
	      setRotation(behind_left_2, 0F, 0F, 0F);
	      behind_left_3 = new ModelRenderer(this, 32, 25);
	      behind_left_3.addBox(-1F, 0F, -1F, 2, 5, 2);
	      behind_left_3.setRotationPoint(3F, 19F, 6F);
	      behind_left_3.setTextureSize(64, 32);
	      behind_left_3.mirror = true;
	      setRotation(behind_left_3, 0F, 0F, 0F);
	      tail = new ModelRenderer(this, 54, 0);
	      tail.addBox(-2F, 0F, 0F, 4, 5, 1);
	      tail.setRotationPoint(0F, 5F, 9F);
	      tail.setTextureSize(64, 32);
	      tail.mirror = true;
	      setRotation(tail, 0.2617994F, 0F, 0F);
	      horn_left = new ModelRenderer(this, 0, 24);
	      horn_left.addBox(0F, -8F, 0F, 8, 8, 0);
	      horn_left.setRotationPoint(2F, -3F, -8F);
	      horn_left.setTextureSize(64, 32);
	      horn_left.mirror = false;
	      setRotation(horn_left, 0F, -0.5235988F, 0F);
	      horn_right = new ModelRenderer(this, 0, 24);
	      horn_right.addBox(-8F, -8F, 0F, 8, 8, 0);
	      horn_right.setRotationPoint(-2F, -3F, -8F);
	      horn_right.setTextureSize(64, 32);
	      horn_right.mirror = false;
	      setRotation(horn_right, 0F, 0.5235988F, 0F);
	      ear_left = new ModelRenderer(this, 16, 26);
	      ear_left.addBox(0F, -1F, 0F, 0, 3, 3);
	      ear_left.setRotationPoint(2.5F, -3F, -6F);
	      ear_left.setTextureSize(64, 32);
	      ear_left.mirror = true;
	      setRotation(ear_left, 0F, 0.7853982F, 0F);
	      ear_left.mirror = false;
	      ear_right = new ModelRenderer(this, 16, 26);
	      ear_right.addBox(0F, 0F, 0F, 0, 3, 3);
	      ear_right.setRotationPoint(-2.5F, -4F, -6F);
	      ear_right.setTextureSize(64, 32);
	      ear_right.mirror = true;
	      setRotation(ear_right, 0F, -0.7853982F, 0F);
	      ear_right.mirror = false;
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body.render(f5);
		neck.render(f5);
		head.render(f5);
		leg1.render(f5);
		front_right_2.render(f5);
		front_right_3.render(f5);
		leg2.render(f5);
		front_left_2.render(f5);
		front_left_3.render(f5);
		leg3.render(f5);
		behind_right_2.render(f5);
		behind_right_3.render(f5);
		leg4.render(f5);
		behind_left_2.render(f5);
		behind_left_3.render(f5);
		tail.render(f5);
		horn_left.render(f5);
		horn_right.render(f5);
	    ear_left.render(f5);
	    ear_right.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entityIn) {
		this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		
		this.front_left_2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.front_right_2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.behind_left_2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.behind_right_2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		
		this.front_left_3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.front_right_3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.behind_left_3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.behind_right_3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		
		float baseAngle = 0.5235988F + f4 / (180F / (float) Math.PI);

		if (f3 > 20.0F) {
			f3 = 20.0F;
		}

		if (f3 < -20.0F) {
			f3 = -20.0F;
		}

        this.head.rotateAngleX = f4 * 0.017453292F;
        this.head.rotateAngleY = f3 * 0.017453292F;
        //this.body.rotateAngleX = ((float)Math.PI / 2F);
		//this.neck.rotateAngleX = -0.5235988F;
		//this.tail.rotateAngleX = (f3 / 4) / (180F / (float) Math.PI);
		//this.head.rotateAngleX = baseAngle;

		this.horn_right.rotateAngleX = this.head.rotateAngleX;
		this.horn_left.rotateAngleX = this.head.rotateAngleX;

		this.horn_right.rotateAngleY = this.head.rotateAngleY;
		this.horn_left.rotateAngleY = this.head.rotateAngleY;
		
		this.ear_left.rotateAngleX = this.head.rotateAngleX;
		this.ear_left.rotateAngleX = this.head.rotateAngleX;

		this.ear_right.rotateAngleY = this.head.rotateAngleY;
		this.ear_right.rotateAngleY = this.head.rotateAngleY;
	}
	/*
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }*/
}
