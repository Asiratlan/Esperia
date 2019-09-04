package net.esperia.tileentity;

import java.util.Date;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityLightBlock extends TileEntity {

	public Date date_begin = new Date();

	public void setDate() {
		date_begin = new Date();
		this.markDirty();
	}

	public void setDate(Date date) {
		date_begin = date;
		this.markDirty();
	}

	public Date getDate() {
		return date_begin;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		date_begin = new Date(nbt.getLong("date"));
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setLong("date", date_begin.getTime());
		return nbt;
	}
	
	@Override
	public NBTTagCompound getUpdateTag()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setLong("date", date_begin.getTime());
		return nbt;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound nbt)
	{
		super.handleUpdateTag(nbt);
		date_begin = new Date(nbt.getLong("date"));
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
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState){
		if(oldState.getBlock() == newState.getBlock()){
			return false;
		}	
		
		return true;
	}

}
