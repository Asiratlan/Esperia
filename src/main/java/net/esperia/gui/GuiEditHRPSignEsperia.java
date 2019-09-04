package net.esperia.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.esperia.Esperia;
import net.esperia.network.SignEsperiaInfoServerPacket;
import net.esperia.tileentity.TileEntityHRPSignEsperia;
import net.esperia.tileentity.TileEntityHRPSignEsperia.SignColor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStandingSign;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiEditHRPSignEsperia extends GuiScreen {

    /**
     * Reference to the sign object.
     */
    private final TileEntityHRPSignEsperia tileSign;
    /**
     * Counts the number of screen updates.
     */
    private int updateCounter;
    /**
     * The index of the line that is being edited.
     */
    private int editLine;
    /**
     * "Done" button for the GUI.
     */
    private GuiButton doneBtn;

    public GuiEditHRPSignEsperia(TileEntityHRPSignEsperia teSign) {
        this.tileSign = teSign;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called
     * when the GUI is displayed and when the window resizes, the buttonList is
     * cleared beforehand.
     */
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.doneBtn = this.addButton(
                new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, I18n.format("gui.done")));
        this.tileSign.setEditable(false);
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat
     * events
     */
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        /*
		 * NetHandlerPlayClient nethandlerplayclient = this.mc.getConnection();
		 * 
		 * if (nethandlerplayclient != null) {
		 * nethandlerplayclient.sendPacket(new
		 * CPacketUpdateSign(this.tileSign.getPos(), this.tileSign.signText)); }
         */

 /*
		 * for (int i = 0; i < tileSign.signText.length; i++) { int maxLength =
		 * Utils.getMaxLength(rowSizes[i]); String s =
		 * fontRendererObj.trimStringToWidth(tileSign.signText[i].
		 * getUnformattedText(),
		 * Math.min(fontRendererObj.getStringWidth(tileSign.signText[i].
		 * getUnformattedText()), maxLength - toPixelWidth(getStyleOffset(i))));
		 * tileSign.signText[i] = new TextComponentString(s); }
         */
        this.tileSign.setEditable(true);

        Esperia.network.sendToServer(new SignEsperiaInfoServerPacket(this.tileSign));

    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen() {
        ++this.updateCounter;
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed
     * for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.enabled) {
            if (button.id == 0) {
                this.tileSign.markDirty();
                this.mc.displayGuiScreen((GuiScreen) null);
            }
        }
    }

    /**
     * Fired when a key is typed (except F11 which toggles full screen). This is
     * the equivalent of KeyListener.keyTyped(KeyEvent e). Args : character
     * (character on the key), keyCode (lwjgl Keyboard key code)
     */
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == 200) {
            this.editLine = this.editLine - 1 & 3;
        }

        if (keyCode == 208 || keyCode == 28 || keyCode == 156) {
            this.editLine = this.editLine + 1 & 3;
        }

        String s = this.tileSign.signText[this.editLine].getUnformattedText();

        if (keyCode == 14 && !s.isEmpty()) {
            s = s.substring(0, s.length() - 1);

            if (this.editLine == 0) {
                if (s.length() == 0 && this.tileSign.getColorCode().length() > 0 && !this.tileSign.getFlag()) {
                    s = this.tileSign.getColorCode();
                    this.tileSign.setColorCode("");
                    this.tileSign.setFlag(true);
                } else if (s.length() == 0 && this.tileSign.getColorCode().length() == 0) {
                    this.tileSign.setColor(SignColor.WHITE);
                }
            }
        }

        if (ChatAllowedCharacters.isAllowedCharacter(typedChar)
                && this.fontRenderer.getStringWidth(s + typedChar) <= 90) {

            s = s + typedChar;
            if (this.editLine == 0) {
                if (s.length() > 0 && s.startsWith("&") && this.tileSign.getFlag()) {
                    if (s.indexOf("&") == 0 && s.length() > 1) {

                        switch (s.charAt(1)) {
                            case '0':
                                this.tileSign.setColor(SignColor.BLACK);
                                break;
                            case '1':
                                this.tileSign.setColor(SignColor.DARK_BLUE);
                                break;
                            case '2':
                                this.tileSign.setColor(SignColor.DARK_GREEN);
                                break;
                            case '3':
                                this.tileSign.setColor(SignColor.DARK_CYAN);
                                break;
                            case '4':
                                this.tileSign.setColor(SignColor.DARK_RED);
                                break;
                            case '5':
                                this.tileSign.setColor(SignColor.PURPLE);
                                break;
                            case '6':
                                this.tileSign.setColor(SignColor.GOLD);
                                break;
                            case '7':
                                this.tileSign.setColor(SignColor.GREY);
                                break;
                            case '8':
                                this.tileSign.setColor(SignColor.DARK_GREY);
                                break;
                            case '9':
                                this.tileSign.setColor(SignColor.BLUE);
                                break;
                            case 'a':
                                this.tileSign.setColor(SignColor.LIGHT_GREEN);
                                break;
                            case 'b':
                                this.tileSign.setColor(SignColor.CYAN);
                                break;
                            case 'c':
                                this.tileSign.setColor(SignColor.RED);
                                break;
                            case 'd':
                                this.tileSign.setColor(SignColor.PINK);
                                break;
                            case 'e':
                                this.tileSign.setColor(SignColor.YELLOW);
                                break;
                            default:
                                break;

                        }
                    }
                }

                if (s.startsWith("&") && s.length() > 2 && this.tileSign.getFlag()) {
                    this.tileSign.setColorCode(s.substring(0, 2));
                    s = s.substring(2, s.length());
                    this.tileSign.setFlag(false);
                }
            }

        }

        this.tileSign.signText[this.editLine] = new TextComponentString(s);

        if (keyCode == 1) {
            this.actionPerformed(this.doneBtn);
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, I18n.format("sign.edit"), this.width / 2, 40, 16777215);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) (this.width / 2), 0.0F, 50.0F);
        float f = 93.75F;
        GlStateManager.scale(-93.75F, -93.75F, -93.75F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        Block block = this.tileSign.getBlockType();

        if (block instanceof BlockStandingSign) {
            float f1 = (float) (this.tileSign.getBlockMetadata() * 360) / 16.0F;
            GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.0F, -1.0625F, 0.0F);
        } else {
            int i = this.tileSign.getBlockMetadata();
            System.out.println(i);
            float f2 = 0.0F;

            if (i == 2) {
                f2 = 180.0F;
            }

            if (i == 4) {
                f2 = 180.0F;
            }

            if (i == 5) {
                f2 = -180.0F;
            }

            GlStateManager.rotate(f2, 0.0F, 1.0F, 0.0F);
            GlStateManager.translate(0.0F, -1.0625F, 0.0F);
        }

        if (this.updateCounter / 6 % 2 == 0) {
            this.tileSign.lineBeingEdited = this.editLine;
        }

        int metadata = this.tileSign.getBlockMetadata();
        this.tileSign.setBlockMetadata(0);
        TileEntityRendererDispatcher.instance.render(this.tileSign, -0.5D, -0.75D, -0.5D, 0.0F);
        this.tileSign.setBlockMetadata(metadata);

        this.tileSign.lineBeingEdited = -1;
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

}
