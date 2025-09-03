package de.domenikyt1.createdomeniksmod.CreativeTabs;

import com.simibubi.create.AllCreativeModeTabs;
import de.domenikyt1.createdomeniksmod.block.ModBlocks;
import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.block.CDMBlocks;
import de.domenikyt1.createdomeniksmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static de.domenikyt1.createdomeniksmod.CDM.MOD_ID;
import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;

public class Tabs {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CDM.MOD_ID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BASE_TAB = TAB.register("base_tab", () -> CreativeModeTab.builder()
            .title(Component.translatableWithFallback("itemGroup.createdomeniksmod", MOD_ID))
            .withTabsBefore(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .icon(CDMBlocks.FIRE_COAL_BLOCK::asStack)
            .build());

    public static void register() {}

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(Tabs.BASE_TAB.getKey())) for (var entry : REGISTRATE.getAll(Registries.ITEM));
    }
}