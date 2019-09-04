package net.esperia.capabilities.playerdescription;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerDescriptionStorage implements IStorage<IPlayerDescription>{

	@Override
	public NBTBase writeNBT(Capability<IPlayerDescription> capability, IPlayerDescription instance, EnumFacing side) {
		// TODO Auto-generated method stub
		return new NBTTagString(instance.getDescription());
	}

	@Override
	public void readNBT(Capability<IPlayerDescription> capability, IPlayerDescription instance, EnumFacing side,
			NBTBase nbt) {
		instance.setDescription(((NBTTagString) nbt).getString());
		
	}

}
