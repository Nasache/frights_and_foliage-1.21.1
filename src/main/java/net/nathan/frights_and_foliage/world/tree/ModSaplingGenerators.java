package net.nathan.frights_and_foliage.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.world.ModConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator MARNOR = new SaplingGenerator(FrightsAndFoliage.MOD_ID + "marnor",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MARNOR_KEY), Optional.empty());

    public static final SaplingGenerator RED_ASERIA = new SaplingGenerator(FrightsAndFoliage.MOD_ID + "red_aseria",
            Optional.empty(), Optional.of(ModConfiguredFeatures.RED_ASERIA_KEY), Optional.empty());
    public static final SaplingGenerator ORANGE_ASERIA = new SaplingGenerator(FrightsAndFoliage.MOD_ID + "orange_aseria",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ORANGE_ASERIA_KEY), Optional.empty());
    public static final SaplingGenerator YELLOW_ASERIA = new SaplingGenerator(FrightsAndFoliage.MOD_ID + "yellow_aseria",
            Optional.empty(), Optional.of(ModConfiguredFeatures.YELLOW_ASERIA_KEY), Optional.empty());
}