package com.danako.practical_additions.client;

import com.danako.practical_additions.PracticalAdditions;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = PracticalAdditions.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = PracticalAdditions.MODID, value = Dist.CLIENT)
public class PracticalAdditionsClient {
    public PracticalAdditionsClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
