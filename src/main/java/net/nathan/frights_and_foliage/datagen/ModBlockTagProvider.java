package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
   public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
       super(output, registriesFuture);
   }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.ASERIA_PLANKS,
                        ModBlocks.ASERIA_STAIRS,
                        ModBlocks.ASERIA_SLAB,
                        ModBlocks.ASERIA_BUTTON,
                        ModBlocks.ASERIA_PRESSURE_PLATE,
                        ModBlocks.ASERIA_FENCE,
                        ModBlocks.ASERIA_FENCE_GATE,
                        ModBlocks.ASERIA_DOOR,
                        ModBlocks.ASERIA_TRAPDOOR,
                        ModBlocks.ASERIA_LOG,
                        ModBlocks.ASERIA_SYRUP_LOG,
                        ModBlocks.ASERIA_WOOD,
                        ModBlocks.STRIPPED_ASERIA_LOG,
                        ModBlocks.STRIPPED_ASERIA_WOOD,
                        ModBlocks.ASERIA_HANGING_SIGN,
                        ModBlocks.ASERIA_SIGN,
                        ModBlocks.ASERIA_WALL_SIGN,
                        ModBlocks.ASERIA_WALL_HANGING_SIGN,
                        ModBlocks.MARNOR_PLANKS,
                        ModBlocks.MARNOR_STAIRS,
                        ModBlocks.MARNOR_SLAB,
                        ModBlocks.MARNOR_BUTTON,
                        ModBlocks.MARNOR_PRESSURE_PLATE,
                        ModBlocks.MARNOR_FENCE,
                        ModBlocks.MARNOR_FENCE_GATE,
                        ModBlocks.MARNOR_DOOR,
                        ModBlocks.MARNOR_TRAPDOOR,
                        ModBlocks.MARNOR_LOG,
                        ModBlocks.MARNOR_WOOD,
                        ModBlocks.STRIPPED_MARNOR_LOG,
                        ModBlocks.STRIPPED_MARNOR_WOOD,
                        ModBlocks.MARNOR_HANGING_SIGN,
                        ModBlocks.MARNOR_SIGN,
                        ModBlocks.MARNOR_WALL_SIGN,
                        ModBlocks.MARNOR_WALL_HANGING_SIGN,
                        ModBlocks.CRIMSON_PUMPKIN,
                        ModBlocks.CARVED_CRIMSON_PUMPKIN,
                        ModBlocks.CRIMSON_JACK_O_LANTERN,
                        ModBlocks.WARPED_PUMPKIN,
                        ModBlocks.CARVED_WARPED_PUMPKIN,
                        ModBlocks.WARPED_JACK_O_LANTERN,
                        ModBlocks.SPOOKY_CAMPFIRE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.THORNY_COBBLESTONE,
                        ModBlocks.THORNY_COBBLESTONE_STAIRS,
                        ModBlocks.THORNY_COBBLESTONE_SLAB,
                        ModBlocks.THORNY_COBBLESTONE_WALL,
                        ModBlocks.SPOOKY_LANTERN);

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.ASERIA_PLANKS, ModBlocks.MARNOR_PLANKS);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.RED_ASERIA_LEAVES,
                        ModBlocks.ORANGE_ASERIA_LEAVES,
                        ModBlocks.YELLOW_ASERIA_LEAVES,
                        ModBlocks.MARNOR_LEAVES,
                        ModBlocks.INFESTED_MARNOR_LEAVES);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.ASERIA_FENCE, ModBlocks.MARNOR_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ASERIA_FENCE_GATE, ModBlocks.MARNOR_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ASERIA_LOG,
                        ModBlocks.ASERIA_WOOD,
                        ModBlocks.ASERIA_SYRUP_LOG,
                        ModBlocks.STRIPPED_ASERIA_LOG,
                        ModBlocks.STRIPPED_ASERIA_WOOD,
                        ModBlocks.MARNOR_WOOD,
                        ModBlocks.MARNOR_LOG,
                        ModBlocks.STRIPPED_MARNOR_LOG,
                        ModBlocks.STRIPPED_MARNOR_WOOD);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.TWINFIRE_BLOOM,
                        ModBlocks.ROTBUD,
                        ModBlocks.DARKROSE_BUSH,
                        ModBlocks.AMBERCUP_BUSH);

        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.DARKROSE_BUSH,
                        ModBlocks.AMBERCUP_BUSH);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.TWINFIRE_BLOOM,
                        ModBlocks.ROTBUD);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_TWINFIRE_BLOOM,
                        ModBlocks.POTTED_ROTBUD,
                        ModBlocks.POTTED_MARNOR_SAPLING,
                        ModBlocks.POTTED_ORANGE_ASERIA_SAPLING,
                        ModBlocks.POTTED_RED_ASERIA_SAPLING,
                        ModBlocks.POTTED_YELLOW_ASERIA_SAPLING);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.POTTED_MARNOR_SAPLING,
                        ModBlocks.POTTED_ORANGE_ASERIA_SAPLING,
                        ModBlocks.POTTED_RED_ASERIA_SAPLING,
                        ModBlocks.POTTED_YELLOW_ASERIA_SAPLING);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.THORNY_COBBLESTONE_WALL);

        getOrCreateTagBuilder(BlockTags.CAMPFIRES)
                .add(ModBlocks.SPOOKY_CAMPFIRE);

        getOrCreateTagBuilder(ModTags.Blocks.ASERIA_LOGS)
                .add(ModBlocks.ASERIA_LOG, ModBlocks.ASERIA_SYRUP_LOG, ModBlocks.ASERIA_WOOD,
                        ModBlocks.STRIPPED_ASERIA_LOG, ModBlocks.STRIPPED_ASERIA_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.MARNOR_LOGS)
                .add(ModBlocks.MARNOR_LOG, ModBlocks.MARNOR_WOOD,
                        ModBlocks.STRIPPED_MARNOR_LOG, ModBlocks.STRIPPED_MARNOR_WOOD);

    }
}
