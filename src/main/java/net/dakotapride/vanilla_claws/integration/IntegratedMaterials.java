package net.dakotapride.vanilla_claws.integration;

import net.dakotapride.vanilla_claws.tags.TagsInit;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum IntegratedMaterials implements Tier {
    GOBBER2(3800, 20, () -> {
        return Ingredient.of(TagsInit.GOBBER2_INGOTS);
    }),
    GOBBER2_NETHER(5200, 25, () -> {
        return Ingredient.of(TagsInit.GOBBER2_NETHER_INGOTS);
    }),
    GOBBER2_END(8000, 26, () -> {
        return Ingredient.of(TagsInit.GOBBER2_END_INGOTS);
    }),
    SOAPY(82, 4, () -> {
        return Ingredient.of(TagsInit.SOAPY_INGOTS);
    }),
    BLACK_OPAL(687, 3, () -> {
        return Ingredient.of(TagsInit.BLACK_OPAL);
    }),
    ZIRCON(652, 2, () -> {
        return Ingredient.of(TagsInit.ZIRCON);
    }),
    TANZANITE(791, 3, () -> {
        return Ingredient.of(TagsInit.TANZANITE);
    }),
    EMERALD(853,6, () -> {
        return Ingredient.of(TagsInit.EMERALD);
    }),
    CITRINE(276,2, () -> {
        return Ingredient.of(TagsInit.CITRINE);
    });


    private final int uses;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    IntegratedMaterials(int pUses, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        this.uses = pUses;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }


    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return 0;
    }

    public float getAttackDamageBonus() {
        return 0;
    }

    public TagKey<Block> getIncorrectBlocksForDrops() {
        return null;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public static void init(IEventBus eventBus) {}
}
