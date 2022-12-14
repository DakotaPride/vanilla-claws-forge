package net.dakotapride.vanilla_claws.integration;

import net.dakotapride.vanilla_claws.tags.TagsInit;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum IntegratedMaterials implements Tier {
    GOBBER2(0, 3800, 10.0F, 4.0F, 20, () -> {
        return Ingredient.of(TagsInit.GOBBER2_INGOTS);
    }),
    GOBBER2_NETHER(0, 5200, 11.0F, 6.0F, 25, () -> {
        return Ingredient.of(TagsInit.GOBBER2_NETHER_INGOTS);
    }),
    GOBBER2_END(0, 8000, 12.0F, 8.0F, 26, () -> {
        return Ingredient.of(TagsInit.GOBBER2_END_INGOTS);
    }),
    SOAPY(0, 82, 3.0F, 0.0F, 4, () -> {
        return Ingredient.of(TagsInit.SOAPY_INGOTS);
    }),
    BLACK_OPAL(0, 687, 7.0F, 1.0F, 3, () -> {
        return Ingredient.of(TagsInit.BLACK_OPAL);
    }),
    ZIRCON(0, 652, 4.0F, 0.5F, 2, () -> {
        return Ingredient.of(TagsInit.ZIRCON);
    }),
    TANZANITE(0, 791, 8.0F, 2.0F, 3, () -> {
        return Ingredient.of(TagsInit.TANZANITE);
    }),
    EMERALD(0, 853, 8.5F, 2.0F, 6, () -> {
        return Ingredient.of(TagsInit.EMERALD);
    }),
    CITRINE(0, 276, 1.5F, 0.0F, 2, () -> {
        return Ingredient.of(TagsInit.CITRINE);
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    IntegratedMaterials(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        this.level = pLevel;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public static void init(IEventBus eventBus) {}
}
