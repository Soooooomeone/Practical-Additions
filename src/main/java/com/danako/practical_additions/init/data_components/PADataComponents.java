package com.danako.practical_additions.init.data_components;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.common.item.quiver.QuiverContents;
import com.danako.practical_additions.common.item.magnet.MagnetFilterData;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PADataComponents {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, PracticalAdditions.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> MAGNET_ACTIVE = DATA_COMPONENTS.register("magnet_active", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<MagnetFilterData>> MAGNET_FILTER = DATA_COMPONENTS.register("magnet_filter", () -> DataComponentType.<MagnetFilterData>builder().persistent(MagnetFilterData.CODEC).networkSynchronized(MagnetFilterData.STREAM_CODEC).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<QuiverContents>> QUIVER_CONTENTS = DATA_COMPONENTS.register("quiver_contents", () -> DataComponentType.<QuiverContents>builder().persistent(QuiverContents.CODEC).networkSynchronized(QuiverContents.STREAM_CODEC).build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> DIVING_BELT_ACTIVE = DATA_COMPONENTS.register("diving_belt_active", () -> DataComponentType.<Boolean>builder().persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL).build());

    public static void register(IEventBus modEventBus) {
        DATA_COMPONENTS.register(modEventBus);
    }
}