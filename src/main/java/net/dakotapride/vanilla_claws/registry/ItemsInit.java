package net.dakotapride.vanilla_claws.registry;

import net.dakotapride.vanilla_claws.integration.IntegratedMaterials;
import net.dakotapride.vanilla_claws.item.ClawsItem;
import net.dakotapride.vanilla_claws.item.EndGobberClawsItem;
import net.dakotapride.vanilla_claws.item.GobberClawsItem;
import net.dakotapride.vanilla_claws.item.ResourceSlimesIntegratedClawsItem;
import net.dakotapride.vanilla_claws.item.material.VanillaClawsMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.dakotapride.vanilla_claws.VanillaClawsMain.MOD_ID;

public class ItemsInit {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<ClawsItem> NETHERITE_CLAWS = ITEMS.register("netherite_claws",
            () -> new ClawsItem(VanillaClawsMaterials.NETHERITE, 6, 2, new Item.Properties()));
    public static final DeferredItem<ClawsItem> DIAMOND_CLAWS = ITEMS.register("diamond_claws",
            () -> new ClawsItem(VanillaClawsMaterials.DIAMOND, 5, 2, new Item.Properties()));
    public static final DeferredItem<ClawsItem> GOLD_CLAWS = ITEMS.register("gold_claws",
            () -> new ClawsItem(VanillaClawsMaterials.GOLD, 4, 2, new Item.Properties()));
    public static final DeferredItem<ClawsItem> COPPER_CLAWS = ITEMS.register("copper_claws",
            () -> new ClawsItem(VanillaClawsMaterials.COPPER, 4, 2, new Item.Properties()));
    public static final DeferredItem<ClawsItem> IRON_CLAWS = ITEMS.register("iron_claws",
            () -> new ClawsItem(VanillaClawsMaterials.IRON, 3, 2, new Item.Properties()));
    public static final DeferredItem<ClawsItem> STONE_CLAWS = ITEMS.register("stone_claws",
            () -> new ClawsItem(VanillaClawsMaterials.STONE, 3, 2, new Item.Properties()));
    public static final DeferredItem<ClawsItem> WOODEN_CLAWS = ITEMS.register("wooden_claws",
            () -> new ClawsItem(VanillaClawsMaterials.WOOD, 2, 2, new Item.Properties()));

    public static final DeferredItem<GobberClawsItem> GOBBER2_CLAWS = ITEMS.register("gobber2_claws",
            () -> new GobberClawsItem(IntegratedMaterials.GOBBER2, 7, 2, new Item.Properties()));
    public static final DeferredItem<GobberClawsItem> GOBBER2_NETHER_CLAWS = ITEMS.register("gobber2_nether_claws",
            () -> new GobberClawsItem(IntegratedMaterials.GOBBER2_NETHER, 8, 2, new Item.Properties().fireResistant()));
    public static final DeferredItem<EndGobberClawsItem> GOBBER2_END_CLAWS = ITEMS.register("gobber2_end_claws",
            () -> new EndGobberClawsItem(IntegratedMaterials.GOBBER2_END, 9, 2, new Item.Properties()));

    public static final DeferredItem<ResourceSlimesIntegratedClawsItem> SOAPY_CLAWS = ITEMS.register("soapy_claws",
            () -> new ResourceSlimesIntegratedClawsItem(IntegratedMaterials.SOAPY, 3, 4, new Item.Properties()));
    public static final DeferredItem<ResourceSlimesIntegratedClawsItem> BLACK_OPAL_CLAWS = ITEMS.register("black_opal_claws",
            () -> new ResourceSlimesIntegratedClawsItem(IntegratedMaterials.BLACK_OPAL, 3, 4, new Item.Properties()));
    public static final DeferredItem<ResourceSlimesIntegratedClawsItem> CITRINE_CLAWS = ITEMS.register("citrine_claws",
            () -> new ResourceSlimesIntegratedClawsItem(IntegratedMaterials.CITRINE, 3, 4, new Item.Properties()));
    public static final DeferredItem<ResourceSlimesIntegratedClawsItem> EMERALD_CLAWS = ITEMS.register("emerald_claws",
            () -> new ResourceSlimesIntegratedClawsItem(IntegratedMaterials.EMERALD, 3, 4, new Item.Properties()));
    public static final DeferredItem<ResourceSlimesIntegratedClawsItem> TANZANITE_CLAWS = ITEMS.register("tanzanite_claws",
            () -> new ResourceSlimesIntegratedClawsItem(IntegratedMaterials.TANZANITE, 3, 4, new Item.Properties()));
    public static final DeferredItem<ResourceSlimesIntegratedClawsItem> ZIRCON_CLAWS = ITEMS.register("zircon_claws",
            () -> new ResourceSlimesIntegratedClawsItem(IntegratedMaterials.ZIRCON, 3, 4, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
