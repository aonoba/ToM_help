package net.Aonoba.atouchofmagic.datagen;

import net.Aonoba.atouchofmagic.ATouchOfMagic;
import net.Aonoba.atouchofmagic.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ATouchOfMagic.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FAE_STEEL_BLOCK);
        //blockWithItem(ModBlocks.PIXIE_MARROW_BLOCK);
        blockWithItem(ModBlocks.FAE_DUST_ORE);
    }

        private void blockWithItem(RegistryObject<Block> blockRegistryObject){
            simpleBlock(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
        }

    }

