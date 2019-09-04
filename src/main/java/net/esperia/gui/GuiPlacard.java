package net.esperia.gui;

import net.esperia.container.ContainerPlacard;
import net.esperia.tileentity.TileEntityPlacard;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiPlacard extends GuiContainer {

    private static final ResourceLocation CONTAINER = new ResourceLocation(
            "textures/gui/container/generic_54.png");
    private static final ResourceLocation PLACARD = new ResourceLocation("esperia", "textures/gui/container/cupboard.png");
    private TileEntityPlacard tilePlacard;
    private final IInventory upperPlacardInventory;
    private final IInventory lowerPlacardInventory;
    private final int inventoryRows;

    public GuiPlacard(TileEntityPlacard tileEntity, InventoryPlayer inventory) {
        super(new ContainerPlacard(inventory, tileEntity));
        this.tilePlacard = tileEntity;
        this.upperPlacardInventory = inventory;
        this.lowerPlacardInventory = tileEntity;
        this.allowUserInput = false;
        int i = 222;
        int j = 114;
        this.inventoryRows = lowerPlacardInventory.getSizeInventory() / 6;
        this.ySize = 114 + this.inventoryRows * 18;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String placardName = this.lowerPlacardInventory.getDisplayName().getUnformattedText();
        int xPos = this.fontRenderer.getStringWidth(placardName);
        this.fontRenderer.drawString(this.lowerPlacardInventory.getDisplayName().getUnformattedText(), xSize / 2 - xPos / 2, 6, 4210752);
        this.fontRenderer.drawString(this.upperPlacardInventory.getDisplayName().getUnformattedText(), 8,
                this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(CONTAINER);
        //this.mc.getTextureManager().bindTexture(PLACARD);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.mc.getTextureManager().bindTexture(PLACARD);
        this.drawTexturedModalRect(i - 9, j - 10, 0, 0, this.xSize, this.inventoryRows * 18 + 30);
        this.mc.getTextureManager().bindTexture(CONTAINER);
        this.drawTexturedModalRect(i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

}
