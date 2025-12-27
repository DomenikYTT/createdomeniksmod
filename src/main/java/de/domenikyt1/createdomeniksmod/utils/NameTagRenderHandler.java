package de.domenikyt1.createdomeniksmod.utils;


import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityAttachment;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;


@EventBusSubscriber(value = Dist.CLIENT)
public class NameTagRenderHandler {



    @SubscribeEvent
    public static void onRenderNameTag(RenderNameTagEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!PLAYERRANKUUIDS.isDev(player)) return;
        Vec3 vec3 = player.getAttachments().get(EntityAttachment.NAME_TAG, 0, player.getYRot());

        if (vec3 != null) {


            PoseStack poseStack = event.getPoseStack();
            MultiBufferSource buffer = event.getMultiBufferSource();
            Font font = Minecraft.getInstance().font;

            poseStack.pushPose();
            // Nur ein kleiner Offset über dem Nametag
            poseStack.translate(vec3.x, vec3.y + 0.75D, vec3.x);


            poseStack.mulPose(Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation());

            poseStack.scale(0.025F, -0.025F, 0.025F);
            Component RANK = Component.literal(CheckRank(player));
            float x = -font.width(RANK) / 2f;

            font.drawInBatch(RANK, x, 0, 0xFFFFFF, false,
                    poseStack.last().pose(), buffer, Font.DisplayMode.NORMAL,
                    0, event.getPackedLight());

            poseStack.popPose();
        }
    }


    public static String CheckRank(Player player) {
        String DEV = "§f\uE001§r";
        String TEAM = "§f\uE002§r";
        String VIP = "§f\uE003§r";

        String RANKS = null;

        if (PLAYERRANKUUIDS.isVip(player)) {
            RANKS = VIP;
        }
        if (PLAYERRANKUUIDS.isTeam(player)) {
            if (RANKS != null) {
                RANKS = RANKS + " " + TEAM;
            } else {
                RANKS = TEAM;
            }
        }
        if (PLAYERRANKUUIDS.isDev(player)) {
            if (RANKS != null) {
                RANKS = RANKS + " " + DEV;
            } else {
                RANKS = DEV;
            }
        }

        return RANKS;
    }
}
