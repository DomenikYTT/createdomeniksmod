package de.domenikyt1.createdomeniksmod.registry.custom;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import de.domenikyt1.createdomeniksmod.CDM;
import net.minecraft.resources.ResourceLocation;

public class CDMTextureShifts {

    public static final CTSpriteShiftEntry FIRE_CASING = getCasingCT("fire_casing");


    private static CTSpriteShiftEntry getCasingCT(String casingName) {
        return CTSpriteShifter.getCT(AllCTTypes.OMNIDIRECTIONAL,
                ResourceLocation.fromNamespaceAndPath("createdomeniksmod","block/" + casingName),
                ResourceLocation.fromNamespaceAndPath("createdomeniksmod", "block/" + casingName + "_connected")
        );
    }
}
