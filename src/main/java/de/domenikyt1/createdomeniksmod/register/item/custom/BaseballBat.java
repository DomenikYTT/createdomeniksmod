package de.domenikyt1.createdomeniksmod.register.item.custom;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Tool.Rule;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

public class BaseballBat extends TieredItem {
    public BaseballBat(Tier p_43269_, Item.Properties p_43272_) {
        super(p_43269_, p_43272_.component(DataComponents.TOOL, createToolProperties()));
    }

    public BaseballBat(Tier tier, Item.Properties properties, Tool toolComponentData) {
        super(tier, properties.component(DataComponents.TOOL, toolComponentData));
    }

    public static Tool createToolProperties() {
        return new Tool(List.of(Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public static ItemAttributeModifiers createAttributes(Tier p_330371_, int p_331976_, float p_332104_) {
        return createAttributes(p_330371_, (float)p_331976_, p_332104_);
    }

    public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(p_331976_ + p_330371_.getAttackDamageBonus()), Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)p_332104_, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    public boolean canAttackBlock(BlockState p_43291_, Level p_43292_, BlockPos p_43293_, Player p_43294_) {
        return !p_43294_.isCreative();
    }

    public boolean hurtEnemy(ItemStack p_43278_, LivingEntity p_43279_, LivingEntity p_43280_) {
        return true;
    }

    public void postHurtEnemy(ItemStack p_345553_, LivingEntity p_345771_, LivingEntity p_346282_) {
        p_345553_.hurtAndBreak(1, p_346282_, EquipmentSlot.MAINHAND);
    }



    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_SWORD_ACTIONS.contains(itemAbility);
    }




    @Override
    public void appendHoverText(ItemStack Stack, TooltipContext Context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.empty());
            tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.baseball_bat.0"));
            tooltipComponents.add(Component.literal("§c" + Minecraft.getInstance().getUser().getName()));
            if(Screen.hasControlDown()) {
                tooltipComponents.add(Component.empty());
                tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.lavundel.credits.strg_down0"));
                tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.lavundel.credits.strg_down1"));
            } else {
                tooltipComponents.add(Component.empty());
                tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.credits.press_strg"));


            }
        } else {
            tooltipComponents.add(Component.empty());
            tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.info.shift"));
            if(Screen.hasControlDown()) {
                tooltipComponents.add(Component.empty());
                tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.lavundel.credits.strg_down0"));
                tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.lavundel.credits.strg_down1"));
            } else {
                tooltipComponents.add(Component.empty());
                tooltipComponents.add(Component.translatable("tooltip.createdomeniksmod.credits.press_strg"));


            }
        }
        super.appendHoverText(Stack, Context, tooltipComponents, tooltipFlag);
    }
}
