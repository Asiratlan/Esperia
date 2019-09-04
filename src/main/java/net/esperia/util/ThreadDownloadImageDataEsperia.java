package net.esperia.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ThreadDownloadImageDataEsperia extends SimpleTexture {
	private static final Logger LOGGER = LogManager.getLogger();
    private static final AtomicInteger TEXTURE_DOWNLOADER_THREAD_ID = new AtomicInteger(0);
    //@Nullable
    private final File cacheFile;
    private final String imageUrl;
    
    private final String username;
    //@Nullable
    private final IImageBuffer imageBuffer;
    //@Nullable
    private BufferedImage bufferedImage;
    //@Nullable
    private Thread imageThread;
    private boolean textureUploaded;

    public ThreadDownloadImageDataEsperia(/*@Nullable*/ File cacheFileIn, String imageUrlIn, String username, ResourceLocation textureResourceLocation, @Nullable IImageBuffer imageBufferIn)
    {
        super(textureResourceLocation);
        this.cacheFile = cacheFileIn;
        this.imageUrl = imageUrlIn;
        this.imageBuffer = imageBufferIn;
        
        this.username = username;
    }

    private void checkTextureUploaded()
    {
        if (!this.textureUploaded)
        {
            if (this.bufferedImage != null)
            {
                if (this.textureLocation != null)
                {
                    this.deleteGlTexture();
                }

                TextureUtil.uploadTextureImage(super.getGlTextureId(), this.bufferedImage);
                this.textureUploaded = true;
            }
        }
    }
    
    public String getHash(String passwordToHash){
    	String generatedPassword = null;
    	    try {
    	    	
    	         MessageDigest md = MessageDigest.getInstance("SHA-512");
    	         byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
    	         StringBuilder sb = new StringBuilder();
    	         for(int i=0; i< bytes.length ;i++){
    	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
    	         }
    	         byte[] base64 =  Base64.encodeBase64(sb.toString().getBytes());
    	         
    	         generatedPassword = new String(base64);
    	        } 
    	       catch (NoSuchAlgorithmException e){
    	        e.printStackTrace();
    	       } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    return generatedPassword;
    	}

    public int getGlTextureId()
    {
        this.checkTextureUploaded();
        return super.getGlTextureId();
    }

    public void setBufferedImage(BufferedImage bufferedImageIn)
    {
        this.bufferedImage = bufferedImageIn;

        if (this.imageBuffer != null)
        {
            this.imageBuffer.skinAvailable();
        }
    }

    public void loadTexture(IResourceManager resourceManager) throws IOException
    {
        if (this.bufferedImage == null && this.textureLocation != null)
        {
            super.loadTexture(resourceManager);
        }

        if (this.imageThread == null)
        {
            if (this.cacheFile != null && this.cacheFile.isFile())
            {
                LOGGER.debug("Loading http texture from local cache ({})", new Object[] {this.cacheFile});

                try
                {
                    this.bufferedImage = ImageIO.read(this.cacheFile);

                    if (this.imageBuffer != null)
                    {
                        this.setBufferedImage(this.imageBuffer.parseUserSkin(this.bufferedImage));
                    }
                }
                catch (IOException ioexception)
                {
                    LOGGER.error("Couldn\'t load skin {}", new Object[] {this.cacheFile, ioexception});
                    this.loadTextureFromServer();
                }
            }
            else
            {
                this.loadTextureFromServer();
            }
        }
    }

    protected void loadTextureFromServer()
    {
        this.imageThread = new Thread("Texture Downloader #" + TEXTURE_DOWNLOADER_THREAD_ID.incrementAndGet())
        {
            public void run()
            {
                HttpURLConnection httpurlconnection = null;
                ThreadDownloadImageDataEsperia.LOGGER.debug("Downloading http texture from {} to {}", new Object[] {ThreadDownloadImageDataEsperia.this.imageUrl, ThreadDownloadImageDataEsperia.this.cacheFile});

                try
                {
                    httpurlconnection = (HttpURLConnection)(new URL(ThreadDownloadImageDataEsperia.this.imageUrl)).openConnection(Minecraft.getMinecraft().getProxy());
                    httpurlconnection.setDoInput(true);
                    httpurlconnection.setDoOutput(false);
                    httpurlconnection.setRequestProperty("X-API-KEY", ThreadDownloadImageDataEsperia.this.getHash(ThreadDownloadImageDataEsperia.this.username));
                    httpurlconnection.connect();

                    if (httpurlconnection.getResponseCode() / 100 == 2)
                    {
                        BufferedImage bufferedimage;

                        if (ThreadDownloadImageDataEsperia.this.cacheFile != null)
                        {
                            FileUtils.copyInputStreamToFile(httpurlconnection.getInputStream(), ThreadDownloadImageDataEsperia.this.cacheFile);
                            bufferedimage = ImageIO.read(ThreadDownloadImageDataEsperia.this.cacheFile);
                        }
                        else
                        {
                            bufferedimage = TextureUtil.readBufferedImage(httpurlconnection.getInputStream());
                        }

                        if (ThreadDownloadImageDataEsperia.this.imageBuffer != null)
                        {
                            bufferedimage = ThreadDownloadImageDataEsperia.this.imageBuffer.parseUserSkin(bufferedimage);
                        }

                        ThreadDownloadImageDataEsperia.this.setBufferedImage(bufferedimage);
                        return;
                    }
                }
                catch (Exception exception)
                {
                	ThreadDownloadImageDataEsperia.LOGGER.error((String)"Couldn\'t download http texture", (Throwable)exception);
                    return;
                }
                finally
                {
                    if (httpurlconnection != null)
                    {
                        httpurlconnection.disconnect();
                    }
                }
            }
        };
        this.imageThread.setDaemon(true);
        this.imageThread.start();
    }

}
