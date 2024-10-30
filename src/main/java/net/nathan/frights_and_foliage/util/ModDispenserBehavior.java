package net.nathan.frights_and_foliage.util;

import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.nathan.frights_and_foliage.item.ModItems;
import net.nathan.frights_and_foliage.item.custom.VireArrowItem;

public class ModDispenserBehavior {
    public static void registerDispenserBehavior() {
        DispenserBlock.registerBehavior(ModItems.VIRE_FEATHER_ARROW, new DispenserBehavior() {
            @Override
            public ItemStack dispense(BlockPointer pointer, ItemStack stack) {
                World world = pointer.world();
                Position position = DispenserBlock.getOutputLocation(pointer);
                Direction direction = pointer.state().get(DispenserBlock.FACING);

                ProjectileEntity entity = ((VireArrowItem) ModItems.VIRE_FEATHER_ARROW).createEntity(world, position, stack, direction);
                entity.setVelocity(direction.getOffsetX(), direction.getOffsetY(), direction.getOffsetZ(), 1.1F, 6.0F);
                world.spawnEntity(entity);

                stack.decrement(1);
                return stack;
            }
        });
    }
}