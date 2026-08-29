package com.danako.practical_additions.common.item.quiver;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.math.Fraction;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public final class QuiverContents implements TooltipComponent {

    public static final QuiverContents EMPTY = new QuiverContents(List.of());

    public static final Codec<QuiverContents> CODEC = ItemStack.CODEC.listOf().flatXmap(QuiverContents::checkAndCreate, contents -> DataResult.success(contents.items));

    public static final StreamCodec<RegistryFriendlyByteBuf, QuiverContents> STREAM_CODEC = ItemStack.STREAM_CODEC.apply(ByteBufCodecs.list()).map(QuiverContents::new, contents -> contents.items);

    public static final int NO_SELECTED_ITEM_INDEX = -1;

    final List<ItemStack> items;
    final Fraction weight;
    final int selectedItem;

    QuiverContents(List<ItemStack> items, Fraction weight, int selectedItem) {
        this.items = items;
        this.weight = weight;
        this.selectedItem = selectedItem;
    }

    public QuiverContents(List<ItemStack> items) {
        this(items, computeContentWeight(items), NO_SELECTED_ITEM_INDEX);
    }

    private static DataResult<QuiverContents> checkAndCreate(List<ItemStack> items) {
        try {
            Fraction fraction = computeContentWeight(items);
            return DataResult.success(new QuiverContents(items, fraction, NO_SELECTED_ITEM_INDEX));
        } catch (ArithmeticException e) {
            return DataResult.error(() -> "Excessive total quiver weight");
        }
    }

    private static Fraction computeContentWeight(List<ItemStack> content) {
        Fraction fraction = Fraction.ZERO;
        for (ItemStack stack : content) {
            fraction = fraction.add(getWeight(stack).multiplyBy(Fraction.getFraction(stack.getCount(), 1)));
        }
        return fraction;
    }

    static Fraction getWeight(ItemStack stack) {
        return Fraction.getFraction(1, stack.getMaxStackSize());
    }

    public static boolean canItemBeInQuiver(ItemStack stack) {
        return !stack.isEmpty() && stack.is(ItemTags.ARROWS);
    }

    public int getNumberOfItemsToShow() {
        int i = this.size();
        int j = i > 12 ? 11 : 12;
        int k = i % 4;
        int l = k == 0 ? 0 : 4 - k;
        return Math.min(i, j - l);
    }

    public ItemStack getItemUnsafe(int index) {
        return this.items.get(index);
    }

    public Stream<ItemStack> itemCopyStream() {
        return this.items.stream().map(ItemStack::copy);
    }

    public Iterable<ItemStack> items() {
        return this.items;
    }

    public Iterable<ItemStack> itemsCopy() {
        return Lists.transform(this.items, ItemStack::copy);
    }

    public int size() {
        return this.items.size();
    }

    public Fraction weight() {
        return this.weight;
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public int getSelectedItem() {
        return this.selectedItem;
    }

    public boolean hasSelectedItem() {
        return this.selectedItem != NO_SELECTED_ITEM_INDEX;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuiverContents that)) {
            return false;
        }
        return this.weight.equals(that.weight) && ItemStack.listMatches(this.items, that.items);
    }

    @Override
    public int hashCode() {
        return ItemStack.hashStackList(this.items);
    }

    @Override
    public String toString() {
        return "QuiverContents" + this.items;
    }

    public ItemStack peekTopArrow() {
        return this.items.isEmpty() ? ItemStack.EMPTY : this.items.get(0);
    }

    public QuiverContents recomputeIfNeeded() {
        boolean needsPrune = false;
        Fraction newWeight = Fraction.ZERO;
        for (ItemStack stack : this.items) {
            if (stack.isEmpty()) {
                needsPrune = true;
                continue;
            }
            newWeight = newWeight.add(getWeight(stack).multiplyBy(Fraction.getFraction(stack.getCount(), 1)));
        }

        if (!needsPrune && newWeight.equals(this.weight)) {
            return this;
        }

        List<ItemStack> newItems = needsPrune ? this.items.stream().filter(stack -> !stack.isEmpty()).toList() : this.items;
        int newSelected = (this.selectedItem < 0 || this.selectedItem >= newItems.size()) ? NO_SELECTED_ITEM_INDEX : this.selectedItem;

        return new QuiverContents(newItems, newWeight, newSelected);
    }

    public static class Mutable {
        private final List<ItemStack> items;
        private Fraction weight;
        private int selectedItem;
        private final Fraction capacity;

        public Mutable(QuiverContents contents, Fraction capacity) {
            this.items = new ArrayList<>(contents.items);
            this.weight = contents.weight;
            this.selectedItem = contents.selectedItem;
            this.capacity = capacity;
        }

        public QuiverContents.Mutable clearItems() {
            this.items.clear();
            this.weight = Fraction.ZERO;
            this.selectedItem = NO_SELECTED_ITEM_INDEX;
            return this;
        }

        private int findStackWithRoom(ItemStack stack) {
            if (!stack.isStackable()) {
                return -1;
            }
            for (int i = 0; i < this.items.size(); i++) {
                ItemStack existing = this.items.get(i);
                if (existing.getCount() < existing.getMaxStackSize() && ItemStack.isSameItemSameComponents(existing, stack)) {
                    return i;
                }
            }
            return -1;
        }

        private int getMaxAmountToAdd(ItemStack stack) {
            Fraction remaining = this.capacity.subtract(this.weight);
            if (remaining.compareTo(Fraction.ZERO) <= 0) {
                return 0;
            }
            return Math.max(remaining.divideBy(QuiverContents.getWeight(stack)).intValue(), 0);
        }

        public int tryInsert(ItemStack stack) {
            if (!QuiverContents.canItemBeInQuiver(stack)) {
                return 0;
            }
            int totalToAdd = Math.min(stack.getCount(), this.getMaxAmountToAdd(stack));
            if (totalToAdd == 0) {
                return 0;
            }

            int maxStackSize = stack.getMaxStackSize();
            int remaining = totalToAdd;

            int topUpIndex = this.findStackWithRoom(stack);
            if (topUpIndex != -1) {
                ItemStack existing = this.items.get(topUpIndex);
                int room = maxStackSize - existing.getCount();
                int addHere = Math.min(room, remaining);
                this.items.set(topUpIndex, existing.copyWithCount(existing.getCount() + addHere));
                remaining -= addHere;
            }

            while (remaining > 0) {
                int chunk = Math.min(remaining, maxStackSize);
                this.items.add(0, stack.copyWithCount(chunk));
                remaining -= chunk;
            }

            this.weight = this.weight.add(QuiverContents.getWeight(stack).multiplyBy(Fraction.getFraction(totalToAdd, 1)));
            stack.shrink(totalToAdd);
            return totalToAdd;
        }

        public int tryTransfer(Slot slot, Player player) {
            ItemStack stack = slot.getItem();
            int max = this.getMaxAmountToAdd(stack);
            return QuiverContents.canItemBeInQuiver(stack) ? this.tryInsert(slot.safeTake(stack.getCount(), max, player)) : 0;
        }

        public void toggleSelectedItem(int selectedItem) {
            this.selectedItem = this.selectedItem != selectedItem && !this.indexIsOutsideAllowedBounds(selectedItem) ? selectedItem : NO_SELECTED_ITEM_INDEX;
        }

        private boolean indexIsOutsideAllowedBounds(int index) {
            return index < 0 || index >= this.items.size();
        }

        public @Nullable ItemStack removeOne() {
            if (this.items.isEmpty()) {
                return null;
            }
            int index = this.indexIsOutsideAllowedBounds(this.selectedItem) ? 0 : this.selectedItem;
            ItemStack stack = this.items.remove(index).copy();
            this.weight = this.weight.subtract(QuiverContents.getWeight(stack).multiplyBy(Fraction.getFraction(stack.getCount(), 1)));
            this.toggleSelectedItem(NO_SELECTED_ITEM_INDEX);
            return stack;
        }

        public Fraction weight() {
            return this.weight;
        }

        public QuiverContents toImmutable() {
            return new QuiverContents(List.copyOf(this.items), this.weight, this.selectedItem);
        }
    }
}