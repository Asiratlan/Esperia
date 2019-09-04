package net.esperia.block;

import java.util.Random;

import net.esperia.BlocksRegistry;
import net.esperia.ItemsRegistry;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BlockBarrel extends BlockSimple {

    public static final PropertyInteger SIZE = PropertyInteger.create("size", 0, 15);
    public BarrelType content;

    public BlockBarrel(String name, BarrelType content) {
        super(name, Material.WOOD, SoundType.WOOD, 1.5F);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.MISC);
        this.content = content;
        this.setDefaultState(this.blockState.getBaseState().withProperty(SIZE, 0));
    }

    protected PropertyInteger getSizeProperty() {
        return SIZE;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(SIZE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(SIZE);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{SIZE});
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    public enum BarrelType {
        WATER, MILK, BEER, RHUM, WINE, CIDER, MEAD, EMPTY;
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(SIZE, content != BarrelType.EMPTY ? 15 : 0);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return new ItemStack(BlocksRegistry.empty_barrel, 1, 1).getItem();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY,
            float hitZ) {
        if (playerIn.getHeldItemMainhand() != null) {
            if (playerIn.getHeldItemMainhand().getItem() == net.minecraft.init.Items.STICK) {
                int size = state.getValue(SIZE);
                if (!worldIn.isRemote) {
                    if (size > 0) {
                        playerIn.sendMessage(new TextComponentString("Le fut contient encore " + size + " verres.").setStyle(new Style().setColor(TextFormatting.YELLOW)));
                    } else {
                        playerIn.sendMessage(new TextComponentString("Le fut est vide").setStyle(new Style().setColor(TextFormatting.YELLOW)));
                    }
                }
            } else {
                switch (content) {
                    case EMPTY:
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.metal_bucket_rum) {
                            worldIn.setBlockState(pos, BlocksRegistry.rhum_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(net.minecraft.init.Items.BUCKET));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.metal_bucket_cider) {
                            worldIn.setBlockState(pos, BlocksRegistry.cider_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(net.minecraft.init.Items.BUCKET));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.metal_bucket_vine) {
                            worldIn.setBlockState(pos, BlocksRegistry.wine_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(net.minecraft.init.Items.BUCKET));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.metal_bucket_honey) {
                            worldIn.setBlockState(pos, BlocksRegistry.hydromel_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(net.minecraft.init.Items.BUCKET));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.metal_bucket_beer) {
                            worldIn.setBlockState(pos, BlocksRegistry.beer_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(net.minecraft.init.Items.BUCKET));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.wooden_bucket_rum) {
                            worldIn.setBlockState(pos, BlocksRegistry.rhum_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.wooden_bucket_cider) {
                            worldIn.setBlockState(pos, BlocksRegistry.cider_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.wooden_bucket_vine) {
                            worldIn.setBlockState(pos, BlocksRegistry.wine_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.wooden_bucket_honey) {
                            worldIn.setBlockState(pos, BlocksRegistry.hydromel_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.wooden_bucket_beer) {
                            worldIn.setBlockState(pos, BlocksRegistry.beer_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.wooden_bucket_water) {
                            worldIn.setBlockState(pos, BlocksRegistry.water_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                        } else if (playerIn.getHeldItemMainhand().getItem() == Items.WATER_BUCKET) {
                            worldIn.setBlockState(pos, BlocksRegistry.water_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.wooden_bucket_milk) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                        } else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.wooden_bucket_goatmilk) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.wooden_bucket));
                        }else if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.metal_bucket_goatmilk) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET));
                        }else if (playerIn.getHeldItemMainhand().getItem() == Items.MILK_BUCKET) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, 15));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET));
                        }
                        break;
                    case WATER:
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_tumbler_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.water_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_tumbler_water));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.clay_mug_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.water_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.clay_mug_water));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_jar_empty && state.getValue(SIZE) >= 3) {
                            worldIn.setBlockState(pos, BlocksRegistry.water_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 3));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_jar_water));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_bottle_empty && state.getValue(SIZE) >= 5) {
                            worldIn.setBlockState(pos, BlocksRegistry.water_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 5));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_bottle_water));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.gourd_empty && state.getValue(SIZE) >= 5) {
                            worldIn.setBlockState(pos, BlocksRegistry.water_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 5));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.gourd));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.teapot && state.getValue(SIZE) >= 5) {
                            worldIn.setBlockState(pos, BlocksRegistry.water_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 5));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.teapot_water));
                        }
                        break;
                    case MILK:
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_tumbler_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_tumbler_milk));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.clay_mug_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.clay_mug_milk));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_jar_empty && state.getValue(SIZE) >= 3) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 3));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_jar_milk));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_bottle_empty && state.getValue(SIZE) >= 5) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 5));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_bottle_milk));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.teapot && state.getValue(SIZE) >= 5) {
                            worldIn.setBlockState(pos, BlocksRegistry.milk_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 5));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.teapot_milk));
                        }
                        break;
                    case BEER:
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_mug_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.beer_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_mug_beer));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.clay_mug_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.beer_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.clay_mug_beer));
                        }
                        break;

                    case MEAD:
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_mug_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.hydromel_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_mug_mead));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.clay_mug_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.hydromel_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.clay_mug_mead));
                        }
                        break;

                    case CIDER:
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_tumbler_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.cider_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_tumbler_cider));
                        }

                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_bottle_empty && state.getValue(SIZE) >= 5) {
                            worldIn.setBlockState(pos, BlocksRegistry.cider_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 5));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_bottle_cider));
                        }
                        break;

                    case RHUM:
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_tumbler_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.rhum_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_tumbler_rum));
                        }

                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_bottle_rum_empty && state.getValue(SIZE) >= 5) {
                            worldIn.setBlockState(pos, BlocksRegistry.rhum_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 5));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_bottle_rum));
                        }
                        break;
                    case WINE:
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_tumbler_empty) {
                            worldIn.setBlockState(pos, BlocksRegistry.wine_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 1));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_tumbler_vine));
                        }
                        if (playerIn.getHeldItemMainhand().getItem() == ItemsRegistry.glass_bottle_empty && state.getValue(SIZE) >= 5) {
                            worldIn.setBlockState(pos, BlocksRegistry.wine_barrel.getDefaultState().withProperty(SIZE, state.getValue(SIZE) - 5));
                            playerIn.getHeldItemMainhand().shrink(1);
                            playerIn.inventory.addItemStackToInventory(new ItemStack(ItemsRegistry.glass_bottle_vine));
                        }
                        break;
                }

                if (worldIn.getBlockState(pos).getValue(SIZE) == 0) {
                    worldIn.setBlockState(pos, BlocksRegistry.empty_barrel.getDefaultState().withProperty(SIZE, 0));
                }

            }
        }
        return true;
    }
}
