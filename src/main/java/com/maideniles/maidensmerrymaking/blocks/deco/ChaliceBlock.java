package com.maideniles.maidensmerrymaking.blocks.deco;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChaliceBlock extends HorizontalDecoBlock{
    protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D);


    public ChaliceBlock(Properties properties) {
        super(properties);
    }

    public static VoxelShape getSHAPE() {
        return SHAPE;
    }
}
