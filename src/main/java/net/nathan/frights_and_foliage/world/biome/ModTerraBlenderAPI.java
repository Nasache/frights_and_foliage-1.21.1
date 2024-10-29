package net.nathan.frights_and_foliage.world.biome;

import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(FrightsAndFoliage.MOD_ID, "overworld"), 2));
    }
}
