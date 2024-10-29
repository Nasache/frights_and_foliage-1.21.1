package net.nathan.frights_and_foliage.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Unique
    private int scaledWidth;
    @Unique
    private int scaledHeight;

    @Unique
    private static final Identifier WARPED_PUMPKIN_BLUR = Identifier.of("frights_and_foliage", "textures/misc/warpedblur.png");
    @Unique
    private static final Identifier CRIMSON_PUMPKIN_BLUR = Identifier.of("frights_and_foliage", "textures/misc/crimsonblur.png");
    @Unique
    private void renderOverlay(DrawContext context, Identifier texture, float opacity) {
        this.scaledWidth = context.getScaledWindowWidth();
        this.scaledHeight = context.getScaledWindowHeight();
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        context.setShaderColor(1.0f, 1.0f, 1.0f, opacity);
        context.drawTexture(texture, 0, 0, -90, 0.0f, 0.0f, this.scaledWidth, this.scaledHeight, this.scaledWidth, this.scaledHeight);
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        context.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Inject(method = "render", at = @At("HEAD"))
    private void injectCarvedWarpedPumpkinCheck(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        RenderSystem.enableBlend();

        if (client.options.getPerspective().isFirstPerson()) {
            if (!client.player.isUsingSpyglass()) {
                ItemStack itemStack = client.player.getInventory().getArmorStack(3);
                if (itemStack.isOf(ModBlocks.CARVED_WARPED_PUMPKIN.asItem())) {
                    this.renderOverlay(context, WARPED_PUMPKIN_BLUR, 1.0f);
                }
                if (itemStack.isOf(ModBlocks.CARVED_CRIMSON_PUMPKIN.asItem())) {
                    this.renderOverlay(context, CRIMSON_PUMPKIN_BLUR, 1.0f);
                }
            }
        }
    }
}
