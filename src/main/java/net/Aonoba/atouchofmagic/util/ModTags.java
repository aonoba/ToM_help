package net.Aonoba.atouchofmagic.util;

import net.Aonoba.atouchofmagic.ATouchOfMagic;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> MAGIC_SOURCE_LOCATE = tag("magic_source_locate");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(ATouchOfMagic.MOD_ID, name));
        }
    }
    public static class Items{

        //Item tags

        public static final TagKey<Item> MAGIC_SOURCE_LOCATE = tag("magic_source_locate");
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(ATouchOfMagic.MOD_ID, name));
        }

    }
}
