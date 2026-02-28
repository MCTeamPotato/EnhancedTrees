package me.kall.enhancedtrees.mixin;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(IntegerProperty.class)
public interface IntegerPropertyAccessor {
    @Accessor("max")
    int max();

    @Accessor("min")
    int min();
}
