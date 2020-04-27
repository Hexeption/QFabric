package uk.hexeption.qfabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import uk.hexeption.qfabric.registry.QFabricBlocks;

@Environment(EnvType.CLIENT)
public class QfabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),
            QFabricBlocks.FRAMED_GLASS, QFabricBlocks.FRAMED_GLASS_PANE,
            QFabricBlocks.DIRTY_GLASS, QFabricBlocks.DIRTY_GLASS_PANE
        );
    }
}
