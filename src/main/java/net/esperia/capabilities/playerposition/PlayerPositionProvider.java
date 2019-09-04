package net.esperia.capabilities.playerposition;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PlayerPositionProvider implements ICapabilitySerializable<NBTBase> {

	@CapabilityInject(IPlayerPosition.class)
    public static final Capability<IPlayerPosition> POSITION_CAP = null;

    private IPlayerPosition instance = POSITION_CAP.getDefaultInstance();

	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == POSITION_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return capability == POSITION_CAP ? POSITION_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		// TODO Auto-generated method stub
		return POSITION_CAP.getStorage().writeNBT(POSITION_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		POSITION_CAP.getStorage().readNBT(POSITION_CAP, this.instance, null, nbt);		
	}

}
