package com.danako.practical_additions.common.sound;

import com.danako.practical_additions.PracticalAdditions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, PracticalAdditions.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> BOB_MARLEY_SOUND =
            SOUND_EVENTS.register("bobmarley",
                    () -> SoundEvent.createVariableRangeEvent(
                            Identifier.fromNamespaceAndPath("practical_additions", "bobmarley")
                    ));

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}