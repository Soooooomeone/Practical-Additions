package com.danako.practical_additions.mixin.client;

import com.danako.practical_additions.client.sound.PASoundOcclusion;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SoundEngine.class)
public abstract class SoundEngineOcclusionMixin {

    @Shadow
    private float calculateVolume(float volumeMultiplier, SoundSource source) {
        throw new UnsupportedOperationException("shadowed");
    }

    @Redirect(method = "play", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sounds/SoundEngine;calculateVolume(FLnet/minecraft/sounds/SoundSource;)F"))
    private float practicalAdditions$occludePlayVolume(SoundEngine self, float volumeMultiplier, SoundSource source, SoundInstance p_sound) {
        float base = this.calculateVolume(volumeMultiplier, source);
        return base * practicalAdditions$occlusionMultiplier(p_sound);
    }

    @Inject(method = "calculateVolume(Lnet/minecraft/client/resources/sounds/SoundInstance;)F", at = @At("RETURN"), cancellable = true)
    private void practicalAdditions$occludeTickVolume(SoundInstance sound, CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(cir.getReturnValue() * practicalAdditions$occlusionMultiplier(sound));
    }

    @Unique
    private static float practicalAdditions$occlusionMultiplier(SoundInstance sound) {
        if (sound.isRelative() || sound.getAttenuation() == SoundInstance.Attenuation.NONE) {
            return 1.0F;
        }
        Minecraft mc = Minecraft.getInstance();
        Level level = mc.level;
        if (level == null || mc.gameRenderer == null) {
            return 1.0F;
        }
        Camera camera = mc.gameRenderer.getMainCamera();
        if (camera == null || !camera.isInitialized()) {
            return 1.0F;
        }
        Vec3 listenerPos = camera.position();
        Vec3 soundPos = new Vec3(sound.getX(), sound.getY(), sound.getZ());
        return PASoundOcclusion.computeVolumeMultiplier(level, listenerPos, soundPos);
    }
}