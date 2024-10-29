package net.nathan.frights_and_foliage.world.biome;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModBiomes {
    public static final RegistryKey<Biome> AUTUMNAL_FOREST = register("autumnal_forest");
    public static final RegistryKey<Biome> VIOLET_BRAMBLE = register("violet_bramble");

    public static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(FrightsAndFoliage.MOD_ID, name));
    }

    public static void bootstrap(Registerable<Biome> context) {
        context.register(AUTUMNAL_FOREST, autumnalForest(context));
        context.register(VIOLET_BRAMBLE, violetBramble(context));

    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static Biome autumnalForest(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        ModBiomeFeatures.addAutumnalAnimals(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        ModBiomeFeatures.addAutumnalVegetation(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);
        DefaultBiomeFeatures.addDefaultVegetation(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .grassColor(0xa8852c)
                        .fogColor(0xc9c2be)
                        .waterColor(0x2a88d0)
                        .waterFogColor(0xa7c6e7)
                        .foliageColor(0xff7f50)
                        .skyColor(0x97c8f5).build())
                .build();
    }

    public static Biome violetBramble(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        ModBiomeFeatures.addVioletAnimals(spawnBuilder);
        ModBiomeFeatures.addVioletHostiles(spawnBuilder);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnBuilder);

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        ModBiomeFeatures.addVioletVegetation(biomeBuilder);

        DefaultBiomeFeatures.addDefaultMushrooms(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.2f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .grassColor(0x3f3b4e)
                        .fogColor(0x27272a)
                        .waterColor(0x203955)
                        .waterFogColor(0x241f35)
                        .foliageColor(0x19191f)
                        .skyColor(0x494651).build())
                .build();
    }

}