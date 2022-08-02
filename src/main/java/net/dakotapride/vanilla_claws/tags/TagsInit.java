package net.dakotapride.vanilla_claws.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagsInit {

    public static final TagKey<Item> CAN_DISABLE_SHIELDS = forgeTag("shield/can_disable_shields");
    public static final TagKey<Item> CLAWS = forgeTag("weapons/claws");
    public static final TagKey<Item> AXES = forgeTag("weapons/axes");

    private static TagKey<Item> forgeTag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }

}