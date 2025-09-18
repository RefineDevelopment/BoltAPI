package xyz.refinedev.practice.api.leaderboard.meta;

import xyz.refinedev.practice.api.leaderboard.LeaderboardType;

public interface IKitLeaderboard {

    /**
     * Gets the type of the leaderboard (e.g., WINS, KILLS).
     *
     * @return The type of the leaderboard.
     */
    LeaderboardType getType();

    /**
     * Gets the name of the kit associated with this leaderboard.
     *
     * @return The name of the kit.
     */
    String getKitName();

    /**
     * Gets the entries in the leaderboard.
     *
     * @return A list of leaderboard entries.
     */
    ILeaderboardEntry[] getEntries();
}
