package xyz.refinedev.practice.api.match;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.Nullable;

import xyz.refinedev.practice.api.match.enums.MatchDeathReason;
import xyz.refinedev.practice.api.match.enums.MatchEndReason;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;
import xyz.refinedev.practice.api.match.meta.IPostMatchInventory;
import xyz.refinedev.practice.api.utils.ServiceUtil;

import java.util.Collection;
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
public interface MatchAPI {

    MatchAPI BRIDGE = ServiceUtil.findFirst(MatchAPI.class).orElse(null);

    static MatchAPI instance() {
        if (BRIDGE == null) {
            throw new IllegalStateException("No implementation found");
        }
        return BRIDGE;
    }

    /**
     * This handles the statistical requirements of ending a match.
     * After completion, it will terminate the match. Ending a match
     * using this method is the correct and safe way to end a match.
     * As compared to {@link #terminateMatch(IMatch)}, this method will
     * handle updating stats, ELO, and other match related data.
     *
     * @param match {@link IMatch}
     */
    void end(IMatchPlayer match, MatchEndReason reason);

    /**
     * This cleans up the match and teleports  all players and spectators
     * to spawn along with sending them their {@link IPostMatchInventory} message.
     * This method is also responsible for handling /leave or /bolt terminate.
     * It's essentially resetting the players and removing the match from memory.
     * This method does NOT handle any statistical requirements of ending a match.
     *
     * @param match {@link IMatch}
     */
    void terminateMatch(IMatch match);

    /**
     * This method is used to end a match in the event of a critical failure.
     * This should be used sparingly and only in situations where the match
     * cannot continue due to unforeseen circumstances. This method will not
     * handle any statistical requirements of ending a match, it will simply
     * terminate the match and notify all players involved.
     *
     * @param match  {@link IMatch}
     * @param reason {@link String} Reason for the fatal end
     */
    void fatalEnd(IMatch match, String reason);

    /**
     * Resets all blocks in the match asynchronously.
     * This is used to reset the arena for round cleanups.
     * Like in battle rush, the blocks need to be cleared after each round.
     *
     * @param match {@link IMatch}
     * @return {@link CompletableFuture<Boolean>} whether the blocks were reset successfully or not
     */
    CompletableFuture<Boolean> resetBlocks(IMatch match);

    /**
     * Resets the arena for the match asynchronously.
     * This is used to reset the arena after a match has ended.
     * This will reset both the blocks and the entities in the arena.
     *
     * @param match {@link IMatch}
     * @return {@link CompletableFuture<Boolean>} whether the arena was reset successfully or not
     */
    CompletableFuture<Boolean> resetArena(IMatch match);

    /**
     * Handle the kill effect for the dead player via killer player's effect
     *
     * @param deadPlayer   {@link Player} The player that died or disconnected
     * @param killerPlayer {@link Player} The killer of the player if there is one or else null
     */
    void handleKillEffect(Player deadPlayer, Player killerPlayer);

    /**
     * Main method for handling a player's death while in match
     * or a player disconnecting while in match. The reason primarily
     * defines if the player is eligible for a respawn after death or not.
     *
     * @param match        {@link IMatch} The match of player dying
     * @param deadPlayer   {@link Player} The player that died or disconnected
     * @param killerPlayer {@link Player} The killer of the player if there is one or else null
     * @param reason       {@link MatchDeathReason} What was the cause of their death?
     */
    void handleDeath(IMatch match, Player deadPlayer, Player killerPlayer, MatchDeathReason reason);

    /**
     * Returns a Match by its ID
     *
     * @param id {@link UUID match id}
     * @return   {@link IMatch}
     */
     @Nullable IMatch getMatch(UUID id);

    /**
     * Get a {@link Collection} of all ongoing matches.
     *
     * @return {@link Collection}
     */
    Collection<IMatch> getMatches();

    /**
     * Get the match a player is currently in.
     *
     * @param player {@link Player}
     * @return {@link IMatch} or null if not in a match
     */
    @Nullable IMatch getMatchByPlayer(Player player);
}
