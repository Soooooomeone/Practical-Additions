package com.danako.practical_additions.inventory.magnet;
import com.danako.practical_additions.common.item.magnet.MagnetFilterData;
import com.danako.practical_additions.init.data_components.PADataComponents;
import com.danako.practical_additions.inventory.PAMenuTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import java.util.ArrayList;
import java.util.List;
public class AdvancedMagnetMenu extends AbstractContainerMenu {
    public static final int PAGE_SIZE = MagnetFilterData.PAGE_SIZE;
    private static final int MAIN_INV_SIZE = 27;
    private final ItemStack magnetStack;
    private final PagedFilterContainer filterContainer;
    private final ContainerData data;
    public AdvancedMagnetMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, ItemStack.EMPTY);
    }
    public AdvancedMagnetMenu(int containerId, Inventory playerInventory, ItemStack magnetStack) {
        super(PAMenuTypes.ADVANCED_MAGNET_MENU.get(), containerId);
        this.magnetStack = magnetStack;
        MagnetFilterData filterData = magnetStack.getOrDefault(PADataComponents.MAGNET_FILTER.get(), MagnetFilterData.EMPTY);
        this.filterContainer = new PagedFilterContainer(filterData.items());
        this.data = new SimpleContainerData(4);
        this.data.set(0, filterData.whitelist() ? 1 : 0);
        this.data.set(1, filterData.attractExperience() ? 1 : 0);
        this.data.set(2, 0);
        this.data.set(3, filterContainer.getContainerSize());
        addDataSlots(data);
        int gridX = 107, gridY = 13;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int localIndex = row * 3 + col;
                addSlot(new PagedFilterSlot(localIndex, gridX + col * 18 + 1, gridY + row * 18 + 1));
            }
        }
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(playerInventory, col + row * 9 + 9, 9 + col * 18, 85 + row * 18));
            }
        }
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(playerInventory, col, 9 + col * 18, 143));
        }
    }
    public boolean isWhitelist() {
        return data.get(0) == 1;
    }
    public void toggleMode() {
        boolean newValue = !isWhitelist();
        data.set(0, newValue ? 1 : 0);
        writeFilterToStack(newValue, isAttractExperience(), currentItemsSnapshot());
    }
    public boolean isAttractExperience() {
        return data.get(1) == 1;
    }
    public void toggleAttractExperience() {
        boolean newValue = !isAttractExperience();
        data.set(1, newValue ? 1 : 0);
        writeFilterToStack(isWhitelist(), newValue, currentItemsSnapshot());
    }
    public int getCurrentPage() {
        return data.get(2);
    }
    public int getPageCount() {
        return Math.max(1, data.get(3) / PAGE_SIZE);
    }
    public boolean isPageFull(int page) {
        int base = page * PAGE_SIZE;
        for (int i = 0; i < PAGE_SIZE; i++) {
            if (filterContainer.getItem(base + i).isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public boolean canGoToNextPage() {
        return getCurrentPage() < getPageCount() - 1;
    }
    public boolean canGoToPreviousPage() {
        return getCurrentPage() > 0;
    }
    public void nextPage() {
        if (canGoToNextPage()) {
            data.set(2, getCurrentPage() + 1);
        }
        balancePages();
    }
    public void previousPage() {
        if (canGoToPreviousPage()) {
            data.set(2, getCurrentPage() - 1);
        }
        balancePages();
    }
    public void applyPageSync(int page, int pageCount, List<ItemStack> items) {
        data.set(2, page);
        data.set(3, pageCount * PAGE_SIZE);
        filterContainer.setPageContentsSilently(page, items);
    }
    public List<ItemStack> currentPageItemsSnapshot() {
        List<ItemStack> pageItems = new ArrayList<>(PAGE_SIZE);
        int base = getCurrentPage() * PAGE_SIZE;
        for (int i = 0; i < PAGE_SIZE; i++) {
            pageItems.add(filterContainer.getItem(base + i).copy());
        }
        return pageItems;
    }
    public void clearAllEntries() {
        filterContainer.resetToSinglePage();
        data.set(2, 0);
        saveFilterItems();
    }
    @Override
    public void clicked(int slotId, int button, ClickType clickType, Player player) {
        if (isFilterSlotId(slotId)) {
            if (clickType == ClickType.PICKUP && button == 1) {
                handleFilterSlotRightClick(slotId);
            }
            return;
        }
        if (clickType == ClickType.QUICK_MOVE && button == 1 && slotId >= 0 && slotId < slots.size()) {
            Slot slot = slots.get(slotId);
            if (slot.hasItem()) {
                tryAddFilterEntry(slot.getItem());
            }
            return;
        }
        super.clicked(slotId, button, clickType, player);
    }
    private boolean isFilterSlotId(int slotId) {
        return slotId >= 0 && slotId < PAGE_SIZE;
    }
    private void handleFilterSlotRightClick(int localIndex) {
        int realIndex = getCurrentPage() * PAGE_SIZE + localIndex;
        if (realIndex >= filterContainer.getContainerSize()) {
            return;
        }
        ItemStack existing = filterContainer.getItem(realIndex);
        if (!existing.isEmpty()) {
            filterContainer.setItem(realIndex, ItemStack.EMPTY);
            balancePages();
            return;
        }
        ItemStack carried = getCarried();
        if (carried.isEmpty()) {
            return;
        }
        tryAddFilterEntryAt(realIndex, carried);
        expandIfCurrentPageFull();
    }
    private void tryAddFilterEntry(ItemStack sourceStack) {
        if (sourceStack.isEmpty() || magnetStack.isEmpty()) {
            return;
        }
        for (int i = 0; i < filterContainer.getContainerSize(); i++) {
            ItemStack existing = filterContainer.getItem(i);
            if (!existing.isEmpty() && existing.is(sourceStack.getItem())) {
                return;
            }
        }
        int index = findFirstEmptySlot();
        if (index == -1) {
            filterContainer.addPage();
            index = findFirstEmptySlot();
            if (index == -1) {
                return;
            }
        }
        filterContainer.setItem(index, sourceStack.copyWithCount(1));
        expandIfCurrentPageFull();
    }

    private void expandIfCurrentPageFull() {
        int current = getCurrentPage();
        if (current == getPageCount() - 1 && isPageFull(current)) {
            filterContainer.addPage();
            saveFilterItems();
        }
    }
    private void tryAddFilterEntryAt(int index, ItemStack sourceStack) {
        if (sourceStack.isEmpty() || magnetStack.isEmpty()) {
            return;
        }
        for (int i = 0; i < filterContainer.getContainerSize(); i++) {
            ItemStack existing = filterContainer.getItem(i);
            if (!existing.isEmpty() && existing.is(sourceStack.getItem())) {
                return;
            }
        }
        filterContainer.setItem(index, sourceStack.copyWithCount(1));
    }
    private int findFirstEmptySlot() {
        for (int i = 0; i < filterContainer.getContainerSize(); i++) {
            if (filterContainer.getItem(i).isEmpty()) {
                return i;
            }
        }
        return -1;
    }
    private boolean isPageEmpty(int page) {
        int base = page * PAGE_SIZE;
        for (int i = 0; i < PAGE_SIZE; i++) {
            if (!filterContainer.getItem(base + i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void balancePages() {
        int page = 0;
        while (page < getPageCount() - 1) {
            if (isPageEmpty(page) && isPageEmpty(page + 1)) {
                filterContainer.removePage(page + 1);
                if (getCurrentPage() > page) {
                    data.set(2, getCurrentPage() - 1);
                } else if (getCurrentPage() == page + 1) {
                    data.set(2, page);
                }
                continue;
            }
            page++;
        }
        if (getCurrentPage() >= getPageCount()) {
            data.set(2, getPageCount() - 1);
        }
        saveFilterItems();
    }
    private void saveFilterItems() {
        if (magnetStack.isEmpty()) {
            return;
        }
        writeFilterToStack(isWhitelist(), isAttractExperience(), currentItemsSnapshot());
        data.set(3, filterContainer.getContainerSize());
    }
    private NonNullList<ItemStack> currentItemsSnapshot() {
        int size = filterContainer.getContainerSize();
        NonNullList<ItemStack> items = NonNullList.withSize(size, ItemStack.EMPTY);
        for (int i = 0; i < size; i++) {
            ItemStack entry = filterContainer.getItem(i).copy();
            if (!entry.isEmpty()) {
                entry.setCount(1);
            }
            items.set(i, entry);
        }
        return items;
    }
    private void writeFilterToStack(boolean whitelist, boolean attractExperience, NonNullList<ItemStack> items) {
        if (magnetStack.isEmpty()) {
            return;
        }
        magnetStack.set(PADataComponents.MAGNET_FILTER.get(), new MagnetFilterData(whitelist, attractExperience, items));
    }
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        if (index < PAGE_SIZE) {
            return ItemStack.EMPTY;
        }
        Slot slot = slots.get(index);
        if (slot == null || !slot.hasItem()) {
            return ItemStack.EMPTY;
        }
        ItemStack original = slot.getItem();
        ItemStack result = original.copy();
        int mainInvEnd = PAGE_SIZE + MAIN_INV_SIZE;
        if (index < mainInvEnd) {
            if (!moveItemStackTo(original, mainInvEnd, slots.size(), false)) {
                return ItemStack.EMPTY;
            }
        } else {
            if (!moveItemStackTo(original, PAGE_SIZE, mainInvEnd, false)) {
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
        if (magnetStack.isEmpty()) {
            return true;
        }
        return player.getMainHandItem() == magnetStack || player.getOffhandItem() == magnetStack;
    }
    private class PagedFilterSlot extends Slot {
        private final int localIndex;
        PagedFilterSlot(int localIndex, int x, int y) {
            super(filterContainer, localIndex, x, y);
            this.localIndex = localIndex;
        }
        private int realIndex() {
            return getCurrentPage() * PAGE_SIZE + localIndex;
        }
        @Override
        public ItemStack getItem() {
            return filterContainer.getItem(realIndex());
        }
        @Override
        public void set(ItemStack stack) {
            filterContainer.setItem(realIndex(), stack);
            setChanged();
        }
        @Override
        public void setChanged() {
            filterContainer.setChanged();
        }
        @Override
        public boolean hasItem() {
            return !getItem().isEmpty();
        }
        @Override
        public ItemStack remove(int amount) {
            return filterContainer.removeItem(realIndex(), amount);
        }
        @Override
        public int getMaxStackSize() {
            return 1;
        }
        @Override
        public boolean mayPickup(Player player) {
            return false;
        }
        @Override
        public boolean mayPlace(ItemStack stack) {
            return false;
        }
    }
    private class PagedFilterContainer implements Container {
        private final List<ItemStack> items = new ArrayList<>();
        PagedFilterContainer(List<ItemStack> initial) {
            items.addAll(initial);
            int pages = Math.max(1, (items.size() + PAGE_SIZE - 1) / PAGE_SIZE);
            while (items.size() < pages * PAGE_SIZE) {
                items.add(ItemStack.EMPTY);
            }
        }
        void addPage() {
            for (int i = 0; i < PAGE_SIZE; i++) {
                items.add(ItemStack.EMPTY);
            }
        }
        void removePage(int page) {
            int base = page * PAGE_SIZE;
            for (int i = 0; i < PAGE_SIZE; i++) {
                items.remove(base);
            }
        }
        void resetToSinglePage() {
            items.clear();
            for (int i = 0; i < PAGE_SIZE; i++) {
                items.add(ItemStack.EMPTY);
            }
        }
        void setPageContentsSilently(int page, List<ItemStack> stacks) {
            int base = page * PAGE_SIZE;
            ensureIndex(base + PAGE_SIZE - 1);
            for (int i = 0; i < PAGE_SIZE; i++) {
                items.set(base + i, i < stacks.size() ? stacks.get(i) : ItemStack.EMPTY);
            }
        }
        private void ensureIndex(int index) {
            while (index >= items.size()) {
                addPage();
            }
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
            ensureIndex(index);
            return items.get(index);
        }
        @Override
        public ItemStack removeItem(int index, int count) {
            ensureIndex(index);
            ItemStack existing = items.get(index);
            if (existing.isEmpty()) {
                return ItemStack.EMPTY;
            }
            ItemStack result = existing.split(count);
            setChanged();
            return result;
        }
        @Override
        public ItemStack removeItemNoUpdate(int index) {
            ensureIndex(index);
            ItemStack existing = items.get(index);
            items.set(index, ItemStack.EMPTY);
            return existing;
        }
        @Override
        public void setItem(int index, ItemStack stack) {
            ensureIndex(index);
            items.set(index, stack);
            setChanged();
        }
        @Override
        public void setChanged() {
            saveFilterItems();
        }
        @Override
        public boolean stillValid(Player player) {
            return AdvancedMagnetMenu.this.stillValid(player);
        }
        @Override
        public void clearContent() {
            items.replaceAll(stack -> ItemStack.EMPTY);
            setChanged();
        }
    }
}