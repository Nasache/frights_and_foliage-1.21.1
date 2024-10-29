package net.nathan.frights_and_foliage.util;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.nathan.frights_and_foliage.entity.custom.VireArrowEntity;
import net.nathan.frights_and_foliage.item.ModItems;

public class ModDispenserBehavior {
    public static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(ModItems.VIRE_FEATHER_ARROW, new ProjectileDispenserBehavior() {
            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return new VireArrowEntity(world, position.getX(), position.getY(), position.getZ());
            }
        });
    }
}
