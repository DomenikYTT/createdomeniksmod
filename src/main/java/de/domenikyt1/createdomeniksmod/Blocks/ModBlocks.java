package de.domenikyt1.createdomeniksmod.Blocks;

import de.domenikyt1.createdomeniksmod.Blocks.custom.SailBlock;
import de.domenikyt1.createdomeniksmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final String MOD_ID = "createdomeniksmod";
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);


    public static final DeferredBlock<Block> FIRE_COAL_BLOCK = registerBlock("fire_coal_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2, 1)
                    .sound(SoundType.STONE)
            ));
    public static final DeferredBlock<Block> BLASTING_SAIL = registerBlock(
            "blasting_sail",
            () -> new SailBlock(BlockBehaviour.Properties.of()
                    .strength(2,1)
                    .sound(SoundType.WOOD)
                    .noOcclusion()
            ));

    public static final DeferredBlock<Block> WASHING_SAIL = registerBlock(
            "washing_sail",
            () -> new SailBlock(BlockBehaviour.Properties.of()
                    .strength(2, 1)
                    .sound(SoundType.WOOD)
                    .noOcclusion()
            ));
    public static final DeferredBlock<Block> RGB_BLOCK = registerBlock(
            "rgb_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.STONE)
            ));
    public static final DeferredBlock<Block> REALISM_CASING = registerBlock(
            "realism_casing",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
            ));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
