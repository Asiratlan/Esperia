package net.esperia.tileentity;

import javax.annotation.Nullable;

import net.esperia.block.BlockShowcase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityShowcase extends TileEntity {
	public ItemStack displayedStack = ItemStack.EMPTY;
	public String displayedName = "";
	public EnumFacing facing = EnumFacing.NORTH;
	
	public String getLocalizedName() {
		return I18n.translateToLocal(displayedName);
	}

	@Nullable
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, 6969, getUpdateTag());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return writeToNBT(new NBTTagCompound());
	}

	@Override
	public void handleUpdateTag(NBTTagCompound nbt) {
		readFromNBTInternal(nbt);
		IBlockState hahaYes = world.getBlockState(pos);
		world.notifyBlockUpdate(pos, hahaYes, hahaYes, 3);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		handleUpdateTag(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		writeToNBTInternal(nbt);
		return super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		readFromNBTInternal(nbt);
	}

	public NBTTagCompound writeToNBTInternal(NBTTagCompound nbt) {
		nbt.setTag(BlockShowcase.KEY_ITEM, displayedStack.serializeNBT());
		nbt.setInteger("facing", facing.ordinal());
		return nbt;
	}

	public void readFromNBTInternal(NBTTagCompound nbt) {
		displayedStack = new ItemStack(nbt.getCompoundTag(BlockShowcase.KEY_ITEM));
		facing = EnumFacing.values()[nbt.getInteger("facing")];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(pos).expand(0, 0.5, 0);
	}
}
