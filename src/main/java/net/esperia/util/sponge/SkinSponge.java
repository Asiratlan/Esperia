package net.esperia.util.sponge;

import java.util.UUID;

import net.esperia.Esperia;
import net.esperia.network.SkinMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class SkinSponge {
	
	public static void skinForgeActualisation(UUID uuid){
		//Esperia.network.sendToAll(new SkinMessage(uuid.toString()));
	}

}
