package net.esperia.capabilities.emoteplayer;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class EmotePlayerStorage implements IStorage<IEmotePlayer> {

	@Override
	public NBTBase writeNBT(Capability<IEmotePlayer> capability, IEmotePlayer instance, EnumFacing side) {
		// TODO Auto-generated method stub
		return new NBTTagInt(instance.getEmote());
	}

	@Override
	public void readNBT(Capability<IEmotePlayer> capability, IEmotePlayer instance, EnumFacing side, NBTBase nbt) {
		instance.setEmote(((NBTTagInt) nbt).getInt());
	}

}
