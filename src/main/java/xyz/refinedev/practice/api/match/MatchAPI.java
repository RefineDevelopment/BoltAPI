package xyz.refinedev.practice.api.match;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.Nullable;

import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.match.enums.MatchDeathReason;
import xyz.refinedev.practice.api.match.enums.MatchEndReason;
import xyz.refinedev.practice.api.match.meta.IPostMatchInventory;

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

    /**
     * This handles the statistical requirements of ending a match.
     * After completion, it will terminate the match. Ending a match
     * using this method is the correct and safe way to end a match.
     * As compared to {@link #terminateMatch(IMatch)}, this method will
     * handle updating stats, ELO, and other match related data.
     *
     * @param match {@link IMatch}
     * @param reason {@link MatchEndReason}
     */
    void end(IMatch match, MatchEndReason reason);

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
     * @return {@link CompletableFuture} of {@link Boolean} whether the blocks were reset successfully or not
     */
    CompletableFuture<Boolean> resetBlocks(IMatch match);

    /**
     * Resets the arena for the match asynchronously.
     * This is used to reset the arena after a match has ended.
     * This will reset both the blocks and the entities in the arena.
     *
     * @param match {@link IMatch}
     * @return {@link CompletableFuture} of {@link Boolean} whether the arena was reset successfully or not
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
     * Alias for {@link #getMatchByPlayer(Player)}.
     *
     * @param player the player whose active match should be returned
     * @return the current match, or null
     */
    @Nullable
    default IMatch getMatch(Player player) {
        return this.getMatchByPlayer(player);
    }

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

    /**
     * Handles a match respawn using Bolt's normal respawn flow.
     *
     * @param match  the match
     * @param player the player respawning
     */
    default void handleRespawn(IMatch match, Player player) {
    }

    /**
     * Returns a cached post-match inventory snapshot by player UUID.
     *
     * @param playerId the player uuid
     * @return the snapshot, or null if none is cached
     */
    @Nullable
    default IPostMatchInventory getInventory(UUID playerId) {
        return null;
    }

    /**
     * @return the total number of fighters across all matches
     */
    default int getFightingCount() {
        return 0;
    }

    /**
     * @return the total number of players inside bot matches
     */
    default int getBotMatchesCount() {
        return 0;
    }

    /**
     * Creates and starts a solo ranked match between two players using the specified kit.
     * An arena will be automatically selected. If no arena is available, null is returned.
     * This is useful for external integrations (e.g., Discord bots) to force-start
     * ranked matches programmatically.
     *
     * @param playerA The first player
     * @param playerB The second player
     * @param kit     The kit to use for the match
     * @return The created {@link IMatch}, or null if the match could not be created
     */
    @Nullable IMatch createSoloRankedMatch(Player playerA, Player playerB, IKit kit);

    /**
     * Creates and starts a solo unranked match between two players using the specified kit.
     * An arena will be automatically selected. If no arena is available, null is returned.
     *
     * @param playerA The first player
     * @param playerB The second player
     * @param kit     The kit to use for the match
     * @return The created {@link IMatch}, or null if the match could not be created
     */
    @Nullable IMatch createSoloUnrankedMatch(Player playerA, Player playerB, IKit kit);

    /**
     * Creates and starts a team match between two teams using the specified kit.
     * An arena will be automatically selected. If no arena is available, null is returned.
     *
     * @param teamA The first team's player list
     * @param teamB The second team's player list
     * @param kit   The kit to use for the match
     * @param ranked Whether the match is ranked
     * @return The created {@link IMatch}, or null if the match could not be created
     */
    @Nullable IMatch createTeamMatch(java.util.List<Player> teamA, java.util.List<Player> teamB, IKit kit, boolean ranked);
}
