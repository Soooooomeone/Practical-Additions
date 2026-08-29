package com.danako.practical_additions.client.inventory.backpack;

import com.danako.practical_additions.client.PAKeyBindings;
import com.danako.practical_additions.client.item.backpack.BackpackCurioRenderer;
import com.danako.practical_additions.init.PAItems;
import com.danako.practical_additions.model.backpack.Backpack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class PABackpackClient {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(PABackpackClient::registerLayers);
        modEventBus.addListener(PABackpackClient::clientSetup);
        PAKeyBindings.register(modEventBus);
    }

    private static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(Backpack.LAYER_LOCATION, Backpack::createBodyLayer);
    }

    private static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            BackpackCurioRenderer renderer = new BackpackCurioRenderer();
            ICurioRenderer.register(PAItems.BASIC_BACKPACK.get(), () -> renderer);
            ICurioRenderer.register(PAItems.REINFORCED_BACKPACK.get(), () -> renderer);
        });
    }
}