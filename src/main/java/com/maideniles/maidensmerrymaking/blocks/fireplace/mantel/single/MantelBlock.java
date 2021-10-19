package com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.single;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.datafix.fixes.ChunkPalettedStorageFix;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;

import javax.annotation.Nullable;

public class MantelBlock extends HorizontalDecoBlock {
    public MantelBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {


        if (state.getValue(this.FACING) == Direction.SOUTH) {


            level.setBlockAndUpdate(pos.above(), ModBlocks.MANTEL_ACACIA_TOP_MIDDLE.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(-1, 1, 0), ModBlocks.MANTEL_ACACIA_TOP_LEFT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(1, 1, 0), ModBlocks.MANTEL_ACACIA_TOP_RIGHT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(-1, 0, 0), ModBlocks.MANTEL_ACACIA_LEG_LEFT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(1, 0, 0), ModBlocks.MANTEL_ACACIA_LEG_RIGHT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        }

        if (state.getValue(this.FACING) == Direction.NORTH) {


            level.setBlockAndUpdate(pos.above(), ModBlocks.MANTEL_ACACIA_TOP_MIDDLE.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(1, 1, 0), ModBlocks.MANTEL_ACACIA_TOP_LEFT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(-1, 1, 0), ModBlocks.MANTEL_ACACIA_TOP_RIGHT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(1, 0, 0), ModBlocks.MANTEL_ACACIA_LEG_LEFT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(-1, 0, 0), ModBlocks.MANTEL_ACACIA_LEG_RIGHT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        }

        if (state.getValue(this.FACING) == Direction.EAST) {


            level.setBlockAndUpdate(pos.above(), ModBlocks.MANTEL_ACACIA_TOP_MIDDLE.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(0, 1, 1), ModBlocks.MANTEL_ACACIA_TOP_LEFT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(0, 1, -1), ModBlocks.MANTEL_ACACIA_TOP_RIGHT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(0, 0, 1), ModBlocks.MANTEL_ACACIA_LEG_LEFT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(0, 0, -1), ModBlocks.MANTEL_ACACIA_LEG_RIGHT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        }

        if (state.getValue(this.FACING) == Direction.WEST) {


            level.setBlockAndUpdate(pos.above(), ModBlocks.MANTEL_ACACIA_TOP_MIDDLE.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(0, 1, -1), ModBlocks.MANTEL_ACACIA_TOP_LEFT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(0, 1, 1), ModBlocks.MANTEL_ACACIA_TOP_RIGHT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(0, 0, -1), ModBlocks.MANTEL_ACACIA_LEG_LEFT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos.offset(0, 0, 1), ModBlocks.MANTEL_ACACIA_LEG_RIGHT.get().defaultBlockState().setValue(DIRECTION, placer.getDirection()));

            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        }

    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState pState, Player pPlayer) {

        BlockState blockstate = level.getBlockState(pos);
        BlockState blockstate1 = level.getBlockState(pos.north());
        BlockState blockstate2 = level.getBlockState(pos.south());
        BlockState blockstate3 = level.getBlockState(pos.east());
        BlockState blockstate4 = level.getBlockState(pos.west());


        //CHECK IF FACING EAST-WEST//
        if (blockstate.getBlock() == this && blockstate1.getBlock() == ModBlocks.MANTEL_ACACIA_TOP_RIGHT.get()
             //   || blockstate1.getBlock() == ModBlocks.MANTEL_ACACIA_TOP_RIGHT_STOCKING.get()
                || blockstate.getBlock() == this && blockstate2.getBlock() == ModBlocks.MANTEL_ACACIA_TOP_RIGHT.get()){
            //    || blockstate2.getBlock() == ModBlocks.MANTEL_ACACIA_TOP_RIGHT_STOCKING.get() ){

            level.setBlock(pos.north(), Blocks.AIR.defaultBlockState(), 35);
            level.setBlock(pos.south(), Blocks.AIR.defaultBlockState(), 35);
            level.setBlock(pos.north().below(), Blocks.AIR.defaultBlockState(), 35);
            level.setBlock(pos.south().below(), Blocks.AIR.defaultBlockState(), 35);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 35);
        }
//CHECK IF FACING NORTH/SOUTH//
        if (blockstate.getBlock() == this && blockstate3.getBlock() == ModBlocks.MANTEL_ACACIA_TOP_RIGHT.get()

             //   || blockstate3.getBlock() == ModBlocks.MANTEL_ACACIA_TOP_RIGHT_STOCKING.get()
                || blockstate.getBlock() == this && blockstate4.getBlock() == ModBlocks.MANTEL_ACACIA_TOP_RIGHT.get()){

            //    || blockstate4.getBlock() == ModBlocks.MANTEL_ACACIA_TOP_RIGHT_STOCKING.get()){

            level.setBlock(pos.east(), Blocks.AIR.defaultBlockState(), 35);
            level.setBlock(pos.west(), Blocks.AIR.defaultBlockState(), 35);
            level.setBlock(pos.east().below(), Blocks.AIR.defaultBlockState(), 35);
            level.setBlock(pos.west().below(), Blocks.AIR.defaultBlockState(), 35);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 35);

        }
        super.playerWillDestroy(level, pos, pState, pPlayer);
    }
}
