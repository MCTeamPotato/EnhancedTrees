package me.kall.enhancedtrees.mixin;

import me.kall.enhancedtrees.TreeBonusConfig;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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

    @Inject(method = "getLightBlock", at = @At("HEAD"), cancellable = true)
    private void noLongerBlockLight(BlockState state, CallbackInfoReturnable<Integer> cir) {
        if (TreeBonusConfig.TRANSPARENT_LEAVES) cir.setReturnValue(0);
    }
}
