package net.dakotapride.vanilla_claws.mixin;

import net.dakotapride.vanilla_claws.item.ClawsItem;
import net.dakotapride.vanilla_claws.item.EndGobberClawsItem;
import net.dakotapride.vanilla_claws.item.GobberClawsItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ShieldItem.class)
public abstract class ShieldItemMixin {

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    private void use(Level pLevel, Player pPlayer, InteractionHand pHand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        if (pPlayer.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof ClawsItem) {
            cir.setReturnValue(InteractionResultHolder.fail(pPlayer.getItemInHand(pHand)));
        } else if (pPlayer.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof ClawsItem) {
            cir.setReturnValue(InteractionResultHolder.fail(pPlayer.getItemInHand(pHand)));
        }

        if (pPlayer.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof GobberClawsItem) {
            cir.setReturnValue(InteractionResultHolder.fail(pPlayer.getItemInHand(pHand)));
        } else if (pPlayer.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof GobberClawsItem) {
            cir.setReturnValue(InteractionResultHolder.fail(pPlayer.getItemInHand(pHand)));
        }
        if (pPlayer.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof EndGobberClawsItem) {
            cir.setReturnValue(InteractionResultHolder.fail(pPlayer.getItemInHand(pHand)));
        } else if (pPlayer.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof EndGobberClawsItem) {
            cir.setReturnValue(InteractionResultHolder.fail(pPlayer.getItemInHand(pHand)));
        }
    }

}
