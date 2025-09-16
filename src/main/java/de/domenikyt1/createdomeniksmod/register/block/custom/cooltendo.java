package de.domenikyt1.createdomeniksmod.register.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class cooltendo extends HorizontalDirectionalBlock {
    public static final MapCodec<cooltendo> CODEC = simpleCodec(cooltendo::new);


    private static final VoxelShape NORTH = Block.box(1, 0, 7.5, 15, 6, 8.5);
    private static final VoxelShape SOUTH = Block.box(1, 0, 7.5, 15, 6, 8.5);
    private static final VoxelShape EAST = Block.box(7.5, 0, 1, 8.5, 6, 15);
    private static final VoxelShape WEST = Block.box(7.5, 0, 1, 8.5, 6, 15);



    public cooltendo(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> EAST;
            case WEST -> WEST;
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            default -> NORTH; /*Fallback-Sicherheit*/
        };
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
