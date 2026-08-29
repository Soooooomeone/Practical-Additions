package com.danako.practical_additions.common.item.backpack;

import com.danako.practical_additions.inventory.PAMenuTypes;
import com.danako.practical_additions.inventory.backpack.BackpackMenu;
import com.danako.practical_additions.model.backpack.Backpack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class BackpackItem extends Item implements ICurioItem {

    public static final int BASIC_SIZE = 27;
    public static final int REINFORCED_SIZE = 54;

    private final Backpack.BackpackType backpackType;

    public BackpackItem(Backpack.BackpackType backpackType, Properties properties) {
        super(properties);
        this.backpackType = backpackType;
    }

    public Backpack.BackpackType getBackpackType() {
        return backpackType;
    }

    public int getSlotCount() {
        return backpackType == Backpack.BackpackType.REINFORCED ? REINFORCED_SIZE : BASIC_SIZE;
    }

    public MenuType<BackpackMenu> getMenuType() {
        return backpackType == Backpack.BackpackType.REINFORCED ? PAMenuTypes.REINFORCED_BACKPACK_MENU.get() : PAMenuTypes.BASIC_BACKPACK_MENU.get();
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide()) {
            openBackpack(player, stack);
        }
        return level.isClientSide() ? InteractionResult.CONSUME : InteractionResult.SUCCESS_SERVER;
    }

    public void openBackpack(Player player, ItemStack stack) {
        int size = getSlotCount();
        MenuType<BackpackMenu> menuType = getMenuType();
        player.openMenu(new SimpleMenuProvider((containerId, inv, p) -> new BackpackMenu(menuType, containerId, inv, stack, size), stack.getHoverName()));
    }
}
