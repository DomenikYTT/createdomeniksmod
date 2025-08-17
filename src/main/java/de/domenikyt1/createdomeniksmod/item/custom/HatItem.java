package de.domenikyt1.createdomeniksmod.item.custom;

import com.google.common.base.Suppliers;
import de.domenikyt1.createdomeniksmod.CDM;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.AABB;


import java.util.List;
import java.util.function.Supplier;

public class HatItem extends Item implements Equipable  {
    protected ResourceLocation HAT_LOCATION;


    public HatItem(String hatLocation, Properties properties, Supplier<ItemAttributeModifiers> defaultModifiers) {
        this(ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, hatLocation), properties);
        this.defaultModifiers = defaultModifiers;
    }

    public HatItem(ResourceLocation hatLocation, Properties properties) {
        super(properties);
        this.setRenderTexture(hatLocation.getNamespace(), hatLocation.getPath());
    }


    public void setRenderTexture(String modId, String registryName) {
        this.HAT_LOCATION = ResourceLocation.fromNamespaceAndPath(modId, "textures/models/item/" + registryName + ".png");
    }

    public ResourceLocation getHatTexture() {
        return this.HAT_LOCATION;
    }


    public static final DispenseItemBehavior DISPENSE_ITEM_BEHAVIOR = new DefaultDispenseItemBehavior() {
        protected ItemStack execute(BlockSource p_302434_, ItemStack p_40409_) {
            return ArmorItem.dispenseArmor(p_302434_, p_40409_) ? p_40409_ : super.execute(p_302434_, p_40409_);
        }
    };
    private Supplier<ItemAttributeModifiers> defaultModifiers;

    public static boolean dispenseArmor(BlockSource p_302421_, ItemStack p_40400_) {
        BlockPos blockpos = p_302421_.pos().relative((Direction)p_302421_.state().getValue(DispenserBlock.FACING));
        List<LivingEntity> list = p_302421_.level().getEntitiesOfClass(LivingEntity.class, new AABB(blockpos), EntitySelector.NO_SPECTATORS.and(new EntitySelector.MobCanWearArmorEntitySelector(p_40400_)));
        if (list.isEmpty()) {
            return false;
        } else {
            LivingEntity livingentity = (LivingEntity)list.get(0);
            EquipmentSlot equipmentslot = livingentity.getEquipmentSlotForItem(p_40400_);
            if (!p_40400_.canEquip(equipmentslot, livingentity)) {
                return false;
            } else {
                ItemStack itemstack = p_40400_.split(1);
                livingentity.setItemSlot(equipmentslot, itemstack);
                if (livingentity instanceof Mob) {
                    ((Mob)livingentity).setDropChance(equipmentslot, 2.0F);
                    ((Mob)livingentity).setPersistenceRequired();
                }

                return true;
            }
        }
    }

    public HatItem(Item.Properties p_40388_) {
        super(p_40388_);
        DispenserBlock.registerBehavior(this, DISPENSE_ITEM_BEHAVIOR);
        this.defaultModifiers = Suppliers.memoize(() -> {
            ItemAttributeModifiers.Builder itemattributemodifiers$builder = ItemAttributeModifiers.builder();
            EquipmentSlotGroup equipmentslotgroup = EquipmentSlotGroup.bySlot(EquipmentSlot.HEAD);

            return itemattributemodifiers$builder.build();
        });
    }
    public InteractionResultHolder<ItemStack> use(Level p_40395_, Player p_40396_, InteractionHand p_40397_) {
        return this.swapWithEquipmentSlot(this, p_40395_, p_40396_, p_40397_);
    }


    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }

    public Holder<SoundEvent> getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_LEATHER;
    }

    public static enum Type implements StringRepresentable {
        HAT(EquipmentSlot.HEAD,"hat");

        private final EquipmentSlot slot;
        private final String name;

        private Type(EquipmentSlot slot, String name) {
            this.slot = EquipmentSlot.HEAD;
            this.name = name;
        }

        public EquipmentSlot getSlot() {
            return this.slot;
        }

        public String getName() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}