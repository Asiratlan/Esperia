package net.esperia.capabilities.emoteplayer;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class EmotePlayerProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IEmotePlayer.class)
    public static final Capability<IEmotePlayer> PLAYER_EMOTE = null;

    private IEmotePlayer instance = PLAYER_EMOTE.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PLAYER_EMOTE;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PLAYER_EMOTE ? PLAYER_EMOTE.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return PLAYER_EMOTE.getStorage().writeNBT(PLAYER_EMOTE, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PLAYER_EMOTE.getStorage().readNBT(PLAYER_EMOTE, this.instance, null, nbt);
		
	}

}
