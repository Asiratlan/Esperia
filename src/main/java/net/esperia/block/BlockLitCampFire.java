package net.esperia.block;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.esperia.BlocksRegistry;
import net.esperia.Variables;
import net.esperia.tileentity.TileEntityLightBlock;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Feu de camp allumé.
 *
 * @author Mc-Fr
 */
public class BlockLitCampFire extends BlockCampfireBase {

    /**
     * Nombre maximal d'états
     */
    public static final int MAX_STAGE = 2;
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, MAX_STAGE);

    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 0.1D, 0.8D);

    /**
     * Table des loots
     */
    private final Map<Item, Item> loots = new HashMap<>();

    public BlockLitCampFire() {
        super(true);
        setTickRandomly(true);
        setLightLevel(1.0f);
        setDefaultState(this.blockState.getBaseState().withProperty(STAGE, 0));
    }
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
    }
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
         return AABB;
    }

    /**
     * Ajoute une recette.
     *
     * @param itemBefore l'item en entrée
     * @param itemAfter l'item en sortie
     */
    public void addRecipe(Item itemBefore, Item itemAfter) {
        this.loots.put(itemBefore, itemAfter);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        ItemStack heldItem = playerIn.getHeldItem(hand);
        ItemStack loot = new ItemStack((Item) null);
        boolean shouldPutOut = false;

        if (heldItem != null) {
            if (heldItem.getItem() == Items.STICK) {
                int stage = state.getValue(STAGE);

                if (stage < MAX_STAGE) {
                    heldItem.shrink(1);
                    worldIn.setBlockState(pos, state.withProperty(STAGE, stage + 1));
                } else {
                    shouldPutOut = true;
                    int quantity = heldItem.getCount();

                    if (quantity > 4) {
                        quantity = 4;
                    }
                    heldItem.shrink(quantity);
                    loot = getLoot(heldItem, quantity);
                }
            } else if (heldItem.getItem() instanceof ItemFood) {
                loot = getLoot(heldItem);

                if (loot.getItem() != null) {
                    heldItem.shrink(1);
                    shouldPutOut = true;
                }
            }

            if (loot.getItem() != null) {
                if (!playerIn.inventory.addItemStackToInventory(loot)) {
                    EntityItem l = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, loot);

                    l.setPickupDelay(10);
                    worldIn.spawnEntity(l);
                }
            }

            if (shouldPutOut) {
                worldIn.setBlockState(pos, BlocksRegistry.campfire.getDefaultState());
            }

            return true;
        }

        return false;
    }

    /**
     * Retourne l'item correspondant à celui en entrée.
     *
     * @param stack l'item à transformer
     * @return l'item correspondant
     */
    private ItemStack getLoot(ItemStack stack) {
        return getLoot(stack, 1);
    }

    /**
     * Retourne l'item correspondant à celui en entrée et à la quantité donnée.
     *
     * @param stack l'item à transformer
     * @param quantity la quantité
     * @return l'item correspondant
     */
    private ItemStack getLoot(ItemStack stack, int quantity) {
        return new ItemStack(this.loots.get(stack.getItem()), quantity, stack.getMetadata());
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (worldIn.isRaining() && (worldIn.canBlockSeeSky(pos)
                || //
                worldIn.canBlockSeeSky(pos.north())
                || //
                worldIn.canBlockSeeSky(pos.east())
                || //
                worldIn.canBlockSeeSky(pos.south())
                || //
                worldIn.canBlockSeeSky(pos.west()))) {
            worldIn.setBlockState(pos, BlocksRegistry.campfire.getDefaultState());
        }

        if (worldIn.getTileEntity(pos) != null) {
            Date date_begin = ((TileEntityLightBlock) worldIn.getTileEntity(pos)).getDate();
            // Obtient le nombre de minutes depuis l'allumage ou dernier
            // changement de phase.
            if (date_begin == null) {
                return;
            }
            long timer = (new Date().getTime() - date_begin.getTime()) / (60 * 1000) % 60;
            if (timer >= Variables.CAMPFIRE_LIT_TIME) {
                worldIn.setBlockState(pos, BlocksRegistry.ash_layer.getDefaultState());
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
        for (int i = 0; i <= state.getValue(STAGE); i++) {
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX() + rand.nextDouble(), pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), 0, 0, 0);
        }
        for (int i = 0; i < 10; i++) {
            worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX() + 0.25 + rand.nextDouble() / 2, pos.getY() + 0.2 + rand.nextDouble() / 2, pos.getZ() + 0.25 + rand.nextDouble() / 2, 0, 0, 0);
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, STAGE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(STAGE, (meta & 3) % 3);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(STAGE);
    }
}
