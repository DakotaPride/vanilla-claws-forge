package net.dakotapride.vanilla_claws.item;

import net.minecraft.ChatFormatting;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IntegratedClawsItem extends ClawsItem {
    public String requiredMod;
    public boolean isRequiredModInstalled;

    public IntegratedClawsItem(Tier pTier, int damage, float attackSpeed, Properties pProperties) {
        super(pTier, damage, attackSpeed, pProperties);
        this.requiredMod = "gobber2";
        this.isRequiredModInstalled = ModList.get().isLoaded("gobber2");
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pListComponent, @NotNull TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pLevel, pListComponent, pTooltipFlag);
        if(!isRequiredModInstalled) {
            String text = Language.getInstance().getOrDefault("tooltip.vanilla_claws.requires_mod");
            text = text.replaceAll("%", requiredMod.substring(0, 1).toUpperCase() + requiredMod.substring(1));
            pListComponent.add(Component.literal(text).copy().setStyle(Style.EMPTY.withColor(TextColor.fromLegacyFormat(ChatFormatting.GRAY))));
        }
    }

}
