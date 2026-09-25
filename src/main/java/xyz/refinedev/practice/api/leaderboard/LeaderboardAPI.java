package xyz.refinedev.practice.api.leaderboard;

import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.leaderboard.meta.IKitLeaderboard;
import xyz.refinedev.practice.api.leaderboard.meta.ILeaderboardEntry;

import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * The LeaderboardAPI interface provides methods to interact with player leaderboards.
 * It allows fetching leaderboards for specific kits or globally, updating the leaderboard data,
 * and clearing cached data. This service access the 'bolt-statistics' collection in the database.
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/18/2025
 */
public interface LeaderboardAPI {

    /**
     * Updates the leaderboards by fetching the latest data from the database.
     * <b>This method should be called asynchronously to avoid blocking the main thread.</b>
     * It refreshes the cached leaderboard data to ensure it is up-to-date.
     */
    void update();

    /**
     * Clears the cached leaderboard data.
     */
    void clearCache();

    /**
     * Fetches the leaderboard for a specific {@link IKit} and type.
     *
     * @param kit    The {@link IKit} to fetch the leaderboard for.
     * @param amount The number of top entries to retrieve.
     * @param type   The type of leaderboard to fetch (e.g., ELO, WINS, KILLS).
     * @return       A {@link CompletableFuture} that will complete with an IKitLeaderboard object representing the leaderboard for the specified kit and type.
     */
    CompletableFuture<IKitLeaderboard> fetchKitLeaderboard(IKit kit, int amount, LeaderboardType type);

    /**
     * Fetches the global leaderboard for the specified type.
     *
     * @param type   The type of leaderboard to fetch (e.g., ELO, WINS, KILLS).
     * @param amount The number of top entries to retrieve.
     * @return A {@link CompletableFuture} that will complete with an array of ILeaderboardEntry objects representing the top players.
     */
    CompletableFuture<ILeaderboardEntry[]> fetchGlobalLeaderboard(int amount, LeaderboardType type);

    /**
     * Fetches the global elo position a player with the given global elo holds: the number of
     * saved profiles with a strictly higher global elo, plus one. Reads the database directly
     * rather than the top-10 cache, so it works for any position.
     *
     * @param globalElo The global elo to rank.
     * @return A {@link CompletableFuture} that will complete with the 1-based position.
     */
    CompletableFuture<Integer> fetchGlobalEloPosition(int globalElo);
}
