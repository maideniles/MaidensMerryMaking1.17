package com.maideniles.maidensmerrymaking;

import com.maideniles.maidensmerrymaking.init.ModBlocks;
import com.maideniles.maidensmerrymaking.init.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MaidensMerryMaking.MOD_ID)
public class MaidensMerryMaking {
    public static final String MOD_ID = "maidensmerrymaking";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

 /*   public static final CreativeModeTab MAIDENS_BLOCKS_GROUP = new CreativeModeTab("maidens_blocks_group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.AMETHYST_BLOCK);
        }
    };

    public static final CreativeModeTab MAIDENS_ITEMS_GROUP = new CreativeModeTab("maidens_items_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.AMETHYST_SHARD);
        }
    };
*/


    public MaidensMerryMaking() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // add a comment
    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
