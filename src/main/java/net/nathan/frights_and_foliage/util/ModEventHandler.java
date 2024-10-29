package net.nathan.frights_and_foliage.util;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;

import java.util.HashMap;
import java.util.Map;

public class ModEventHandler {

    public static final Map<PlayerEntity, Long> recentBlockBreaks = new HashMap<>();
    public static final Map<PlayerEntity, Long> recentMobDamage = new HashMap<>();

    public static void registerEvents() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
            if (!player.isCreative() && world instanceof ServerWorld) {
                recentBlockBreaks.put(player, world.getTime());
            }
        });

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!player.isCreative() && world instanceof ServerWorld && entity instanceof MobEntity) {
                recentMobDamage.put(player, world.getTime());
            }
            return ActionResult.PASS;
        });
    }

    public static void cleanUpOldEntries(long currentTime, long expirationTime) {
        recentBlockBreaks.entrySet().removeIf(entry -> currentTime - entry.getValue() > expirationTime);
        recentMobDamage.entrySet().removeIf(entry -> currentTime - entry.getValue() > expirationTime);
    }
}
