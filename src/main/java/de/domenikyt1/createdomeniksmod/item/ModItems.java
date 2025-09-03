package de.domenikyt1.createdomeniksmod.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import de.domenikyt1.createdomeniksmod.CDM;
import de.domenikyt1.createdomeniksmod.item.custom.BaseballBat;
import de.domenikyt1.createdomeniksmod.item.custom.HatItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import static de.domenikyt1.createdomeniksmod.CDM.REGISTRATE;

public class ModItems {
    private static final String MOD_ID = CDM.MOD_ID;

    public static final ItemEntry<Item> INCOMPLETE_FIRE_COAL =
            REGISTRATE.item("incomplete_fire_coal", Item::new)
                    .register();

    public static final ItemEntry<FireCoal> FIRE_COAL =
            REGISTRATE.item("fire_coal", properties -> new FireCoal(properties, 2400))
                    .register();
    public static final ItemEntry<BaseballBat> BASEBALL_BAT =
            REGISTRATE.item("baseball_bat", properties -> new BaseballBat(Tiers.WOOD, (new Item.Properties()
                    .durability(690)
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .requiredFeatures()
                    .attributes(BaseballBat.createAttributes(Tiers.WOOD, 4, 6.0F))
                    )))
                    .register();

    public static final ItemEntry<Item> CHOCOLATE_COIN =
            REGISTRATE.item("chocolate_coin", properties -> new Item((new Item.Properties()
                            .food(new FoodProperties.Builder()
                                    .nutrition(10)
                                    .saturationModifier(3)
                                    .build())
                    )))
                    .register();


    public static final ItemEntry<HatItem> WIZZARD_HAT =
            REGISTRATE.item("wizzard_hat", properties -> new HatItem((new Item.Properties()
                            .stacksTo(1)
            )))
                    .register();

    public static final ItemEntry<HatItem> BANDANA =
            REGISTRATE.item("bandana", properties -> new HatItem((new Item.Properties()
                            .stacksTo(1)
                    )))
                    .register();

    public static final ItemEntry<Item> INFO =
            REGISTRATE.item("info", properties -> new Item(new Item.Properties()
                            .stacksTo(1)
                    ))
                    .register();


    public static void register() {
    }
}
