package de.domenikyt1.createdomeniksmod.datagen;

import com.simibubi.create.content.equipment.wrench.WrenchItem;
import de.domenikyt1.createdomeniksmod.CDMItems;
import de.domenikyt1.createdomeniksmod.CDMTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;

public class CDMItemTagProvider extends ItemTagsProvider {
    public CDMItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        var tag = tag(CDMTags.Items.WRENCHES);

        for (var item : REGISTRATE.getAll(Registries.ITEM)) {
            if (item.value() instanceof WrenchItem) {
                tag.add(item.value());
            }
        }

        tag(CDMTags.Items.CREATE_WRENCHES).addTag(CDMTags.Items.WRENCHES);

    }
}
