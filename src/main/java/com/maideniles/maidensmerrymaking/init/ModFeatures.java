package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.world.gen.feature.tree.ChristmasPineTree;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModFeatures {

    public static final Feature<NoneFeatureConfiguration> PINE_TREE = register("pine_tree", new ChristmasPineTree(NoneFeatureConfiguration.CODEC));


    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String pKey, F pValue) {
        return Registry.register(Registry.FEATURE, pKey, pValue);
    }
}