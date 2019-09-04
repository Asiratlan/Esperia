/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.proxy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class ServerProxy extends CommonProxy {

	public final String securityHash = "5f8c5d035f1a27c665ede0d1a6a1002f".toUpperCase();

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		String line;
		try {
			String current = new java.io.File( "." ).getCanonicalPath();
			BufferedReader bufferreader = new BufferedReader(new FileReader("security.txt"));
			line = bufferreader.readLine();
			byte[] bytesOfMessage = line.getBytes("UTF-8");

			MessageDigest md = MessageDigest.getInstance("MD5");
			String thedigest = (new HexBinaryAdapter()).marshal(md.digest(bytesOfMessage));
			if (!thedigest.equals(securityHash)) {
				System.exit(-255);

			}
			bufferreader.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(-255);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(-255);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(-255);
		}
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
}
