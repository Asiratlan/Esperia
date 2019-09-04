package net.esperia.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelBee extends ModelBase {
	// fields
	ModelRenderer wing1;
	ModelRenderer wing2;
	ModelRenderer wing3;
	ModelRenderer wing4;
	ModelRenderer head;
	ModelRenderer abdomen;
	ModelRenderer antenna2;
	ModelRenderer antenna1;
	ModelRenderer stinger;

	public ModelBee() {
		textureWidth = 64;
		textureHeight = 32;

		wing1 = new ModelRenderer(this, 0, 3);
		wing1.addBox(0F, 0F, 0F, 1, 0, 2);
		wing1.setRotationPoint(0F, 23F, -0.9F);
		wing1.setTextureSize(64, 32);
		setRotation(wing1, 0.837758F, 0.4363323F, 0.4014257F);
		wing2 = new ModelRenderer(this, 0, 3);
		wing2.addBox(-1F, 0F, 0F, 1, 0, 2);
		wing2.setRotationPoint(0F, 22.96667F, -0.9F);
		wing2.setTextureSize(64, 32);
		setRotation(wing2, 0.837758F, -0.4363323F, -0.4014257F);
		wing3 = new ModelRenderer(this, 6, 3);
		wing3.addBox(0F, 0F, 0F, 1, 0, 1);
		wing3.setRotationPoint(0.2F, 22.9F, -0.7F);
		wing3.setTextureSize(64, 32);
		setRotation(wing3, 0.5585054F, 0F, 0.3490659F);
		wing4 = new ModelRenderer(this, 6, 3);
		wing4.addBox(-1F, 0F, 0F, 1, 0, 1);
		wing4.setRotationPoint(-0.2F, 22.9F, -0.7F);
		wing4.setTextureSize(64, 32);
		setRotation(wing4, 0.5585054F, 0F, -0.3490659F);
		head = new ModelRenderer(this, 4, 0);
		head.addBox(-0.5F, 0F, -1F, 1, 1, 1);
		head.setRotationPoint(0F, 23F, -1.1F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		abdomen = new ModelRenderer(this, 0, 0);
		abdomen.addBox(-0.5F, 0F, -1F, 1, 1, 2);
		abdomen.setRotationPoint(0F, 23F, 0F);
		abdomen.setTextureSize(64, 32);
		setRotation(abdomen, 0F, 0F, 0F);
		antenna2 = new ModelRenderer(this, 8, 0);
		antenna2.addBox(-0.4F, 0F, -2F, 0, 1, 1);
		antenna2.setRotationPoint(0F, 22F, -1.1F);
		antenna2.setTextureSize(64, 32);
		setRotation(antenna2, 0F, 0F, 0F);
		antenna1 = new ModelRenderer(this, 8, 0);
		antenna1.addBox(0.4F, 0F, -2F, 0, 1, 1);
		antenna1.setRotationPoint(0F, 22F, -1.1F);
		antenna1.setTextureSize(64, 32);
		setRotation(antenna1, 0F, 0F, 0F);
		stinger = new ModelRenderer(this, 6, 4);
		stinger.addBox(0F, 0F, 1.8F, 0, 1, 1);
		stinger.setRotationPoint(0F, 22.7F, -1.1F);
		stinger.setTextureSize(64, 32);
		setRotation(stinger, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		wing1.render(f5);
		wing2.render(f5);
		wing3.render(f5);
		wing4.render(f5);
		head.render(f5);
		abdomen.render(f5);
		antenna2.render(f5);
		antenna1.render(f5);
		stinger.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		this.wing1.rotateAngleX = MathHelper.cos(f2 * 2F) / 3F + 19F;
		this.wing3.rotateAngleX = MathHelper.cos(f2 * 2F) / 3F + 19F;
		this.wing2.rotateAngleX = MathHelper.cos(f2 * 2F) / 3F + 19F;
		this.wing4.rotateAngleX = MathHelper.cos(f2 * 2F) / 3F + 19F;
	}
}
