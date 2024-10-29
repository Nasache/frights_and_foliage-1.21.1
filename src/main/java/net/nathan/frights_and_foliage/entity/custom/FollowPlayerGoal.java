package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;

import java.util.EnumSet;

public class FollowPlayerGoal extends Goal {
    private final PathAwareEntity mob;
    private final double speed;
    private LivingEntity target;
    private int updateCountdownTicks;

    public FollowPlayerGoal(PathAwareEntity mob, double speed) {
        this.mob = mob;
        this.speed = speed;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        PlayerEntity target = this.mob.getWorld().getClosestPlayer(this.mob, 30);
        if (target == null || target.isCreative() || target.isDead()) {
            return false;
        }
        this.target = target;
        return true;
    }

    @Override
    public boolean shouldContinue() {
        return this.target != null && this.target.isAlive() && !this.mob.getNavigation().isIdle();
    }

    @Override
    public void start() {
        this.updateCountdownTicks = 0;
    }

    @Override
    public void tick() {
        if (this.target != null) {
            this.mob.getLookControl().lookAt(this.target, 30.0F, 30.0F);
            double distanceSquared = this.mob.squaredDistanceTo(this.target.getX(), this.target.getY(), this.target.getZ());

            this.updateCountdownTicks = Math.max(this.updateCountdownTicks - 1, 0);

            if (this.updateCountdownTicks <= 0) {
                double targetX = this.target.getX();
                double targetY = this.target.getY();
                double targetZ = this.target.getZ();
                this.updateCountdownTicks = 4 + this.mob.getRandom().nextInt(7);

                if (distanceSquared > 1024.0) {
                    this.updateCountdownTicks += 10;
                } else if (distanceSquared > 256.0) {
                    this.updateCountdownTicks += 5;
                }

                this.mob.getNavigation().startMovingTo(targetX, targetY, targetZ, this.speed);
            }
        }
    }

    @Override
    public void stop() {
        this.target = null;
        this.mob.getNavigation().stop();
    }
}

