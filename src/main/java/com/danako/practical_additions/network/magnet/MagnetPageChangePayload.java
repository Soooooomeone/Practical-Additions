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

public record MagnetPageChangePayload(int containerId, boolean next) implements CustomPacketPayload {

    public static final Type<MagnetPageChangePayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "magnet_page_change"));
    public static final StreamCodec<FriendlyByteBuf, MagnetPageChangePayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, MagnetPageChangePayload::containerId, ByteBufCodecs.BOOL, MagnetPageChangePayload::next, MagnetPageChangePayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MagnetPageChangePayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer serverPlayer && serverPlayer.containerMenu.containerId == payload.containerId() && serverPlayer.containerMenu instanceof AdvancedMagnetMenu magnetMenu) {
                if (payload.next()) {
                    magnetMenu.nextPage();
                } else {
                    magnetMenu.previousPage();
                }
                PacketDistributor.sendToPlayer(serverPlayer, new MagnetPageSyncPayload(magnetMenu.containerId, magnetMenu.getCurrentPage(), magnetMenu.getPageCount(), magnetMenu.currentPageItemsSnapshot()));
            }
        });
    }
}