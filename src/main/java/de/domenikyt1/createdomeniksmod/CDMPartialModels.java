package de.domenikyt1.createdomeniksmod;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;

public class CDMPartialModels {


    private static PartialModel block(String path) {
        PartialModel model = PartialModel.of(CDM.asResource("block/" + path));
        return model;
    }


    public static void register() {

    }
}
