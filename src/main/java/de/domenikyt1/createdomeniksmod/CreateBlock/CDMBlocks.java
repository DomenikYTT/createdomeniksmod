package de.domenikyt1.createdomeniksmod.CreateBlock;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;
import de.domenikyt1.createdomeniksmod.Blocks.custom.CustomCasingBlock;
import de.domenikyt1.createdomeniksmod.registry.custom.CDMTextureShifts;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;


import java.util.function.Supplier;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;


public class CDMBlocks {
    public static final BlockEntry<CustomCasingBlock> FIRE_CASING =
            REGISTRATE.block("fire_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.FIRE_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.STONE).forceSolidOff())
                    .item().build()
                    .transform(axeOrPickaxe())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> TEMPLATE_CASING =
            REGISTRATE.block("template_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.TEMPLATE_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.STONE).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> RGB_CASING =
            REGISTRATE.block("rgb_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.RGB_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> RED_CASING =
            REGISTRATE.block("red_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.RED_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> BLUE_CASING =
            REGISTRATE.block("blue_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.BLUE_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> BLACK_CASING =
            REGISTRATE.block("black_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.BLACK_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> GRAY_CASING =
            REGISTRATE.block("gray_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.GRAY_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> PINK_CASING =
            REGISTRATE.block("pink_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.PINK_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> YELLOW_CASING =
            REGISTRATE.block("yellow_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.YELLOW_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CustomCasingBlock> LIME_CASING =
            REGISTRATE.block("lime_casing", CustomCasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.LIME_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.WOOD).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();




    public static void register() {}
}
