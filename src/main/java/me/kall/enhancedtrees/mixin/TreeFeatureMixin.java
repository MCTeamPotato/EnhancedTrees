package me.kall.enhancedtrees.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.kall.enhancedtrees.TreeBonusConfig;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Random;

@Mixin(TreeFeature.class)
public abstract class TreeFeatureMixin {
    @WrapOperation(method = "doPlace", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/feature/foliageplacers/FoliagePlacer;foliageHeight(Ljava/util/Random;ILnet/minecraft/world/level/levelgen/feature/configurations/TreeConfiguration;)I"))
    private int increaseHeight(FoliagePlacer instance, Random random, int i, TreeConfiguration treeConfiguration, @NotNull Operation<Integer> original) {
        return (int) (original.call(instance, random, i, treeConfiguration) * TreeBonusConfig.FOLIAGE_Y_BONUS);
    }
}
