package net.dakotapride.vanilla_claws.client;

import com.google.common.collect.Maps;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ModelBakeryInit extends ModelBakery {
    private final Map<ResourceLocation, UnbakedModel> unbakedCache = Maps.newHashMap();
    private final Map<ResourceLocation, UnbakedModel> topLevelModels = Maps.newHashMap();

    public ModelBakeryInit(ResourceManager pResourceManager, BlockColors pBlockColors, ProfilerFiller pProfiler, int pMaxMipmapLevel) {
        super(pResourceManager, pBlockColors, pProfiler, pMaxMipmapLevel);
    }

    @Override
    public void processLoading(@NotNull ProfilerFiller pProfiler, int pMaxMipmapLevel) {
        this.loadTopLevel(new ModelResourceLocation("vanilla_claws:netherite_claws_in_hand#inventory"));
    }

    public void loadTopLevel(ModelResourceLocation pLocation) {
        UnbakedModel unbakedmodel = this.getModel(pLocation);
        this.unbakedCache.put(pLocation, unbakedmodel);
        this.topLevelModels.put(pLocation, unbakedmodel);
    }
}
