package me.kall.enhancedtrees.mixin;

import net.minecraft.util.UniformInt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(UniformInt.class)
public interface UniformIntAccessor {
    @Accessor("baseValue")
    int baseValue();

    @Accessor("spread")
    int spread();
}
