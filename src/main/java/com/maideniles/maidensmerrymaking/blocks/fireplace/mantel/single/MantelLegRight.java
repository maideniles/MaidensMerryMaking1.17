package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MantelLegRight extends HorizontalDecoBlock {

    public static final DirectionProperty DIRECTION = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape MANTEL_WEST_AABB = Block.box(0.0D, 0.0D, 0.0D, 8.0D, 16.0D, 9.0D);
    private static final VoxelShape MANTEL_EAST_AABB = Block.box(7.0D, 0.0D, 8.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape MANTEL_NORTH_AABB = Block.box(7.0D, 0.0D, 0.0D, 15.0D, 16.0D, 8.0D);
    private static final VoxelShape MANTEL_SOUTH_AABB = Block.box(1.0D, 0.0D, 8.0D, 9.0D, 16.0D, 16.0D);


    public MantelLegRight(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_48946_, BlockPos p_48947_, CollisionContext p_48948_) {

        switch(state.getValue(DIRECTION)) {

            default:
            case NORTH:
                return MANTEL_NORTH_AABB;
            case SOUTH:
                return MANTEL_SOUTH_AABB;
            case WEST:
                return MANTEL_WEST_AABB;
            case EAST:

                return MANTEL_EAST_AABB;
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {


        if (state.getValue(MantelLegRight.FACING) == Direction.NORTH) {

            //destroy block above//
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and to left//
            level.setBlock(pos.above().west(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and 2 blocks to left//
            level.setBlock(pos.above().west(2), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 2 blocks to left//
            level.setBlock(pos.west(2), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegRight.FACING) == Direction.SOUTH) {

            //destroy block above//
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and to left//
            level.setBlock(pos.above().east(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and 2 blocks to left//
            level.setBlock(pos.above().east(2), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 2 blocks to left//
            level.setBlock(pos.east(2), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegRight.FACING) == Direction.EAST) {

            //destroy block above//
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and to left//
            level.setBlock(pos.above().north(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and 2 blocks to left//
            level.setBlock(pos.above().north(2), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 2 blocks to left//
            level.setBlock(pos.north(2), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegRight.FACING) == Direction.WEST) {

            //destroy block above//
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and to left//
            level.setBlock(pos.above().south(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and 2 blocks to left//
            level.setBlock(pos.above().south(2), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 2 blocks to left//
            level.setBlock(pos.south(2), Blocks.AIR.defaultBlockState(), 35);
        }


    }


}
