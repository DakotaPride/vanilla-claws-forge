package net.dakotapride.vanilla_claws.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class EndGobberClawsItem extends GobberClawsItem {
    public EndGobberClawsItem(String requiredMod, Tier pTier, int damage, float attackSpeed, Properties pProperties) {
        super(requiredMod, pTier, damage, attackSpeed, pProperties);
    }

    public EndGobberClawsItem(Tier pTier, int damage, float speed, Properties pProperties) {
        super(pTier, damage, speed, pProperties);
    }

    @Override
    public void onCraftedBy(ItemStack pStack, Level pLevel, Player pPlayer) {
        if(pLevel.isClientSide) return;
        pStack.serializeNBT().putInt("Unbreakable", 1);
    }
}
