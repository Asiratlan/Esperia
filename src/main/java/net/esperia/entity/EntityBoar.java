package net.esperia.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import net.esperia.handler.LootTableHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBoar extends EntityMob {

    private static final DataParameter<Byte> CLIMBING = EntityDataManager.<Byte>createKey(EntityBoar.class,
            DataSerializers.BYTE);
    private static final UUID ATTACK_SPEED_BOOST_MODIFIER_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
    private static final AttributeModifier ATTACK_SPEED_BOOST_MODIFIER = (new AttributeModifier(ATTACK_SPEED_BOOST_MODIFIER_UUID, "Attacking speed boost", 0.00D, 0)).setSaved(false);
    private int angerLevel;
    private int randomSoundDelay;
    private UUID angerTargetUUID;

    public boolean isAttacking;
    private final int field_35185_e;
    private int field_70826_g = 0;

    public EntityBoar(World par1World) {
        super(par1World);
        isAttacking = false;
        field_35185_e = 0;
        setSize(0.9F, 0.9F);
    }

    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.2F));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 0.6D, true));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 4.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityBoar.AIHurtByAggressor(this));
        this.targetTasks.addTask(2, new EntityBoar.AITargetAggressor(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(CLIMBING, Byte.valueOf((byte) 0));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIG_AMBIENT;
    }

    protected SoundEvent getHurtSound() {
        return SoundEvents.ENTITY_PIG_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PIG_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTableHandler.BOAR;
    }

    public EntityBoar createChild(EntityAgeable ageable) {
        return new EntityBoar(this.world);
    }

    @Override
    public void onUpdate() // vitesse
    {
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
                .setBaseValue(this.getAttackTarget() != null ? 0.75D : 0.30D);

        if (this.rand.nextInt(50) == 0 && !world.isRemote) {
            if (this.world.getBlockState(new BlockPos((int) this.posX, (int) this.posY - 1, (int) this.posZ))
                    .getBlock() == Block.getBlockFromName("grass")) {
                this.world.setBlockState(new BlockPos((int) this.posX, (int) this.posY - 1, (int) this.posZ),
                        Block.getBlockFromName("dirt").getDefaultState());
            }
        }

        super.onUpdate();
    }

    /*
	 * carcasse ajout & modif protected void updateEntityActionState() { if
	 * (!(this.isCorpses())) { super.updateEntityActionState(); } }
	 * 
	 * // carcasse fin ajout
     */
    public void setRevengeTarget(@Nullable EntityLivingBase livingBase) {
        super.setRevengeTarget(livingBase);

        if (livingBase != null) {
            this.angerTargetUUID = livingBase.getUniqueID();
        }
    }

    protected void applyEntityAI() {
        this.targetTasks.addTask(1, new EntityBoar.AIHurtByAggressor(this));
        this.targetTasks.addTask(2, new EntityBoar.AITargetAggressor(this));
    }

    protected void updateAITasks() {
        IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

        if (this.isAngry()) {
            if (!this.isChild() && !iattributeinstance.hasModifier(ATTACK_SPEED_BOOST_MODIFIER)) {
                iattributeinstance.applyModifier(ATTACK_SPEED_BOOST_MODIFIER);
            }

            --this.angerLevel;
        } else if (iattributeinstance.hasModifier(ATTACK_SPEED_BOOST_MODIFIER)) {
            iattributeinstance.removeModifier(ATTACK_SPEED_BOOST_MODIFIER);
        }

        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
            this.playSound(SoundEvents.ENTITY_ZOMBIE_PIG_ANGRY, this.getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }

        if (this.angerLevel > 0 && this.angerTargetUUID != null && this.getAttackingEntity() == null) {
            EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
            this.setRevengeTarget(entityplayer);
            this.attackingPlayer = entityplayer;
            this.recentlyHit = this.getRevengeTimer();
        }

        super.updateAITasks();
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this
     * entity.
     */
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }

    /**
     * Checks that the entity is not colliding with any blocks / liquids
     */
    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setShort("Anger", (short) this.angerLevel);

        if (this.angerTargetUUID != null) {
            compound.setString("HurtBy", this.angerTargetUUID.toString());
        } else {
            compound.setString("HurtBy", "");
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.angerLevel = compound.getShort("Anger");
        String s = compound.getString("HurtBy");

        if (!s.isEmpty()) {
            this.angerTargetUUID = UUID.fromString(s);
            EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
            this.setRevengeTarget(entityplayer);

            if (entityplayer != null) {
                this.attackingPlayer = entityplayer;
                this.recentlyHit = this.getRevengeTimer();
            }
        }
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();

            if (entity instanceof EntityPlayer) {
                this.becomeAngryAt(entity);
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    /**
     * Causes this PigZombie to become angry at the supplied Entity (which will
     * be a player).
     */
    private void becomeAngryAt(Entity p_70835_1_) {
        this.angerLevel = 400 + this.rand.nextInt(400);
        this.randomSoundDelay = this.rand.nextInt(40);

        if (p_70835_1_ instanceof EntityLivingBase) {
            this.setRevengeTarget((EntityLivingBase) p_70835_1_);
        }
    }

    public boolean isAngry() {
        return this.angerLevel > 0;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack) {
        return false;
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob
     * spawner, natural spawning etc, but not called when entity is reloaded
     * from nbt. Mainly used for initializing attributes and inventory
     */
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        super.onInitialSpawn(difficulty, livingdata);
        return livingdata;
    }

    static class AIHurtByAggressor extends EntityAIHurtByTarget {

        public AIHurtByAggressor(EntityBoar p_i45828_1_) {
            super(p_i45828_1_, true, new Class[0]);
        }

        protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn) {
            super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);

            if (creatureIn instanceof EntityBoar) {
                ((EntityBoar) creatureIn).becomeAngryAt(entityLivingBaseIn);
            }
        }
    }

    static class AITargetAggressor extends EntityAINearestAttackableTarget<EntityPlayer> {

        public AITargetAggressor(EntityBoar p_i45829_1_) {
            super(p_i45829_1_, EntityPlayer.class, true);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            return ((EntityBoar) this.taskOwner).isAngry() && super.shouldExecute();
        }
    }

}
