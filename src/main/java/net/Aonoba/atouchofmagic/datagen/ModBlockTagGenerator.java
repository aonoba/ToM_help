package net.Aonoba.atouchofmagic.datagen;

import net.Aonoba.atouchofmagic.ATouchOfMagic;
import net.Aonoba.atouchofmagic.block.ModBlocks;
import net.Aonoba.atouchofmagic.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ATouchOfMagic.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider){
        this.tag(ModTags.Blocks.MAGIC_SOURCE_LOCATE)
                .add(ModBlocks.FAE_STEEL_BLOCK.get()).addTag(Tags.Blocks.ORES)

                //.add(ModBlocks.PIXIE_MARROW_BLOCK.get())
        ;

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FAE_STEEL_BLOCK.get());
                        //ModBlocks.PIXIE_MARROW_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FAE_STEEL_BLOCK.get());
                       // ,ModBlocks.PIXIE_MARROW_BLOCK.get());
        //can make diamond ect tools



    }
}

