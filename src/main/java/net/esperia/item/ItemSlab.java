package net.esperia.item;

import net.esperia.Esperia;
import net.esperia.block.BlockClaySlab;
import net.esperia.block.BlockClaySlab_b;
import net.esperia.block.BlockConcreteSlab;
import net.esperia.block.BlockConcreteSlab_b;
import net.esperia.block.BlockHaySlab;
import net.esperia.block.BlockSlab;
import net.esperia.block.BlockStoneSlab;
import net.esperia.block.BlockStoneSlab_b;
import net.esperia.block.BlockWoolSlab;
import net.esperia.block.BlockWoolSlab_b;
import net.minecraft.block.Block;

/**
 * Wrapper around ItemSlab to allow init from GameRegistry.
 * 
 * @author jrowlett
 *
 */
public class ItemSlab extends net.minecraft.item.ItemSlab {
	/**
	 * Initializes a new instance of the ItemBlockStainedBrickSlab class.
	 * 
	 * @param block
	 *            the block behind the item.
	 * @param hay_block
	 *            the half height slab.
	 * @param double_hay_slab
	 *            the full height slab.
	 * @param stacked
	 *            whether or not the block is the stacked version.
	 */
	
	public ItemSlab(final Block block, final BlockSlab slab, final BlockSlab doubleSlab, final Boolean stacked) {
		super(block, slab, doubleSlab);
	}
	
	public ItemSlab(final Block block, final BlockHaySlab hay_block, final BlockHaySlab double_hay_slab, final Boolean stacked) {
		super(block, hay_block, double_hay_slab);
	}
	
	public ItemSlab(final Block block, final BlockClaySlab slab, final BlockClaySlab doubleSlab, final Boolean stacked) {
		super(block, slab, doubleSlab);
	}
	
	public ItemSlab(final Block block, final BlockClaySlab_b slab, final BlockClaySlab_b doubleSlab, final Boolean stacked) {
		super(block, slab, doubleSlab);
	}
	
	public ItemSlab(final Block block, final BlockWoolSlab slab, final BlockWoolSlab doubleSlab, final Boolean stacked) {
		super(block, slab, doubleSlab);
	}
	
	public ItemSlab(final Block block, final BlockWoolSlab_b slab, final BlockWoolSlab_b doubleSlab, final Boolean stacked) {
		super(block, slab, doubleSlab);
	}

	public ItemSlab(final Block block, final BlockStoneSlab slab, final BlockStoneSlab doubleSlab, boolean stacked) {
		super(block, slab, doubleSlab);
	}

	public ItemSlab(final Block block, final BlockStoneSlab_b slab, final BlockStoneSlab_b doubleSlab, boolean stacked) {
		super(block, slab, doubleSlab);
	}
	
	public ItemSlab(final Block block, final BlockConcreteSlab slab, final BlockConcreteSlab doubleSlab, boolean stacked) {
		super(block, slab, doubleSlab);
	}

	public ItemSlab(final Block block, final BlockConcreteSlab_b slab, final BlockConcreteSlab_b doubleSlab, boolean stacked) {
		super(block, slab, doubleSlab);
	}
	
	 public void registerItemModel() {
			Esperia.proxy.registerItemRenderer(this, 0, getRegistryName().getResourcePath());
	}
}
