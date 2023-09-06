package net.Aonoba.atouchofmagic.item.custom;

import net.Aonoba.atouchofmagic.util.ModTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemDowsingRod extends Item {
    public ItemDowsingRod(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()){
            BlockPos positionViewed = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i=0;i<=positionViewed.getY() +64; i++){
                BlockState state = pContext.getLevel().getBlockState(positionViewed.below(i));

                if(isValuableBlock(state)){
                    outpuValuableCoordinates(positionViewed.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock){
                player.sendSystemMessage(Component.literal("nothing here..."));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return InteractionResult.SUCCESS;

    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.atouchofmagic.dowsing_rod"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outpuValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("found"+I18n.get(block.getDescriptionId())+"at" +"("+
                blockPos.getX()+","+blockPos.getY()+","+blockPos.getZ()+")"));

    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.MAGIC_SOURCE_LOCATE);
    }
}
