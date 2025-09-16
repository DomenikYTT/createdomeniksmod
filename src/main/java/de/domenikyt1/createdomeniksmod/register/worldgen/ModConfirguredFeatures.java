package de.domenikyt1.createdomeniksmod.register.worldgen;

import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.register.block.CDMBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfirguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ELEMENTIUM_ORE_KEY = registerKey("elementium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ANDESITE_ALLOY_ORE_KEY = registerKey("andesite_alloy_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stonereplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslatereplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldElementiumOres = List.of(
          OreConfiguration.target(stonereplaceables, CDMBlocks.ELEMENTIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslatereplaceables, CDMBlocks.DEEPSLATE_ELEMENTIUM_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_ELEMENTIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldElementiumOres, 4));

        List<OreConfiguration.TargetBlockState> overworldAndesitealloyOres = List.of(
          OreConfiguration.target(stonereplaceables, CDMBlocks.ANDESITE_ALLOY_ORE.get().defaultBlockState()),
          OreConfiguration.target(deepslatereplaceables, CDMBlocks.DEEPSLATE_ANDESITE_ALLOY_ORE.get().defaultBlockState())
        );
        register(context, OVERWORLD_ANDESITE_ALLOY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAndesitealloyOres, 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));

    }
}
