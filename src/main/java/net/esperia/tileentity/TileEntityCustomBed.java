package net.esperia.tileentity;

import net.esperia.BlocksRegistry;
import net.minecraft.block.BlockBed;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityCustomBed extends TileEntity
{
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        return compound;
    }

    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.pos, 11, this.getUpdateTag());
    }

    @SideOnly(Side.CLIENT)
    public boolean isHeadPiece()
    {
        return BlockBed.isHeadPiece(this.getBlockMetadata());
    }

    public ItemStack getItemStack()
    {
        return new ItemStack(BlocksRegistry.hay_bed_item, 1, 0);
    }
}