package net.kaupenjoe.livestreammods.event;

import de.domenikyt1.createdomeniksmod.block.entity.custom.AltarBlockEntity;
import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.networking.ClientPayloadHandler;
import de.domenikyt1.createdomeniksmod.networking.PedestalCraftCountS2C;
import de.domenikyt1.createdomeniksmod.networking.ResetSacrificedEntityS2C;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.util.stream.Stream;

@EventBusSubscriber(modid = CDM.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onAnimalSacrifice(LivingDeathEvent event) {
        Level level = event.getEntity().level();
        AABB blocksAround = AABB.ofSize(event.getEntity().blockPosition().getCenter(), 5, 3, 5);
        Stream<BlockPos> position = BlockPos.betweenClosedStream(blocksAround);

        position.forEach(pos -> {
            if(level.getBlockEntity(pos) instanceof AltarBlockEntity altarBlockEntity) {
                altarBlockEntity.setSacrificedEntity(event.getEntity().getType());
            }
        });
    }

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        // Sets the current network version
        final PayloadRegistrar registrar = event.registrar("1")
                .executesOn(HandlerThread.MAIN);

        registrar.commonToClient(
                ResetSacrificedEntityS2C.TYPE,
                ResetSacrificedEntityS2C.STREAM_CODEC, ClientPayloadHandler::handleSacrificeOnClient);

        registrar.commonToClient(
                PedestalCraftCountS2C.TYPE,
                PedestalCraftCountS2C.STREAM_CODEC, ClientPayloadHandler::handleCountOnClient);
    }
}
