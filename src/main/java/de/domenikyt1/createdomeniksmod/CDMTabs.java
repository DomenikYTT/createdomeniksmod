package de.domenikyt1.createdomeniksmod;

import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import de.domenikyt1.createdomeniksmod.register.block.AsphaltBlock;
import de.domenikyt1.createdomeniksmod.register.block.BuildingBlock;
import de.domenikyt1.createdomeniksmod.register.block.CustomCasingBlock;
import de.domenikyt1.createdomeniksmod.register.item.SequencedSmithingItem;
import de.domenikyt1.createdomeniksmod.register.item.nottabItem;
import de.domenikyt1.createdomeniksmod.register.item.nottabhatitem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static de.domenikyt1.createdomeniksmod.CDM.MOD_ID;
import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;

public class CDMTabs {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BASE_TAB = TAB.register("base_tab", () -> CreativeModeTab.builder()
            .title(Component.translatableWithFallback("itemGroup.createdomeniksmod.base", MOD_ID))
            .withTabsBefore(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .icon(CDMItems.CIRCUIT_BOARD::asStack)
            .build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDING_TAB = TAB.register("building_tab", () -> CreativeModeTab.builder()
            .title(Component.translatableWithFallback("itemGroup.createdomeniksmod.building", MOD_ID + " Building"))
            .withTabsBefore(CDMTabs.BASE_TAB.getKey())
            .icon(CDMBlocks.FIRE_COAL_BLOCK::asStack)
            .build());

    public static void register() {}

    public static void addCreative(BuildCreativeModeTabContentsEvent event) {


        // Base Tab
        if (event.getTabKey().equals(CDMTabs.BASE_TAB.getKey())) {

            for (var entry : REGISTRATE.getAll(Registries.ITEM)) {
                Item item = entry.get();

                boolean isBuildingBlock =
                        item instanceof BlockItem blockItem &&
                                (blockItem.getBlock() instanceof BuildingBlock ||
                                        blockItem.getBlock() instanceof CustomCasingBlock ||
                                        blockItem.getBlock() instanceof AsphaltBlock);

                boolean isHiddenItem =
                        item instanceof nottabItem ||
                                item instanceof nottabhatitem ||
                                item instanceof SequencedAssemblyItem;

                if (isHiddenItem) {
                    event.remove(item.getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                    continue;
                }
                if (isBuildingBlock) {
                    event.remove(item.getDefaultInstance(),
                            CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                }
            }
        }
        // Building Tab
        else if (event.getTabKey().equals(CDMTabs.BUILDING_TAB.getKey())) {

            for (var entry : REGISTRATE.getAll(Registries.ITEM)) {
                Item item = entry.get();

                boolean isBuildingBlock =
                        item instanceof BlockItem blockItem &&
                                (blockItem.getBlock() instanceof BuildingBlock ||
                                        blockItem.getBlock() instanceof CustomCasingBlock ||
                                        blockItem.getBlock() instanceof AsphaltBlock);

                if (isBuildingBlock) {
                    event.accept(item.getDefaultInstance());
                }
            }
        }
    }
}