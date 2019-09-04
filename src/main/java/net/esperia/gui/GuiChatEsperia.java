package net.esperia.gui;

import java.io.IOException;

import net.esperia.Esperia;
import net.esperia.capabilities.emoteplayer.EmotePlayerProvider;
import net.esperia.capabilities.emoteplayer.IEmotePlayer;
import net.esperia.network.PlayerIconePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.entity.player.EntityPlayer;

public class GuiChatEsperia extends GuiChat {

    public GuiChatEsperia() {
        super();
    }

    public GuiChatEsperia(String defaultText) {
        super(defaultText);
    }

    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
        if (super.inputField.getText().length() == 1) {
            this.sendTypeIcone(super.inputField.getText().charAt(0));
        } else if (super.inputField.getText().length() == 0) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            IEmotePlayer icone = player.getCapability(EmotePlayerProvider.PLAYER_EMOTE, null);
            icone.setEmote(0);
            Esperia.network.sendToServer(new PlayerIconePacket(icone.getEmote()));
        }
    }

    private void sendTypeIcone(char firstChar) {
        // int icone = 0;
        EntityPlayer player = Minecraft.getMinecraft().player;
        IEmotePlayer icone = player.getCapability(EmotePlayerProvider.PLAYER_EMOTE, null);
        switch (firstChar) {
            case '*':
                icone.setEmote(2);
                break;
            case '(':
                icone.setEmote(3);
                break;
            case '?':
                icone.setEmote(0);
                break;
            case '!':
                icone.setEmote(0);
                break;
            case '/':
                icone.setEmote(0);
                break;
            default:
                icone.setEmote(1);
                break;
        }

        Esperia.network.sendToServer(new PlayerIconePacket(icone.getEmote()));
    }

    public void onGuiClosed() {
        super.onGuiClosed();
        this.inputField.setText("");
        EntityPlayer player = Minecraft.getMinecraft().player;
        if(player == null)
        	return;
        IEmotePlayer icone = player.getCapability(EmotePlayerProvider.PLAYER_EMOTE, null);
        icone.setEmote(0);
        Esperia.network.sendToServer(new PlayerIconePacket(icone.getEmote()));
    }
}
