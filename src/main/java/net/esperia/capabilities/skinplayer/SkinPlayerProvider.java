package net.esperia.capabilities.skinplayer;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SkinPlayerProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(ISkinPlayer.class)
    public static final Capability<ISkinPlayer> SKIN_DOWNLOADED = null;
	
	private ISkinPlayer instance = SKIN_DOWNLOADED.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SKIN_DOWNLOADED;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == SKIN_DOWNLOADED ? SKIN_DOWNLOADED.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return SKIN_DOWNLOADED.getStorage().writeNBT(SKIN_DOWNLOADED, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		SKIN_DOWNLOADED.getStorage().readNBT(SKIN_DOWNLOADED, this.instance, null, nbt);	
		
	}

}
