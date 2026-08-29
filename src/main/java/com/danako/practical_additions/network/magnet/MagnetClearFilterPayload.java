package com.danako.practical_additions.network.magnet;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.inventory.magnet.AdvancedMagnetMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MagnetClearFilterPayload(int containerId) implements CustomPacketPayload {

    public static final Type<MagnetClearFilterPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "magnet_clear_filter"));

    public static final StreamCodec<FriendlyByteBuf, MagnetClearFilterPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, MagnetClearFilterPayload::containerId, MagnetClearFilterPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MagnetClearFilterPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer serverPlayer && serverPlayer.containerMenu.containerId == payload.containerId() && serverPlayer.containerMenu instanceof AdvancedMagnetMenu magnetMenu) {
                magnetMenu.clearAllEntries();
                PacketDistributor.sendToPlayer(serverPlayer, new MagnetPageSyncPayload(magnetMenu.containerId, magnetMenu.getCurrentPage(), magnetMenu.getPageCount(), magnetMenu.currentPageItemsSnapshot()));
            }
        });
    }
}