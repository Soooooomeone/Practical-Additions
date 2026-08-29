package com.danako.practical_additions.network;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.network.magnet.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = PracticalAdditions.MODID)
public class PAPayloads {

    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(PracticalAdditions.MODID).versioned("1.0.0");
        registrar.playToServer(MagnetFilterModePayload.TYPE, MagnetFilterModePayload.STREAM_CODEC, MagnetFilterModePayload::handle);
        registrar.playToServer(MagnetToggleXpPayload.TYPE, MagnetToggleXpPayload.STREAM_CODEC, MagnetToggleXpPayload::handle);
        registrar.playToServer(MagnetPageChangePayload.TYPE, MagnetPageChangePayload.STREAM_CODEC, MagnetPageChangePayload::handle);
        registrar.playToServer(MagnetClearFilterPayload.TYPE, MagnetClearFilterPayload.STREAM_CODEC, MagnetClearFilterPayload::handle);
        registrar.playToClient(MagnetPageSyncPayload.TYPE, MagnetPageSyncPayload.STREAM_CODEC, MagnetPageSyncPayload::handle);
    }
}