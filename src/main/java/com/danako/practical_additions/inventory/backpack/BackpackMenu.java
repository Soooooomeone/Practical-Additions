package com.danako.practical_additions.inventory.backpack;

import com.danako.practical_additions.common.item.backpack.BackpackItem;
import com.danako.practical_additions.init.data_components.BackpackComponents;
import com.danako.practical_additions.util.magnet.BackpackUtil;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;

public class BackpackMenu extends AbstractContainerMenu {

    private final ItemStack backpackStack;
    private final int backpackSize;
    private final BackpackContainer backpackContainer;

    public BackpackMenu(MenuType<BackpackMenu> type, int containerId, Inventory playerInventory, int backpackSize) {
        this(type, containerId, playerInventory, ItemStack.EMPTY, backpackSize);
    }

    public BackpackMenu(MenuType<BackpackMenu> type, int containerId, Inventory playerInventory, ItemStack backpackStack, int backpackSize) {
        super(type, containerId);
        this.backpackStack = backpackStack;
        this.backpackSize = backpackSize;
        this.backpackContainer = new BackpackContainer(readContents(backpackStack, backpackSize));

        int rows = backpackSize / 9;
        int gridX = 9;
        int gridY = 18;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new BackpackSlot(backpackContainer, col + row * 9, gridX + col * 18, gridY + row * 18));
            }
        }

        int invY = gridY + rows * 18 + 13;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(playerInventory, col + row * 9 + 9, gridX + col * 18, invY + row * 18));
            }
        }
        int hotbarY = invY + 3 * 18 + 4;
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(playerInventory, col, gridX + col * 18, hotbarY));
        }
    }

    public int getBackpackSlotCount() {
        return backpackSize;
    }

    private static NonNullList<ItemStack> readContents(ItemStack stack, int size) {
        NonNullList<ItemStack> items = NonNullList.withSize(size, ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            ItemContainerContents contents = stack.getOrDefault(BackpackComponents.BACKPACK_CONTENTS.get(), ItemContainerContents.EMPTY);
            contents.copyInto(items);
        }
        return items;
    }

    private void saveContents() {
        if (backpackStack.isEmpty()) {
            return;
        }
        NonNullList<ItemStack> snapshot = NonNullList.withSize(backpackSize, ItemStack.EMPTY);
        for (int i = 0; i < backpackSize; i++) {
            snapshot.set(i, backpackContainer.getItem(i).copy());
        }
        backpackStack.set(BackpackComponents.BACKPACK_CONTENTS.get(), ItemContainerContents.fromItems(snapshot));
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot slot = slots.get(index);
        if (slot == null || !slot.hasItem()) {
            return ItemStack.EMPTY;
        }
        ItemStack original = slot.getItem();
        ItemStack result = original.copy();
        if (index < backpackSize) {
            if (!moveItemStackTo(original, backpackSize, slots.size(), true)) {
                return ItemStack.EMPTY;
            }
        } else {
            if (!moveItemStackTo(original, 0, backpackSize, false)) {
                return ItemStack.EMPTY;
            }
        }
        if (original.isEmpty()) {
            slot.set(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }
        return result;
    }

    @Override
    public boolean stillValid(Player player) {
        if (backpackStack.isEmpty()) {
            return true;
        }
        return BackpackUtil.isBackpackAccessible(player, backpackStack);
    }

    private class BackpackSlot extends Slot {
        BackpackSlot(Container container, int index, int x, int y) {
            super(container, index, x, y);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return !(stack.getItem() instanceof BackpackItem);
        }
    }

    private class BackpackContainer implements Container {
        private final NonNullList<ItemStack> items;

        BackpackContainer(NonNullList<ItemStack> items) {
            this.items = items;
        }

        @Override
        public int getContainerSize() {
            return items.size();
        }

        @Override
        public boolean isEmpty() {
            return items.stream().allMatch(ItemStack::isEmpty);
        }

        @Override
        public ItemStack getItem(int index) {
            return items.get(index);
        }

        @Override
        public ItemStack removeItem(int index, int count) {
            ItemStack result = ContainerHelper.removeItem(items, index, count);
            if (!result.isEmpty()) {
                setChanged();
            }
            return result;
        }

        @Override
        public ItemStack removeItemNoUpdate(int index) {
            ItemStack existing = items.get(index);
            items.set(index, ItemStack.EMPTY);
            return existing;
        }

        @Override
        public void setItem(int index, ItemStack stack) {
            items.set(index, stack);
            if (stack.getCount() > getMaxStackSize()) {
                stack.setCount(getMaxStackSize());
            }
            setChanged();
        }

        @Override
        public void setChanged() {
            saveContents();
        }

        @Override
        public boolean stillValid(Player player) {
            return BackpackMenu.this.stillValid(player);
        }

        @Override
        public void clearContent() {
            items.replaceAll(stack -> ItemStack.EMPTY);
            setChanged();
        }
    }
}