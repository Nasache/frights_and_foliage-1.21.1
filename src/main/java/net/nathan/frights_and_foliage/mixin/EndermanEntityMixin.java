package net.nathan.frights_and_foliage.mixin;

import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {

    @Inject(method = "isPlayerStaring(Lnet/minecraft/entity/player/PlayerEntity;)Z", at = @At("HEAD"), cancellable = true)
    private void injectModPumpkinInfo(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemStack = player.getInventory().armor.get(3);
        if (itemStack.isOf(ModBlocks.CARVED_WARPED_PUMPKIN.asItem())) {
            cir.setReturnValue(false);
        }
        if (itemStack.isOf(ModBlocks.CARVED_CRIMSON_PUMPKIN.asItem())) {
            cir.setReturnValue(false);
        }
    }
}
