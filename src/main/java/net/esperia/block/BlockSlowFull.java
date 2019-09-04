/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block;

import javax.annotation.Nullable;

import net.esperia.Esperia;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 *
 * @author Tiago
 */
public class BlockSlowFull extends Block {

	protected static final AxisAlignedBB SOUL_SAND_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	protected String name;

	public BlockSlowFull(Material materialIn, String name) {
		super(Material.SAND, MapColor.BROWN);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.name = name;
		setLightOpacity(1);
		setHardness(4.0F);
		setSoundType(SoundType.SLIME);
		setRegistryName(Esperia.MOD_ID, name);
		setUnlocalizedName(Esperia.MOD_ID + "." + name);

	}

	public void registerItemModel(Item itemBlock) {
		Esperia.proxy.registerItemRenderer(itemBlock, 0, name);
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return SOUL_SAND_AABB;
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		entityIn.motionX *= 0.1D;
		entityIn.motionZ *= 0.1D;
	}
}
