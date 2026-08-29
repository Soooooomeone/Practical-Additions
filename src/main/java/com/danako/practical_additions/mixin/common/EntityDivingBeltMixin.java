package com.danako.practical_additions.mixin.common;

import com.danako.practical_additions.common.item.diving_belt.DivingBeltHelper;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Entity.class)
public abstract class EntityDivingBeltMixin {

    @WrapOperation(method = "updateSwimming", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;setSwimming(Z)V"))
    private void practicalAdditions$disableSwimmingPose(Entity self, boolean swimming, Operation<Void> original) {
        if (!self.isInLava() && self instanceof Player player && DivingBeltHelper.isWearingActiveBelt(player)) {
            original.call(self, false);
        } else {
            original.call(self, swimming);
        }
    }
}