package net.Aonoba.atouchofmagic.datagen.loot;

import net.Aonoba.atouchofmagic.block.ModBlocks;
import net.Aonoba.atouchofmagic.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.FAE_STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.PIXIE_MARROW_BLOCK.get());

        //for ore blocks that don't drop themselves like ore
        //duplicate this line for more
        this.add(ModBlocks.FAE_DUST_ORE.get(),
                block-> createLapisLikeOreDrops(ModBlocks.FAE_DUST_ORE.get(), ModItems.FAE_DUST.get()));
        //this.add(ModBlocks.PIXIE_MARROW_BLOCK.get(),
               // block-> createLapisLikeOreDrops(ModBlocks.PIXIE_MARROW_BLOCK.get(), ModItems.PIXIE_MARROW.get()));

    }
    //if I want to create another ore then i just make another of this method below
    protected LootTable.Builder createLapisLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
