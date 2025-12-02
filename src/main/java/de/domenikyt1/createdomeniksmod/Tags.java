package de.domenikyt1.createdomeniksmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Tags {


    public static class Blocks {
        public static final TagKey<Block> ALL_BLOCKS = MyTag("all_blocks");
        public static final TagKey<Block> NEEDS_ELEMENTIUM_TOOL = MyTag("needs_elementium_tool");

        public static final TagKey<Block> INCORRECT_FOR_ELEMENTIUM_TOOL = MyTag("incorrect_for_elementium_tool");
        public static final TagKey<Block> ELEMENTIUM = NeoTag("elementium");

        private static TagKey<Block> MyTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("createdomeniksmod", name));
        }

        private static TagKey<Block> NeoTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }




    public static class Items {
        public static final TagKey<Item> WRENCHES = MyTag("wrenches");
        public static final TagKey<Item> ELEMENTIUM = NeoTag("elementium");

        private static TagKey<Item> MyTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("createdomeniksmod", name));
        }

        private static TagKey<Item> NeoTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }


}
