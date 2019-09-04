package net.esperia.capabilities.playersize;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerSizeStorage implements IStorage<IPlayerSize>{

	@Override
	public NBTBase writeNBT(Capability<IPlayerSize> capability, IPlayerSize instance, EnumFacing side) {
		return new NBTTagFloat(instance.getSize());
	}

	@Override
	public void readNBT(Capability<IPlayerSize> capability, IPlayerSize instance, EnumFacing side, NBTBase nbt) {
		instance.setSize(((NBTTagFloat) nbt).getFloat());
	}

}
