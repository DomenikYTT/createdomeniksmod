package de.domenikyt1.createdomeniksmod.registry.custom;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraft.world.level.block.Block;

public class CDMBlockStates {
    public static <T extends Block> void cubeAll(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov) {
        cubeAll(ctx, prov, "");
    }

    public static <T extends Block> void cubeAll(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov,
                                                 String textureSubDir) {
        String texturePath = "block/" + textureSubDir + ctx.getId().getPath();
        prov.simpleBlock(ctx.get(), prov.models()
                .cubeAll(ctx.getName(), prov.modLoc(texturePath)));
    }
}
