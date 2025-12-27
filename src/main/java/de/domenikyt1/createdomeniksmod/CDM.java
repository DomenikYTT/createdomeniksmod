//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package de.domenikyt1.createdomeniksmod;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import de.domenikyt1.createdomeniksmod.datagen.CDMDatagen;
import de.domenikyt1.createdomeniksmod.register.CreativeTabs.Tabs;
import de.domenikyt1.createdomeniksmod.register.block.CDMBlockEntityTypes;
import de.domenikyt1.createdomeniksmod.register.block.CDMBlocks;
import de.domenikyt1.createdomeniksmod.register.block.entity.ModBlockEntities;
import de.domenikyt1.createdomeniksmod.register.item.CDMArmorMaterial;
import de.domenikyt1.createdomeniksmod.register.item.ModItems;
import de.domenikyt1.createdomeniksmod.register.recipe.ModRecipes;
import de.domenikyt1.createdomeniksmod.register.screen.ModMenuTypes;
import de.domenikyt1.createdomeniksmod.utils.CDMRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

@Mod("createdomeniksmod")
public class CDM {
    public static final String MOD_ID = "createdomeniksmod";
    public static CDMRegistry REGISTER = new CDMRegistry("createdomeniksmod");
    public static CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Item> ITEMS;

    public CDM(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        CDMBlockEntityTypes.register();
        Tabs.TAB.register(modEventBus);
        REGISTRATE.registerEventListeners(modEventBus);
        REGISTRATE.defaultCreativeTab(Tabs.BASE_TAB, "base_tab");
        LOGGER.info("Loading All Creative Tabs...");
        CDMArmorMaterial.register(modEventBus);
        LOGGER.info("Loading Items...");
        ModItems.register();
        LOGGER.info("Loading Blocks");
        CDMBlocks.register();
        if (ModList.get().isLoaded("rechiseled")) {
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
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
        if (Config.logDirtBlock) {
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        }

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
        Config.items.forEach((item) -> {
            LOGGER.info("ITEM >> {}", item.toString());
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("you are cool :D");
    }

    public static ResourceLocation loc(String loc) {
        return ResourceLocation.fromNamespaceAndPath("createdomeniksmod", loc);
    }

    public static ResourceLocation emptyLoc() {
        return ResourceLocation.fromNamespaceAndPath("createdomeniksmod", "empty");
    }

    static {
        ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, "createdomeniksmod");
    }



    public static CreateRegistrate getRegistrate() {
        return REGISTRATE;
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
