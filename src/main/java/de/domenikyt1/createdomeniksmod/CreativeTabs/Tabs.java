package de.domenikyt1.createdomeniksmod.CreativeTabs;

import de.domenikyt1.createdomeniksmod.Blocks.ModBlocks;
import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.CreateBlock.CDMBlocks;
import de.domenikyt1.createdomeniksmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Tabs {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CDM.MOD_ID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS_TAB = TAB.register("tab_items", () -> CreativeModeTab.builder().title(Component.translatable("tab.items")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> ModItems.FIRE_COAL.get().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(ModItems.FIRE_COAL.get());
        output.accept(ModItems.BASEBALL_BAT.get());
        output.accept(ModItems.CHOCOLATE_COIN.get());
        output.accept(ModItems.WIZZARD_HAT.get());
    }).build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCKS_TAB = TAB.register("tab_blocks", () -> CreativeModeTab.builder().title(Component.translatable("tab.blocks")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> CDMBlocks.FIRE_CASING.get().asItem().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(ModBlocks.FIRE_COAL_BLOCK.get());
        output.accept(ModBlocks.WASHING_SAIL.get());
        output.accept(ModBlocks.BLASTING_SAIL.get());
        output.accept(CDMBlocks.FIRE_CASING.get());
    }).build());
}
