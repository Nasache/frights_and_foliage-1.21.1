package net.nathan.frights_and_foliage.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.world.tree.ModFoliagePlacerTypes;

public class MarnorFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<MarnorFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((instance) ->
            fillFoliagePlacerFields(instance)
                    .and(instance.group(
                            IntProvider.createValidatingCodec(4, 16).fieldOf("height").forGetter((foliagePlacer) -> foliagePlacer.height),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("wide_bottom_layer_hole_chance").forGetter((foliagePlacer) -> foliagePlacer.wideBottomLayerHoleChance),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("corner_hole_chance").forGetter((foliagePlacer) -> foliagePlacer.cornerHoleChance),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_chance").forGetter((foliagePlacer) -> foliagePlacer.hangingLeavesChance),
                            Codec.floatRange(0.0F, 1.0F).fieldOf("hanging_leaves_extension_chance").forGetter((foliagePlacer) -> foliagePlacer.hangingLeavesExtensionChance)
                    ))
                    .apply(instance, MarnorFoliagePlacer::new));


    private final IntProvider height;
    private final float wideBottomLayerHoleChance;
    private final float cornerHoleChance;
    private final float hangingLeavesChance;
    private final float hangingLeavesExtensionChance;

    public MarnorFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height, float wideBottomLayerHoleChance, float cornerHoleChance, float hangingLeavesChance, float hangingLeavesExtensionChance) {
        super(radius, offset);
        this.height = height;
        this.wideBottomLayerHoleChance = wideBottomLayerHoleChance;
        this.cornerHoleChance = cornerHoleChance;
        this.hangingLeavesChance = hangingLeavesChance;
        this.hangingLeavesExtensionChance = hangingLeavesExtensionChance;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.MARNOR_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset) {
        boolean bl = treeNode.isGiantTrunk();
        BlockPos blockPos = treeNode.getCenter().up(offset);
        int i = radius + treeNode.getFoliageRadius() - 1;

        // Generate foliage as usual
        this.generateSquare(world, placer, random, config, blockPos, i - 2, foliageHeight - 3, bl);
        this.generateSquare(world, placer, random, config, blockPos, i - 1, foliageHeight - 4, bl);

        for (int j = foliageHeight - 5; j >= 0; --j) {
            this.generateSquare(world, placer, random, config, blockPos, i, j, bl);
        }

        this.generateSquareWithHangingLeaves(world, placer, random, config, blockPos, i, -1, bl, this.hangingLeavesChance, this.hangingLeavesExtensionChance);
        this.generateSquareWithHangingLeaves(world, placer, random, config, blockPos, i - 1, -2, bl, this.hangingLeavesChance, this.hangingLeavesExtensionChance);

        // Adjust vine generation to include random lengths
        generateMarnorVinesWithRandomLength(world, placer, random, blockPos, radius);
    }

    // Method to generate vines on lower layers with random lengths
    private void generateMarnorVinesWithRandomLength(TestableWorld world, BlockPlacer placer, Random random, BlockPos foliagePos, int radius) {
        for (int layerOffset = -3; layerOffset <= -1; layerOffset++) {  // Iterate over the three lower layers
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    if (random.nextFloat() < 0.2F) {  // 20% chance to generate vines
                        BlockPos vinePos = foliagePos.add(x, layerOffset, z);  // Adjust the position based on layer offset
                        BlockPos blockAbove = vinePos.up();  // The block directly above the vines

                        // Check if the block above is Marnor Leaves and the current position is air
                        if (world.testBlockState(blockAbove, state -> state.isOf(ModBlocks.MARNOR_LEAVES)) && world.testBlockState(vinePos, state -> state.isAir())) {
                            placeVineWithRandomLength(world, placer, vinePos, random);  // Place Marnor Vine with random length
                        }
                    }
                }
            }
        }
    }

    // Method to place vines with a random length, ensuring MARNOR_VINES_PLANT for upper blocks and MARNOR_VINES for the bottom
    private void placeVineWithRandomLength(TestableWorld world, BlockPlacer placer, BlockPos vinePos, Random random) {
        int maxLength = 3 + random.nextInt(3);  // Random vine length between 3 and 5 blocks
        BlockPos currentPos = vinePos;

        for (int i = 0; i < maxLength; i++) {
            if (world.testBlockState(currentPos, state -> state.isAir())) {
                if (i == maxLength - 1) {
                    placer.placeBlock(currentPos, ModBlocks.MARNOR_VINES.getDefaultState());  // Place MARNOR_VINES at the bottom
                } else {
                    placer.placeBlock(currentPos, ModBlocks.MARNOR_VINES_PLANT.getDefaultState());  // Place MARNOR_VINES_PLANT for the upper parts
                }
                currentPos = currentPos.down();  // Move one block down to extend the vine
            } else {
                break;  // Stop if we hit a non-air block
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height.get(random);
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (y == -1 && (dx == radius || dz == radius) && random.nextFloat() < this.wideBottomLayerHoleChance) {
            return true;
        } else {
            boolean bl = dx == radius && dz == radius;
            boolean bl2 = radius > 2;
            if (bl2) {
                return bl || dx + dz > radius * 2 - 2 && random.nextFloat() < this.cornerHoleChance;
            } else {
                return bl && random.nextFloat() < this.cornerHoleChance;
            }
        }
    }
}