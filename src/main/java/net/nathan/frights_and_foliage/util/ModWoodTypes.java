package net.nathan.frights_and_foliage.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModWoodTypes {
    public static final WoodType ASERIA = new WoodTypeBuilder()
            .soundGroup(BlockSoundGroup.WOOD)
            .hangingSignSoundGroup(BlockSoundGroup.HANGING_SIGN)
            .fenceGateCloseSound(SoundEvents.BLOCK_FENCE_GATE_CLOSE)
            .fenceGateOpenSound(SoundEvents.BLOCK_FENCE_GATE_OPEN)
            .register(Identifier.of(FrightsAndFoliage.MOD_ID, "aseria"), BlockSetType.OAK);

    public static final WoodType MARNOR = new WoodTypeBuilder()
            .soundGroup(BlockSoundGroup.WOOD)
            .hangingSignSoundGroup(BlockSoundGroup.HANGING_SIGN)
            .fenceGateCloseSound(SoundEvents.BLOCK_FENCE_GATE_CLOSE)
            .fenceGateOpenSound(SoundEvents.BLOCK_FENCE_GATE_OPEN)
            .register(Identifier.of(FrightsAndFoliage.MOD_ID, "marnor"), BlockSetType.DARK_OAK);
}