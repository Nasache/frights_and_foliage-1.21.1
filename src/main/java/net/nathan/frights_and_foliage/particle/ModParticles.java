package net.nathan.frights_and_foliage.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModParticles {
    public static final SimpleParticleType RED_ASERIA_PARTICLE =
            registerParticle("red_aseria_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType ORANGE_ASERIA_PARTICLE =
            registerParticle("orange_aseria_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType YELLOW_ASERIA_PARTICLE =
            registerParticle("yellow_aseria_leaves", FabricParticleTypes.simple());

    public static final SimpleParticleType SPOOKY_FIRE_FLAME =
            registerParticle("spooky_fire_flame", FabricParticleTypes.simple());


    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(FrightsAndFoliage.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        FrightsAndFoliage.LOGGER.info("Registering Particles for " + FrightsAndFoliage.MOD_ID);
    }
}