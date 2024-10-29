package net.nathan.frights_and_foliage.blocks.custom;

import net.minecraft.block.Block;

public abstract class CrimsonGourdBlock
        extends Block {
    public CrimsonGourdBlock(Settings settings) {
        super(settings);
    }

    public abstract CrimsonPumpkinStemBlock getStem();

    public abstract AttachedCrimsonPumpkinStemBlock getAttachedStem();
}

