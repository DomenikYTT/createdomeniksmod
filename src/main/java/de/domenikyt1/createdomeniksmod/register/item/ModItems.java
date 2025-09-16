package de.domenikyt1.createdomeniksmod.register.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.register.item.custom.*;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;

public class ModItems {
    private static final String MOD_ID = CDM.MOD_ID;

    public static final ItemEntry<nottabItem> INCOMPLETE_FIRE_COAL =
            REGISTRATE.item("incomplete_fire_coal", nottabItem::new)
                    .register();

    public static final ItemEntry<FireCoal> FIRE_COAL =
            REGISTRATE.item("fire_coal", properties -> new FireCoal(properties, 2400))
                    .register();
    public static final ItemEntry<BaseballBat> BASEBALL_BAT =
            REGISTRATE.item("baseball_bat", properties -> new BaseballBat(Tiers.WOOD, (new Item.Properties()
                    .durability(690)
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .requiredFeatures()
                    .attributes(BaseballBat.createAttributes(Tiers.WOOD, 4, 6.0F))
                    )))
                    .register();

    public static final ItemEntry<Item> CHOCOLATE_COIN =
            REGISTRATE.item("chocolate_coin", properties -> new Item((new Item.Properties()
                            .food(new FoodProperties.Builder()
                                    .nutrition(10)
                                    .saturationModifier(3)
                                    .build())
                    )))
                    .register();


    public static final ItemEntry<HatItem> WIZZARD_HAT =
            REGISTRATE.item("wizzard_hat", properties -> new HatItem((new Item.Properties()
                            .stacksTo(1)
            )))
                    .register();

    public static final ItemEntry<HatItem> BANDANA =
            REGISTRATE.item("bandana", properties -> new HatItem((new Item.Properties()
                            .stacksTo(1)
                    )))
                    .register();

    public static final ItemEntry<nottabItem> INFO =
            REGISTRATE.item("info", properties -> new nottabItem(new Item.Properties()
                            .stacksTo(1)
                    ))
                    .register();

    public static final ItemEntry<Item> ELEMENTIUM_INGOT =
            REGISTRATE.item("elementium_ingot", Item::new)
                    .register();

    public static final ItemEntry<Item> RAW_ELEMENTIUM =
            REGISTRATE.item("raw_elementium", Item::new)
                    .register();

    public static final ItemEntry<PickaxeItem> ELEMENTIUM_PICKAXE =
            REGISTRATE.item("elementium_pickaxe", properties -> new PickaxeItem(ModToolTiers.ELEMENTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ELEMENTIUM, 1, 6.8f)).stacksTo(1)))
                    .register();

    public static final ItemEntry<SwordItem> ELEMENTIUM_SWORD =
            REGISTRATE.item("elementium_sword", properties -> new SwordItem(ModToolTiers.ELEMENTIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.ELEMENTIUM, 10, 6f)).stacksTo(1)))
                    .register();

    public static final ItemEntry<BowItem> ELEMENTIUM_BOW =
            REGISTRATE.item("elementium_bow", properties -> new BowItem(new Item.Properties().durability(1400).stacksTo(1)))
                    .register();

    public static final ItemEntry<AxeItem> ELEMENTIUM_AXE =
            REGISTRATE.item("elementium_axe", properties -> new AxeItem(ModToolTiers.ELEMENTIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.ELEMENTIUM, 14, 3f))))
                    .register();

    public static final ItemEntry<ShovelItem> ELEMENTIUM_SHOVEL =
            REGISTRATE.item("elementium_shovel", properties -> new ShovelItem(ModToolTiers.ELEMENTIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.ELEMENTIUM, 1, 6f)).stacksTo(1)))
                    .register();

    public static final ItemEntry<HoeItem> ELEMENTIUM_HOE =
            REGISTRATE.item("elementium_hoe", properties -> new HoeItem(ModToolTiers.ELEMENTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ELEMENTIUM, 1, 6f)).stacksTo(1)))
                    .register();

    public static final ItemEntry<Item> ELEMENTIUM_ROD =
            REGISTRATE.item("elementium_rod", Item::new)
                    .register();

    public static final ItemEntry<HammerItem> ELEMENTIUM_HAMMER =
            REGISTRATE.item("elementium_hammer", properties -> new HammerItem(ModToolTiers.ELEMENTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ELEMENTIUM, 1, 6.8f)).stacksTo(1)))
                    .register();

    public static final ItemEntry<ExcavatorItem> ELEMENTIUM_EXCAVATOR =
            REGISTRATE.item("elementium_excavator", properties -> new ExcavatorItem(ModToolTiers.ELEMENTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.ELEMENTIUM, 1, 6.8f)).stacksTo(1)))
                    .register();


    /*      Armor       */

    public static final ItemEntry<ArmorItem> ELEMENTIUM_HELMET =
            REGISTRATE.item("elementium_helmet", properties -> new ArmorItem(ModArmorMaterial.ELEMENTIUM_ARMOR_MATERIAL,
                            ArmorItem.Type.HELMET, new Item.Properties()))
                    .properties(p -> p
                            .durability(ArmorItem.Type.HELMET.getDurability(15))
                            .stacksTo(1)
                    )
                    .register();

    public static final ItemEntry<ArmorItem> ELEMENTIUM_CHESTPLATE =
            REGISTRATE.item("elementium_chestplate", properties -> new ArmorItem(ModArmorMaterial.ELEMENTIUM_ARMOR_MATERIAL,
                            ArmorItem.Type.CHESTPLATE, new Item.Properties()))
                    .properties(p -> p
                            .durability(ArmorItem.Type.CHESTPLATE.getDurability(15))
                            .stacksTo(1)
                    )
                    .register();

    public static final ItemEntry<ArmorItem> ELEMENTIUM_LEGGINGS =
            REGISTRATE.item("elementium_leggings", properties -> new ArmorItem(ModArmorMaterial.ELEMENTIUM_ARMOR_MATERIAL,
                            ArmorItem.Type.LEGGINGS, new Item.Properties()))
                    .properties(p -> p
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(15))
                            .stacksTo(1)
                    )
                    .register();

    public static final ItemEntry<ArmorItem> ELEMENTIUM_BOOTS =
            REGISTRATE.item("elementium_boots", properties -> new ArmorItem(ModArmorMaterial.ELEMENTIUM_ARMOR_MATERIAL,
                            ArmorItem.Type.BOOTS, new Item.Properties()))
                    .properties(p -> p
                            .durability(ArmorItem.Type.BOOTS.getDurability(15))
                            .stacksTo(1)
                    )
                    .register();





    public static void register() {
    }
}
