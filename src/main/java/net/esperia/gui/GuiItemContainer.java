package net.esperia.gui;

import org.lwjgl.opengl.GL11;

import net.esperia.container.ContainerDiceGlass;
import net.esperia.container.ContainerItemContainer;
import net.esperia.itemcontainer.InventaireDiceGlass;
import net.esperia.itemcontainer.InventaireItemContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiItemContainer extends GuiContainer {

	private static final ResourceLocation bourse_2 = new ResourceLocation("esperia", "textures/gui/container/bourse_2.png");
	private static final ResourceLocation bourse_4 = new ResourceLocation("esperia", "textures/gui/container/bourse_4.png");
	private static final ResourceLocation bourse_6 = new ResourceLocation("esperia", "textures/gui/container/bourse_6.png");

	InventoryPlayer inv;
	InventaireItemContainer bourse;

	public GuiItemContainer(InventoryPlayer inv, InventaireItemContainer bourse) {
		super(new ContainerItemContainer(inv, bourse));

		this.inv = inv;
		this.bourse = bourse;

		ySize = 222;
	}

	public GuiItemContainer(InventoryPlayer inv, InventaireDiceGlass bourse) {
		super(new ContainerDiceGlass(inv, bourse));

		this.inv = inv;
		this.bourse = bourse;

		ySize = 222;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;

		int size = bourse.getSizeInventory();
		if (size == 2) {
			this.mc.getTextureManager().bindTexture(bourse_2);
		} else if (size == 4) {
			this.mc.getTextureManager().bindTexture(bourse_4);
		} else if (size == 6) {
			this.mc.getTextureManager().bindTexture(bourse_6);
		}

		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		// fontRenderer.drawString(StatCollector.translateToLocal(pc.getInvName()),
		// 8, 6, titleColor);
		this.fontRenderer.drawString(I18n.format(inv.getName()), 8, (ySize - 152) + 2, /* titleColor */ 0);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
}
