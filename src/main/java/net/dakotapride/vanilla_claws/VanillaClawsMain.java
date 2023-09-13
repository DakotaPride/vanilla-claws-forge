package net.dakotapride.vanilla_claws;

import net.dakotapride.vanilla_claws.integration.IntegratedMaterials;
import net.dakotapride.vanilla_claws.registry.ItemsInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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
        } else if (ModList.get().isLoaded("resourceslimes")) {
            IntegratedMaterials.init(eventBus);
        }

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ItemsInit.NETHERITE_CLAWS);
            event.accept(ItemsInit.DIAMOND_CLAWS);
            event.accept(ItemsInit.GOLD_CLAWS);
            event.accept(ItemsInit.COPPER_CLAWS);
            event.accept(ItemsInit.IRON_CLAWS);
            event.accept(ItemsInit.STONE_CLAWS);
            event.accept(ItemsInit.WOODEN_CLAWS);

            event.accept(ItemsInit.GOBBER2_END_CLAWS);
            event.accept(ItemsInit.GOBBER2_NETHER_CLAWS);
            event.accept(ItemsInit.GOBBER2_CLAWS);

            event.accept(ItemsInit.SOAPY_CLAWS);
            event.accept(ItemsInit.BLACK_OPAL_CLAWS);
            event.accept(ItemsInit.CITRINE_CLAWS);
            event.accept(ItemsInit.EMERALD_CLAWS);
            event.accept(ItemsInit.TANZANITE_CLAWS);
            event.accept(ItemsInit.ZIRCON_CLAWS);
        }
    }
}
