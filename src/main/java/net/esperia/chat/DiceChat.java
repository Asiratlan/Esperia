package net.esperia.chat;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

//@SideOnly(Side.SERVER)
public class DiceChat {

	public static double getNumberBlock(EntityPlayer sender, EntityPlayer receiver) {

		double number = 0;
		Vec3d senderPosition = sender.getPositionVector();
		Vec3d receiverPosition = receiver.getPositionVector();
		Vec3d direction = receiverPosition.subtract(senderPosition);
		for(double i = 0; i < 1 ; i = i + (1/Math.max(Math.max(Math.abs(direction.x), Math.abs(direction.y)), Math.abs(direction.z)))){
			if (sender.world.getBlockState(new BlockPos((i*direction.x+senderPosition.x),(i*direction.y+senderPosition.y)+1,(i*direction.z+senderPosition.z))).isOpaqueCube())
				number += 1.0D;
		}
		return number;

	}
}
