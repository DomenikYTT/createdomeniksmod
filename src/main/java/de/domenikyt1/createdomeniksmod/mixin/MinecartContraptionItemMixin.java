package de.domenikyt1.createdomeniksmod.mixin;

import com.simibubi.create.content.contraptions.mounted.MinecartContraptionItem;
import com.simibubi.create.content.equipment.wrench.WrenchItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecartContraptionItem.class)
public class MinecartContraptionItemMixin {

    @Redirect(
            method = "wrenchCanBeUsedToPickUpMinecartContraptions",
            at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/ItemEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z")
    )
    private static boolean replaceWrenchCheck(ItemEntry instance, ItemStack stack) {
        return stack.getItem() instanceof WrenchItem;
    }
}
