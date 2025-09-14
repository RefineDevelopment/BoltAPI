package xyz.refinedev.practice.api.division;

import org.bukkit.inventory.ItemStack;
import xyz.refinedev.practice.api.stats.IStatsProfile;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/14/2025
 */
public interface IDivision {

    /**
     * Get the name of this division.
     *
     * @return The name as a String.
     */
    String getName();

    /**
     * Get the display name of this division.
     *
     * @return The display name as a String.
     */
    String getDisplayName();

    /**
     * Get the mini logo of this division.
     *
     * @return The mini logo as a String.
     */
    String getMiniLogo();

    /**
     * Get the icon representing this division.
     *
     * @return The icon as an ItemStack.
     */
    ItemStack getIcon();

    /**
     * '&' based color code for this division.
     *
     * @return The color code.
     */
    String getColor();

    /**
     * Check if a {@link IStatsProfile} qualifies for this division.
     *
     * @param statsProfile The stats profile to check.
     * @return True if the stats profile qualifies, false otherwise.
     */
    boolean qualifies(IStatsProfile statsProfile);

    /**
     * Get the progress of a {@link IStatsProfile} towards this division.
     * The progress is the percentage of the requirements met for this division.
     *
     * @param statsProfile The stats profile to check.
     * @return The progress towards this division.
     */
    double getProgress(IStatsProfile statsProfile);
}
