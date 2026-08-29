package com.danako.practical_additions.mixin.client;

import com.danako.practical_additions.common.item.cobalt_bow.CobaltBowItem;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerFovMixin {

    @Redirect(
            method = "getFieldOfViewModifier",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
            )
    )
    private boolean practicalAdditions$treatCobaltBowAsBow(ItemStack stack, Item item) {
        return stack.is(item) || stack.getItem() instanceof CobaltBowItem;
    }

    @ModifyConstant(
            method = "getFieldOfViewModifier",
            constant = @Constant(floatValue = 20.0F)
    )
    private float practicalAdditions$fasterBowZoom(float drawTicks) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (self.getUseItem().getItem() instanceof CobaltBowItem) {
            return CobaltBowItem.DRAW_TICKS;
        }
        return drawTicks;
    }
}