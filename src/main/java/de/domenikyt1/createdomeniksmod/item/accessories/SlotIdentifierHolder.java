package de.domenikyt1.createdomeniksmod.item.accessories;

import io.wispforest.accessories.api.slot.SlotTypeReference;

@FunctionalInterface
public interface SlotIdentifierHolder {
    SlotTypeReference getIdentifier();
}
