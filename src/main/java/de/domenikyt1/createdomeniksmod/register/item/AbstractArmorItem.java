package de.domenikyt1.createdomeniksmod.register.item;

import com.google.common.collect.Multimap;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public abstract class AbstractArmorItem extends ArmorItem {
    public AbstractArmorItem(Holder<ArmorMaterial> pMaterial, ArmorItem.Type pType, Item.Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public boolean isFullSetActive(LivingEntity living) {
        return isFullSetActive(living, this.getMaterial());
    }

    public static boolean isFullSetActive(LivingEntity living, Holder<ArmorMaterial> materials) {
        if (living == null) {
            return false;
        } else {
            Item var4 = living.getItemBySlot(EquipmentSlot.HEAD).getItem();
            ArmorItem var10000;
            if (var4 instanceof ArmorItem) {
                ArmorItem armorItem = (ArmorItem)var4;
                var10000 = armorItem;
            } else {
                var10000 = null;
            }

            ArmorItem head = var10000;
            Item chestPlate = living.getItemBySlot(EquipmentSlot.CHEST).getItem();
            if (!(chestPlate instanceof ElytraItem) && !(chestPlate instanceof AirItem)) {
                ArmorItem chest = (ArmorItem)living.getItemBySlot(EquipmentSlot.CHEST).getItem();
                Item var7 = living.getItemBySlot(EquipmentSlot.LEGS).getItem();
                ArmorItem feet;
                if (var7 instanceof ArmorItem) {
                    feet = (ArmorItem)var7;
                    var10000 = feet;
                } else {
                    var10000 = null;
                }

                ArmorItem legs = var10000;
                Item var8 = living.getItemBySlot(EquipmentSlot.FEET).getItem();
                if (var8 instanceof ArmorItem) {
                    ArmorItem armorItem = (ArmorItem)var8;
                    var10000 = armorItem;
                } else {
                    var10000 = null;
                }

                feet = var10000;
                return head != null && legs != null && feet != null && head.getMaterial() == materials && chest.getMaterial() == materials && legs.getMaterial() == materials && feet.getMaterial() == materials;
            } else {
                return false;
            }
        }
    }

    public Multimap<Attribute, AttributeModifier> getAttributeMods(EquipmentSlot slot) {
        return null;
    }

    public static ResourceLocation makeCustomTextureLocation(String nameSpace, String id) {
        return ResourceLocation.fromNamespaceAndPath(nameSpace, "textures/models/armor/custom/" + id + ".png");
    }

    public static <T extends AbstractArmorItem> Map<ArmorItem.Type, DeferredItem<T>> createRegistry(DeferredRegister.Items registry, String baseName, Function<ArmorItem.Type, T> creator) {
        return (Map)Util.make(new EnumMap(ArmorItem.Type.class), (map) -> {
            ArmorItem.Type[] var4 = Type.values();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                ArmorItem.Type type = var4[var6];
                if (type != Type.BODY) {
                    map.put(type, registry.register(baseName + "_" + type.getName(), () -> {
                        return (AbstractArmorItem)creator.apply(type);
                    }));
                }
            }

        });
    }
}
