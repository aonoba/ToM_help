package net.Aonoba.atouchofmagic.datagen;

import net.Aonoba.atouchofmagic.block.ModBlocks;
import net.Aonoba.atouchofmagic.datagen.loot.ModBlockLootTables;
import net.Aonoba.atouchofmagic.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider {


    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(),List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)

        ));
    }
}
