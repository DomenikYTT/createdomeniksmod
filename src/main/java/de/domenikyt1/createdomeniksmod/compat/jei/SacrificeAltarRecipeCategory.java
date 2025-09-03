package de.domenikyt1.createdomeniksmod.compat.jei;


import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.block.CDMBlocks;
import de.domenikyt1.createdomeniksmod.block.ModBlocks;
import de.domenikyt1.createdomeniksmod.item.ModItems;
import de.domenikyt1.createdomeniksmod.recipe.PedestalRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;

public class SacrificeAltarRecipeCategory implements IRecipeCategory<PedestalRecipe> {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, "sacrifice_altar");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, "textures/jei/sacrifice_altar.png");


    public static final RecipeType<PedestalRecipe> PEDESTAL_RECIPE_RECIPE_TYPE = new RecipeType<>(UID, PedestalRecipe.class);



    private final IDrawable background;
    private final IDrawable icon;

    public SacrificeAltarRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 144, 81);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(CDMBlocks.SACRIFICE_ALTAR.get()));
    }

    @Override
    public RecipeType<PedestalRecipe> getRecipeType() {
        return PEDESTAL_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.createdomeniksmod.sacrifice_altar");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PedestalRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 33, 33).addIngredients(recipe.getIngredients().get(0));


        builder.addSlot(RecipeIngredientRole.INPUT, 7, 7).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 33, 1).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 59, 7).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 65, 33).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 59, 59).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 33, 64).addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 7, 59).addIngredients(recipe.getIngredients().get(7));
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 33).addIngredients(recipe.getIngredients().get(8));

        ItemStack stack = ModItems.INFO.asStack();
        String entityType = recipe.entityType().toString().substring(17).replace("_", " ");
        String[] words = entityType.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0))) // erster Buchstabe groß
                        .append(word.substring(1))                     // Rest bleibt
                        .append(" ");
            }
        }
        entityType = result.toString();

        stack.set(DataComponents.CUSTOM_NAME, Component.literal("§4Kill an §a" + entityType));
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 92, 33).addItemStack((stack));



        builder.addSlot(RecipeIngredientRole.OUTPUT, 123, 33).addItemStack(recipe.getResultItem(null));
    }
}
