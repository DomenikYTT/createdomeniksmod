package de.domenikyt1.createdomeniksmod.register.item;

import de.domenikyt1.createdomeniksmod.Tags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier ELEMENTIUM = new SimpleTier(Tags.Blocks.INCORRECT_FOR_ELEMENTIUM_TOOL,
            2000, 10.0f, 3f, 15, () -> Ingredient.of(ModItems.ELEMENTIUM_INGOT));
}
