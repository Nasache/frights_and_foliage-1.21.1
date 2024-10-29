package net.nathan.frights_and_foliage.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.nathan.frights_and_foliage.blocks.entity.ModHangingSignBlockEntity;

public class ModWallHangingSignBlock extends WallHangingSignBlock {
    public ModWallHangingSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ModHangingSignBlockEntity(pos, state);
    }
}