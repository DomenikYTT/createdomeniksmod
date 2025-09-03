package de.domenikyt1.createdomeniksmod.block;

import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;
import de.domenikyt1.createdomeniksmod.CreativeTabs.Tabs;
import de.domenikyt1.createdomeniksmod.block.custom.*;
import de.domenikyt1.createdomeniksmod.registry.custom.CDMTextureShifts;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;


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
                    .simpleItem()
                    .register();

    public static final BlockEntry<PedestalBlock> PEDESTAL =
            REGISTRATE.block("pedestal", PedestalBlock::new)
                    .properties(p -> p.noOcclusion()
                            .sound(SoundType.STONE)
                            .destroyTime(1.5f)
                            .explosionResistance(0.1f))
                    .transform(pickaxeOnly())
                    .simpleItem()
                    .register();

    public static final BlockEntry<cooltendo> COOLTENDO_SWATCH =
            REGISTRATE.block("cooltendo_swatch", cooltendo::new)
                    .properties(p -> p
                            .noOcclusion()
                            .sound(SoundType.METAL)
                            .strength(1f, 0.1f)
                    )
                    .simpleItem()
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
                    .register();
    public static final BlockEntry<SailBlock> WASHING_SAIL =
            REGISTRATE.block("washing_sail", SailBlock::new)
                    .properties(p -> p
                            .strength(2, 1)
                            .sound(SoundType.WOOD)
                            .noOcclusion()
                    )
                    .simpleItem()
                    .register();

    public static final BlockEntry<SailBlock> BLASTING_SAIL =
            REGISTRATE.block("blasting_sail", SailBlock::new)
                    .properties(p -> p
                            .strength(2, 1)
                            .sound(SoundType.WOOD)
                            .noOcclusion()
                    )
                    .simpleItem()
                    .register();

    public static final BlockEntry<Block> FIRE_COAL_BLOCK =
            REGISTRATE.block("fire_coal_block", Block::new)
                    .properties(p -> p.sound(SoundType.STONE))
                    .item()
                    .build()
                    .register();


    protected static String getItemName(ItemLike pItemLike) {
        return BuiltInRegistries.ITEM.getKey(pItemLike.asItem()).getPath();
    }

    public static void register() {}
}
