package uk.hexeption.qfabric.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EnchantingTableBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import uk.hexeption.qfabric.registry.QFabricBlocks;

/**
 * MixinEnchantingTableBlock
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 28/04/2020 - 01:06 pm
 */
@Mixin(EnchantingTableBlock.class)
public class MixinEnchantingTableBlock {

    @Redirect(method = "randomDisplayTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;"))
    private Block getReplacedBlock(BlockState state) {
        if (state.getBlock() == Blocks.BOOKSHELF) {
            return Blocks.BOOKSHELF;
        }
        if (state.getBlock() == QFabricBlocks.ACACIA_BOOKSHELF ||
            state.getBlock() == QFabricBlocks.BIRCH_BOOKSHELF ||
            state.getBlock() == QFabricBlocks.JUNGLE_BOOKSHELF ||
            state.getBlock() == QFabricBlocks.DARK_OAK_BOOKSHELF ||
            state.getBlock() == QFabricBlocks.SPRUCE_BOOKSHELF) {
            return Blocks.BOOKSHELF;
        } else {
            return Blocks.AIR;
        }
    }

}

