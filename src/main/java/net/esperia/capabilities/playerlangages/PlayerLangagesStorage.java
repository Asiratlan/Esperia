package net.esperia.capabilities.playerlangages;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerLangagesStorage implements IStorage<IPlayerLangages> {

	@Override
	public NBTBase writeNBT(Capability<IPlayerLangages> capability, IPlayerLangages instance, EnumFacing side) {
		return new NBTTagIntArray(instance.getLangages());
	}

	@Override
	public void readNBT(Capability<IPlayerLangages> capability, IPlayerLangages instance, EnumFacing side,
			NBTBase nbt) {
		instance.setLangages(((NBTTagIntArray) nbt).getIntArray());

	}
}
