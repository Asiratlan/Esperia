package net.esperia.util.positions;

import java.util.UUID;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

public class FaceDownPosition extends Positions {

    private static final UUID facedownSpeedUUID = UUID.fromString("572810e5-d5cd-4ab5-94af-419d2c1553c9");
    private static final AttributeModifier facedownSpeed = new AttributeModifier(facedownSpeedUUID, "vitesse � plat ventre",
            -0.6D, 2);

    public AttributeModifier getSpeedModifier() {
        return facedownSpeed;
    }

    @Override
    public void setHitBox(EntityPlayer player/*, float size*/) {
        AxisAlignedBB axisalignedbb = player.getEntityBoundingBox();
        float height = 0.6F;

        //On ne modifie pas la taille à cause du changement de position
        player.height = height;
        player.eyeHeight = 0.3F;

        player.setEntityBoundingBox(new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ,
                axisalignedbb.minX + player.width, axisalignedbb.minY + (double) height,
                axisalignedbb.minZ /*- (double) 1.8F*/ + player.width));
        player.getEntityBoundingBox().setMaxY(axisalignedbb.maxY);

    }

    public static UUID getUUIDSpeedModifier() {
        return facedownSpeedUUID;
    }

}
