package net.nathan.frights_and_foliage.world.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.mixin.FoliagePlacerTypeInvoker;
import net.nathan.frights_and_foliage.world.tree.custom.AseriaFoliagePlacer;
import net.nathan.frights_and_foliage.world.tree.custom.MarnorFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> ASERIA_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister(
            "aseria_foliage_placer", AseriaFoliagePlacer.CODEC);

    public static final FoliagePlacerType<?> MARNOR_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister(
            "marnor_foliage_placer", MarnorFoliagePlacer.CODEC);

    public static void register() {
        FrightsAndFoliage.LOGGER.info("Registering the Foliage Placers for " + FrightsAndFoliage.MOD_ID);
    }
}