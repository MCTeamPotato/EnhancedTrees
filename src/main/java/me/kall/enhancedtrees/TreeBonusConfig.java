package me.kall.enhancedtrees;

import me.kall.duplicationless.config.JsonConfig;

public class TreeBonusConfig {
    private static final JsonConfig CONFIG = JsonConfig.create(EnhancedTrees.MOD_ID, "1")
            .put("TrunkBonus", 1.50)
            .put("FoliageHorizontalBonus", 1.50)
            .put("FoliageVerticalBonus", 1.50)
            .put("FoliageDecayRangeBonus", 1.50)
            .initialize();

    public static final double FOLIAGE_Y_BONUS = CONFIG.getDouble("FoliageVerticalBonus");
    public static final double FOLIAGE_XZ_BONUS = CONFIG.getDouble("FoliageHorizontalBonus");
    public static final double TRUNK_BONUS = CONFIG.getDouble("TrunkBonus");
    public static final double FOLIAGE_DECAY_RANGE_BONUS = CONFIG.getDouble("FoliageDecayRangeBonus");
}
