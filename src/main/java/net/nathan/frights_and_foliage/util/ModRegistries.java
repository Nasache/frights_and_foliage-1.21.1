package net.nathan.frights_and_foliage.util;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.entity.custom.FumkinEntity;
import net.nathan.frights_and_foliage.entity.custom.LephidEntity;
import net.nathan.frights_and_foliage.entity.custom.StalkEntity;
import net.nathan.frights_and_foliage.entity.custom.VireEntity;
import net.nathan.frights_and_foliage.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerModCompostables();
        registerStrippables();
        registerFlammables();
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.STALK, StalkEntity.createStalkAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.LEPHID, LephidEntity.createLephidAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.FUMKIN, FumkinEntity.createFumkinAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.VIRE, VireEntity.createVireAttributes());
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModBlocks.ASERIA_PLANKS, 300);
        registry.add(ModBlocks.ASERIA_LOG, 300);
        registry.add(ModBlocks.ASERIA_SYRUP_LOG, 300);
        registry.add(ModBlocks.STRIPPED_ASERIA_LOG, 300);
        registry.add(ModBlocks.ASERIA_WOOD, 300);
        registry.add(ModBlocks.STRIPPED_ASERIA_WOOD, 300);
        registry.add(ModBlocks.ASERIA_STAIRS, 300);
        registry.add(ModBlocks.ASERIA_SLAB, 150);
        registry.add(ModBlocks.ASERIA_BUTTON, 100);
        registry.add(ModBlocks.ASERIA_PRESSURE_PLATE, 300);
        registry.add(ModBlocks.ASERIA_FENCE, 300);
        registry.add(ModBlocks.ASERIA_FENCE_GATE, 300);
        registry.add(ModBlocks.ASERIA_DOOR, 200);
        registry.add(ModBlocks.ASERIA_TRAPDOOR, 300);
        registry.add(ModItems.ASERIA_BOAT, 1200);
        registry.add(ModItems.ASERIA_CHEST_BOAT, 1200);
        registry.add(ModItems.ASERIA_SIGN, 200);
        registry.add(ModItems.ASERIA_HANGING_SIGN, 800);
        registry.add(ModBlocks.RED_ASERIA_SAPLING, 100);
        registry.add(ModBlocks.ORANGE_ASERIA_SAPLING, 100);
        registry.add(ModBlocks.YELLOW_ASERIA_SAPLING, 100);

        registry.add(ModBlocks.MARNOR_PLANKS, 300);
        registry.add(ModBlocks.MARNOR_LOG, 300);
        registry.add(ModBlocks.STRIPPED_MARNOR_LOG, 300);
        registry.add(ModBlocks.MARNOR_WOOD, 300);
        registry.add(ModBlocks.STRIPPED_MARNOR_WOOD, 300);
        registry.add(ModBlocks.MARNOR_STAIRS, 300);
        registry.add(ModBlocks.MARNOR_SLAB, 150);
        registry.add(ModBlocks.MARNOR_BUTTON, 100);
        registry.add(ModBlocks.MARNOR_PRESSURE_PLATE, 300);
        registry.add(ModBlocks.MARNOR_FENCE, 300);
        registry.add(ModBlocks.MARNOR_FENCE_GATE, 300);
        registry.add(ModBlocks.MARNOR_DOOR, 200);
        registry.add(ModBlocks.MARNOR_TRAPDOOR, 300);
        registry.add(ModItems.MARNOR_BOAT, 1200);
        registry.add(ModItems.MARNOR_CHEST_BOAT, 1200);
        registry.add(ModItems.MARNOR_SIGN, 200);
        registry.add(ModItems.MARNOR_HANGING_SIGN, 800);
        registry.add(ModBlocks.MARNOR_SAPLING, 100);
    }

    private static void registerModCompostables () {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.RED_ASERIA_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_ASERIA_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.YELLOW_ASERIA_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.RED_ASERIA_LEAVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_ASERIA_LEAVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.YELLOW_ASERIA_LEAVES, 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.MARNOR_LEAVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.INFESTED_MARNOR_LEAVES, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.MARNOR_SAPLING, 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.DARKROSE_BUSH, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.AMBERCUP_BUSH, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.TWINFIRE_BLOOM, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ROTBUD, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WILD_GAIZE_CROP, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.MARNOR_VINES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.MARNOR_VINES_PLANT, 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CRIMSON_PUMPKIN_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.CRIMSON_PUMPKIN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.CARVED_CRIMSON_PUMPKIN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CRIMSON_PUMPKIN_PIE, 1f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.WARPED_PUMPKIN_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WARPED_PUMPKIN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.CARVED_WARPED_PUMPKIN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.WARPED_PUMPKIN_PIE, 1f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.FUMKIN_ANTLER, 0.8f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.SAFFROOT, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STUFFED_PUMPKIN, 1f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GAIZE, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GAIZE_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.NOX_BERRIES, 0.3f);
    }

    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ASERIA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ASERIA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_ASERIA_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORANGE_ASERIA_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.YELLOW_ASERIA_LEAVES, 30, 60);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MARNOR_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MARNOR_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.INFESTED_MARNOR_LEAVES, 30, 60);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.ASERIA_LOG, ModBlocks.STRIPPED_ASERIA_LOG);
        StrippableBlockRegistry.register(ModBlocks.ASERIA_SYRUP_LOG, ModBlocks.STRIPPED_ASERIA_LOG);
        StrippableBlockRegistry.register(ModBlocks.ASERIA_WOOD, ModBlocks.STRIPPED_ASERIA_WOOD);

        StrippableBlockRegistry.register(ModBlocks.MARNOR_LOG, ModBlocks.STRIPPED_MARNOR_LOG);
        StrippableBlockRegistry.register(ModBlocks.MARNOR_WOOD, ModBlocks.STRIPPED_MARNOR_WOOD);
    }
}
