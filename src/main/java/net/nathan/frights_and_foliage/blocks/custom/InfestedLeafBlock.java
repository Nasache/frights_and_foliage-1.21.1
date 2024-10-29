package net.nathan.frights_and_foliage.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.entity.custom.LephidEntity;

import java.util.List;
import java.util.OptionalInt;

public class InfestedLeafBlock extends LeavesBlock {

    public InfestedLeafBlock(Settings settings) {
        super(settings);
    }

    private void spawnLephid(ServerWorld world, BlockPos pos) {
        BlockPos spawnPos = pos.down();

        if (world.getBlockState(spawnPos).isAir()) {
            LephidEntity leafBugEntity = (LephidEntity) ModEntities.LEPHID.create(world);
            if (leafBugEntity != null) {
                leafBugEntity.refreshPositionAndAngles((double)spawnPos.getX() + 0.5, (double)spawnPos.getY() + 0.5, (double)spawnPos.getZ() + 0.5, 0.0F, 0.0F);
                world.spawnEntity(leafBugEntity);
                leafBugEntity.playSpawnEffects();
            }

            BlockState currentState = world.getBlockState(pos);

            BlockState newState = ModBlocks.MARNOR_LEAVES.getDefaultState()
                    .with(Properties.DISTANCE_1_7, currentState.get(Properties.DISTANCE_1_7))
                    .with(Properties.PERSISTENT, currentState.get(Properties.PERSISTENT));

            world.setBlockState(pos, newState, 3);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.setBlockState(pos, updateDistanceFromLogs(state, world, pos), 3);
        if (!world.isClient) {
            Box detectionBox = new Box(pos).expand(0, -1, 0).stretch(0, -5, 0);

            List<PlayerEntity> players = world.getEntitiesByClass(PlayerEntity.class, detectionBox, player -> !player.isCreative() && !player.isSpectator());

            if (!players.isEmpty() && world.getBlockState(pos.down()).isAir()) {
                this.spawnLephid(world, pos);
            }
        }

        world.scheduleBlockTick(pos, this, 5);
    }


    private static BlockState updateDistanceFromLogs(BlockState state, WorldAccess world, BlockPos pos) {
        int i = 7;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Direction[] var5 = Direction.values();
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Direction direction = var5[var7];
            mutable.set(pos, direction);
            i = Math.min(i, getDistanceFromLog(world.getBlockState(mutable)) + 1);
            if (i == 1) {
                break;
            }
        }

        return (BlockState)state.with(DISTANCE, i);
    }

    private static int getDistanceFromLog(BlockState state) {
        return getOptionalDistanceFromLog(state).orElse(7);
    }

    public static OptionalInt getOptionalDistanceFromLog(BlockState state) {
        if (state.isIn(BlockTags.LOGS)) {
            return OptionalInt.of(0);
        } else {
            return state.contains(DISTANCE) ? OptionalInt.of((Integer)state.get(DISTANCE)) : OptionalInt.empty();
        }
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, net.minecraft.entity.LivingEntity placer, net.minecraft.item.ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient) {
            ((ServerWorld) world).scheduleBlockTick(pos, this, 5);
        }
    }
}
