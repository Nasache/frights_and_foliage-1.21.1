package net.nathan.frights_and_foliage.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModSounds {
    public static final SoundEvent STALK_ALERT = registerSoundEvent("stalk_alert");
    public static final SoundEvent STALK_ANGRY = registerSoundEvent("stalk_angry");
    public static final SoundEvent STALK_HURT = registerSoundEvent("stalk_hurt");

    public static final SoundEvent VIRE_CAW = registerSoundEvent("vire_caw");
    public static final SoundEvent VIRE_AMBIENT = registerSoundEvent("vire_ambient");

    public static final SoundEvent FUMKIN_HURT = registerSoundEvent("fumkin_hurt");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier identifier = Identifier.of(FrightsAndFoliage.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerSounds() {
        FrightsAndFoliage.LOGGER.info("Registering Mod Sounds for " + FrightsAndFoliage.MOD_ID);
    }
}
