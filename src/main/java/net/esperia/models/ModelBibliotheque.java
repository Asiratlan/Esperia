package net.esperia.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBibliotheque extends ModelBase {

	public static final int NUM_LIVRES = 16;
	ModelRenderer back;
	ModelRenderer left;
	ModelRenderer shelf;
	ModelRenderer right;
	ModelRenderer top;
	ModelRenderer bottom;
	ModelRenderer[] books = new ModelRenderer[NUM_LIVRES];

	public ModelBibliotheque() {
		textureWidth = 256;
		textureHeight = 128;

		back = new ModelRenderer(this, 0, 0);
		back.addBox(0F, 0F, -2F, 32, 32, 18);
		back.setRotationPoint(-16F, -8F, 0F);
		back.setTextureSize(256, 128);
		back.mirror = true;
		setRotation(back, 0F, 0F, 0F);
		left = new ModelRenderer(this, 100, 0);
		left.addBox(31F, 0F, -16F, 1, 32, 14);
		left.setRotationPoint(-16F, -8F, 0F);
		left.setTextureSize(256, 128);
		left.mirror = true;
		setRotation(left, 0F, 0F, 0F);
		shelf = new ModelRenderer(this, 130, 15);
		shelf.addBox(1F, 15F, -16F, 30, 1, 14);
		shelf.setRotationPoint(-16F, -8F, 0F);
		shelf.setTextureSize(256, 128);
		shelf.mirror = true;
		setRotation(shelf, 0F, 0F, 0F);
		right = new ModelRenderer(this, 218, 0);
		right.addBox(0F, 0F, -16F, 1, 32, 14);
		right.setRotationPoint(-16F, -8F, 0F);
		right.setTextureSize(256, 128);
		right.mirror = false;
		setRotation(right, 0F, 0F, 0F);
		top = new ModelRenderer(this, 130, 0);
		top.addBox(1F, 0F, -16F, 30, 1, 14);
		top.setRotationPoint(-16F, -8F, 0F);
		top.setTextureSize(256, 128);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		bottom = new ModelRenderer(this, 130, 30);
		bottom.addBox(1F, 31F, -16F, 30, 1, 14);
		bottom.setRotationPoint(-16F, -8F, 0F);
		bottom.setTextureSize(256, 128);
		bottom.mirror = true;
		setRotation(bottom, 0F, 0F, 0F);
		books[0] = new ModelRenderer(this, 204, 50);
		books[0].addBox(0F, -11F, -12F, 3, 11, 9);
		books[0].setRotationPoint(-11F, 7F, -2F);
		books[0].setTextureSize(256, 128);
		books[0].mirror = true;
		setRotation(books[0], 0F, 0F, -0.3752458F);
		books[1] = new ModelRenderer(this, 178, 50);
		books[1].addBox(0F, -13F, -13.33333F, 2, 13, 11);
		books[1].setRotationPoint(-8F, 7F, -2F);
		books[1].setTextureSize(256, 128);
		books[1].mirror = true;
		setRotation(books[1], 0F, 0F, 0F);
		books[2] = new ModelRenderer(this, 146, 50);
		books[2].addBox(0F, -12F, -12F, 4, 12, 12);
		books[2].setRotationPoint(-6F, 7F, -2F);
		books[2].setTextureSize(256, 128);
		books[2].mirror = true;
		setRotation(books[2], 0F, 0F, 0F);
		books[3] = new ModelRenderer(this, 120, 50);
		books[3].addBox(0F, -10F, -10F, 5, 10, 8);
		books[3].setRotationPoint(-2F, 7F, -2F);
		books[3].setTextureSize(256, 128);
		books[3].mirror = true;
		setRotation(books[3], 0F, 0F, 0F);
		books[4] = new ModelRenderer(this, 88, 50);
		books[4].addBox(0F, -14F, -13F, 3, 14, 13);
		books[4].setRotationPoint(3F, 7F, -2F);
		books[4].setTextureSize(256, 128);
		books[4].mirror = true;
		setRotation(books[4], 0F, 0F, 0F);
		books[5] = new ModelRenderer(this, 58, 50);
		books[5].addBox(0F, -9F, -12F, 4, 9, 11);
		books[5].setRotationPoint(6F, 7F, -2F);
		books[5].setTextureSize(256, 128);
		books[5].mirror = true;
		setRotation(books[5], 0F, 0F, 0F);
		books[6] = new ModelRenderer(this, 32, 50);
		books[6].addBox(0F, -11F, -11F, 2, 11, 11);
		books[6].setRotationPoint(10F, 7F, -2F);
		books[6].setTextureSize(256, 128);
		books[6].mirror = true;
		setRotation(books[6], 0F, 0F, 0F);
		books[7] = new ModelRenderer(this, 0, 50);
		books[7].addBox(0F, -13F, -13F, 3, 13, 13);
		books[7].setRotationPoint(12F, 7F, -2F);
		books[7].setTextureSize(256, 128);
		books[7].mirror = true;
		setRotation(books[7], 0F, 0F, 0F);
		books[15] = new ModelRenderer(this, 0, 77);
		books[15].addBox(-2F, -11F, -11F, 2, 11, 11);
		books[15].setRotationPoint(11F, 23F, -2F);
		books[15].setTextureSize(256, 128);
		books[15].mirror = true;
		setRotation(books[15], 0F, 0F, 0.3735005F);
		books[14] = new ModelRenderer(this, 26, 77);
		books[14].addBox(0F, -11F, -11F, 2, 11, 10);
		books[14].setRotationPoint(2F, 23F, -2F);
		books[14].setTextureSize(256, 128);
		books[14].mirror = true;
		setRotation(books[14], 0F, 0F, 0F);
		books[13] = new ModelRenderer(this, 50, 77);
		books[13].addBox(0F, -8F, -12F, 4, 8, 12);
		books[13].setRotationPoint(4F, 23F, -2F);
		books[13].setTextureSize(256, 128);
		books[13].mirror = true;
		setRotation(books[13], 0F, 0F, 0F);
		books[12] = new ModelRenderer(this, 82, 77);
		books[12].addBox(0F, -14F, -10F, 3, 14, 8);
		books[12].setRotationPoint(-1F, 23F, -2F);
		books[12].setTextureSize(256, 128);
		books[12].mirror = true;
		setRotation(books[12], 0F, 0F, 0F);
		books[11] = new ModelRenderer(this, 104, 77);
		books[11].addBox(0F, -14F, -13F, 3, 12, 13);
		books[11].setRotationPoint(-4F, 25F, -2F);
		books[11].setTextureSize(256, 128);
		books[11].mirror = true;
		setRotation(books[11], 0F, 0F, 0F);
		books[10] = new ModelRenderer(this, 136, 77);
		books[10].addBox(0F, -8F, -7F, 3, 8, 7);
		books[10].setRotationPoint(-10F, 23F, -2F);
		books[10].setTextureSize(256, 128);
		books[10].mirror = true;
		setRotation(books[10], 0F, 0F, 0F);
		books[9] = new ModelRenderer(this, 156, 77);
		books[9].addBox(0F, -8F, -10F, 3, 13, 10);
		books[9].setRotationPoint(-13F, 18F, -2F);
		books[9].setTextureSize(256, 128);
		books[9].mirror = true;
		setRotation(books[9], 0F, 0F, 0F);
		books[8] = new ModelRenderer(this, 182, 77);
		books[8].addBox(0F, -6F, -13F, 2, 11, 11);
		books[8].setRotationPoint(-15F, 18F, -2F);
		books[8].setTextureSize(256, 128);
		books[8].mirror = true;
		setRotation(books[8], 0F, 0F, 0F);
	}

	public void renderBiblio() {
		float scale = 0.03125F;

		back.render(scale);
		top.render(scale);
		shelf.render(scale);
		bottom.render(scale);
		left.render(scale);
		right.render(scale);
	}

	public void renderLivre(int num) {
		float scale = 0.03125F;
		books[num].render(scale);
	}

	public void renderItem(float scale) {
		top.render(scale);
		bottom.render(scale);
		shelf.render(scale);
		back.render(scale);
		left.render(scale);
		right.render(scale);

		for (int i = 0; i < NUM_LIVRES; i++)
			books[i].render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par7Entity);
	}

}
