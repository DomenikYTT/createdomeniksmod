package de.domenikyt1.createdomeniksmod.register.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import de.domenikyt1.createdomeniksmod.CDMItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.ApiStatus.Internal;

public class CDMArmorMaterial {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS;
    public static final Holder<ArmorMaterial> ELEMENTIUM;

    public CDMArmorMaterial() {
    }

    private static Holder<ArmorMaterial> register(String name, int[] defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath("createdomeniksmod", name)));
        return register(name, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static Holder<ArmorMaterial> register(String name, int[] defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngridient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = Type.values();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            ArmorItem.Type armoritem$type = var9[var11];
            enummap.put(armoritem$type, defense[armoritem$type.ordinal()]);
        }

        return ARMOR_MATERIALS.register(name, () -> {
            return new ArmorMaterial(enummap, enchantmentValue, equipSound, repairIngridient, layers, toughness, knockbackResistance);
        });
    }

    @Internal
    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }

    static {
        ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, "createdomeniksmod");
        ELEMENTIUM = register("elementium", new int[]{5, 10, 8, 5, 15}, 28, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> {
            return Ingredient.of(new ItemLike[]{CDMItems.ELEMENTIUM_INGOT});
        });
    }
}
