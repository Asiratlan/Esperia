package net.esperia.tileentity;

import java.util.Arrays;

import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.world.World;

/**
 * Classe de base des tile entities des panneaux larges (note murale, pierre tombale).
 *
 * @author Mc-Fr
 */
public abstract class TileEntityLargeSign extends TileEntity {
  /** Nombre de lignes */
  public static final int LINES_NB = 15;

  private ITextComponent[] text;
  /** Indice de la ligne éditée */
  private int lineBeingEdited;

  public TileEntityLargeSign() {
    this.text = new ITextComponent[LINES_NB];
    this.lineBeingEdited = -1;
    Arrays.fill(this.text, new TextComponentString(""));
  }

  /**
   * @return les lignes de texte
   */
  public ITextComponent[] getText() {
    return this.text;
  }

  /**
   * @return l'indice de la ligne éditée
   */
  public int getLineBeingEdited() {
    return this.lineBeingEdited;
  }

  /**
   * Modifie l'indice de la ligne éditée.
   * 
   * @param lineBeingEdited le nouvel indice
   */
  public void setLineBeingEdited(int lineBeingEdited) {
    this.lineBeingEdited = lineBeingEdited;
  }

  @Override
  public void readFromNBT(NBTTagCompound compound) {
    super.readFromNBT(compound);
    ICommandSender icommandsender = new ICommandSender()
    {
        /**
         * Get the name of this object. For players this returns their username
         */
        public String getName()
        {
            return "Sign";
        }
        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return new TextComponentString(this.getName());
        }
        /**
         * Send a chat message to the CommandSender
         */
        public void addChatMessage(ITextComponent component)
        {
        }
        /**
         * Returns {@code true} if the CommandSender is allowed to execute the command, {@code false} if not
         */
        public boolean canUseCommand(int permLevel, String commandName)
        {
            return permLevel <= 2; //Forge: Fixes  MC-75630 - Exploit with signs and command blocks
        }
        /**
         * Get the position in the world. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
         * return the coordinates 0, 0, 0
         */
        public BlockPos getPosition()
        {
            return TileEntityLargeSign.this.pos;
        }
        /**
         * Get the position vector. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
         * return 0.0D, 0.0D, 0.0D
         */
        public Vec3d getPositionVector()
        {
            return new Vec3d((double)TileEntityLargeSign.this.pos.getX() + 0.5D, (double)TileEntityLargeSign.this.pos.getY() + 0.5D, (double)TileEntityLargeSign.this.pos.getZ() + 0.5D);
        }
        /**
         * Get the world, if available. <b>{@code null} is not allowed!</b> If you are not an entity in the world,
         * return the overworld
         */
        public World getEntityWorld()
        {
            return TileEntityLargeSign.this.world;
        }
        /**
         * Returns the entity associated with the command sender. MAY BE NULL!
         */
        public Entity getCommandSenderEntity()
        {
            return null;
        }
        /**
         * Returns true if the command sender should be sent feedback about executed commands
         */
        public boolean sendCommandFeedback()
        {
            return false;
        }
        public void setCommandStat(CommandResultStats.Type type, int amount)
        {
        }
        /**
         * Get the Minecraft server instance
         */
        public MinecraftServer getServer()
        {
            return TileEntityLargeSign.this.world.getMinecraftServer();
        }
    };
    
    for (int i = 0; i < LINES_NB; ++i)
    {
        String s = compound.getString("Text" + (i + 1));
        ITextComponent itextcomponent = ITextComponent.Serializer.jsonToComponent(s);
        
        try
        {
            getText()[i] = TextComponentUtils.processComponent(icommandsender, itextcomponent, (Entity)null);
        }
        catch (CommandException var7)
        {
        	getText()[i] = itextcomponent;
        }
    }
    
    /*NBTTagList lines = compound.getTagList("Lines", NBTUtils.TAG_STRING);
    for (int i = 0; i < LINES_NB; i++)
      this.text[i] = new TextComponentString(lines.getStringTagAt(i));*/
  }

  @Override
  public NBTTagCompound writeToNBT(NBTTagCompound compound) {
	  super.writeToNBT(compound);
	  
      for (int i = 0; i < LINES_NB; ++i)
      {
          String s = ITextComponent.Serializer.componentToJson(getText()[i]);
          compound.setString("Text" + (i + 1), s);
      }
      //compound.setString("color", this.color.name());

      //this.stats.writeStatsToNBT(compound);
      return compound;
	  
	  /*super.writeToNBT(compound);

    NBTTagList lines = new NBTTagList();
    for (int i = 0; i < LINES_NB; i++)
      lines.appendTag(new NBTTagString(getText()[i].getUnformattedText()));
    compound.setTag("Lines", lines);

    return compound;*/
  }

  @Override
  public SPacketUpdateTileEntity getUpdatePacket() {
    return new SPacketUpdateTileEntity(getPos(), 9, getUpdateTag());
  }

  @Override
  public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
    readFromNBT(pkt.getNbtCompound());
  }

  @Override
  public NBTTagCompound getUpdateTag() {
    return writeToNBT(new NBTTagCompound());
  }
}
