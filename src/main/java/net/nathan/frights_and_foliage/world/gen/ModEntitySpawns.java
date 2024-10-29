package net.nathan.frights_and_foliage.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.world.biome.ModBiomes;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.DARK_FOREST),
                SpawnGroup.CREATURE, ModEntities.VIRE, 10, 2, 4);

        SpawnRestriction.register(ModEntities.VIRE, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING, AnimalEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST,
                        BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.DARK_FOREST,
                        BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.TAIGA),
                SpawnGroup.CREATURE, ModEntities.FUMKIN, 12, 2, 5);

        SpawnRestriction.register(ModEntities.FUMKIN, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.VIOLET_BRAMBLE),
                SpawnGroup.MONSTER, ModEntities.STALK, 150, 1, 1);

        SpawnRestriction.register(ModEntities.STALK, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING, MobEntity::canMobSpawn);
    }
}
