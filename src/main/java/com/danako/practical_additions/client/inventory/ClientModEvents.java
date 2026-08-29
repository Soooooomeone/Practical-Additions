package com.danako.practical_additions.client.inventory;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.client.inventory.backpack.BackpackScreen;
import com.danako.practical_additions.client.inventory.advanced_magnet.AdvancedMagnetScreen;
import com.danako.practical_additions.inventory.PAMenuTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = PracticalAdditions.MODID, value = net.neoforged.api.distmarker.Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(PAMenuTypes.ADVANCED_MAGNET_MENU.get(), AdvancedMagnetScreen::new);
        event.register(PAMenuTypes.BASIC_BACKPACK_MENU.get(), BackpackScreen::new);
        event.register(PAMenuTypes.REINFORCED_BACKPACK_MENU.get(), BackpackScreen::new);
    }
}