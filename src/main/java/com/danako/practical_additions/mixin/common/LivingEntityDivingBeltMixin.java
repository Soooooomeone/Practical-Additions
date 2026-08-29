package com.danako.practical_additions.mixin.common;

import com.danako.practical_additions.common.item.diving_belt.DivingBeltHelper;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityDivingBeltMixin {

    @Shadow
    private int noJumpDelay;

    @ModifyReturnValue(method = "shouldTravelInFluid", at = @At("RETURN"))
    private boolean practicalAdditions$disableWaterTravel(boolean original, FluidState fluidState) {
        if (!original) {
            return false;
        }
        LivingEntity self = (LivingEntity) (Object) this;

        if (!self.isInLava() && self instanceof Player player && DivingBeltHelper.isWearingActiveBelt(player)) {
            return false;
        }
        return original;
    }

    @WrapOperation(method = "aiStep", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;jumpInFluid(Lnet/neoforged/neoforge/fluids/FluidType;)V"))
    private void practicalAdditions$surfaceStyleJumpUnderwater(LivingEntity self, net.neoforged.neoforge.fluids.FluidType fluidType, Operation<Void> original) {
        if (!self.isInLava() && self instanceof Player player && DivingBeltHelper.isWearingActiveBelt(player)) {
            if (self.onGround() && this.noJumpDelay == 0) {
                self.jumpFromGround();
                this.noJumpDelay = 10;
            }
        } else {
            original.call(self, fluidType);
        }
    }
}