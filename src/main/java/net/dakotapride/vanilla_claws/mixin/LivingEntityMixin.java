package net.dakotapride.vanilla_claws.mixin;

import net.dakotapride.vanilla_claws.tags.TagsInit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    private final LivingEntity livingEntity = (LivingEntity) (Object) this;

    public LivingEntityMixin(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Redirect(method = "canDisableShield", at = @At("TAIL"))
    private void canDisableShield(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(livingEntity.getItemInHand(InteractionHand.MAIN_HAND).is(TagsInit.CAN_DISABLE_SHIELDS));
    }

}
