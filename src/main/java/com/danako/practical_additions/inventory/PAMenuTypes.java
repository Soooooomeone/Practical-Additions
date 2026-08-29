package com.danako.practical_additions.inventory;

import com.danako.practical_additions.PracticalAdditions;
import com.danako.practical_additions.common.item.backpack.BackpackItem;
import com.danako.practical_additions.inventory.magnet.AdvancedMagnetMenu;
import com.danako.practical_additions.inventory.backpack.BackpackMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class PAMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, PracticalAdditions.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<AdvancedMagnetMenu>> ADVANCED_MAGNET_MENU = MENU_TYPES.register("advanced_magnet_menu", () -> IMenuTypeExtension.create((containerId, inv, buf) -> new AdvancedMagnetMenu(containerId, inv)));

    public static final DeferredHolder<MenuType<?>, MenuType<BackpackMenu>> BASIC_BACKPACK_MENU = MENU_TYPES.register("basic_backpack_menu", () -> IMenuTypeExtension.create((containerId, inv, buf) -> new BackpackMenu(basicMenuType(), containerId, inv, BackpackItem.BASIC_SIZE)));

    public static final DeferredHolder<MenuType<?>, MenuType<BackpackMenu>> REINFORCED_BACKPACK_MENU = MENU_TYPES.register("reinforced_backpack_menu", () -> IMenuTypeExtension.create((containerId, inv, buf) -> new BackpackMenu(reinforcedMenuType(), containerId, inv, BackpackItem.REINFORCED_SIZE)));

    private static MenuType<BackpackMenu> basicMenuType() {
        return BASIC_BACKPACK_MENU.get();
    }

    private static MenuType<BackpackMenu> reinforcedMenuType() {
        return REINFORCED_BACKPACK_MENU.get();
    }

    public static void register(IEventBus modEventBus) {
        MENU_TYPES.register(modEventBus);
    }
}