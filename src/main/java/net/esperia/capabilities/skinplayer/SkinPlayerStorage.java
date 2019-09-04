package net.esperia.capabilities.skinplayer;

import net.esperia.capabilities.skinplayer.SkinPlayer.SkinState;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class SkinPlayerStorage implements IStorage<ISkinPlayer> {

	@Override
	public NBTBase writeNBT(Capability<ISkinPlayer> capability, ISkinPlayer instance, EnumFacing side) {
		// TODO Auto-generated method stub
		return new NBTTagString(instance.getDownloaded());
	}

	@Override
	public void readNBT(Capability<ISkinPlayer> capability, ISkinPlayer instance, EnumFacing side, NBTBase nbt) {
		if(nbt instanceof NBTTagInt){
			NBTTagInt nbtInt = (NBTTagInt) nbt;
		String string = nbtInt.getInt() == 0 ? SkinState.NULL.name() : SkinState.DOWNLOADED.name();
			instance.setDownloaded(string);}
		else
			instance.setDownloaded(((NBTTagString) nbt).getString());
	}

}
