package com.danako.practical_additions.client.render;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.client.item.kevlar_shield.KevlarShieldSpecialRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterSpecialModelRendererEvent;

@EventBusSubscriber(modid = PracticalAdditions.MODID, value = Dist.CLIENT)
public class PAClientModelEvents {

    @SubscribeEvent
    public static void registerSpecialRenderers(RegisterSpecialModelRendererEvent event) {
        event.register(
                Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "kevlar_shield"),
                KevlarShieldSpecialRenderer.Unbaked.MAP_CODEC
        );
    }
}