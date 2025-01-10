package org.modintroduction.modding_practice.block.custom;
import net.minecraft.world.level.block.Block;

public class FuelBlock extends Block {
    private final int burnTime;
    public FuelBlock(Properties properties, int burnTime) {
        super(properties);
        this.burnTime = burnTime;
    }
}