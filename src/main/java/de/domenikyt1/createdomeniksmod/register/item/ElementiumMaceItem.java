//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package de.domenikyt1.createdomeniksmod.register.item;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ElementiumMaceItem extends Item {
    private int DEFAULT_ATTACK_DAMAGE = 5;
    private float DEFAULT_ATTACK_SPEED = -3.4F;
    public float SMASH_ATTACK_FALL_THRESHOLD = 1.5F;
    private float SMASH_ATTACK_HEAVY_THRESHOLD = 5.0F;
    public float SMASH_ATTACK_KNOCKBACK_RADIUS = 3.5F;
    private float SMASH_ATTACK_KNOCKBACK_POWER = 0.7F;
    private int DamagePerBlock;
    private double BaseAttackDamage;
    private double BaseAttackSpeed;

    public ElementiumMaceItem(Item.Properties properties, int damageperblock, double baseattackdamage, double baseattackspeed) {
        super(properties.component(DataComponents.TOOL, createToolProperties(damageperblock)).attributes(createAttributes(baseattackdamage, baseattackspeed)));
        this.DamagePerBlock = damageperblock;
        this.BaseAttackDamage = baseattackdamage;
        this.BaseAttackSpeed = baseattackspeed;
    }

    public static ItemAttributeModifiers createAttributes(double baseAttackDamage, double baseAttackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, baseAttackDamage, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, baseAttackSpeed, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

    public static Tool createToolProperties(int damagePerBlock) {
        return new Tool(List.of(), 1.0F, damagePerBlock);
    }

    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public int getEnchantmentValue() {
        return 15;
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof ServerPlayer serverplayer) {
            if (canSmashAttack(serverplayer)) {
                ServerLevel serverlevel = (ServerLevel)attacker.level();
                if (serverplayer.isIgnoringFallDamageFromCurrentImpulse() && serverplayer.currentImpulseImpactPos != null) {
                    if (serverplayer.currentImpulseImpactPos.y > serverplayer.position().y) {
                        serverplayer.currentImpulseImpactPos = serverplayer.position();
                    }
                } else {
                    serverplayer.currentImpulseImpactPos = serverplayer.position();
                }

                serverplayer.setIgnoreFallDamageFromCurrentImpulse(true);
                serverplayer.setDeltaMovement(serverplayer.getDeltaMovement().with(Axis.Y, 0.009999999776482582));
                serverplayer.connection.send(new ClientboundSetEntityMotionPacket(serverplayer));
                if (target.onGround()) {
                    serverplayer.setSpawnExtraParticlesOnFall(true);
                    SoundEvent soundevent = serverplayer.fallDistance > 5.0F ? SoundEvents.MACE_SMASH_GROUND_HEAVY : SoundEvents.MACE_SMASH_GROUND;
                    serverlevel.playSound((Player)null, serverplayer.getX(), serverplayer.getY(), serverplayer.getZ(), soundevent, serverplayer.getSoundSource(), 1.0F, 1.0F);
                } else {
                    serverlevel.playSound((Player)null, serverplayer.getX(), serverplayer.getY(), serverplayer.getZ(), SoundEvents.MACE_SMASH_AIR, serverplayer.getSoundSource(), 1.0F, 1.0F);
                }

                knockback(serverlevel, serverplayer, target);
            }
        }

        return true;
    }

    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
        if (canSmashAttack(attacker)) {
            attacker.resetFallDistance();
        }

    }

    public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(Items.BREEZE_ROD);
    }

    public float getAttackDamageBonus(Entity target, float damage, DamageSource damageSource) {
        Entity var5 = damageSource.getDirectEntity();
        if (var5 instanceof LivingEntity livingentity) {
            if (!canSmashAttack(livingentity)) {
                return 0.0F;
            } else {
                float f3 = 3.0F;
                float f = 8.0F;
                float f1 = livingentity.fallDistance;
                float f2;
                if (f1 <= 3.0F) {
                    f2 = 4.0F * f1;
                } else if (f1 <= 8.0F) {
                    f2 = 12.0F + 2.0F * (f1 - 3.0F);
                } else {
                    f2 = 22.0F + f1 - 8.0F;
                }

                Level var10 = livingentity.level();
                float var10000;
                if (var10 instanceof ServerLevel) {
                    ServerLevel serverlevel = (ServerLevel)var10;
                    var10000 = f2 + EnchantmentHelper.modifyFallBasedDamage(serverlevel, livingentity.getWeaponItem(), target, damageSource, 0.0F) * f1;
                } else {
                    var10000 = f2;
                }

                return var10000;
            }
        } else {
            return 0.0F;
        }
    }

    private static void knockback(Level level, Player player, Entity entity) {
        level.levelEvent(2013, entity.getOnPos(), 750);
        level.getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(3.5), knockbackPredicate(player, entity)).forEach((p_347296_) -> {
            Vec3 vec3 = p_347296_.position().subtract(entity.position());
            double d0 = getKnockbackPower(player, p_347296_, vec3);
            Vec3 vec31 = vec3.normalize().scale(d0);
            if (d0 > 0.0) {
                p_347296_.push(vec31.x, 0.699999988079071, vec31.z);
                if (p_347296_ instanceof ServerPlayer) {
                    ServerPlayer serverplayer = (ServerPlayer)p_347296_;
                    serverplayer.connection.send(new ClientboundSetEntityMotionPacket(serverplayer));
                }
            }

        });
    }

    private static Predicate<LivingEntity> knockbackPredicate(Player player, Entity entity) {
        return (p_344407_) -> {
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag6;
            label62: {
                flag = !p_344407_.isSpectator();
                flag1 = p_344407_ != player && p_344407_ != entity;
                flag2 = !player.isAlliedTo(p_344407_);
                if (p_344407_ instanceof TamableAnimal tamableanimal) {
                    if (tamableanimal.isTame() && player.getUUID().equals(tamableanimal.getOwnerUUID())) {
                        flag6 = true;
                        break label62;
                    }
                }

                flag6 = false;
            }

            boolean flag3;
            label55: {
                flag3 = !flag6;
                if (p_344407_ instanceof ArmorStand armorstand) {
                    if (armorstand.isMarker()) {
                        flag6 = false;
                        break label55;
                    }
                }

                flag6 = true;
            }

            boolean flag4 = flag6;
            boolean flag5 = entity.distanceToSqr(p_344407_) <= Math.pow(3.5, 2.0);
            return flag && flag1 && flag2 && flag3 && flag4 && flag5;
        };
    }

    private static double getKnockbackPower(Player player, LivingEntity entity, Vec3 entityPos) {
        return (3.5 - entityPos.length()) * 0.699999988079071 * (double)(player.fallDistance > 5.0F ? 2 : 1) * (1.0 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
    }

    public static boolean canSmashAttack(LivingEntity entity) {
        return entity.fallDistance > 1.5F && !entity.isFallFlying();
    }
}
