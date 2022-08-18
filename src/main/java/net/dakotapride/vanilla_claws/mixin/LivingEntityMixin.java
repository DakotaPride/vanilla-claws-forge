package net.dakotapride.vanilla_claws.mixin;

import net.dakotapride.vanilla_claws.registry.ItemsInit;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    Entity entity = this;
    private static final RegistryObject<MobEffect> SOAPY_EFFECT =
            RegistryObject.create(new ResourceLocation("resourceslimes:soapy"), ForgeRegistries.MOB_EFFECTS);
    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        if (entity instanceof LivingEntity living && living.getItemInHand(InteractionHand.MAIN_HAND).is(ItemsInit.SOAPY_CLAWS.get())
        && ModList.get().isLoaded("resourceslimes")) {
            ((LivingEntity) entity).addEffect(new MobEffectInstance(SOAPY_EFFECT.get()));
        }
    }

    @Inject(method = "getBlockSpeedFactor", at = @At("HEAD"), cancellable = true)
    private void onGetBlockSpeedFactor(CallbackInfoReturnable<Float> cir) {
        if (((Object)this) instanceof LivingEntity living
                && living.getItemInHand(InteractionHand.MAIN_HAND).is(ItemsInit.SOAPY_CLAWS.get())) {
            cir.setReturnValue(1.01F);
        }
    }

}
