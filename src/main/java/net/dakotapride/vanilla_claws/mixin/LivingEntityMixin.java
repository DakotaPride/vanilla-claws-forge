package net.dakotapride.vanilla_claws.mixin;

import net.dakotapride.vanilla_claws.registry.ItemsInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Unique
    Entity claws$entity = this;

    @Unique
    private static final DeferredHolder<MobEffect, MobEffect> SOAPY_EFFECT =
            DeferredHolder.create(ResourceLocation.fromNamespaceAndPath("resourceslimes", "soapy"), Registries.MOB_EFFECT.registry());
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (claws$entity instanceof LivingEntity living && living.getItemInHand(InteractionHand.MAIN_HAND).is(ItemsInit.SOAPY_CLAWS)
        && ModList.get().isLoaded("resourceslimes")) {
            ((LivingEntity) claws$entity).addEffect(new MobEffectInstance(SOAPY_EFFECT, 40));
        }
    }

}
