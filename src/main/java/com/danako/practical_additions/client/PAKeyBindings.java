package com.danako.practical_additions.client;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.network.backpack.OpenBackpackPayload;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.common.NeoForge;

public class PAKeyBindings {

    private static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "main"));

    public static final KeyMapping OPEN_BACKPACK = new KeyMapping("key." + PracticalAdditions.MODID + ".open_backpack", InputConstants.Type.KEYSYM, InputConstants.KEY_B, CATEGORY);

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(PAKeyBindings::registerKeyMappings);
        NeoForge.EVENT_BUS.addListener(PAKeyBindings::onClientTick);
    }

    private static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(OPEN_BACKPACK);
    }

    private static void onClientTick(ClientTickEvent.Post event) {
        while (OPEN_BACKPACK.consumeClick()) {
            ClientPacketDistributor.sendToServer(new OpenBackpackPayload());
        }
    }
}