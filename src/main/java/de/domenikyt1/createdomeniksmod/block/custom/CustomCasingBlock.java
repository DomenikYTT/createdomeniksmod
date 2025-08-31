package de.domenikyt1.createdomeniksmod.block.custom;

import com.simibubi.create.content.decoration.encasing.CasingBlock;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class CustomCasingBlock extends CasingBlock {
    public CustomCasingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.empty());
            tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.Casings.shift_down"));
        } else {
            tooltipComponents.add(Component.empty());
            tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.info.shift"));
        }
        super.appendHoverText(stack, context, tooltipComponents, flag);
    }
}
