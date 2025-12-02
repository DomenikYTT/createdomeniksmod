package de.domenikyt1.createdomeniksmod.register.item;

import java.util.List;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class FireCoal extends Item {
    private int burnTime = 0;

    public FireCoal(Item.Properties properties, int burnTime) {
        super(properties);
        this.burnTime = burnTime;
    }

    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }

    public void appendHoverText(ItemStack Stack, Item.TooltipContext Context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.empty());
            tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.fire_coal"));
            tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.fire_coal.shift_down"));
        } else {
            tooltipComponents.add(Component.empty());
            tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.info.shift"));
        }

        super.appendHoverText(Stack, Context, tooltipComponents, tooltipFlag);
    }
}
