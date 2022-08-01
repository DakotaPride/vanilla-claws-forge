package net.dakotapride.vanilla_claws.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dakotapride.vanilla_claws.client.TwoModelsItemRegistry;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    @Mutable
    @Final
    private final ItemModelShaper models;

    Player player;

    protected ItemRendererMixin(ItemModelShaper models) {
        this.models = models;
    }

    public abstract void renderItem(ItemStack stack, ItemTransforms.TransformType renderMode, PoseStack matrices,
                                    MultiBufferSource vertexConsumers, int light, int overlay, BakedModel model);

    @Inject(method = "renderStatic(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/client/renderer/block/model/ItemTransforms$TransformType;IILcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At("HEAD"))
    void renderStatic(ItemStack pItemStack, ItemTransforms.TransformType pTransformType, int pCombinedLight, int pCombinedOverlay,
                    PoseStack pPoseStack, MultiBufferSource pBuffer, int p_174276_, CallbackInfo ci) {
        TwoModelsItemRegistry.ENTRIES.forEach((id, item) -> {
            if(!pItemStack.isEmpty() && pItemStack.is(item) && player != null){
                BakedModel model = models.getModelManager().getModel(new ModelResourceLocation(id + "_in_hand#inventory"));
                renderItem(pItemStack, pTransformType, pPoseStack, pBuffer, pCombinedLight, pCombinedOverlay, model);
                pPoseStack.scale(0, 0, 0);
            }
        });
    }

}
