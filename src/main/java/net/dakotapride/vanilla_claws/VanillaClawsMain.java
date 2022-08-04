package net.dakotapride.vanilla_claws;

import net.dakotapride.vanilla_claws.integration.IntegratedMaterials;
import net.dakotapride.vanilla_claws.registry.ItemsInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VanillaClawsMain.MOD_ID)
public class VanillaClawsMain
{
    public static final String MOD_ID = "vanilla_claws";

    public VanillaClawsMain()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemsInit.register(eventBus);
        if (ModList.get().isLoaded("gobber2")) {
            IntegratedMaterials.init(eventBus);
        }

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
