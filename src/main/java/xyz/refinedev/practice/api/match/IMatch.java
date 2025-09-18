package xyz.refinedev.practice.api.match;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.Nullable;

import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.match.enums.MatchType;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;
import xyz.refinedev.practice.api.match.meta.IMatchTeam;
import xyz.refinedev.practice.api.match.meta.IPostMatchInventory;
import xyz.refinedev.practice.api.queue.IQueue;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
public interface IMatch {

    /**
     * Gets the unique identifier of the match.
     *
     * @return The UUID of the match.
     */
    UUID getMatchId();

    /**
     * Gets the queue associated with the match, if any.
     *
     * @return The IQueue instance or null if no queue is associated.
     */
    @Nullable IQueue getQueue();

    /**
     * Gets the kit associated with the match.
     *
     * @return The IKit instance.
     */
    IKit getKit();

    /**
     * Gets the type of the match.
     *
     * @return The MatchType of the match.
     */
    MatchType getType();

    /**
     * Gets the current state of the match.
     *
     * @return The MatchState of the match.
     */
    MatchState getState();

    /**
     * Gets the set of spectators currently watching the match.
     *
     * @return A Set of UUIDs representing the spectators.
     */
    Set<UUID> getSpectators();

    /**
     * Gets a list of all blocks that have been changed during the match.
     * This contains their original states, current ones can be fetched by location.
     *
     * @return A List of BlockState objects representing the changed blocks.
     */
    List<BlockState> getChangedBlocks();

    /**
     * Gets a list of all locations where blocks have been placed during the match.
     *
     * @return A List of Locations where blocks were placed.
     */
    List<Location> getPlacedBlocks();

    /**
     * Gets a list of all non-player entities involved in the match.
     *
     * @return A List of Entity objects.
     */
    List<Entity> getEntities();

    /**
     * Gets the timestamp when the match started.
     * Null if the match hasn't started yet.
     *
     * @return An Instant representing the start time of the match.
     */
    @Nullable Instant getStartTimestamp();

    /**
     * Gets the timestamp when the match ended.
     * Null if the match hasn't ended yet.
     *
     * @return An Instant representing the end time of the match.
     */
    @Nullable Instant getEndTimestamp();

    /**
     * Is the match being force ended by an admin?
     *
     * @return True if the match is being force ended, false otherwise.
     */
    boolean isForceEnd();

    /**
     * Checks if the match was terminated because the server is shutting down.
     *
     * @return True if the match ended due to server shutdown, false otherwise.
     */
    boolean isServerShutdown();

    /**
     * Checks if the match has timed out due to exceeding the time limit.
     * The time limit is toggleable and configurable in the configuration file.
     *
     * @return True if the match has timed out, false otherwise.
     */
    boolean isTimedOut();

    /**
     * Checks if the match statistics have been distributed to players.
     *
     * @return True if statistics have been distributed, false otherwise.
     */
    boolean isStatsDistributed();

    /**
     * Checks if the match is a duel between two players.
     *
     * @return True if the match is a duel, false otherwise.
     */
    boolean isDuel();

    /**
     * Checks if the party was created from or for a party.
     *
     * @return True if the match is a party match, false otherwise.
     */
    boolean isPartyMode();

    /**
     * Checks if the match was forfeited by a player or team.
     *
     * @return True if the match was forfeited, false otherwise.
     */
    boolean isForfeited();

    /**
     * Gets the current round number of the match.
     * Returns 0 if the match is not round-based or not started yet.
     *
     * @return The current round number.
     */
    int getRound();

    /**
     * Set up the player for the match. This handles teleporting, inventory setup,
     * and any other necessary preparations. It is also used for respawning players
     * during the match. If the player has the  metadata "dead" set, when this method
     * is called, the player will not be spawned as a valid player.
     *
     * @param player The player to set up for the match.
     */
    void setupPlayer(Player player);

    /**
     * Returns true if the match starting
     *
     * @return {@link Boolean}
     */
    boolean isStarting();

    /**
     * Returns true if the match is in fight
     *
     * @return {@link Boolean}
     */
    boolean isFighting();

    /**
     * Returns true if the match is ending
     *
     * @return {@link Boolean}
     */
    boolean isEnding();

    /**
     * Gets the formatted duration of the match in "mm:ss" format.
     * If match is starting, it returns "Starting" instead or
     * if match is ending it returns "Ending".
     *
     * @return A String representing the match duration.
     */
    String getDuration();

    /**
     * Broadcast a message to all players in the match, including spectators.
     *
     * @param message The message to broadcast.
     */
    void broadcastMessage(String message);

    /**
     * Broadcast a {@link Sound} to all match participants
     *
     * @param sound {@link Sound}
     */
    void broadcastSound(Sound sound);

    /**
     * Apply a {@link Function} to all match participant including spectators.
     *
     * @param consumer {@link Function} to apply
     */
    void broadcastFormattedMessage(Consumer<Player> consumer);

    /**
     * Send a title to all match participants
     *
     * @param message    {@link String message}
     * @param subMessage {@link String subMessage}
     */
    void broadcastTitle(String message, String subMessage);

    /**
     * Send a title to all match spectators
     *
     * @param message    {@link String message}
     * @param subMessage {@link String subMessage}
     */
    void sendSpectatorTitle(String message, String subMessage);

    /**
     * Is the given block breakable or not for this specific match instance
     *
     * @param block {@link Block} the block being checked
     * @return      {@link Boolean} true if the block is breakable, false otherwise
     */
    boolean isBreakable(Block block);

    /**
     * Is the given block droppable or not for this specific match instance
     *
     * @param block {@link Block} the block being checked
     * @return      {@link Boolean} true if the block is droppable, false otherwise
     */
    boolean isDroppable(Block block);

    /**
     * This method returns true if the
     * current match is a ranked match.
     *
     * @return {@link Boolean}
     */
    boolean isRanked();

    /**
     * This method returns true if the match an instance of a solo match.
     *
     * @return {@link Boolean}
     */
    boolean isSoloMatch();

    /**
     * This method returns true if the match is an instance of a team match.
     *
     * @return {@link Boolean}
     */
    boolean isTeamMatch();

    /**
     * This method returns true if the current match is an FFAMatch
     *
     * @return {@link Boolean}
     */
    boolean isFFAMatch();

    /**
     * This method returns true if the
     * current match is related to a bot match
     *
     * @return {@link Boolean}
     */
    boolean isBotMatch();

    /**
     * This method returns true if the kit is TeamFight
     *
     * @return {@link Boolean}
     */
    boolean isHCFMatch();

    /**
     * This method returns true if the kit is bridges
     *
     * @return {@link Boolean}
     */
    boolean isTheBridgeMatch();

    /**
     * This method returns true if the kit is battleRush
     *
     * @return {@link Boolean}
     */
    boolean isBattleRushMatch();

    /**
     * This method returns true if the kit is mlgRush
     *
     * @return {@link Boolean}
     */
    boolean isMLGRushMatch();

    /**
     * This method returns true if the kit is boxing
     *
     * @return {@link Boolean}
     */
    boolean isBoxingMatch();

    /**
     * This method returns true if the kit is bedFight
     *
     * @return {@link Boolean}
     */
    boolean isBedFightMatch();

    /**
     * This method returns true if the kit is pearlFight
     *
     * @return {@link Boolean}
     */
    boolean isPearlFightMatch();

    /**
     * This method returns true if the kit is topFight
     *
     * @return {@link Boolean}
     */
    boolean isTopFightMatch();

    /**
     * This method returns true if the kit is stickFight
     *
     * @return {@link Boolean}
     */
    boolean isStickFightMatch();

    /**
     * This method returns true if the match is a OITQ match
     *
     * @return {@link Boolean}
     * @author J4C0B3Y
     */
    boolean isOITQMatch();

    /**
     * This method returns true if the match is lives based
     *
     * @return {@link Boolean}
     */
    boolean isLivesBasedMatch();

    /**
     * Get a IMatchPlayer via Player
     *
     * @param player {@link Player player}
     * @return {@link IMatchPlayer matchPlayer}
     */
    @Nullable IMatchPlayer getMatchPlayer(Player player);

    /**
     * Get a IMatchTeam via Player
     *
     * @param player {@link Player player}
     * @return {@link IMatchTeam matchTeam}
     */
    @Nullable IMatchTeam getMatchTeam(Player player);

    /**
     * Get a IMatchTeam via IMatchPlayer
     *
     * @param matchPlayer {@link IMatchPlayer matchPlayer}
     * @return {@link IMatchTeam matchTeam}
     */
    @Nullable IMatchTeam getMatchTeam(IMatchPlayer matchPlayer);

    /**
     * Get the Opponent {@link IMatchTeam} of a specified IMatchTeam
     *
     * @param team {@link IMatchTeam} the team whose opponent team we are getting
     * @return {@link IMatchTeam} the queried team
     */
    @Nullable IMatchTeam getOpponentMatchTeam(IMatchTeam team);

    /**
     * Get the Opponent {@link IMatchTeam} of a specified Player's IMatchTeam
     *
     * @param player {@link Player} the player whose opponent team we are getting
     * @return {@link IMatchTeam} the queried team
     */
    @Nullable IMatchTeam getOpponentMatchTeam(Player player);

    /**
     * Get the Opponent {@link IMatchPlayer} of a specified player
     *
     * @param matchPlayer {@link IMatchPlayer} the player whose opponent we are getting
     * @return {@link IMatchPlayer} the queried player
     */
    @Nullable IMatchPlayer getOpponentMatchPlayer(IMatchPlayer matchPlayer);

    /**
     * Get the Opponent {@link IMatchPlayer} of a specified player
     *
     * @param player {@link Player} the player whose opponent we are getting
     * @return {@link IMatchPlayer} the queried player
     */
    @Nullable IMatchPlayer getOpponentMatchPlayer(Player player);

    /**
     * Get the Opponent {@link Player} of a specified player
     *
     * @param player {@link Player} the player whose opponent we are getting
     * @return {@link Player} the queried player
     */
    @Nullable Player getOpponentPlayer(Player player);

    /**
     * Get a predicate that checks if the player is on the red team
     *
     * @return {@link Predicate} of {@link IMatchPlayer} which defines if the player is on the red team
     */
    Predicate<IMatchPlayer> isRedTeamPredicate();

    /**
     * Returns a list of every player involved in this match
     * Invalid players (disconnected) are not included.
     *
     * @return {@link List}
     */
    List<Player> getPlayersAndSpectators();

    /**
     * The post match inventory snapshot for a specific player.
     * Can be null if the player hasn't registered one to the match.
     *
     * @param player {@link UUID player uuid}
     * @return {@link IPostMatchInventory inv}
     */
    @Nullable IPostMatchInventory getSnapshotByPlayer(UUID player);

}
