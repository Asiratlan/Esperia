package net.esperia.events;

import net.esperia.ItemsRegistry;
import net.esperia.item.ItemJewelry;
import net.esperia.item.ItemKey;
import net.esperia.item.ItemLock;
import net.esperia.item.ItemPlank;
import net.esperia.item.ItemRockHammer;
import net.esperia.item.ItemSerrure;
import net.esperia.network.Synchronisation;
import net.esperia.util.EsperiaUtils;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockFurnace;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandler {

    @SubscribeEvent
    public void onPlayerLogsIn(PlayerLoggedInEvent event) {
        if (event.player.isServerWorld()) {

//            Synchronisation.syncPlayerToOther(event.player);
//            Synchronisation.syncOtherToPlayer((EntityPlayerMP) event.player);
            Synchronisation.syncServerToPlayer((EntityPlayerMP) event.player);
        }
        // IPlayerPosition position =
        // event.player.getCapability(PlayerPositionProvider.POSITION_CAP, null);

        /*
		 * if (event.player != null && event.player instanceof EntityPlayerMP) { if
		 * (Minecraft.getMinecraft().theWorld != null &&
		 * Minecraft.getMinecraft().theWorld.isRemote) { networkplayerinfo =
		 * Minecraft.getMinecraft().getConnection()
		 * .getPlayerInfo(event.player.getGameProfile().getId());
		 * SkinEsperia.DownloadImageSkin(networkplayerinfo.getLocationSkin(),
		 * event.player.getUniqueID().toString(), (AbstractClientPlayer) event.player);
         */
        // String message = String.format("Hello there, you have §7%d§r mana
        // left.", (int) position.getPosition());
        // event.player.addChatMessage(new TextComponentString(message));
    }

//    @SubscribeEvent
//    public void playerTickEvent(TickEvent.PlayerTickEvent event) {
//        if (event.player != null) {
//            IPlayerPosition position = event.player.getCapability(PlayerPositionProvider.POSITION_CAP, null);
//            EnumPosition enumPosition = position.getEnumPosition();
//            Positions classPosition = enumPosition.getClassPosition();
//            classPosition.setHitBox(event.player);
//            /*if(!enumPosition.equals(EnumPosition.STAND) && Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()){
//				Minecraft.getMinecraft().gameSettings.keyBindSneak.
//			}*/
// /*if (position.getPosition() == 1)
//				PlayerHitbox.setPlayerSize(event.player, 0.6F, 1.3F, 1.1F);
//			else if (position.getPosition() == 2)
//				PlayerHitbox.setPlayerSize(event.player, 0.6F, 0.6F, 0.3F);
//			else if (position.getPosition() == 0)
//				PlayerHitbox.resetPlayerSize(event.player);*/
//        }
//    }
//    @SubscribeEvent
//    @SideOnly(Side.CLIENT)
//    public void sneakEvent(InputUpdateEvent event) {
//        if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {
//            IPlayerPosition position = event.getEntityPlayer().getCapability(PlayerPositionProvider.POSITION_CAP, null);
//            EnumPosition enumPosition = position.getEnumPosition();
//            if (!enumPosition.equals(EnumPosition.STAND)) {
//                event.getMovementInput().sneak = false;
//            }
//        }
//    }
    @SubscribeEvent
    public void itemUsedEvent(LivingEntityUseItemEvent event) {
        if (event.getItem().getItem() == net.esperia.ItemsRegistry.wooden_bucket_water) {
            event.getItem().setCount(event.getItem().getCount() - 1);
            ((EntityPlayer) event.getEntity()).inventory
                    .addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
        }

    }

    public static boolean isCauldron;

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (!event.getWorld().isRemote) {
            if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.CAULDRON
                    && event.getItemStack().getItem() == net.esperia.ItemsRegistry.wooden_bucket_water
                    && event.getHand() == EnumHand.MAIN_HAND) {
                event.getWorld().setBlockState(event.getPos(),
                        Blocks.CAULDRON.getDefaultState().withProperty(BlockCauldron.LEVEL, 3));
                isCauldron = true;
                if (!event.getEntityPlayer().isCreative()) {
                    event.getItemStack().setCount(event.getItemStack().getCount() - 1);
                    ((EntityPlayer) event.getEntity()).inventory
                            .addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                }
            }
            if (!event.getWorld().isRemote) {
                if (event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.FURNACE && event.getItemStack().getItem() == Items.FLINT_AND_STEEL) {
                    event.getWorld().setBlockState(event.getPos(), Blocks.LIT_FURNACE.getDefaultState().withProperty(BlockFurnace.FACING, event.getWorld().getBlockState(event.getPos()).getValue(BlockFurnace.FACING)));
                    event.getWorld().setBlockState(event.getPos(),
                            Blocks.LIT_FURNACE.getDefaultState().withProperty(BlockFurnace.FACING,
                                    event.getWorld().getBlockState(event.getPos()).getValue(BlockFurnace.FACING)));

                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getItemStack().getItem() == ItemsRegistry.wooden_bucket_water && isCauldron) {
            event.setCanceled(true);
            isCauldron = false;
        }
    }

    @SubscribeEvent
    public void craftingEvent(ItemCraftedEvent event) {
        if (!event.player.getEntityWorld().isRemote) {
            IInventory craftMatrix = event.craftMatrix;
            for (int i = 0; i < 9; i++) {
                if (!craftMatrix.getStackInSlot(i).isEmpty()) {
                    if (craftMatrix.getStackInSlot(i).getItem() instanceof ItemTool
                            || craftMatrix.getStackInSlot(i).getItem() instanceof ItemSword) {
                        ItemStack s = craftMatrix.getStackInSlot(i);
                        s.damageItem(1, event.player);
                    }
                      if (craftMatrix.getStackInSlot(i).getItem() == Items.WHEAT || craftMatrix.getStackInSlot(i).getItem() == ItemsRegistry.barley) {
                        event.player.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.plant_fiber));
                    }
                }
            }

            if (event.crafting.getItem() instanceof ItemPlank) {
                event.player.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.sawdust));
            }
            
            if (event.crafting.getItem() instanceof ItemJewelry) {
            	ItemJewelry.setInventory(event.crafting, event.craftMatrix);
            }
        }
    }

    @SubscribeEvent
    public void craftedItem(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() instanceof ItemKey) {
            for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
                if (!event.craftMatrix.getStackInSlot(i).isEmpty()
                        && event.craftMatrix.getStackInSlot(i).getItem() instanceof ItemSerrure) {
                    ItemKey key = (ItemKey) event.crafting.getItem();
                    ItemStack serrure = event.craftMatrix.getStackInSlot(i);

                    key.setKey(ItemLock.getkey(serrure), event.crafting);
                    event.player.inventory.addItemStackToInventory(event.craftMatrix.getStackInSlot(i).copy());
                }
            }
        }
    }

    /**
     * Cet écouteur remplace l'écran-titre, le menu en jeu et le tchat par ceux
     * du mod.
     *
     * @param e l'évènement
     */
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent e) {
        GuiScreen gui = e.getGui();
        if (gui instanceof GuiMainMenu) {
            e.setGui(new net.esperia.gui.GuiMainMenu());
        }
        if (gui instanceof GuiMultiplayer) {
            if (!EsperiaUtils.isPlayerAdmin()) {
                e.setGui(new net.esperia.gui.GuiMainMenu());
            }
        }
    }
    
    //Rock Hammer, drop uncooked stone.
    @SubscribeEvent
    public void onBlockBreak(HarvestDropsEvent  e){
    	if(e.getState().getBlock() == Blocks.STONE){
    		if(e.getHarvester().getHeldItemMainhand().getItem() instanceof ItemRockHammer){
    			e.getDrops().clear();
    			e.getDrops().add(new ItemStack(Blocks.STONE, 1, 0));
    		}
    	}
    	
    	
    }
}
