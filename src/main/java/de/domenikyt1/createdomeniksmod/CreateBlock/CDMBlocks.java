package de.domenikyt1.createdomeniksmod.CreateBlock;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.tterrag.registrate.util.entry.BlockEntry;
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
    public static final BlockEntry<CasingBlock> FIRE_CASING =
            REGISTRATE.block("fire_casing", CasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.FIRE_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.STONE).forceSolidOff())
                    .item().build()
                    .transform(axeOrPickaxe())
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();

    public static final BlockEntry<CasingBlock> TEMPLATE_CASING =
            REGISTRATE.block("template_casing", CasingBlock::new)
                    .transform(BuilderTransformers.casing(() -> CDMTextureShifts.TEMPLATE_CASING))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.STONE).forceSolidOff())
                    .item().build()
                    .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag, AllTags.AllBlockTags.CASING.tag)
                    .register();




    public static void register() {}
}
