package de.domenikyt1.createdomeniksmod.register.block;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import de.domenikyt1.createdomeniksmod.register.block.custom.*;
import de.domenikyt1.createdomeniksmod.register.item.ModItems;
import de.domenikyt1.createdomeniksmod.registry.custom.CDMTextureShifts;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.neoforged.neoforge.common.Tags;


import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;


public class CDMBlocks {

    /*      CASINGS     */
    public static final BlockEntry<CustomCasingBlock> FIRE_CASING =
            REGISTRATE.block("fire_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.FIRE_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.STONE).forceSolidOff())
                    .transform(axeOrPickaxe())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> TEMPLATE_CASING =
            REGISTRATE.block("template_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.TEMPLATE_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.STONE).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();


    public static final BlockEntry<CustomCasingBlock> RGB_CASING =
            REGISTRATE.block("rgb_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.RGB_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> RED_CASING =
            REGISTRATE.block("red_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.RED_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> BLUE_CASING =
            REGISTRATE.block("blue_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.BLUE_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> BLACK_CASING =
            REGISTRATE.block("black_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.BLACK_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> GRAY_CASING =
            REGISTRATE.block("gray_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.GRAY_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> PINK_CASING =
            REGISTRATE.block("pink_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.PINK_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> YELLOW_CASING =
            REGISTRATE.block("yellow_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.YELLOW_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> LIME_CASING =
            REGISTRATE.block("lime_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.LIME_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();



    public static final BlockEntry<AltarBlock> SACRIFICE_ALTAR =
            REGISTRATE.block("sacrifice_altar", AltarBlock::new)
                    .properties(p -> p.noOcclusion()
                            .sound(SoundType.STONE)
                            .destroyTime(1.5f)
                            .explosionResistance(0.1f))
                    .transform(pickaxeOnly())
                    .item()
                    .build()
                    .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .register();

    public static final BlockEntry<PedestalBlock> PEDESTAL =
            REGISTRATE.block("pedestal", PedestalBlock::new)
                    .properties(p -> p.noOcclusion()
                            .sound(SoundType.STONE)
                            .destroyTime(1.5f)
                            .explosionResistance(0.1f))
                    .transform(pickaxeOnly())
                    .item()
                    .build()
                    .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .register();

    public static final BlockEntry<cooltendo> COOLTENDO_SWATCH =
            REGISTRATE.block("cooltendo_swatch", cooltendo::new)
                    .properties(p -> p
                            .noOcclusion()
                            .sound(SoundType.METAL)
                            .strength(1f, 0.1f)
                    )
                    .item()
                    .build()
                    .register();


    public static final BlockEntry<CustomCasingBlock> REALISM_CASING =
            REGISTRATE.block("realism_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.REALISM_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<Block> RGB_BLOCK =
            REGISTRATE.block("rgb_block", Block::new)
                    .properties(p -> p
                            .sound(SoundType.STONE)
                            .strength(1.5f))
                    .item()
                    .build()
                    .register();
    public static final BlockEntry<SailBlock> WASHING_SAIL =
            REGISTRATE.block("washing_sail", SailBlock::new)
                    .properties(p -> p
                            .strength(2, 1)
                            .sound(SoundType.WOOD)
                            .noOcclusion()
                    )
                    .item()
                    .build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.WINDMILL_SAILS.tag, AllTags.AllBlockTags.FAN_TRANSPARENT.tag, AllTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_SPLASHING.tag)
                    .register();

    public static final BlockEntry<SailBlock> BLASTING_SAIL =
            REGISTRATE.block("blasting_sail", SailBlock::new)
                    .properties(p -> p
                            .strength(2, 1)
                            .sound(SoundType.WOOD)
                            .noOcclusion()
                    )
                    .item()
                    .build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.WINDMILL_SAILS.tag, AllTags.AllBlockTags.FAN_TRANSPARENT.tag, AllTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_BLASTING.tag)
                    .register();

    public static final BlockEntry<Block> FIRE_COAL_BLOCK =
            REGISTRATE.block("fire_coal_block", Block::new)
                    .properties(p -> p.sound(SoundType.STONE))
                    .item()
                    .build()
                    .register();


    public static final BlockEntry<AsphaltBlock> APSHALT =
            REGISTRATE.block("asphalt", properties -> new AsphaltBlock(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1.5f, 0.75f).requiresCorrectToolForDrops(), 9))
                    .transform(pickaxeOnly())
                    .item()
                    .build()
                    .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL)
                    .register();

    public static final BlockEntry<Block> ELEMENTIUM_ORE =
            REGISTRATE.block("elementium_ore", Block::new)
                    .properties(p -> p.strength(1.75f, 1.0f)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
                    )
                    .item().tag(Tags.Items.ORES, Tags.Items.ORES_IN_GROUND_STONE)
                    .build()
                    .loot((lt, b) -> {
                        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = lt.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);

                        lt.add(b,
                                lt.createSilkTouchDispatchTable(b,
                                        lt.applyExplosionDecay(b, LootItem.lootTableItem(ModItems.RAW_ELEMENTIUM.get())
                                                .apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE))))));
                    })
                    .tag(BlockTags.NEEDS_IRON_TOOL, Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Blocks.ORES, BlockTags.MINEABLE_WITH_PICKAXE)
                    .register();

    public static final BlockEntry<Block> DEEPSLATE_ELEMENTIUM_ORE =
            REGISTRATE.block("deepslate_elementium_ore", Block::new)
                    .properties(p -> p.strength(1.75f, 1.0f)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
                    )
                    .item().tag(Tags.Items.ORES, Tags.Items.ORES_IN_GROUND_DEEPSLATE)
                    .build()
                    .loot((lt, b) -> {
                        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = lt.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);

                        lt.add(b,
                                lt.createSilkTouchDispatchTable(b,
                                        lt.applyExplosionDecay(b, LootItem.lootTableItem(ModItems.RAW_ELEMENTIUM.get())
                                                .apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE))))));
                    })
                    .tag(BlockTags.NEEDS_IRON_TOOL, Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Blocks.ORES, BlockTags.MINEABLE_WITH_PICKAXE)

                    .register();

    public static final BlockEntry<Block> RAW_ELEMENTIUM_BLOCK =
            REGISTRATE.block("raw_elementium_block", Block::new)
                    .properties(p -> p.strength(1.75f, 1.0f)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
                    )
                    .item()
                    .build()
                    .tag(BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
                    .register();

    public static final BlockEntry<Block> ELEMENTIUM_BLOCK =
            REGISTRATE.block("elementium_block", Block::new)
                    .properties(p -> p.strength(1.75f, 1.0f)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
                    )
                    .item()
                    .build()
                    .tag(BlockTags.NEEDS_IRON_TOOL, BlockTags.MINEABLE_WITH_PICKAXE)
                    .register();

    public static final BlockEntry<Block> ANDESITE_ALLOY_ORE =
            REGISTRATE.block("andesite_alloy_ore", Block::new)
                    .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL, Tags.Blocks.ORES, Tags.Blocks.ORES_IN_GROUND_STONE)
                    .loot((lt, b) -> {
                        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = lt.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);

                        lt.add(b,
                                lt.createSilkTouchDispatchTable(b,
                                        lt.applyExplosionDecay(b, LootItem.lootTableItem(AllItems.ANDESITE_ALLOY.get())
                                                .apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE))))));
                    })
                    .simpleItem()
                    .properties(p -> p
                            .strength(1.5f, 0.5f)
                    )
                    .register();

    public static final BlockEntry<Block> DEEPSLATE_ANDESITE_ALLOY_ORE =
            REGISTRATE.block("deepslate_andesite_alloy_ore", Block::new)
                    .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_STONE_TOOL, Tags.Blocks.ORES, Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                    .loot((lt, b) -> {
                        HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = lt.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);

                        lt.add(b,
                                lt.createSilkTouchDispatchTable(b,
                                        lt.applyExplosionDecay(b, LootItem.lootTableItem(AllItems.ANDESITE_ALLOY.get())
                                                .apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE))))));
                    })
                    .properties(p -> p
                            .strength(1.5f, 0.5f)
                    )
                    .simpleItem()
                    .register();


    protected static String getItemName(ItemLike pItemLike) {
        return BuiltInRegistries.ITEM.getKey(pItemLike.asItem()).getPath();
    }

    public static void register() {}
}
