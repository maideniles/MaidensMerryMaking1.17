package com.maideniles.maidensmerrymaking.blocks.lamppost;

import com.maideniles.maidensmerrymaking.blocks.deco.HorizontalDecoBlock;
import com.maideniles.maidensmerrymaking.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LampPostBottom extends HorizontalDecoBlock {

    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public LampPostBottom(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter p_48946_, BlockPos p_48947_, CollisionContext p_48948_) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_49573_) {
        return this.defaultBlockState().setValue(FACING, p_49573_.getHorizontalDirection());
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {



        BlockState above = level.getBlockState(pos.above());
        BlockState up2 = level.getBlockState(pos.above(2));

//IF THE BLOCK ABOVE IS THE LAMP,
        if (above.getBlock() == ModBlocks.LAMP_POST.get()) {

            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(),3);  //CHANGE LAMP TO AIR

            level.setBlock(pos, ModBlocks.LAMP_POST.get().defaultBlockState().setValue(FACING, state.getValue(FACING)),3);
            //MOVE LAMP DOWN
        }


        if (above.getBlock() instanceof LampPostPole && up2.getBlock() == ModBlocks.LAMP_POST.get() || up2.getBlock()== ModBlocks.LAMP_POST_ON.get()) {

            //PLACE BOTTOM UNDER LAMP
            level.setBlock(pos, Blocks.AIR.defaultBlockState(),3);
            //MOVE LAMP DOWN
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(),3);
            //CHANGE LAMP TO AIR
            level.setBlock(pos.above().above(), Blocks.AIR.defaultBlockState(),3);


            popResource(level, pos, new ItemStack(Item.byBlock(ModBlocks.LAMP_POST.get()))); //SPAWN THE LAMP//


            popResource(level, pos, new ItemStack(Items.TORCH));//SPAWN THE TORCH//

        }
    }

}
