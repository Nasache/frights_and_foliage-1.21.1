package net.nathan.frights_and_foliage.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.nathan.frights_and_foliage.world.tree.ModFoliagePlacerTypes;

public class AseriaFoliagePlacer extends FoliagePlacer {
    public static final Codec<AseriaFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> fillFoliagePlacerFields(instance)
            .and(Codec.intRange(0, 12).fieldOf("height").forGetter((placer) -> placer.height)).apply(instance, AseriaFoliagePlacer::new));
    private final int height;

    public AseriaFoliagePlacer(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerTypes.ASERIA_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight,
                            TreeNode treeNode, int foliageHeight, int radius, int offset) {
        for(int i = 3; i < 5; i++) {
            this.generateSquare(world, placer, random, config, treeNode.getCenter(), 0, i, treeNode.isGiantTrunk());
        } for(int i = 0; i < 3; i++) {
            this.generateSquare(world, placer, random, config, treeNode.getCenter(), 1, i, treeNode.isGiantTrunk());
        } for(int i = -4; i < 0; i++) {
            this.generateSquare(world, placer, random, config, treeNode.getCenter(), 2, i, treeNode.isGiantTrunk());
        } for(int i = -5; i < -4; i++) {
            this.generateSquare(world, placer, random, config, treeNode.getCenter(), 1, i, treeNode.isGiantTrunk());
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return dx == radius && dz == radius &&  y == 2 ||
                dx == radius && dz == radius &&  y == 1 ||
                dx == 2 && dz >= 1 &&  y == -1 ||
                dx == 1 && dz == 2 &&  y == -1 ||
                dx == radius && dz == radius &&  y <= -2;
    }
}
