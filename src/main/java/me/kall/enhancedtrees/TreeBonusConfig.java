package me.kall.enhancedtrees;

import me.kall.duplicationless.config.JsonConfig;

public class TreeBonusConfig {
    private static final JsonConfig CONFIG = JsonConfig.create(EnhancedTrees.MOD_ID, "3")
            .put("TrunkBonus", 4.000)
            .put("FoliageHorizontalBonus", 2.000)
            .put("FoliageVerticalBonus", 2.000)
            .put("FoliageDecayRangeBonus", 2.000)
            .put("LeavesNoLongerBlockLight", false)
            .initialize();

    public static final double FOLIAGE_Y_BONUS = CONFIG.getDouble("FoliageVerticalBonus");
    public static final double FOLIAGE_XZ_BONUS = CONFIG.getDouble("FoliageHorizontalBonus");
    public static final double TRUNK_BONUS = CONFIG.getDouble("TrunkBonus");
    public static final double FOLIAGE_DECAY_RANGE_BONUS = CONFIG.getDouble("FoliageDecayRangeBonus");
    public static final boolean TRANSPARENT_LEAVES = CONFIG.getBoolean("LeavesNoLongerBlockLight");
}
