package net.dakotapride.vanilla_claws.client;

import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.LinkedHashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class TwoModelsItemRegistry {
    public static final Map<Integer, Item> ENTRIES = new LinkedHashMap<>();

    /**
     * Registered items will have secondary
     * model in an entity hand loaded from
     * assets/%modid%/models/item/%item_name%_in_hand.json
     *
     * @param items items to be registered
     */
    public static void register(Item... items) {
        for(Item item : items) {
            int id = Registry.ITEM.getId(item);
            ENTRIES.put(id, item);
        }
    }

}
