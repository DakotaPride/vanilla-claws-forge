package net.dakotapride.vanilla_claws.material;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum VanillaClawsMaterials implements Tier {
    WOOD(0, 79, 2.0F, 0.0F, 1, () -> {
        return Ingredient.of(ItemTags.PLANKS);
    }),
    STONE(0, 161, 4.0F, 0.0F, 1, () -> {
        return Ingredient.of(ItemTags.STONE_TOOL_MATERIALS);
    }),
    COPPER(0, 231, 2.0F, 0.0F, 1, () -> {
        return Ingredient.of(Items.COPPER_INGOT);
    }),
    AMETHYST(0, 273, 5.0F, 1.0F, 5, () -> {
        return Ingredient.of(Items.AMETHYST_SHARD);
    }),
    QUARTZ(0, 267, 7.0F, 0.5F, 3, () -> {
        return Ingredient.of(Items.QUARTZ);
    }),
    IRON(0, 320, 6.0F, 0.0F, 1, () -> {
        return Ingredient.of(Items.IRON_INGOT);
    }),
    DIAMOND(0, 761, 8.0F, 2.0F, 1, () -> {
        return Ingredient.of(Items.DIAMOND);
    }),
    GOLD(0, 72, 12.0F, 0.0F, 26, () -> {
        return Ingredient.of(Items.GOLD_INGOT);
    }),
    NETHERITE(0, 1131, 9.0F, 2.0F, 1, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    VanillaClawsMaterials(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
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
}
