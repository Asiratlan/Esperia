package net.esperia.entity;

import javax.annotation.Nullable;

import net.esperia.BlocksRegistry;
import net.esperia.ItemsRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityBee extends EntityFlying implements IMob {
	public int courseChangeCooldown = 0;
	public double waypointX;
	public double waypointY;
	public double waypointZ;
	private Entity targetedEntity = null;
	private final int attackStrength;
	private int doAction;
	private boolean destination;

	private static final DataParameter<Byte> LIMITED = EntityDataManager.<Byte>createKey(EntityBee.class,
			DataSerializers.BYTE);
	private static final DataParameter<Integer> LIMITEDX = EntityDataManager.<Integer>createKey(EntityBee.class,
			DataSerializers.VARINT);
	private static final DataParameter<Integer> LIMITEDZ = EntityDataManager.<Integer>createKey(EntityBee.class,
			DataSerializers.VARINT);

	public EntityBee(World par1World) {
		super(par1World);
		setSize(0.1F, 0.1F);
		this.ignoreFrustumCheck = true;
		this.attackStrength = 1;
		this.setLimited((byte) 0);
		this.setLimitedX(0);
		this.setLimitedZ(0);
		this.doAction = 0;
		this.destination = false;
		this.moveHelper = new EntityBee.BeeMoveHelper(this);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(LIMITED, Byte.valueOf((byte) 0)); // 16
		this.dataManager.register(LIMITEDX, new Integer(0)); // 17
		this.dataManager.register(LIMITEDZ, new Integer(0)); // 18
	}

	protected void initEntityAI() {
		this.tasks.addTask(5, new EntityBee.AIRandomFly(this));
		
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setByte("limited", (byte) (this.isLimited() ? 1 : 0));
		par1NBTTagCompound.setInteger("limitedx", this.getLimitedX());
		par1NBTTagCompound.setInteger("limitedz", this.getLimitedZ());
	}

	private Integer getLimitedZ() {
		return this.dataManager.get(LIMITEDZ);
	}

	private Integer getLimitedX() {
		return this.dataManager.get(LIMITEDX);
	}

	private Boolean isLimited() {
		return this.dataManager.get(LIMITED) == Byte.valueOf((byte) 1);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setLimited(par1NBTTagCompound.getByte("limited"));
		this.setLimitedX(par1NBTTagCompound.getInteger("limitedx"));
		this.setLimitedZ(par1NBTTagCompound.getInteger("limitedx"));
	}

	private void setLimitedZ(int integer) {
		this.dataManager.set(LIMITEDZ, Integer.valueOf(integer));
	}

	private void setLimitedX(int integer) {
		this.dataManager.set(LIMITEDX, Integer.valueOf(integer));
	}

	private void setLimited(byte byte1) {
		this.dataManager.set(LIMITED, Byte.valueOf(byte1));
	}
/*
	@Override
	public void onLivingUpdate() {
		double var1 = this.waypointX - this.posX;
		double var3 = this.waypointY - this.posY;
		double var5 = this.waypointZ - this.posZ;
		double var7 = var1 * var1 + var3 * var3 + var5 * var5;

		// si destination trop eloigner ou attinte
		if (var7 < 1.0D || var7 > 3600.0D) {
			if (var7 < 1.0D && this.destination && this.doAction != 0) {
				this.doAction--;
			} else {
				this.destination = false;
				if (this.isLimited()) {
					this.waypointX = this.getLimitedX() + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
					this.waypointZ = this.getLimitedZ() + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
				} else {
					this.waypointX = this.posX + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
					this.waypointZ = this.posZ + (this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
				}

				// Ne pas aller a plus de 8 bloc de haut.
				int groudY = this.worldObj.getHeightmapHeight((int) this.waypointX, (int) this.waypointZ);
				this.waypointY = groudY + (this.rand.nextFloat() * 8.0F);
			}
		}

		// lache la destination si imposible
		if (this.courseChangeCooldown-- <= 0) {
			this.courseChangeCooldown += this.rand.nextInt(5) + 2;
			var7 = MathHelper.sqrt_double(var7);

			if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, var7)) {
				this.motionX += var1 / var7 * 0.1D;
				this.motionY += var3 / var7 * 0.1D;
				this.motionZ += var5 / var7 * 0.1D;
			} else {
				this.destination = false;
				this.waypointX = this.posX;
				this.waypointY = this.posY;
				this.waypointZ = this.posZ;
			}
		}

		// lache la cible si deja morte
		if (this.targetedEntity != null && (this.targetedEntity.isDead || this.targetedEntity.isInWater())) {
			this.targetedEntity = null;
		}

		// Cherche la cible la plus proche
		if (this.targetedEntity == null) {
			this.targetedEntity = this.getClosestVulnerablePlayerToEntity(this, 5.0D);
			if (this.targetedEntity != null) {
				this.setLimited((byte) 0);
				this.destination = false;
			}
		}

		// si une cible en vue
		if (this.targetedEntity != null) {
			this.destination = false;
			// il se dirige vers elle
			this.waypointX = this.targetedEntity.posX;
			this.waypointY = this.targetedEntity.posY + this.targetedEntity.getEyeHeight();
			this.waypointZ = this.targetedEntity.posZ;

			var1 = this.waypointX - this.posX;
			var3 = this.waypointY - this.posY;
			var5 = this.waypointZ - this.posZ;
			var7 = var1 * var1 + var3 * var3 + var5 * var5;

			// si destination attinte
			if (var7 < 1.0D) {
				this.targetedEntity.attackEntityFrom(DamageSource.causeMobDamage(this), this.attackStrength);
			}
		} else {
			if (this.rand.nextInt(1000) == 0) {
				// chercher si ruche ou plante proche
				double distance = Integer.MAX_VALUE;
				for (int i = (int) (this.posX - 5); i <= this.posX + 5; i++) {
					for (int j = (int) (this.posY - 5); j <= this.posY + 5; j++) {
						for (int k = (int) (this.posZ - 5); k <= this.posZ + 5; k++) {
							BlockPos pos = new BlockPos(i, j, k);
							if ((this.worldObj.getBlockState(pos).getBlock() instanceof BlockFlower
									|| this.worldObj.getBlockState(pos).getBlock() == BlocksRegistry.ruche)
									&& this.getDistanceSq(i, j, k) < distance) {
								distance = this.getDistanceSq(i, j, k);
								this.destination = true;
								this.doAction = this.worldObj.getBlockState(pos).getBlock() == BlocksRegistry.ruche ? 0
										: this.rand.nextInt(300);
								this.waypointX = i;
								this.waypointY = j;
								this.waypointZ = k;
							}
						}
					}
				}
			}

			this.renderYawOffset = this.rotationYaw = -((float) Math.atan2(this.motionX, this.motionZ)) * 180.0F
					/ (float) Math.PI;
		}
	}*/

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */

    public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand, @Nullable ItemStack stack){
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
		if (var2 != null && var2.getItem() == ItemsRegistry.glass_jar_empty && var2.getCount() == 1) {
			par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem,
					new ItemStack(ItemsRegistry.glass_jar_bee, 1, 0, null));
			this.setDead();
		}
		return true;
	}

	/**
	 * True if the bee has an unobstructed line of travel to the waypoint.
	 */
	private boolean isCourseTraversable(double par1, double par3, double par5, double par7) {
		double var9 = (this.waypointX - this.posX) / par7;
		double var11 = (this.waypointY - this.posY) / par7;
		double var13 = (this.waypointZ - this.posZ) / par7;
		AxisAlignedBB var15 = this.getEntityBoundingBox();

		for (int var16 = 1; var16 < par7; ++var16) {
			var15.offset(var9, var11, var13);

			if (!this.world.getCollisionBoxes(this, var15).isEmpty()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the closest vulnerable player to this entity within the given
	 * radius, or null if none is found
	 */
	public EntityPlayer getClosestVulnerablePlayerToEntity(Entity par1Entity, double par2) {
		double par1 = par1Entity.posX;
		double par3 = par1Entity.posY;
		double par5 = par1Entity.posZ;
		double par7 = par2;
		double var9 = -1.0D;
		EntityPlayer var11 = null;

		for (int var12 = 0; var12 < this.world.playerEntities.size(); ++var12) {
			EntityPlayer var13 = (EntityPlayer) this.world.playerEntities.get(var12);

			if (!var13.capabilities.disableDamage && var13.getHeldItemMainhand() != null
					&& (var13.getHeldItemMainhand().getItem() == net.esperia.ItemsRegistry.honey
							|| Block.getBlockFromItem(var13.getHeldItemMainhand().getItem()) instanceof BlockFlower)) {
				double var14 = var13.getDistanceSq(par1, par3, par5);

				if ((par7 < 0.0D || var14 < par7 * par7) && (var9 == -1.0D || var14 < var9)) {
					var9 = var14;
					var11 = var13;
				}
			}
		}

		return var11;
	}

	public void setRuche(int x, int z) {
		this.setLimited((byte) 1);
		this.setLimitedX(x);
		this.setLimitedZ(z);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected SoundEvent getAmbientSound() {
		return null;
	}

	protected SoundEvent getHurtSound() {
		return null;
	}

	protected SoundEvent getDeathSound() {
		return null;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	@Override
	public boolean getCanSpawnHere() {
		return true;
	}

	/**
	 * Will return how many at most can spawn in a chunk at once.
	 */
	@Override
	public int getMaxSpawnedInChunk() {
		return 50;
	}

	static class AIRandomFly extends EntityAIBase {
		private final EntityBee parentEntity;

		public AIRandomFly(EntityBee bee) {
			this.parentEntity = bee;
			this.setMutexBits(1);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();

			if (!entitymovehelper.isUpdating()) {
				return true;
			} else {
				double d0 = entitymovehelper.getX() - this.parentEntity.posX;
				double d1 = entitymovehelper.getY() - this.parentEntity.posY;
				double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
        public boolean shouldContinueExecuting()
        {
            return false;
        }


		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			double var1 = this.parentEntity.waypointX - this.parentEntity.posX;
    		double var3 = this.parentEntity.waypointY - this.parentEntity.posY;
    		double var5 = this.parentEntity.waypointZ - this.parentEntity.posZ;
    		double var7 = var1 * var1 + var3 * var3 + var5 * var5;

    		// si destination trop eloigner ou attinte
    		if (var7 < 1.0D || var7 > 3600.0D) {
    			if (var7 < 1.0D && this.parentEntity.destination && this.parentEntity.doAction != 0) {
    				this.parentEntity.doAction--;
    			} else {
    				this.parentEntity.destination = false;
    				if (this.parentEntity.isLimited()) {
    					this.parentEntity.waypointX = this.parentEntity.getLimitedX() + (this.parentEntity.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
    					this.parentEntity.waypointZ = this.parentEntity.getLimitedZ() + (this.parentEntity.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
    				} else {
    					this.parentEntity.waypointX = this.parentEntity.posX + (this.parentEntity.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
    					this.parentEntity.waypointZ = this.parentEntity.posZ + (this.parentEntity.rand.nextFloat() * 2.0F - 1.0F) * 16.0F;
    				}

    				// Ne pas aller a plus de 8 bloc de haut.
    				int groudY = this.parentEntity.world.getHeight((int) this.parentEntity.waypointX, (int) this.parentEntity.waypointZ);
    				this.parentEntity.waypointY = groudY + (this.parentEntity.rand.nextFloat() * 8.0F);
    			}
    		}

    		// lache la destination si imposible
    		if (this.parentEntity.courseChangeCooldown-- <= 0) {
    			this.parentEntity.courseChangeCooldown += this.parentEntity.rand.nextInt(5) + 2;
    			var7 = MathHelper.sqrt(var7);

    			if (this.parentEntity.isCourseTraversable(this.parentEntity.waypointX, this.parentEntity.waypointY, this.parentEntity.waypointZ, var7)) {
    				this.parentEntity.motionX += var1 / var7 * 0.1D;
    				this.parentEntity.motionY += var3 / var7 * 0.1D;
    				this.parentEntity.motionZ += var5 / var7 * 0.1D;
    			} else {
    				this.parentEntity.destination = false;
    				this.parentEntity.waypointX = this.parentEntity.posX;
    				this.parentEntity.waypointY = this.parentEntity.posY;
    				this.parentEntity.waypointZ = this.parentEntity.posZ;
    			}
    		}

    		// lache la cible si deja morte
    		if (this.parentEntity.targetedEntity != null && (this.parentEntity.targetedEntity.isDead || this.parentEntity.targetedEntity.isInWater())) {
    			this.parentEntity.targetedEntity = null;
    		}

    		// Cherche la cible la plus proche
    		if (this.parentEntity.targetedEntity == null) {
    			this.parentEntity.targetedEntity = this.parentEntity.getClosestVulnerablePlayerToEntity(parentEntity, 5.0D);
    			if (this.parentEntity.targetedEntity != null) {
    				this.parentEntity.setLimited((byte) 0);
    				this.parentEntity.destination = false;
    			}
    		}

    		// si une cible en vue
    		if (this.parentEntity.targetedEntity != null) {
    			this.parentEntity.destination = false;
    			// il se dirige vers elle
    			this.parentEntity.waypointX = this.parentEntity.targetedEntity.posX;
    			this.parentEntity.waypointY = this.parentEntity.targetedEntity.posY + this.parentEntity.targetedEntity.getEyeHeight();
    			this.parentEntity.waypointZ = this.parentEntity.targetedEntity.posZ;

    			var1 = this.parentEntity.waypointX - this.parentEntity.posX;
    			var3 = this.parentEntity.waypointY - this.parentEntity.posY;
    			var5 = this.parentEntity.waypointZ - this.parentEntity.posZ;
    			var7 = var1 * var1 + var3 * var3 + var5 * var5;

    			// si destination attinte
    			if (var7 < 1.0D) {
    				this.parentEntity.targetedEntity.attackEntityFrom(DamageSource.causeMobDamage(parentEntity), this.parentEntity.attackStrength);
    			}
    		} else {
    			if (this.parentEntity.rand.nextInt(1000) == 0) {
    				// chercher si ruche ou plante proche
    				double distance = Integer.MAX_VALUE;
    				for (int i = (int) (this.parentEntity.posX - 5); i <= this.parentEntity.posX + 5; i++) {
    					for (int j = (int) (this.parentEntity.posY - 5); j <= this.parentEntity.posY + 5; j++) {
    						for (int k = (int) (this.parentEntity.posZ - 5); k <= this.parentEntity.posZ + 5; k++) {
    							BlockPos pos = new BlockPos(i, j, k);
    							if ((this.parentEntity.world.getBlockState(pos).getBlock() instanceof BlockFlower
    									|| this.parentEntity.world.getBlockState(pos).getBlock() == BlocksRegistry.hive)
    									&& this.parentEntity.getDistanceSq(i, j, k) < distance) {
    								distance = this.parentEntity.getDistanceSq(i, j, k);
    								this.parentEntity.destination = true;
    								this.parentEntity.doAction = this.parentEntity.world.getBlockState(pos).getBlock() == BlocksRegistry.hive ? 0
    										: this.parentEntity.rand.nextInt(300);
    								this.parentEntity.waypointX = i;
    								this.parentEntity.waypointY = j;
    								this.parentEntity.waypointZ = k;
    							}
    						}
    					}
    				}
    			}

    			this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw = -((float) Math.atan2(this.parentEntity.motionX, this.parentEntity.motionZ)) * 180.0F
    					/ (float) Math.PI;
    		}
		}
	}
	
    static class BeeMoveHelper extends EntityMoveHelper
    {
        private final EntityBee parentEntity;
        private int courseChangeCooldown;

        public BeeMoveHelper(EntityBee bee)
        {
            super(bee);
            this.parentEntity = bee;
        }

        public void onUpdateMoveHelper()
        {
            if (this.action == EntityMoveHelper.Action.MOVE_TO)
            {
                double d0 = this.posX - this.parentEntity.posX;
                double d1 = this.posY - this.parentEntity.posY;
                double d2 = this.posZ - this.parentEntity.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (this.courseChangeCooldown-- <= 0)
                {
                    this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
                    d3 = (double)MathHelper.sqrt(d3);

                    if (this.isNotColliding(this.posX, this.posY, this.posZ, d3))
                    {
                        this.parentEntity.motionX += d0 / d3 * 0.1D;
                        this.parentEntity.motionY += d1 / d3 * 0.1D;
                        this.parentEntity.motionZ += d2 / d3 * 0.1D;
                    }
                    else
                    {
                        this.action = EntityMoveHelper.Action.WAIT;
                    }
                }
            }
        }
        private boolean isNotColliding(double x, double y, double z, double p_179926_7_)
        {
            double d0 = (x - this.parentEntity.posX) / p_179926_7_;
            double d1 = (y - this.parentEntity.posY) / p_179926_7_;
            double d2 = (z - this.parentEntity.posZ) / p_179926_7_;
            AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

            for (int i = 1; (double)i < p_179926_7_; ++i)
            {
                axisalignedbb = axisalignedbb.offset(d0, d1, d2);

                if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty())
                {
                    return false;
                }
            }

            return true;
        }
    }
}
