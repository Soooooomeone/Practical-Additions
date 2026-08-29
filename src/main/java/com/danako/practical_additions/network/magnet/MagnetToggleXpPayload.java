package com.danako.practical_additions.network.magnet;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.inventory.magnet.AdvancedMagnetMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record MagnetToggleXpPayload(int containerId) implements CustomPacketPayload {

    public static final Type<MagnetToggleXpPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "magnet_toggle_xp"));

    public static final StreamCodec<FriendlyByteBuf, MagnetToggleXpPayload> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, MagnetToggleXpPayload::containerId, MagnetToggleXpPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(MagnetToggleXpPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer serverPlayer && serverPlayer.containerMenu.containerId == payload.containerId() && serverPlayer.containerMenu instanceof AdvancedMagnetMenu magnetMenu) {
                magnetMenu.toggleAttractExperience();
            }
        });
    }
}