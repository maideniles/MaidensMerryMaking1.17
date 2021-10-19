package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MantelTopCenter extends HorizontalDecoBlock {


    protected static final VoxelShape MANTEL_WEST_AABB = Block.box(0.0D, 8.0D, 0.0D, 9.0D, 16.0D, 16.0D);
    protected static final VoxelShape MANTEL_EAST_AABB = Block.box(7.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape MANTEL_NORTH_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 9.0D);   protected static final VoxelShape MANTEL_SOUTH_AABB = Block.box(0.0D, 8.0D, 7.0D, 16.0D, 16.0D, 16.0D);


    public MantelTopCenter(Properties properties) {
        super(properties);


    }

    public VoxelShape getShape(BlockState state, BlockGetter p_48946_, BlockPos p_48947_, CollisionContext p_48948_) {

        switch(state.getValue(DIRECTION)) {
            case SOUTH:
                return MANTEL_SOUTH_AABB;
            case NORTH:
            default:
                return MANTEL_NORTH_AABB;
            case WEST:
                return MANTEL_WEST_AABB;
            case EAST:
                return MANTEL_EAST_AABB;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(DIRECTION, context.getHorizontalDirection().getOpposite());

    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult pHit) {


        ItemStack stocking = player.getItemInHand(hand);

        if (!level.isClientSide()) {



            if (stocking.getItem() == ModItems.STOCKING.get()){

                System.out.println("THE STOCKINGS WERE HUNG");
                level.setBlock (pos, ModBlocks.MANTEL_ACACIA_TOP_MIDDLE_STOCKING.get (). defaultBlockState (). setValue (FACING, state.getValue (FACING)) , 3);


                stocking.shrink(1);
                return InteractionResult.PASS;
            }


            if (stocking.isEmpty()){
                level.setBlock (pos, ModBlocks.MANTEL_ACACIA_TOP_MIDDLE.get (). defaultBlockState (). setValue (FACING, state.getValue (FACING)) , 3);



                player.getInventory().add(new ItemStack(ModItems.STOCKING.get()));
            }


        }

        return InteractionResult.sidedSuccess (level.isClientSide);
    }










    @Override
    public  void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {


        if (state.getValue(MantelLegLeft.FACING) == Direction.NORTH) {

            //destroy block to left//
            level.setBlock(pos.west(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block  to right//
            level.setBlock(pos.east(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block below and 1 to right//
            level.setBlock(pos.below().east(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 blocks below and 1 to left//
            level.setBlock(pos.below().west(), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegLeft.FACING) == Direction.SOUTH) {

            //destroy block to left//
            level.setBlock(pos.east(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block  to right//
            level.setBlock(pos.west(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block below and 1 to right//
            level.setBlock(pos.below().west(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 blocks below and 1 to left//
            level.setBlock(pos.below().east(), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegLeft.FACING) == Direction.EAST) {

            //destroy block to left//
            level.setBlock(pos.north(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block  to right//
            level.setBlock(pos.south(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block below and 1 to right//
            level.setBlock(pos.below().south(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 blocks below and 1 to left//
            level.setBlock(pos.below().north(), Blocks.AIR.defaultBlockState(), 35);
        }

        if (state.getValue(MantelLegLeft.FACING) == Direction.WEST) {

            //destroy block to left//
            level.setBlock(pos.south(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block  to right//
            level.setBlock(pos.north(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 block below and 1 to right//
            level.setBlock(pos.below().south(), Blocks.AIR.defaultBlockState(), 35);
            //destroy block 1 blocks below and 1 to left//
            level.setBlock(pos.below().north(), Blocks.AIR.defaultBlockState(), 35);
        }

    }

    }





