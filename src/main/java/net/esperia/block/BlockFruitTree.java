package net.esperia.block;

import java.util.Random;

import net.esperia.BlocksRegistry;
import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFruitTree extends net.minecraft.block.BlockCrops {

    Item fruit;
    boolean leavesFancy = true;

    public BlockFruitTree(Item fruit, String registryName) {
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
        this.setRegistryName(Esperia.MOD_ID, registryName);
        this.setUnlocalizedName(Esperia.MOD_ID + "." + registryName);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setSoundType(SoundType.PLANT);
        this.disableStats();
        this.fruit = fruit;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return Block.FULL_BLOCK_AABB;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return FULL_BLOCK_AABB;
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return true;
    }

    @Override
    protected Item getCrop() {
        return null;
    }

    @Override
    protected Item getSeed() {
        return null;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            int age = this.getAge(state);

            if (playerIn.getHeldItemMainhand().isEmpty()) {
                Random rand = world instanceof World ? ((World) world).rand : new Random();

                if (age >= getMaxAge()) {
                    int k = 2;

                    for (int i = 0; i < 3; ++i) {
                        if (rand.nextInt(2 * getMaxAge()) <= age) {
                            k++;
                        }
                    }
                    world.setBlockState(pos, state.withProperty(AGE, 0));
                    int view = MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
                    switch (view) {
                        case 0:
                            spawnAsEntity(world, pos.north(), new ItemStack(fruit, k, 0));
                            break;
                        case 1:
                            spawnAsEntity(world, pos.east(), new ItemStack(fruit, k, 0));
                            break;
                        case 2:
                            spawnAsEntity(world, pos.south(), new ItemStack(fruit, k, 0));
                            break;
                        case 3:
                            spawnAsEntity(world, pos.west(), new ItemStack(fruit, k, 0));
                            break;

                    }

                }
            } else if (playerIn.getHeldItemMainhand().getItem() == net.minecraft.init.Items.DYE && age < getMaxAge()) {
                if (state.getBlock() != BlocksRegistry.salt_carrier) {
                    world.setBlockState(pos, state.withProperty(AGE, age + 1));
                }
            } else {
                super.onBlockActivated(world, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
            }
        }
        return true;
    }

    @Override
    protected int getAge(IBlockState state) {
        return ((Integer) state.getValue(this.getAgeProperty())).intValue();
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void setGraphicsLevel(boolean fancy) {
        this.leavesFancy = fancy;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return this.leavesFancy ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
    }

    public void registerItemModel(Item itemBlock) {
        Esperia.proxy.registerItemRenderer(itemBlock, 0, getRegistryName().getResourcePath());
    }

    public Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

}
