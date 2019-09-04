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

public class TileEntityRepair extends TileEntity {

	private int charges;
	
	public TileEntityRepair(){
		this.charges = 0;
	}

	public void setCharges(int charges) {
		this.charges = charges;
		this.markDirty();
	}
	
	public int getCharges() {
		return charges;
	}
	
	public void decrCharge(){
		charges--;
		this.markDirty();
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		charges = nbt.getInteger("charges");
		int n = charges;

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("charges", charges);
		return nbt;
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
	public NBTTagCompound getUpdateTag()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("charges", charges);
		return nbt;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound nbt)
	{
		super.handleUpdateTag(nbt);
		charges = nbt.getInteger("charges");
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState){
		if(oldState.getBlock() == newState.getBlock()){
			return false;
		}	
		
		return true;
	}

}
