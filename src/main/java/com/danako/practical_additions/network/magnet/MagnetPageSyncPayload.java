package com.danako.practical_additions.network.magnet;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.inventory.magnet.AdvancedMagnetMenu;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.List;

public record MagnetPageSyncPayload(int containerId, int page, int pageCount, List<ItemStack> items) implements CustomPacketPayload {

    public static final Type<MagnetPageSyncPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "magnet_page_sync"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MagnetPageSyncPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, MagnetPageSyncPayload::containerId, ByteBufCodecs.VAR_INT, MagnetPageSyncPayload::page, ByteBufCodecs.VAR_INT, MagnetPageSyncPayload::pageCount, ItemStack.OPTIONAL_LIST_STREAM_CODEC, MagnetPageSyncPayload::items, MagnetPageSyncPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MagnetPageSyncPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu.containerId == payload.containerId() && context.player().containerMenu instanceof AdvancedMagnetMenu magnetMenu) {
                magnetMenu.applyPageSync(payload.page(), payload.pageCount(), payload.items());
            }
        });
    }
}