package xyz.refinedev.practice.api.stats;

import org.bukkit.entity.Player;
import xyz.refinedev.practice.api.utils.ServiceUtil;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

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

    StatsAPI BRIDGE = ServiceUtil.findFirst(StatsAPI.class).orElse(null);

    static StatsAPI instance() {
        if (BRIDGE == null) {
            throw new IllegalStateException("No implementation found");
        }
        return BRIDGE;
    }

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
     * @return {@link CompletableFuture<IStatsProfile>} of the player
     */
    CompletableFuture<IStatsProfile> getStatsProfile(UUID uuid);

    /**
     * Save the stats profile of a player.
     *
     * @param statsProfile {@link IStatsProfile} to save
     * @param async        whether to save the stats profile asynchronously or not
     */
    void saveStatsProfile(IStatsProfile statsProfile, boolean async);

    //TODO: Leaderboards
}
