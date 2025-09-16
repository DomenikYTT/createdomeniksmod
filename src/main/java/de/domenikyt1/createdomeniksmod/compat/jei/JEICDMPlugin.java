package de.domenikyt1.createdomeniksmod.compat.jei;


import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.register.block.CDMBlocks;
import de.domenikyt1.createdomeniksmod.register.recipe.ModRecipes;
import de.domenikyt1.createdomeniksmod.register.recipe.PedestalRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEICDMPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SacrificeAltarRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<PedestalRecipe> sacrifice_altar = recipeManager
                .getAllRecipesFor(ModRecipes.PEDESTAL_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(SacrificeAltarRecipeCategory.PEDESTAL_RECIPE_RECIPE_TYPE, sacrifice_altar);

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(CDMBlocks.SACRIFICE_ALTAR.get()), SacrificeAltarRecipeCategory.PEDESTAL_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(CDMBlocks.PEDESTAL.get()), SacrificeAltarRecipeCategory.PEDESTAL_RECIPE_RECIPE_TYPE);


    }
}
