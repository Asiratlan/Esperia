package net.esperia.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSignHRPEsperia extends ModelBase {
	/** The board on a sign that has the writing on it. */
	public ModelRenderer signBoard_1 = new ModelRenderer(this, 0, 0);
	public ModelRenderer signBoard_2 = new ModelRenderer(this, 0, 0);
	/** The stick a sign stands on. */
	public ModelRenderer signStick;

	public ModelSignHRPEsperia() {
		this.signBoard_1.addBox(-12.0F, -14.0F, -1.0F, 24, 12, 2, 0.0F);
		this.signBoard_2.addBox(-12.0F, -14.0F, -1.0F, 24, 12, 2, 0.0F);
		this.signStick = new ModelRenderer(this, 0, 14);
		this.signStick.addBox(-1.0F, -2.0F, -1.0F, 2, 14, 2, 0.0F);
	}

	/**
	 * Renders the sign model through TileEntitySignRenderer
	 */
	public void renderSign() {
		this.signBoard_1.render(0.0625F);
		this.signBoard_2.render(0.0625F);
		this.signStick.render(0.0625F);
	}
}
