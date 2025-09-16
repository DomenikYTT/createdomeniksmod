package de.domenikyt1.createdomeniksmod.utils;

import de.domenikyt1.createdomeniksmod.CDM;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.core.registries.Registries.*;

@SuppressWarnings({"unused", "removal"})
public record CDMRegistry(String modID) {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(CREATIVE_MODE_TAB, CDM.MOD_ID);



    public DeferredRegister<CreativeModeTab> creativeTab() {return CREATIVE_MODE_TABS;}


    public void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
