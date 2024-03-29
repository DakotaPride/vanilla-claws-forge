package net.dakotapride.vanilla_claws.tags;

import net.dakotapride.vanilla_claws.VanillaClawsMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagsInit {

    public static final TagKey<Item> CAN_DISABLE_SHIELDS = forgeTag("shield/can_disable_shields");
    public static final TagKey<Item> CLAWS = forgeTag("weapons/claws");
    public static final TagKey<Item> AXES = forgeTag("weapons/axes");

    public static final TagKey<Item> GOBBER2_INGOTS = of("gobber2_ingots");
    public static final TagKey<Item> GOBBER2_END_INGOTS = of("gobber2_end_ingots");
    public static final TagKey<Item> GOBBER2_NETHER_INGOTS = of("gobber2_nether_ingots");

    public static final TagKey<Item> SOAPY_INGOTS = of("soapy_ingots");
    public static final TagKey<Item> BLACK_OPAL = of("black_opal");
    public static final TagKey<Item> ZIRCON = of("zircon");
    public static final TagKey<Item> TANZANITE = of("tanzanite");
    public static final TagKey<Item> EMERALD = of("emerald");
    public static final TagKey<Item> CITRINE = of("citrine");

    private static TagKey<Item> forgeTag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }

    private static TagKey<Item> of(String name) {
        return ItemTags.create(new ResourceLocation(VanillaClawsMain.MOD_ID, name));
    }

}
