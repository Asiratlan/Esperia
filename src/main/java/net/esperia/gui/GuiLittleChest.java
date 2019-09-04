package net.esperia.gui;

import org.lwjgl.opengl.GL11;

import net.esperia.container.ContainerLittleChest;
import net.esperia.tileentity.TileEntityLittleChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

public class GuiLittleChest extends GuiContainer {

    private static final ResourceLocation bookshelf = new ResourceLocation("esperia",
            "textures/gui/container/bookshelf.png");

    FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;

    public GuiLittleChest(TileEntityLittleChest tile, InventoryPlayer inventorySlotsIn) {
        super(new ContainerLittleChest(inventorySlotsIn, tile));
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        fontRenderer.drawString("Coffret", 60, 6, 0/*titleColor*/);
        fontRenderer.drawString(new TextComponentTranslation("container.inventory").getFormattedText(), 8, (ySize - 96) + 2, 0/*titleColor*/);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(bookshelf);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
    }
        @Override
        public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

}
