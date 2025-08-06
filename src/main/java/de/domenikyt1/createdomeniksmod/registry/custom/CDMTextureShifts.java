package de.domenikyt1.createdomeniksmod.registry.custom;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import net.minecraft.resources.ResourceLocation;

public class CDMTextureShifts {

    public static final CTSpriteShiftEntry FIRE_CASING = ct("fire_casing");
    public static final CTSpriteShiftEntry TEMPLATE_CASING = ct("template_casing");
    public static final CTSpriteShiftEntry RGB_CASING = ct("rgb_casing");
    public static final CTSpriteShiftEntry BLACK_CASING = ct("black_casing");
    public static final CTSpriteShiftEntry BLUE_CASING = ct("blue_casing");
    public static final CTSpriteShiftEntry GRAY_CASING = ct("gray_casing");
    public static final CTSpriteShiftEntry RED_CASING = ct("red_casing");
    public static final CTSpriteShiftEntry PINK_CASING = ct("pink_casing");
    public static final CTSpriteShiftEntry YELLOW_CASING = ct("yellow_casing");
    public static final CTSpriteShiftEntry LIME_CASING = ct("lime_casing");





    private static CTSpriteShiftEntry ct(String name) {
        return CTSpriteShifter.getCT(AllCTTypes.OMNIDIRECTIONAL,
                ResourceLocation.fromNamespaceAndPath("createdomeniksmod","block/casings/" + name),
                ResourceLocation.fromNamespaceAndPath("createdomeniksmod","block/casings/" + name + "_connected"));
    }
}
