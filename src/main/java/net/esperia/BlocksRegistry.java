package net.esperia;

import net.esperia.block.BlockBarrel;
import net.esperia.block.BlockBed;
import net.esperia.block.BlockBibliotheque;
import net.esperia.block.BlockBigLantern;
import net.esperia.block.BlockButton;
import net.esperia.block.BlockCampfire;
import net.esperia.block.BlockCandle;
import net.esperia.block.BlockCardDeck;
import net.esperia.block.BlockChain;
import net.esperia.block.BlockChair;
import net.esperia.block.BlockChessBoard;
import net.esperia.block.BlockClaySlab;
import net.esperia.block.BlockClaySlab_b;
import net.esperia.block.BlockConcreteSlab;
import net.esperia.block.BlockConcreteSlab_b;
import net.esperia.block.BlockContainerHRP;
import net.esperia.block.BlockDecal;
import net.esperia.block.BlockDistaff;
import net.esperia.block.BlockDoor;
import net.esperia.block.BlockDoorLockable;
import net.esperia.block.BlockFence;
import net.esperia.block.BlockFlowerPot;
import net.esperia.block.BlockFruitTree;
import net.esperia.block.BlockFurniture;
import net.esperia.block.BlockGlass;
import net.esperia.block.BlockGravity;
import net.esperia.block.BlockHayBall;
import net.esperia.block.BlockHaySlab;
import net.esperia.block.BlockHive;
import net.esperia.block.BlockLantern;
import net.esperia.block.BlockLayer;
import net.esperia.block.BlockLeavesStairs;
import net.esperia.block.BlockLitCampFire;
import net.esperia.block.BlockLittleChest;
import net.esperia.block.BlockLog;
import net.esperia.block.BlockLongSupport;
import net.esperia.block.BlockMushroom;
import net.esperia.block.BlockNaturalHive;
import net.esperia.block.BlockOre;
import net.esperia.block.BlockOrientable;
import net.esperia.block.BlockPane;
import net.esperia.block.BlockPlacard;
import net.esperia.block.BlockPlant;
import net.esperia.block.BlockPressurePlate;
import net.esperia.block.BlockRepairWheel;
import net.esperia.block.BlockSaltCarrier;
import net.esperia.block.BlockShowcase;
import net.esperia.block.BlockShutterPane;
import net.esperia.block.BlockSimple;
import net.esperia.block.BlockSlowFull;
import net.esperia.block.BlockSlowHalf;
import net.esperia.block.BlockSmallTable;
import net.esperia.block.BlockStairs;
import net.esperia.block.BlockStalactite;
import net.esperia.block.BlockStandingSignEsperia;
import net.esperia.block.BlockStaticSign;
import net.esperia.block.BlockStoneSlab;
import net.esperia.block.BlockStoneSlab_b;
import net.esperia.block.BlockSupport;
import net.esperia.block.BlockTable;
import net.esperia.block.BlockTrapDoorEsperia;
import net.esperia.block.BlockTrapDoorLockable;
import net.esperia.block.BlockVine;
import net.esperia.block.BlockWall;
import net.esperia.block.BlockWallNote;
import net.esperia.block.BlockWallSignEsperia;
import net.esperia.block.BlockWindowPane;
import net.esperia.block.BlockWoolSlab;
import net.esperia.block.BlockWoolSlab_b;
import net.esperia.block.cake.BlockCakeBlueCheese;
import net.esperia.block.cake.BlockCakeCheese;
import net.esperia.block.crop.BlockCropBarley;
import net.esperia.block.crop.BlockCropFlax;
import net.esperia.block.crop.BlockCropHemp;
import net.esperia.block.crop.BlockCropLettuce;
import net.esperia.block.crop.BlockCropTurnip;
import net.esperia.block.crop.vine.BlockVineGrapes;
import net.esperia.block.crop.vine.BlockVineTomato;
import net.esperia.enumerator.EnumLanternColor;
import net.esperia.item.ItemBed;
import net.esperia.item.ItemBlockSpecial;
import net.esperia.item.ItemDoor;
import net.esperia.item.ItemDoorLockable;
import net.esperia.item.ItemLayer;
import net.esperia.item.ItemShowcase;
import net.esperia.item.ItemSlab;
import net.esperia.item.ItemStalactite;
import net.esperia.item.ItemWall;
import net.esperia.item.ItemWallNote;
import net.esperia.item.ItemWindowPane;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMultiTexture;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistry;

public class BlocksRegistry {

    // TODO: Take all Blocks from Blocks.java and bring them here to the new format.	
    /**
     * Construction *
     */
    public static BlockSimple stuc = new BlockSimple("stuc", Material.SAND, SoundType.STONE, 0.8F);
    public static BlockHaySlab hay_slab = new BlockHaySlab.Half(Material.GROUND, SoundType.PLANT, "hay_slab");
    public static BlockHaySlab double_hay_slab = new BlockHaySlab.Double(Material.GROUND, SoundType.PLANT, "hay_slab_double");
    public static BlockSimple raw_slate = new BlockSimple("raw_slate", Material.ROCK, SoundType.STONE, 2.0F);
    public static BlockSimple slate = new BlockSimple("slate", Material.ROCK, SoundType.STONE, 2.0F);
    public static BlockStairs slate_stairs = new BlockStairs("slate_stairs", slate.getDefaultState());

    public static BlockGravity ash_block = new BlockGravity("ash_block", Material.SAND);
    public static BlockLayer ash_layer = (BlockLayer) new BlockLayer("ash_layer", Material.SNOW, ItemsRegistry.cinder, SoundType.SAND, 0.1F).setLightOpacity(0);
    public static BlockLayer sand_layer = (BlockLayer) new BlockLayer("sand_layer", Material.SAND, null, SoundType.SAND, 0.1F).setLightOpacity(0);
    public static BlockLayer red_sand_layer = (BlockLayer) new BlockLayer("red_sand_layer", Material.SAND, null, SoundType.SAND, 0.1F).setLightOpacity(0);
    public static BlockSimple hay_block = new BlockSimple("hay_block", Material.GROUND, SoundType.PLANT, 0.5F);
    public static BlockStairs hay_stairs = new BlockStairs("hay_stairs", hay_block.getDefaultState());
    public static BlockLayer hay_layer = (BlockLayer) new BlockLayer("hay_layer", Material.SNOW, null, SoundType.SAND, 0.1F).setLightOpacity(0);
    public static BlockHayBall old_hay_ball = new BlockHayBall("old_hay_ball");
    public static BlockSimple old_hay_block = new BlockSimple("old_hay_block", Material.GROUND, SoundType.PLANT, 0.5F);
    public static BlockStairs old_hay_stairs = new BlockStairs("old_hay_stairs", hay_block.getDefaultState());
    public static BlockLayer old_hay_layer = (BlockLayer) new BlockLayer("old_hay_layer", Material.SNOW, net.minecraft.init.Items.SNOWBALL, SoundType.SAND, 0.1F).setLightOpacity(0);
    public static BlockLayer leaves_layer = (BlockLayer) new BlockLayer("leaves_layer", Material.SNOW, null, SoundType.PLANT, 0.1F).setLightOpacity(0);
    public static BlockLayer leaves_birch_layer = (BlockLayer) new BlockLayer("leaves_birch_layer", Material.SNOW, null, SoundType.PLANT, 0.1F).setLightOpacity(0);
    public static BlockLayer leaves_spruce_layer = (BlockLayer) new BlockLayer("leaves_spruce_layer", Material.SNOW, null, SoundType.PLANT, 0.1F).setLightOpacity(0);
    public static BlockLayer leaves_jungle_layer = (BlockLayer) new BlockLayer("leaves_jungle_layer", Material.SNOW, null, SoundType.PLANT, 0.1F).setLightOpacity(0);
    public static BlockLayer leaves_acacia_layer = (BlockLayer) new BlockLayer("leaves_acacia_layer", Material.SNOW, null, SoundType.PLANT, 0.1F).setLightOpacity(0);
    public static BlockLayer leaves_dark_oak_layer = (BlockLayer) new BlockLayer("leaves_dark_oak_layer", Material.SNOW, null, SoundType.PLANT, 0.1F).setLightOpacity(0);

    public static ItemLayer sand_layer_item = new ItemLayer(sand_layer, "sand_layer");
    public static ItemLayer red_sand_layer_item = new ItemLayer(red_sand_layer, "red_sand_layer");
    public static ItemLayer ash_layer_item = new ItemLayer(ash_layer, "ash_layer");
    public static ItemLayer hay_layer_item = new ItemLayer(hay_layer, "hay_layer");
    public static ItemLayer old_hay_layer_item = new ItemLayer(old_hay_layer, "old_hay_layer");
    public static ItemLayer leaves_layer_item = new ItemLayer(leaves_layer, "leaves_layer");
    public static ItemLayer leaves_jungle_layer_item = new ItemLayer(leaves_jungle_layer, "leaves_jungle_layer");
    public static ItemLayer leaves_birch_layer_item = new ItemLayer(leaves_birch_layer, "leaves_birch_layer");
    public static ItemLayer leaves_spruce_layer_item = new ItemLayer(leaves_spruce_layer, "leaves_spruce_layer");
    public static ItemLayer leaves_acacia_layer_item = new ItemLayer(leaves_acacia_layer, "leaves_acacia_layer");
    public static ItemLayer leaves_dark_oak_layer_item = new ItemLayer(leaves_dark_oak_layer, "leaves_dark_oak_layer");
    public static BlockSimple bronze_block = new BlockSimple("bronze_block", Material.IRON, SoundType.METAL, 1.5F);
    public static BlockSimple copper_block = new BlockSimple("copper_block", Material.IRON, SoundType.METAL, 1.5F);
    public static BlockSimple lead_block = new BlockSimple("lead_block", Material.IRON, SoundType.METAL, 1.5F);
    public static BlockSimple steel_block = new BlockSimple("steel_block", Material.IRON, SoundType.METAL, 1.5F);
    public static BlockSimple silver_block = new BlockSimple("silver_block", Material.IRON, SoundType.METAL, 1.5F);
    public static BlockSimple tin_block = new BlockSimple("tin_block", Material.IRON, SoundType.METAL, 1.5F);

    public static BlockSlowHalf mud_half = new BlockSlowHalf(Material.GROUND, "mud_half");
    public static BlockSlowFull mud_full = new BlockSlowFull(Material.GROUND, "mud_full");

    public static BlockSimple timber_block = new BlockSimple("timber_block", Material.CLAY, SoundType.GROUND, 1.5F);
    public static BlockSimple timber_block_crossed = new BlockSimple("timber_block_crossed", Material.CLAY, SoundType.GROUND, 1.5F);
    public static BlockSimple timber_block_right = new BlockSimple("timber_block_right", Material.CLAY, SoundType.GROUND, 1.5F);
    public static BlockSimple timber_block_left = new BlockSimple("timber_block_left", Material.CLAY, SoundType.GROUND, 1.5F);
    public static BlockSimple timber_block_horizontal = new BlockSimple("timber_block_horizontal", Material.CLAY, SoundType.GROUND, 1.5F);
    public static BlockSimple timber_block_vertical = new BlockSimple("timber_block_vertical", Material.CLAY, SoundType.GROUND, 1.5F);

    /**
     * Decorations *
     */
    public static BlockStalactite stone_stalactite = new BlockStalactite("stone", Material.ROCK, SoundType.STONE, 1.5f);
    public static BlockStalactite icicle = new BlockStalactite("ice", Material.ICE, SoundType.GLASS, 1);

    public static BlockWallNote wall_note = new BlockWallNote();
    public static BlockStandingSignEsperia hrp_standing_sign = new BlockStandingSignEsperia("hrp_standing_sign", Material.WOOD, SoundType.WOOD);
    public static BlockWallSignEsperia hrp_wall_sign = new BlockWallSignEsperia("sign_hrp", Material.WOOD, SoundType.WOOD);
    public static BlockStandingSignEsperia stone_standing_sign = new BlockStandingSignEsperia("stone_standing_sign", Material.ROCK, SoundType.STONE);
    public static BlockWallSignEsperia stone_wall_sign = new BlockWallSignEsperia("sign_stone", Material.ROCK, SoundType.STONE);

    //public static BlockWallNoteEsperia wall_note_esperia = new BlockWallNoteEsperia("wall_note_esperia", Material.WOOD, SoundType.CLOTH);
    public static BlockCandle candle_on = new BlockCandle("candle", true);
    public static BlockCandle candle_off = new BlockCandle("candle_off", false);

    public static BlockChain chain = new BlockChain("chain", Material.IRON, SoundType.METAL, 0.5F);
    public static BlockChain rope = new BlockChain("rope", Material.CLOTH, SoundType.CLOTH, 0.5F);

    public static BlockLantern lantern_white = new BlockLantern(EnumLanternColor.values()[0], false, true);
    public static BlockLantern lantern_orange = new BlockLantern(EnumLanternColor.values()[1], false, true);
    public static BlockLantern lantern_yellow = new BlockLantern(EnumLanternColor.values()[2], false, true);
    public static BlockLantern lantern_purple = new BlockLantern(EnumLanternColor.values()[3], false, true);
    public static BlockLantern lantern_blue = new BlockLantern(EnumLanternColor.values()[4], false, true);
    public static BlockLantern lantern_green = new BlockLantern(EnumLanternColor.values()[5], false, true);
    public static BlockLantern lantern_red = new BlockLantern(EnumLanternColor.values()[6], false, true);

    public static BlockLantern paper_lantern_white = new BlockLantern(EnumLanternColor.values()[0], true, true);
    public static BlockLantern paper_lantern_orange = new BlockLantern(EnumLanternColor.values()[1], true, true);
    public static BlockLantern paper_lantern_yellow = new BlockLantern(EnumLanternColor.values()[2], true, true);
    public static BlockLantern paper_lantern_purple = new BlockLantern(EnumLanternColor.values()[3], true, true);
    public static BlockLantern paper_lantern_blue = new BlockLantern(EnumLanternColor.values()[4], true, true);
    public static BlockLantern paper_lantern_green = new BlockLantern(EnumLanternColor.values()[5], true, true);
    public static BlockLantern paper_lantern_red = new BlockLantern(EnumLanternColor.values()[6], true, true);

    public static BlockLantern lantern_off_white = new BlockLantern(EnumLanternColor.values()[0], false, false);
    public static BlockLantern lantern_off_orange = new BlockLantern(EnumLanternColor.values()[1], false, false);
    public static BlockLantern lantern_off_yellow = new BlockLantern(EnumLanternColor.values()[2], false, false);
    public static BlockLantern lantern_off_purple = new BlockLantern(EnumLanternColor.values()[3], false, false);
    public static BlockLantern lantern_off_blue = new BlockLantern(EnumLanternColor.values()[4], false, false);
    public static BlockLantern lantern_off_green = new BlockLantern(EnumLanternColor.values()[5], false, false);
    public static BlockLantern lantern_off_red = new BlockLantern(EnumLanternColor.values()[6], false, false);

    public static BlockLantern paper_lantern_off_white = new BlockLantern(EnumLanternColor.values()[0], true, false);
    public static BlockLantern paper_lantern_off_orange = new BlockLantern(EnumLanternColor.values()[1], true, false);
    public static BlockLantern paper_lantern_off_yellow = new BlockLantern(EnumLanternColor.values()[2], true, false);
    public static BlockLantern paper_lantern_off_purple = new BlockLantern(EnumLanternColor.values()[3], true, false);
    public static BlockLantern paper_lantern_off_blue = new BlockLantern(EnumLanternColor.values()[4], true, false);
    public static BlockLantern paper_lantern_off_green = new BlockLantern(EnumLanternColor.values()[5], true, false);
    public static BlockLantern paper_lantern_off_red = new BlockLantern(EnumLanternColor.values()[6], true, false);

    public static BlockBigLantern big_lantern = new BlockBigLantern(true);
    public static BlockBigLantern big_lantern_off = new BlockBigLantern(false);

    public static BlockNaturalHive hive = new BlockNaturalHive("hive");
    public static BlockHive hive_cube = new BlockHive("hive_cube");

    public static BlockCampfire campfire = new BlockCampfire();
    public static BlockLitCampFire lit_campfire = new BlockLitCampFire();

    public static BlockDecal decal_water_puddle = new BlockDecal("decal_water_puddle");
    public static BlockDecal decal_blood_puddle = new BlockDecal("decal_blood_puddle");
    public static BlockDecal decal_mud_puddle = new BlockDecal("decal_mud_puddle");

    /**
     * Bois *
     */
    public static BlockLog log_oak_mossy = new BlockLog("log_oak_mossy");
    public static BlockLog log_birch_mossy = new BlockLog("log_spruce_mossy");
    public static BlockLog log_spruce_mossy = new BlockLog("log_birch_mossy");
    public static BlockLog log_jungle_mossy = new BlockLog("log_jungle_mossy");
    public static BlockLog log_dark_oak_mossy = new BlockLog("log_acacia_mossy");
    public static BlockLog log_acacia_mossy = new BlockLog("log_dark_oak_mossy");

    public static BlockSimple planks_acacia_mossy = new BlockSimple("planks_acacia_mossy", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_acacia_cracked = new BlockSimple("planks_acacia_cracked", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_acacia_varnish = new BlockSimple("planks_acacia_varnish", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_acacia_pattern_1 = new BlockSimple("planks_acacia_pattern_1", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_acacia_pattern_2 = new BlockSimple("planks_acacia_pattern_2", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_big_oak_mossy = new BlockSimple("planks_big_oak_mossy", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_big_oak_cracked = new BlockSimple("planks_big_oak_cracked", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_big_oak_varnish = new BlockSimple("planks_big_oak_varnish", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_big_oak_pattern_1 = new BlockSimple("planks_big_oak_pattern_1", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_big_oak_pattern_2 = new BlockSimple("planks_big_oak_pattern_2", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_birch_mossy = new BlockSimple("planks_birch_mossy", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_birch_cracked = new BlockSimple("planks_birch_cracked", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_birch_varnish = new BlockSimple("planks_birch_varnish", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_birch_pattern_1 = new BlockSimple("planks_birch_pattern_1", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_birch_pattern_2 = new BlockSimple("planks_birch_pattern_2", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_jungle_mossy = new BlockSimple("planks_jungle_mossy", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_jungle_cracked = new BlockSimple("planks_jungle_cracked", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_jungle_varnish = new BlockSimple("planks_jungle_varnish", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_jungle_pattern_1 = new BlockSimple("planks_jungle_pattern_1", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_jungle_pattern_2 = new BlockSimple("planks_jungle_pattern_2", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_oak_mossy = new BlockSimple("planks_oak_mossy", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_oak_cracked = new BlockSimple("planks_oak_cracked", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_oak_varnish = new BlockSimple("planks_oak_varnish", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_oak_pattern_1 = new BlockSimple("planks_oak_pattern_1", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_oak_pattern_2 = new BlockSimple("planks_oak_pattern_2", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_spruce_mossy = new BlockSimple("planks_spruce_mossy", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_spruce_cracked = new BlockSimple("planks_spruce_cracked", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_spruce_varnish = new BlockSimple("planks_spruce_varnish", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_spruce_pattern_1 = new BlockSimple("planks_spruce_pattern_1", Material.WOOD, SoundType.WOOD, 2.0F);
    public static BlockSimple planks_spruce_pattern_2 = new BlockSimple("planks_spruce_pattern_2", Material.WOOD, SoundType.WOOD, 2.0F);

    public static BlockPane wooden_bars = new BlockPane(Material.WOOD, true, "wooden_bars");

    public static BlockWall wood_wall_spruce = new BlockWall(net.minecraft.block.Block.getBlockById(14), "wood_wall_spruce", Material.WOOD);
    public static BlockWall wood_wall_oak = new BlockWall(net.minecraft.block.Block.getBlockById(14), "wood_wall_oak", Material.WOOD);
    public static BlockWall wood_wall_birch = new BlockWall(net.minecraft.block.Block.getBlockById(14), "wood_wall_birch", Material.WOOD);
    public static BlockWall wood_wall_jungle = new BlockWall(net.minecraft.block.Block.getBlockById(14), "wood_wall_jungle", Material.WOOD);
    public static BlockWall wood_wall_acacia = new BlockWall(net.minecraft.block.Block.getBlockById(14), "wood_wall_acacia", Material.WOOD);
    public static BlockWall wood_wall_dark_oak = new BlockWall(net.minecraft.block.Block.getBlockById(14), "wood_wall_dark_oak", Material.WOOD);

    public static BlockButton button_spruce = new BlockButton(true, "button_spruce");
    public static BlockButton button_birch = new BlockButton(true, "button_birch");
    public static BlockButton button_jungle = new BlockButton(true, "button_jungle");
    public static BlockButton button_acacia = new BlockButton(true, "button_acacia");
    public static BlockButton button_dark_oak = new BlockButton(true, "button_dark_oak");

    public static BlockPressurePlate pressure_plate_spruce = new BlockPressurePlate(Material.WOOD, net.minecraft.block.BlockPressurePlate.Sensitivity.EVERYTHING, "pressure_plate_spruce");
    public static BlockPressurePlate pressure_plate_birch = new BlockPressurePlate(Material.WOOD, net.minecraft.block.BlockPressurePlate.Sensitivity.EVERYTHING, "pressure_plate_birch");
    public static BlockPressurePlate pressure_plate_jungle = new BlockPressurePlate(Material.WOOD, net.minecraft.block.BlockPressurePlate.Sensitivity.EVERYTHING, "pressure_plate_jungle");
    public static BlockPressurePlate pressure_plate_acacia = new BlockPressurePlate(Material.WOOD, net.minecraft.block.BlockPressurePlate.Sensitivity.EVERYTHING, "pressure_plate_acacia");
    public static BlockPressurePlate pressure_plate_dark_oak = new BlockPressurePlate(Material.WOOD, net.minecraft.block.BlockPressurePlate.Sensitivity.EVERYTHING, "pressure_plate_dark_oak");

    /**
     * Pierre *
     */
    public static BlockSimple cobblestone_cracked = new BlockSimple("cobblestone_cracked", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stone_slab_top = new BlockSimple("stone_slab_top", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stone_granite_smooth_mossy = new BlockSimple("stone_granite_smooth_mossy", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_granite = new BlockSimple("stonebrick_granite", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_granite_cracked = new BlockSimple("stonebrick_granite_cracked", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_granite_mossy = new BlockSimple("stonebrick_granite_mossy", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_granite_carved = new BlockSimple("stonebrick_granite_carved", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stone_granite_slab_top = new BlockSimple("stone_granite_slab_top", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stone_diorite_smooth_mossy = new BlockSimple("stone_diorite_smooth_mossy", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_diorite = new BlockSimple("stonebrick_diorite", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_diorite_cracked = new BlockSimple("stonebrick_diorite_cracked", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_diorite_mossy = new BlockSimple("stonebrick_diorite_mossy", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_diorite_carved = new BlockSimple("stonebrick_diorite_carved", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stone_diorite_slab_top = new BlockSimple("stone_diorite_slab_top", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stone_andesite_smooth_mossy = new BlockSimple("stone_andesite_smooth_mossy", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_andesite = new BlockSimple("stonebrick_andesite", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_andesite_cracked = new BlockSimple("stonebrick_andesite_cracked", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_andesite_mossy = new BlockSimple("stonebrick_andesite_mossy", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stonebrick_andesite_carved = new BlockSimple("stonebrick_andesite_carved", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple stone_andesite_slab_top = new BlockSimple("stone_andesite_slab_top", Material.ROCK, SoundType.STONE, 1.5F);

    public static BlockStairs stonebrick_andesite_stair = new BlockStairs("stonebrick_andesite_stairs", stonebrick_diorite.getDefaultState());
    public static BlockStairs stonebrick_granite_stair = new BlockStairs("stonebrick_granite_stairs", stonebrick_andesite.getDefaultState());
    public static BlockStairs stonebrick_diorite_stair = new BlockStairs("stonebrick_diorite_stairs", stonebrick_granite.getDefaultState());
    public static BlockStairs stone_andesite_stair = new BlockStairs("stone_andesite_stairs", stonebrick_diorite.getDefaultState());
    public static BlockStairs stone_granite_stair = new BlockStairs("stone_granite_stairs", stonebrick_andesite.getDefaultState());
    public static BlockStairs stone_diorite_stair = new BlockStairs("stone_diorite_stairs", stonebrick_granite.getDefaultState());
    public static BlockStairs smooth_andesite_stair = new BlockStairs("smooth_andesite_stairs", stone_andesite_slab_top.getDefaultState());
    public static BlockStairs smooth_granite_stair = new BlockStairs("smooth_granite_stairs", stone_granite_slab_top.getDefaultState());
    public static BlockStairs smooth_diorite_stair = new BlockStairs("smooth_diorite_stairs", stone_diorite_slab_top.getDefaultState());
    public static BlockStairs smooth_stone_stair = new BlockStairs("smooth_stone_stairs", stone_slab_top.getDefaultState());

    public static BlockStoneSlab stone_slab = new BlockStoneSlab.Half(Material.ROCK, SoundType.STONE, "stone_slab");
    public static BlockStoneSlab double_stone_slab = new BlockStoneSlab.Double(Material.ROCK, SoundType.STONE, "stone_slab_double");
    public static BlockStoneSlab_b stone_slab_b = new BlockStoneSlab_b.Half(Material.ROCK, SoundType.STONE, "stone_slab_b");
    public static BlockStoneSlab_b double_stone_slab_b = new BlockStoneSlab_b.Double(Material.ROCK, SoundType.STONE, "stone_slab_double_b");

    public static BlockWall stone_wall_andesite = new BlockWall(net.minecraft.block.Block.getBlockById(1), "stone_wall_andesite", Material.ROCK);
    public static BlockWall stone_wall_diorite = new BlockWall(net.minecraft.block.Block.getBlockById(1), "stone_wall_diorite", Material.ROCK);
    public static BlockWall stone_wall_granite = new BlockWall(net.minecraft.block.Block.getBlockById(1), "stone_wall_granite", Material.ROCK);

    public static BlockButton button_granite = new BlockButton(false, "button_granite");
    public static BlockButton button_diorite = new BlockButton(false, "button_diorite");
    public static BlockButton button_andesite = new BlockButton(false, "button_andesite");

    public static BlockPressurePlate pressure_plate_granite = new BlockPressurePlate(Material.ROCK, net.minecraft.block.BlockPressurePlate.Sensitivity.MOBS, "pressure_plate_granite");
    public static BlockPressurePlate pressure_plate_diorite = new BlockPressurePlate(Material.ROCK, net.minecraft.block.BlockPressurePlate.Sensitivity.MOBS, "pressure_plate_diorite");
    public static BlockPressurePlate pressure_plate_andesite = new BlockPressurePlate(Material.ROCK, net.minecraft.block.BlockPressurePlate.Sensitivity.MOBS, "pressure_plate_andesite");

    /**
     * Minerais *
     */
    public static BlockOre amethyst_ore = new BlockOre("amethyst_ore", ItemsRegistry.amethyst_gemstone);
    public static BlockOre aquamarine_ore = new BlockOre("aquamarine_ore", ItemsRegistry.aquamarine_gemstone);
    public static BlockOre charoite_ore = new BlockOre("charoite_ore", ItemsRegistry.charoite_gemstone);
    public static BlockOre citrine_ore = new BlockOre("citrine_ore", ItemsRegistry.citrine_gemstone);
    public static BlockOre coraline_ore = new BlockOre("coraline_ore", ItemsRegistry.coraline_gemstone);
    public static BlockOre hematite_ore = new BlockOre("hematite_ore", ItemsRegistry.hematite_gemstone);
    public static BlockOre malachite_ore = new BlockOre("malachite_ore", ItemsRegistry.malachite_gemstone);
    public static BlockOre opale_ore = new BlockOre("opale_ore", ItemsRegistry.opale_gemstone);
    public static BlockOre quartz_ore = new BlockOre("quartz_ore", ItemsRegistry.quartz_gemstone);
    public static BlockOre quartzrose_ore = new BlockOre("quartzrose_ore", ItemsRegistry.quartzrose_gemstone);
    public static BlockOre ruby_ore = new BlockOre("ruby_ore", ItemsRegistry.ruby_gemstone);
    public static BlockOre tigereye_ore = new BlockOre("tigereye_ore", ItemsRegistry.tigereye_gemstone);
    public static BlockOre tourmaline_ore = new BlockOre("tourmaline_ore", ItemsRegistry.tourmaline_gemstone);
    public static BlockOre turquoise_ore = new BlockOre("turquoise_ore", ItemsRegistry.turquoise_gemstone);
    public static BlockOre copper_ore = new BlockOre("copper_ore", ItemsRegistry.copper_raw);
    public static BlockOre tin_ore = new BlockOre("tin_ore", ItemsRegistry.tin_raw);
    public static BlockOre lead_ore = new BlockOre("lead_ore", ItemsRegistry.lead_raw);
    public static BlockOre silver_ore = new BlockOre("silver_ore", ItemsRegistry.silver_raw);
    public static BlockOre alun_ore = new BlockOre("alun_ore", ItemsRegistry.alun_shard, 4, 8);
    public static BlockOre salt_ore = new BlockOre("salt_ore", ItemsRegistry.salt_shard, 1, 4);
    public static BlockSaltCarrier salt_carrier = new BlockSaltCarrier(ItemsRegistry.salt, "salt_carrier");

    /**
     * Laine *
     */
    public static BlockStairs wool_colored_white_stairs = new BlockStairs("wool_colored_white_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_orange_stairs = new BlockStairs("wool_colored_orange_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_magenta_stairs = new BlockStairs("wool_colored_magenta_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_light_blue_stairs = new BlockStairs("wool_colored_light_blue_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_yellow_stairs = new BlockStairs("wool_colored_yellow_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_lime_stairs = new BlockStairs("wool_colored_lime_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_pink_stairs = new BlockStairs("wool_colored_pink_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_gray_stairs = new BlockStairs("wool_colored_gray_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_silver_stairs = new BlockStairs("wool_colored_silver_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_cyan_stairs = new BlockStairs("wool_colored_cyan_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_purple_stairs = new BlockStairs("wool_colored_purple_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_blue_stairs = new BlockStairs("wool_colored_blue_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_brown_stairs = new BlockStairs("wool_colored_brown_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_green_stairs = new BlockStairs("wool_colored_green_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_red_stairs = new BlockStairs("wool_colored_red_stairs", Block.getStateById(35));
    public static BlockStairs wool_colored_black_stairs = new BlockStairs("wool_colored_black_stairs", Block.getStateById(35));

    public static BlockWoolSlab wool_slab = new BlockWoolSlab.Half(Material.CLOTH, "wool_slab");
    public static BlockWoolSlab double_wool_slab = new BlockWoolSlab.Double(Material.CLOTH, "wool_slab_double");
    public static BlockWoolSlab_b wool_slab_b = new BlockWoolSlab_b.Half(Material.CLOTH, "wool_slab_b");
    public static BlockWoolSlab_b double_wool_slab_b = new BlockWoolSlab_b.Double(Material.CLOTH, "wool_slab_double_b");

    /**
     * Argile *
     */
    public static BlockStairs hardened_clay_stained_white_stairs = new BlockStairs("hardened_clay_stained_white_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_orange_stairs = new BlockStairs("hardened_clay_stained_orange_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_magenta_stairs = new BlockStairs("hardened_clay_stained_magenta_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_light_blue_stairs = new BlockStairs("hardened_clay_stained_light_blue_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_yellow_stairs = new BlockStairs("hardened_clay_stained_yellow_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_lime_stairs = new BlockStairs("hardened_clay_stained_lime_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_pink_stairs = new BlockStairs("hardened_clay_stained_pink_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_gray_stairs = new BlockStairs("hardened_clay_stained_gray_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_silver_stairs = new BlockStairs("hardened_clay_stained_silver_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_cyan_stairs = new BlockStairs("hardened_clay_stained_cyan_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_purple_stairs = new BlockStairs("hardened_clay_stained_purple_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_blue_stairs = new BlockStairs("hardened_clay_stained_blue_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_brown_stairs = new BlockStairs("hardened_clay_stained_brown_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_green_stairs = new BlockStairs("hardened_clay_stained_green_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_red_stairs = new BlockStairs("hardened_clay_stained_red_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stained_black_stairs = new BlockStairs("hardened_clay_stained_black_stairs", Block.getStateById(172));
    public static BlockStairs hardened_clay_stairs = new BlockStairs("hardened_clay_stairs", Block.getStateById(172));

    public static BlockClaySlab hardened_clay_slab = new BlockClaySlab.Half(Material.ROCK, "hardened_clay_slab");
    public static BlockClaySlab double_hardened_clay_slab = new BlockClaySlab.Double(Material.ROCK, "hardened_clay_slab_double");
    public static BlockClaySlab_b hardened_clay_slab_b = new BlockClaySlab_b.Half(Material.ROCK, "hardened_clay_slab_b");
    public static BlockClaySlab_b double_hardened_clay_slab_b = new BlockClaySlab_b.Double(Material.ROCK, "hardened_clay_slab_double_b");

    /**
     * Verre *
     */
    public static BlockGlass robust_glass_white = new BlockGlass(Material.GLASS, false, "robust_glass_white");
    public static BlockGlass robust_glass_orange = new BlockGlass(Material.GLASS, false, "robust_glass_orange");
    public static BlockGlass robust_glass_magenta = new BlockGlass(Material.GLASS, false, "robust_glass_magenta");
    public static BlockGlass robust_glass_light_blue = new BlockGlass(Material.GLASS, false, "robust_glass_light_blue");
    public static BlockGlass robust_glass_yellow = new BlockGlass(Material.GLASS, false, "robust_glass_yellow");
    public static BlockGlass robust_glass_lime = new BlockGlass(Material.GLASS, false, "robust_glass_lime");
    public static BlockGlass robust_glass_pink = new BlockGlass(Material.GLASS, false, "robust_glass_pink");
    public static BlockGlass robust_glass_gray = new BlockGlass(Material.GLASS, false, "robust_glass_gray");
    public static BlockGlass robust_glass_silver = new BlockGlass(Material.GLASS, false, "robust_glass_silver");
    public static BlockGlass robust_glass_cyan = new BlockGlass(Material.GLASS, false, "robust_glass_cyan");
    public static BlockGlass robust_glass_purple = new BlockGlass(Material.GLASS, false, "robust_glass_purple");
    public static BlockGlass robust_glass_blue = new BlockGlass(Material.GLASS, false, "robust_glass_blue");
    public static BlockGlass robust_glass_brown = new BlockGlass(Material.GLASS, false, "robust_glass_brown");
    public static BlockGlass robust_glass_green = new BlockGlass(Material.GLASS, false, "robust_glass_green");
    public static BlockGlass robust_glass_red = new BlockGlass(Material.GLASS, false, "robust_glass_red");
    public static BlockGlass robust_glass_black = new BlockGlass(Material.GLASS, false, "robust_glass_black");
    public static BlockGlass robust_glass_normal = new BlockGlass(Material.GLASS, false, "robust_glass");

    public static BlockPane robust_glass_pane_white = new BlockPane(Material.GLASS, false, "robust_glass_pane_white");
    public static BlockPane robust_glass_pane_orange = new BlockPane(Material.GLASS, false, "robust_glass_pane_orange");
    public static BlockPane robust_glass_pane_magenta = new BlockPane(Material.GLASS, false, "robust_glass_pane_magenta");
    public static BlockPane robust_glass_pane_light_blue = new BlockPane(Material.GLASS, false, "robust_glass_pane_light_blue");
    public static BlockPane robust_glass_pane_yellow = new BlockPane(Material.GLASS, false, "robust_glass_pane_yellow");
    public static BlockPane robust_glass_pane_lime = new BlockPane(Material.GLASS, false, "robust_glass_pane_lime");
    public static BlockPane robust_glass_pane_pink = new BlockPane(Material.GLASS, false, "robust_glass_pane_pink");
    public static BlockPane robust_glass_pane_gray = new BlockPane(Material.GLASS, false, "robust_glass_pane_gray");
    public static BlockPane robust_glass_pane_silver = new BlockPane(Material.GLASS, false, "robust_glass_pane_silver");
    public static BlockPane robust_glass_pane_cyan = new BlockPane(Material.GLASS, false, "robust_glass_pane_cyan");
    public static BlockPane robust_glass_pane_purple = new BlockPane(Material.GLASS, false, "robust_glass_pane_purple");
    public static BlockPane robust_glass_pane_blue = new BlockPane(Material.GLASS, false, "robust_glass_pane_blue");
    public static BlockPane robust_glass_pane_brown = new BlockPane(Material.GLASS, false, "robust_glass_pane_brown");
    public static BlockPane robust_glass_pane_green = new BlockPane(Material.GLASS, false, "robust_glass_pane_green");
    public static BlockPane robust_glass_pane_red = new BlockPane(Material.GLASS, false, "robust_glass_pane_red");
    public static BlockPane robust_glass_pane_black = new BlockPane(Material.GLASS, false, "robust_glass_pane_black");
    public static BlockPane robust_glass_pane_normal = new BlockPane(Material.GLASS, false, "robust_glass_pane");

    /**
     * Meubles *
     */
    public static BlockBed hay_bed = new BlockBed("hay_bed");

    public static BlockChair oak_stool = new BlockChair("oak_stool", Material.WOOD, SoundType.WOOD);
    public static BlockChair spruce_stool = new BlockChair("spruce_stool", Material.WOOD, SoundType.WOOD);
    public static BlockChair birch_stool = new BlockChair("birch_stool", Material.WOOD, SoundType.WOOD);
    public static BlockChair jungle_stool = new BlockChair("jungle_stool", Material.WOOD, SoundType.WOOD);
    public static BlockChair big_oak_stool = new BlockChair("big_oak_stool", Material.WOOD, SoundType.WOOD);
    public static BlockChair acacia_stool = new BlockChair("acacia_stool", Material.WOOD, SoundType.WOOD);
    public static BlockChair oak_chair = new BlockChair("oak_chair", Material.WOOD, SoundType.WOOD);
    public static BlockChair spruce_chair = new BlockChair("spruce_chair", Material.WOOD, SoundType.WOOD);
    public static BlockChair birch_chair = new BlockChair("birch_chair", Material.WOOD, SoundType.WOOD);
    public static BlockChair jungle_chair = new BlockChair("jungle_chair", Material.WOOD, SoundType.WOOD);
    public static BlockChair big_oak_chair = new BlockChair("big_oak_chair", Material.WOOD, SoundType.WOOD);
    public static BlockChair acacia_chair = new BlockChair("acacia_chair", Material.WOOD, SoundType.WOOD);
    public static BlockTable oak_table = new BlockTable("oak_table", Material.WOOD, SoundType.WOOD);
    public static BlockTable spruce_table = new BlockTable("spruce_table", Material.WOOD, SoundType.WOOD);
    public static BlockTable birch_table = new BlockTable("birch_table", Material.WOOD, SoundType.WOOD);
    public static BlockTable jungle_table = new BlockTable("jungle_table", Material.WOOD, SoundType.WOOD);
    public static BlockTable big_oak_table = new BlockTable("big_oak_table", Material.WOOD, SoundType.WOOD);
    public static BlockTable acacia_table = new BlockTable("acacia_table", Material.WOOD, SoundType.WOOD);
    public static BlockSmallTable oak_table_low = new BlockSmallTable("oak_table_low", Material.WOOD, SoundType.WOOD);
    public static BlockSmallTable spruce_table_low = new BlockSmallTable("spruce_table_low", Material.WOOD, SoundType.WOOD);
    public static BlockSmallTable birch_table_low = new BlockSmallTable("birch_table_low", Material.WOOD, SoundType.WOOD);
    public static BlockSmallTable jungle_table_low = new BlockSmallTable("jungle_table_low", Material.WOOD, SoundType.WOOD);
    public static BlockSmallTable big_oak_table_low = new BlockSmallTable("big_oak_table_low", Material.WOOD, SoundType.WOOD);
    public static BlockSmallTable acacia_table_low = new BlockSmallTable("acacia_table_low", Material.WOOD, SoundType.WOOD);
    public static BlockFurniture oak_shelf = new BlockFurniture("oak_shelf", Material.WOOD, SoundType.WOOD);
    public static BlockFurniture spruce_shelf = new BlockFurniture("spruce_shelf", Material.WOOD, SoundType.WOOD);
    public static BlockFurniture birch_shelf = new BlockFurniture("birch_shelf", Material.WOOD, SoundType.WOOD);
    public static BlockFurniture jungle_shelf = new BlockFurniture("jungle_shelf", Material.WOOD, SoundType.WOOD);
    public static BlockFurniture big_oak_shelf = new BlockFurniture("big_oak_shelf", Material.WOOD, SoundType.WOOD);
    public static BlockFurniture acacia_shelf = new BlockFurniture("acacia_shelf", Material.WOOD, SoundType.WOOD);

    public static BlockSupport support = new BlockSupport("support_short_slim");
    public static BlockLongSupport long_support = new BlockLongSupport("support_long_slim");
    public static BlockSupport support_fat = new BlockSupport("support_short_fat");
    public static BlockLongSupport long_support_fat = new BlockLongSupport("support_long_fat");

    public static BlockLittleChest little_chest = new BlockLittleChest("little_chest", Material.WOOD, SoundType.WOOD);

    public static BlockBarrel water_barrel = new BlockBarrel("water_barrel", BlockBarrel.BarrelType.WATER);
    public static BlockBarrel milk_barrel = new BlockBarrel("milk_barrel", BlockBarrel.BarrelType.MILK);
    public static BlockBarrel beer_barrel = new BlockBarrel("beer_barrel", BlockBarrel.BarrelType.BEER);
    public static BlockBarrel wine_barrel = new BlockBarrel("wine_barrel", BlockBarrel.BarrelType.WINE);
    public static BlockBarrel cider_barrel = new BlockBarrel("cider_barrel", BlockBarrel.BarrelType.CIDER);
    public static BlockBarrel hydromel_barrel = new BlockBarrel("hydromel_barrel", BlockBarrel.BarrelType.MEAD);
    public static BlockBarrel rhum_barrel = new BlockBarrel("rhum_barrel", BlockBarrel.BarrelType.RHUM);
    public static BlockBarrel empty_barrel = new BlockBarrel("empty_barrel", BlockBarrel.BarrelType.EMPTY);

    public static BlockBibliotheque bibliotheque_oak = new BlockBibliotheque("bibliotheque_oak", "oak");
    public static BlockBibliotheque bibliotheque_spruce = new BlockBibliotheque("bibliotheque_spruce", "spruce");
    public static BlockBibliotheque bibliotheque_birch = new BlockBibliotheque("bibliotheque_birch", "birch");
    public static BlockBibliotheque bibliotheque_jungle = new BlockBibliotheque("bibliotheque_jungle", "jungle");
    public static BlockBibliotheque bibliotheque_dark_oak = new BlockBibliotheque("bibliotheque_dark_oak", "dark_oak");
    public static BlockBibliotheque bibliotheque_acacia = new BlockBibliotheque("bibliotheque_acacia", "acacia");
    public static BlockPlacard cupboard = new BlockPlacard("cupboard");
    public static BlockPlacard wooden_cupboard = new BlockPlacard("wooden_cupboard");

    public static BlockTrapDoorEsperia acacia_trapdoor = new BlockTrapDoorEsperia("acacia_trapdoor", Material.WOOD);
    public static BlockTrapDoorEsperia birch_trapdoor = new BlockTrapDoorEsperia("birch_trapdoor", Material.WOOD);
    public static BlockTrapDoorEsperia dark_oak_trapdoor = new BlockTrapDoorEsperia("dark_oak_trapdoor", Material.WOOD);
    public static BlockTrapDoorEsperia jungle_trapdoor = new BlockTrapDoorEsperia("jungle_trapdoor", Material.WOOD);
    public static BlockTrapDoorEsperia spruce_trapdoor = new BlockTrapDoorEsperia("spruce_trapdoor", Material.WOOD);
    public static BlockDoor door_strong = new BlockDoor("door_strong", Material.WOOD);

    /**
     * Serrurerie *
     */
    public static BlockDoorLockable acacia_door_lockable = new BlockDoorLockable("acacia_door_lockable", Material.WOOD);
    public static BlockDoorLockable birch_door_lockable = new BlockDoorLockable("birch_door_lockable", Material.WOOD);
    public static BlockDoorLockable dark_oak_door_lockable = new BlockDoorLockable("dark_oak_door_lockable", Material.WOOD);
    public static BlockDoorLockable iron_door_lockable = new BlockDoorLockable("iron_door_lockable", Material.IRON);
    public static BlockDoorLockable jungle_door_lockable = new BlockDoorLockable("jungle_door_lockable", Material.WOOD);
    public static BlockDoorLockable oak_door_lockable = new BlockDoorLockable("wooden_door_lockable", Material.WOOD);
    public static BlockDoorLockable spruce_door_lockable = new BlockDoorLockable("spruce_door_lockable", Material.WOOD);
    public static BlockDoorLockable door_strong_lockable = new BlockDoorLockable("door_strong_lockable", Material.WOOD);

    public static BlockTrapDoorLockable trapdoor_lockable = new BlockTrapDoorLockable("trapdoor_lockable", Material.WOOD);
    public static BlockTrapDoorLockable iron_trapdoor_lockable = new BlockTrapDoorLockable("iron_trapdoor_lockable", Material.IRON);
    public static BlockTrapDoorLockable acacia_trapdoor_lockable = new BlockTrapDoorLockable("acacia_trapdoor_lockable", Material.WOOD);
    public static BlockTrapDoorLockable birch_trapdoor_lockable = new BlockTrapDoorLockable("birch_trapdoor_lockable", Material.WOOD);
    public static BlockTrapDoorLockable dark_oak_trapdoor_lockable = new BlockTrapDoorLockable("dark_oak_trapdoor_lockable", Material.WOOD);
    public static BlockTrapDoorLockable jungle_trapdoor_lockable = new BlockTrapDoorLockable("jungle_trapdoor_lockable", Material.WOOD);
    public static BlockTrapDoorLockable spruce_trapdoor_lockable = new BlockTrapDoorLockable("spruce_trapdoor_lockable", Material.WOOD);

    //Gateaux
    public static BlockCakeCheese cheese_wheel = new BlockCakeCheese();
    public static BlockCakeBlueCheese bluecheese_wheel = new BlockCakeBlueCheese();

    //Agriculture
    public static BlockCropBarley barley_crops = new BlockCropBarley();
    public static BlockCropLettuce lettuce_crops = new BlockCropLettuce();
    public static BlockCropTurnip turnip_crops = new BlockCropTurnip();
    public static BlockCropFlax flax_crops = new BlockCropFlax();
    public static BlockCropHemp hemp_crops = new BlockCropHemp();
    public static BlockVineGrapes grapes_vines = new BlockVineGrapes();
    public static BlockVineTomato tomato_vines = new BlockVineTomato();

    /**
     * Plantes *
     */
    public static BlockPlant flower_violets = new BlockPlant("flower_violets");
    public static BlockPlant flower_blue_hydrangea = new BlockPlant("flower_blue_hydrangea");
    public static BlockPlant flower_bluebells = new BlockPlant("flower_bluebells");
    public static BlockPlant flower_bromeliad = new BlockPlant("flower_bromeliad");
    public static BlockPlant flower_daisy = new BlockPlant("flower_daisy");
    public static BlockPlant flower_dandelion = new BlockPlant("flower_dandelion");
    public static BlockPlant flower_goldenrod = new BlockPlant("flower_goldenrod");
    public static BlockPlant flower_iris = new BlockPlant("flower_iris");
    public static BlockPlant flower_lavender = new BlockPlant("flower_lavender");
    public static BlockPlant flower_lily = new BlockPlant("flower_lily");
    public static BlockPlant flower_orange_cosmos = new BlockPlant("flower_orange_cosmos");
    public static BlockPlant flower_pink_daffodil = new BlockPlant("flower_pink_daffodil");
    public static BlockPlant flower_pink_hibiscus = new BlockPlant("flower_pink_hibiscus");
    public static BlockPlant flower_swampflower = new BlockPlant("flower_swampflower");
    public static BlockPlant flower_swampviolets = new BlockPlant("flower_swampviolets");
    public static BlockPlant flower_wildflower = new BlockPlant("flower_wildflower");
    public static BlockMushroom mushroom_blue_milk_cap = new BlockMushroom("mushroom_blue_milk_cap");
    public static BlockMushroom mushroom_flat = new BlockMushroom("mushroom_flat");
    public static BlockMushroom mushroom_portobello = new BlockMushroom("mushroom_portobello");
    public static BlockMushroom mushroom_toadstool = new BlockMushroom("mushroom_toadstool");
    public static BlockMushroom mushroom_strange = new BlockMushroom("mushroom_strange");
    public static BlockPlant plant_tea = new BlockPlant("plant_tea");
    public static BlockDistaff distaff = new BlockDistaff("distaff");

    public static BlockFruitTree apple_bloom = new BlockFruitTree(net.minecraft.init.Items.APPLE, "apple_bloom");
    public static BlockFruitTree raspberry_bloom = new BlockFruitTree(ItemsRegistry.raspberry, "raspberry_bloom");
    public static BlockFruitTree cassis_bloom = new BlockFruitTree(ItemsRegistry.cassis, "cassis_bloom");
    public static BlockFruitTree cherry_bloom = new BlockFruitTree(ItemsRegistry.cherry, "cherry_bloom");
    public static BlockFruitTree chestnut_bloom = new BlockFruitTree(ItemsRegistry.chestnut, "chestnut_bloom");
    public static BlockFruitTree lemon_bloom = new BlockFruitTree(ItemsRegistry.lemon, "lemon_bloom");
    public static BlockFruitTree peach_bloom = new BlockFruitTree(ItemsRegistry.peach, "peach_bloom");
    public static BlockFruitTree strawberry_bloom = new BlockFruitTree(ItemsRegistry.strawberry, "strawberry_bloom");
    public static BlockFruitTree apricot_bloom = new BlockFruitTree(ItemsRegistry.apricot, "apricot_bloom");

    public static BlockFlowerPot flower_pot = new BlockFlowerPot();
    
    public static BlockChessBoard chess_board = new BlockChessBoard("chess_board", Material.WOOD, SoundType.WOOD);
    public static BlockCardDeck card_deck = new BlockCardDeck("card_deck");
    public static BlockRepairWheel repair_wheel = new BlockRepairWheel("repair_wheel");
    
    public static BlockStairs concrete_colored_white_stairs = new BlockStairs("concrete_colored_white_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_orange_stairs = new BlockStairs("concrete_colored_orange_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_magenta_stairs = new BlockStairs("concrete_colored_magenta_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_light_blue_stairs = new BlockStairs("concrete_colored_light_blue_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_yellow_stairs = new BlockStairs("concrete_colored_yellow_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_lime_stairs = new BlockStairs("concrete_colored_lime_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_pink_stairs = new BlockStairs("concrete_colored_pink_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_gray_stairs = new BlockStairs("concrete_colored_gray_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_silver_stairs = new BlockStairs("concrete_colored_silver_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_cyan_stairs = new BlockStairs("concrete_colored_cyan_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_purple_stairs = new BlockStairs("concrete_colored_purple_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_blue_stairs = new BlockStairs("concrete_colored_blue_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_brown_stairs = new BlockStairs("concrete_colored_brown_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_green_stairs = new BlockStairs("concrete_colored_green_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_red_stairs = new BlockStairs("concrete_colored_red_stairs", Blocks.CONCRETE.getDefaultState());
    public static BlockStairs concrete_colored_black_stairs = new BlockStairs("concrete_colored_black_stairs", Blocks.CONCRETE.getDefaultState());
    
    public static BlockConcreteSlab concrete_slab = new BlockConcreteSlab.Half(Material.ROCK, "concrete_slab");
    public static BlockConcreteSlab double_concrete_slab = new BlockConcreteSlab.Double(Material.ROCK, "concrete_slab_double");
    public static BlockConcreteSlab_b concrete_slab_b = new BlockConcreteSlab_b.Half(Material.ROCK, "concrete_slab_b");
    public static BlockConcreteSlab_b double_concrete_slab_b = new BlockConcreteSlab_b.Double(Material.ROCK, "concrete_slab_double_b");
    
    public static BlockPlant salsola = new BlockPlant("salsola");
    public static BlockShowcase showcase_black = new BlockShowcase("showcase_black");
    public static BlockShowcase showcase_blue = new BlockShowcase("showcase_blue");
    public static BlockShowcase showcase_brown = new BlockShowcase("showcase_brown");
    public static BlockShowcase showcase_cyan = new BlockShowcase("showcase_cyan");
    public static BlockShowcase showcase_green = new BlockShowcase("showcase_green");
    public static BlockShowcase showcase_grey = new BlockShowcase("showcase_grey");
    public static BlockShowcase showcase_light_blue = new BlockShowcase("showcase_light_blue");
    public static BlockShowcase showcase_lime = new BlockShowcase("showcase_lime");
    public static BlockShowcase showcase_magenta = new BlockShowcase("showcase_magenta");
    public static BlockShowcase showcase_orange = new BlockShowcase("showcase_orange");
    public static BlockShowcase showcase_pink = new BlockShowcase("showcase_pink");
    public static BlockShowcase showcase_purple = new BlockShowcase("showcase_purple");
    public static BlockShowcase showcase_red = new BlockShowcase("showcase_red");
    public static BlockShowcase showcase_silver = new BlockShowcase("showcase_silver");
    public static BlockShowcase showcase_white = new BlockShowcase("showcase_white");
    public static BlockShowcase showcase_yellow = new BlockShowcase("showcase_yellow");
    
    public static BlockContainerHRP container_hrp = new BlockContainerHRP("container_hrp");
    
    public static BlockShutterPane oak_shutter = new BlockShutterPane("oak_shutter", Material.WOOD);
    public static BlockShutterPane birch_shutter = new BlockShutterPane("birch_shutter", Material.WOOD);
    public static BlockShutterPane spruce_shutter = new BlockShutterPane("spruce_shutter", Material.WOOD);
    public static BlockShutterPane jungle_shutter = new BlockShutterPane("jungle_shutter", Material.WOOD);
    public static BlockShutterPane dark_oak_shutter = new BlockShutterPane("dark_oak_shutter", Material.WOOD);
    public static BlockShutterPane acacia_shutter = new BlockShutterPane("acacia_shutter", Material.WOOD);

    public static BlockWindowPane clear_window = new BlockWindowPane("clear_window", Material.GLASS);
    public static BlockWindowPane black_window = new BlockWindowPane("black_window", Material.GLASS);
    public static BlockWindowPane blue_window = new BlockWindowPane("blue_window", Material.GLASS);
    public static BlockWindowPane brown_window = new BlockWindowPane("brown_window", Material.GLASS);
    public static BlockWindowPane cyan_window = new BlockWindowPane("cyan_window", Material.GLASS);
    public static BlockWindowPane green_window = new BlockWindowPane("green_window", Material.GLASS);
    public static BlockWindowPane gray_window = new BlockWindowPane("gray_window", Material.GLASS);
    public static BlockWindowPane light_blue_window = new BlockWindowPane("light_blue_window", Material.GLASS);
    public static BlockWindowPane lime_window = new BlockWindowPane("lime_window", Material.GLASS);
    public static BlockWindowPane magenta_window = new BlockWindowPane("magenta_window", Material.GLASS);
    public static BlockWindowPane orange_window = new BlockWindowPane("orange_window", Material.GLASS);
    public static BlockWindowPane pink_window = new BlockWindowPane("pink_window", Material.GLASS);
    public static BlockWindowPane purple_window = new BlockWindowPane("purple_window", Material.GLASS);
    public static BlockWindowPane red_window = new BlockWindowPane("red_window", Material.GLASS);
    public static BlockWindowPane silver_window = new BlockWindowPane("silver_window", Material.GLASS);
    public static BlockWindowPane white_window = new BlockWindowPane("white_window", Material.GLASS);
    public static BlockWindowPane yellow_window = new BlockWindowPane("yellow_window", Material.GLASS);
    
    public static BlockStaticSign oak_static_sign = new BlockStaticSign("oak_static_sign");
    public static BlockStaticSign birch_static_sign = new BlockStaticSign("birch_static_sign");
    public static BlockStaticSign spruce_static_sign = new BlockStaticSign("spruce_static_sign");
    public static BlockStaticSign jungle_static_sign = new BlockStaticSign("jungle_static_sign");
    public static BlockStaticSign dark_oak_static_sign = new BlockStaticSign("dark_oak_static_sign");
    public static BlockStaticSign acacia_static_sign = new BlockStaticSign("acacia_static_sign");
    public static BlockStaticSign stone_static_sign = new BlockStaticSign("stone_static_sign");
    public static BlockStaticSign granite_static_sign = new BlockStaticSign("granite_static_sign");
    public static BlockStaticSign andesite_static_sign = new BlockStaticSign("andesite_static_sign");
    public static BlockStaticSign diorite_static_sign = new BlockStaticSign("diorite_static_sign");

    public static BlockFence stone_fence = new BlockFence(Material.ROCK, MapColor.BROWN, "stone_fence");
    public static BlockFence andesite_fence = new BlockFence(Material.ROCK, MapColor.BROWN, "andesite_fence");
    public static BlockFence diorite_fence = new BlockFence(Material.ROCK, MapColor.BROWN, "diorite_fence");
    public static BlockFence granite_fence = new BlockFence(Material.ROCK, MapColor.BROWN, "granite_fence");

    public static BlockFence oak_wood_fence = new BlockFence(Material.WOOD, MapColor.BROWN, "oak_wood_fence");
    public static BlockFence spruce_wood_fence = new BlockFence(Material.WOOD, MapColor.BROWN, "spruce_wood_fence");
    public static BlockFence birch_wood_fence = new BlockFence(Material.WOOD, MapColor.BROWN, "birch_wood_fence");
    public static BlockFence jungle_wood_fence = new BlockFence(Material.WOOD, MapColor.BROWN, "jungle_wood_fence");
    public static BlockFence dark_oak_wood_fence = new BlockFence(Material.WOOD, MapColor.BROWN, "dark_oak_wood_fence");
    public static BlockFence acacia_wood_fence = new BlockFence(Material.WOOD, MapColor.BROWN, "acacia_wood_fence");
    
    public static BlockVine rose_vine = new BlockVine("rose_vine");
    public static BlockVine red_rose_vine = new BlockVine("red_rose_vine");
    public static BlockVine pink_rose_vine = new BlockVine("pink_rose_vine");
    public static BlockVine yellow_rose_vine = new BlockVine("yellow_rose_vine");
    public static BlockVine white_flower_vine = new BlockVine("white_flower_vine");
    public static BlockVine red_flower_vine = new BlockVine("red_flower_vine");
    public static BlockVine purple_flower_vine = new BlockVine("purple_flower_vine");
    public static BlockVine pale_vine = new BlockVine("pale_vine");
    
    /*public static BlockLeavesStairs oak_leaves_stairs = new BlockLeavesStairs("oak_leaves_stairs");
    public static BlockLeavesStairs birch_leaves_stairs = new BlockLeavesStairs("birch_leaves_stairs");
    public static BlockLeavesStairs spruce_leaves_stairs = new BlockLeavesStairs("spruce_leaves_stairs");
    public static BlockLeavesStairs jungle_leaves_stairs = new BlockLeavesStairs("jungle_leaves_stairs");
    public static BlockLeavesStairs dark_oak_leaves_stairs = new BlockLeavesStairs("dark_oak_leaves_stairs");
    public static BlockLeavesStairs acacia_leaves_stairs = new BlockLeavesStairs("acacia_leaves_stairs");*/
 
    public static BlockSimple blue_slate_raw = new BlockSimple("blue_slate_raw", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockSimple blue_slate = new BlockSimple("blue_slate", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockStairs blue_slate_stairs = new BlockStairs("blue_slate_stairs", blue_slate.getDefaultState());
    
    public static BlockSimple clay_slate = new BlockSimple("clay_slate", Material.ROCK, SoundType.STONE, 1.5F);
    public static BlockStairs clay_slate_stairs = new BlockStairs("clay_slate_stairs", clay_slate.getDefaultState());

    /**
     * Item Blocks *
     */
    public static ItemSlab hay_slab_item = (ItemSlab) new ItemSlab((Block) hay_slab, hay_slab, double_hay_slab, false).setRegistryName(hay_slab.getRegistryName());
    public static ItemSlab wool_slab_item = (ItemSlab) new ItemSlab((Block) wool_slab, wool_slab, double_wool_slab, false).setRegistryName(wool_slab.getRegistryName());
    public static ItemSlab wool_slab_b_item = (ItemSlab) new ItemSlab((Block) wool_slab_b, wool_slab_b, double_wool_slab_b, false).setRegistryName(wool_slab_b.getRegistryName());
    public static ItemSlab hardened_clay_slab_item = (ItemSlab) new ItemSlab((Block) hardened_clay_slab, hardened_clay_slab, double_hardened_clay_slab, false).setRegistryName(hardened_clay_slab.getRegistryName());
    public static ItemSlab hardened_clay_slab_b_item = (ItemSlab) new ItemSlab((Block) hardened_clay_slab_b, hardened_clay_slab_b, double_hardened_clay_slab_b, false).setRegistryName(hardened_clay_slab_b.getRegistryName());
    public static ItemSlab stone_slab_item = (ItemSlab) new ItemSlab((Block) stone_slab, stone_slab, double_stone_slab, false).setRegistryName(stone_slab.getRegistryName());
    public static ItemSlab stone_slab_b_item = (ItemSlab) new ItemSlab((Block) stone_slab_b, stone_slab_b, double_stone_slab_b, false).setRegistryName(stone_slab_b.getRegistryName());
    public static ItemSlab concrete_slab_item = (ItemSlab) new ItemSlab((Block) concrete_slab, concrete_slab, double_concrete_slab, false).setRegistryName(concrete_slab.getRegistryName());
    public static ItemSlab concrete_slab_b_item = (ItemSlab) new ItemSlab((Block) concrete_slab_b, concrete_slab_b, double_concrete_slab_b, false).setRegistryName(concrete_slab_b.getRegistryName());
    public static ItemStalactite icicle_item = new ItemStalactite(icicle, icicle.getRegistryName().getResourcePath());
    public static ItemStalactite stone_stalactite_item = new ItemStalactite(stone_stalactite, stone_stalactite.getRegistryName().getResourcePath());
    public static ItemBlockSpecial campfire_item = new ItemBlockSpecial("campfire", campfire, CreativeTabs.DECORATIONS);
    public static ItemBlockSpecial lit_campfire_item = new ItemBlockSpecial("lit_campfire", lit_campfire, CreativeTabs.DECORATIONS);
    public static ItemBed hay_bed_item = (ItemBed) hay_bed.getItem();

    public static ItemDoor door_strong_item = new ItemDoor("door_strong", door_strong);
    public static ItemDoorLockable acacia_door_lockable_item = new ItemDoorLockable("acacia_door_lockable", acacia_door_lockable);
    public static ItemDoorLockable birch_door_lockable_item = new ItemDoorLockable("birch_door_lockable", birch_door_lockable);
    public static ItemDoorLockable dark_oak_door_lockable_item = new ItemDoorLockable("dark_oak_door_lockable", dark_oak_door_lockable);
    public static ItemDoorLockable iron_door_lockable_item = new ItemDoorLockable("iron_door_lockable", iron_door_lockable);
    public static ItemDoorLockable jungle_door_lockable_item = new ItemDoorLockable("jungle_door_lockable", jungle_door_lockable);
    public static ItemDoorLockable oak_door_lockable_item = new ItemDoorLockable("wooden_door_lockable", oak_door_lockable);
    public static ItemDoorLockable spruce_door_lockable_item = new ItemDoorLockable("spruce_door_lockable", spruce_door_lockable);
    public static ItemDoorLockable door_strong_lockable_item = new ItemDoorLockable("door_strong_lockable", door_strong_lockable);

    public static ItemWallNote wall_note_item = new ItemWallNote();
    public static ItemShowcase showcase_black_item = (ItemShowcase) new ItemShowcase(showcase_black).setRegistryName(showcase_black.getRegistryName());
    public static ItemShowcase showcase_blue_item = (ItemShowcase) new ItemShowcase(showcase_blue).setRegistryName(showcase_blue.getRegistryName());
    public static ItemShowcase showcase_brown_item = (ItemShowcase) new ItemShowcase(showcase_brown).setRegistryName(showcase_brown.getRegistryName());
    public static ItemShowcase showcase_cyan_item = (ItemShowcase) new ItemShowcase(showcase_cyan).setRegistryName(showcase_cyan.getRegistryName());
    public static ItemShowcase showcase_green_item = (ItemShowcase) new ItemShowcase(showcase_green).setRegistryName(showcase_green.getRegistryName());
    public static ItemShowcase showcase_grey_item = (ItemShowcase) new ItemShowcase(showcase_grey).setRegistryName(showcase_grey.getRegistryName());
    public static ItemShowcase showcase_light_blue_item = (ItemShowcase) new ItemShowcase(showcase_light_blue).setRegistryName(showcase_light_blue.getRegistryName());
    public static ItemShowcase showcase_lime_item = (ItemShowcase) new ItemShowcase(showcase_lime).setRegistryName(showcase_lime.getRegistryName());
    public static ItemShowcase showcase_magenta_item = (ItemShowcase) new ItemShowcase(showcase_magenta).setRegistryName(showcase_magenta.getRegistryName());
    public static ItemShowcase showcase_orange_item = (ItemShowcase) new ItemShowcase(showcase_orange).setRegistryName(showcase_orange.getRegistryName());
    public static ItemShowcase showcase_pink_item = (ItemShowcase) new ItemShowcase(showcase_pink).setRegistryName(showcase_pink.getRegistryName());
    public static ItemShowcase showcase_purple_item = (ItemShowcase) new ItemShowcase(showcase_purple).setRegistryName(showcase_purple.getRegistryName());
    public static ItemShowcase showcase_red_item = (ItemShowcase) new ItemShowcase(showcase_red).setRegistryName(showcase_red.getRegistryName());
    public static ItemShowcase showcase_silver_item = (ItemShowcase) new ItemShowcase(showcase_silver).setRegistryName(showcase_silver.getRegistryName());
    public static ItemShowcase showcase_white_item = (ItemShowcase) new ItemShowcase(showcase_white).setRegistryName(showcase_white.getRegistryName());
    public static ItemShowcase showcase_yellow_item = (ItemShowcase) new ItemShowcase(showcase_yellow).setRegistryName(showcase_yellow.getRegistryName());

    public static ItemWindowPane oak_shutter_item = new ItemWindowPane("oak_shutter", oak_shutter);
    public static ItemWindowPane spruce_shutter_item = new ItemWindowPane("spruce_shutter", spruce_shutter);
    public static ItemWindowPane birch_shutter_item = new ItemWindowPane("birch_shutter", birch_shutter);
    public static ItemWindowPane jungle_shutter_item = new ItemWindowPane("jungle_shutter", jungle_shutter);
    public static ItemWindowPane dark_oak_shutter_item = new ItemWindowPane("dark_oak_shutter", dark_oak_shutter);
    public static ItemWindowPane acacia_shutter_item = new ItemWindowPane("acacia_shutter", acacia_shutter);

    public static ItemWindowPane clear_window_item = new ItemWindowPane("clear_window", clear_window);
    public static ItemWindowPane black_window_item = new ItemWindowPane("black_window", black_window);
    public static ItemWindowPane blue_window_item = new ItemWindowPane("blue_window", blue_window);
    public static ItemWindowPane brown_window_item = new ItemWindowPane("brown_window", brown_window);
    public static ItemWindowPane cyan_window_item = new ItemWindowPane("cyan_window", cyan_window);
    public static ItemWindowPane green_window_item = new ItemWindowPane("green_window", green_window);
    public static ItemWindowPane gray_window_item = new ItemWindowPane("gray_window", gray_window);
    public static ItemWindowPane light_blue_window_item = new ItemWindowPane("light_blue_window", light_blue_window);
    public static ItemWindowPane lime_window_item = new ItemWindowPane("lime_window", lime_window);
    public static ItemWindowPane magenta_window_item = new ItemWindowPane("magenta_window", magenta_window);
    public static ItemWindowPane orange_window_item = new ItemWindowPane("orange_window", orange_window);
    public static ItemWindowPane pink_window_item = new ItemWindowPane("pink_window", pink_window);
    public static ItemWindowPane purple_window_item = new ItemWindowPane("purple_window", purple_window);
    public static ItemWindowPane red_window_item = new ItemWindowPane("red_window", red_window);
    public static ItemWindowPane silver_window_item = new ItemWindowPane("silver_window", silver_window);
    public static ItemWindowPane white_window_item = new ItemWindowPane("white_window", white_window);
    public static ItemWindowPane yellow_window_item = new ItemWindowPane("yellow_window", yellow_window);
    
    public static Item wood_wall_spruce_item = new ItemWall(wood_wall_spruce, wood_wall_spruce, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });
    public static Item wood_wall_oak_item = new ItemWall(wood_wall_oak, wood_wall_oak, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });
    public static Item wood_wall_birch_item = new ItemWall(wood_wall_birch, wood_wall_birch, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });
    public static Item wood_wall_jungle_item = new ItemWall(wood_wall_jungle, wood_wall_jungle, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });
    public static Item wood_wall_acacia_item = new ItemWall(wood_wall_acacia, wood_wall_acacia, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });
    public static Item wood_wall_dark_oak_item = new ItemWall(wood_wall_dark_oak, wood_wall_dark_oak, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });

    public static Item stone_wall_andesite_item = new ItemWall(stone_wall_andesite, stone_wall_andesite, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });
    ;
    public static Item stone_wall_diorite_item = new ItemWall(stone_wall_diorite, stone_wall_diorite, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });
    public static Item stone_wall_granite_item = new ItemWall(stone_wall_granite, stone_wall_granite, new ItemMultiTexture.Mapper() {
        public String apply(ItemStack p_apply_1_) {
            return BlockWall.Variants.byMetadata(p_apply_1_.getMetadata()).getUnlocalizedName();
        }
    });

    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(stuc,
                flower_pot,
                hay_slab,
                double_hay_slab,
                raw_slate, slate,
                slate_stairs,
                ash_block,
                ash_layer,
                sand_layer,
                red_sand_layer,
                hay_block,
                hay_stairs,
                hay_layer,
                old_hay_ball,
                old_hay_block,
                old_hay_stairs,
                old_hay_layer,
                leaves_layer, leaves_jungle_layer,
                leaves_birch_layer, leaves_spruce_layer, leaves_acacia_layer, leaves_dark_oak_layer,
                bronze_block,
                copper_block,
                lead_block,
                steel_block,
                silver_block,
                tin_block,
                mud_half,
                mud_full,
                timber_block,
                timber_block_crossed,
                timber_block_right,
                timber_block_left,
                timber_block_horizontal,
                timber_block_vertical,
                stone_stalactite,
                icicle,
                hrp_standing_sign,
                hrp_wall_sign,
                stone_standing_sign,
                stone_wall_sign,
                candle_on,
                candle_off,
                chain,
                rope,
                lantern_white,
                lantern_orange,
                lantern_yellow,
                lantern_purple,
                lantern_blue,
                lantern_green,
                lantern_red,
                paper_lantern_white,
                paper_lantern_orange,
                paper_lantern_yellow,
                paper_lantern_purple,
                paper_lantern_blue,
                paper_lantern_green,
                paper_lantern_red,
                lantern_off_white,
                lantern_off_orange,
                lantern_off_yellow,
                lantern_off_purple,
                lantern_off_blue,
                lantern_off_green,
                lantern_off_red,
                paper_lantern_off_white,
                paper_lantern_off_orange,
                paper_lantern_off_yellow,
                paper_lantern_off_purple,
                paper_lantern_off_blue,
                paper_lantern_off_green,
                paper_lantern_off_red,
                big_lantern,
                big_lantern_off,
                hive,
                hive_cube,
                campfire,
                lit_campfire,
                decal_water_puddle,
                decal_blood_puddle,
                decal_mud_puddle,
                log_oak_mossy,
                log_birch_mossy,
                log_spruce_mossy,
                log_jungle_mossy,
                log_acacia_mossy,
                log_dark_oak_mossy,
                planks_acacia_mossy,
                planks_acacia_cracked,
                planks_acacia_varnish,
                planks_acacia_pattern_1,
                planks_acacia_pattern_2,
                planks_big_oak_mossy,
                planks_big_oak_cracked,
                planks_big_oak_varnish,
                planks_big_oak_pattern_1,
                planks_big_oak_pattern_2,
                planks_birch_mossy,
                planks_birch_cracked,
                planks_birch_varnish,
                planks_birch_pattern_1,
                planks_birch_pattern_2,
                planks_jungle_mossy,
                planks_jungle_cracked,
                planks_jungle_varnish,
                planks_jungle_pattern_1,
                planks_jungle_pattern_2,
                planks_oak_mossy,
                planks_oak_cracked,
                planks_oak_varnish,
                planks_oak_pattern_1,
                planks_oak_pattern_2,
                planks_spruce_mossy,
                planks_spruce_cracked,
                planks_spruce_varnish,
                planks_spruce_pattern_1,
                planks_spruce_pattern_2,
                wooden_bars,
                wood_wall_spruce,
                wood_wall_oak,
                wood_wall_birch,
                wood_wall_jungle,
                wood_wall_acacia,
                wood_wall_dark_oak,
                button_spruce,
                button_birch,
                button_jungle,
                button_acacia,
                button_dark_oak,
                pressure_plate_spruce,
                pressure_plate_birch,
                pressure_plate_jungle,
                pressure_plate_acacia,
                pressure_plate_dark_oak,
                cobblestone_cracked,
                stone_slab_top,
                stone_granite_smooth_mossy,
                stonebrick_granite,
                stonebrick_granite_cracked,
                stonebrick_granite_mossy,
                stonebrick_granite_carved,
                stone_granite_slab_top,
                stone_diorite_smooth_mossy,
                stonebrick_diorite,
                stonebrick_diorite_cracked,
                stonebrick_diorite_mossy,
                stonebrick_diorite_carved,
                stone_diorite_slab_top,
                stone_andesite_smooth_mossy,
                stonebrick_andesite,
                stonebrick_andesite_cracked,
                stonebrick_andesite_mossy,
                stonebrick_andesite_carved,
                stone_andesite_slab_top,
                stonebrick_andesite_stair,
                stonebrick_granite_stair,
                stonebrick_diorite_stair,
                stone_andesite_stair,
                stone_granite_stair,
                stone_diorite_stair,
                smooth_andesite_stair,
                smooth_granite_stair,
                smooth_diorite_stair,
                smooth_stone_stair,
                stone_slab,
                double_stone_slab,
                stone_slab_b,
                double_stone_slab_b,
                stone_wall_andesite,
                stone_wall_diorite,
                stone_wall_granite,
                button_andesite,
                button_diorite,
                button_granite,
                pressure_plate_andesite,
                pressure_plate_diorite,
                pressure_plate_granite,
                amethyst_ore,
                aquamarine_ore,
                charoite_ore,
                citrine_ore,
                coraline_ore,
                hematite_ore,
                malachite_ore,
                opale_ore,
                quartz_ore,
                quartzrose_ore,
                ruby_ore,
                tigereye_ore,
                tourmaline_ore,
                turquoise_ore,
                copper_ore,
                tin_ore,
                lead_ore,
                silver_ore,
                alun_ore,
                salt_ore,
                salt_carrier,
                wool_colored_white_stairs,
                wool_colored_orange_stairs,
                wool_colored_magenta_stairs,
                wool_colored_light_blue_stairs,
                wool_colored_yellow_stairs,
                wool_colored_lime_stairs,
                wool_colored_pink_stairs,
                wool_colored_gray_stairs,
                wool_colored_silver_stairs,
                wool_colored_cyan_stairs,
                wool_colored_purple_stairs,
                wool_colored_blue_stairs,
                wool_colored_brown_stairs,
                wool_colored_green_stairs,
                wool_colored_red_stairs,
                wool_colored_black_stairs,
                wool_slab,
                wool_slab_b,
                double_wool_slab,
                double_wool_slab_b,
                hardened_clay_stained_white_stairs,
                hardened_clay_stained_orange_stairs,
                hardened_clay_stained_magenta_stairs,
                hardened_clay_stained_light_blue_stairs,
                hardened_clay_stained_yellow_stairs,
                hardened_clay_stained_lime_stairs,
                hardened_clay_stained_pink_stairs,
                hardened_clay_stained_gray_stairs,
                hardened_clay_stained_silver_stairs,
                hardened_clay_stained_cyan_stairs,
                hardened_clay_stained_purple_stairs,
                hardened_clay_stained_blue_stairs,
                hardened_clay_stained_brown_stairs,
                hardened_clay_stained_green_stairs,
                hardened_clay_stained_red_stairs,
                hardened_clay_stained_black_stairs,
                hardened_clay_stairs,
                hardened_clay_slab,
                hardened_clay_slab_b,
                double_hardened_clay_slab,
                double_hardened_clay_slab_b,
                robust_glass_white,
                robust_glass_orange,
                robust_glass_magenta,
                robust_glass_light_blue,
                robust_glass_yellow,
                robust_glass_lime,
                robust_glass_pink,
                robust_glass_gray,
                robust_glass_silver,
                robust_glass_cyan,
                robust_glass_purple,
                robust_glass_blue,
                robust_glass_brown,
                robust_glass_green,
                robust_glass_red,
                robust_glass_black,
                robust_glass_normal,
                robust_glass_pane_white,
                robust_glass_pane_orange,
                robust_glass_pane_magenta,
                robust_glass_pane_light_blue,
                robust_glass_pane_yellow,
                robust_glass_pane_lime,
                robust_glass_pane_pink,
                robust_glass_pane_gray,
                robust_glass_pane_silver,
                robust_glass_pane_cyan,
                robust_glass_pane_purple,
                robust_glass_pane_blue,
                robust_glass_pane_brown,
                robust_glass_pane_green,
                robust_glass_pane_red,
                robust_glass_pane_black,
                robust_glass_pane_normal,
                hay_bed,
                oak_stool,
                spruce_stool,
                birch_stool,
                jungle_stool,
                big_oak_stool,
                acacia_stool,
                oak_chair,
                spruce_chair,
                birch_chair,
                jungle_chair,
                big_oak_chair,
                acacia_chair,
                oak_table,
                spruce_table,
                birch_table,
                jungle_table,
                big_oak_table,
                acacia_table,
                oak_table_low,
                spruce_table_low,
                birch_table_low,
                jungle_table_low,
                big_oak_table_low,
                acacia_table_low,
                oak_shelf,
                spruce_shelf,
                birch_shelf,
                jungle_shelf,
                big_oak_shelf,
                acacia_shelf,
                support,
                long_support,
                support_fat,
                long_support_fat,
                little_chest,
                water_barrel,
                milk_barrel,
                beer_barrel,
                wine_barrel,
                cider_barrel,
                hydromel_barrel,
                rhum_barrel,
                empty_barrel,
                bibliotheque_oak,
                bibliotheque_birch,
                bibliotheque_spruce,
                bibliotheque_jungle,
                bibliotheque_acacia,
                bibliotheque_dark_oak,
                cupboard,
                acacia_trapdoor,
                birch_trapdoor,
                jungle_trapdoor,
                dark_oak_trapdoor,
                spruce_trapdoor,
                door_strong,
                acacia_door_lockable,
                birch_door_lockable,
                dark_oak_door_lockable,
                jungle_door_lockable,
                oak_door_lockable,
                spruce_door_lockable,
                iron_door_lockable,
                door_strong_lockable,
                trapdoor_lockable,
                iron_trapdoor_lockable,
                acacia_trapdoor_lockable,
                birch_trapdoor_lockable,
                dark_oak_trapdoor_lockable,
                jungle_trapdoor_lockable,
                spruce_trapdoor_lockable,
                //Nourriture
                cheese_wheel,
                bluecheese_wheel,
                //Agriculture
                barley_crops,
                flax_crops,
                hemp_crops,
                lettuce_crops,
                tomato_vines,
                grapes_vines,
                turnip_crops,
                //Fleurs
                flower_violets,
                flower_blue_hydrangea,
                flower_bluebells,
                flower_bromeliad,
                flower_daisy,
                flower_dandelion,
                flower_goldenrod,
                flower_iris,
                flower_lavender,
                flower_lily,
                flower_orange_cosmos,
                flower_pink_daffodil,
                flower_pink_hibiscus,
                flower_swampflower,
                flower_swampviolets,
                flower_wildflower,
                mushroom_blue_milk_cap,
                mushroom_flat,
                mushroom_portobello,
                mushroom_toadstool,
                mushroom_strange,
                plant_tea,
                distaff,
                apple_bloom,
                raspberry_bloom,
                cassis_bloom,
                cherry_bloom,
                chestnut_bloom,
                lemon_bloom,
                peach_bloom,
                strawberry_bloom,
                apricot_bloom,
                wall_note,
                chess_board,
                card_deck,
                repair_wheel,
                concrete_colored_white_stairs,
                concrete_colored_orange_stairs,
                concrete_colored_magenta_stairs,
                concrete_colored_light_blue_stairs,
                concrete_colored_yellow_stairs,
                concrete_colored_lime_stairs,
                concrete_colored_pink_stairs,
                concrete_colored_gray_stairs,
                concrete_colored_silver_stairs,
                concrete_colored_cyan_stairs,
                concrete_colored_purple_stairs,
                concrete_colored_blue_stairs,
                concrete_colored_brown_stairs,
                concrete_colored_green_stairs,
                concrete_colored_red_stairs,
                concrete_colored_black_stairs,
                concrete_slab,
                concrete_slab_b,
                double_concrete_slab,
                double_concrete_slab_b,
                salsola,
                showcase_black,
                showcase_blue,
                showcase_brown,
                showcase_cyan,
                showcase_green,
                showcase_grey,
                showcase_light_blue,
                showcase_lime,
                showcase_magenta,
                showcase_orange,
                showcase_pink,
                showcase_purple,
                showcase_red,
                showcase_silver,
                showcase_white,
                showcase_yellow,
                container_hrp,
                wooden_cupboard,
                oak_shutter,
                birch_shutter,
                spruce_shutter,
                jungle_shutter,
                dark_oak_shutter,
                acacia_shutter,
                clear_window,
                black_window,
                blue_window,
                brown_window,
                cyan_window,
                green_window,
                gray_window,
                light_blue_window,
                lime_window,
                magenta_window,
                orange_window,
                pink_window,
                purple_window,
                red_window,
                silver_window,
                white_window,
                yellow_window,
                oak_static_sign,
                birch_static_sign,
                spruce_static_sign,
                jungle_static_sign,
                dark_oak_static_sign,
                acacia_static_sign,
                stone_static_sign,
                granite_static_sign,
                andesite_static_sign,
                diorite_static_sign,
                stone_fence,
                andesite_fence,
                diorite_fence,
                granite_fence,
                oak_wood_fence,
                spruce_wood_fence,
                birch_wood_fence,
                jungle_wood_fence,
                dark_oak_wood_fence,
                acacia_wood_fence,
                rose_vine,
                red_rose_vine,
                pink_rose_vine,
                yellow_rose_vine,
                white_flower_vine,
                red_flower_vine,
                purple_flower_vine,
                pale_vine,
                blue_slate,
                blue_slate_raw,
                blue_slate_stairs,
                clay_slate,
                clay_slate_stairs
                /*oak_leaves_stairs,
                birch_leaves_stairs,
                spruce_leaves_stairs,
                jungle_leaves_stairs,
                dark_oak_leaves_stairs,
                acacia_leaves_stairs*/
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(stuc.createItemBlock(),
                flower_pot.createItemBlock(),
                raw_slate.createItemBlock(),
                slate.createItemBlock(),
                slate_stairs.createItemBlock(),
                ash_block.createItemBlock(),
                hay_block.createItemBlock(),
                hay_stairs.createItemBlock(),
                old_hay_ball.createItemBlock(),
                old_hay_block.createItemBlock(),
                old_hay_stairs.createItemBlock(),
                bronze_block.createItemBlock(),
                copper_block.createItemBlock(),
                lead_block.createItemBlock(),
                steel_block.createItemBlock(),
                silver_block.createItemBlock(),
                tin_block.createItemBlock(),
                mud_half.createItemBlock(),
                mud_full.createItemBlock(),
                timber_block.createItemBlock(),
                timber_block_crossed.createItemBlock(),
                timber_block_right.createItemBlock(),
                timber_block_left.createItemBlock(),
                timber_block_horizontal.createItemBlock(),
                timber_block_vertical.createItemBlock(),
                candle_on.createItemBlock(),
                candle_off.createItemBlock(),
                chain.createItemBlock(),
                rope.createItemBlock(),
                lantern_white.createItemBlock(),
                lantern_orange.createItemBlock(),
                lantern_yellow.createItemBlock(),
                lantern_purple.createItemBlock(),
                lantern_blue.createItemBlock(),
                lantern_green.createItemBlock(),
                lantern_red.createItemBlock(),
                lantern_off_white.createItemBlock(),
                lantern_off_orange.createItemBlock(),
                lantern_off_yellow.createItemBlock(),
                lantern_off_purple.createItemBlock(),
                lantern_off_blue.createItemBlock(),
                lantern_off_green.createItemBlock(),
                lantern_off_red.createItemBlock(),
                paper_lantern_white.createItemBlock(),
                paper_lantern_orange.createItemBlock(),
                paper_lantern_yellow.createItemBlock(),
                paper_lantern_purple.createItemBlock(),
                paper_lantern_blue.createItemBlock(),
                paper_lantern_green.createItemBlock(),
                paper_lantern_red.createItemBlock(),
                paper_lantern_off_white.createItemBlock(),
                paper_lantern_off_orange.createItemBlock(),
                paper_lantern_off_yellow.createItemBlock(),
                paper_lantern_off_purple.createItemBlock(),
                paper_lantern_off_blue.createItemBlock(),
                paper_lantern_off_green.createItemBlock(),
                paper_lantern_off_red.createItemBlock(),
                big_lantern.createItemBlock(),
                big_lantern_off.createItemBlock(),
                hive.createItemBlock(),
                hive_cube.createItemBlock(),
                decal_water_puddle.createItemBlock(),
                decal_blood_puddle.createItemBlock(),
                decal_mud_puddle.createItemBlock(),
                log_oak_mossy.createItemBlock(),
                log_birch_mossy.createItemBlock(),
                log_spruce_mossy.createItemBlock(),
                log_jungle_mossy.createItemBlock(),
                log_acacia_mossy.createItemBlock(),
                log_dark_oak_mossy.createItemBlock(),
                planks_acacia_mossy.createItemBlock(),
                planks_acacia_cracked.createItemBlock(),
                planks_acacia_varnish.createItemBlock(),
                planks_acacia_pattern_1.createItemBlock(),
                planks_acacia_pattern_2.createItemBlock(),
                planks_big_oak_mossy.createItemBlock(),
                planks_big_oak_cracked.createItemBlock(),
                planks_big_oak_varnish.createItemBlock(),
                planks_big_oak_pattern_1.createItemBlock(),
                planks_big_oak_pattern_2.createItemBlock(),
                planks_birch_mossy.createItemBlock(),
                planks_birch_cracked.createItemBlock(),
                planks_birch_varnish.createItemBlock(),
                planks_birch_pattern_1.createItemBlock(),
                planks_birch_pattern_2.createItemBlock(),
                planks_jungle_mossy.createItemBlock(),
                planks_jungle_cracked.createItemBlock(),
                planks_jungle_varnish.createItemBlock(),
                planks_jungle_pattern_1.createItemBlock(),
                planks_jungle_pattern_2.createItemBlock(),
                planks_oak_mossy.createItemBlock(),
                planks_oak_cracked.createItemBlock(),
                planks_oak_varnish.createItemBlock(),
                planks_oak_pattern_1.createItemBlock(),
                planks_oak_pattern_2.createItemBlock(),
                planks_spruce_mossy.createItemBlock(),
                planks_spruce_cracked.createItemBlock(),
                planks_spruce_varnish.createItemBlock(),
                planks_spruce_pattern_1.createItemBlock(),
                planks_spruce_pattern_2.createItemBlock(),
                wooden_bars.createItemBlock(),
                button_spruce.createItemBlock(),
                button_birch.createItemBlock(),
                button_jungle.createItemBlock(),
                button_acacia.createItemBlock(),
                button_dark_oak.createItemBlock(),
                pressure_plate_spruce.createItemBlock(),
                pressure_plate_birch.createItemBlock(),
                pressure_plate_jungle.createItemBlock(),
                pressure_plate_acacia.createItemBlock(),
                pressure_plate_dark_oak.createItemBlock(),
                cobblestone_cracked.createItemBlock(),
                stone_slab_top.createItemBlock(),
                stone_granite_smooth_mossy.createItemBlock(),
                stonebrick_granite.createItemBlock(),
                stonebrick_granite_cracked.createItemBlock(),
                stonebrick_granite_mossy.createItemBlock(),
                stonebrick_granite_carved.createItemBlock(),
                stone_granite_slab_top.createItemBlock(),
                stone_diorite_smooth_mossy.createItemBlock(),
                stonebrick_diorite.createItemBlock(),
                stonebrick_diorite_cracked.createItemBlock(),
                stonebrick_diorite_mossy.createItemBlock(),
                stonebrick_diorite_carved.createItemBlock(),
                stone_diorite_slab_top.createItemBlock(),
                stone_andesite_smooth_mossy.createItemBlock(),
                stonebrick_andesite.createItemBlock(),
                stonebrick_andesite_cracked.createItemBlock(),
                stonebrick_andesite_mossy.createItemBlock(),
                stonebrick_andesite_carved.createItemBlock(),
                stone_andesite_slab_top.createItemBlock(),
                stonebrick_andesite_stair.createItemBlock(),
                stonebrick_granite_stair.createItemBlock(),
                stonebrick_diorite_stair.createItemBlock(),
                stone_andesite_stair.createItemBlock(),
                stone_granite_stair.createItemBlock(),
                stone_diorite_stair.createItemBlock(),
                smooth_andesite_stair.createItemBlock(),
                smooth_granite_stair.createItemBlock(),
                smooth_diorite_stair.createItemBlock(),
                smooth_stone_stair.createItemBlock(),
                button_andesite.createItemBlock(),
                button_diorite.createItemBlock(),
                button_granite.createItemBlock(),
                pressure_plate_andesite.createItemBlock(),
                pressure_plate_diorite.createItemBlock(),
                pressure_plate_granite.createItemBlock(),
                amethyst_ore.createItemBlock(),
                aquamarine_ore.createItemBlock(),
                charoite_ore.createItemBlock(),
                citrine_ore.createItemBlock(),
                coraline_ore.createItemBlock(),
                hematite_ore.createItemBlock(),
                malachite_ore.createItemBlock(),
                opale_ore.createItemBlock(),
                quartz_ore.createItemBlock(),
                quartzrose_ore.createItemBlock(),
                ruby_ore.createItemBlock(),
                tigereye_ore.createItemBlock(),
                tourmaline_ore.createItemBlock(),
                turquoise_ore.createItemBlock(),
                copper_ore.createItemBlock(),
                tin_ore.createItemBlock(),
                lead_ore.createItemBlock(),
                silver_ore.createItemBlock(),
                alun_ore.createItemBlock(),
                salt_ore.createItemBlock(),
                salt_carrier.createItemBlock(),
                wool_colored_white_stairs.createItemBlock(),
                wool_colored_orange_stairs.createItemBlock(),
                wool_colored_magenta_stairs.createItemBlock(),
                wool_colored_light_blue_stairs.createItemBlock(),
                wool_colored_yellow_stairs.createItemBlock(),
                wool_colored_lime_stairs.createItemBlock(),
                wool_colored_pink_stairs.createItemBlock(),
                wool_colored_gray_stairs.createItemBlock(),
                wool_colored_silver_stairs.createItemBlock(),
                wool_colored_cyan_stairs.createItemBlock(),
                wool_colored_purple_stairs.createItemBlock(),
                wool_colored_blue_stairs.createItemBlock(),
                wool_colored_brown_stairs.createItemBlock(),
                wool_colored_green_stairs.createItemBlock(),
                wool_colored_red_stairs.createItemBlock(),
                wool_colored_black_stairs.createItemBlock(),
                hardened_clay_stained_white_stairs.createItemBlock(),
                hardened_clay_stained_orange_stairs.createItemBlock(),
                hardened_clay_stained_magenta_stairs.createItemBlock(),
                hardened_clay_stained_light_blue_stairs.createItemBlock(),
                hardened_clay_stained_yellow_stairs.createItemBlock(),
                hardened_clay_stained_lime_stairs.createItemBlock(),
                hardened_clay_stained_pink_stairs.createItemBlock(),
                hardened_clay_stained_gray_stairs.createItemBlock(),
                hardened_clay_stained_silver_stairs.createItemBlock(),
                hardened_clay_stained_cyan_stairs.createItemBlock(),
                hardened_clay_stained_purple_stairs.createItemBlock(),
                hardened_clay_stained_blue_stairs.createItemBlock(),
                hardened_clay_stained_brown_stairs.createItemBlock(),
                hardened_clay_stained_green_stairs.createItemBlock(),
                hardened_clay_stained_red_stairs.createItemBlock(),
                hardened_clay_stained_black_stairs.createItemBlock(),
                hardened_clay_stairs.createItemBlock(),
                robust_glass_white.createItemBlock(),
                robust_glass_orange.createItemBlock(),
                robust_glass_magenta.createItemBlock(),
                robust_glass_light_blue.createItemBlock(),
                robust_glass_yellow.createItemBlock(),
                robust_glass_lime.createItemBlock(),
                robust_glass_pink.createItemBlock(),
                robust_glass_gray.createItemBlock(),
                robust_glass_silver.createItemBlock(),
                robust_glass_cyan.createItemBlock(),
                robust_glass_purple.createItemBlock(),
                robust_glass_blue.createItemBlock(),
                robust_glass_brown.createItemBlock(),
                robust_glass_green.createItemBlock(),
                robust_glass_red.createItemBlock(),
                robust_glass_black.createItemBlock(),
                robust_glass_normal.createItemBlock(),
                robust_glass_pane_white.createItemBlock(),
                robust_glass_pane_orange.createItemBlock(),
                robust_glass_pane_magenta.createItemBlock(),
                robust_glass_pane_light_blue.createItemBlock(),
                robust_glass_pane_yellow.createItemBlock(),
                robust_glass_pane_lime.createItemBlock(),
                robust_glass_pane_pink.createItemBlock(),
                robust_glass_pane_gray.createItemBlock(),
                robust_glass_pane_silver.createItemBlock(),
                robust_glass_pane_cyan.createItemBlock(),
                robust_glass_pane_purple.createItemBlock(),
                robust_glass_pane_blue.createItemBlock(),
                robust_glass_pane_brown.createItemBlock(),
                robust_glass_pane_green.createItemBlock(),
                robust_glass_pane_red.createItemBlock(),
                robust_glass_pane_black.createItemBlock(),
                robust_glass_pane_normal.createItemBlock(),
                oak_stool.createItemBlock(),
                spruce_stool.createItemBlock(),
                birch_stool.createItemBlock(),
                jungle_stool.createItemBlock(),
                big_oak_stool.createItemBlock(),
                acacia_stool.createItemBlock(),
                oak_chair.createItemBlock(),
                spruce_chair.createItemBlock(),
                birch_chair.createItemBlock(),
                jungle_chair.createItemBlock(),
                big_oak_chair.createItemBlock(),
                acacia_chair.createItemBlock(),
                oak_table.createItemBlock(),
                spruce_table.createItemBlock(),
                birch_table.createItemBlock(),
                jungle_table.createItemBlock(),
                big_oak_table.createItemBlock(),
                acacia_table.createItemBlock(),
                oak_table_low.createItemBlock(),
                spruce_table_low.createItemBlock(),
                birch_table_low.createItemBlock(),
                jungle_table_low.createItemBlock(),
                big_oak_table_low.createItemBlock(),
                acacia_table_low.createItemBlock(),
                oak_shelf.createItemBlock(),
                spruce_shelf.createItemBlock(),
                birch_shelf.createItemBlock(),
                jungle_shelf.createItemBlock(),
                big_oak_shelf.createItemBlock(),
                acacia_shelf.createItemBlock(),
                support.createItemBlock(),
                long_support.createItemBlock(),
                support_fat.createItemBlock(),
                long_support_fat.createItemBlock(),
                little_chest.createItemBlock(),
                beer_barrel.createItemBlock(),
                water_barrel.createItemBlock(),
                milk_barrel.createItemBlock(),
                wine_barrel.createItemBlock(),
                cider_barrel.createItemBlock(),
                hydromel_barrel.createItemBlock(),
                rhum_barrel.createItemBlock(),
                empty_barrel.createItemBlock(),
                bibliotheque_oak.createItemBlock(),
                bibliotheque_birch.createItemBlock(),
                bibliotheque_spruce.createItemBlock(),
                bibliotheque_jungle.createItemBlock(),
                bibliotheque_acacia.createItemBlock(),
                bibliotheque_dark_oak.createItemBlock(),
                cupboard.createItemBlock(),
                acacia_trapdoor.createItemBlock(),
                birch_trapdoor.createItemBlock(),
                jungle_trapdoor.createItemBlock(),
                dark_oak_trapdoor.createItemBlock(),
                spruce_trapdoor.createItemBlock(),
                trapdoor_lockable.createItemBlock(),
                iron_trapdoor_lockable.createItemBlock(),
                acacia_trapdoor_lockable.createItemBlock(),
                birch_trapdoor_lockable.createItemBlock(),
                dark_oak_trapdoor_lockable.createItemBlock(),
                jungle_trapdoor_lockable.createItemBlock(),
                spruce_trapdoor_lockable.createItemBlock(),
                flower_violets.createItemBlock(),
                flower_blue_hydrangea.createItemBlock(),
                flower_bluebells.createItemBlock(),
                flower_bromeliad.createItemBlock(),
                flower_daisy.createItemBlock(),
                flower_dandelion.createItemBlock(),
                flower_goldenrod.createItemBlock(),
                flower_iris.createItemBlock(),
                flower_lavender.createItemBlock(),
                flower_lily.createItemBlock(),
                flower_orange_cosmos.createItemBlock(),
                flower_pink_daffodil.createItemBlock(),
                flower_pink_hibiscus.createItemBlock(),
                flower_swampflower.createItemBlock(),
                flower_swampviolets.createItemBlock(),
                flower_wildflower.createItemBlock(),
                mushroom_blue_milk_cap.createItemBlock(),
                mushroom_flat.createItemBlock(),
                mushroom_portobello.createItemBlock(),
                mushroom_toadstool.createItemBlock(),
                mushroom_strange.createItemBlock(),
                plant_tea.createItemBlock(),
                distaff.createItemBlock(),
                apple_bloom.createItemBlock(),
                raspberry_bloom.createItemBlock(),
                cassis_bloom.createItemBlock(),
                cherry_bloom.createItemBlock(),
                chestnut_bloom.createItemBlock(),
                lemon_bloom.createItemBlock(),
                peach_bloom.createItemBlock(),
                strawberry_bloom.createItemBlock(),
                apricot_bloom.createItemBlock(),
                chess_board.createItemBlock(),
                card_deck.createItemBlock(),
                repair_wheel.createItemBlock(),
                concrete_colored_white_stairs.createItemBlock(),
                concrete_colored_orange_stairs.createItemBlock(),
                concrete_colored_magenta_stairs.createItemBlock(),
                concrete_colored_light_blue_stairs.createItemBlock(),
                concrete_colored_yellow_stairs.createItemBlock(),
                concrete_colored_lime_stairs.createItemBlock(),
                concrete_colored_pink_stairs.createItemBlock(),
                concrete_colored_gray_stairs.createItemBlock(),
                concrete_colored_silver_stairs.createItemBlock(),
                concrete_colored_cyan_stairs.createItemBlock(),
                concrete_colored_purple_stairs.createItemBlock(),
                concrete_colored_blue_stairs.createItemBlock(),
                concrete_colored_brown_stairs.createItemBlock(),
                concrete_colored_green_stairs.createItemBlock(),
                concrete_colored_red_stairs.createItemBlock(),
                concrete_colored_black_stairs.createItemBlock(),
                salsola.createItemBlock(),
                container_hrp.createItemBlock(),
                wooden_cupboard.createItemBlock(),
                oak_static_sign.createItemBlock(),
                birch_static_sign.createItemBlock(),
                spruce_static_sign.createItemBlock(),
                jungle_static_sign.createItemBlock(),
                dark_oak_static_sign.createItemBlock(),
                acacia_static_sign.createItemBlock(),
                stone_static_sign.createItemBlock(),
                granite_static_sign.createItemBlock(),
                andesite_static_sign.createItemBlock(),
                diorite_static_sign.createItemBlock(),
                stone_fence.createItemBlock(),
                andesite_fence.createItemBlock(),
                diorite_fence.createItemBlock(),
                granite_fence.createItemBlock(),
                oak_wood_fence.createItemBlock(),
                spruce_wood_fence.createItemBlock(),
                birch_wood_fence.createItemBlock(),
                jungle_wood_fence.createItemBlock(),
                dark_oak_wood_fence.createItemBlock(),
                acacia_wood_fence.createItemBlock(),
                rose_vine.createItemBlock(),
                red_rose_vine.createItemBlock(),
                pink_rose_vine.createItemBlock(),
                yellow_rose_vine.createItemBlock(),
                white_flower_vine.createItemBlock(),
                red_flower_vine.createItemBlock(),
                purple_flower_vine.createItemBlock(),
                pale_vine.createItemBlock(),
                blue_slate.createItemBlock(),
                blue_slate_raw.createItemBlock(),
                blue_slate_stairs.createItemBlock(),
                clay_slate.createItemBlock(),
                clay_slate_stairs.createItemBlock()
              /*oak_leaves_stairs.createItemBlock(),
                birch_leaves_stairs.createItemBlock(),
                spruce_leaves_stairs.createItemBlock(),
                jungle_leaves_stairs.createItemBlock(),
                dark_oak_leaves_stairs.createItemBlock(),
                acacia_leaves_stairs.createItemBlock()*/
                

        //wall_note_esperia.createItemBlock()
        );
        registry.register(hay_slab_item);
        registry.register(wool_slab_item);
        registry.register(wool_slab_b_item);
        registry.register(concrete_slab_item);
        registry.register(concrete_slab_b_item);
        registry.register(icicle_item);
        registry.register(stone_stalactite_item);
        registry.register(campfire_item);
        registry.register(lit_campfire_item);
        registry.register(hardened_clay_slab_item);
        registry.register(hardened_clay_slab_b_item);
        registry.register(stone_slab_item);
        registry.register(stone_slab_b_item);
        registry.register(hay_bed_item);
        registry.register(hay_layer_item);
        registry.register(old_hay_layer_item);
        registry.register(ash_layer_item);
        registry.register(sand_layer_item);
        registry.register(red_sand_layer_item);
        registry.register(leaves_layer_item);
        registry.register(leaves_acacia_layer_item);
        registry.register(leaves_dark_oak_layer_item);
        registry.register(leaves_jungle_layer_item);
        registry.register(leaves_spruce_layer_item);
        registry.register(leaves_birch_layer_item);
        registry.register(wood_wall_oak_item);
        registry.register(wood_wall_birch_item);
        registry.register(wood_wall_spruce_item);
        registry.register(wood_wall_jungle_item);
        registry.register(wood_wall_acacia_item);
        registry.register(wood_wall_dark_oak_item);
        registry.register(stone_wall_andesite_item);
        registry.register(stone_wall_diorite_item);
        registry.register(stone_wall_granite_item);
        registry.register(door_strong_item);
        registry.register(acacia_door_lockable_item);
        registry.register(birch_door_lockable_item);
        registry.register(dark_oak_door_lockable_item);
        registry.register(iron_door_lockable_item);
        registry.register(jungle_door_lockable_item);
        registry.register(oak_door_lockable_item);
        registry.register(spruce_door_lockable_item);
        registry.register(door_strong_lockable_item);
        registry.register(wall_note_item);
        registry.register(showcase_black_item);
        registry.register(showcase_blue_item);
        registry.register(showcase_brown_item);
        registry.register(showcase_cyan_item);
        registry.register(showcase_green_item);
        registry.register(showcase_grey_item);
        registry.register(showcase_light_blue_item);
        registry.register(showcase_lime_item);
        registry.register(showcase_magenta_item);
        registry.register(showcase_orange_item);
        registry.register(showcase_pink_item);
        registry.register(showcase_purple_item);
        registry.register(showcase_red_item);
        registry.register(showcase_silver_item);
        registry.register(showcase_white_item);
        registry.register(showcase_yellow_item);
        registry.register(oak_shutter_item);
        registry.register(spruce_shutter_item);
        registry.register(birch_shutter_item);
        registry.register(jungle_shutter_item);
        registry.register(dark_oak_shutter_item);
        registry.register(acacia_shutter_item);
        registry.register(clear_window_item);
        registry.register(black_window_item);
        registry.register(blue_window_item);
        registry.register(brown_window_item);
        registry.register(cyan_window_item);
        registry.register(green_window_item);
        registry.register(gray_window_item);
        registry.register(light_blue_window_item);
        registry.register(lime_window_item);
        registry.register(magenta_window_item);
        registry.register(orange_window_item);
        registry.register(pink_window_item);
        registry.register(purple_window_item);
        registry.register(red_window_item);
        registry.register(silver_window_item);
        registry.register(white_window_item);
        registry.register(yellow_window_item);

        //registry.register(sign_hrp_item);
        //registry.register(sign_stone_item);
    }

    public static void registerModels() {
        stuc.registerItemModel(Item.getItemFromBlock(stuc));
        flower_pot.registerItemModel(Item.getItemFromBlock(flower_pot));
        hay_slab.registerItemModel(hay_slab_item);
        raw_slate.registerItemModel(Item.getItemFromBlock(raw_slate));
        slate.registerItemModel(Item.getItemFromBlock(slate));
        slate_stairs.registerItemModel(Item.getItemFromBlock(slate_stairs));
        ash_block.registerItemModel(Item.getItemFromBlock(ash_block));
        ash_layer.registerItemModel(ash_layer_item);
        sand_layer.registerItemModel(sand_layer_item);
        red_sand_layer.registerItemModel(red_sand_layer_item);
        hay_block.registerItemModel(Item.getItemFromBlock(hay_block));
        hay_stairs.registerItemModel(Item.getItemFromBlock(hay_stairs));
        hay_layer.registerItemModel(Item.getItemFromBlock(hay_layer));
        old_hay_ball.registerItemModel(Item.getItemFromBlock(old_hay_ball));
        old_hay_block.registerItemModel(Item.getItemFromBlock(old_hay_block));
        old_hay_stairs.registerItemModel(Item.getItemFromBlock(old_hay_stairs));
        hay_layer.registerItemModel(hay_layer_item);
        old_hay_layer.registerItemModel(old_hay_layer_item);
        leaves_layer.registerItemModel(leaves_layer_item);
        leaves_dark_oak_layer.registerItemModel(leaves_dark_oak_layer_item);
        leaves_jungle_layer.registerItemModel(leaves_jungle_layer_item);
        leaves_birch_layer.registerItemModel(leaves_birch_layer_item);
        leaves_spruce_layer.registerItemModel(leaves_spruce_layer_item);
        leaves_jungle_layer.registerItemModel(leaves_jungle_layer_item);
        leaves_acacia_layer.registerItemModel(leaves_acacia_layer_item);
        bronze_block.registerItemModel(Item.getItemFromBlock(bronze_block));
        copper_block.registerItemModel(Item.getItemFromBlock(copper_block));
        lead_block.registerItemModel(Item.getItemFromBlock(lead_block));
        steel_block.registerItemModel(Item.getItemFromBlock(steel_block));
        silver_block.registerItemModel(Item.getItemFromBlock(silver_block));
        tin_block.registerItemModel(Item.getItemFromBlock(tin_block));
        mud_half.registerItemModel(Item.getItemFromBlock(mud_half));
        mud_full.registerItemModel(Item.getItemFromBlock(mud_full));
        timber_block.registerItemModel(Item.getItemFromBlock(timber_block));
        timber_block_crossed.registerItemModel(Item.getItemFromBlock(timber_block_crossed));
        timber_block_right.registerItemModel(Item.getItemFromBlock(timber_block_right));
        timber_block_left.registerItemModel(Item.getItemFromBlock(timber_block_left));
        timber_block_horizontal.registerItemModel(Item.getItemFromBlock(timber_block_horizontal));
        timber_block_vertical.registerItemModel(Item.getItemFromBlock(timber_block_vertical));
        stone_stalactite.registerItemModel(stone_stalactite_item);
        icicle.registerItemModel(icicle_item);
        wall_note.registerItemModel(wall_note_item);
        //hrp_standing_sign.registerItemModel(sign_hrp_item);
        //hrp_wall_sign.registerItemModel(sign_hrp_item);
        //stone_standing_sign.registerItemModel(sign_stone_item);
        //stone_wall_sign.registerItemModel(sign_stone_item);
        candle_on.registerItemModel(Item.getItemFromBlock(candle_on));
        candle_off.registerItemModel(Item.getItemFromBlock(candle_off));
        chain.registerItemModel(Item.getItemFromBlock(chain));
        rope.registerItemModel(Item.getItemFromBlock(rope));
        lantern_white.registerItemModel(Item.getItemFromBlock(lantern_white));
        lantern_orange.registerItemModel(Item.getItemFromBlock(lantern_orange));
        lantern_yellow.registerItemModel(Item.getItemFromBlock(lantern_yellow));
        lantern_purple.registerItemModel(Item.getItemFromBlock(lantern_purple));
        lantern_blue.registerItemModel(Item.getItemFromBlock(lantern_blue));
        lantern_green.registerItemModel(Item.getItemFromBlock(lantern_green));
        lantern_red.registerItemModel(Item.getItemFromBlock(lantern_red));
        paper_lantern_white.registerItemModel(Item.getItemFromBlock(paper_lantern_white));
        paper_lantern_orange.registerItemModel(Item.getItemFromBlock(paper_lantern_orange));
        paper_lantern_yellow.registerItemModel(Item.getItemFromBlock(paper_lantern_yellow));
        paper_lantern_purple.registerItemModel(Item.getItemFromBlock(paper_lantern_purple));
        paper_lantern_blue.registerItemModel(Item.getItemFromBlock(paper_lantern_blue));
        paper_lantern_green.registerItemModel(Item.getItemFromBlock(paper_lantern_green));
        paper_lantern_red.registerItemModel(Item.getItemFromBlock(paper_lantern_red));
        lantern_off_white.registerItemModel(Item.getItemFromBlock(lantern_off_white));
        lantern_off_orange.registerItemModel(Item.getItemFromBlock(lantern_off_orange));
        lantern_off_yellow.registerItemModel(Item.getItemFromBlock(lantern_off_yellow));
        lantern_off_purple.registerItemModel(Item.getItemFromBlock(lantern_off_purple));
        lantern_off_blue.registerItemModel(Item.getItemFromBlock(lantern_off_blue));
        lantern_off_green.registerItemModel(Item.getItemFromBlock(lantern_off_green));
        lantern_off_red.registerItemModel(Item.getItemFromBlock(lantern_off_red));
        paper_lantern_off_white.registerItemModel(Item.getItemFromBlock(paper_lantern_off_white));
        paper_lantern_off_orange.registerItemModel(Item.getItemFromBlock(paper_lantern_off_orange));
        paper_lantern_off_yellow.registerItemModel(Item.getItemFromBlock(paper_lantern_off_yellow));
        paper_lantern_off_purple.registerItemModel(Item.getItemFromBlock(paper_lantern_off_purple));
        paper_lantern_off_blue.registerItemModel(Item.getItemFromBlock(paper_lantern_off_blue));
        paper_lantern_off_green.registerItemModel(Item.getItemFromBlock(paper_lantern_off_green));
        paper_lantern_off_red.registerItemModel(Item.getItemFromBlock(paper_lantern_off_red));
        big_lantern.registerItemModel(Item.getItemFromBlock(big_lantern));
        big_lantern_off.registerItemModel(Item.getItemFromBlock(big_lantern_off));
        hive.registerItemModel(Item.getItemFromBlock(hive));
        hive_cube.registerItemModel(Item.getItemFromBlock(hive_cube));
        campfire.registerItemModel(campfire_item);
        lit_campfire.registerItemModel(lit_campfire_item);
        decal_water_puddle.registerItemModel(Item.getItemFromBlock(decal_water_puddle));
        decal_blood_puddle.registerItemModel(Item.getItemFromBlock(decal_blood_puddle));
        decal_mud_puddle.registerItemModel(Item.getItemFromBlock(decal_mud_puddle));
        log_oak_mossy.registerItemModel(Item.getItemFromBlock(log_oak_mossy));
        log_birch_mossy.registerItemModel(Item.getItemFromBlock(log_birch_mossy));
        log_spruce_mossy.registerItemModel(Item.getItemFromBlock(log_spruce_mossy));
        log_jungle_mossy.registerItemModel(Item.getItemFromBlock(log_jungle_mossy));
        log_acacia_mossy.registerItemModel(Item.getItemFromBlock(log_acacia_mossy));
        log_dark_oak_mossy.registerItemModel(Item.getItemFromBlock(log_dark_oak_mossy));
        planks_acacia_mossy.registerItemModel(Item.getItemFromBlock(planks_acacia_mossy));
        planks_acacia_cracked.registerItemModel(Item.getItemFromBlock(planks_acacia_cracked));
        planks_acacia_varnish.registerItemModel(Item.getItemFromBlock(planks_acacia_varnish));
        planks_acacia_pattern_1.registerItemModel(Item.getItemFromBlock(planks_acacia_pattern_1));
        planks_acacia_pattern_2.registerItemModel(Item.getItemFromBlock(planks_acacia_pattern_2));
        planks_big_oak_mossy.registerItemModel(Item.getItemFromBlock(planks_big_oak_mossy));
        planks_big_oak_cracked.registerItemModel(Item.getItemFromBlock(planks_big_oak_cracked));
        planks_big_oak_varnish.registerItemModel(Item.getItemFromBlock(planks_big_oak_varnish));
        planks_big_oak_pattern_1.registerItemModel(Item.getItemFromBlock(planks_big_oak_pattern_1));
        planks_big_oak_pattern_2.registerItemModel(Item.getItemFromBlock(planks_big_oak_pattern_2));
        planks_birch_mossy.registerItemModel(Item.getItemFromBlock(planks_birch_mossy));
        planks_birch_cracked.registerItemModel(Item.getItemFromBlock(planks_birch_cracked));
        planks_birch_varnish.registerItemModel(Item.getItemFromBlock(planks_birch_varnish));
        planks_birch_pattern_1.registerItemModel(Item.getItemFromBlock(planks_birch_pattern_1));
        planks_birch_pattern_2.registerItemModel(Item.getItemFromBlock(planks_birch_pattern_2));
        planks_jungle_mossy.registerItemModel(Item.getItemFromBlock(planks_jungle_mossy));
        planks_jungle_cracked.registerItemModel(Item.getItemFromBlock(planks_jungle_cracked));
        planks_jungle_varnish.registerItemModel(Item.getItemFromBlock(planks_jungle_varnish));
        planks_jungle_pattern_1.registerItemModel(Item.getItemFromBlock(planks_jungle_pattern_1));
        planks_jungle_pattern_2.registerItemModel(Item.getItemFromBlock(planks_jungle_pattern_2));
        planks_oak_mossy.registerItemModel(Item.getItemFromBlock(planks_oak_mossy));
        planks_oak_cracked.registerItemModel(Item.getItemFromBlock(planks_oak_cracked));
        planks_oak_varnish.registerItemModel(Item.getItemFromBlock(planks_oak_varnish));
        planks_oak_pattern_1.registerItemModel(Item.getItemFromBlock(planks_oak_pattern_1));
        planks_oak_pattern_2.registerItemModel(Item.getItemFromBlock(planks_oak_pattern_2));
        planks_spruce_mossy.registerItemModel(Item.getItemFromBlock(planks_spruce_mossy));
        planks_spruce_cracked.registerItemModel(Item.getItemFromBlock(planks_spruce_cracked));
        planks_spruce_varnish.registerItemModel(Item.getItemFromBlock(planks_spruce_varnish));
        planks_spruce_pattern_1.registerItemModel(Item.getItemFromBlock(planks_spruce_pattern_1));
        planks_spruce_pattern_2.registerItemModel(Item.getItemFromBlock(planks_spruce_pattern_2));
        wooden_bars.registerItemModel(Item.getItemFromBlock(wooden_bars));
        wood_wall_spruce.registerItemModel(wood_wall_spruce_item);
        wood_wall_oak.registerItemModel(wood_wall_oak_item);
        wood_wall_birch.registerItemModel(wood_wall_birch_item);
        wood_wall_jungle.registerItemModel(wood_wall_jungle_item);
        wood_wall_acacia.registerItemModel(wood_wall_acacia_item);
        wood_wall_dark_oak.registerItemModel(wood_wall_dark_oak_item);
        button_spruce.registerItemModel(Item.getItemFromBlock(button_spruce));
        button_birch.registerItemModel(Item.getItemFromBlock(button_birch));
        button_jungle.registerItemModel(Item.getItemFromBlock(button_jungle));
        button_acacia.registerItemModel(Item.getItemFromBlock(button_acacia));
        button_dark_oak.registerItemModel(Item.getItemFromBlock(button_dark_oak));
        pressure_plate_spruce.registerItemModel(Item.getItemFromBlock(pressure_plate_spruce));
        pressure_plate_birch.registerItemModel(Item.getItemFromBlock(pressure_plate_birch));
        pressure_plate_jungle.registerItemModel(Item.getItemFromBlock(pressure_plate_jungle));
        pressure_plate_acacia.registerItemModel(Item.getItemFromBlock(pressure_plate_acacia));
        pressure_plate_dark_oak.registerItemModel(Item.getItemFromBlock(pressure_plate_dark_oak));
        cobblestone_cracked.registerItemModel(Item.getItemFromBlock(cobblestone_cracked));
        stone_slab_top.registerItemModel(Item.getItemFromBlock(stone_slab_top));
        stone_granite_smooth_mossy.registerItemModel(Item.getItemFromBlock(stone_granite_smooth_mossy));
        stonebrick_granite.registerItemModel(Item.getItemFromBlock(stonebrick_granite));
        stonebrick_granite_cracked.registerItemModel(Item.getItemFromBlock(stonebrick_granite_cracked));
        stonebrick_granite_mossy.registerItemModel(Item.getItemFromBlock(stonebrick_granite_mossy));
        stonebrick_granite_carved.registerItemModel(Item.getItemFromBlock(stonebrick_granite_carved));
        stone_granite_slab_top.registerItemModel(Item.getItemFromBlock(stone_granite_slab_top));
        stone_diorite_smooth_mossy.registerItemModel(Item.getItemFromBlock(stone_diorite_smooth_mossy));
        stonebrick_diorite.registerItemModel(Item.getItemFromBlock(stonebrick_diorite));
        stonebrick_diorite_cracked.registerItemModel(Item.getItemFromBlock(stonebrick_diorite_cracked));
        stonebrick_diorite_mossy.registerItemModel(Item.getItemFromBlock(stonebrick_diorite_mossy));
        stonebrick_diorite_carved.registerItemModel(Item.getItemFromBlock(stonebrick_diorite_carved));
        stone_diorite_slab_top.registerItemModel(Item.getItemFromBlock(stone_diorite_slab_top));
        stone_andesite_smooth_mossy.registerItemModel(Item.getItemFromBlock(stone_andesite_smooth_mossy));
        stonebrick_andesite.registerItemModel(Item.getItemFromBlock(stonebrick_andesite));
        stonebrick_andesite_cracked.registerItemModel(Item.getItemFromBlock(stonebrick_andesite_cracked));
        stonebrick_andesite_mossy.registerItemModel(Item.getItemFromBlock(stonebrick_andesite_mossy));
        stonebrick_andesite_carved.registerItemModel(Item.getItemFromBlock(stonebrick_andesite_carved));
        stone_andesite_slab_top.registerItemModel(Item.getItemFromBlock(stone_andesite_slab_top));
        stonebrick_andesite_stair.registerItemModel(Item.getItemFromBlock(stonebrick_andesite_stair));
        stonebrick_granite_stair.registerItemModel(Item.getItemFromBlock(stonebrick_granite_stair));
        stonebrick_diorite_stair.registerItemModel(Item.getItemFromBlock(stonebrick_diorite_stair));
        stone_andesite_stair.registerItemModel(Item.getItemFromBlock(stone_andesite_stair));
        stone_granite_stair.registerItemModel(Item.getItemFromBlock(stone_granite_stair));
        stone_diorite_stair.registerItemModel(Item.getItemFromBlock(stone_diorite_stair));
        smooth_andesite_stair.registerItemModel(Item.getItemFromBlock(smooth_andesite_stair));
        smooth_granite_stair.registerItemModel(Item.getItemFromBlock(smooth_granite_stair));
        smooth_diorite_stair.registerItemModel(Item.getItemFromBlock(smooth_diorite_stair));
        smooth_stone_stair.registerItemModel(Item.getItemFromBlock(smooth_stone_stair));
        stone_slab.registerItemModel(stone_slab_item);
        stone_slab_b.registerItemModel(stone_slab_b_item);
        stone_wall_andesite.registerItemModel(stone_wall_andesite_item);
        stone_wall_diorite.registerItemModel(stone_wall_diorite_item);
        stone_wall_granite.registerItemModel(stone_wall_granite_item);
        button_andesite.registerItemModel(Item.getItemFromBlock(button_andesite));
        button_diorite.registerItemModel(Item.getItemFromBlock(button_diorite));
        button_granite.registerItemModel(Item.getItemFromBlock(button_granite));
        pressure_plate_andesite.registerItemModel(Item.getItemFromBlock(pressure_plate_andesite));
        pressure_plate_diorite.registerItemModel(Item.getItemFromBlock(pressure_plate_diorite));
        pressure_plate_granite.registerItemModel(Item.getItemFromBlock(pressure_plate_granite));
        amethyst_ore.registerItemModel(Item.getItemFromBlock(amethyst_ore));
        aquamarine_ore.registerItemModel(Item.getItemFromBlock(aquamarine_ore));
        charoite_ore.registerItemModel(Item.getItemFromBlock(charoite_ore));
        citrine_ore.registerItemModel(Item.getItemFromBlock(citrine_ore));
        coraline_ore.registerItemModel(Item.getItemFromBlock(coraline_ore));
        hematite_ore.registerItemModel(Item.getItemFromBlock(hematite_ore));
        malachite_ore.registerItemModel(Item.getItemFromBlock(malachite_ore));
        opale_ore.registerItemModel(Item.getItemFromBlock(opale_ore));
        quartz_ore.registerItemModel(Item.getItemFromBlock(quartz_ore));
        quartzrose_ore.registerItemModel(Item.getItemFromBlock(quartzrose_ore));
        ruby_ore.registerItemModel(Item.getItemFromBlock(ruby_ore));
        tigereye_ore.registerItemModel(Item.getItemFromBlock(tigereye_ore));
        tourmaline_ore.registerItemModel(Item.getItemFromBlock(tourmaline_ore));
        turquoise_ore.registerItemModel(Item.getItemFromBlock(turquoise_ore));
        copper_ore.registerItemModel(Item.getItemFromBlock(copper_ore));
        tin_ore.registerItemModel(Item.getItemFromBlock(tin_ore));
        lead_ore.registerItemModel(Item.getItemFromBlock(lead_ore));
        silver_ore.registerItemModel(Item.getItemFromBlock(silver_ore));
        alun_ore.registerItemModel(Item.getItemFromBlock(alun_ore));
        salt_ore.registerItemModel(Item.getItemFromBlock(salt_ore));
        salt_carrier.registerItemModel(Item.getItemFromBlock(salt_carrier));
        wool_colored_white_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_white_stairs));
        wool_colored_orange_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_orange_stairs));
        wool_colored_magenta_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_magenta_stairs));
        wool_colored_yellow_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_yellow_stairs));
        wool_colored_lime_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_lime_stairs));
        wool_colored_pink_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_pink_stairs));
        wool_colored_gray_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_gray_stairs));
        wool_colored_silver_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_silver_stairs));
        wool_colored_cyan_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_cyan_stairs));
        wool_colored_purple_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_purple_stairs));
        wool_colored_light_blue_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_light_blue_stairs));
        wool_colored_blue_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_blue_stairs));
        wool_colored_brown_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_brown_stairs));
        wool_colored_green_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_green_stairs));
        wool_colored_red_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_red_stairs));
        wool_colored_black_stairs.registerItemModel(Item.getItemFromBlock(wool_colored_black_stairs));
        wool_slab.registerItemModel(wool_slab_item);
        wool_slab_b.registerItemModel(wool_slab_b_item);
        hardened_clay_stained_white_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_white_stairs));
        hardened_clay_stained_orange_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_orange_stairs));
        hardened_clay_stained_magenta_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_magenta_stairs));
        hardened_clay_stained_lime_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_lime_stairs));
        hardened_clay_stained_pink_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_pink_stairs));
        hardened_clay_stained_gray_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_gray_stairs));
        hardened_clay_stained_silver_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_silver_stairs));
        hardened_clay_stained_cyan_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_cyan_stairs));
        hardened_clay_stained_purple_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_purple_stairs));
        hardened_clay_stained_light_blue_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_light_blue_stairs));
        hardened_clay_stained_yellow_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_yellow_stairs));
        hardened_clay_stained_blue_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_blue_stairs));
        hardened_clay_stained_brown_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_brown_stairs));
        hardened_clay_stained_green_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_green_stairs));
        hardened_clay_stained_red_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_red_stairs));
        hardened_clay_stained_black_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stained_black_stairs));
        hardened_clay_stairs.registerItemModel(Item.getItemFromBlock(hardened_clay_stairs));
        hardened_clay_slab.registerItemModel(hardened_clay_slab_item);
        hardened_clay_slab_b.registerItemModel(hardened_clay_slab_b_item);
        robust_glass_white.registerItemModel(Item.getItemFromBlock(robust_glass_white));
        robust_glass_orange.registerItemModel(Item.getItemFromBlock(robust_glass_orange));
        robust_glass_magenta.registerItemModel(Item.getItemFromBlock(robust_glass_magenta));
        robust_glass_light_blue.registerItemModel(Item.getItemFromBlock(robust_glass_light_blue));
        robust_glass_yellow.registerItemModel(Item.getItemFromBlock(robust_glass_yellow));
        robust_glass_lime.registerItemModel(Item.getItemFromBlock(robust_glass_lime));
        robust_glass_pink.registerItemModel(Item.getItemFromBlock(robust_glass_pink));
        robust_glass_gray.registerItemModel(Item.getItemFromBlock(robust_glass_gray));
        robust_glass_silver.registerItemModel(Item.getItemFromBlock(robust_glass_silver));
        robust_glass_cyan.registerItemModel(Item.getItemFromBlock(robust_glass_cyan));
        robust_glass_purple.registerItemModel(Item.getItemFromBlock(robust_glass_purple));
        robust_glass_blue.registerItemModel(Item.getItemFromBlock(robust_glass_blue));
        robust_glass_brown.registerItemModel(Item.getItemFromBlock(robust_glass_brown));
        robust_glass_green.registerItemModel(Item.getItemFromBlock(robust_glass_green));
        robust_glass_red.registerItemModel(Item.getItemFromBlock(robust_glass_red));
        robust_glass_black.registerItemModel(Item.getItemFromBlock(robust_glass_black));
        robust_glass_normal.registerItemModel(Item.getItemFromBlock(robust_glass_normal));
        robust_glass_pane_white.registerItemModel(Item.getItemFromBlock(robust_glass_pane_white));
        robust_glass_pane_orange.registerItemModel(Item.getItemFromBlock(robust_glass_pane_orange));
        robust_glass_pane_magenta.registerItemModel(Item.getItemFromBlock(robust_glass_pane_magenta));
        robust_glass_pane_light_blue.registerItemModel(Item.getItemFromBlock(robust_glass_pane_light_blue));
        robust_glass_pane_yellow.registerItemModel(Item.getItemFromBlock(robust_glass_pane_yellow));
        robust_glass_pane_lime.registerItemModel(Item.getItemFromBlock(robust_glass_pane_lime));
        robust_glass_pane_pink.registerItemModel(Item.getItemFromBlock(robust_glass_pane_pink));
        robust_glass_pane_gray.registerItemModel(Item.getItemFromBlock(robust_glass_pane_gray));
        robust_glass_pane_silver.registerItemModel(Item.getItemFromBlock(robust_glass_pane_silver));
        robust_glass_pane_cyan.registerItemModel(Item.getItemFromBlock(robust_glass_pane_cyan));
        robust_glass_pane_purple.registerItemModel(Item.getItemFromBlock(robust_glass_pane_purple));
        robust_glass_pane_blue.registerItemModel(Item.getItemFromBlock(robust_glass_pane_blue));
        robust_glass_pane_brown.registerItemModel(Item.getItemFromBlock(robust_glass_pane_brown));
        robust_glass_pane_green.registerItemModel(Item.getItemFromBlock(robust_glass_pane_green));
        robust_glass_pane_red.registerItemModel(Item.getItemFromBlock(robust_glass_pane_red));
        robust_glass_pane_black.registerItemModel(Item.getItemFromBlock(robust_glass_pane_black));
        robust_glass_pane_normal.registerItemModel(Item.getItemFromBlock(robust_glass_pane_normal));
        hay_bed.registerItemModel(hay_bed_item);
        oak_stool.registerItemModel(Item.getItemFromBlock(oak_stool));
        spruce_stool.registerItemModel(Item.getItemFromBlock(spruce_stool));
        birch_stool.registerItemModel(Item.getItemFromBlock(birch_stool));
        jungle_stool.registerItemModel(Item.getItemFromBlock(jungle_stool));
        big_oak_stool.registerItemModel(Item.getItemFromBlock(big_oak_stool));
        acacia_stool.registerItemModel(Item.getItemFromBlock(acacia_stool));
        oak_chair.registerItemModel(Item.getItemFromBlock(oak_chair));
        spruce_chair.registerItemModel(Item.getItemFromBlock(spruce_chair));
        birch_chair.registerItemModel(Item.getItemFromBlock(birch_chair));
        jungle_chair.registerItemModel(Item.getItemFromBlock(jungle_chair));
        big_oak_chair.registerItemModel(Item.getItemFromBlock(big_oak_chair));
        acacia_chair.registerItemModel(Item.getItemFromBlock(acacia_chair));
        oak_table.registerItemModel(Item.getItemFromBlock(oak_table));
        spruce_table.registerItemModel(Item.getItemFromBlock(spruce_table));
        birch_table.registerItemModel(Item.getItemFromBlock(birch_table));
        jungle_table.registerItemModel(Item.getItemFromBlock(jungle_table));
        big_oak_table.registerItemModel(Item.getItemFromBlock(big_oak_table));
        acacia_table.registerItemModel(Item.getItemFromBlock(acacia_table));
        oak_table_low.registerItemModel(Item.getItemFromBlock(oak_table_low));
        spruce_table_low.registerItemModel(Item.getItemFromBlock(spruce_table_low));
        birch_table_low.registerItemModel(Item.getItemFromBlock(birch_table_low));
        jungle_table_low.registerItemModel(Item.getItemFromBlock(jungle_table_low));
        big_oak_table_low.registerItemModel(Item.getItemFromBlock(big_oak_table_low));
        acacia_table_low.registerItemModel(Item.getItemFromBlock(acacia_table_low));
        oak_shelf.registerItemModel(Item.getItemFromBlock(oak_shelf));
        spruce_shelf.registerItemModel(Item.getItemFromBlock(spruce_shelf));
        birch_shelf.registerItemModel(Item.getItemFromBlock(birch_shelf));
        jungle_shelf.registerItemModel(Item.getItemFromBlock(jungle_shelf));
        big_oak_shelf.registerItemModel(Item.getItemFromBlock(big_oak_shelf));
        acacia_shelf.registerItemModel(Item.getItemFromBlock(acacia_shelf));
        support.registerItemModel(Item.getItemFromBlock(support));
        long_support.registerItemModel(Item.getItemFromBlock(long_support));
        support_fat.registerItemModel(Item.getItemFromBlock(support_fat));
        long_support_fat.registerItemModel(Item.getItemFromBlock(long_support_fat));
        little_chest.registerItemModel(Item.getItemFromBlock(little_chest));
        water_barrel.registerItemModel(Item.getItemFromBlock(water_barrel));
        milk_barrel.registerItemModel(Item.getItemFromBlock(milk_barrel));
        beer_barrel.registerItemModel(Item.getItemFromBlock(beer_barrel));
        wine_barrel.registerItemModel(Item.getItemFromBlock(wine_barrel));
        cider_barrel.registerItemModel(Item.getItemFromBlock(cider_barrel));
        hydromel_barrel.registerItemModel(Item.getItemFromBlock(hydromel_barrel));
        rhum_barrel.registerItemModel(Item.getItemFromBlock(rhum_barrel));
        empty_barrel.registerItemModel(Item.getItemFromBlock(empty_barrel));
        bibliotheque_oak.registerItemModel(Item.getItemFromBlock(bibliotheque_oak));
        bibliotheque_birch.registerItemModel(Item.getItemFromBlock(bibliotheque_birch));
        bibliotheque_spruce.registerItemModel(Item.getItemFromBlock(bibliotheque_spruce));
        bibliotheque_jungle.registerItemModel(Item.getItemFromBlock(bibliotheque_jungle));
        bibliotheque_acacia.registerItemModel(Item.getItemFromBlock(bibliotheque_acacia));
        bibliotheque_dark_oak.registerItemModel(Item.getItemFromBlock(bibliotheque_dark_oak));
        cupboard.registerItemModel(Item.getItemFromBlock(cupboard));
        acacia_trapdoor.registerItemModel(Item.getItemFromBlock(acacia_trapdoor));
        birch_trapdoor.registerItemModel(Item.getItemFromBlock(birch_trapdoor));
        jungle_trapdoor.registerItemModel(Item.getItemFromBlock(jungle_trapdoor));
        dark_oak_trapdoor.registerItemModel(Item.getItemFromBlock(dark_oak_trapdoor));
        spruce_trapdoor.registerItemModel(Item.getItemFromBlock(spruce_trapdoor));
        door_strong.registerItemModel(door_strong_item);
        acacia_door_lockable.registerItemModel(Item.getItemFromBlock(acacia_door_lockable));
        birch_door_lockable.registerItemModel(Item.getItemFromBlock(birch_door_lockable));
        dark_oak_door_lockable.registerItemModel(Item.getItemFromBlock(dark_oak_door_lockable));
        jungle_door_lockable.registerItemModel(Item.getItemFromBlock(jungle_door_lockable));
        oak_door_lockable.registerItemModel(Item.getItemFromBlock(oak_door_lockable));
        spruce_door_lockable.registerItemModel(Item.getItemFromBlock(spruce_door_lockable));
        iron_door_lockable.registerItemModel(Item.getItemFromBlock(iron_door_lockable));
        door_strong_lockable.registerItemModel(Item.getItemFromBlock(door_strong_lockable));
        trapdoor_lockable.registerItemModel(Item.getItemFromBlock(trapdoor_lockable));
        iron_trapdoor_lockable.registerItemModel(Item.getItemFromBlock(iron_trapdoor_lockable));
        acacia_trapdoor_lockable.registerItemModel(Item.getItemFromBlock(acacia_trapdoor_lockable));
        birch_trapdoor_lockable.registerItemModel(Item.getItemFromBlock(birch_trapdoor_lockable));
        dark_oak_trapdoor_lockable.registerItemModel(Item.getItemFromBlock(dark_oak_trapdoor_lockable));
        jungle_trapdoor_lockable.registerItemModel(Item.getItemFromBlock(jungle_trapdoor_lockable));
        spruce_trapdoor_lockable.registerItemModel(Item.getItemFromBlock(spruce_trapdoor_lockable));
        flower_violets.registerItemModel(Item.getItemFromBlock(flower_violets));
        flower_blue_hydrangea.registerItemModel(Item.getItemFromBlock(flower_blue_hydrangea));
        flower_bluebells.registerItemModel(Item.getItemFromBlock(flower_bluebells));
        flower_bromeliad.registerItemModel(Item.getItemFromBlock(flower_bromeliad));
        flower_daisy.registerItemModel(Item.getItemFromBlock(flower_daisy));
        flower_dandelion.registerItemModel(Item.getItemFromBlock(flower_dandelion));
        flower_goldenrod.registerItemModel(Item.getItemFromBlock(flower_goldenrod));
        flower_iris.registerItemModel(Item.getItemFromBlock(flower_iris));
        flower_lavender.registerItemModel(Item.getItemFromBlock(flower_lavender));
        flower_lily.registerItemModel(Item.getItemFromBlock(flower_lily));
        flower_orange_cosmos.registerItemModel(Item.getItemFromBlock(flower_orange_cosmos));
        flower_pink_daffodil.registerItemModel(Item.getItemFromBlock(flower_pink_daffodil));
        flower_pink_hibiscus.registerItemModel(Item.getItemFromBlock(flower_pink_hibiscus));
        flower_swampflower.registerItemModel(Item.getItemFromBlock(flower_swampflower));
        flower_swampviolets.registerItemModel(Item.getItemFromBlock(flower_swampviolets));
        flower_wildflower.registerItemModel(Item.getItemFromBlock(flower_wildflower));
        mushroom_blue_milk_cap.registerItemModel(Item.getItemFromBlock(mushroom_blue_milk_cap));
        mushroom_flat.registerItemModel(Item.getItemFromBlock(mushroom_flat));
        mushroom_portobello.registerItemModel(Item.getItemFromBlock(mushroom_portobello));
        mushroom_toadstool.registerItemModel(Item.getItemFromBlock(mushroom_toadstool));
        mushroom_strange.registerItemModel(Item.getItemFromBlock(mushroom_strange));
        plant_tea.registerItemModel(Item.getItemFromBlock(plant_tea));
        distaff.registerItemModel(Item.getItemFromBlock(distaff));
        apple_bloom.registerItemModel(Item.getItemFromBlock(apple_bloom));
        raspberry_bloom.registerItemModel(Item.getItemFromBlock(raspberry_bloom));
        cassis_bloom.registerItemModel(Item.getItemFromBlock(cassis_bloom));
        cherry_bloom.registerItemModel(Item.getItemFromBlock(cherry_bloom));
        chestnut_bloom.registerItemModel(Item.getItemFromBlock(chestnut_bloom));
        lemon_bloom.registerItemModel(Item.getItemFromBlock(lemon_bloom));
        peach_bloom.registerItemModel(Item.getItemFromBlock(peach_bloom));
        strawberry_bloom.registerItemModel(Item.getItemFromBlock(strawberry_bloom));
        apricot_bloom.registerItemModel(Item.getItemFromBlock(apricot_bloom));
        chess_board.registerItemModel(Item.getItemFromBlock(chess_board));
        card_deck.registerItemModel(Item.getItemFromBlock(card_deck));
        repair_wheel.registerItemModel(Item.getItemFromBlock(repair_wheel));
        concrete_colored_white_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_white_stairs));
        concrete_colored_orange_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_orange_stairs));
        concrete_colored_magenta_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_magenta_stairs));
        concrete_colored_yellow_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_yellow_stairs));
        concrete_colored_lime_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_lime_stairs));
        concrete_colored_pink_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_pink_stairs));
        concrete_colored_gray_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_gray_stairs));
        concrete_colored_silver_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_silver_stairs));
        concrete_colored_cyan_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_cyan_stairs));
        concrete_colored_purple_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_purple_stairs));
        concrete_colored_light_blue_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_light_blue_stairs));
        concrete_colored_blue_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_blue_stairs));
        concrete_colored_brown_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_brown_stairs));
        concrete_colored_green_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_green_stairs));
        concrete_colored_red_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_red_stairs));
        concrete_colored_black_stairs.registerItemModel(Item.getItemFromBlock(concrete_colored_black_stairs));
        concrete_slab.registerItemModel(concrete_slab_item);
        concrete_slab_b.registerItemModel(concrete_slab_b_item);
        salsola.registerItemModel(Item.getItemFromBlock(salsola));
        showcase_black.registerItemModel(showcase_black_item);
        showcase_blue.registerItemModel(showcase_blue_item);
        showcase_brown.registerItemModel(showcase_brown_item);
        showcase_cyan.registerItemModel(showcase_cyan_item);
        showcase_green.registerItemModel(showcase_green_item);
        showcase_grey.registerItemModel(showcase_grey_item);
        showcase_light_blue.registerItemModel(showcase_light_blue_item);
        showcase_lime.registerItemModel(showcase_lime_item);
        showcase_magenta.registerItemModel(showcase_magenta_item);
        showcase_orange.registerItemModel(showcase_orange_item);
        showcase_pink.registerItemModel(showcase_pink_item);
        showcase_purple.registerItemModel(showcase_purple_item);
        showcase_red.registerItemModel(showcase_red_item);
        showcase_silver.registerItemModel(showcase_silver_item);
        showcase_white.registerItemModel(showcase_white_item);
        showcase_yellow.registerItemModel(showcase_yellow_item);
        container_hrp.registerItemModel(Item.getItemFromBlock(container_hrp));
        wooden_cupboard.registerItemModel(Item.getItemFromBlock(wooden_cupboard));
        oak_shutter.registerItemModel(oak_shutter_item);
        spruce_shutter.registerItemModel(spruce_shutter_item);
        birch_shutter.registerItemModel(birch_shutter_item);
        jungle_shutter.registerItemModel(jungle_shutter_item);
        dark_oak_shutter.registerItemModel(dark_oak_shutter_item);
        acacia_shutter.registerItemModel(acacia_shutter_item);
        clear_window.registerItemModel(clear_window_item);
        black_window.registerItemModel(black_window_item);
        blue_window.registerItemModel(blue_window_item);
        brown_window.registerItemModel(brown_window_item);
        cyan_window.registerItemModel(cyan_window_item);
        green_window.registerItemModel(green_window_item);
        gray_window.registerItemModel(gray_window_item);
        light_blue_window.registerItemModel(light_blue_window_item);
        lime_window.registerItemModel(lime_window_item);
        magenta_window.registerItemModel(magenta_window_item);
        orange_window.registerItemModel(orange_window_item);
        pink_window.registerItemModel(pink_window_item);
        purple_window.registerItemModel(purple_window_item);
        red_window.registerItemModel(red_window_item);
        silver_window.registerItemModel(silver_window_item);
        white_window.registerItemModel(white_window_item);
		yellow_window.registerItemModel(yellow_window_item);       
        oak_static_sign.registerItemModel(Item.getItemFromBlock(oak_static_sign));
        birch_static_sign.registerItemModel(Item.getItemFromBlock(birch_static_sign));
        spruce_static_sign.registerItemModel(Item.getItemFromBlock(spruce_static_sign));
        jungle_static_sign.registerItemModel(Item.getItemFromBlock(jungle_static_sign));
        dark_oak_static_sign.registerItemModel(Item.getItemFromBlock(dark_oak_static_sign));
        acacia_static_sign.registerItemModel(Item.getItemFromBlock(acacia_static_sign));
        stone_static_sign.registerItemModel(Item.getItemFromBlock(stone_static_sign));
        granite_static_sign.registerItemModel(Item.getItemFromBlock(granite_static_sign));
        andesite_static_sign.registerItemModel(Item.getItemFromBlock(andesite_static_sign));
        diorite_static_sign.registerItemModel(Item.getItemFromBlock(diorite_static_sign));
        stone_fence.registerItemModel(Item.getItemFromBlock(stone_fence));
        andesite_fence.registerItemModel(Item.getItemFromBlock(andesite_fence));
        diorite_fence.registerItemModel(Item.getItemFromBlock(diorite_fence));
        granite_fence.registerItemModel(Item.getItemFromBlock(granite_fence));
        oak_wood_fence.registerItemModel(Item.getItemFromBlock(oak_wood_fence));
        spruce_wood_fence.registerItemModel(Item.getItemFromBlock(spruce_wood_fence));
        birch_wood_fence.registerItemModel(Item.getItemFromBlock(birch_wood_fence));
        jungle_wood_fence.registerItemModel(Item.getItemFromBlock(jungle_wood_fence));
        dark_oak_wood_fence.registerItemModel(Item.getItemFromBlock(dark_oak_wood_fence));
        acacia_wood_fence.registerItemModel(Item.getItemFromBlock(acacia_wood_fence));
        rose_vine.registerItemModel(Item.getItemFromBlock(rose_vine));
        red_rose_vine.registerItemModel(Item.getItemFromBlock(red_rose_vine));
        pink_rose_vine.registerItemModel(Item.getItemFromBlock(pink_rose_vine));
        yellow_rose_vine.registerItemModel(Item.getItemFromBlock(yellow_rose_vine));
        white_flower_vine.registerItemModel(Item.getItemFromBlock(white_flower_vine));
        red_flower_vine.registerItemModel(Item.getItemFromBlock(red_flower_vine));
        purple_flower_vine.registerItemModel(Item.getItemFromBlock(purple_flower_vine));
        pale_vine.registerItemModel(Item.getItemFromBlock(pale_vine));
        blue_slate.registerItemModel(Item.getItemFromBlock(blue_slate));
        blue_slate_raw.registerItemModel(Item.getItemFromBlock(blue_slate_raw));
        blue_slate_stairs.registerItemModel(Item.getItemFromBlock(blue_slate_stairs));
        clay_slate.registerItemModel(Item.getItemFromBlock(clay_slate));
        clay_slate_stairs.registerItemModel(Item.getItemFromBlock(clay_slate_stairs));
        /*oak_leaves_stairs.registerItemModel(Item.getItemFromBlock(oak_leaves_stairs));
        birch_leaves_stairs.registerItemModel(Item.getItemFromBlock(birch_leaves_stairs));
        spruce_leaves_stairs.registerItemModel(Item.getItemFromBlock(spruce_leaves_stairs));
        jungle_leaves_stairs.registerItemModel(Item.getItemFromBlock(jungle_leaves_stairs));
        dark_oak_leaves_stairs.registerItemModel(Item.getItemFromBlock(dark_oak_leaves_stairs));
        acacia_leaves_stairs.registerItemModel(Item.getItemFromBlock(acacia_leaves_stairs));*/
    }
}
