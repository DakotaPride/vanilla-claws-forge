package net.dakotapride.vanilla_claws.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dakotapride.vanilla_claws.registry.ItemsInit;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    private final ItemModelShaper itemModelShaper;

    public ItemRendererMixin(ItemModelShaper itemModelShaper) {
        this.itemModelShaper = itemModelShaper;
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void render(ItemStack pItemStack, ItemTransforms.TransformType pTransformType, boolean pLeftHand,
            PoseStack pPoseStack, MultiBufferSource pBuffer, int pCombinedLight, int pCombinedOverlay,
            BakedModel pModel, CallbackInfo ci) {

        if (!pItemStack.isEmpty()) {
            pPoseStack.pushPose();
            boolean flag = pTransformType == ItemTransforms.TransformType.GUI || pTransformType == ItemTransforms.TransformType.GROUND || pTransformType == ItemTransforms.TransformType.FIXED;
            if (flag) {
                if (pItemStack.is(ItemsInit.NETHERITE_CLAWS.get())) {
                    pModel = this.itemModelShaper.getModelManager().getModel(new ModelResourceLocation("vanilla_claws:netherite_claws#inventory"));
                }
            }
        }

    }

    @Inject(method = "getModel", at = @At("TAIL"))
    private void getModel(ItemStack pItemStack, Level pLevel, LivingEntity p_174267_, int p_174268_, CallbackInfoReturnable<BakedModel> cir) {
        BakedModel bakedmodel;
        if (pItemStack.is(ItemsInit.NETHERITE_CLAWS.get())) {
            bakedmodel = this.itemModelShaper.getModelManager().getModel(new ModelResourceLocation("vanilla_claws:netherite_claws#inventory"));
        }
    }

}
