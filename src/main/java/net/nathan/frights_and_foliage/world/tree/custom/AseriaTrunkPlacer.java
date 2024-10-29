package net.nathan.frights_and_foliage.world.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.world.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;

public class AseriaTrunkPlacer extends TrunkPlacer {
    public static final Codec<AseriaTrunkPlacer> CODEC = RecordCodecBuilder.create((AcerTrunkPlacerInstance) -> {
        return fillTrunkPlacerFields(AcerTrunkPlacerInstance).apply(AcerTrunkPlacerInstance, AseriaTrunkPlacer::new);
    });

    public AseriaTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    protected TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.ASERIA_TRUNK_PLACER;
    }

    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);

        for (int i = 0; i < height; ++i) {
            BlockPos currentPos = startPos.up(i);
            if (random.nextInt(10) == 0) {
                replacer.accept(currentPos, ModBlocks.ASERIA_SYRUP_LOG.getDefaultState());
            } else {
                this.getAndSetState(world, replacer, random, currentPos, config);
            }
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));
    }
}
