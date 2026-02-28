package me.kall.enhancedtrees.mixin;

import me.kall.enhancedtrees.TreeBonusConfig;
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

    @Inject(method = "<init>", at = @At("RETURN"))
    private void enhancedTrees$init(IntProvider radius, IntProvider offset, CallbackInfo ci) {
        this.radius = new IntProvider() {
            @Override
            public int sample(@NotNull RandomSource random) {
                return (int) (radius.sample(random) * TreeBonusConfig.FOLIAGE_XZ_BONUS);
            }

            @Override
            public int getMinValue() {
                return (int) (radius.getMinValue() * TreeBonusConfig.FOLIAGE_XZ_BONUS);
            }

            @Override
            public int getMaxValue() {
                return (int) (radius.getMaxValue() * TreeBonusConfig.FOLIAGE_XZ_BONUS);
            }

            @Override
            public @NotNull IntProviderType<?> getType() {
                return radius.getType();
            }
        };
    }
}
