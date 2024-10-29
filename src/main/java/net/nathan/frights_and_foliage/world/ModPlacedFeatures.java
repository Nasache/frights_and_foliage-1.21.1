package net.nathan.frights_and_foliage.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> RED_ASERIA_PLACED_KEY = registerKey("red_aseria_placed");
    public static final RegistryKey<PlacedFeature> ORANGE_ASERIA_PLACED_KEY = registerKey("orange_aseria_placed");
    public static final RegistryKey<PlacedFeature> YELLOW_ASERIA_PLACED_KEY = registerKey("yellow_aseria_placed");
    public static final RegistryKey<PlacedFeature> MARNOR_PLACED_KEY = registerKey("marnor_placed");
    public static final RegistryKey<PlacedFeature> FALLEN_LEAVES_PLACED_KEY = registerKey("fallen_leaves_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_ROCK_PLACED_KEY = registerKey("autumn_rock_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_PUMPKIN_PLACED_KEY = registerKey("autumn_pumpkin_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_FLOWER_PLACED_KEY = registerKey("autumn_flower_placed");

    public static final RegistryKey<PlacedFeature> NOX_BERRY_BUSH_PLACED_KEY = registerKey("nox_berry_placed");
    public static final RegistryKey<PlacedFeature> WILD_GAIZE_CROP_PLACED_KEY = registerKey("wild_gaize_placed");
    public static final RegistryKey<PlacedFeature> DARKROSE_BUSH_PLACED_KEY = registerKey("darkrose_placed");
    public static final RegistryKey<PlacedFeature> AMBERCUP_BUSH_PLACED_KEY = registerKey("ambercup_placed");
    public static final RegistryKey<PlacedFeature> ROTBUD_PLACED_KEY = registerKey("rotbud_placed");
    public static final RegistryKey<PlacedFeature> TWINFIRE_BLOOM_PLACED_KEY = registerKey("twinfire_placed");
    public static final RegistryKey<PlacedFeature> PATCH_TALL_GRASS_VIOLET = registerKey("tall_grass_placed");
    public static final RegistryKey<PlacedFeature> VIOLET_ROCK_PLACED_KEY = registerKey("violet_rock_placed");

    public static final RegistryKey<PlacedFeature> PATCH_CRIMSON_PUMPKIN_PLACED_KEY = registerKey("patch_crimson_placed");
    public static final RegistryKey<PlacedFeature> PATCH_WARPED_PUMPKIN_PLACED_KEY = registerKey("patch_warped_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, RED_ASERIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_ASERIA_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), ModBlocks.RED_ASERIA_SAPLING));
        register(context, ORANGE_ASERIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_ASERIA_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), ModBlocks.ORANGE_ASERIA_SAPLING));
        register(context, YELLOW_ASERIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_ASERIA_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), ModBlocks.YELLOW_ASERIA_SAPLING));

        register(context, MARNOR_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MARNOR_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(12, 0.5f, 4), ModBlocks.MARNOR_SAPLING));

        PlacedFeatures.register(context, FALLEN_LEAVES_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FALLEN_LEAVES_KEY),
                new PlacementModifier[]{NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10),
                        SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, AUTUMN_ROCK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AUTUMN_ROCK_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, VIOLET_ROCK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIOLET_ROCK_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, AUTUMN_PUMPKIN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AUTUMN_PUMPKIN_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, AUTUMN_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AUTUMN_FLOWER_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(2), RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        register(context, NOX_BERRY_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NOX_BERRY_BUSH_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(10), SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()});

        register(context, DARKROSE_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DARKROSE_BUSH_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()});
        register(context, AMBERCUP_BUSH_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AMBERCUP_BUSH_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()});
        register(context, ROTBUD_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ROTBUD_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(10), SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()});
        register(context, TWINFIRE_BLOOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TWINFIRE_BLOOM_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()});

        register(context, WILD_GAIZE_CROP_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WILD_GAIZE_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(40), SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, PATCH_TALL_GRASS_VIOLET, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TALL_GRASS_KEY),
                NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10), SquarePlacementModifier.of(),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PATCH_CRIMSON_PUMPKIN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PATCH_CRIMSON_PUMPKIN_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(8), SquarePlacementModifier.of(),
                        PlacedFeatures.BOTTOM_TO_TOP_RANGE, EnvironmentScanPlacementModifier.of(Direction.DOWN,
                        BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
                        RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1)), BiomePlacementModifier.of()});
        register(context, PATCH_WARPED_PUMPKIN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PATCH_WARPED_PUMPKIN_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(8), SquarePlacementModifier.of(),
                        PlacedFeatures.BOTTOM_TO_TOP_RANGE, EnvironmentScanPlacementModifier.of(Direction.DOWN,
                        BlockPredicate.solid(), BlockPredicate.IS_AIR, 12),
                        RandomOffsetPlacementModifier.vertically(ConstantIntProvider.create(1)), BiomePlacementModifier.of()});

    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(FrightsAndFoliage.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}