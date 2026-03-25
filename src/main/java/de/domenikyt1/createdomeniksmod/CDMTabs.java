package de.domenikyt1.createdomeniksmod;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import de.domenikyt1.createdomeniksmod.register.item.SequencedSmithingItem;
import de.domenikyt1.createdomeniksmod.register.item.nottabItem;
import de.domenikyt1.createdomeniksmod.register.item.nottabhatitem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static de.domenikyt1.createdomeniksmod.CDM.MOD_ID;
import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;

public class CDMTabs {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CDM.MOD_ID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BASE_TAB = TAB.register("base_tab", () -> CreativeModeTab.builder()
            .title(Component.translatableWithFallback("itemGroup.createdomeniksmod", MOD_ID))
            .withTabsBefore(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .icon(CDMBlocks.FIRE_COAL_BLOCK::asStack)
            .build());

    public static void register() {}

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(CDMTabs.BASE_TAB.getKey())) for (var entry : REGISTRATE.getAll(Registries.ITEM))
            if (entry.get() instanceof nottabItem || entry.get() instanceof nottabhatitem || entry.get() instanceof SequencedSmithingItem || entry.get() instanceof SequencedAssemblyItem) event.remove(entry.get().getDefaultInstance(),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }
}