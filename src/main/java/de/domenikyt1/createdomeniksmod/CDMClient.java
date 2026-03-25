package de.domenikyt1.createdomeniksmod;


import de.domenikyt1.createdomeniksmod.register.block.entity.ModBlockEntities;
import de.domenikyt1.createdomeniksmod.register.block.entity.renderer.AltarBlockEntityRenderer;
import de.domenikyt1.createdomeniksmod.register.block.entity.renderer.PedestalBlockEntityRenderer;
import de.domenikyt1.createdomeniksmod.register.screen.PedestalScreen;
import de.domenikyt1.createdomeniksmod.register.screen.SidePedestalScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(value = CDM.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = CDM.MOD_ID, value = Dist.CLIENT)
public class CDMClient {

    public CDMClient(IEventBus modEventBus) {
        onCtorClient(modEventBus);
    }

    public static void onCtorClient(IEventBus modEventBus) {
        IEventBus neoEventBus = NeoForge.EVENT_BUS;

        modEventBus.addListener(CDMClient::ClientInit);

    }


    public static void ClientInit(final FMLClientSetupEvent event) {
        CDMPartialModels.register();
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.SACRIFICE_ALTAR_BE.get(), AltarBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(CDMMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
        event.register(CDMMenuTypes.SIDE_PEDESTAL_MENU.get(), SidePedestalScreen::new);
    }
}