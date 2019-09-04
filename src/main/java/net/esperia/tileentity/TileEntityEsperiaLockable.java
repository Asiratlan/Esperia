package net.esperia.tileentity;

import java.util.ArrayList;

import net.esperia.block.BlockDoorLockable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityEsperiaLockable extends TileEntity {

	private long key = 0;
	private boolean open = true;
	private ItemStack anItemStack;

	private ArrayList aList = new ArrayList();

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setLong("key", this.key);
		compound.setBoolean("open", this.open);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.key = compound.getLong("key");
		this.open = compound.getBoolean("open");
	}
	
	@Override
	public NBTTagCompound getUpdateTag()
	{
		NBTTagCompound tag = super.getUpdateTag();
		tag.setLong("key", this.key);
		tag.setBoolean("open", this.open);
		return tag;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag)
	{
		super.handleUpdateTag(tag);
		this.key = tag.getLong("key");
		this.open = tag.getBoolean("open");
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), getUpdateTag());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		if(net.getDirection() == EnumPacketDirection.CLIENTBOUND)
		{
			readFromNBT(pkt.getNbtCompound());
		}
	}

	public String messageSerrure() {
		String message = "";

		if (this.open == true) {
			message = "déverouillée";
		} else if (this.open == false) {
			message = "verrouillé";
		}

		return message;
	}

	public void serrure() {
		this.open = !this.open;
		this.markDirty();
	}

	public long getKey() {
		return this.key;
	}

	public void setKey(Long key2) {
		this.key = key2;
		this.markDirty();
	}

	public boolean getOpen() {
		return this.open;
	}

	public void setOpen(boolean open) {
		this.open = open;
		this.markDirty();
	}

	public BlockPos getComplHalfDoor(World worldIn) {
		BlockPos pos2 = null;

		switch (worldIn.getBlockState(this.pos).getValue(BlockDoorLockable.HALF)) {
		case UPPER:
			pos2 = this.pos.down();
			break;
		case LOWER:
			pos2 = this.pos.up();
			break;
		default:
			pos2 = this.pos;
			break;
		}

		return pos2;

	}
}
