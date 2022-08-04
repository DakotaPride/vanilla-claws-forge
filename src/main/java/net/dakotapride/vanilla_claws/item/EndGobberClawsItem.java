package net.dakotapride.vanilla_claws.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class EndGobberClawsItem extends GobberClawsItem {
    public EndGobberClawsItem(String requiredMod, Tier pTier, int damage, float attackSpeed, Properties pProperties) {
        super(requiredMod, pTier, damage, attackSpeed, pProperties);
    }

    public EndGobberClawsItem(Tier pTier, int damage, float speed, Properties pProperties) {
        super(pTier, damage, speed, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pLivingEntity, @NotNull LivingEntity pTarget) {
        pStack.setDamageValue(0);
        return true;
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack pStack, @NotNull Level pLevel, BlockState pBlockState, @NotNull BlockPos pBlockPos, @NotNull LivingEntity pLivingEntity) {
        Block pBlock = pBlockState.getBlock();
        if ((double)pBlock.defaultDestroyTime() != 0.0D) {
            pStack.setDamageValue(0);
        }

        return true;
    }
}
