package net.nathan.frights_and_foliage.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.minecraft.item.ProjectileItem;
import net.nathan.frights_and_foliage.entity.custom.VireArrowEntity;
import org.jetbrains.annotations.Nullable;


public class VireArrowItem extends ArrowItem implements ProjectileItem {
    public VireArrowItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        return new VireArrowEntity(world, shooter, stack.copyWithCount(1), shotFrom);
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        VireArrowEntity vireArrowEntity = new VireArrowEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1), null);
        vireArrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return vireArrowEntity;
    }
}
