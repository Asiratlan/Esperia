package net.esperia.capabilities.playerposition;

import net.esperia.enumerator.EnumPosition;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PlayerPositionStorage implements IStorage<IPlayerPosition> {

	@Override
	public NBTBase writeNBT(Capability<IPlayerPosition> capability, IPlayerPosition instance, EnumFacing side) {
		// if(instance.getEnumPosition() != null)
		return new NBTTagString(instance.getEnumPositionValue());
		/*
		 * else switch(instance.getIntPosition()){ case 0 : return new
		 * NBTTagString(EnumPosition.STAND.name()); case 1 : return new
		 * NBTTagString(EnumPosition.SIT.name()); case 2 : return new
		 * NBTTagString(EnumPosition.LAY.name()); case 3 : return new
		 * NBTTagString(EnumPosition.FACEDOWN.name()); default : return new
		 * NBTTagString(EnumPosition.STAND.name()); }
		 */
	}

	@Override
	public void readNBT(Capability<IPlayerPosition> capability, IPlayerPosition instance, EnumFacing side,
			NBTBase nbt) {
		if (nbt instanceof NBTTagString) {
			if (((NBTTagString) nbt).getString() != null)
				instance.setEnumPositionValue(((NBTTagString) nbt).getString());
		}

		else if (nbt instanceof NBTTagInt) {
			switch (((NBTTagInt) nbt).getInt()) {
			case 0:
				instance.setEnumPositionValue(EnumPosition.STAND.name());
				break;
			case 1:
				instance.setEnumPositionValue(EnumPosition.SIT.name());
				break;
			case 2:
				instance.setEnumPositionValue(EnumPosition.LAY.name());
				break;
			case 3:
				instance.setEnumPositionValue(EnumPosition.FACEDOWN.name());
				break;
			default:
				instance.setEnumPositionValue(EnumPosition.STAND.name());
				break;
			}

		}
	}

}
