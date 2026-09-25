package xyz.refinedev.practice.api.stats;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.ToIntFunction;

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
public interface StatsAPI {

    /**
     * Get the stats profile of a player
     *
     * @param player {@link Player} to get the stats profile of
     * @return {@link IStatsProfile} of the player
     */
    IStatsProfile getStatsProfile(Player player);

    /**
     * Get the stats profile of a player by their UUID.
     * If the player is online, this will return the same instance as {@link #getStatsProfile(Player)}.
     * Otherwise, it will fetch the data from the database asynchronously.
     *
     * @param uuid {@link UUID} to get the stats profile of
     * @return {@link CompletableFuture} of the player's {@link IStatsProfile}
     */
    CompletableFuture<IStatsProfile> getStatsProfile(UUID uuid);

    /**
     * Save the stats profile of a player.
     *
     * @param statsProfile {@link IStatsProfile} to save
     * @param async        whether to save the stats profile asynchronously or not
     */
    void saveStatsProfile(IStatsProfile statsProfile, boolean async);

    /**
     * Replace the formula that turns a profile's kit elos into its global elo.
     * Bolt applies it wherever it recalculates a global elo: after ranked matches,
     * elo commands and when a profile loads. A formula that throws falls back to the default.
     *
     * @param formula profile → global elo, or {@code null} for the default (average elo of the ranked kits)
     */
    void setGlobalEloFormula(@Nullable ToIntFunction<IStatsProfile> formula);

    /**
     * Recalculate every saved profile's global elo with the current formula and store it,
     * so leaderboards and positions match after the formula changes. Online profiles are
     * recalculated on the main thread and saved as usual.
     *
     * @return {@link CompletableFuture} with the number of stored profiles whose global elo changed
     */
    CompletableFuture<Integer> recalculateGlobalElo();

    //TODO: Leaderboards
}
