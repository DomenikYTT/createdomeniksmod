package de.domenikyt1.createdomeniksmod.utils;

import net.minecraft.world.entity.player.Player;

import java.util.Set;
import java.util.UUID;

public class PLAYERRANKUUIDS {

    public static final Set<UUID> DEVELOPERS = Set.of(
            UUID.fromString("fa25a26f-bd10-401c-8cd9-fabfd3c1981f")
    );

    public static final Set<UUID> TEAMS = Set.of(
            UUID.fromString("fa25a26f-bd10-401c-8cd9-fabfd3c1981f")

    );

    public static final Set<UUID> VIPS = Set.of(
            // R.I.P Veit2012O
            UUID.fromString("4feaa427-0efc-416a-afee-9b7de95ad5b9"),
            // other users
            UUID.fromString("fa25a26f-bd10-401c-8cd9-fabfd3c1981f")
    );


    public static boolean isDev(Player player) {
        return DEVELOPERS.contains(player.getUUID());
    }

    public static boolean isTeam(Player player) {
        return TEAMS.contains(player.getUUID());
    }

    public static boolean isVip(Player player) {
        return VIPS.contains(player.getUUID());
    }
}
