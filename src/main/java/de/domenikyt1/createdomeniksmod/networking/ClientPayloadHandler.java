package de.domenikyt1.createdomeniksmod.networking;

import de.domenikyt1.createdomeniksmod.register.block.entity.custom.AltarBlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ClientPayloadHandler {
    public static void handleSacrificeOnClient(final ResetSacrificedEntityS2C data, final IPayloadContext context) {
        ((AltarBlockEntity) context.player().level().getBlockEntity(data.blockEntityPosition())).setSacrificedEntity(null);
    }

    public static void handleCountOnClient(final PedestalCraftCountS2C data, final IPayloadContext context) {
        ((AltarBlockEntity) context.player().level().getBlockEntity(data.blockEntityPosition())).setCount(data.count());
    }
}