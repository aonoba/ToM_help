package net.Aonoba.atouchofmagic.item;


import net.Aonoba.atouchofmagic.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.Aonoba.atouchofmagic.ATouchOfMagic;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
//import net.minecraft.world.item.Items;

//import java.awt.*;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ATouchOfMagic.MOD_ID);

    public static  final RegistryObject<CreativeModeTab>A_TOUCH_OF_MAGIC= CREATIVE_MODE_TABS.register("a_touch_of_magic",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FAE_DUST.get()))
                    .title(Component.translatable("creativetab.a_touch_of_magic"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.FAE_DUST.get());
                        pOutput.accept(ModItems.PIXIE_MARROW.get());


                        pOutput.accept(ModBlocks.FAE_STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.PIXIE_MARROW_BLOCK.get());

                        pOutput.accept(ModBlocks.FAE_DUST_ORE.get());
                        pOutput.accept(ModItems.DOWSING_ROD.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){ CREATIVE_MODE_TABS.register(eventBus);

    }
}
