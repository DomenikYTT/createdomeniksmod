package de.domenikyt1.createdomeniksmod.datagen;

import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.register.worldgen.ModBiomeModifiers;
import de.domenikyt1.createdomeniksmod.register.worldgen.ModConfirguredFeatures;
import de.domenikyt1.createdomeniksmod.register.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.core.RegistrySetBuilder;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CDMGeneratedEntriesProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, ModConfirguredFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public CDMGeneratedEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CDM.MOD_ID));

    }

    @Override
    public String getName() {
        return "CDM's Generated Registry Entries!";
    }
}
