package com.danako.practical_additions.network.backpack;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.common.item.backpack.BackpackItem;
import com.danako.practical_additions.util.magnet.BackpackUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record OpenBackpackPayload() implements CustomPacketPayload {

    public static final Type<OpenBackpackPayload> TYPE =
            new Type<>(Identifier.fromNamespaceAndPath(PracticalAdditions.MODID, "open_backpack"));

    public static final StreamCodec<RegistryFriendlyByteBuf, OpenBackpackPayload> STREAM_CODEC =
            StreamCodec.unit(new OpenBackpackPayload());

    public static void handle(OpenBackpackPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (!(context.player() instanceof ServerPlayer serverPlayer)) {
                return;
            }
            ItemStack backpack = BackpackUtil.findBackpack(serverPlayer);
            if (!backpack.isEmpty() && backpack.getItem() instanceof BackpackItem backpackItem) {
                backpackItem.openBackpack(serverPlayer, backpack);
            }
        });
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
