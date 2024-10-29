package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.blocks.custom.GaizeCropBlock;
import net.nathan.frights_and_foliage.blocks.custom.NoxBerryBushBlock;
import net.nathan.frights_and_foliage.blocks.custom.SaffrootCropBlock;
import net.nathan.frights_and_foliage.item.ModItems;

import java.util.concurrent.CompletableFuture;


public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
    @Override
    public void generate() {
        addDrop(ModBlocks.ASERIA_PLANKS);
        addDrop(ModBlocks.ASERIA_LOG);
        addDrop(ModBlocks.ASERIA_WOOD);
        addDrop(ModBlocks.STRIPPED_ASERIA_LOG);
        addDrop(ModBlocks.STRIPPED_ASERIA_WOOD);
        addDrop(ModBlocks.RED_ASERIA_LEAVES, leavesDrops(ModBlocks.RED_ASERIA_LEAVES, ModBlocks.RED_ASERIA_SAPLING, .05f));
        addDrop(ModBlocks.ORANGE_ASERIA_LEAVES, leavesDrops(ModBlocks.ORANGE_ASERIA_LEAVES, ModBlocks.ORANGE_ASERIA_SAPLING, .05f));
        addDrop(ModBlocks.YELLOW_ASERIA_LEAVES, leavesDrops(ModBlocks.YELLOW_ASERIA_LEAVES, ModBlocks.YELLOW_ASERIA_SAPLING, .05f));
        addDrop(ModBlocks.ASERIA_STAIRS);
        addDrop(ModBlocks.ASERIA_SLAB, slabDrops(ModBlocks.ASERIA_SLAB));
        addDrop(ModBlocks.ASERIA_BUTTON);
        addDrop(ModBlocks.ASERIA_PRESSURE_PLATE);
        addDrop(ModBlocks.ASERIA_FENCE);
        addDrop(ModBlocks.ASERIA_FENCE_GATE);
        addDrop(ModBlocks.ASERIA_DOOR, doorDrops(ModBlocks.ASERIA_DOOR));
        addDrop(ModBlocks.ASERIA_TRAPDOOR);
        addDrop(ModBlocks.ASERIA_SIGN);
        addDrop(ModBlocks.ASERIA_WALL_SIGN);
        addDrop(ModBlocks.ASERIA_HANGING_SIGN);
        addDrop(ModBlocks.ASERIA_WALL_HANGING_SIGN);
        addDrop(ModBlocks.RED_ASERIA_SAPLING);
        addDrop(ModBlocks.POTTED_RED_ASERIA_SAPLING, pottedPlantDrops(ModBlocks.RED_ASERIA_SAPLING));
        addDrop(ModBlocks.ORANGE_ASERIA_SAPLING);
        addDrop(ModBlocks.POTTED_ORANGE_ASERIA_SAPLING, pottedPlantDrops(ModBlocks.ORANGE_ASERIA_SAPLING));
        addDrop(ModBlocks.YELLOW_ASERIA_SAPLING);
        addDrop(ModBlocks.POTTED_YELLOW_ASERIA_SAPLING, pottedPlantDrops(ModBlocks.YELLOW_ASERIA_SAPLING));

        addDrop(ModBlocks.FALLEN_LEAVES, flowerbedDrops(ModBlocks.FALLEN_LEAVES));

        addDrop(ModBlocks.ASERIA_SYRUP_LOG, drops(ModBlocks.ASERIA_SYRUP_LOG, ModBlocks.ASERIA_LOG));

        addDrop(ModBlocks.MARNOR_PLANKS);
        addDrop(ModBlocks.MARNOR_LOG);
        addDrop(ModBlocks.MARNOR_WOOD);
        addDrop(ModBlocks.STRIPPED_MARNOR_LOG);
        addDrop(ModBlocks.STRIPPED_MARNOR_WOOD);
        addDrop(ModBlocks.MARNOR_LEAVES, leavesDrops(ModBlocks.MARNOR_LEAVES, ModBlocks.MARNOR_SAPLING, .05f));
        addDrop(ModBlocks.INFESTED_MARNOR_LEAVES, leavesDrops(ModBlocks.MARNOR_LEAVES, ModBlocks.MARNOR_SAPLING, .05f));
        addDrop(ModBlocks.MARNOR_STAIRS);
        addDrop(ModBlocks.MARNOR_SLAB, slabDrops(ModBlocks.MARNOR_SLAB));
        addDrop(ModBlocks.MARNOR_BUTTON);
        addDrop(ModBlocks.MARNOR_PRESSURE_PLATE);
        addDrop(ModBlocks.MARNOR_FENCE);
        addDrop(ModBlocks.MARNOR_FENCE_GATE);
        addDrop(ModBlocks.MARNOR_DOOR, doorDrops(ModBlocks.MARNOR_DOOR));
        addDrop(ModBlocks.MARNOR_TRAPDOOR);
        addDrop(ModBlocks.MARNOR_SIGN);
        addDrop(ModBlocks.MARNOR_WALL_SIGN);
        addDrop(ModBlocks.MARNOR_HANGING_SIGN);
        addDrop(ModBlocks.MARNOR_WALL_HANGING_SIGN);
        addDrop(ModBlocks.MARNOR_SAPLING);
        addDrop(ModBlocks.POTTED_MARNOR_SAPLING, pottedPlantDrops(ModBlocks.MARNOR_SAPLING));

        addDrop(ModBlocks.MARNOR_VINES);
        addDrop(ModBlocks.MARNOR_VINES_PLANT, drops(ModBlocks.MARNOR_VINES));

        LootCondition.Builder builder1 = BlockStatePropertyLootCondition.builder(ModBlocks.NOX_BERRY_BUSH)
                .properties(StatePredicate.Builder.create().exactMatch(NoxBerryBushBlock.AGE, 3));
        this.addDrop(ModBlocks.NOX_BERRY_BUSH, this.cropDrops(ModBlocks.NOX_BERRY_BUSH, ModItems.NOX_BERRIES, Items.AIR, builder1));

        LootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.SAFFROOT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(SaffrootCropBlock.AGE, 3));
        this.addDrop(ModBlocks.SAFFROOT_CROP, this.cropDrops(ModBlocks.SAFFROOT_CROP, ModItems.SAFFROOT, ModItems.SAFFROOT, builder2));

        LootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.GAIZE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GaizeCropBlock.AGE, 3));
        this.addDrop(ModBlocks.GAIZE_CROP, this.cropDrops(ModBlocks.GAIZE_CROP, ModItems.GAIZE, ModItems.GAIZE_SEEDS, builder3));

        addDrop(ModBlocks.WARPED_PUMPKIN_STEM, attachedCropStemDrops(ModBlocks.WARPED_PUMPKIN_STEM,
                ModItems.WARPED_PUMPKIN_SEEDS));
        addDrop(ModBlocks.ATTACHED_WARPED_PUMPKIN_STEM, attachedCropStemDrops(ModBlocks.ATTACHED_WARPED_PUMPKIN_STEM,
                ModItems.WARPED_PUMPKIN_SEEDS));
        addDrop(ModBlocks.CRIMSON_PUMPKIN_STEM, attachedCropStemDrops(ModBlocks.CRIMSON_PUMPKIN_STEM,
                ModItems.CRIMSON_PUMPKIN_SEEDS));
        addDrop(ModBlocks.ATTACHED_CRIMSON_PUMPKIN_STEM, attachedCropStemDrops(ModBlocks.ATTACHED_CRIMSON_PUMPKIN_STEM,
                ModItems.CRIMSON_PUMPKIN_SEEDS));
        addDrop(ModBlocks.WARPED_PUMPKIN);
        addDrop(ModBlocks.CARVED_WARPED_PUMPKIN);
        addDrop(ModBlocks.WARPED_JACK_O_LANTERN);
        addDrop(ModBlocks.CRIMSON_PUMPKIN);
        addDrop(ModBlocks.CARVED_CRIMSON_PUMPKIN);
        addDrop(ModBlocks.CRIMSON_JACK_O_LANTERN);

        addDrop(ModBlocks.SPOOKY_TORCH);
        addDrop(ModBlocks.WALL_SPOOKY_TORCH);
        addDrop(ModBlocks.SPOOKY_LANTERN);
        addDrop(ModBlocks.SPOOKY_CAMPFIRE, drops(ModBlocks.SPOOKY_CAMPFIRE, Items.ROTTEN_FLESH));

        addDrop(ModBlocks.TWINFIRE_BLOOM);
        addDrop(ModBlocks.POTTED_TWINFIRE_BLOOM, pottedPlantDrops(ModBlocks.TWINFIRE_BLOOM));
        addDrop(ModBlocks.ROTBUD);
        addDrop(ModBlocks.POTTED_ROTBUD, pottedPlantDrops(ModBlocks.ROTBUD));

        addDrop(ModBlocks.DARKROSE_BUSH, doorDrops(ModBlocks.DARKROSE_BUSH));
        addDrop(ModBlocks.AMBERCUP_BUSH, doorDrops(ModBlocks.AMBERCUP_BUSH));

        addDrop(ModBlocks.THORNY_COBBLESTONE);
        addDrop(ModBlocks.THORNY_COBBLESTONE_STAIRS);
        addDrop(ModBlocks.THORNY_COBBLESTONE_SLAB);
        addDrop(ModBlocks.THORNY_COBBLESTONE_WALL);

    }
}