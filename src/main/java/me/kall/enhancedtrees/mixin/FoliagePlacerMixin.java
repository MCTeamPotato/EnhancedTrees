package me.kall.enhancedtrees.mixin;

import me.kall.enhancedtrees.EnhancedTrees;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoliagePlacer.class)
public abstract class FoliagePlacerMixin {
    @Mutable @Shadow @Final protected IntProvider radius;

    @Mutable
    @Shadow @Final protected IntProvider offset;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void enhancedTrees$init(IntProvider radius, IntProvider offset, CallbackInfo ci) {
        this.radius = new IntProvider() {
            @Override
            public int sample(@NotNull RandomSource random) {
                return (int) (radius.sample(random) * EnhancedTrees.FOLIAGE_BONUS);
            }

            @Override
            public int getMinValue() {
                return (int) (radius.getMinValue() * EnhancedTrees.FOLIAGE_BONUS);
            }

            @Override
            public int getMaxValue() {
                return (int) (radius.getMaxValue() * EnhancedTrees.FOLIAGE_BONUS);
            }

            @Override
            public @NotNull IntProviderType<?> getType() {
                return radius.getType();
            }
        };
        this.offset = new IntProvider() {
            @Override
            public int sample(@NotNull RandomSource random) {
                return (int) (offset.sample(random) * EnhancedTrees.FOLIAGE_BONUS);
            }

            @Override
            public int getMinValue() {
                return (int) (offset.getMinValue() * EnhancedTrees.FOLIAGE_BONUS);
            }

            @Override
            public int getMaxValue() {
                return (int) (offset.getMaxValue() * EnhancedTrees.FOLIAGE_BONUS);
            }

            @Override
            public @NotNull IntProviderType<?> getType() {
                return offset.getType();
            };
        };
    }
}
