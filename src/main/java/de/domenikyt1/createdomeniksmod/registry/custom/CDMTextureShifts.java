package de.domenikyt1.createdomeniksmod.registry.custom;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import net.minecraft.resources.ResourceLocation;

public class CDMTextureShifts {

    public static final CTSpriteShiftEntry FIRE_CASING = ct("fire_casing");
    public static final CTSpriteShiftEntry TEMPLATE_CASING = ct("template_casing");




    private static CTSpriteShiftEntry ct(String name) {
        return CTSpriteShifter.getCT(AllCTTypes.OMNIDIRECTIONAL,
                ResourceLocation.fromNamespaceAndPath("createdomeniksmod","block/" + name),
                ResourceLocation.fromNamespaceAndPath("createdomeniksmod","block/" + name + "_connected"));
    }
}
