package com.danako.practical_additions.common.item.music_disc;

import com.danako.practical_additions.PracticalAdditions;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(PracticalAdditions.MODID);

    public static final DeferredItem<Item> BOB_MARLEY_MUSIC_DISC = ITEMS.registerItem("bobmarley_music_disc",
            props -> new Item(props
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(ResourceKey.create(
                            Registries.JUKEBOX_SONG,
                            Identifier.fromNamespaceAndPath("practical_additions", "bobmarley")
                    ))
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}