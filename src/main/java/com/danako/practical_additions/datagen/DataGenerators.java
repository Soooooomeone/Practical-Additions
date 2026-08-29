package com.danako.practical_additions.datagen;

import com.danako.practical_additions.datagen.curios.PACuriosDataProvider;
import com.danako.practical_additions.datagen.misc.PALanguageProvider;
import com.danako.practical_additions.datagen.misc.PARecipeProvider;
import com.danako.practical_additions.datagen.model.PAEquipmentAssetProvider;
import com.danako.practical_additions.datagen.model.PAModelProvider;
import com.danako.practical_additions.datagen.tags.PABlockTagsProvider;
import com.danako.practical_additions.datagen.tags.PAItemTagsProvider;
import com.danako.practical_additions.datagen.worldgen.PALootTableProvider;
import com.danako.practical_additions.datagen.worldgen.PAWorldGenProvider;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(DataGenerators::gatherClientData);
    }

    public static void gatherClientData(GatherDataEvent.Client event) {
        event.createProvider(PAModelProvider::new);
        event.createProvider(PAEquipmentAssetProvider::new);
        event.createProvider(PALanguageProvider::new);
        event.createProvider(PACuriosDataProvider::new);
        event.createDatapackRegistryObjects(PAWorldGenProvider.BUILDER);
        event.createBlockAndItemTags(PABlockTagsProvider::new, PAItemTagsProvider::new);
        event.createProvider(PALootTableProvider::new);
        event.createProvider(PARecipeProvider.Runner::new);
    }
}