/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.esperia.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

/**
 *
 * @author AlmeidaCorreiaT
 */
public abstract class BlockSlab extends net.minecraft.block.BlockSlab {

	private static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");
    private static final int HALF_META_BIT = 8;


	public BlockSlab(Material materialIn) {
		super(materialIn);

		IBlockState blockState = this.blockState.getBaseState();
		blockState = blockState.withProperty(VARIANT_PROPERTY, false);
		if (!this.isDouble()) {
			blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}

		setDefaultState(blockState);
        useNeighborBrightness = true;
	}

	  /**
     * Gets the unlocalized name based on metadata/damage.
     * @param metadata block metadata.
     * @return the unlocalized name.
     */
    @Override
    public String getUnlocalizedName(final int metadata) {
        return this.getUnlocalizedName();
    }

    /**
     * Gets the value of the variant property based on the item.
     * @param itemStack item stack.
     * @return the variant value null.
     */
    public Object getVariant(final ItemStack itemStack) {
        return false;
    }

    /**
     * Gets the variant property.
     * @return the variant property null.
     */
    @Override
    public IProperty getVariantProperty() {
        return VARIANT_PROPERTY;
    }

    /**
     * Gets a block state from metadata.
     * @param meta the metadata or color value.
     * @return a block state with the meta encoded as the variant property.
     */
    @Override
    public IBlockState getStateFromMeta(final int meta) {
        IBlockState blockState = this.getDefaultState();
        blockState = blockState.withProperty(VARIANT_PROPERTY, false);
        if (!this.isDouble()) {
            EnumBlockHalf value = EnumBlockHalf.BOTTOM;
            if ((meta & HALF_META_BIT) != 0) {
                value = EnumBlockHalf.TOP;
            }

            blockState = blockState.withProperty(HALF, value);
        }

        return blockState;
    }

    /**
     * Gets the metadata value from a block state.
     * @param state the block state.
     * @return the metadata or color value.
     */
    @Override
    public int getMetaFromState(final IBlockState state) {
        if (this.isDouble()) {
           return 0;
        }

        if ((EnumBlockHalf) state.getValue(HALF) == EnumBlockHalf.TOP) {
            return HALF_META_BIT;
        } else {
            return 0;
        }
    }

    /**
     * Gets the damage for the block's item when dropped.
     * @param state the block's state.
     * @return the metadata or color value.
     */
    @Override
    public int damageDropped(final IBlockState state) {
        return 0;
    }

    /**
     * Creates the block state object.
     * @return the block state with properties defined.
     */
    @Override
    protected BlockStateContainer createBlockState()
    {
        if (this.isDouble()) {
            return new BlockStateContainer(this, new IProperty[] {VARIANT_PROPERTY});
        } else {
            return new BlockStateContainer(
                this,
                new IProperty[] {VARIANT_PROPERTY, HALF});
        }
    }
}
