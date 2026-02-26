package me.kall.enhancedtrees;

import me.kall.duplicationless.config.JsonConfig;
import net.minecraftforge.fml.common.Mod;

@Mod(EnhancedTrees.MOD_ID)
public final class EnhancedTrees {
    public static final String MOD_ID = "enhancedtrees";

    private static final JsonConfig CONFIG = JsonConfig.create(MOD_ID, "1")
            .put("TrunkBonus", 2.00)
            .put("FoliageBonus", 1.50)
            .initialize();

    public static final double TRUNK_BONUS = CONFIG.getDouble("TrunkBonus");
    public static final double FOLIAGE_BONUS = CONFIG.getDouble("FoliageBonus");
}
