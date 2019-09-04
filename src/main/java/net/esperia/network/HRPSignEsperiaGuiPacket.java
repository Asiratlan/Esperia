package net.esperia.network;

import io.netty.buffer.ByteBuf;
import net.esperia.gui.GuiEditHRPSignEsperia;
import net.esperia.tileentity.TileEntityHRPSignEsperia;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HRPSignEsperiaGuiPacket implements IMessage {

	public BlockPos pos;
	public String texture;

	public HRPSignEsperiaGuiPacket() {

	}

	public HRPSignEsperiaGuiPacket(TileEntityHRPSignEsperia tile) {
		this.pos = tile.getPos();

	}

	@Override
	public void fromBytes(ByteBuf buf) {
		PacketBuffer packetBuf = new PacketBuffer(buf);

		this.pos = packetBuf.readBlockPos();

	}

	@Override
	public void toBytes(ByteBuf buf) {
		PacketBuffer packetBuf = new PacketBuffer(buf);

		packetBuf.writeBlockPos(pos);

	}

	public BlockPos getSignPos() {
		return this.pos;
	}

	public static class ClientHandler implements IMessageHandler<HRPSignEsperiaGuiPacket, IMessage> {

		@Override
		public IMessage onMessage(HRPSignEsperiaGuiPacket message, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(() -> {
				BlockPos pos = message.getSignPos();
				World world = Minecraft.getMinecraft().player.world;
				TileEntity te = world.getTileEntity(pos);

				if (!(te instanceof TileEntityHRPSignEsperia)) {
					te = new TileEntityHRPSignEsperia();
					te.setWorld(world);
					te.setPos(message.getSignPos());
				}

				// if (!message.isMoving)
				displayGUI(te);
			});
			return null;

		}
	}

	@SideOnly(Side.CLIENT)
	public static void displayGUI(TileEntity tileEntity) {
		FMLClientHandler.instance().getClient().displayGuiScreen(new GuiEditHRPSignEsperia((TileEntityHRPSignEsperia) tileEntity));

	}

}
