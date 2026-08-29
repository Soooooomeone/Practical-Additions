package com.danako.practical_additions.client.tooltip;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.client.item.quiver.ClientQuiverTooltip;
import com.danako.practical_additions.common.item.quiver.QuiverTooltip;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;

@EventBusSubscriber(modid = PracticalAdditions.MODID, value = Dist.CLIENT)
public class PAClientTooltips {

    @SubscribeEvent
    public static void registerTooltipComponents(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(QuiverTooltip.class, tooltip -> new ClientQuiverTooltip(tooltip.contents(), tooltip.capacity()));
    }
}