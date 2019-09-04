package net.esperia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.client.Minecraft;

public class EsperiaUtils {
	
	public static boolean isPlayerAdmin(){
		try {
		      List<String> admins = new ArrayList<>();
		      URLConnection conn = new URL("https://www.esperia-rp.net/utils/ops").openConnection();

		     try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8.name()))) {
		        admins = rd.lines().collect(Collectors.toList());
		      } 

		      return admins.contains(Minecraft.getMinecraft().getSession().getUsername().toLowerCase());
		    }
		    catch (IOException e) {}

		    return false;
	}
}