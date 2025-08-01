package de.domenikyt1.createdomeniksmod.item;

import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.item.custom.BaseballBat;
import de.domenikyt1.createdomeniksmod.item.custom.HatItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ModItems {
    private static final String MOD_ID = CDM.MOD_ID;

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public class CurioItem implements ICurioItem {

        @Override
        public void curioTick(SlotContext slotContext, ItemStack stack) {
            // ticking logic here
        }
    }

    public static final DeferredItem<Item> INCOMPLETE_FIRE_COAL = ITEMS.register(
            "incomplete_fire_coal",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FIRE_COAL = ITEMS.register(
            "fire_coal",
            () -> new FireCoal(new Item.Properties(), 2400));


    public static final DeferredItem<Item> BASEBALL_BAT = ITEMS.register(
            "baseball_bat",
            () -> new BaseballBat(Tiers.WOOD, (new Item.Properties())
                    .durability(690)
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .requiredFeatures()
                    .attributes(BaseballBat.createAttributes(Tiers.WOOD, 4, 6.0F)))

    );
    public static final DeferredItem<Item> CHOCOLATE_COIN = ITEMS.register(
            "chocolate_coin",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(10)
                            .saturationModifier(3)
                            .build())
            ));

    public static final DeferredItem<HatItem> WIZZARD_HAT = ITEMS.register(
            "wizzard_hat",
            () -> new HatItem(new Item.Properties())
            );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
