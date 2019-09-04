package net.esperia.block;

import java.util.Date;
import java.util.Random;

import net.esperia.BlocksRegistry;
import net.esperia.Variables;
import net.esperia.tileentity.TileEntityLightBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Lanterne colorée.
 * 
 * @author Mc-Fr
 */
public class BlockBigLantern extends BlockSimple implements ITileEntityProvider {

	/** Indique si la lanterne est en papier */
	private final boolean burning;

	/**
	 * Crée une lanterne.
	 * 
	 * @param color
	 *            la couleur
	 * @param isPaper
	 *            en papier ou non
	 */

	public BlockBigLantern(boolean burning) {
		super("big_lantern" + (!burning ? "_off" : ""), Material.GLASS, SoundType.GLASS, 0.5f);
		if (burning) {
			setLightLevel(0.875f);
			setTickRandomly(true);
			setCreativeTab(null);
		}
		this.burning = burning;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		// if (!worldIn.isRemote) {
		super.updateTick(worldIn, pos, state, rand);
		if (this.burning) {
			if (worldIn.isRaining() && worldIn.getChunkFromBlockCoords(pos).getBiome(pos, worldIn.getBiomeProvider()).canRain() && //
				   (worldIn.canBlockSeeSky(pos) || //
					worldIn.canBlockSeeSky(pos.north()) || //
					worldIn.canBlockSeeSky(pos.east()) || //
					worldIn.canBlockSeeSky(pos.south()) || //
					worldIn.canBlockSeeSky(pos.west()))) {
				worldIn.setBlockState(pos, BlocksRegistry.big_lantern_off.getDefaultState());
			}
			
			if (worldIn.getTileEntity(pos) != null) {
				Date date_begin = ((TileEntityLightBlock) worldIn.getTileEntity(pos)).getDate();
				// Obtient le nombre de minutes depuis l'allumage ou dernier
				// changement de phase.
				if (date_begin == null)
					return;
				long timer = (new Date().getTime() - date_begin.getTime()) / (60 * 1000) % 60;
				if (timer >= Variables.LANTERN_LIT_TIME) {
					worldIn.setBlockState(pos, BlocksRegistry.big_lantern_off.getDefaultState());
					((TileEntityLightBlock) worldIn.getTileEntity(pos)).setDate(new Date());
				}
			}
		}
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (this.burning && playerIn.getHeldItemMainhand().isEmpty()) {
			worldIn.setBlockState(pos, BlocksRegistry.big_lantern_off.getDefaultState());
		} else if (playerIn.getHeldItemMainhand() != null && (playerIn.getHeldItemMainhand().getItem() == Item.getItemFromBlock(BlocksRegistry.candle_off))) {
			if(!playerIn.isCreative()){
				playerIn.getHeldItemMainhand().shrink(1);
			}
			worldIn.setBlockState(pos, BlocksRegistry.big_lantern.getDefaultState());
			((TileEntityLightBlock) worldIn.getTileEntity(pos)).setDate();
		}

		return true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityLightBlock();
	}
}
