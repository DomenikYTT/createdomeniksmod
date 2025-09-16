package de.domenikyt1.createdomeniksmod.datagen;

import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.Tags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CDMBlockTagProvider extends BlockTagsProvider {
    public CDMBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CDM.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(Tags.Blocks.NEEDS_ELEMENTIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(Tags.Blocks.INCORRECT_FOR_ELEMENTIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(Tags.Blocks.NEEDS_ELEMENTIUM_TOOL);
    }
}
