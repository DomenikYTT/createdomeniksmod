package de.domenikyt1.createdomeniksmod.CreativeTabs;

import de.domenikyt1.createdomeniksmod.Blocks.ModBlocks;
import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.CreateBlock.CDMBlocks;
import de.domenikyt1.createdomeniksmod.Tags;
import de.domenikyt1.createdomeniksmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Tabs {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CDM.MOD_ID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCKS_TAB = TAB.register("tab_cdm", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.createdomeniksmod")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> ModBlocks.FIRE_COAL_BLOCK.get().asItem().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(ModItems.FIRE_COAL.get());
        output.accept(ModItems.BASEBALL_BAT.get());
        output.accept(ModItems.CHOCOLATE_COIN.get());
        output.accept(ModItems.WIZZARD_HAT.get());
        output.accept(ModItems.BANDANA.get());
        output.accept(ModBlocks.COOLTENDO_SWATCH.get());
        output.accept(ModBlocks.FIRE_COAL_BLOCK.get());
        output.accept(ModBlocks.WASHING_SAIL.get());
        output.accept(ModBlocks.BLASTING_SAIL.get());
        output.accept(CDMBlocks.FIRE_CASING.get());
        output.accept(CDMBlocks.RED_CASING.get());
        output.accept(CDMBlocks.BLUE_CASING.get());
        output.accept(CDMBlocks.RGB_CASING.get());
        output.accept(CDMBlocks.BLACK_CASING.get());
        output.accept(CDMBlocks.GRAY_CASING.get());
        output.accept(CDMBlocks.PINK_CASING.get());
        output.accept(CDMBlocks.LIME_CASING.get());
        output.accept(CDMBlocks.YELLOW_CASING.get());
        output.accept(ModBlocks.RGB_BLOCK.get());
        output.accept(ModBlocks.REALISM_CASING.get());
        output.accept(ModBlocks.COOLTENDO_SWATCH.get());
    }).build());
}
