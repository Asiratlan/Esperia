package net.esperia.network;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import net.esperia.tileentity.TileEntityLargeSign;
import net.esperia.tileentity.TileEntityStoneSignEsperia;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Paquet commandant la mise à jour des notes murales chez le serveur.
 *
 * @author Mc-Fr
 */
public class UpdateWallNoteMessage implements IMessage {
  private BlockPos notePos;
  private String[] lines;
  public ITextComponent[] text;

  /**
   * Crée un paquet. Constructeur equis par Forge.
   */
  public UpdateWallNoteMessage() {
    this(null, new ITextComponent[TileEntityLargeSign.LINES_NB]);
  }

  /**
   * Crée un paquet.
   * 
   * @param signPos la position de la note
   * @param lines les lignes de texte
   */
  public UpdateWallNoteMessage(BlockPos signPos, ITextComponent[] lines) {
    this.notePos = signPos;
    this.text = lines;
  }
  
  @Override
	public void fromBytes(ByteBuf buf) {
		PacketBuffer packetBuf = new PacketBuffer(buf);
		this.notePos = packetBuf.readBlockPos();
		//color = packetBuf.readString(20);
		//this.text = new ITextComponent[4];

		for (int i = 0; i < this.text.length; i++) {
			try {
				text[i] = packetBuf.readTextComponent();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void toBytes(ByteBuf buf) {
		PacketBuffer packetBuf = new PacketBuffer(buf);
		packetBuf.writeBlockPos(notePos);
		//packetBuf.writeString(color);

		for (int i = 0; i < this.text.length; i++) {
			packetBuf.writeTextComponent(this.text[i]);
		}

	}

  /**
   * @return la position de la note
   */
  public BlockPos getNotePos() {
    return this.notePos;
  }

  /**
   * @return les lignes de texte
   */
  public ITextComponent[] getLines() {
    return this.text;
  }

  /**
   * Gestionnaire côté serveur.
   *
   * @author Mc-Fr
   */
  public static class ServerHandler implements IMessageHandler<UpdateWallNoteMessage, IMessage> {
    @Override
    public IMessage onMessage(final UpdateWallNoteMessage message, MessageContext ctx) {
      BlockPos pos = message.getNotePos();
      World world = ctx.getServerHandler().player.world;
      IBlockState state = world.getBlockState(pos);
      TileEntity te = world.getTileEntity(pos);
      
      if (!(te instanceof TileEntityLargeSign)) {
			te = new TileEntityStoneSignEsperia();
			te.setWorld(world);
			te.setPos(pos);
		}
      
      if (te instanceof TileEntityLargeSign && world.isBlockLoaded(pos)) {
        for (int i = 0; i < message.getLines().length; i++) {
          ((TileEntityLargeSign) te).getText()[i] = message.getLines()[i];
        }
      }
      te.markDirty();
      world.notifyBlockUpdate(pos, state, state, 3);

      return null;
    }
  }
}
