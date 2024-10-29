package net.nathan.frights_and_foliage.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.nathan.frights_and_foliage.sound.ModSounds;
import net.nathan.frights_and_foliage.util.ModEventHandler;
import org.jetbrains.annotations.Nullable;

public class StalkEntity extends HostileEntity {

    private boolean isAlerted = false;
    private boolean isHostile = false;
    private int followPlayerTicks = 0;
    private long lastWarningTime = 0;
    private static final long WARNING_COOLDOWN_TICKS = 100;

    private FollowPlayerGoal followPlayerGoal;

    public StalkEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.followPlayerGoal = new FollowPlayerGoal(this, 1.0);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.5));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();

        PlayerEntity closestPlayer = this.getWorld().getClosestPlayer(this, 30);

        if (closestPlayer != null) {
            double distanceToPlayer = this.squaredDistanceTo(closestPlayer);
            long currentTime = this.getWorld().getTime();

            if (closestPlayer.isCreative() || closestPlayer.isDead()) {
                this.resetHostility();
                return;
            }

            if (distanceToPlayer >= 25 && distanceToPlayer <= 900) {
                if (ModEventHandler.recentBlockBreaks.containsKey(closestPlayer) &&
                        currentTime - ModEventHandler.recentBlockBreaks.get(closestPlayer) < 2) {
                    if (canPlayWarningScream(currentTime)) {
                        this.playAlertSound();
                        this.isAlerted = true;
                        this.followPlayerTicks = 200;
                        if (this.goalSelector.getGoals().stream().noneMatch(goal -> goal.getGoal() == this.followPlayerGoal && goal.isRunning())) {
                            this.goalSelector.add(2, this.followPlayerGoal);
                        }
                    }
                } else if (ModEventHandler.recentMobDamage.containsKey(closestPlayer) &&
                        currentTime - ModEventHandler.recentMobDamage.get(closestPlayer) < 2) {
                    if (canPlayWarningScream(currentTime)) {
                        this.playAlertSound();
                        this.isAlerted = true;
                        this.followPlayerTicks = 200;
                        if (this.goalSelector.getGoals().stream().noneMatch(goal -> goal.getGoal() == this.followPlayerGoal && goal.isRunning())) {
                            this.goalSelector.add(2, this.followPlayerGoal);
                        }
                    }
                }

                if (this.isAlerted && this.followPlayerTicks > 0) {
                    this.followPlayerTicks--;
                } else {
                    this.isAlerted = false;
                    this.goalSelector.remove(this.followPlayerGoal);
                }
            }

            if (distanceToPlayer < 25 && closestPlayer.canSee(this)) {
                if (ModEventHandler.recentBlockBreaks.containsKey(closestPlayer) &&
                        currentTime - ModEventHandler.recentBlockBreaks.get(closestPlayer) < 2) {
                    this.playHostileSound();
                    this.isHostile = true;
                    this.isAlerted = false;
                    this.getNavigation().stop();
                    this.setTarget(closestPlayer);
                } else if (ModEventHandler.recentMobDamage.containsKey(closestPlayer) &&
                        currentTime - ModEventHandler.recentMobDamage.get(closestPlayer) < 2) {
                    this.playHostileSound();
                    this.isHostile = true;
                    this.isAlerted = false;
                    this.getNavigation().stop();
                    this.setTarget(closestPlayer);
                }
            }

            if (distanceToPlayer > 900) {
                this.resetHostility();
            }
        } else {
            this.resetHostility();
        }
    }

    private void resetHostility() {
        this.isHostile = false;
        this.isAlerted = false;
        this.followPlayerTicks = 0;
        this.setTarget(null);
        this.goalSelector.remove(this.followPlayerGoal);
    }

    public static DefaultAttributeContainer.Builder createStalkAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15);
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.BLOCK_WOOD_STEP;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.10F, 2.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.STALK_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.STALK_HURT;
    }

    protected SoundEvent getAlertSound() {
        return ModSounds.STALK_ALERT;
    }

    protected SoundEvent getHostileSound() {
        return ModSounds.STALK_ANGRY;
    }

    public void playAlertSound() {
        if (!this.isHostile) {
            this.playSound(this.getAlertSound(), 3.0F, this.getSoundPitch());
            this.lastWarningTime = this.getWorld().getTime();
        }
    }

    public void playHostileSound() {
        if (!this.isHostile) {
            this.playSound(this.getHostileSound(), 3.0F, this.getSoundPitch());
        }
    }


    private boolean canPlayWarningScream(long currentTime) {
        return currentTime - lastWarningTime >= WARNING_COOLDOWN_TICKS;
    }
}
