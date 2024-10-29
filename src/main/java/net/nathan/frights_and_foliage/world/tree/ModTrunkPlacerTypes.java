package net.nathan.frights_and_foliage.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.mixin.TrunkPlacerTypeInvoker;
import net.nathan.frights_and_foliage.world.tree.custom.AseriaTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> ASERIA_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("aseria_trunk_placer",
            AseriaTrunkPlacer.CODEC);

    public static void register() {
        FrightsAndFoliage.LOGGER.info("Registering Trunk Placer for " + FrightsAndFoliage.MOD_ID);
    }
}
