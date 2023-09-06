package net.Aonoba.atouchofmagic.item;

import net.Aonoba.atouchofmagic.ATouchOfMagic;
import net.Aonoba.atouchofmagic.item.custom.ItemDowsingRod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ATouchOfMagic.MOD_ID);
    public static final RegistryObject<Item> FAE_DUST =ITEMS.register("fae_dust",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PIXIE_MARROW=ITEMS.register("pixie_marrow",
            () -> new Item(new Item.Properties()));

    /*public static final RegistryObject<Item>PIXIE_MARROW =register("pixie_marrow",
            ()-> new ItemBlock(BlockBehaviour.Properties.copy(Blocks.noLootTable)));*/
    public static final RegistryObject<Item>DOWSING_ROD=ITEMS.register("dowsing_rod",
            () -> new ItemDowsingRod(new Item.Properties().durability(15)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
