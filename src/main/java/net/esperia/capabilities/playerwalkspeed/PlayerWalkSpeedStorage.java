package net.esperia.capabilities.playerwalkspeed;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerWalkSpeedStorage implements IStorage<IPlayerWalkSpeed>{

	@Override
	public NBTBase writeNBT(Capability<IPlayerWalkSpeed> capability, IPlayerWalkSpeed instance, EnumFacing side) {
		return new NBTTagString(instance.getWalkSpeedEnumName());
	}

	@Override
	public void readNBT(Capability<IPlayerWalkSpeed> capability, IPlayerWalkSpeed instance, EnumFacing side,
			NBTBase nbt) {
		instance.saveWalkSpeed(((NBTTagString) nbt).getString());
		
	}

}
