package net.esperia.gui;

import net.esperia.container.ContainerHRP;
import net.esperia.tileentity.TileEntityContainerHRP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiContainerHRP extends GuiContainer {
	private static final ResourceLocation CONTAINER_HRP_GUI_TEXTURES = new ResourceLocation("textures/gui/container/dispenser.png");
	/** The player inventory bound to this GUI. */
	private final InventoryPlayer playerInventory;
	/** The inventory contained within the corresponding Dispenser. */
	public IInventory containerHRPInventory;

	public GuiContainerHRP(TileEntityContainerHRP containerHRPInv, InventoryPlayer playerInv) {
		super(new ContainerHRP(playerInv, containerHRPInv));
		this.playerInventory = playerInv;
		this.containerHRPInventory = containerHRPInv;
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of
	 * the items)
	 */
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	/**
	 * Draws the background layer of this container (behind the items).
	 */
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(CONTAINER_HRP_GUI_TEXTURES);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
	}
}