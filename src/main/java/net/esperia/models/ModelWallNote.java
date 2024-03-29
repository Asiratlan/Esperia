package net.esperia.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * Modèle de la note murale.
 *
 * @author Mc-Fr
 */
public class ModelWallNote extends ModelBase {
  public ModelRenderer signBoard = new ModelRenderer(this, 0, 0);

  public ModelWallNote() {
    this.signBoard.addBox(-32, -26, 0, 32 * 2, 32, 0, 0);
  }

  /**
   * Affiche le modèle.
   */
  public void renderModel() {
    this.signBoard.render(0.0625F);
  }
}
