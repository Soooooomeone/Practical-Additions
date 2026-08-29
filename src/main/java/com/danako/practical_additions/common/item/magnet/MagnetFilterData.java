package com.danako.practical_additions.common.item.magnet;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public record MagnetFilterData(boolean whitelist, boolean attractExperience, NonNullList<ItemStack> items) {

    public static final int PAGE_SIZE = 9;
    public static final MagnetFilterData EMPTY = new MagnetFilterData(false, true, NonNullList.withSize(PAGE_SIZE, ItemStack.EMPTY));
    public static final Codec<MagnetFilterData> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.BOOL.fieldOf("whitelist").forGetter(MagnetFilterData::whitelist), Codec.BOOL.fieldOf("attract_experience").forGetter(MagnetFilterData::attractExperience), ItemStack.OPTIONAL_CODEC.listOf().xmap(MagnetFilterData::toPagedList, List::copyOf).fieldOf("items").forGetter(MagnetFilterData::items)).apply(instance, MagnetFilterData::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, MagnetFilterData> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.BOOL, MagnetFilterData::whitelist, ByteBufCodecs.BOOL, MagnetFilterData::attractExperience, ItemStack.OPTIONAL_LIST_STREAM_CODEC.map(MagnetFilterData::toPagedList, List::copyOf), MagnetFilterData::items, MagnetFilterData::new);

    private static NonNullList<ItemStack> toPagedList(List<ItemStack> source) {
        int pages = Math.max(1, (source.size() + PAGE_SIZE - 1) / PAGE_SIZE);
        int size = pages * PAGE_SIZE;
        NonNullList<ItemStack> fixed = NonNullList.withSize(size, ItemStack.EMPTY);
        for (int i = 0; i < Math.min(source.size(), size); i++) {
            ItemStack stack = source.get(i);
            fixed.set(i, stack == null ? ItemStack.EMPTY : stack);
        }
        return fixed;
    }

    public boolean allows(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }
        boolean matchesAnEntry = false;
        for (ItemStack filterEntry : items) {
            if (!filterEntry.isEmpty() && filterEntry.is(stack.getItem())) {
                matchesAnEntry = true;
                break;
            }
        }
        return whitelist == matchesAnEntry;
    }
}