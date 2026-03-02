package me.kall.enhancedtrees.mixin.decay;

import com.google.common.collect.ImmutableSet;
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

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void enhancedTrees$init(CallbackInfo ci) {
        ImmutableSet<Integer> values = ((IntegerPropertyAccessor) DISTANCE).values();
        int one = values.iterator().next();
        int min = one;
        int max = one;
        for (int value : values) {
            if (min > value) min = value;
            if (max < value) max = value;
        }

        int newMax = (int) (TreeBonusConfig.FOLIAGE_DECAY_RANGE_BONUS * (double) max);
        DISTANCE = IntegerProperty.create("distance", min, newMax);
        EnhancedTrees.LOGGER.info("Max value of BlockStateProperties DISTANCE is updated from {} to {}", max, newMax);
    }
}
