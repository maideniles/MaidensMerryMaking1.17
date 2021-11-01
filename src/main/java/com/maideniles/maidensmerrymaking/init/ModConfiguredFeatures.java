package com.maideniles.maidensmerrymaking.init;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;


public class ModConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> CHRISTMAS =
            register("christmas", ModFeatures.CHRISTMAS_TREE.get().configured(FeatureConfiguration.NONE));

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?>
    register(String p_243968_0_, ConfiguredFeature<FC, ?> p_243968_1_) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, p_243968_0_, p_243968_1_);
    }
}
