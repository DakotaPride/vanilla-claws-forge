package net.dakotapride.vanilla_claws.registry;

import net.dakotapride.vanilla_claws.item.ClawsItem;
import net.dakotapride.vanilla_claws.material.VanillaClawsMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.dakotapride.vanilla_claws.VanillaClawsMain.*;

public class ItemsInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> NETHERITE_CLAWS = ITEMS.register("netherite_claws",
            () -> new ClawsItem(VanillaClawsMaterials.NETHERITE, 5, 2, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
