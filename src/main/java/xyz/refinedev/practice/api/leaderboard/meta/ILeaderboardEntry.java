package xyz.refinedev.practice.api.leaderboard.meta;

import xyz.refinedev.practice.api.division.IDivision;

import java.util.UUID;

public interface ILeaderboardEntry {

    /**
     * Gets the unique ID of the player.
     *
     * @return the unique ID of the player.
     */
    UUID getUniqueId();

    /**
     * Gets the name of the player.
     *
     * @return the name of the player.
     */
    String getName();

    /**
     * Gets the division name of the player.
     * This can be used to fetch the actual {@link IDivision}
     *
     * @return the division name of the player.
     */
    String getDivisionName();

    /**
     * Gets the value of the player for the specific leaderboard type.
     *
     * @return the value of the player.
     */
    int getValue();
}
