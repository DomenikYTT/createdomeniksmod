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

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> HATS = createTag("hats");
        public static final TagKey<Item> BANDANAS = createTag("bandanas");
        public static final TagKey<Item> ALL_ITEMS = createTag("all_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, name));
        }
    }
}
