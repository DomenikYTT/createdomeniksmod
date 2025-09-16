package de.domenikyt1.createdomeniksmod.register.block.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class AsphaltBlock extends Block {
    // Effekt-Stufe (Amplifier). 0 = Speed I, 1 = Speed II, usw.
    private final int amplifier;

    public AsphaltBlock(Properties properties, int amplifier) {
        super(properties);
        this.amplifier = amplifier;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            // Solange der Spieler auf dem Block steht → Effekt erneuern
            player.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SPEED,
                    5,              // Dauer in Ticks (1 Sekunde), wird bei jedem Tick erneuert
                    amplifier,       // Verstärkung (0 = Speed I)
                    true,            // Ambient (kleine Partikel)
                    false            // Partikel sichtbar
            ));
        }
        super.stepOn(level, pos, state, entity);
    }
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(!Screen.hasShiftDown()) {
            tooltipComponents.add(Component.empty());
            tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.info.shift"));
        } else {
         tooltipComponents.add(Component.empty());
         tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.speed_multiplier0"));
         tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.speed_multiplier1"));
         tooltipComponents.add(Component.literal("§a" + amplifier));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
