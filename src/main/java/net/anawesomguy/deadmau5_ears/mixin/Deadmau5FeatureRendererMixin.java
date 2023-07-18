package net.anawesomguy.deadmau5_ears.mixin;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.feature.Deadmau5FeatureRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(Deadmau5FeatureRenderer.class)
public class Deadmau5FeatureRendererMixin {
	@Redirect(
		method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V",
		at = @At(value = "INVOKE", target = "Ljava/lang/String;equals(Ljava/lang/Object;)Z"),
		slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deadmau5"))
	)
	private boolean notCheckUsername(String instance, Object anObject) {
		return true;
	}
	@Redirect(
		method = "render(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;ILnet/minecraft/client/network/AbstractClientPlayerEntity;FFFFFF)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;hasSkinTexture()Z"),
		slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=deadmau5"))
	)
	private boolean notCheckSkinTexture(AbstractClientPlayerEntity instance) {
		return true;
	}
}
