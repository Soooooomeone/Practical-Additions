package com.danako.practical_additions.network.backpack;

import com.danako.practical_additions.PracticalAdditions;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class BackpackNetworking {

    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(PracticalAdditions.MODID).versioned("1.0");
        registrar.playToServer(OpenBackpackPayload.TYPE, OpenBackpackPayload.STREAM_CODEC, OpenBackpackPayload::handle);
    }
}
