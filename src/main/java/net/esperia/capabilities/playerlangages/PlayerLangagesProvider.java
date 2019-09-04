package net.esperia.capabilities.playerlangages;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerLangagesProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IPlayerLangages.class)
    public static final Capability<IPlayerLangages> PLAYER_LANGAGES = null;

    private IPlayerLangages instance = PLAYER_LANGAGES.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PLAYER_LANGAGES;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == PLAYER_LANGAGES ? PLAYER_LANGAGES.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return PLAYER_LANGAGES.getStorage().writeNBT(PLAYER_LANGAGES, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PLAYER_LANGAGES.getStorage().readNBT(PLAYER_LANGAGES, this.instance, null, nbt);	
		
	}

}
