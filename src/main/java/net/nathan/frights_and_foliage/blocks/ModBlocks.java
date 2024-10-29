package net.nathan.frights_and_foliage.blocks;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.custom.*;
import net.nathan.frights_and_foliage.item.ModItems;
import net.nathan.frights_and_foliage.particle.ModParticles;
import net.nathan.frights_and_foliage.util.ModWoodTypes;
import net.nathan.frights_and_foliage.world.tree.ModSaplingGenerators;

import static net.minecraft.block.Blocks.*;

public class ModBlocks {

    public static final Block ASERIA_PLANKS = registerBlock("aseria_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block ASERIA_STAIRS = registerBlock("aseria_stairs",
            new StairsBlock(ModBlocks.ASERIA_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS)));
    public static final Block ASERIA_SLAB = registerBlock("aseria_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)));
    public static final Block ASERIA_BUTTON = registerBlock("aseria_button",
            new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));
    public static final Block ASERIA_PRESSURE_PLATE = registerBlock("aseria_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final Block ASERIA_FENCE = registerBlock("aseria_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    public static final Block ASERIA_FENCE_GATE = registerBlock("aseria_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));
    public static final Block ASERIA_DOOR = registerBlock("aseria_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR)));
    public static final Block ASERIA_TRAPDOOR = registerBlock("aseria_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR)));
    public static final Block ASERIA_LOG = registerBlock("aseria_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block ASERIA_WOOD = registerBlock("aseria_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_ASERIA_LOG = registerBlock("stripped_aseria_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_ASERIA_WOOD = registerBlock("stripped_aseria_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final Block RED_ASERIA_LEAVES = registerBlock("red_aseria_leaves",
            new RedAseriaLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.BRIGHT_RED)));
    public static final Block ORANGE_ASERIA_LEAVES = registerBlock("orange_aseria_leaves",
            new OrangeAseriaLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.ORANGE)));
    public static final Block YELLOW_ASERIA_LEAVES = registerBlock("yellow_aseria_leaves",
            new YellowAseriaLeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.YELLOW)));

    public static final Block RED_ASERIA_SAPLING = registerBlock("red_aseria_sapling",
            new SaplingBlock(ModSaplingGenerators.RED_ASERIA, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.BRIGHT_RED)));
    public static final Block POTTED_RED_ASERIA_SAPLING = registerBlockWithoutBlockItem("potted_red_aseria_sapling",
            new FlowerPotBlock(RED_ASERIA_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.BRIGHT_RED)));

    public static final Block ORANGE_ASERIA_SAPLING = registerBlock("orange_aseria_sapling",
            new SaplingBlock(ModSaplingGenerators.ORANGE_ASERIA, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.ORANGE)));
    public static final Block POTTED_ORANGE_ASERIA_SAPLING = registerBlockWithoutBlockItem("potted_orange_aseria_sapling",
            new FlowerPotBlock(ORANGE_ASERIA_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.ORANGE)));

    public static final Block YELLOW_ASERIA_SAPLING = registerBlock("yellow_aseria_sapling",
            new SaplingBlock(ModSaplingGenerators.YELLOW_ASERIA, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.YELLOW)));
    public static final Block POTTED_YELLOW_ASERIA_SAPLING = registerBlockWithoutBlockItem("potted_yellow_aseria_sapling",
            new FlowerPotBlock(YELLOW_ASERIA_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.YELLOW)));

    public static final Block FALLEN_LEAVES = registerBlock("fallen_leaves",
            new FallenLeavesBlock(AbstractBlock.Settings.copy(Blocks.PINK_PETALS).mapColor(MapColor.ORANGE)));

    public static final Block ASERIA_SIGN = registerBlockWithoutBlockItem("aseria_sign",
            new ModStandingSignBlock(ModWoodTypes.ASERIA, AbstractBlock.Settings.copy(Blocks.OAK_SIGN)));
    public static final Block ASERIA_WALL_SIGN = registerBlockWithoutBlockItem("aseria_wall_sign",
            new ModWallSignBlock(ModWoodTypes.ASERIA, AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).dropsLike(ASERIA_SIGN)));
    public static final Block ASERIA_HANGING_SIGN = registerBlockWithoutBlockItem("aseria_hanging_sign",
            new ModHangingSignBlock(ModWoodTypes.ASERIA, AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)));
    public static final Block ASERIA_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("aseria_wall_hanging_sign",
            new ModWallHangingSignBlock(ModWoodTypes.ASERIA, AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(ASERIA_HANGING_SIGN)));

    public static final Block ASERIA_SYRUP_LOG = registerBlock("aseria_syrup_log",
            new SyrupLogBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block MARNOR_PLANKS = registerBlock("marnor_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_STAIRS = registerBlock("marnor_stairs",
            new StairsBlock(ModBlocks.ASERIA_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_SLAB = registerBlock("marnor_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_BUTTON = registerBlock("marnor_button",
            new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_PRESSURE_PLATE = registerBlock("marnor_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_FENCE = registerBlock("marnor_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_FENCE_GATE = registerBlock("marnor_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_DOOR = registerBlock("marnor_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_DOOR).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_TRAPDOOR = registerBlock("marnor_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_LOG = registerBlock("marnor_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_WOOD = registerBlock("marnor_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).mapColor(MapColor.PURPLE)));
    public static final Block STRIPPED_MARNOR_LOG = registerBlock("stripped_marnor_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).mapColor(MapColor.PURPLE)));
    public static final Block STRIPPED_MARNOR_WOOD = registerBlock("stripped_marnor_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).mapColor(MapColor.PURPLE)));

    public static final Block MARNOR_SIGN = registerBlockWithoutBlockItem("marnor_sign",
            new ModStandingSignBlock(ModWoodTypes.MARNOR, AbstractBlock.Settings.copy(DARK_OAK_SIGN).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_WALL_SIGN = registerBlockWithoutBlockItem("marnor_wall_sign",
            new ModWallSignBlock(ModWoodTypes.MARNOR, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WALL_SIGN).dropsLike(MARNOR_SIGN).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_HANGING_SIGN = registerBlockWithoutBlockItem("marnor_hanging_sign",
            new ModHangingSignBlock(ModWoodTypes.MARNOR, AbstractBlock.Settings.copy(Blocks.DARK_OAK_HANGING_SIGN).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_WALL_HANGING_SIGN = registerBlockWithoutBlockItem("marnor_wall_hanging_sign",
            new ModWallHangingSignBlock(ModWoodTypes.MARNOR, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WALL_HANGING_SIGN).dropsLike(MARNOR_HANGING_SIGN).mapColor(MapColor.PURPLE)));

    public static final Block MARNOR_LEAVES = registerBlock("marnor_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.PURPLE)));

    public static final Block MARNOR_SAPLING = registerBlock("marnor_sapling",
            new MarnorSaplingBlock(ModSaplingGenerators.MARNOR, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.PURPLE)));
    public static final Block POTTED_MARNOR_SAPLING = registerBlockWithoutBlockItem("potted_marnor_sapling",
            new FlowerPotBlock(MARNOR_SAPLING, AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING).mapColor(MapColor.PURPLE)));


    public static final Block INFESTED_MARNOR_LEAVES = registerBlock("infested_marnor_leaves",
            new InfestedLeafBlock(AbstractBlock.Settings.copy(OAK_LEAVES).mapColor(MapColor.PURPLE)));

    public static final Block MARNOR_VINES_PLANT = registerBlockWithoutBlockItem("marnor_vines_plant",
            new MarnorVinesPlantBlock(AbstractBlock.Settings.copy(WEEPING_VINES_PLANT).mapColor(MapColor.PURPLE)));
    public static final Block MARNOR_VINES = registerBlock("marnor_vines",
            new MarnorVinesBlock(AbstractBlock.Settings.copy(WEEPING_VINES).mapColor(MapColor.PURPLE)));

    public static final Block NOX_BERRY_BUSH = registerBlockWithoutBlockItem("nox_berry_bush",
            new NoxBerryBushBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).ticksRandomly().noCollision()
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.PURPLE)));

    public static final Block THORNY_COBBLESTONE = registerBlock("thorny_cobblestone",
            new Block(AbstractBlock.Settings.copy(MOSSY_COBBLESTONE).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block THORNY_COBBLESTONE_STAIRS = registerBlock("thorny_cobblestone_stairs",
            new StairsBlock(ModBlocks.ASERIA_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_STAIRS).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block THORNY_COBBLESTONE_SLAB = registerBlock("thorny_cobblestone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_SLAB).mapColor(MapColor.TERRACOTTA_PURPLE)));
    public static final Block THORNY_COBBLESTONE_WALL = registerBlock("thorny_cobblestone_wall",
            new WallBlock(AbstractBlock.Settings.copy(MOSSY_COBBLESTONE_WALL).mapColor(MapColor.TERRACOTTA_PURPLE)));


    public static final Block WARPED_PUMPKIN = registerBlock("warped_pumpkin",
            new WarpedPumpkinBlock(AbstractBlock.Settings.copy(PUMPKIN).mapColor(MapColor.CYAN).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block CARVED_WARPED_PUMPKIN = registerBlock("carved_warped_pumpkin",
            new WearableCarvedPumpkinBlock(AbstractBlock.Settings.copy(CARVED_PUMPKIN).mapColor(MapColor.CYAN).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block WARPED_JACK_O_LANTERN = registerBlock("warped_jack_o_lantern",
            new CarvedPumpkinBlock(AbstractBlock.Settings.copy(JACK_O_LANTERN).mapColor(MapColor.CYAN).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block WARPED_PUMPKIN_STEM = registerBlockWithoutBlockItem("warped_pumpkin_stem",
            (Block)new WarpedPumpkinStemBlock((WarpedGourdBlock) WARPED_PUMPKIN, () -> ModItems.WARPED_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.CYAN)
                            .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.STEM)
                            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ATTACHED_WARPED_PUMPKIN_STEM = registerBlockWithoutBlockItem("attached_warped_pumpkin_stem",
            (Block)new AttachedWarpedPumpkinStemBlock((WarpedGourdBlock) WARPED_PUMPKIN, () -> ModItems.WARPED_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.CYAN)
                            .noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD)
                            .pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block CRIMSON_PUMPKIN = registerBlock("crimson_pumpkin",
            new CrimsonPumpkinBlock(AbstractBlock.Settings.copy(PUMPKIN).mapColor(MapColor.DARK_RED).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block CARVED_CRIMSON_PUMPKIN = registerBlock("carved_crimson_pumpkin",
            new WearableCarvedPumpkinBlock(AbstractBlock.Settings.copy(CARVED_PUMPKIN).mapColor(MapColor.DARK_RED).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block CRIMSON_JACK_O_LANTERN = registerBlock("crimson_jack_o_lantern",
            new CarvedPumpkinBlock(AbstractBlock.Settings.copy(JACK_O_LANTERN).mapColor(MapColor.DARK_RED).sounds(BlockSoundGroup.NETHER_WOOD)));

    public static final Block CRIMSON_PUMPKIN_STEM = registerBlockWithoutBlockItem("crimson_pumpkin_stem",
            (Block)new CrimsonPumpkinStemBlock((CrimsonGourdBlock) CRIMSON_PUMPKIN, () -> ModItems.CRIMSON_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.BROWN)
                            .noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.STEM)
                            .pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ATTACHED_CRIMSON_PUMPKIN_STEM = registerBlockWithoutBlockItem("attached_crimson_pumpkin_stem",
            (Block)new AttachedCrimsonPumpkinStemBlock((CrimsonGourdBlock) CRIMSON_PUMPKIN, () -> ModItems.CRIMSON_PUMPKIN_SEEDS,
                    AbstractBlock.Settings.create().mapColor(MapColor.BROWN)
                            .noCollision().breakInstantly().sounds(BlockSoundGroup.WOOD)
                            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SAFFROOT_CROP = registerBlockWithoutBlockItem("saffroot_crop",
            new SaffrootCropBlock(AbstractBlock.Settings.copy(CARROTS)));

    public static final Block GAIZE_CROP = registerBlockWithoutBlockItem("gaize_crop",
            new GaizeCropBlock(AbstractBlock.Settings.copy(CARROTS)));

    public static final Block WILD_GAIZE_CROP = registerBlock("wild_gaize_crop",
            new TallFlowerBlock(AbstractBlock.Settings.copy(ROSE_BUSH).mapColor(MapColor.PURPLE)));

    public static final Block DARKROSE_BUSH = registerBlock("darkrose_bush",
            new DarkroseBushBlock(AbstractBlock.Settings.copy(ROSE_BUSH).mapColor(MapColor.BLACK)));
    public static final Block AMBERCUP_BUSH = registerBlock("ambercup_bush",
            new TallFlowerBlock(AbstractBlock.Settings.copy(ROSE_BUSH).mapColor(MapColor.ORANGE)));

    public static final Block ROTBUD = registerBlock("rotbud",
            new FlowerBlock(StatusEffects.POISON, 15, AbstractBlock.Settings.copy(LILY_OF_THE_VALLEY).mapColor(MapColor.LIME)));
    public static final Block POTTED_ROTBUD = registerBlock("potted_rotbud",
            new FlowerPotBlock(ModBlocks.ROTBUD, AbstractBlock.Settings.copy(POTTED_LILY_OF_THE_VALLEY).mapColor(MapColor.LIME)));

    public static final Block TWINFIRE_BLOOM = registerBlock("twinfire_bloom",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 15, AbstractBlock.Settings.copy(LILY_OF_THE_VALLEY).mapColor(MapColor.ORANGE)));
    public static final Block POTTED_TWINFIRE_BLOOM = registerBlock("potted_twinfire_bloom",
            new FlowerPotBlock(ModBlocks.TWINFIRE_BLOOM, AbstractBlock.Settings.copy(POTTED_LILY_OF_THE_VALLEY).mapColor(MapColor.ORANGE)));


    public static final Block SPOOKY_TORCH = registerBlockWithoutBlockItem("spooky_torch",
            new TorchBlock(ModParticles.SPOOKY_FIRE_FLAME, AbstractBlock.Settings.copy(TORCH)));
    public static final Block WALL_SPOOKY_TORCH = registerBlockWithoutBlockItem("wall_spooky_torch",
            new WallTorchBlock(ModParticles.SPOOKY_FIRE_FLAME, AbstractBlock.Settings.copy(WALL_TORCH)));

    public static final Block SPOOKY_LANTERN = registerBlock("spooky_lantern",
            new LanternBlock(AbstractBlock.Settings.copy(LANTERN)));
    public static final Block SPOOKY_CAMPFIRE = registerBlock("spooky_campfire",
            new ModCampfireBlock(false, 1, AbstractBlock.Settings.copy(SOUL_CAMPFIRE)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FrightsAndFoliage.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(FrightsAndFoliage.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(FrightsAndFoliage.MOD_ID, name), block);
    }
    public static void registerModBlocks() {
        FrightsAndFoliage.LOGGER.info("Registering ModBlocks for " + FrightsAndFoliage.MOD_ID);
    }
}
