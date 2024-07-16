package net.dakotapride.vanilla_claws.item.material;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum VanillaClawsMaterials implements Tier {
    WOOD(79, 10, () -> {
        return Ingredient.of(ItemTags.PLANKS);
    }),
    STONE(161, 11, () -> {
        return Ingredient.of(ItemTags.STONE_TOOL_MATERIALS);
    }),
    COPPER(231, 11, () -> {
        return Ingredient.of(Items.COPPER_INGOT);
    }),
    IRON(320, 15, () -> {
        return Ingredient.of(Items.IRON_INGOT);
    }),
    DIAMOND(761, 18, () -> {
        return Ingredient.of(Items.DIAMOND);
    }),
    GOLD(72, 26, () -> {
        return Ingredient.of(Items.GOLD_INGOT);
    }),
    NETHERITE(1131, 24, () -> {
        return Ingredient.of(Items.NETHERITE_INGOT);
    });

    private final int uses;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    VanillaClawsMaterials(int pUses, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
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
}
