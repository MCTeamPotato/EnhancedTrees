package me.kall.enhancedtrees.mixin;

import me.kall.enhancedtrees.EnhancedTrees;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TrunkPlacer.class)
public abstract class TrunkPlacerMixin {
    @Mutable @Shadow @Final protected int baseHeight;
    @Mutable @Shadow @Final protected int heightRandA;
    @Mutable @Shadow @Final protected int heightRandB;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void enhancedTrees$init(int baseHeight, int heightRandA, int heightRandB, CallbackInfo ci) {
        baseHeight = (int) (baseHeight * EnhancedTrees.TRUNK_BONUS);
        heightRandA = (int) (heightRandA * EnhancedTrees.TRUNK_BONUS);
        heightRandB = (int) (heightRandB * EnhancedTrees.TRUNK_BONUS);
        if (baseHeight > 32) baseHeight = 32;
        if (heightRandA > 24) heightRandA = 24;
        if (heightRandB > 24) heightRandB = 24;
        this.baseHeight = baseHeight;
        this.heightRandA = heightRandA;
        this.heightRandB = heightRandB;
    }
}
