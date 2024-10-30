package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;
import net.nathan.frights_and_foliage.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    public void generate(RecipeExporter exporter) {
        offerPlanksRecipe(exporter, ModBlocks.ASERIA_PLANKS, ModTags.Items.ASERIA_LOGS, 4);

        offerBarkBlockRecipe(exporter, ModBlocks.ASERIA_WOOD, ModBlocks.ASERIA_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_ASERIA_WOOD, ModBlocks.STRIPPED_ASERIA_LOG);

        createStairsRecipe(ModBlocks.ASERIA_STAIRS, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ASERIA_STAIRS)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASERIA_SLAB, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ASERIA_SLAB)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.ASERIA_BUTTON)
                .input(ModBlocks.ASERIA_PLANKS)
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ASERIA_BUTTON)));

        createFenceRecipe(ModBlocks.ASERIA_FENCE, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ASERIA_FENCE)));
        createFenceGateRecipe(ModBlocks.ASERIA_FENCE_GATE, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ASERIA_FENCE_GATE)));

        createDoorRecipe(ModBlocks.ASERIA_DOOR, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ASERIA_DOOR)));
        createTrapdoorRecipe(ModBlocks.ASERIA_TRAPDOOR, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ASERIA_TRAPDOOR)));

        offerPressurePlateRecipe(exporter, ModBlocks.ASERIA_PRESSURE_PLATE, ModBlocks.ASERIA_PLANKS);

        offerHangingSignRecipe(exporter, ModItems.ASERIA_HANGING_SIGN, ModBlocks.STRIPPED_ASERIA_LOG);
        createSignRecipe(ModItems.ASERIA_SIGN, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.ASERIA_SIGN)));

        offerBoatRecipe(exporter, ModItems.ASERIA_BOAT, ModBlocks.ASERIA_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.ASERIA_CHEST_BOAT, ModItems.ASERIA_BOAT);


        offerPlanksRecipe(exporter, ModBlocks.MARNOR_PLANKS, ModTags.Items.MARNOR_LOGS, 4);

        offerBarkBlockRecipe(exporter, ModBlocks.MARNOR_WOOD, ModBlocks.MARNOR_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_MARNOR_WOOD, ModBlocks.STRIPPED_MARNOR_LOG);

        createStairsRecipe(ModBlocks.MARNOR_STAIRS, Ingredient.ofItems(ModBlocks.MARNOR_PLANKS))
                .criterion(hasItem(ModBlocks.MARNOR_PLANKS), conditionsFromItem(ModBlocks.MARNOR_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARNOR_STAIRS)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARNOR_SLAB, Ingredient.ofItems(ModBlocks.MARNOR_PLANKS))
                .criterion(hasItem(ModBlocks.MARNOR_PLANKS), conditionsFromItem(ModBlocks.MARNOR_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARNOR_SLAB)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.MARNOR_BUTTON)
                .input(ModBlocks.MARNOR_PLANKS)
                .criterion(hasItem(ModBlocks.MARNOR_PLANKS), conditionsFromItem(ModBlocks.MARNOR_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARNOR_BUTTON)));

        createFenceRecipe(ModBlocks.MARNOR_FENCE, Ingredient.ofItems(ModBlocks.MARNOR_PLANKS))
                .criterion(hasItem(ModBlocks.MARNOR_PLANKS), conditionsFromItem(ModBlocks.MARNOR_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARNOR_FENCE)));
        createFenceGateRecipe(ModBlocks.MARNOR_FENCE_GATE, Ingredient.ofItems(ModBlocks.MARNOR_PLANKS))
                .criterion(hasItem(ModBlocks.MARNOR_PLANKS), conditionsFromItem(ModBlocks.MARNOR_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARNOR_FENCE_GATE)));

        createDoorRecipe(ModBlocks.MARNOR_DOOR, Ingredient.ofItems(ModBlocks.MARNOR_PLANKS))
                .criterion(hasItem(ModBlocks.MARNOR_PLANKS), conditionsFromItem(ModBlocks.MARNOR_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARNOR_DOOR)));
        createTrapdoorRecipe(ModBlocks.MARNOR_TRAPDOOR, Ingredient.ofItems(ModBlocks.MARNOR_PLANKS))
                .criterion(hasItem(ModBlocks.MARNOR_PLANKS), conditionsFromItem(ModBlocks.MARNOR_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARNOR_TRAPDOOR)));

        offerPressurePlateRecipe(exporter, ModBlocks.MARNOR_PRESSURE_PLATE, ModBlocks.MARNOR_PLANKS);

        offerHangingSignRecipe(exporter, ModItems.MARNOR_HANGING_SIGN, ModBlocks.STRIPPED_MARNOR_LOG);
        createSignRecipe(ModItems.MARNOR_SIGN, Ingredient.ofItems(ModBlocks.MARNOR_PLANKS))
                .criterion(hasItem(ModBlocks.MARNOR_PLANKS), conditionsFromItem(ModBlocks.MARNOR_PLANKS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.MARNOR_SIGN)));

        offerBoatRecipe(exporter, ModItems.MARNOR_BOAT, ModBlocks.MARNOR_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.MARNOR_CHEST_BOAT, ModItems.MARNOR_BOAT);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THORNY_COBBLESTONE)
                .input(Blocks.COBBLESTONE)
                .input(ModBlocks.MARNOR_VINES)
                .criterion(hasItem(ModBlocks.MARNOR_VINES), conditionsFromItem(ModBlocks.MARNOR_VINES))
                .offerTo(exporter);

        createStairsRecipe(ModBlocks.THORNY_COBBLESTONE_STAIRS, Ingredient.ofItems(ModBlocks.THORNY_COBBLESTONE))
                .criterion(hasItem(ModBlocks.THORNY_COBBLESTONE), conditionsFromItem(ModBlocks.THORNY_COBBLESTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.THORNY_COBBLESTONE_STAIRS)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THORNY_COBBLESTONE_SLAB, Ingredient.ofItems(ModBlocks.THORNY_COBBLESTONE))
                .criterion(hasItem(ModBlocks.THORNY_COBBLESTONE), conditionsFromItem(ModBlocks.THORNY_COBBLESTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.THORNY_COBBLESTONE_SLAB)));
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.THORNY_COBBLESTONE_WALL, ModBlocks.THORNY_COBBLESTONE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.THORNY_COBBLESTONE_STAIRS, ModBlocks.THORNY_COBBLESTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.THORNY_COBBLESTONE_SLAB, ModBlocks.THORNY_COBBLESTONE, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.THORNY_COBBLESTONE_WALL, ModBlocks.THORNY_COBBLESTONE);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WARPED_PUMPKIN_SEEDS, 4)
                .group("pumpkin_seeds")
                .input(ModBlocks.WARPED_PUMPKIN)
                .criterion(hasItem(ModBlocks.WARPED_PUMPKIN), conditionsFromItem(ModBlocks.WARPED_PUMPKIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WARPED_JACK_O_LANTERN)
                .group("jack_o_lanterns")
                .pattern("A")
                .pattern("B")
                .input('A', ModBlocks.CARVED_WARPED_PUMPKIN)
                .input('B', Blocks.SOUL_TORCH)
                .criterion(hasItem(ModBlocks.CARVED_WARPED_PUMPKIN), conditionsFromItem(ModBlocks.CARVED_WARPED_PUMPKIN))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WARPED_PUMPKIN_PIE)
                .group("pumpkin_pies")
                .input(ModBlocks.WARPED_PUMPKIN)
                .input(Items.SUGAR)
                .input(Items.EGG)
                .criterion(hasItem(ModBlocks.WARPED_PUMPKIN), conditionsFromItem(ModBlocks.WARPED_PUMPKIN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRIMSON_PUMPKIN_SEEDS, 4)
                .group("pumpkin_seeds")
                .input(ModBlocks.CRIMSON_PUMPKIN)
                .criterion(hasItem(ModBlocks.CRIMSON_PUMPKIN), conditionsFromItem(ModBlocks.CRIMSON_PUMPKIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRIMSON_JACK_O_LANTERN)
                .group("jack_o_lanterns")
                .pattern("A")
                .pattern("B")
                .input('A', ModBlocks.CARVED_CRIMSON_PUMPKIN)
                .input('B', Blocks.SOUL_TORCH)
                .criterion(hasItem(ModBlocks.CARVED_CRIMSON_PUMPKIN), conditionsFromItem(ModBlocks.CARVED_CRIMSON_PUMPKIN))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CRIMSON_PUMPKIN_PIE)
                .group("pumpkin_pies")
                .input(ModBlocks.CRIMSON_PUMPKIN)
                .input(Items.SUGAR)
                .input(Items.EGG)
                .criterion(hasItem(ModBlocks.CRIMSON_PUMPKIN), conditionsFromItem(ModBlocks.CRIMSON_PUMPKIN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.STUFFED_PUMPKIN)
                .input(Blocks.PUMPKIN)
                .input(Items.CARROT)
                .input(Items.COOKED_RABBIT)
                .input(ModItems.SAFFROOT)
                .criterion(hasItem(Blocks.PUMPKIN), conditionsFromItem(Blocks.PUMPKIN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ASERIA_SUGAR_COOKIE)
                .input(Items.SUGAR)
                .input(Items.WHEAT)
                .input(ModItems.ASERIA_SYRUP_BOTTLE)
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ASERIA_CANDY)
                .input(Items.SUGAR)
                .input(ModItems.ASERIA_SYRUP_BOTTLE)
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ASERIA_WAFFLE)
                .pattern(" A ")
                .pattern("WEW")
                .pattern(" S ")
                .input('A', ModItems.ASERIA_SYRUP_BOTTLE)
                .input('W', Items.WHEAT)
                .input('E', Items.EGG)
                .input('S', Items.SUGAR)
                .criterion(hasItem(ModItems.ASERIA_SYRUP_BOTTLE), conditionsFromItem(ModItems.ASERIA_SYRUP_BOTTLE))
                .offerTo(exporter);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(new ItemConvertible[]{ModItems.GAIZE}), RecipeCategory.FOOD, ModItems.PEEPCORN, 0.35F, 200).criterion("has_gaize", conditionsFromItem(ModItems.GAIZE)).offerTo(exporter, "peepcorn_smelting");
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(new ItemConvertible[]{ModItems.GAIZE}), RecipeCategory.FOOD, ModItems.PEEPCORN, 0.35f, 100).criterion("has_gaize", conditionsFromItem(ModItems.GAIZE)).offerTo(exporter, "peepcorn_smoker");
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(new ItemConvertible[]{ModItems.GAIZE}), RecipeCategory.FOOD, ModItems.PEEPCORN, 0.35f, 600).criterion("has_gaize", conditionsFromItem(ModItems.GAIZE)).offerTo(exporter, "peepcorn_campfire");


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GAIZE_BREAD)
                .pattern("WGW")
                .input('G', ModItems.GAIZE)
                .input('W', Items.WHEAT)
                .criterion(hasItem(ModItems.GAIZE), conditionsFromItem(ModItems.GAIZE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GAIZE_FRITTER)
                .input(ModItems.GAIZE)
                .input(ModItems.ASERIA_SYRUP_BOTTLE)
                .input(Items.WHEAT)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.GAIZE), conditionsFromItem(ModItems.GAIZE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.APPLE_CIDER)
                .input(Items.APPLE)
                .input(Items.GLASS_BOTTLE)
                .input(Items.SUGAR)
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BERRY_BLEND)
                .input(Items.GLASS_BOTTLE)
                .input(ModItems.NOX_BERRIES)
                .input(Items.GLOW_BERRIES)
                .input(Items.SWEET_BERRIES)
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.NOX_BERRY_TRAIL_MIX)
                .input(ModItems.NOX_BERRIES)
                .input(Items.PUMPKIN_SEEDS)
                .input(Items.DRIED_KELP)
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .offerTo(exporter);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(new ItemConvertible[]{ModItems.NOX_BERRIES}), RecipeCategory.FOOD, ModItems.DRIED_NOX_BERRIES, 0.35F, 200).criterion("has_nox_berries", conditionsFromItem(ModItems.NOX_BERRIES)).offerTo(exporter, "dried_nox_berries_smelting");
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(new ItemConvertible[]{ModItems.NOX_BERRIES}), RecipeCategory.FOOD, ModItems.DRIED_NOX_BERRIES, 0.35f, 100).criterion("has_nox_berries", conditionsFromItem(ModItems.NOX_BERRIES)).offerTo(exporter, "dried_nox_berries_smoking");
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(new ItemConvertible[]{ModItems.NOX_BERRIES}), RecipeCategory.FOOD, ModItems.DRIED_NOX_BERRIES, 0.35f, 600).criterion("has_nox_berries", conditionsFromItem(ModItems.NOX_BERRIES)).offerTo(exporter, "dried_nox_berries_campfire");


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SAFFROOT_OMELETTE)
                .pattern("ESE")
                .input('S', ModItems.SAFFROOT)
                .input('E', Items.EGG)
                .criterion(hasItem(ModItems.SAFFROOT), conditionsFromItem(ModItems.SAFFROOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.STARCH_SKEWER)
                .pattern("  R")
                .pattern(" P ")
                .pattern("S  ")
                .input('R', ModItems.SAFFROOT)
                .input('P', Items.POTATO)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.SAFFROOT), conditionsFromItem(ModItems.SAFFROOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ANTLERMEAL)
                .input(ModItems.FUMKIN_ANTLER)
                .input(Items.BONE_MEAL)
                .criterion(hasItem(Items.BONE_MEAL), conditionsFromItem(Items.BONE_MEAL))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.PUMPKIN)
                .pattern("AA")
                .pattern("AA")
                .input('A', ModItems.FUMKIN_ANTLER)
                .criterion(hasItem(ModItems.FUMKIN_ANTLER), conditionsFromItem(ModItems.FUMKIN_ANTLER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SPOOKY_TORCH, 4)
                .pattern("C")
                .pattern("S")
                .pattern("R")
                .input('C', Items.COAL)
                .input('S', Items.STICK)
                .input('R', Items.ROTTEN_FLESH)
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SPOOKY_LANTERN)
                .pattern("III")
                .pattern("ITI")
                .pattern("III")
                .input('I', Items.IRON_NUGGET)
                .input('T', ModItems.SPOOKY_TORCH)
                .criterion(hasItem(ModItems.SPOOKY_TORCH), conditionsFromItem(ModItems.SPOOKY_TORCH))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SPOOKY_CAMPFIRE)
                .pattern(" S ")
                .pattern("SRS")
                .pattern("WWW")
                .input('S', Items.STICK)
                .input('R', Items.ROTTEN_FLESH)
                .input('W', ItemTags.LOGS)
                .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GAIZE_SEEDS)
                .input(ModItems.GAIZE)
                .criterion(hasItem(ModItems.GAIZE), conditionsFromItem(ModItems.GAIZE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.VIRE_FEATHER_ARROW)
                .input(ModItems.VIRE_FEATHER)
                .input(Items.ARROW)
                .criterion(hasItem(Items.ARROW), conditionsFromItem(Items.ARROW))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.MAGENTA_DYE, 2)
                .input(ModBlocks.DARKROSE_BUSH)
                .criterion(hasItem(ModBlocks.DARKROSE_BUSH), conditionsFromItem(ModBlocks.DARKROSE_BUSH))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.LIME_DYE)
                .input(ModBlocks.ROTBUD)
                .criterion(hasItem(ModBlocks.ROTBUD), conditionsFromItem(ModBlocks.ROTBUD))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.YELLOW_DYE, 2)
                .input(ModBlocks.TWINFIRE_BLOOM)
                .criterion(hasItem(ModBlocks.TWINFIRE_BLOOM), conditionsFromItem(ModBlocks.TWINFIRE_BLOOM))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.ORANGE_DYE, 2)
                .input(ModBlocks.AMBERCUP_BUSH)
                .criterion(hasItem(ModBlocks.AMBERCUP_BUSH), conditionsFromItem(ModBlocks.AMBERCUP_BUSH))
                .offerTo(exporter);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(new ItemConvertible[]{ModItems.RAW_VENISON}), RecipeCategory.FOOD, ModItems.COOKED_VENISON, 0.35F, 200).criterion("has_raw_venison", conditionsFromItem(ModItems.RAW_VENISON)).offerTo(exporter, "cooked_venison_smelting");
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(new ItemConvertible[]{ModItems.RAW_VENISON}), RecipeCategory.FOOD, ModItems.COOKED_VENISON, 0.35f, 100).criterion("has_raw_venison", conditionsFromItem(ModItems.RAW_VENISON)).offerTo(exporter, "cooked_venison_smoking");
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(new ItemConvertible[]{ModItems.RAW_VENISON}), RecipeCategory.FOOD, ModItems.COOKED_VENISON, 0.35f, 600).criterion("has_raw_venison", conditionsFromItem(ModItems.RAW_VENISON)).offerTo(exporter, "cooked_venison_campfire");
    }
}
