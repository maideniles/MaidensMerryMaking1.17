package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;
import com.maideniles.maidensmerrymaking.blocks.crop.GingerPlant;
import com.maideniles.maidensmerrymaking.blocks.crop.MintPlant;
import com.maideniles.maidensmerrymaking.blocks.deco.WreathBlock;
import com.maideniles.maidensmerrymaking.blocks.fireplace.mantel.*;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MaidensMerryMaking.MOD_ID);




    public static final RegistryObject<Block> MINT_PLANT = BLOCKS.register("mint_plant",
            () -> new MintPlant(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> GINGER_PLANT = BLOCKS.register("ginger_plant",
            () -> new GingerPlant(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    public static final RegistryObject<Block> CHRISTMAS_WREATH = registerBlock("christmas_wreath",
            () -> new WreathBlock(Block.Properties.of(Material.PLANT).strength(0.5F, 2.0F).sound(SoundType.MOSS_CARPET)), ModItemGroups.MAIDENS_BLOCKS_GROUP);


//ACACIA MANTEL BLOCKS//
    public static final RegistryObject<Block> MANTEL_ACACIA_NORMAL = registerBlock("mantel_normal_acacia",
            () -> new MantelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)), ModItemGroups.MAIDENS_BLOCKS_GROUP);

    public static final RegistryObject<Block> MANTEL_ACACIA_TOP_MIDDLE = BLOCKS.register("mantel_acacia_top_middle_stocking",
            () -> new MantelTopCenterStocking(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)));

    public static final RegistryObject<Block> MANTEL_ACACIA_TOP_LEFT_STOCKING = BLOCKS.register("mantel_acacia_top_left_stocking",
            () -> new MantelTopLeftStocking(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)));

    public static final RegistryObject<Block> MANTEL_ACACIA_TOP_RIGHT_STOCKING = BLOCKS.register("mantel_acacia_top_right_stocking",
            () -> new MantelTopRightStocking(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)));

    public static final RegistryObject<Block> MANTEL_ACACIA_LEG_LEFT = BLOCKS.register("mantel_acacia_leg_left",
            () -> new MantelLegLeft(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)));

    public static final RegistryObject<Block> MANTEL_ACACIA_LEG_RIGHT = BLOCKS.register("mantel_acacia_leg_right",
            () -> new MantelLegRight(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)));


    //ACACIA WITH STOCKING//

/*    public static final RegistryObject<Block> MANTEL_ACACIA_TOP_MIDDLE_STOCKING = BLOCKS.register("mantel_acacia_top_middle_stocking",
            () -> new MantelTopCenterStocking(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)));

    public static final RegistryObject<Block> MANTEL_ACACIA_TOP_RIGHT_STOCKING = BLOCKS.register("mantel_acacia_top_right_stocking",
            () -> new MantelTopRightStocking(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)));

    public static final RegistryObject<Block> MANTEL_ACACIA_TOP_LEFT_STOCKING = BLOCKS.register("mantel_acacia_top_left_stocking",
            () -> new MantelTopLeftStocking(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F)));
*/

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(ModItemGroups.MAIDENS_BLOCKS_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}