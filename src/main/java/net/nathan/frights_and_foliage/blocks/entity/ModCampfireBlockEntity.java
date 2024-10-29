package net.nathan.frights_and_foliage.blocks.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.util.math.BlockPos;

public class ModCampfireBlockEntity extends CampfireBlockEntity {
    public ModCampfireBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_CAMPFIRE_BLOCK_ENTITY;
    }
}
