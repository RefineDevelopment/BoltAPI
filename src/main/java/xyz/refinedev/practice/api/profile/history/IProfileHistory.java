package xyz.refinedev.practice.api.profile.history;

import org.jetbrains.annotations.NotNull;

import xyz.refinedev.practice.api.match.meta.IPostMatchInventory;

import java.util.Date;
import java.util.UUID;

/**
 * Represents a snapshot of a completed match for a player.
 * <p>
 * Each {@code IProfileHistory} instance stores metadata about the match,
 * including participants, outcome, timestamps, snapshots of inventories,
 * and various statistics such as ELO changes, win streaks, kills, and deaths.
 * </p>
 *
 * <p>
 * Implementations of this interface should be comparable by their
 * {@link #getDate()} field to allow sorting histories chronologically.
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 9/25/2021
 */
public interface IProfileHistory extends Comparable<IProfileHistory> {

    /**
     * @return the unique identifier for this profile history entry
     */
    String getUniqueId();

    /**
     * @return the match type (e.g., ranked, unranked, event)
     */
    String getType();

    /**
     * @return the timestamp when the match began, in milliseconds since epoch
     */
    long getTime();

    /**
     * @return the duration of the match in milliseconds
     */
    long getDuration();

    /**
     * @return true if this profile history is expired and no longer valid
     */
    boolean isExpired();

    /**
     * Marks this profile history as expired or active.
     *
     * @param expired whether the profile history is expired
     */
    void setExpired(boolean expired);

    /**
     * @return the {@link Date} object representing when the match took place
     */
    Date getDate();

    /**
     * Sets the {@link Date} for when the match took place.
     *
     * @param date the date to associate with this history
     */
    void setDate(Date date);

    /**
     * @return the post-match snapshot of the winner’s inventory and stats
     */
    IPostMatchInventory getWinnerSnapshot();

    /**
     * @return the post-match snapshot of the loser’s inventory and stats
     */
    IPostMatchInventory getLooserSnapshot();

    /**
     * @return the name of the kit used in the match
     */
    String getKit();

    /**
     * @return the name of the arena where the match took place
     */
    String getArena();

    /**
     * @return true if the match was ranked, false otherwise
     */
    boolean isRanked();

    /**
     * Sets whether this match was ranked.
     *
     * @param ranked whether the match was ranked
     */
    void setRanked(boolean ranked);

    int getWinnerChangedELO();
    void setWinnerChangedELO(int elo);

    int getWinnerWinstreak();
    void setWinnerWinstreak(int winstreak);

    int getWinnerRankedWinstreak();
    void setWinnerRankedWinstreak(int rankedWinstreak);

    int getWinnerXP();
    void setWinnerXP(int xp);

    int getWinnerKills();
    void setWinnerKills(int kills);

    int getWinnerDeaths();
    void setWinnerDeaths(int deaths);

    int getWinnerPoints();
    void setWinnerPoints(int points);

    int getLooserChangedELO();
    void setLooserChangedELO(int elo);

    int getLooserWinstreak();
    void setLooserWinstreak(int winstreak);

    int getLooserRankedWinstreak();
    void setLooserRankedWinstreak(int rankedWinstreak);

    int getLooserXP();
    void setLooserXP(int xp);

    int getLooserKills();
    void setLooserKills(int kills);

    int getLooserDeaths();
    void setLooserDeaths(int deaths);

    int getLooserPoints();
    void setLooserPoints(int points);

    /**
     * Determines if the given player UUID corresponds to the winner of this match.
     *
     * @param uuid the UUID of the player to check
     * @return true if the given UUID belongs to the winner, false otherwise
     */
    boolean isWinner(UUID uuid);

    /**
     * Compares this history with another by their {@link #getDate()}.
     *
     * @param o the other profile history to compare against
     * @return a negative integer, zero, or a positive integer as this history
     *         occurred before, at the same time, or after the specified history
     */
    @Override
    int compareTo(@NotNull IProfileHistory o);
}
