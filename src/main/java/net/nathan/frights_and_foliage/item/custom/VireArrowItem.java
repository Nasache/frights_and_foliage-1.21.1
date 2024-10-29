package net.nathan.frights_and_foliage.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nathan.frights_and_foliage.entity.custom.VireArrowEntity;

public class VireArrowItem extends ArrowItem {
    public VireArrowItem(Item.Settings settings) {
        super(settings);
    }

    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new VireArrowEntity(world, shooter);
    }
}
