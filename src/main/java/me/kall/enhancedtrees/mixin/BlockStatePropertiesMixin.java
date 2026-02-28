package me.kall.enhancedtrees.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import me.kall.enhancedtrees.TreeBonusConfig;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockStateProperties.class)
public abstract class BlockStatePropertiesMixin {
    @WrapOperation(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/properties/IntegerProperty;create(Ljava/lang/String;II)Lnet/minecraft/world/level/block/state/properties/IntegerProperty;"))
    private static IntegerProperty largerDist(String name, int min, int max, @NotNull Operation<IntegerProperty> original) {
        return original.call(name, min, name.equals("distance") ? (int) (max * TreeBonusConfig.FOLIAGE_DECAY_RANGE_BONUS) : max);
    }
}
