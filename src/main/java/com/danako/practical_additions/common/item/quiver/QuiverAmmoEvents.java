package com.danako.practical_additions.common.item.quiver;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.init.data_components.PADataComponents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingGetProjectileEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber(modid = PracticalAdditions.MODID)
public class QuiverAmmoEvents {

    @SubscribeEvent
    public static void onGetProjectile(LivingGetProjectileEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (player.getAbilities().instabuild) {
            return;
        }
        if (!(event.getProjectileWeaponItemStack().getItem() instanceof ProjectileWeaponItem)) {
            return;
        }

        ItemStack quiverArrow = findQuiverArrow(player);
        if (!quiverArrow.isEmpty()) {
            event.setProjectileItemStack(quiverArrow);
        }
    }


    @SubscribeEvent
    @SuppressWarnings("removal")
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) {
            return;
        }

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (normalizeIfQuiver(stack)) {
                player.getInventory().setItem(i, stack);
            }
        }

        CuriosApi.getCuriosInventory(player).ifPresent(curios -> {
            IItemHandlerModifiable handler = curios.getEquippedCurios();
            for (int i = 0; i < handler.getSlots(); i++) {
                ItemStack stack = handler.getStackInSlot(i);
                if (normalizeIfQuiver(stack)) {
                    handler.setStackInSlot(i, stack);
                }
            }
        });
    }
    @SuppressWarnings("removal")
    private static ItemStack findQuiverArrow(Player player) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack arrow = tryGetArrow(player.getInventory().getItem(i));
            if (!arrow.isEmpty()) {
                return arrow;
            }
        }

        return CuriosApi.getCuriosInventory(player).map(curios -> {
            IItemHandlerModifiable handler = curios.getEquippedCurios();
            for (int i = 0; i < handler.getSlots(); i++) {
                ItemStack arrow = tryGetArrow(handler.getStackInSlot(i));
                if (!arrow.isEmpty()) {
                    return arrow;
                }
            }
            return ItemStack.EMPTY;
        }).orElse(ItemStack.EMPTY);
    }

    private static ItemStack tryGetArrow(ItemStack maybeQuiver) {
        if (!(maybeQuiver.getItem() instanceof QuiverItem)) {
            return ItemStack.EMPTY;
        }
        QuiverContents contents = maybeQuiver.get(PADataComponents.QUIVER_CONTENTS.get());
        if (contents == null || contents.isEmpty()) {
            return ItemStack.EMPTY;
        }
        return contents.peekTopArrow();
    }

    private static boolean normalizeIfQuiver(ItemStack stack) {
        if (!(stack.getItem() instanceof QuiverItem)) {
            return false;
        }
        QuiverContents contents = stack.get(PADataComponents.QUIVER_CONTENTS.get());
        if (contents == null) {
            return false;
        }
        QuiverContents recomputed = contents.recomputeIfNeeded();
        if (recomputed == contents) {
            return false;
        }
        stack.set(PADataComponents.QUIVER_CONTENTS.get(), recomputed);
        return true;
    }
}