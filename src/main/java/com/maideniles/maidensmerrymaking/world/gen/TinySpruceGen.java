package com.maideniles.maidensmerrymaking.world.gen;

import com.maideniles.maidensmerrymaking.init.ModConfiguredFeatures;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class TinySpruceGen {
    public static void setupTreeGen(final BiomeLoadingEvent event) {
        if (event.getCategory().equals(Biome.BiomeCategory.TAIGA) || event.getCategory().equals(Biome.BiomeCategory.ICY)) {
            ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
            Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

            List<Supplier<ConfiguredFeature<?, ?>>> base =
                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

            base.add(() -> ModConfiguredFeatures.CHRISTMAS
                    .decorated(Features.Decorators.HEIGHTMAP_SQUARE).count(1)
                    .decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration
                            (1, 0.5f,2))));
        }
    }
}