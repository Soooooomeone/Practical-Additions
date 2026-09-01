package com.danako.practical_additions;


import com.danako.practical_additions.client.inventory.backpack.PABackpackClient;
import com.danako.practical_additions.common.item.music_disc.ModItems;
import com.danako.practical_additions.common.sound.ModSounds;
import com.danako.practical_additions.config.PAConfig;
import com.danako.practical_additions.datagen.DataGenerators;
import com.danako.practical_additions.init.*;
import com.danako.practical_additions.init.creative_tab.PACreativeModeTabs;
import com.danako.practical_additions.init.creative_tab.PACreativeTabAdditions;
import com.danako.practical_additions.init.data_components.BackpackComponents;
import com.danako.practical_additions.init.data_components.PADataComponents;
import com.danako.practical_additions.init.event_handler.PAEventsHandler;
import com.danako.practical_additions.inventory.PAMenuTypes;
import com.danako.practical_additions.network.backpack.BackpackNetworking;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod(PracticalAdditions.MODID)
public class PracticalAdditions {
    public static final String MODID = "practical_additions";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public PracticalAdditions(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(DataGenerators::gatherClientData);
        modEventBus.addListener(BackpackNetworking::register);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        PACreativeTabAdditions.register(modEventBus);
        PADataComponents.register(modEventBus);
        BackpackComponents.register(modEventBus);
        PAMenuTypes.register(modEventBus);
        PABackpackClient.register(modEventBus);
        ModItems.register(modEventBus);
        ModSounds.register(modEventBus);
        PABlocks.register();
        PAItems.register();
        PACreativeModeTabs.register();
        PAEventsHandler.register();

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, PAConfig.COMMON_SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Practical Additions common setup complete");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}