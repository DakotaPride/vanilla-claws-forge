package net.dakotapride.vanilla_claws;

import com.mojang.logging.LogUtils;
import net.dakotapride.vanilla_claws.item.ClawsItem;
import net.dakotapride.vanilla_claws.material.VanillaClawsMaterials;
import net.dakotapride.vanilla_claws.registry.ItemsInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(VanillaClawsMain.MOD_ID)
public class VanillaClawsMain
{
    public static final String MOD_ID = "vanilla_claws";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public VanillaClawsMain()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemsInit.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
