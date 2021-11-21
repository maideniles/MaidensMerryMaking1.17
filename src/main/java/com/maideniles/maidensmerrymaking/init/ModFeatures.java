package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.world.feature.tree.ChristmasSpruce;
import com.maideniles.maidensmerrymaking.world.feature.tree.HollyTreeGen;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES
            = DeferredRegister.create(ForgeRegistries.FEATURES, MaidensMerryMaking.MOD_ID);

    public static RegistryObject<Feature<NoneFeatureConfiguration>> CHRISTMAS_TREE =
            FEATURES.register("christmas_tree", () -> new ChristmasSpruce(NoneFeatureConfiguration.CODEC));

    public static RegistryObject<Feature<NoneFeatureConfiguration>> HOLLY_TREE =
            FEATURES.register("holly_tree", () -> new HollyTreeGen(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
