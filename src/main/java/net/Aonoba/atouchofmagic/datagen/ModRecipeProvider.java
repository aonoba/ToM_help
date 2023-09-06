package net.Aonoba.atouchofmagic.datagen;

import net.Aonoba.atouchofmagic.ATouchOfMagic;
import net.Aonoba.atouchofmagic.block.ModBlocks;
import net.Aonoba.atouchofmagic.item.ModItems;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.awt.event.ItemListener;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> FAE_SMELTABLES = List.of(
            //ModItems.PIXIE_MARROW.get(),
            //ModBlocks.PIXIE_MARROW_BLOCK.get(),
            //ModBlocks.FAE_DUST_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter,FAE_SMELTABLES, RecipeCategory.MISC, ModItems.FAE_DUST.get(),0.25f,200, "fae_dust");
        oreBlasting(pWriter,FAE_SMELTABLES, RecipeCategory.MISC, ModItems.FAE_DUST.get(),0.25f,100, "fae_dust");


       ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.PIXIE_MARROW_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P',ModItems.PIXIE_MARROW.get())
                .unlockedBy(getHasName(ModItems.PIXIE_MARROW.get()), has(ModItems.PIXIE_MARROW.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PIXIE_MARROW.get(),9)
                .requires(ModBlocks.PIXIE_MARROW_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PIXIE_MARROW_BLOCK.get()), has(ModBlocks.PIXIE_MARROW_BLOCK.get()))
                .save(pWriter);


    }
        protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List< ItemLike > pIngredients, RecipeCategory
        pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
            oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

        protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
            oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
        }

        protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe > pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
            for(ItemLike itemlike : pIngredients) {
                SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                                pExperience, pCookingTime, pCookingSerializer)
                        .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer,
                                ATouchOfMagic.MOD_ID +":"+(pResult) + pRecipeName + "_" + getItemName(itemlike));
            }
    }

}
