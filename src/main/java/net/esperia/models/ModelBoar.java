package net.esperia.models;

import net.minecraft.client.model.ModelQuadruped;

public class ModelBoar extends ModelQuadruped {
	public ModelBoar() {
		this(0.0F);
	}

	public ModelBoar(float f) {
		super(6, f);
		this.head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, f);
		this.head.setTextureOffset(16, 20).addBox(3F, 1F, -9F, 1, 2, 1, f);
		this.head.setTextureOffset(16, 20).addBox(-4F, 1F, -9F, 1, 2, 1, f);
		this.childZOffset = 4.0F;
	}
}