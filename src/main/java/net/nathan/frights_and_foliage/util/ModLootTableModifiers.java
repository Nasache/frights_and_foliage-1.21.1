package net.nathan.frights_and_foliage.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.item.ModItems;

public class ModLootTableModifiers {

    private static final Identifier PLAINS_VILLAGE_CHEST_ID
            = Identifier.of("minecraft", "chests/village/village_plains_house");
    private static final Identifier TAIGA_VILLAGE_CHEST_ID
            = Identifier.of("minecraft", "chests/village/village_taiga_house");
    private static final Identifier SNOW_VILLAGE_CHEST_ID
            = Identifier.of("minecraft", "chests/village/village_snowy_house");



    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {

            if(PLAINS_VILLAGE_CHEST_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(0.5f))
                        .with(ItemEntry.builder(ModItems.SAFFROOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(TAIGA_VILLAGE_CHEST_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(0.5f))
                        .with(ItemEntry.builder(ModItems.SAFFROOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }

            if(SNOW_VILLAGE_CHEST_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(0.5f))
                        .with(ItemEntry.builder(ModItems.SAFFROOT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
