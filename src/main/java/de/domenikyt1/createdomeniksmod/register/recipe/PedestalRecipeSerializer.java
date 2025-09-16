package de.domenikyt1.createdomeniksmod.register.recipe;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.Arrays;

public class PedestalRecipeSerializer implements RecipeSerializer<PedestalRecipe> {

    /**
     * Custom Codec, der sowohl einzelne Ingredients als auch
     * Arrays von Ingredients akzeptiert – dein gewünschtes Schema.
     */
    public static final Codec<Ingredient> MULTI_INGREDIENT_CODEC = Codec.either(
            Ingredient.CODEC_NONEMPTY,
            Ingredient.CODEC_NONEMPTY.listOf()
    ).xmap(
            either -> {
                if (either.left().isPresent()) {
                    // normaler Ingredient-Fall
                    return either.left().get();
                } else {
                    // Array-Fall -> baue ein einziges Ingredient aus allen Items
                    return Ingredient.fromValues(
                            either.right().get().stream()
                                    .flatMap(i -> Arrays.stream(i.getItems()))
                                    .map(stack -> new Ingredient.ItemValue(stack))
                    );
                }
            },
            ingredient -> Either.left(ingredient) // Beim Schreiben als normal
    );

    public static final MapCodec<PedestalRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            MULTI_INGREDIENT_CODEC
                    .listOf()
                    .fieldOf("ingredients")
                    .flatXmap(
                            list -> {
                                Ingredient[] aingredient = list.toArray(Ingredient[]::new);
                                return DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
                            },
                            DataResult::success
                    ).forGetter(PedestalRecipe::getIngredients),
            ItemStack.CODEC.fieldOf("result").forGetter(PedestalRecipe::output),
            BuiltInRegistries.ENTITY_TYPE.byNameCodec().fieldOf("entityType").forGetter(PedestalRecipe::entityType)
    ).apply(inst, PedestalRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, PedestalRecipe> STREAM_CODEC =
            StreamCodec.of(PedestalRecipeSerializer::toNetwork, PedestalRecipeSerializer::fromNetwork);

    @Override
    public MapCodec<PedestalRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, PedestalRecipe> streamCodec() {
        return STREAM_CODEC;
    }

    private static PedestalRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
        int i = buffer.readVarInt();
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
        nonnulllist.replaceAll(p -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
        ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
        EntityType<?> entityType = ByteBufCodecs.registry(Registries.ENTITY_TYPE).decode(buffer);

        return new PedestalRecipe(nonnulllist, itemstack, entityType);
    }

    private static void toNetwork(RegistryFriendlyByteBuf buffer, PedestalRecipe recipe) {
        buffer.writeVarInt(recipe.ingredients().size());

        for (Ingredient ingredient : recipe.ingredients()) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
        }

        ItemStack.STREAM_CODEC.encode(buffer, recipe.output());
        ByteBufCodecs.registry(Registries.ENTITY_TYPE).encode(buffer, recipe.entityType());
    }
}