package net.raccoon.will.ventura.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.raccoon.will.ventura.Ventura;

public class VTags {

    public static class Blocks {
        public static final TagKey<Block> BLOCK_TAG = createTag("block_tag");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Ventura.resLoc(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> AGEABLE_ITEMS = createTag("ageable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Ventura.resLoc(name));
        }
    }
}
