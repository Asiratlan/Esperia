package net.esperia.models;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

public class PlayerHitbox {
	
	/**
     * Method to set the player hitbox size
     * 
     * @param player
     *            <i>(EntityPlayer)</i> Call the player from event
     * @param width
     *            <i>(float)</i> Define the player width
     * @param height
     *            <i>(float)</i> Define the player height
     * @param eyeHeight
     *            <i>(float)</i> Define the player eyes Y position
     */
    public static void setPlayerSize(EntityPlayer player, float width, float height, float eyeHeight)
    {
        AxisAlignedBB axisalignedbb = player.getEntityBoundingBox();

        player.width = width;
        
        //On ne modifie pas la taille à cause du changement de position
        //player.height = height;

        player.setEntityBoundingBox(new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ,
                axisalignedbb.minX + (double) width, axisalignedbb.minY + (double) height,
                axisalignedbb.minZ + (double) width));
        player.getEntityBoundingBox().setMaxY(axisalignedbb.maxY);

        player.eyeHeight = eyeHeight;
    }

    /**
     * Method to reset the player hitbox size to default <br>
     * height = 1.8F <br>
     * width = 0.6F <br>
     * eyeHeight = 1.62F</br>
     * 
     * @param player
     *            <i>(EntityPlayer)</i> Call the player from event
     */
    public static void resetPlayerSize(EntityPlayer player)
    {
        setPlayerSize(player, 0.6F, 1.8F, player.getDefaultEyeHeight());
    }

}
