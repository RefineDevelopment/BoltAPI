package xyz.refinedev.practice.api.profile;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.profile.parkour.IProfileParkour;
import xyz.refinedev.practice.api.profile.settings.IProfileSettings;

import java.util.List;
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
public interface IProfile {

    /**
     * Get the unique ID of the profile
     *
     * @return {@link UUID} of the profile
     */
    UUID getUniqueId();

    /**
     * Get the current state of the profile
     *
     * @return {@link ProfileState} of the profile
     */
    ProfileState getState();

    /**
     * Get the settings of the profile
     *
     * @return {@link IProfileSettings} of the profile
     */
    IProfileSettings getSettings();

    /**
     * Get the parkour data of the profile
     *
     * @return {@link IProfileParkour} of the profile
     */
    IProfileParkour getParkour();

    /**
     * Returns a list of profile history IDs that can be
     * used to fetch the actual Profile History data from the database.
     * These are shared between winner and loser.
     *
     * @return List of profile history IDs
     */
    List<String> getMatchHistory();

    /**
     * Get the current match ID the profile is in, null if not in a match
     *
     * @return {@link UUID} of the match, or null if not in a match
     */
    @Nullable UUID getMatchId();

    /**
     * Get the current party ID the profile is in, null if not in a party
     *
     * @return {@link UUID} of the party, or null if not in a party
     */
    @Nullable UUID getPartyId();

    /**
     * Get the current queue ID the profile is in, null if not in a queue
     *
     * @return {@link UUID} of the queue, or null if not in a queue
     */
    @Nullable UUID getQueueId();

    /**
     * Terminate the current parkour session, if any.
     * This will reset parkour-related data and states.
     */
    void terminateParkour();

    /**
     * Claim the daily reward for the player.
     * This will also send them the daily reward message.
     */
    void claimDailyReward();

    /**
     * Check if the player can claim their daily reward.
     *
     * @return true if the player can claim their daily reward, false otherwise
     */
    boolean canClaimDailyReward();

    /**
     * Check if the profile is currently in the lobby.
     *
     * @return true if in lobby, false otherwise
     */
    boolean isInLobby();

    /**
     * Check if the profile is currently in a queue.
     *
     * @return true if in queue, false otherwise
     */
    boolean isInQueue();

    /**
     * Check if the profile is currently spectating a match.
     *
     * @return true if spectating, false otherwise
     */
    boolean isSpectating();

    /**
     * Check if the profile is currently in a match.
     *
     * @return true if in match, false otherwise
     */
    boolean isInMatch();

    /**
     * Check if the profile is currently in an event.
     *
     * @return true if in event, false otherwise
     */
    boolean isInEvent();

    /**
     * Check if the profile is currently in a tournament.
     *
     * @return true if in tournament, false otherwise
     */
    boolean isInTournament();

    /**
     * Check if the profile is currently in a party.
     *
     * @return true if in party, false otherwise
     */
    boolean isInParty();

    /**
     * Check if the profile is currently in parkour.
     *
     * @return true if in parkour, false otherwise
     */
    boolean isInParkour();

}
