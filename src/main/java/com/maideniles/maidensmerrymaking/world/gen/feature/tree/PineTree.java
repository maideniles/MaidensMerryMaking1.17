package com.maideniles.maidensmerrymaking.world.gen.feature.tree;

import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class PineTree extends Feature<NoneFeatureConfiguration> {
    public PineTree(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }
    @Override
        public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        BlockPos blockpos = pContext.origin();
        WorldGenLevel worldgenlevel = pContext.level();

        this.setBlock( worldgenlevel, blockpos, ModBlocks.TREE.get().defaultBlockState());
        this.setBlock(worldgenlevel, blockpos.offset(0,1,0), ModBlocks.TREE_MIDDLE.get().defaultBlockState());
        this.setBlock(worldgenlevel, blockpos.offset(0, 2, 0), ModBlocks.TREE_TOP.get().defaultBlockState());
        return true;
    }
    protected void setBlock(LevelWriter level, BlockPos pos, BlockState state) {
        level.setBlock(pos, state, 3);
    }
}





