package net.esperia.item;

import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemClothSheet extends ItemSimple {
	EnumDyeColor color;

	public ItemClothSheet(String registryName, EnumDyeColor color) {
		super(registryName);
		this.color = color;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
		RayTraceResult raytraceresult = this.rayTrace(worldIn, player, true);
		if (raytraceresult != null) {
			BlockPos pos = raytraceresult.getBlockPos();
			if (worldIn.getTileEntity(pos) instanceof TileEntityBed) {
				IBlockState state = worldIn.getBlockState(pos);
				EnumDyeColor previousColor = ((TileEntityBed) worldIn.getTileEntity(pos)).getColor();

				BlockPos posCompl = null;
				switch (worldIn.getBlockState(pos).getValue(BlockBed.FACING)) {
				case NORTH:
					posCompl = state.getValue(BlockBed.PART) == BlockBed.EnumPartType.FOOT ? pos.north() : pos.south();
					break;
				case SOUTH:
					posCompl = state.getValue(BlockBed.PART) == BlockBed.EnumPartType.FOOT ? pos.south() : pos.north();
					break;
				case WEST:
					posCompl = state.getValue(BlockBed.PART) == BlockBed.EnumPartType.FOOT ? pos.west() : pos.east();
					break;
				case EAST:
					posCompl = state.getValue(BlockBed.PART) == BlockBed.EnumPartType.FOOT ? pos.east() : pos.west();
					break;
				default:
					break;
				}
				((TileEntityBed) worldIn.getTileEntity(pos)).setColor(this.color);
				((TileEntityBed) worldIn.getTileEntity(posCompl)).setColor(this.color);
				player.inventory.addItemStackToInventory(new ItemStack(Item.REGISTRY.getObject(
						new ResourceLocation("esperia", "cloth_sheet_" + previousColor.getName().toLowerCase())), 1,
						0));
				return new ActionResult(EnumActionResult.SUCCESS,
						new ItemStack(this, player.getHeldItem(hand).getCount() - 1, 0));
			}
		}

		return new ActionResult(EnumActionResult.FAIL, new ItemStack(this, player.getHeldItem(hand).getCount(), 0));
	}
}
