package net.esperia.models;

import org.lwjgl.opengl.GL11;

import net.esperia.entity.EntityFox;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.MathHelper;

public class ModelFox extends ModelBase {

    ModelRenderer renardHead;
    ModelRenderer body;
    ModelRenderer legBackRight;
    ModelRenderer legBackLeft;
    ModelRenderer legFrontRight;
    ModelRenderer legFrontLeft;
    ModelRenderer ear1;
    ModelRenderer ear2;
    ModelRenderer nose1;
    ModelRenderer nose2;
    ModelRenderer tail;
    ModelRenderer whiskers1;
    ModelRenderer whiskers2;
    
    
    int field_78163_i = 1;

    public ModelFox()
    {
    	init();
    }

    
    public void init() {
    	/*
        this.setTextureOffset("head.main", 0, 0);   //6,6,4
        this.setTextureOffset("head.nose1", 0, 10); //4,3,3
        this.setTextureOffset("head.nose2",12, 10); //2,2,2
        this.setTextureOffset("head.ear1", 0, 17);  //2,3,0
        this.setTextureOffset("head.ear2", 0, 21);  //2,3,0
        this.setTextureOffset("body", 25, 0);       //6,14,6
        this.setTextureOffset("leg.back", 0, 25);   //2,5,2
        this.setTextureOffset("leg.front",18,25);  //2,5,2
        this.setTextureOffset("tail",50, 0);       //3,3,10
        */
    	
    	this.boxList.clear();
        this.renardHead = new ModelRenderer(this, 0, 0);
        this.renardHead.addBox( -3F, -3F, -2F, 6, 6, 4);	 
        this.renardHead.setRotationPoint(-1F, 15.5F, -7F);	//<<--- x--1 y-15.5 z--7
        //nose1 = new ModelRenderer(this, 0, 10);
        //nose1.addBox(-3F, -3F, -3F, 3, 3, 3);
        //nose1.setRotationPoint(1F, 2.5F, -2F);       		 //nose1.setRotationPoint(0F, 18F, -9F);
        //this.renardHead.addChild(nose1);
        //nose2 = new ModelRenderer(this, 15, 10);
        //nose2.addBox( -1F, -1F, -2F, 2, 2, 2);
        //nose2.setRotationPoint(0F, 1.5F, -5F);				//nose2.setRotationPoint(-1F, 17F, -12F);
        nose1 = new ModelRenderer(this, 0, 10);
        nose1.addBox(-3F, -3F, -5F, 2, 1, 4);
        nose1.setRotationPoint(2.0F, 2.5F, 0F);       		 //nose1.setRotationPoint(0F, 18F, -9F);
        this.renardHead.addChild(nose1);
        setRotation(nose1, 0.1F, 0F, 0F);
        nose2 = new ModelRenderer(this, 12, 10);
        nose2.addBox( -1.0F, 0F, -1F, 2, 1, 3);
        nose2.setRotationPoint(0F, 0.5F, -4F);
        this.renardHead.addChild(nose2);        
        
        ear1 = new ModelRenderer(this, 0, 18);
        ear1.addBox( -1F, -3F, -0.5F, 2, 3, 0);
        ear1.setRotationPoint(-2F, -3F, -1F);				//ear1.setRotationPoint(-3F, 12.5F, -8F);
        setRotation(ear1, 0.1745329F, 0F, -0.1745329F);
        this.renardHead.addChild(ear1);
        ear2 = new ModelRenderer(this, 5, 18);
        ear2.addBox( -1F, -3F, -0.5F, 2, 3, 0);        
        ear2.setRotationPoint(2F, -3F, -1F);				//ear2.setRotationPoint(1F, 12.5F, -8F);        
        setRotation(ear2, 0.1745329F, 0F, 0.1745329F);
        this.renardHead.addChild(ear2);
        
        whiskers1 = new ModelRenderer(this, 0, 22);
        whiskers1.addBox(0F, 0F, 0F, 3, 3, 0);
        whiskers1.setRotationPoint(-1F,-1.5F,-3.5F);
        this.renardHead.addChild(whiskers1);
        setRotation(whiskers1, 0F, 2.9F, 0F);
        
        whiskers2 = new ModelRenderer(this, 0, 22);
        whiskers2.addBox(0F, 0F, 0F, 3, 3, 0);
        whiskers2.setRotationPoint(1F,-1.5F,-3.5F);
        whiskers2.mirror = true;
        this.renardHead.addChild(whiskers2);
        setRotation(whiskers2, 0F, 0.5F, 0F);
        
        body = new ModelRenderer(this, 24, 0);
        body.addBox(-4F, -2F, -3F, 6, 6, 14);
        body.setRotationPoint(0F, 16F, -3F);
        
        legBackRight = new ModelRenderer(this, 32, 25);
        legBackRight.addBox(-1F, 0F, -1F, 2, 5, 2);
        legBackRight.setRotationPoint(-2.5F, 19F, 7F);
        legBackRight.mirror = true;
        legBackLeft = new ModelRenderer(this, 41, 25);
        legBackLeft.addBox(-1F, 0F, -1F, 2, 5, 2);
        legBackLeft.setRotationPoint(0.5F, 19F, 7F);
        
        legFrontRight = new ModelRenderer(this, 41, 25);
        legFrontRight.addBox(-1F, 0F, -1F, 2, 5, 2);
        legFrontRight.setRotationPoint(-2.5F, 19F, -4F);
        legFrontRight.mirror = true;
        legFrontLeft = new ModelRenderer(this, 32, 25);
        legFrontLeft.addBox(-1F, 0F, -1F, 2, 5, 2);
        legFrontLeft.setRotationPoint(0.5F, 19F, -4F);
        
        tail = new ModelRenderer(this, 5, 19);
        tail.addBox(-1F, -1F, 0F, 3, 3, 10);
        tail.setRotationPoint(-1.5F, 15F, 9F);
        setRotation(tail, -0.5410521F, 0F, 0F);
    }
    
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
    
    
    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

        if (this.isChild)
        {
            float var8 = 2.0F;
            GL11.glPushMatrix();
            GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
            GL11.glTranslatef(0.0F, 10.0F * par7, 4.0F * par7);
            this.renardHead.render(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
            GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
            this.body.render(par7);
            this.legBackLeft.render(par7);
            this.legBackRight.render(par7);
            this.legFrontLeft.render(par7);
            this.legFrontRight.render(par7);
            this.tail.render(par7);
            GL11.glPopMatrix();
        }
        else
        {
            this.renardHead.render(par7);
            this.body.render(par7);
            this.legBackLeft.render(par7);
            this.legBackRight.render(par7);
            this.legFrontLeft.render(par7);
            this.legFrontRight.render(par7);
            this.tail.render(par7);
        }
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     * 
     * par1 : bras
     * par2 : jambe 
     * par3 : duree de vie de l'entité en tick
     * par4 et 5 : tete
     * par6 = 0.0625
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
    	this.renardHead.rotateAngleX = par5 / (180F / (float)Math.PI);
        this.renardHead.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.legBackLeft.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        this.legBackRight.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
        this.legFrontRight.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    	
        //
        
        this.ear1.rotateAngleY = MathHelper.cos(par5/2);
        this.ear2.rotateAngleY = -MathHelper.cos(par5/2);
        
        if(this.field_78163_i == 2) {
        	this.tail.rotateAngleY = MathHelper.cos(par3/4F);
        } else {
        	this.tail.rotateAngleX = -1.1F + 0.47123894F * MathHelper.cos(par1) * (par2*1.5F);
        }
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLiving par1EntityLiving, float par2, float par3, float par4)
    {
        EntityFox var5 = (EntityFox)par1EntityLiving;
        this.body.rotationPointY = 16.0F;
        this.body.rotationPointZ = -3.0F;
        this.body.rotateAngleX = 0;
        this.renardHead.rotationPointY = 15.5F;
        this.renardHead.rotationPointZ = -7.0F;
        this.tail.rotationPointY = 15.0F;
        this.tail.rotationPointZ = 9.0F;
        this.tail.rotateAngleX = -1.1F;
        
        this.legFrontLeft.rotationPointY = this.legFrontRight.rotationPointY = 19.0F;
        this.legFrontLeft.rotationPointZ = this.legFrontRight.rotationPointZ = -4.0F;
        this.legBackLeft.rotationPointY = this.legBackRight.rotationPointY = 19.0F;
        this.legBackLeft.rotationPointZ = this.legBackRight.rotationPointZ = 7.0F;        
        this.legBackLeft.rotateAngleX = this.legFrontLeft.rotateAngleX = 0.0F;
        
        this.field_78163_i = 0;
        
        if (var5.isSneaking())
        {
            /*++this.body.rotationPointY;
            this.renardHead.rotationPointY += 2.0F;
            ++this.tail.rotationPointY;
            this.tail.rotateAngleX = ((float)Math.PI / 2F);
            this.tail.rotateAngleX = ((float)Math.PI / 2F);
            this.field_78163_i = 0;*/
        }
        else if (var5.isSprinting())
        {
            this.tail.rotateAngleX = ((float)Math.PI / 2F);

        }   
        else
        {
            this.field_78163_i = 1;
        }
    }
}
