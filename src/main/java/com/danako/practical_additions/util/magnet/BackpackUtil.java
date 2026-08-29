package com.danako.practical_additions.util.magnet;

import com.danako.practical_additions.common.item.backpack.BackpackItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;

import java.util.Map;
import java.util.Optional;

public final class BackpackUtil {

    private BackpackUtil() {
    }

    public static boolean isBackpack(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() instanceof BackpackItem;
    }

    public static ItemStack findBackpack(Player player) {
        ItemStack mainHand = player.getMainHandItem();
        if (isBackpack(mainHand)) {
            return mainHand;
        }

        ItemStack offHand = player.getOffhandItem();
        if (isBackpack(offHand)) {
            return offHand;
        }

        ItemStack curio = findInCurios(player);
        if (!curio.isEmpty()) {
            return curio;
        }

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (isBackpack(stack)) {
                return stack;
            }
        }

        return ItemStack.EMPTY;
    }

    private static ItemStack findInCurios(Player player) {
        Optional<ICuriosItemHandler> handler = CuriosApi.getCuriosInventory(player);
        if (handler.isEmpty()) {
            return ItemStack.EMPTY;
        }
        for (Map.Entry<String, ICurioStacksHandler> entry : handler.get().getCurios().entrySet()) {
            ICurioStacksHandler stacksHandler = entry.getValue();
            for (int i = 0; i < stacksHandler.getSlots(); i++) {
                ItemStack stack = stacksHandler.getStacks().getStackInSlot(i);
                if (isBackpack(stack)) {
                    return stack;
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public static boolean isBackpackAccessible(Player player, ItemStack target) {
        if (player.getMainHandItem() == target || player.getOffhandItem() == target) {
            return true;
        }

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            if (player.getInventory().getItem(i) == target) {
                return true;
            }
        }

        Optional<ICuriosItemHandler> handler = CuriosApi.getCuriosInventory(player);
        if (handler.isPresent()) {
            for (Map.Entry<String, ICurioStacksHandler> entry : handler.get().getCurios().entrySet()) {
                ICurioStacksHandler stacksHandler = entry.getValue();
                for (int i = 0; i < stacksHandler.getSlots(); i++) {
                    if (stacksHandler.getStacks().getStackInSlot(i) == target) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}