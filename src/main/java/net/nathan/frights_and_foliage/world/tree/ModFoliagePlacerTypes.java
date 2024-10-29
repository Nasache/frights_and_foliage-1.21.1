package net.nathan.frights_and_foliage.world.tree;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.world.tree.custom.AseriaFoliagePlacer;
import net.nathan.frights_and_foliage.world.tree.custom.MarnorFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<AseriaFoliagePlacer> ASERIA_FOLIAGE_PLACER =
            Registry.register(Registries.FOLIAGE_PLACER_TYPE,
                    Identifier.of(FrightsAndFoliage.MOD_ID, "aseria_foliage_placer"),
                    new FoliagePlacerType<>(AseriaFoliagePlacer.CODEC));

    public static final FoliagePlacerType<MarnorFoliagePlacer> MARNOR_FOLIAGE_PLACER =
            Registry.register(Registries.FOLIAGE_PLACER_TYPE,
                    Identifier.of(FrightsAndFoliage.MOD_ID, "marnor_foliage_placer"),
                    new FoliagePlacerType<>(MarnorFoliagePlacer.CODEC));



    public static void register() {
        FrightsAndFoliage.LOGGER.info("Registering the Foliage Placers for " + FrightsAndFoliage.MOD_ID);
    }
}