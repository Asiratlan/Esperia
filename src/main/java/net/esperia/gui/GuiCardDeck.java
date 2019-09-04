package net.esperia.gui;

import net.esperia.container.ContainerCardDeck;
import net.esperia.tileentity.TileEntityCardDeck;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiCardDeck extends GuiContainer {

    private static final ResourceLocation CONTAINER = new ResourceLocation(
            "textures/gui/container/generic_54.png");
    private static final ResourceLocation CARD = new ResourceLocation("esperia", "textures/gui/container/cards.png");
    private final IInventory upperChessInventory;
    private final IInventory lowerChessInventory;
    private final int inventoryRows;

    public GuiCardDeck(TileEntityCardDeck tileEntity, InventoryPlayer inventory) {
        super(new ContainerCardDeck(inventory, tileEntity));
        this.upperChessInventory = inventory;
        this.lowerChessInventory = tileEntity;
        this.allowUserInput = false;
        this.inventoryRows = lowerChessInventory.getSizeInventory() / 8;
        this.ySize = 228 + this.inventoryRows * 18;
        this.xSize += 11;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String ChessName = this.lowerChessInventory.getDisplayName().getUnformattedText();
        int xPos = this.fontRenderer.getStringWidth(ChessName);
        this.fontRenderer.drawString(this.lowerChessInventory.getDisplayName().getUnformattedText(), xSize / 2 - xPos / 2, 10, 4210752);
        this.fontRenderer.drawString(this.upperChessInventory.getDisplayName().getUnformattedText(), 8,
                this.ySize - 189, 4210752);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(CONTAINER);
        //this.mc.getTextureManager().bindTexture(Chess);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.mc.getTextureManager().bindTexture(CARD);
        this.drawTexturedModalRect(i - 9, j - 10, 0, 0, this.xSize, this.inventoryRows * 18 + 50);
        this.mc.getTextureManager().bindTexture(CONTAINER);
        this.drawTexturedModalRect(i, j + this.inventoryRows * 18 + 37, 0, 126, this.xSize, 96);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

}
