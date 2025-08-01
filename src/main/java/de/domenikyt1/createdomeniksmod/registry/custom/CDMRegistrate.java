package de.domenikyt1.createdomeniksmod.registry.custom;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class CDMRegistrate extends CreateRegistrate {
    protected CDMRegistrate(String MOD_ID) {
        super(MOD_ID);
    }
    public static CDMRegistrate create(String MOD_ID) {
        return new CDMRegistrate(MOD_ID);
    }
    public <T extends MobEffect> MobEffectBuilder<T, CDMRegistrate> mobEffect(String name, Supplier<? extends T> factory) {
        return mobEffect(this, name, factory);
    }
    public <T extends MobEffect, P> MobEffectBuilder<T, P> mobEffect(P parent, Supplier<? extends T> factory) {
        return mobEffect(parent, currentName(), factory);
    }
    public <T extends MobEffect, P> MobEffectBuilder<T, P> mobEffect(P parent, String name, Supplier<? extends T> factory) {
        return entry(name, callback -> new MobEffectBuilder<>(this, parent, name, callback, factory));
    }
}
