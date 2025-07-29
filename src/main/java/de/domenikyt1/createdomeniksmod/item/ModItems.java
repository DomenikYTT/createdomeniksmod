package de.domenikyt1.createdomeniksmod.item;

import de.domenikyt1.createdomeniksmod.item.custom.BaseballBat;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    private static final String MOD_ID = "createdomeniksmod";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);



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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
