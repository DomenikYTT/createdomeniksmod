package de.domenikyt1.createdomeniksmod.block.entity;

import de.domenikyt1.createdomeniksmod.block.CDMBlocks;
import de.domenikyt1.createdomeniksmod.block.ModBlocks;
import de.domenikyt1.createdomeniksmod.block.entity.custom.AltarBlockEntity;
import de.domenikyt1.createdomeniksmod.block.entity.custom.PedestalBlockEntity;
import de.domenikyt1.createdomeniksmod.CDM;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CDM.MOD_ID);

    public static final Supplier<BlockEntityType<AltarBlockEntity>> SACRIFICE_ALTAR_BE =
            BLOCK_ENTITIES.register("sacrifice_altar_be", () -> BlockEntityType.Builder.of(
                    AltarBlockEntity::new, CDMBlocks.SACRIFICE_ALTAR.get()).build(null));

    public static final Supplier<BlockEntityType<PedestalBlockEntity>> PEDESTAL_BE =
            BLOCK_ENTITIES.register("pedestal_be", () -> BlockEntityType.Builder.of(
                    PedestalBlockEntity::new, CDMBlocks.PEDESTAL.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
