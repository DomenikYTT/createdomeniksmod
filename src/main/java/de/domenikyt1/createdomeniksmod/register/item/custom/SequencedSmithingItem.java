package de.domenikyt1.createdomeniksmod.register.item.custom;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SequencedSmithingItem extends SequencedAssemblyItem {
    public SequencedSmithingItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.empty());
        tooltipComponents.add(Component.literal("§8this Item can be used to make Smithing Templates!"));
    }
}
