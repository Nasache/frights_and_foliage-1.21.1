package net.nathan.frights_and_foliage.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MarnorSaplingBlock extends PlantBlock implements Fertilizable {
    public static final IntProperty STAGE;
    protected static final float field_31236 = 6.0F;
    protected static final VoxelShape SHAPE;
    private final SaplingGenerator generator;

    public MarnorSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(settings);
        this.generator = generator;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(STAGE, 0));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(7) == 0) {
            this.generate(world, pos, state, random);
        }
    }

    public void generate(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if ((Integer)state.get(STAGE) == 0) {
            world.setBlockState(pos, (BlockState)state.cycle(STAGE), 4);
        } else {
            if (canGrowInTightSpace(world, pos)) {
                this.generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
            }
        }
    }

    private boolean canGrowInTightSpace(World world, BlockPos pos) {
        return true;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double)world.random.nextFloat() < 0.45;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.generate(world, pos, state, random);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{STAGE});
    }

    static {
        STAGE = Properties.STAGE;
        SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    }

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }
}

