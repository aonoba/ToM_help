package net.Aonoba.atouchofmagic.block;

import net.Aonoba.atouchofmagic.ATouchOfMagic;
import net.Aonoba.atouchofmagic.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister <Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ATouchOfMagic.MOD_ID);
    public static final RegistryObject<Block> FAE_STEEL_BLOCK = registerBlock("fae_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> PIXIE_MARROW_BLOCK = registerBlock("pixie_marrow_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> FAE_DUST_ORE= registerBlock("fae_dust_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.SAND)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(1,4)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
