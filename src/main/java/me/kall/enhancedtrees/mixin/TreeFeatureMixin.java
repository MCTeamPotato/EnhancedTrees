package me.kall.enhancedtrees.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.kall.enhancedtrees.TreeBonusConfig;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TreeFeature.class)
public abstract class TreeFeatureMixin {
    @WrapOperation(method = "doPlace", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/feature/foliageplacers/FoliagePlacer;foliageHeight(Lnet/minecraft/util/RandomSource;ILnet/minecraft/world/level/levelgen/feature/configurations/TreeConfiguration;)I"))
    private int increaseHeight(FoliagePlacer foliagePlacer, RandomSource randomSource, int i, TreeConfiguration treeConfiguration, @NotNull Operation<Integer> original) {
        return (int) (original.call(foliagePlacer, randomSource, i, treeConfiguration) * TreeBonusConfig.FOLIAGE_Y_BONUS);
    }
}
