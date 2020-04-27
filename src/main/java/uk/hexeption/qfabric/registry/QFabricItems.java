package uk.hexeption.qfabric.registry;

import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import uk.hexeption.qfabric.QfabricMain;

/**
 * QFabricItems
 *
 * @author Hexeption admin@hexeption.co.uk
 * @since 27/04/2020 - 08:07 pm
 */
public class QFabricItems {

    public static final Item ANCIENT_TOME = register("ancient_tome", new Item(newSettings()));
    public static final Item BACKPACK = register("backpack", new Item(newSettings()));
    public static final Item BIOTITE = register("biotite", new Item(newSettings()));
    public static final Item CLEAR_SHARD = register("clear_shard", new Item(newSettings()));
    public static final Item TROWEL = register("trowel", new Item(newSettings()));

    static Item.Settings newSettings() {
        return new Item.Settings().group(QfabricMain.GROUP);
    }

    public static void init() {

    }

    protected static <T extends Item> T register(String name, T item) {
        return Registry.register(Registry.ITEM, QfabricMain.id(name), item);
    }
}
