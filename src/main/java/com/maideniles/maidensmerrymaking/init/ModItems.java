package com.maideniles.maidensmerrymaking.init;

import com.maideniles.maidensmerrymaking.MaidensMerryMaking;

import com.maideniles.maidensmerrymaking.items.MintBottleItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MaidensMerryMaking.MOD_ID);


    public static final RegistryObject<Item> CHRISTMAS_TREE = ITEMS.register("christmas_tree",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    // public static final RegistryObject<Item> CHRISTMAS_TREE_LIGHTS_WHITE = ITEMS.register("christmas_tree_white_lights",
    //          () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    //  public static final RegistryObject<Item> CHRISTMAS_TREE_LIGHTS_MULTI = ITEMS.register("christmas_tree_multi_lights",
    //         () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> ROOF_TILES= ITEMS.register( "roof_tiles",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));


    //TOPPERS//
    public static final RegistryObject<Item> BOW= ITEMS.register( "bow",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> STAR = ITEMS.register( "star",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> STOCKING = ITEMS.register("stocking",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> MUG = ITEMS.register( "mug",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    //BULBS AND WIRES//
    public static final RegistryObject<Item> MULTI_BULBS = ITEMS.register("multi_bulbs",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> WHITE_BULBS = ITEMS.register( "white_bulbs",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> WHITE_WIRES = ITEMS.register("white_wires",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> GREEN_WIRES = ITEMS.register("green_wires",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    //LIGHT STRANDS//
    public static final RegistryObject<Item> CLASSIC_LIGHTS_WHITE = ITEMS.register("classic_lights_white",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> CLASSIC_LIGHTS_MULTI = ITEMS.register("classic_lights_multi",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> ICICLE_LIGHTS_WHITE = ITEMS.register("icicle_lights_white",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> ICICLE_LIGHTS_MULTI = ITEMS.register("icicle_lights_multi",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> MINI_LIGHTS_WHITE = ITEMS.register("mini_lights_white",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> MINI_LIGHTS_MULTI = ITEMS.register("mini_lights_multi",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> TWINKLING_LIGHTS_WHITE = ITEMS.register("twinkling_lights_white",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> TWINKLING_LIGHTS_MULTI = ITEMS.register("twinkling_lights_multi",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));



    //CROP SEEDS//
    public static final RegistryObject<Item> GINGER_ROOT = ITEMS.register( "ginger_root",
            () ->  new BlockItem(ModBlocks.GINGER_PLANT.get(), (new Item.Properties()).food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> MINT_SEEDS = ITEMS.register("mint_seeds",
            () -> new BlockItem(ModBlocks.MINT_PLANT.get(), new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(1).saturationMod(0.1f).build()).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    //CROP ITEMS//
    public static final RegistryObject<Item> MINT_LEAF = ITEMS.register( "mint_leaf",
            () -> new Item(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    //CHRISTMAS TREATS AND INGREDIENTS//
    public static final RegistryObject<Item>TREE_CHRISTMAS_COOKIE = ITEMS.register("tree_christmas_cookie",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>STOCKING_CHRISTMAS_COOKIE = ITEMS.register("stocking_christmas_cookie",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>MITTEN_CHRISTMAS_COOKIE = ITEMS.register("mitten_christmas_cookie",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));


    public static final RegistryObject<Item>CANDY_CANE = ITEMS.register("candy_cane",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>GINGERBREAD_DOUGH = ITEMS.register("gingerbread_dough",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>COOKIE_DOUGH = ITEMS.register("cookie_dough",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));


    public static final RegistryObject<Item>HOT_COCOA = ITEMS.register("hot_cocoa",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>EGG_NOG = ITEMS.register("egg_nog",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>GINGERBREAD_COOKIE = ITEMS.register("gingerbread_cookie",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>FUDGE = ITEMS.register("fudge",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>PEPPERMINT_COCOA = ITEMS.register("peppermint_cocoa",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>PEPPERMINT_EXTRACT = ITEMS.register("peppermint_extract",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>GROUND_GINGER = ITEMS.register("ground_ginger",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>ICING = ITEMS.register("icing",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item>FRUITCAKE = ITEMS.register("fruitcake",
            () -> new Item(new Item.Properties().food(Foods.APPLE).tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));

    public static final RegistryObject<Item> BOTTLE_OF_MINT = ITEMS.register("bottle_of_mint",
            () -> new MintBottleItem(new Item.Properties().tab(ModItemGroups.MAIDENS_ITEMS_GROUP)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
