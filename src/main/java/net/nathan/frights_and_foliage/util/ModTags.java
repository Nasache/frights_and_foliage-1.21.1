package net.nathan.frights_and_foliage.util;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> ASERIA_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("frights_and_foliage", "aseria_logs"));
        public static final TagKey<Block> MARNOR_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("frights_and_foliage", "marnor_logs"));

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FrightsAndFoliage.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> ASERIA_LOGS = TagKey.of(RegistryKeys.ITEM, Identifier.of("frights_and_foliage", "aseria_logs"));
        public static final TagKey<Item> MARNOR_LOGS = TagKey.of(RegistryKeys.ITEM, Identifier.of("frights_and_foliage", "marnor_logs"));

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(FrightsAndFoliage.MOD_ID, name));
        }

        private static TagKey<Item> createCommonItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("c", name));

        }
    }
}