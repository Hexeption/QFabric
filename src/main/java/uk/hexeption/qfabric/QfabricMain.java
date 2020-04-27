package uk.hexeption.qfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import uk.hexeption.qfabric.registry.QFabricBlocks;
import uk.hexeption.qfabric.registry.QFabricItems;

public class QfabricMain implements ModInitializer {

    public static final String MOD_ID = "qfabric";

    public static final ItemGroup GROUP = FabricItemGroupBuilder.build(id("group"), () -> new ItemStack(Items.ACACIA_FENCE));

    public static Identifier id(String name) {
        return new Identifier(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        QFabricBlocks.init();
        QFabricItems.init();
    }
}

