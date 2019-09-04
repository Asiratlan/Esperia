package net.esperia.capabilities.playerwalkspeed;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerWalkSpeedProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(IPlayerWalkSpeed.class)
    public static final Capability<IPlayerWalkSpeed> PLAYER_WALKSPEED = null;
	
	private IPlayerWalkSpeed instance = PLAYER_WALKSPEED.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PLAYER_WALKSPEED;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PLAYER_WALKSPEED ? PLAYER_WALKSPEED.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PLAYER_WALKSPEED.getStorage().writeNBT(PLAYER_WALKSPEED, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PLAYER_WALKSPEED.getStorage().readNBT(PLAYER_WALKSPEED, this.instance, null, nbt);	
	}

}
