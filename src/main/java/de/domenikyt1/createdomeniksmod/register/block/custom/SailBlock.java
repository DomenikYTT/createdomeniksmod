package de.domenikyt1.createdomeniksmod.register.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class SailBlock extends DirectionalBlock {
    public static final MapCodec<SailBlock> CODEC = simpleCodec(SailBlock::new);


    private static final VoxelShape UP = Block.box(0, 5, 0, 16, 10, 16);
    private static final VoxelShape DOWN = Block.box(0, 6, 0, 16, 11, 16);
    private static final VoxelShape EAST = Block.box(5, 0, 0, 10, 16, 16);
    private static final VoxelShape WEST = Block.box(6, 0, 0, 11, 16, 16);
    private static final VoxelShape NORTH = Block.box(0, 0, 6, 16, 16, 11);
    private static final VoxelShape SOUTH = Block.box(0, 0, 5, 16, 16, 10);



    public SailBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case UP -> UP;
            case DOWN -> DOWN;
            case EAST -> EAST;
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case WEST -> WEST;
        };
    }

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
