package net.nathan.frights_and_foliage.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.WorldView;
import net.nathan.frights_and_foliage.blocks.ModBlocks;

public class MarnorVinesPlantBlock extends AbstractPlantBlock {
    public static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    public MarnorVinesPlantBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false);
    }

    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) ModBlocks.MARNOR_VINES;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.offset(this.growthDirection.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);

        if (!this.canAttachTo(blockState)) {
            return false;
        } else {
            return blockState.isOf(this.getStem()) || blockState.isOf(this.getPlant()) ||
                    blockState.isSideSolidFullSquare(world, blockPos, this.growthDirection) ||
                    blockState.getBlock() instanceof LeavesBlock;
        }
    }

    @Override
    protected MapCodec<? extends AbstractPlantBlock> getCodec() {
        return null;
    }
}
