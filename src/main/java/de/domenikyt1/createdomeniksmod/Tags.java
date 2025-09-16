package de.domenikyt1.createdomeniksmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class Tags {
    public static class Blocks {

        public static final TagKey<Block> ALL_BLOCKS = createTag("all_blocks");

        public static final TagKey<Block> NEEDS_ELEMENTIUM_TOOL = createTag("needs_elementium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ELEMENTIUM_TOOL = createTag("incorrect_for_elementium_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, name));
        }
    }
    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, name));
        }
    }
}
