package de.domenikyt1.createdomeniksmod.register.item.custom;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult.Type;

public class HammerItem extends DiggerItem {
    public HammerItem(Tier tier, Item.Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList();
        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1.0F), player.getEyePosition(1.0F).add(player.getViewVector(1.0F).scale(6.0)), Block.COLLIDER, Fluid.NONE, player));
        if (traceResult.getType() == Type.MISS) {
            return positions;
        } else {
            int x;
            int y;
            if (traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
                for(x = -range; x <= range; ++x) {
                    for(y = -range; y <= range; ++y) {
                        positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
                    }
                }
            }

            if (traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
                for(x = -range; x <= range; ++x) {
                    for(y = -range; y <= range; ++y) {
                        positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
                    }
                }
            }

            if (traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
                for(x = -range; x <= range; ++x) {
                    for(y = -range; y <= range; ++y) {
                        positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                    }
                }
            }

            return positions;
        }
    }
}
