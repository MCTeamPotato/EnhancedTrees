package me.kall.enhancedtrees.mixin;

import me.kall.enhancedtrees.EnhancedTrees;
import me.kall.enhancedtrees.TreeBonusConfig;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockStateProperties.class)
public abstract class BlockStatePropertiesMixin {
    @Mutable @Shadow @Final public static IntegerProperty DISTANCE;

    @SuppressWarnings("DataFlowIssue")
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void enhancedTrees$init(CallbackInfo ci) {
        int oldMax = ((IntegerPropertyAccessor) (Object) DISTANCE).max();
        int newMax = (int) (TreeBonusConfig.FOLIAGE_DECAY_RANGE_BONUS * (double) oldMax);
        DISTANCE = IntegerProperty.create("distance", ((IntegerPropertyAccessor)(Object) DISTANCE).min(), newMax);
        EnhancedTrees.LOGGER.info("Max value of BlockStateProperties DISTANCE is updated from {} to {}", oldMax, newMax);
    }
}
