package net.nathan.frights_and_foliage.world.tree;

import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.nathan.frights_and_foliage.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class OrangeAseriaSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.ORANGE_ASERIA_KEY;
    }
}