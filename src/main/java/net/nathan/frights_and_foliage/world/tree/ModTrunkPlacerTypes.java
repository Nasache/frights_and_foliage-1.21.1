package net.nathan.frights_and_foliage.world.tree;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.world.tree.custom.AseriaTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<AseriaTrunkPlacer> ASERIA_TRUNK_PLACER =
            Registry.register(Registries.TRUNK_PLACER_TYPE,
                    Identifier.of(FrightsAndFoliage.MOD_ID, "aseria_trunk_placer"),
                    new TrunkPlacerType<>(AseriaTrunkPlacer.CODEC));

    public static void register() {
        FrightsAndFoliage.LOGGER.info("Registering Trunk Placer for " + FrightsAndFoliage.MOD_ID);
    }
}
