package net.nathan.frights_and_foliage.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class AntlerMealItem extends Item {

    public AntlerMealItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        if (useOnFertilizable(context.getStack(), world, blockPos)) {
            if (!world.isClient) {
                world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, blockPos, 0);
            }
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }

    public static boolean useOnFertilizable(ItemStack stack, World world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof Fertilizable fertilizable) {
            if (fertilizable.isFertilizable(world, pos, blockState)) {
                if (world instanceof ServerWorld) {
                    if (fertilizable.canGrow(world, world.random, pos, blockState)) {
                        BlockState grownState = fullyGrowPlant(world, pos, blockState);
                        if (grownState != blockState) {
                            world.setBlockState(pos, grownState, 2);
                        } else {
                            fertilizable.grow((ServerWorld) world, world.random, pos, blockState);
                        }
                    }
                    stack.decrement(1);
                }
                return true;
            }
        }
        return false;
    }

    private static BlockState fullyGrowPlant(World world, BlockPos pos, BlockState state) {
        if (state.contains(Properties.AGE_7)) {
            return state.with(Properties.AGE_7, 7);
        } else if (state.contains(Properties.AGE_5)) {
            return state.with(Properties.AGE_5, 5);
        } else if (state.contains(Properties.AGE_3)) {
            return state.with(Properties.AGE_3, 3);
        } else if (state.contains(Properties.AGE_2)) {
            return state.with(Properties.AGE_2, 2);
        }
        return state;
    }
}
