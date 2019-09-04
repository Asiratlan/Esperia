package net.esperia.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.esperia.Esperia;
import net.esperia.chat.DiceChat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemDice extends ItemSimpleColor {

	int value;
	public String registryName;

	public ItemDice(String registryName, int value) {
		super(registryName, 8417869);
		this.registryName = registryName;
		this.maxStackSize = 16;
		this.value = value;
	}

	public void registerItemModel() {
		Esperia.proxy.registerItemRenderer(this, 0, registryName);
	}

	@Override

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		List<Integer> results = throwDice(playerIn.getHeldItem(hand), this.value);
		int result_total = 0;
		StringBuilder string_result_total = new StringBuilder();
		for (int r : results) {
			result_total += r;
			string_result_total.append(r);
			string_result_total.append(", ");
		}

		string_result_total.append("(");
		string_result_total.append(result_total);
		string_result_total.append(")");

		if (!worldIn.isRemote) {

			for (EntityPlayerMP otherPlayer : playerIn.getServer().getPlayerList().getPlayers()) {
				double distance2 = 4D - DiceChat.getNumberBlock(playerIn, (EntityPlayer) otherPlayer);
				if (otherPlayer.getDistanceSq(playerIn) <= (distance2 * distance2)) {

					((EntityPlayer) otherPlayer).sendMessage(new TextComponentString(string_result_total.toString()).setStyle(new Style().setColor(TextFormatting.AQUA)));

				}
			}
		}
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(hand));
	}

	public static List<Integer> throwDice(ItemStack stack, int value) {
		List<Integer> results = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < stack.getCount(); i++) {

			results.add(rand.nextInt(value) + 1);
		}

		return results;
	}
}
