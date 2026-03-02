package me.kall.enhancedtrees.mixin.decay;

import me.kall.enhancedtrees.TreeBonusConfig;
import net.minecraft.world.level.block.LeavesBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LeavesBlock.class)
public abstract class LeavesBlockMixin {
    @ModifyConstant(method = {"decaying", "isRandomlyTicking", "<init>"}, constant = @Constant(intValue = 7))
    private int enhancedTrees$decaying(int constant) {
        return (int) (constant * TreeBonusConfig.FOLIAGE_DECAY_RANGE_BONUS);
    }

    @ModifyConstant(method = {"updateDistance", "getDistanceAt", "<clinit>"}, constant = @Constant(intValue = 7))
    private static int enhancedTrees$updateDistance(int constant) {
        return (int) (constant * TreeBonusConfig.FOLIAGE_DECAY_RANGE_BONUS);
    }
}
