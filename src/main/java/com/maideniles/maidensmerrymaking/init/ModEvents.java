package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.event.Disc2DungeonModifier;
import com.maideniles.maidensmerrymaking.event.DiscDungeonModifier;
import com.maideniles.maidensmerrymaking.event.SpruceLeavesConverterModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid= MaidensMerryMaking.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event){

        event.getRegistry().register(new SpruceLeavesConverterModifier.Serializer().setRegistryName
                (new ResourceLocation(MaidensMerryMaking.MOD_ID, "spruce_leaves_drop_tiny_sapling")));

        event.getRegistry().register(new DiscDungeonModifier.Serializer().setRegistryName
                (new ResourceLocation(MaidensMerryMaking.MOD_ID,"disc_in_igloo")));

        event.getRegistry().register(new Disc2DungeonModifier.Serializer().setRegistryName
                (new ResourceLocation(MaidensMerryMaking.MOD_ID,"disc_2_in_chests")));


    }



}
