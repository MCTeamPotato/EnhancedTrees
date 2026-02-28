package me.kall.enhancedtrees.mixin;

import me.kall.enhancedtrees.TreeBonusConfig;
import net.minecraft.util.UniformInt;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoliagePlacer.class)
public abstract class FoliagePlacerMixin {
    @Mutable @Shadow @Final protected UniformInt radius;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void enhancedTrees$init(UniformInt radius, UniformInt arg2, CallbackInfo ci) {
        this.radius = UniformInt.of((int) (((UniformIntAccessor)radius).baseValue() * TreeBonusConfig.FOLIAGE_XZ_BONUS), (int) (((UniformIntAccessor)radius).spread() * TreeBonusConfig.FOLIAGE_XZ_BONUS));
    }
}
