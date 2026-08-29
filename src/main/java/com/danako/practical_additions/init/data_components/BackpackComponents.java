package com.danako.practical_additions.init.data_components;

import com.danako.practical_additions.PracticalAdditions;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class BackpackComponents {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, PracticalAdditions.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ItemContainerContents>> BACKPACK_CONTENTS = DATA_COMPONENTS.register("backpack_contents", () -> DataComponentType.<ItemContainerContents>builder().persistent(ItemContainerContents.CODEC).networkSynchronized(ItemContainerContents.STREAM_CODEC).build());

    public static void register(IEventBus modEventBus) {
        DATA_COMPONENTS.register(modEventBus);
    }
}
