package me.fishbythefin.minecraftinfinite.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class GeekBarItem extends Item {

    private static final int DRINK_DURATION = 32;

    public GeekBarItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!pLevel.isClientSide) {
            if (pLevel.random.nextInt(10) == 7) {
                pEntityLiving.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 140));

            } else {
                pEntityLiving.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 800));
            }

        }


        Vec3 lookAngle = pEntityLiving.getLookAngle();

        for (int i = 0; i < 10; i++) {

            double powerx = pLevel.random.nextFloat();
            double powerz = pLevel.random.nextFloat();

            pLevel.addParticle(ParticleTypes.WHITE_SMOKE, pEntityLiving.getX(), pEntityLiving.getY() + 1.6, pEntityLiving.getZ(), lookAngle.x * powerx * 0.2, lookAngle.z * 0.1, lookAngle.z * powerz * 0.2);
        }

        return super.finishUsingItem(pStack, pLevel, pEntityLiving);

    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
        return DRINK_DURATION;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }
}
