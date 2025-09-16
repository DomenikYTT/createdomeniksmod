package de.domenikyt1.createdomeniksmod;

import com.mojang.logging.LogUtils;
import de.domenikyt1.createdomeniksmod.datagen.CDMDatagen;
import de.domenikyt1.createdomeniksmod.register.block.entity.ModBlockEntities;
import de.domenikyt1.createdomeniksmod.register.block.CDMBlocks;
import de.domenikyt1.createdomeniksmod.register.CreativeTabs.Tabs;
import de.domenikyt1.createdomeniksmod.register.item.ModItems;
import de.domenikyt1.createdomeniksmod.register.recipe.ModRecipes;
import de.domenikyt1.createdomeniksmod.register.util.CDMItemProperties;
import de.domenikyt1.createdomeniksmod.registry.custom.CDMRegistrate;
import de.domenikyt1.createdomeniksmod.register.screen.ModMenuTypes;
import de.domenikyt1.createdomeniksmod.utils.CDMRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import static de.domenikyt1.createdomeniksmod.register.CreativeTabs.Tabs.BASE_TAB;
// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CDM.MOD_ID)
public class CDM {

    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "createdomeniksmod";

    public static CDMRegistry REGISTER = new CDMRegistry(MOD_ID);

    public static CDMRegistrate REGISTRATE = CDMRegistrate.create(MOD_ID);

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "ceatedomeniksmod" namespace
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(BuiltInRegistries.ITEM, MOD_ID);

    // Creates a creative tab with the id "ceatedomeniksmod:example_tab" for the example item, that is placed after the combat tab

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CDM(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        Tabs.TAB.register(modEventBus);
        REGISTRATE.registerEventListeners(modEventBus);
        REGISTRATE.defaultCreativeTab(BASE_TAB, "base_tab");

        // Register the Deferred Register to the mod event bus so blocks get registered
        // Register the Deferred Register to the mod event bus so items get registered
        LOGGER.info("Loading All Creative Tabs...");


        LOGGER.info("Loading Items...");
        ModItems.register();
        LOGGER.info("Loading Blocks");
        CDMBlocks.register();

        if(ModList.get().isLoaded("rechiseled")) {
            LOGGER.info("Loading Rechiseled Compat...");
        } else {
            LOGGER.info("Rechiseled is not intsalled...");
            LOGGER.info("Skipping Rechiseled Compat...");
        }

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);


        modEventBus.addListener(Tabs::addCreative);
        modEventBus.addListener(EventPriority.HIGH, CDMDatagen::gatherData);
        // Register the Deferred Register to the mod event bus so tabs get registered

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Ceatedomeniksmod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("you are cool :D");
    }
    @EventBusSubscriber(modid = CDM.MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            CDMItemProperties.addCustomItemProperties();
        }
    }


    public static ResourceLocation loc(String loc) {
        return ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, loc);
    }
    public static ResourceLocation emptyLoc() {
        return ResourceLocation.fromNamespaceAndPath(CDM.MOD_ID, "empty");
    }
}

