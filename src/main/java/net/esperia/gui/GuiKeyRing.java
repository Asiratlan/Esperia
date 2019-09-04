package net.esperia.gui;

import org.lwjgl.opengl.GL11;

import net.esperia.container.ContainerKeyRing;
import net.esperia.itemcontainer.InventaireKeyRing;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiKeyRing extends GuiContainer {
	
	private static final ResourceLocation keyring = new ResourceLocation("esperia",
			"textures/gui/container/keyring.png");
	private static final ResourceLocation container = new ResourceLocation("textures/gui/container/generic_54.png");

	
	InventoryPlayer inv;
	InventaireKeyRing pc;
	
	public GuiKeyRing(InventoryPlayer inv, InventaireKeyRing pc) {
		super(new ContainerKeyRing(inv, pc));
		this.inv = inv;
		this.pc = pc;

		ySize = 222;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        
	        int j = (width - xSize) / 2;
	        int k = (height - ySize) / 2;
	        
	        this.mc.getTextureManager().bindTexture(keyring);
	        drawTexturedModalRect(j - 10, k - 3, 0, 0, xSize, 138); // 138 = nb_ligne * 18 + 30
	        this.mc.getTextureManager().bindTexture(container);
	        drawTexturedModalRect(j, k + 125, 0, 126, xSize, 96);
	}
	
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
	}
}