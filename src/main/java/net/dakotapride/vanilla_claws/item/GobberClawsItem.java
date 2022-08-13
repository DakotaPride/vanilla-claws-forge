package net.dakotapride.vanilla_claws.item;

import net.minecraft.world.item.Tier;

public class GobberClawsItem extends Gobber2IntegratedClawsItem {
    public GobberClawsItem(String requiredMod, Tier pTier, int damage, float attackSpeed, Properties pProperties) {
        super(pTier, damage, attackSpeed, pProperties);
    }

    public GobberClawsItem(Tier pTier, int damage, float speed, Properties pProperties) {
        super(pTier, damage, speed, pProperties);
    }
}
