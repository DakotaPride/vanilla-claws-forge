package net.dakotapride.vanilla_claws.registry;

import net.dakotapride.vanilla_claws.integration.IntegratedMaterials;
import net.dakotapride.vanilla_claws.item.ClawsItem;
import net.dakotapride.vanilla_claws.item.EndGobberClawsItem;
import net.dakotapride.vanilla_claws.item.GobberClawsItem;
import net.dakotapride.vanilla_claws.item.material.VanillaClawsMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.vanilla_claws.VanillaClawsMain.MOD_ID;

public class ItemsInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<ClawsItem> NETHERITE_CLAWS = ITEMS.register("netherite_claws",
            () -> new ClawsItem(VanillaClawsMaterials.NETHERITE, 5, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ClawsItem> DIAMOND_CLAWS = ITEMS.register("diamond_claws",
            () -> new ClawsItem(VanillaClawsMaterials.DIAMOND, 4, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ClawsItem> GOLD_CLAWS = ITEMS.register("gold_claws",
            () -> new ClawsItem(VanillaClawsMaterials.GOLD, 4, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ClawsItem> COPPER_CLAWS = ITEMS.register("copper_claws",
            () -> new ClawsItem(VanillaClawsMaterials.COPPER, 4, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ClawsItem> IRON_CLAWS = ITEMS.register("iron_claws",
            () -> new ClawsItem(VanillaClawsMaterials.IRON, 5, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ClawsItem> STONE_CLAWS = ITEMS.register("stone_claws",
            () -> new ClawsItem(VanillaClawsMaterials.STONE, 4, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<ClawsItem> WOODEN_CLAWS = ITEMS.register("wooden_claws",
            () -> new ClawsItem(VanillaClawsMaterials.WOOD, 3, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<GobberClawsItem> GOBBER2_CLAWS = ITEMS.register("gobber2_claws",
            () -> new GobberClawsItem(IntegratedMaterials.GOBBER2, 4, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<GobberClawsItem> GOBBER2_NETHER_CLAWS = ITEMS.register("gobber2_nether_claws",
            () -> new GobberClawsItem(IntegratedMaterials.GOBBER2_NETHER, 5, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<EndGobberClawsItem> GOBBER2_END_CLAWS = ITEMS.register("gobber2_end_claws",
            () -> new EndGobberClawsItem(IntegratedMaterials.GOBBER2_END, 5, 2, new Item.Properties()
                    .tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
