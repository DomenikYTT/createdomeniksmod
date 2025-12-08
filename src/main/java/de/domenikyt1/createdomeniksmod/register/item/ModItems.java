package de.domenikyt1.createdomeniksmod.register.item;

import com.simibubi.create.content.equipment.wrench.WrenchItem;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.register.item.custom.*;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;

public class ModItems {
    private static final String MOD_ID = CDM.MOD_ID;

    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_FIRE_COAL =
            REGISTRATE.item("incomplete_fire_coal", SequencedAssemblyItem::new).register();

    public static final ItemEntry<SequencedSmithingItem> INCOMPLETE_SMITHING_UPGRADE_TEMPLATE =
            REGISTRATE.item("incomplete_elementium_smithing_upgrade_template", SequencedSmithingItem::new).register();

    public static final ItemEntry<SequencedSmithingItem> INCOMPLETE_COSMETIC_SMITHING_TEMPLATE =
            REGISTRATE.item("incomplete_cosmetic_smithing_template", SequencedSmithingItem::new).register();




    public static final ItemEntry<Item> COSMETIC_SMITHING_TEMPLATE =
            REGISTRATE.item("cosmetic_smithing_template", Item::new).register();


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
            REGISTRATE.item("elementium_pickaxe", properties -> new PickaxeItem(CDMToolTiers.ELEMENTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(CDMToolTiers.ELEMENTIUM, 1, 6.8f)).stacksTo(1)))
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE)
                    .register();

    public static final ItemEntry<SwordItem> ELEMENTIUM_SWORD =
            REGISTRATE.item("elementium_sword", properties -> new SwordItem(CDMToolTiers.ELEMENTIUM, new Item.Properties().attributes(SwordItem.createAttributes(CDMToolTiers.ELEMENTIUM, 10, 6f)).stacksTo(1)))
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.SWORD_ENCHANTABLE)
                    .register();

    public static final ItemEntry<BowItem> ELEMENTIUM_BOW =
            REGISTRATE.item("elementium_bow", properties -> new BowItem(new Item.Properties().durability(1400).stacksTo(1)))
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.BOW_ENCHANTABLE)
                    .register();

    public static final ItemEntry<AxeItem> ELEMENTIUM_AXE =
            REGISTRATE.item("elementium_axe", properties -> new AxeItem(CDMToolTiers.ELEMENTIUM, new Item.Properties().attributes(AxeItem.createAttributes(CDMToolTiers.ELEMENTIUM, 14, 3f))))
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE)
                    .register();

    public static final ItemEntry<ShovelItem> ELEMENTIUM_SHOVEL =
            REGISTRATE.item("elementium_shovel", properties -> new ShovelItem(CDMToolTiers.ELEMENTIUM, new Item.Properties().attributes(ShovelItem.createAttributes(CDMToolTiers.ELEMENTIUM, 1, 6f)).stacksTo(1)))
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE)
                    .register();

    public static final ItemEntry<HoeItem> ELEMENTIUM_HOE =
            REGISTRATE.item("elementium_hoe", properties -> new HoeItem(CDMToolTiers.ELEMENTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(CDMToolTiers.ELEMENTIUM, 1, 6f)).stacksTo(1)))
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE)
                    .register();

    public static final ItemEntry<Item> ELEMENTIUM_ROD =
            REGISTRATE.item("elementium_rod", Item::new)
                    .register();

    public static final ItemEntry<HammerItem> ELEMENTIUM_HAMMER =
            REGISTRATE.item("elementium_hammer", properties -> new HammerItem(CDMToolTiers.ELEMENTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(CDMToolTiers.ELEMENTIUM, 1, 6.8f)).stacksTo(1)))
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE)
                    .register();

    public static final ItemEntry<ExcavatorItem> ELEMENTIUM_EXCAVATOR =
            REGISTRATE.item("elementium_excavator", properties -> new ExcavatorItem(CDMToolTiers.ELEMENTIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(CDMToolTiers.ELEMENTIUM, 1, 6.8f)).stacksTo(1)))
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MINING_ENCHANTABLE)
                    .register();


    /*      Armor       */

    public static final ItemEntry<ArmorItem> ELEMENTIUM_HELMET =
            REGISTRATE.item("elementium_helmet", properties -> new ArmorItem(CDMArmorMaterial.ELEMENTIUM,
                            ArmorItem.Type.HELMET, new Item.Properties()))
                    .properties(p -> p
                            .durability(ArmorItem.Type.HELMET.getDurability(15))
                            .stacksTo(1)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.HEAD_ARMOR)
                    .register();

    public static final ItemEntry<ArmorItem> ELEMENTIUM_CHESTPLATE =
            REGISTRATE.item("elementium_chestplate", properties -> new ArmorItem(CDMArmorMaterial.ELEMENTIUM,
                            ArmorItem.Type.CHESTPLATE, new Item.Properties()))
                    .properties(p -> p
                            .durability(ArmorItem.Type.CHESTPLATE.getDurability(15))
                            .stacksTo(1)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.CHEST_ARMOR)
                    .register();

    public static final ItemEntry<ArmorItem> ELEMENTIUM_LEGGINGS =
            REGISTRATE.item("elementium_leggings", properties -> new ArmorItem(CDMArmorMaterial.ELEMENTIUM,
                            ArmorItem.Type.LEGGINGS, new Item.Properties()))
                    .properties(p -> p
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(15))
                            .stacksTo(1)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.LEG_ARMOR)
                    .register();

    public static final ItemEntry<ArmorItem> ELEMENTIUM_BOOTS =
            REGISTRATE.item("elementium_boots", properties -> new ArmorItem(CDMArmorMaterial.ELEMENTIUM,
                            ArmorItem.Type.BOOTS, new Item.Properties()))
                    .properties(p -> p
                            .durability(ArmorItem.Type.BOOTS.getDurability(15))
                            .stacksTo(1)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.FOOT_ARMOR)
                    .register();

    public static final ItemEntry<Item> ELEMENTIUM_SMITHING_UPGRADE_TEMPLATE =
            REGISTRATE.item("elementium_smithing_upgrade_template", Item::new)
                    .register();


    public static final ItemEntry<WrenchItem> RGB_WRENCH =
            REGISTRATE.item("rgb_wrench", WrenchItem::new).register();


    public static final ItemEntry<WrenchItem> RED_WRENCH =
            REGISTRATE.item("red_wrench", WrenchItem::new).register();


    public static final ItemEntry<WrenchItem> BLUE_WRENCH =
            REGISTRATE.item("blue_wrench", WrenchItem::new).register();


    public static final ItemEntry<WrenchItem> YELLOW_WRENCH =
            REGISTRATE.item("yellow_wrench", WrenchItem::new).register();


    public static final ItemEntry<WrenchItem> PINK_WRENCH =
            REGISTRATE.item("pink_wrench", WrenchItem::new).register();


    public static final ItemEntry<WrenchItem> GRAY_WRENCH =
            REGISTRATE.item("gray_wrench", WrenchItem::new).register();


    public static final ItemEntry<WrenchItem> GREEN_WRENCH =
            REGISTRATE.item("green_wrench", WrenchItem::new).register();


    public static final ItemEntry<WrenchItem> BLACK_WRENCH =
            REGISTRATE.item("black_wrench", WrenchItem::new).register();


    public static final ItemEntry<MaceItem> MACE_3D_0 =
            REGISTRATE.item("3d_mace", MaceItem::new)
                    .properties(p -> p
                            .durability(500)
                    )
                    .register();


    public static final ItemEntry<MaceItem> MACE_SPLAT_ROLLER =
            REGISTRATE.item("mace_splat_roller", MaceItem::new)
                    .properties(p -> p
                            .durability(500)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MACE_ENCHANTABLE)
                    .register();


    public static final ItemEntry<MaceItem> MACE_HAMMER =
            REGISTRATE.item("mace_hammer", MaceItem::new)
                    .properties(p -> p
                            .durability(500)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MACE_ENCHANTABLE)
                    .register();


    public static final ItemEntry<MaceItem> ASTRAL_MACE =
            REGISTRATE.item("astral_mace", MaceItem::new)
                    .properties(p -> p
                            .durability(500)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MACE_ENCHANTABLE)
                    .register();


    public static final ItemEntry<MaceItem> MACE_SILVER_STRIKE =
            REGISTRATE.item("silver_strike_mace", MaceItem::new)
                    .properties(p -> p
                            .durability(500)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MACE_ENCHANTABLE)
                    .register();


    public static final ItemEntry<MaceItem> MACE_WARDENS_WRATH =
            REGISTRATE.item("wardens_wrath_mace", MaceItem::new)
                    .properties(p -> p
                            .durability(500)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MACE_ENCHANTABLE)
                    .register();


    public static final ItemEntry<ElementiumMaceItem> ELEMENTIUM_MACE =
            REGISTRATE.item("elementium_mace", properties -> new ElementiumMaceItem(new Item.Properties(), 3, 6.0, -3.2))
                    .properties(p -> p
                            .durability(1000)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MACE_ENCHANTABLE)
                    .register();


    public static final ItemEntry<ElementiumMaceItem> ELEMENTIUM_MACE_3D =
            REGISTRATE.item("3d_elementium_mace", properties -> new ElementiumMaceItem(new Item.Properties(), 3, 6.0, -3.2))
                    .properties(p -> p
                            .durability(1000)
                    )
                    .tag(ItemTags.DURABILITY_ENCHANTABLE, ItemTags.MACE_ENCHANTABLE)
                    .register();





    public static void register() {
    }
}