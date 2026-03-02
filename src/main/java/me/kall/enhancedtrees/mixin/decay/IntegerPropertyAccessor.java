package me.kall.enhancedtrees.mixin.decay;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(IntegerProperty.class)
public interface IntegerPropertyAccessor {
    @Accessor("values")
    ImmutableSet<Integer> values();
}
