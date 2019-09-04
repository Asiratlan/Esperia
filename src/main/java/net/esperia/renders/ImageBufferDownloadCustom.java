package net.esperia.renders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;

import net.minecraft.client.renderer.IImageBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ImageBufferDownloadCustom implements IImageBuffer
{
    private int[] imageData;
    private int imageWidth;
    private int imageHeight;

    public BufferedImage parseUserSkin(BufferedImage image)
    {
        if (image == null)
        {
            return null;
        }
        else
        {
        	//this.imageWidth = 128;
        	//this.imageHeight = 128;
            this.imageWidth = (image.getWidth() % 64) == 0 ? image.getWidth() : 64 ;
            this.imageHeight = this.imageWidth;
            //this.imageHeight = (image.getHeight() % 64) == 0 ? image.getHeight() : 64 ;
            BufferedImage bufferedimage = new BufferedImage(this.imageWidth, this.imageHeight, 2);
            Graphics graphics = bufferedimage.getGraphics();
            graphics.drawImage(image, 0, 0, (ImageObserver)null);
            boolean flag = image.getHeight() == image.getWidth()/2;
            int multiplicateur = image.getHeight()/32;
            
            if (flag)
            {
            	
                graphics.setColor(new Color(0, 0, 0, 0));
                graphics.fillRect(0, 32*multiplicateur, this.imageWidth, 32*multiplicateur);
                graphics.drawImage(bufferedimage, 24*multiplicateur, 48*multiplicateur, 20*multiplicateur, 52*multiplicateur, 4*multiplicateur, 16*multiplicateur, 8*multiplicateur, 20*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 28*multiplicateur, 48*multiplicateur, 24*multiplicateur, 52*multiplicateur, 8*multiplicateur, 16*multiplicateur, 12*multiplicateur, 20*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 20*multiplicateur, 52*multiplicateur, 16*multiplicateur, 64*multiplicateur, 8*multiplicateur, 20*multiplicateur, 12*multiplicateur, 32*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 24*multiplicateur, 52*multiplicateur, 20*multiplicateur, 64*multiplicateur, 4*multiplicateur, 20*multiplicateur, 8*multiplicateur, 32*multiplicateur, (ImageObserver)null);
                /**/graphics.drawImage(bufferedimage, 28*multiplicateur, 52*multiplicateur, 24*multiplicateur, 64*multiplicateur, 0*multiplicateur, 20*multiplicateur, 4*multiplicateur, 32*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 32*multiplicateur, 52*multiplicateur, 28*multiplicateur, 64*multiplicateur, 12*multiplicateur, 20*multiplicateur, 16*multiplicateur, 32*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 40*multiplicateur, 48*multiplicateur, 36*multiplicateur, 52*multiplicateur, 44*multiplicateur, 16*multiplicateur, 48*multiplicateur, 20*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 44*multiplicateur, 48*multiplicateur, 40*multiplicateur, 52*multiplicateur, 48*multiplicateur, 16*multiplicateur, 52*multiplicateur, 20*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 36*multiplicateur, 52*multiplicateur, 32*multiplicateur, 64*multiplicateur, 48*multiplicateur, 20*multiplicateur, 52*multiplicateur, 32*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 40*multiplicateur, 52*multiplicateur, 36*multiplicateur, 64*multiplicateur, 44*multiplicateur, 20*multiplicateur, 48*multiplicateur, 32*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 44*multiplicateur, 52*multiplicateur, 40*multiplicateur, 64*multiplicateur, 40*multiplicateur, 20*multiplicateur, 44*multiplicateur, 32*multiplicateur, (ImageObserver)null);
                graphics.drawImage(bufferedimage, 48*multiplicateur, 52*multiplicateur, 44*multiplicateur, 64*multiplicateur, 52*multiplicateur, 20*multiplicateur, 56*multiplicateur, 32*multiplicateur, (ImageObserver)null);
            }

            graphics.dispose();
            this.imageData = ((DataBufferInt)bufferedimage.getRaster().getDataBuffer()).getData();
            this.setAreaOpaque(0, 0, 32*multiplicateur, 16*multiplicateur);

            if (flag)
            {
                this.doTransparencyHack(32*multiplicateur, 0, 64*multiplicateur, 32*multiplicateur);
            }

            this.setAreaOpaque(0, 16*multiplicateur, 64*multiplicateur, 32*multiplicateur);
            this.setAreaOpaque(16*multiplicateur, 48*multiplicateur, 48*multiplicateur, 64*multiplicateur);
            return bufferedimage;
        }
    }

    public void skinAvailable()
    {
    }

    private void doTransparencyHack(int p_189559_1_, int p_189559_2_, int p_189559_3_, int p_189559_4_)
    {
        for (int i = p_189559_1_; i < p_189559_3_; ++i)
        {
            for (int j = p_189559_2_; j < p_189559_4_; ++j)
            {
                int k = this.imageData[i + j * this.imageWidth];

                if ((k >> 24 & 255) < 128)
                {
                    return;
                }
            }
        }

        for (int l = p_189559_1_; l < p_189559_3_; ++l)
        {
            for (int i1 = p_189559_2_; i1 < p_189559_4_; ++i1)
            {
                this.imageData[l + i1 * this.imageWidth] &= 16777215;
            }
        }
    }

    /**
     * Makes the given area of the image opaque
     */
    private void setAreaOpaque(int x, int y, int width, int height)
    {
        for (int i = x; i < width; ++i)
        {
            for (int j = y; j < height; ++j)
            {
                this.imageData[i + j * this.imageWidth] |= -16777216;
            }
        }
    }
}