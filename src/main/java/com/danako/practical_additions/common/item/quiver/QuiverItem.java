package com.danako.practical_additions.common.item.quiver;

import com.danako.practical_additions.init.data_components.PADataComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.component.TooltipDisplay;
import org.apache.commons.lang3.math.Fraction;

import java.util.Optional;


public class QuiverItem extends Item {

    private static final int FULL_BAR_COLOR = ARGB.colorFromFloat(1.0F, 1.0F, 0.33F, 0.33F);
    private static final int BAR_COLOR = ARGB.colorFromFloat(1.0F, 0.44F, 0.53F, 1.0F);

    public enum QuiverType {
        BASIC(3), REINFORCED(6);

        private final int maxArrowStacks;

        QuiverType(int maxArrowStacks) {
            this.maxArrowStacks = maxArrowStacks;
        }

        public int getMaxArrowStacks() {
            return maxArrowStacks;
        }

        public Fraction getCapacity() {
            return Fraction.getFraction(this.maxArrowStacks, 1);
        }
    }

    private final QuiverType type;

    public QuiverItem(QuiverType type, Properties properties) {
        super(properties);
        this.type = type;
    }

    public QuiverType getType() {
        return type;
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack quiverStack, Slot slot, ClickAction action, Player player) {
        QuiverContents contents = quiverStack.get(PADataComponents.QUIVER_CONTENTS.get());
        if (contents == null || quiverStack.getCount() != 1) {
            return false;
        }

        ItemStack slotStack = slot.getItem();
        QuiverContents.Mutable mutable = new QuiverContents.Mutable(contents, this.type.getCapacity());

        if (action == ClickAction.PRIMARY && !slotStack.isEmpty()) {
            if (mutable.tryTransfer(slot, player) > 0) {
                playInsertSound(player);
            } else {
                playInsertFailSound(player);
            }
            quiverStack.set(PADataComponents.QUIVER_CONTENTS.get(), mutable.toImmutable());
            this.broadcastChangesOnContainerMenu(player);
            return true;
        } else if (action == ClickAction.SECONDARY && slotStack.isEmpty()) {
            ItemStack removed = mutable.removeOne();
            if (removed != null) {
                ItemStack leftover = slot.safeInsert(removed);
                if (leftover.getCount() > 0) {
                    mutable.tryInsert(leftover);
                } else {
                    playRemoveOneSound(player);
                }
            }
            quiverStack.set(PADataComponents.QUIVER_CONTENTS.get(), mutable.toImmutable());
            this.broadcastChangesOnContainerMenu(player);
            return true;
        }
        return false;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack quiverStack, ItemStack otherStack, Slot slot, ClickAction action, Player player, SlotAccess slotAccess) {
        if (quiverStack.getCount() != 1) {
            return false;
        }
        if (action == ClickAction.PRIMARY && otherStack.isEmpty()) {
            toggleSelectedItem(quiverStack, -1);
            return false;
        }

        QuiverContents contents = quiverStack.get(PADataComponents.QUIVER_CONTENTS.get());
        if (contents == null) {
            return false;
        }
        QuiverContents.Mutable mutable = new QuiverContents.Mutable(contents, this.type.getCapacity());

        if (action == ClickAction.PRIMARY && !otherStack.isEmpty()) {
            if (slot.allowModification(player) && mutable.tryInsert(otherStack) > 0) {
                playInsertSound(player);
            } else {
                playInsertFailSound(player);
            }
            quiverStack.set(PADataComponents.QUIVER_CONTENTS.get(), mutable.toImmutable());
            this.broadcastChangesOnContainerMenu(player);
            return true;
        } else if (action == ClickAction.SECONDARY && otherStack.isEmpty()) {
            if (slot.allowModification(player)) {
                ItemStack removed = mutable.removeOne();
                if (removed != null) {
                    playRemoveOneSound(player);
                    slotAccess.set(removed);
                }
            }
            quiverStack.set(PADataComponents.QUIVER_CONTENTS.get(), mutable.toImmutable());
            this.broadcastChangesOnContainerMenu(player);
            return true;
        } else {
            toggleSelectedItem(quiverStack, -1);
            return false;
        }
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        QuiverContents contents = stack.getOrDefault(PADataComponents.QUIVER_CONTENTS.get(), QuiverContents.EMPTY);
        return contents.weight().compareTo(Fraction.ZERO) > 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        QuiverContents contents = stack.getOrDefault(PADataComponents.QUIVER_CONTENTS.get(), QuiverContents.EMPTY);
        Fraction ratio = contents.weight().divideBy(this.type.getCapacity());
        return Math.min(1 + Mth.mulAndTruncate(ratio, 12), 13);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        QuiverContents contents = stack.getOrDefault(PADataComponents.QUIVER_CONTENTS.get(), QuiverContents.EMPTY);
        Fraction ratio = contents.weight().divideBy(this.type.getCapacity());
        return ratio.compareTo(Fraction.ONE) >= 0 ? FULL_BAR_COLOR : BAR_COLOR;
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        TooltipDisplay display = stack.getOrDefault(DataComponents.TOOLTIP_DISPLAY, TooltipDisplay.DEFAULT);
        if (!display.shows(PADataComponents.QUIVER_CONTENTS.get())) {
            return Optional.empty();
        }
        QuiverContents contents = stack.get(PADataComponents.QUIVER_CONTENTS.get());
        return contents == null ? Optional.empty() : Optional.of(new QuiverTooltip(contents, this.type.getCapacity()));
    }

    @Override
    public void onDestroyed(ItemEntity itemEntity) {
        QuiverContents contents = itemEntity.getItem().get(PADataComponents.QUIVER_CONTENTS.get());
        if (contents != null) {
            itemEntity.getItem().set(PADataComponents.QUIVER_CONTENTS.get(), QuiverContents.EMPTY);
            ItemUtils.onContainerDestroyed(itemEntity, contents.itemsCopy());
        }
    }

    public static void toggleSelectedItem(ItemStack quiverStack, int selectedItem) {
        QuiverContents contents = quiverStack.get(PADataComponents.QUIVER_CONTENTS.get());
        if (contents != null) {
            QuiverContents.Mutable mutable = new QuiverContents.Mutable(contents, Fraction.ZERO);
            mutable.toggleSelectedItem(selectedItem);
            quiverStack.set(PADataComponents.QUIVER_CONTENTS.get(), mutable.toImmutable());
        }
    }

    private static void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private static void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private static void playInsertFailSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT_FAIL, 1.0F, 1.0F);
    }

    private void broadcastChangesOnContainerMenu(Player player) {
        AbstractContainerMenu menu = player.containerMenu;
        if (menu != null) {
            menu.slotsChanged(player.getInventory());
        }
    }
}