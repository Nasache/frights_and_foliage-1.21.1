package net.nathan.frights_and_foliage.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.blocks.custom.NoxBerryBushBlock;
import net.nathan.frights_and_foliage.world.tree.custom.AseriaFoliagePlacer;
import net.nathan.frights_and_foliage.world.tree.custom.AseriaTrunkPlacer;
import net.nathan.frights_and_foliage.world.tree.custom.MarnorFoliagePlacer;

import java.util.Iterator;
import java.util.List;

import static net.minecraft.world.gen.feature.ConfiguredFeatures.createRandomPatchFeatureConfig;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_ASERIA_KEY = registerKey("red_aseria");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_ASERIA_KEY = registerKey("orange_aseria");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_ASERIA_KEY = registerKey("yellow_aseria");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MARNOR_KEY = registerKey("marnor");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_LEAVES_KEY = registerKey("fallen_leaves");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_ROCK_KEY = registerKey("autumn_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_PUMPKIN_KEY = registerKey("autumn_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_FLOWER_KEY = registerKey("autumn_flower");

    public static final RegistryKey<ConfiguredFeature<?, ?>> NOX_BERRY_BUSH_KEY = registerKey("nox_berry_bush_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILD_GAIZE_KEY = registerKey("wild_gaize_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DARKROSE_BUSH_KEY = registerKey("darkrose_bush_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMBERCUP_BUSH_KEY = registerKey("ambercup_bush_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROTBUD_KEY = registerKey("rotbud_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TWINFIRE_BLOOM_KEY = registerKey("twinfire_bloom_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_GRASS_KEY = registerKey("tall_grass_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIOLET_ROCK_KEY = registerKey("violet_rock");


    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_CRIMSON_PUMPKIN_KEY = registerKey("crimson_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WARPED_PUMPKIN_KEY = registerKey("warped_pumpkin");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, RED_ASERIA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASERIA_LOG),
                new AseriaTrunkPlacer(6, 2, 3),
                BlockStateProvider.of(ModBlocks.RED_ASERIA_LEAVES),
                new AseriaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, ORANGE_ASERIA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASERIA_LOG),
                new AseriaTrunkPlacer(6, 2, 3),
                BlockStateProvider.of(ModBlocks.ORANGE_ASERIA_LEAVES),
                new AseriaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, YELLOW_ASERIA_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ASERIA_LOG),
                new AseriaTrunkPlacer(6, 2, 3),
                BlockStateProvider.of(ModBlocks.YELLOW_ASERIA_LEAVES),
                new AseriaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, MARNOR_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MARNOR_LOG),
                new CherryTrunkPlacer(4, 1, 2,
                        ConstantIntProvider.create(2), ConstantIntProvider.create(3), UniformIntProvider.create(-3, 0), ConstantIntProvider.create(2)),
                new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                        .add(ModBlocks.MARNOR_LEAVES.getDefaultState(), 60)
                        .add(ModBlocks.INFESTED_MARNOR_LEAVES.getDefaultState(), 1)),
                new MarnorFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5),
                        0.25F, 0.5F, 0.4F, 0.5F),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        DataPool.Builder<BlockState> builder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator var35 = Direction.Type.HORIZONTAL.iterator();

            while(var35.hasNext()) {
                Direction direction = (Direction)var35.next();
                builder.add((BlockState)((BlockState) ModBlocks.FALLEN_LEAVES.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, i))
                        .with(FlowerbedBlock.FACING, direction), 1);
            }
        }
        ConfiguredFeatures.register(context, FALLEN_LEAVES_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder)))));

        ConfiguredFeatures.register(context, AUTUMN_ROCK_KEY, Feature.FOREST_ROCK, new SingleStateFeatureConfig(Blocks.MOSSY_COBBLESTONE.getDefaultState()));
        ConfiguredFeatures.register(context, VIOLET_ROCK_KEY, Feature.FOREST_ROCK, new SingleStateFeatureConfig(ModBlocks.THORNY_COBBLESTONE.getDefaultState()));

        ConfiguredFeatures.register(context, AUTUMN_PUMPKIN_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.PUMPKIN)), List.of(Blocks.GRASS_BLOCK)));

        ConfiguredFeatures.register(context, AUTUMN_FLOWER_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(96, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new NoiseBlockStateProvider(2345L,
                                new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0, new double[0]), 0.020833334F,
                                List.of(Blocks.DANDELION.getDefaultState(),
                                        Blocks.POPPY.getDefaultState(),
                                        Blocks.RED_TULIP.getDefaultState(),
                                        Blocks.ORANGE_TULIP.getDefaultState()))))));

        ConfiguredFeatures.register(context, NOX_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (BlockStateProvider.of((BlockState) ModBlocks.NOX_BERRY_BUSH.getDefaultState()
                                .with(NoxBerryBushBlock.AGE, 3))), List.of(Blocks.GRASS_BLOCK)));

        ConfiguredFeatures.register(context, WILD_GAIZE_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (BlockStateProvider.of((BlockState) ModBlocks.WILD_GAIZE_CROP.getDefaultState())), List.of(Blocks.GRASS_BLOCK)));

        ConfiguredFeatures.register(context, DARKROSE_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (BlockStateProvider.of((BlockState) ModBlocks.DARKROSE_BUSH.getDefaultState())), List.of(Blocks.GRASS_BLOCK)));
        ConfiguredFeatures.register(context, AMBERCUP_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (BlockStateProvider.of((BlockState) ModBlocks.AMBERCUP_BUSH.getDefaultState())), List.of(Blocks.GRASS_BLOCK)));
        ConfiguredFeatures.register(context, ROTBUD_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (BlockStateProvider.of((BlockState) ModBlocks.ROTBUD.getDefaultState())), List.of(Blocks.GRASS_BLOCK)));
        ConfiguredFeatures.register(context, TWINFIRE_BLOOM_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig
                        (BlockStateProvider.of((BlockState) ModBlocks.TWINFIRE_BLOOM.getDefaultState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, TALL_GRASS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 10, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.TALL_GRASS)))));

        ConfiguredFeatures.register(context, PATCH_CRIMSON_PUMPKIN_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(48, 6, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CRIMSON_PUMPKIN)),
                        BlockPredicate.allOf(BlockPredicate.replaceable(),
                                BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.CRIMSON_NYLIUM, Blocks.NETHERRACK)))));

        ConfiguredFeatures.register(context, PATCH_WARPED_PUMPKIN_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(48, 6, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WARPED_PUMPKIN)),
                        BlockPredicate.allOf(BlockPredicate.replaceable(),
                                BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.WARPED_NYLIUM, Blocks.NETHERRACK)))));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(FrightsAndFoliage.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}