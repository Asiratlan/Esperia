package net.esperia.item;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.esperia.Esperia;
import net.esperia.chat.DiceChat;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class ItemDiceGlass extends ItemContainer {

	public ItemDiceGlass(String registryName, int size) {
		super(registryName, size);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
		int nbDices = 0;
		String values = "";
		boolean hasValues = false;

		if (stack.hasTagCompound()) {
			NBTTagList inv = stack.getTagCompound().getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
			for (int i = 0; i < inv.tagCount(); i++) {
				NBTTagCompound comp1 = inv.getCompoundTagAt(i);
				nbDices += new ItemStack(comp1).getCount();
			}

			values += stack.getTagCompound().getString("values");
			hasValues = stack.getTagCompound().getBoolean("hasValues");
		}

		if (nbDices > 0) {
			String pluriel = (nbDices > 1) ? "s" : "";
			tooltip.add("Contient " + nbDices + " dé" + pluriel);
		}

		if (hasValues)
			tooltip.add(values);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {

		ItemStack stack = playerIn.getHeldItem(hand);
		if (!playerIn.isSneaking()) {
			if (stack.hasTagCompound()) {
				NBTTagList inv = stack.getTagCompound().getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
				if (inv.tagCount() > 0) {
					List<Integer> final_results = new ArrayList<Integer>();
					for (int i = 0; i < inv.tagCount(); i++) {
						NBTTagCompound comp1 = inv.getCompoundTagAt(i);
						ItemStack de = new ItemStack(comp1);
						if (de.getItem() instanceof ItemDice) {
							List<Integer> results = ItemDice.throwDice(de, ((ItemDice) de.getItem()).value);
							final_results.addAll(results);
						}
					}

					if (!stack.getTagCompound().getBoolean("hasValues")) {
						stack.getTagCompound().setString("values", final_results.toString());
						stack.getTagCompound().setBoolean("hasValues", true);
					} else {
						if (!worldIn.isRemote) {

							for (EntityPlayerMP otherPlayer : playerIn.getServer().getPlayerList().getPlayers()) {
								double distance2 = 4D - DiceChat.getNumberBlock(playerIn, (EntityPlayer) otherPlayer);
								if (otherPlayer.getDistanceSq(playerIn) <= (distance2 * distance2)) {

									((EntityPlayer) otherPlayer).sendMessage(new TextComponentString(stack.getTagCompound().getString("values")).setStyle(new Style().setColor(TextFormatting.AQUA)));

								}

								stack.getTagCompound().setBoolean("hasValues", false);
							}
						}
					}
				}
			}

		} else {
			playerIn.openGui(Esperia.instance(), 10, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
			return EnumActionResult.PASS;
		}

		return EnumActionResult.PASS;

	}

	private boolean haveKeys(ItemStack stack) {
		if (stack.hasTagCompound()) {
			NBTTagList inv = stack.getTagCompound().getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
			return inv.tagCount() > 0;
		}
		return false;
	}
}
