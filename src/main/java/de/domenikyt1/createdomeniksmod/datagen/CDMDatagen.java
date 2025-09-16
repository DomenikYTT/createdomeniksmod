package de.domenikyt1.createdomeniksmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.minecraft.data.DataGenerator;

import java.util.concurrent.CompletableFuture;

public class CDMDatagen {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        CDMGeneratedEntriesProvider generatedEntriesProvider = new CDMGeneratedEntriesProvider(output, lookupProvider);
        lookupProvider = generatedEntriesProvider.getRegistryProvider();
        generator.addProvider(event.includeServer(), generatedEntriesProvider);


        BlockTagsProvider blockTagsProvider = new CDMBlockTagProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

    }
}
