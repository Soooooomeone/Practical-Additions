package com.danako.practical_additions.common.item.diving_belt;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

public final class DivingBeltHelper {

    private DivingBeltHelper() {
    }

    public static boolean isWearingActiveBelt(Player player) {
        for (ItemStack stack : player.getInventory().getNonEquipmentItems()) {
            if (isActiveBelt(stack)) {
                return true;
            }
        }
        return CuriosApi.getCuriosInventory(player)
                .map(handler -> handler.findFirstCurio(DivingBeltHelper::isActiveBelt).isPresent())
                .orElse(false);
    }

    private static boolean isActiveBelt(ItemStack stack) {
        return stack.getItem() instanceof DivingBeltItem belt && belt.isActive(stack);
    }
}