package net.dakotapride.vanilla_claws;

import net.dakotapride.vanilla_claws.integration.IntegratedMaterials;
import net.dakotapride.vanilla_claws.registry.ItemsInit;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VanillaClawsMain.MOD_ID)
public class VanillaClawsMain
{
    public static final String MOD_ID = "vanilla_claws";

    public VanillaClawsMain(IEventBus eventBus, ModContainer modContainer)
    {

        eventBus.addListener(this::commonSetup);

        ItemsInit.register(eventBus);
        if (ModList.get().isLoaded("gobber2")) {
            IntegratedMaterials.init(eventBus);
        } else if (ModList.get().isLoaded("resourceslimes")) {
            IntegratedMaterials.init(eventBus);
        }

        // Register the item to a creative tab
        eventBus.addListener(this::itemGroupEvent);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {}

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    public void itemGroupEvent(BuildCreativeModeTabContentsEvent event) {
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
