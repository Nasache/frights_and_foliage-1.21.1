package net.nathan.frights_and_foliage.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;

public class ModBoats {
    public static final Identifier ASERIA_BOAT_ID = Identifier.of(FrightsAndFoliage.MOD_ID, "aseria_boat");
    public static final Identifier ASERIA_CHEST_BOAT_ID = Identifier.of(FrightsAndFoliage.MOD_ID, "aseria_chest_boat");

    public static final Identifier MARNOR_BOAT_ID = Identifier.of(FrightsAndFoliage.MOD_ID, "marnor_boat");
    public static final Identifier MARNOR_CHEST_BOAT_ID = Identifier.of(FrightsAndFoliage.MOD_ID, "marnor_chest_boat");

    public static final RegistryKey<TerraformBoatType> ASERIA_BOAT_KEY = TerraformBoatTypeRegistry.createKey(ASERIA_BOAT_ID);
    public static final RegistryKey<TerraformBoatType> MARNOR_BOAT_KEY = TerraformBoatTypeRegistry.createKey(MARNOR_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType aseriaBoat = new TerraformBoatType.Builder()
                .item(ModItems.ASERIA_BOAT)
                .chestItem(ModItems.ASERIA_CHEST_BOAT)
                .planks(ModBlocks.ASERIA_PLANKS.asItem())
                .build();

        TerraformBoatType marnorBoat = new TerraformBoatType.Builder()
                .item(ModItems.MARNOR_BOAT)
                .chestItem(ModItems.MARNOR_CHEST_BOAT)
                .planks(ModBlocks.MARNOR_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, ASERIA_BOAT_KEY, aseriaBoat);
        Registry.register(TerraformBoatTypeRegistry.INSTANCE, MARNOR_BOAT_KEY, marnorBoat);
    }
}