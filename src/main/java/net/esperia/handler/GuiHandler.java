/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.handler;

import net.esperia.container.ContainerBibliotheque;
import net.esperia.container.ContainerCardDeck;
import net.esperia.container.ContainerChessBoard;
import net.esperia.container.ContainerDiceGlass;
import net.esperia.container.ContainerFurniture;
import net.esperia.container.ContainerHRP;
import net.esperia.container.ContainerItemContainer;
import net.esperia.container.ContainerJewelry;
import net.esperia.container.ContainerKeyRing;
import net.esperia.container.ContainerLittleChest;
import net.esperia.container.ContainerPlacard;
import net.esperia.gui.GuiBibliotheque;
import net.esperia.gui.GuiCardDeck;
import net.esperia.gui.GuiChessBoard;
import net.esperia.gui.GuiContainerHRP;
import net.esperia.gui.GuiFurniture;
import net.esperia.gui.GuiItemContainer;
import net.esperia.gui.GuiJewelry;
import net.esperia.gui.GuiKeyRing;
import net.esperia.gui.GuiLittleChest;
import net.esperia.gui.GuiPlacard;
import net.esperia.item.ItemBackpack;
import net.esperia.item.ItemContainer;
import net.esperia.item.ItemDiceGlass;
import net.esperia.item.ItemJewelry;
import net.esperia.item.ItemKeyRing;
import net.esperia.itemcontainer.InventaireDiceGlass;
import net.esperia.itemcontainer.InventaireItemContainer;
import net.esperia.itemcontainer.InventaireJewelry;
import net.esperia.itemcontainer.InventaireKeyRing;
import net.esperia.tileentity.TileEntityBibliotheque;
import net.esperia.tileentity.TileEntityCardDeck;
import net.esperia.tileentity.TileEntityChessBoard;
import net.esperia.tileentity.TileEntityContainerHRP;
import net.esperia.tileentity.TileEntityFurniture;
import net.esperia.tileentity.TileEntityLittleChest;
import net.esperia.tileentity.TileEntityPlacard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 *
 * @author AlmeidaCorreiaT
 */
public class GuiHandler implements IGuiHandler {

	public static final int GUI_HRPCONTAINER = 0;
	public static final int GUI_BIBLIOTHEQUE = 1;
	public static final int GUI_BOURSE_TISSU = 2;
	public static final int GUI_BOURSE_CUIR = 3;
	public static final int GUI_BOURSE_DECORE = 4;
	public static final int GUI_PLACARD = 5;
	public static final int GUI_FURNITURE = 6;
	public static final int GUI_LITTLE_CHEST = 7;
	public static final int GUI_BACKPACK = 8;
	public static final int GUI_KEYRING = 9;
	public static final int GUI_DICEGLASS = 10;
	public static final int GUI_CHESS = 11;
	public static final int GUI_CARD_DECK = 12;
	public static final int GUI_JEWELRY = 13;
	public static final int GUI_CONTAINER_HRP = 14;


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GUI_BIBLIOTHEQUE) {
			return new ContainerBibliotheque(player.inventory,
					(TileEntityBibliotheque) world.getTileEntity(new BlockPos(x, y, z)));
		} else if (ID == GUI_BOURSE_TISSU) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemContainer))
				return new ContainerItemContainer(player.inventory,
						new InventaireItemContainer(player.getHeldItemMainhand(), 2));

		} else if (ID == GUI_BOURSE_CUIR) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemContainer))
				return new ContainerItemContainer(player.inventory,
						new InventaireItemContainer(player.getHeldItemMainhand(), 4));
		} else if (ID == GUI_BOURSE_DECORE) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemContainer))
				return new ContainerItemContainer(player.inventory,
						new InventaireItemContainer(player.getHeldItemMainhand(), 6));
		} else if (ID == GUI_PLACARD) {
			return new ContainerPlacard(player.inventory,
					(TileEntityPlacard) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == GUI_FURNITURE) {
			return new ContainerFurniture(player.inventory,
					(TileEntityFurniture) world.getTileEntity(new BlockPos(x, y, z)));
		}		
		else if (ID == GUI_LITTLE_CHEST) {
			return new ContainerLittleChest(player.inventory,
					(TileEntityLittleChest) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == GUI_BACKPACK) {
			if (player.inventory.armorInventory.get(2) != null
					&& (player.inventory.armorInventory.get(2).getItem() instanceof ItemBackpack))
				return new ContainerItemContainer(player.inventory,
						new InventaireItemContainer(player.inventory.armorInventory.get(2), 6));
		}
		else if (ID == GUI_KEYRING) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemKeyRing))
				return new ContainerKeyRing(player.inventory,
						new InventaireKeyRing(player.getHeldItemMainhand()));
		}
		else if (ID == GUI_DICEGLASS) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemDiceGlass))
				return new ContainerDiceGlass(player.inventory,
						new InventaireDiceGlass(player.getHeldItemMainhand()));
		}
		else if (ID == GUI_CHESS) {
			return new ContainerChessBoard(player.inventory,
					(TileEntityChessBoard) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == GUI_CARD_DECK) {
			return new ContainerCardDeck(player.inventory,
					(TileEntityCardDeck) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else if (ID == GUI_JEWELRY) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemJewelry))
				return new ContainerJewelry(player.inventory,
						new InventaireJewelry(player.getHeldItemMainhand()));
		}
		else if (ID == GUI_CONTAINER_HRP) {
			return new ContainerHRP(player.inventory,
					(TileEntityContainerHRP) world.getTileEntity(new BlockPos(x, y, z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (ID == GUI_BIBLIOTHEQUE) {

			return new GuiBibliotheque((TileEntityBibliotheque) world.getTileEntity(new BlockPos(x, y, z)),
					player.inventory);
		} else if (ID == GUI_BOURSE_TISSU) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemContainer))
				return new GuiItemContainer(player.inventory,
						new InventaireItemContainer(player.getHeldItemMainhand(), 2));
		} else if (ID == GUI_BOURSE_CUIR) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemContainer))
				return new GuiItemContainer(player.inventory,
						new InventaireItemContainer(player.getHeldItemMainhand(), 4));
		} else if (ID == GUI_BOURSE_DECORE) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemContainer))
				return new GuiItemContainer(player.inventory,
						new InventaireItemContainer(player.getHeldItemMainhand(), 6));
		}
		else if (ID == GUI_KEYRING) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemKeyRing))
				return new GuiKeyRing(player.inventory,
						new InventaireKeyRing(player.getHeldItemMainhand()));
		}
		else if (ID == GUI_DICEGLASS) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemDiceGlass))
				return new GuiItemContainer(player.inventory,
						new InventaireDiceGlass(player.getHeldItemMainhand()));
		}
		else if (ID == GUI_PLACARD){
			return new GuiPlacard((TileEntityPlacard) world.getTileEntity(new BlockPos(x, y, z)),
					player.inventory);
		}
		else if (ID == GUI_FURNITURE){
			return new GuiFurniture((TileEntityFurniture) world.getTileEntity(new BlockPos(x, y, z)),
					player.inventory);
		}
		else if (ID == GUI_LITTLE_CHEST){
			return new GuiLittleChest((TileEntityLittleChest) world.getTileEntity(new BlockPos(x, y, z)),
					player.inventory);
		}
		else if (ID == GUI_BACKPACK) {
			if (player.inventory.armorInventory.get(2) != null
					&& (player.inventory.armorInventory.get(2).getItem() instanceof ItemBackpack))
				return new GuiItemContainer(player.inventory,
						new InventaireItemContainer(player.inventory.armorInventory.get(2), 6));
		}
		else if (ID == GUI_CHESS){
			return new GuiChessBoard((TileEntityChessBoard) world.getTileEntity(new BlockPos(x, y, z)),
					player.inventory);
		}
		else if (ID == GUI_CARD_DECK){
			return new GuiCardDeck((TileEntityCardDeck) world.getTileEntity(new BlockPos(x, y, z)),
					player.inventory);
		}
		else if (ID == GUI_JEWELRY) {
			if (player.getHeldItemMainhand() != null
					&& (player.getHeldItemMainhand().getItem() instanceof ItemJewelry))
				return new GuiJewelry(player.inventory,
						new InventaireJewelry(player.getHeldItemMainhand()));
		}
		else if (ID == GUI_CONTAINER_HRP){
			return new GuiContainerHRP((TileEntityContainerHRP) world.getTileEntity(new BlockPos(x, y, z)),
					player.inventory);
		}

		return null;
	}

}
