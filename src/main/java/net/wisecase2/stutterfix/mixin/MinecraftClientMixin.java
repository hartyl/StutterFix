package net.wisecase2.stutterfix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.MinecraftClient.class)
public class MinecraftClientMixin {

    @Inject(method = "run()V", at = @At(value = "INVOKE", target = "java/lang/Runtime.availableProcessors ()I", shift = At.Shift.AFTER))
    private void setMinecraftClientPriority(CallbackInfo ci) {
        Thread.currentThread().setPriority(10);
    }

}
