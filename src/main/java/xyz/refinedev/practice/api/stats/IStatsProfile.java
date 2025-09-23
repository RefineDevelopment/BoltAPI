package xyz.refinedev.practice.api.stats;

import org.jetbrains.annotations.Nullable;

import xyz.refinedev.practice.api.division.IDivision;
import xyz.refinedev.practice.api.kit.IKit;

import java.util.UUID;

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
public interface IStatsProfile {

    /**
     * Get the unique ID of the profile
     *
     * @return {@link UUID} of the profile
     */
    UUID getUniqueId();

    /**
     * Get the global ELO from the stats profile.
     *
     * @return The global ELO.
     */
    int getGlobalElo();

    /**
     * Get the number of wins from the stats profile.
     *
     * @return The number of wins.
     */
    int getWins();

    /**
     * Get the number of losses from the stats profile.
     *
     * @return The number of losses.
     */
    int getLosses();

    /**
     * Get the number of kills from the stats profile.
     *
     * @return The number of kills.
     */
    int getKills();

    /**
     * Add experience to the stats profile.
     *
     * @param experience the amount of experience to add
     */
    void addExperience(int experience);

    /**
     * Get the current experience points of the stats profile.
     *
     * @return The current experience points.
     */
    int getExperience();

    /**
     * Add coins to the stats profile.
     *
     * @param coins the number of coins to add
     */
    void addCoins(int coins);

    /**
     * Subtract coins from the stats profile.
     *
     * @param coins the number of coins to subtract
     */
    void subtractCoins(int coins);

    /**
     * Get the current coin balance of the stats profile.
     *
     * @return The current coin balance.
     */
    int getCoins();

    /**
     * Get the total number of wins across all kits.
     *
     * @return The total number of wins.
     */
    int getTotalWins();

    /**
     * Get the total number of unranked wins across all kits.
     *
     * @return The total number of unranked wins.
     */
    int getUnrankedWins();

    /**
     * Get the total number of ranked wins across all kits.
     *
     * @return The total number of ranked wins.
     */
    int getRankedWins();

    /**
     * Get the total number of losses across all kits.
     *
     * @return The total number of losses.
     */
    int getTotalLosses();

    /**
     * Get the total number of unranked losses across all kits.
     *
     * @return The total number of unranked losses.
     */
    int getUnrankedLosses();

    /**
     * Get the total number of ranked losses across all kits.
     *
     * @return The total number of ranked losses.
     */
    int getRankedLosses();

    /**
     * Get the total winstreak across all kits.
     *
     * @return The total winstreak.
     */
    int getTotalWinstreak();

    /**
     * Get the highest winstreak achieved across all kits.
     *
     * @return The highest winstreak.
     */
    int getHighestWinstreak();

    /**
     * Get the total number of kills across all kits.
     *
     * @return The total number of kills.
     */
    int getTotalKills();

    /**
     * Get the total number of deaths across all kits.
     *
     * @return The total number of deaths.
     */
    int getTotalDeaths();

    /**
     * Get the total number of tournament wins across all kits.
     *
     * @return The total number of tournament wins.
     */
    int getTotalTournamentWins();

    /**
     * Get the current level of the stats profile.
     *
     * @return The current level.
     */
    int getLevel();

    /**
     * Get the next level that can be achieved.
     *
     * @return The next level that can be achieved.
     */
    int getNextLevel();

    /**
     * Get the division associated with this stats profile.
     *
     * @return The {@link IDivision} associated with this stats profile.
     */
    IDivision getDivision();

    /**
     * Get the next division that can be achieved.
     *
     * @return The next {@link IDivision} that can be achieved, or null if there is no next division.
     */
    @Nullable IDivision getNextDivision();

    /**
     * Get the stats cache for a specific kit.
     *
     * @param kit The {@link IKit} to get the stats cache for.
     * @return The {@link IStatsCache} associated with the specified kit.
     */
    IStatsCache getStats(IKit kit);
}
