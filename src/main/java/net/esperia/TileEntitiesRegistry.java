/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia;

import java.util.ArrayList;

import net.esperia.tileentity.TileEntityBibliotheque;
import net.esperia.tileentity.TileEntityCampfire;
import net.esperia.tileentity.TileEntityCardDeck;
import net.esperia.tileentity.TileEntityChessBoard;
import net.esperia.tileentity.TileEntityContainerHRP;
import net.esperia.tileentity.TileEntityCustomBed;
import net.esperia.tileentity.TileEntityEsperiaLockable;
import net.esperia.tileentity.TileEntityFurniture;
import net.esperia.tileentity.TileEntityHRPContainer;
import net.esperia.tileentity.TileEntityHRPSignEsperia;
import net.esperia.tileentity.TileEntityHive;
import net.esperia.tileentity.TileEntityLightBlock;
import net.esperia.tileentity.TileEntityLittleChest;
import net.esperia.tileentity.TileEntityPlacard;
import net.esperia.tileentity.TileEntityRepair;
import net.esperia.tileentity.TileEntityShowcase;
import net.esperia.tileentity.TileEntityStoneSignEsperia;
import net.esperia.tileentity.TileEntityWallNote;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 *
 * @author AlmeidaCorreiaT
 */
public class TileEntitiesRegistry {

    public static ArrayList<TileEntity> tileEntityList = new ArrayList<TileEntity>();

    public static TileEntity hrpcontainer;

    public static void init() {
        GameRegistry.registerTileEntity(TileEntityHRPContainer.class, "te_hrpcontainer");
        GameRegistry.registerTileEntity(TileEntityWallNote.class, "te_wallnote");
        GameRegistry.registerTileEntity(TileEntityHRPSignEsperia.class, "te_hrpsignesperia");
        GameRegistry.registerTileEntity(TileEntityStoneSignEsperia.class, "te_stonesignesperia");
        GameRegistry.registerTileEntity(TileEntityBibliotheque.class, "te_bibliotheque");
        GameRegistry.registerTileEntity(TileEntityEsperiaLockable.class, "te_lockable");
        GameRegistry.registerTileEntity(TileEntityCampfire.class, "campfire");
        GameRegistry.registerTileEntity(TileEntityLightBlock.class, "light");
        GameRegistry.registerTileEntity(TileEntityPlacard.class, "te_cupboard");
        GameRegistry.registerTileEntity(TileEntityHive.class, "hive");
        GameRegistry.registerTileEntity(TileEntityFurniture.class, "furniture");
        GameRegistry.registerTileEntity(TileEntityLittleChest.class, "little_chest");
        GameRegistry.registerTileEntity(TileEntityCustomBed.class, "custom_bed");
        //NEVER USE ABOVE FORMAT AGAIN, PREFER THE ONE BELLOW
        GameRegistry.registerTileEntity(TileEntityChessBoard.class, new ResourceLocation(Esperia.MOD_ID, "chess_board"));
        GameRegistry.registerTileEntity(TileEntityCardDeck.class, new ResourceLocation(Esperia.MOD_ID, "card_deck"));
        GameRegistry.registerTileEntity(TileEntityRepair.class, new ResourceLocation(Esperia.MOD_ID, "repair"));
        GameRegistry.registerTileEntity(TileEntityShowcase.class, new ResourceLocation(Esperia.MOD_ID, "showcase"));
        GameRegistry.registerTileEntity(TileEntityContainerHRP.class, new ResourceLocation(Esperia.MOD_ID, "container_hrp"));

        //Showcase Register
    }
}
