package de.domenikyt1.createdomeniksmod.register.item;

import de.domenikyt1.createdomeniksmod.CDMItems;
import de.domenikyt1.createdomeniksmod.CDMTags.Blocks;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public enum CDMToolTiers implements Tier {
    ELEMENTIUM(Blocks.INCORRECT_FOR_ELEMENTIUM_TOOL, 2000, 10.0F, 3.0F, 28, Ingredient.of(new ItemLike[]{CDMItems.ELEMENTIUM_INGOT}));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    private CDMToolTiers(TagKey incorrectBlocksForDrops, int uses, float speed, float attackDamageBonus, int enchantmentValue, Ingredient repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    public float getSpeed() {
        return this.speed;
    }

    public int getUses() {
        return this.uses;
    }
}
