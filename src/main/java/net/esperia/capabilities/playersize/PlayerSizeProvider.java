package net.esperia.capabilities.playersize;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerSizeProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(IPlayerSize.class)
    public static final Capability<IPlayerSize> PLAYER_SIZE = null;
	
	private IPlayerSize instance = PLAYER_SIZE.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PLAYER_SIZE;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PLAYER_SIZE ? PLAYER_SIZE.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PLAYER_SIZE.getStorage().writeNBT(PLAYER_SIZE, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PLAYER_SIZE.getStorage().readNBT(PLAYER_SIZE, this.instance, null, nbt);	
	}

}
