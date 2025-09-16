package de.domenikyt1.createdomeniksmod.register.event;

import de.domenikyt1.createdomeniksmod.register.block.entity.custom.AltarBlockEntity;
import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.networking.ClientPayloadHandler;
import de.domenikyt1.createdomeniksmod.networking.PedestalCraftCountS2C;
import de.domenikyt1.createdomeniksmod.networking.ResetSacrificedEntityS2C;
import de.domenikyt1.createdomeniksmod.register.item.custom.ExcavatorItem;
import de.domenikyt1.createdomeniksmod.register.item.custom.HammerItem;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

import java.util.stream.Stream;

@EventBusSubscriber(modid = CDM.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onAnimalSacrifice(LivingDeathEvent event) {
        Level level = event.getEntity().level();
        AABB blocksAround = AABB.ofSize(event.getEntity().blockPosition().getCenter(), 5, 3, 5);
        Stream<BlockPos> position = BlockPos.betweenClosedStream(blocksAround);

        position.forEach(pos -> {
            if (level.getBlockEntity(pos) instanceof AltarBlockEntity altarBlockEntity) {
                altarBlockEntity.setSacrificedEntity(event.getEntity().getType());
            }
        });
    }

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    private static final Set<BlockPos> HARVESTED_BLOCKS1 = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onExcavatorUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof ExcavatorItem excavator && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS1.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : ExcavatorItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !excavator.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS1.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS1.remove(pos);
            }
        }
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
