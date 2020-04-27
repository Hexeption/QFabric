package uk.hexeption.qfabric.registry;

import java.util.function.Function;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import uk.hexeption.qfabric.QfabricMain;
import uk.hexeption.qfabric.blocks.QFabricGlassBlock;
import uk.hexeption.qfabric.blocks.QFabricGlassPaneBlock;

/**
 * QFabricBlocks
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 27/04/2020 - 08:04 pm
 */
public class QFabricBlocks {

    /**
     * Glass
     */
    public static final Block FRAMED_GLASS = register("framed_glass", new QFabricGlassBlock(FabricBlockSettings.copy(Blocks.GLASS).build()));
    public static final Block FRAMED_GLASS_PANE = register("framed_glass_pane", new QFabricGlassPaneBlock(FabricBlockSettings.copy(Blocks.GLASS).build()));

    public static final Block DIRTY_GLASS = register("dirty_glass", new QFabricGlassBlock(FabricBlockSettings.copy(Blocks.GLASS).build()));
    public static final Block DIRTY_GLASS_PANE = register("dirty_glass_pane", new QFabricGlassPaneBlock(FabricBlockSettings.copy(Blocks.GLASS).build()));

    public static void init() {

    }

    static <T extends Block> T register(String name, T block, Item.Settings settings) {
        return register(name, block, new BlockItem(block, settings));
    }

    static <T extends Block> T register(String name, T block) {
        return register(name, block, new Item.Settings().group(QfabricMain.GROUP));
    }

    static <T extends Block> T register(String name, T block, Function<T, BlockItem> itemFactory) {
        return register(name, block, itemFactory.apply(block));
    }

    static <T extends Block> T register(String name, T block, BlockItem item) {
        T b = Registry.register(Registry.BLOCK, QfabricMain.id(name), block);
        if (item != null) {
            QFabricItems.register(name, item);
        }
        return b;
    }
}
