package net.esperia.capabilities.playerdescription;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerDescriptionProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(IPlayerDescription.class)
    public static final Capability<IPlayerDescription> PLAYER_DESCRIPTION = null;
	
	private IPlayerDescription instance = PLAYER_DESCRIPTION.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PLAYER_DESCRIPTION;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PLAYER_DESCRIPTION ? PLAYER_DESCRIPTION.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PLAYER_DESCRIPTION.getStorage().writeNBT(PLAYER_DESCRIPTION, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PLAYER_DESCRIPTION.getStorage().readNBT(PLAYER_DESCRIPTION, this.instance, null, nbt);		
	}

}
