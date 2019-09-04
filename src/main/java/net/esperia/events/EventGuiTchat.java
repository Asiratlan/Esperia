package net.esperia.events;

import net.esperia.gui.GuiChatEsperia;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventGuiTchat {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onGuiTchatIsOpen(GuiOpenEvent event) {
		GuiScreen gui = event.getGui();
		if (event.getGui() instanceof GuiChat) {
			GuiChat guiChat = (GuiChat) gui;
			event.setGui(new GuiChatEsperia());	
		}
	}
}
