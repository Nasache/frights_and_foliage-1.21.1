package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;
import net.nathan.frights_and_foliage.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ASERIA_LOG.asItem(), ModBlocks.ASERIA_SYRUP_LOG.asItem(), ModBlocks.ASERIA_WOOD.asItem(),
                        ModBlocks.STRIPPED_ASERIA_LOG.asItem(), ModBlocks.STRIPPED_ASERIA_WOOD.asItem(),
                        ModBlocks.MARNOR_LOG.asItem(), ModBlocks.MARNOR_WOOD.asItem(),
                        ModBlocks.STRIPPED_MARNOR_LOG.asItem(), ModBlocks.STRIPPED_MARNOR_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.ASERIA_PLANKS.asItem(), ModBlocks.MARNOR_PLANKS.asItem());

        getOrCreateTagBuilder(ModTags.Items.ASERIA_LOGS)
                .add(ModBlocks.ASERIA_LOG.asItem(), ModBlocks.ASERIA_SYRUP_LOG.asItem(), ModBlocks.ASERIA_WOOD.asItem(),
                        ModBlocks.STRIPPED_ASERIA_LOG.asItem(), ModBlocks.STRIPPED_ASERIA_WOOD.asItem());

        getOrCreateTagBuilder(ModTags.Items.MARNOR_LOGS)
                .add(ModBlocks.MARNOR_LOG.asItem(), ModBlocks.MARNOR_WOOD.asItem(),
                        ModBlocks.STRIPPED_MARNOR_LOG.asItem(), ModBlocks.STRIPPED_MARNOR_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.ARROWS)
                .add(ModItems.VIRE_FEATHER_ARROW);
    }
}
