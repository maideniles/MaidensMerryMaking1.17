package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.world.gen.feature.tree.PineTree;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModFeatures {

    public static final Feature<NoneFeatureConfiguration> PINE_TREE = registerFeature("pine_tree", new PineTree(NoneFeatureConfiguration.CODEC));

    public static final ConfiguredFeature<?, ?> PINE_TREE_CONFIG = registerConfig("pine_tree_config",
            ModFeatures.PINE_TREE.configured(FeatureConfiguration.NONE).range(Features.Decorators.FULL_RANGE).squared().count(10));


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void registerConfig(FMLCommonSetupEvent event) {
        event.enqueueWork((Runnable) PINE_TREE_CONFIG);
        event.enqueueWork((Runnable) PINE_TREE);
    }

    public static <C extends FeatureConfiguration, F extends Feature<C>> F registerFeature(String pKey, F pValue) {
        return Registry.register(Registry.FEATURE, pKey, pValue);
    }

    public static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> registerConfig(String pId, ConfiguredFeature<FC, ?> pConfiguredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, pId, pConfiguredFeature);
    }
}