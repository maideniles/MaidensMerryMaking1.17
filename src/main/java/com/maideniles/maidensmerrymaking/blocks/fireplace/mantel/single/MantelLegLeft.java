package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking.MantelTopCenterStocking;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking.MantelTopLeftStocking;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.stocking.MantelTopRightStocking;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MantelLegLeft extends HorizontalDecoBlock {

    private static final VoxelShape WEST_AABB = Block.box(0.0D, 0.0D, 7.0D, 8.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_AABB = Block.box(8.0D, 0.0D, 0.0D, 16.0D, 16.0D, 9.0D);
    private static final VoxelShape NORTH_AABB = Block.box(1.0D, 0.0D, 0.0D, 9.0D, 16.0D, 8.0D);
    private static final VoxelShape SOUTH_AABB = Block.box(7.0D, 0.0D, 8.0D, 15.0D, 16.0D, 16.0D);



    public MantelLegLeft(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter p_48946_, BlockPos p_48947_, CollisionContext p_48948_) {

        switch((Direction)state.getValue(DIRECTION)) {
            case SOUTH:
                return SOUTH_AABB;
            case NORTH:
            default:
                return NORTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
                return EAST_AABB;
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {

//BlockState check_stocking = level.getBlockState(pos.above());


        int r =  1;
        for (int x = -r; x <= r; x++) {
            for (int z = -r; z <= r; z++) {
                Block check_stocking = level.getBlockState(pos.offset(x, 1, z)).getBlock();

                BlockPos blockpos = pos.offset(x, -1, z);
                if (blockpos.distSqr(pos) > r * r) {
                    continue;}

                if(check_stocking instanceof MantelTopLeftStocking || check_stocking instanceof MantelTopCenterStocking
                || check_stocking instanceof MantelTopRightStocking) {
                    popResource(level, pos, new ItemStack(ModItems.STOCKING.get()));
                    System.out.println("DROPPED STOCKING");
                }

            }

            // destroy block above//
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and to right//
            level.setBlock(pos.above().east(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and 2 blocks to right//
            level.setBlock(pos.above().east(2), Blocks.AIR.defaultBlockState(), 35);
            //destroy LEG block 2 blocks to right//
            level.setBlock(pos.east(2), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegLeft.FACING) == Direction.SOUTH) {

            //destroy block above//
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and to right//
            level.setBlock(pos.above().west(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and 2 blocks to right//
            level.setBlock(pos.above().west(2), Blocks.AIR.defaultBlockState(), 35);
            //destroy LEG block 2 blocks to right//
            level.setBlock(pos.west(2), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegLeft.FACING) == Direction.EAST) {
            //destroy block above//
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and to right//
            level.setBlock(pos.above().south(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and 2 blocks to right//
            level.setBlock(pos.above().south(2), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 2 blocks to right//
            level.setBlock(pos.south(2), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegLeft.FACING) == Direction.WEST) {

            //destroy block above//
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and to right//
            level.setBlock(pos.above().north(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block above and 2 blocks to right//
            level.setBlock(pos.above().north(2), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 2 blocks to right//
            level.setBlock(pos.north(2), Blocks.AIR.defaultBlockState(), 35);
        }


    }

}
