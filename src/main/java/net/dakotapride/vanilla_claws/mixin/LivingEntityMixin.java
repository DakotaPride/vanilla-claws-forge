package net.dakotapride.vanilla_claws.mixin;

import net.dakotapride.vanilla_claws.registry.ItemsInit;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
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
    private static final RegistryObject<MobEffect> SOAPY_EFFECT =
            RegistryObject.create(new ResourceLocation("resourceslimes:soapy"), ForgeRegistries.MOB_EFFECTS);
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (claws$entity instanceof LivingEntity living && living.getItemInHand(InteractionHand.MAIN_HAND).is(ItemsInit.SOAPY_CLAWS.get())
        && ModList.get().isLoaded("resourceslimes")) {
            ((LivingEntity) claws$entity).addEffect(new MobEffectInstance(SOAPY_EFFECT.get(), 40));
        }
    }

}
