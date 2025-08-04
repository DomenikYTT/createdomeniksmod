package de.domenikyt1.createdomeniksmod.item.accessories;

import io.wispforest.accessories.api.Accessory;
import io.wispforest.accessories.api.SoundEventData;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.Nullable;

public class AccessoryItem extends Item implements Accessory {
    private final Holder<SoundEvent> soundEventSupplier;

    public AccessoryItem(Properties properties) {
        this(SoundEvents.ARMOR_EQUIP_GENERIC, properties);
    }

    public AccessoryItem(Holder<SoundEvent> soundEventSupplier, Properties properties) {
        super(properties);
        this.soundEventSupplier = soundEventSupplier;
    }

    @Override
    public boolean canEquipFromUse(ItemStack stack) {
        return true;
    }

    @Override
    public @Nullable SoundEventData getEquipSound(ItemStack stack, SlotReference reference) {
        return new SoundEventData(this.soundEventSupplier, 1.0F, 1.0F);
    }
}
