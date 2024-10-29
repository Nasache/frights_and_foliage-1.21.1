package net.nathan.frights_and_foliage.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.world.ModPlacedFeatures;

public class ModBiomeFeatures {

    public static void addAutumnalVegetation(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_TALL_GRASS);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RED_ASERIA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_ASERIA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YELLOW_ASERIA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FALLEN_LEAVES_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_ROCK_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_PUMPKIN_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_FLOWER_PLACED_KEY);
    }

    public static void addAutumnalAnimals(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SHEEP, 6, 2, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 8, 2, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.COW, 4, 2, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.FUMKIN, 16, 3, 5));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.VIRE, 8, 1, 4));
    }

    public static void addVioletVegetation(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MARNOR_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_TALL_GRASS_VIOLET);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_GAIZE_CROP_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DARKROSE_BUSH_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ROTBUD_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.NOX_BERRY_BUSH_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.VIOLET_ROCK_PLACED_KEY);
    }

    public static void addVioletAnimals(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.VIRE, 8, 1, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.STALK, 20, 1, 1));

    }

    public static void addVioletHostiles(SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntities.STALK, 100, 1, 1));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 10, 1, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 5, 1, 3));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 6, 1, 4));
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 6, 1, 4));
    }
}