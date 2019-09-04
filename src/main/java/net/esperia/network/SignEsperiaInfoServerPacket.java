package net.esperia.network;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import net.esperia.tileentity.TileEntityHRPSignEsperia;
import net.esperia.tileentity.TileEntityHRPSignEsperia.SignColor;
import net.esperia.tileentity.TileEntityStoneSignEsperia;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class SignEsperiaInfoServerPacket implements IMessage {

	public BlockPos pos;
	// public int[] rowLocations = new int[4];
	// public int[] rowSizes = { 0, 0, 0, 0 };
	public ITextComponent[] text;
	public String color;

	public SignEsperiaInfoServerPacket() {

	}

	public SignEsperiaInfoServerPacket(TileEntityHRPSignEsperia tileEntity) {
		this(tileEntity.getPos(), tileEntity.signText, tileEntity.getColor().name());
	}
	
	public SignEsperiaInfoServerPacket(TileEntityStoneSignEsperia tileEntity) {
		this(tileEntity.getPos(), tileEntity.signText, tileEntity.getColor().name());
	}
	
	public SignEsperiaInfoServerPacket(BlockPos pos, ITextComponent[] text, String color) {
		this.pos = pos;
		this.text = text;
		this.color = color;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		PacketBuffer packetBuf = new PacketBuffer(buf);
		pos = packetBuf.readBlockPos();
		color = packetBuf.readString(20);
		text = new ITextComponent[4];

		for (int i = 0; i < this.text.length; i++) {
			try {
				this.text[i] = packetBuf.readTextComponent();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void toBytes(ByteBuf buf) {
		PacketBuffer packetBuf = new PacketBuffer(buf);
		packetBuf.writeBlockPos(pos);
		packetBuf.writeString(color);

		for (int i = 0; i < this.text.length; i++) {
			packetBuf.writeTextComponent(text[i]);
		}

	}

	public static class ServerHandler implements IMessageHandler<SignEsperiaInfoServerPacket, IMessage> {

		@Override
		public IMessage onMessage(final SignEsperiaInfoServerPacket message, MessageContext ctx) {
			if (ctx.side != Side.SERVER)
				return null;
			EntityPlayerMP player = ctx.getServerHandler().player;
			player.markPlayerActive();
			
			WorldServer worldserver = FMLCommonHandler.instance().getMinecraftServerInstance()
					.getWorld(player.dimension);
			BlockPos pos = message.pos;

			if (worldserver.isBlockLoaded(pos)) {
				TileEntity tileentity = worldserver.getTileEntity(pos);

				if (tileentity instanceof TileEntityHRPSignEsperia) {
					TileEntityHRPSignEsperia sign = (TileEntityHRPSignEsperia) tileentity;
					sign.setColor(SignColor.valueOf(message.color));
					System.arraycopy(message.text, 0, sign.signText, 0, 4);
					sign.markDirty();

					IBlockState iblockstate = worldserver.getBlockState(pos);
					worldserver.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);
				}
				else if (tileentity instanceof TileEntityStoneSignEsperia) {
					TileEntityStoneSignEsperia sign = (TileEntityStoneSignEsperia) tileentity;
					//sign.setColor(SignColor.valueOf(message.color));
					System.arraycopy(message.text, 0, sign.signText, 0, 4);
					sign.markDirty();

					IBlockState iblockstate = worldserver.getBlockState(pos);
					worldserver.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);
				}
			}
			return null;

		}
	}
}
