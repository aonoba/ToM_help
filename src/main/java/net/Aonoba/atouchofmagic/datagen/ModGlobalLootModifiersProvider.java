package net.Aonoba.atouchofmagic.datagen;
import net.Aonoba.atouchofmagic.datagen.loot.AddItemModifier;
import net.Aonoba.atouchofmagic.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.Aonoba.atouchofmagic.ATouchOfMagic;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {

        super(output, ATouchOfMagic.MOD_ID);
    }
    @Override
    protected void start(){
        //doesn't work for blocks says to change addItemmodifier to object something
        /*add("pixie_marrow_from_zombie",new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build(),},
                ModItems.PIXIE_MARROW));
        */
        add("pixie_marrow_from_zombie",new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/zombie")).build()},
                ModItems.PIXIE_MARROW.get()));

        add("dowsing_rod_from_jungle_temples",new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build()},
                ModItems.DOWSING_ROD.get()));
        }
}
