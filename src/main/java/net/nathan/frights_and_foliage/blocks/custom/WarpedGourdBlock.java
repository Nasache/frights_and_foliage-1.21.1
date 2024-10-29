package net.nathan.frights_and_foliage.blocks.custom;

import net.minecraft.block.Block;

public abstract class WarpedGourdBlock
        extends Block {
    public WarpedGourdBlock(Settings settings) {
        super(settings);
    }

    public abstract WarpedPumpkinStemBlock getStem();

    public abstract AttachedWarpedPumpkinStemBlock getAttachedStem();
}

