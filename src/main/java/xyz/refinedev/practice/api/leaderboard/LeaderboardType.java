package xyz.refinedev.practice.api.leaderboard;

import com.google.common.base.Preconditions;
import xyz.refinedev.practice.api.stats.IStatsCache;

/**
 * Represents the different types of leaderboards in the system.
 * <p>
 * Each type can be either <b>local</b> (per-kit) or <b>global</b> (across all kits).
 * Global variants are automatically linked to their local counterparts via {@link #toGlobal()} and {@link #toLocal()}.
 * The key represents the field in the database. E.g. "elo", "kills", "wins", "winstreak", "experience".
 * If the type is local, it is fetched from the kit-specific {@link IStatsCache} from the database.
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 12/29/2022
 */
public enum LeaderboardType {

    // Local leaderboard types
    ELO("Elo", "elo", false, null),
    KILLS("Kills", "kills", false, null),
    WINS("Wins", "wins", false, null),
    WINSTREAK("Winstreak", "winstreak", false, null),
    EXPERIENCE("Experience", "experience", false, null),

    // Global leaderboard types
    GLOBAL_ELO("Global Elo", "globalElo", true, ELO),
    GLOBAL_KILLS("Global Kills", "kills", true, KILLS),
    GLOBAL_WINS("Global Wins", "wins", true, WINS),
    GLOBAL_WINSTREAK("Global Winstreak", "winstreak", true, WINSTREAK),
    GLOBAL_EXPERIENCE("Global XP", "experience", true, EXPERIENCE);

    private final String displayName;
    private final String key;
    private final boolean global;

    /**
     * If this is a global leaderboard, links back to its local type.
     * If this is a local leaderboard, points to its global counterpart.
     */
    private LeaderboardType counterpart;

    LeaderboardType(String displayName, String key, boolean global, LeaderboardType counterpart) {
        this.displayName = displayName;
        this.key = key;
        this.global = global;
        this.counterpart = counterpart;
    }

    static {
        // Wire up local counterparts to their global equivalents
        ELO.counterpart = GLOBAL_ELO;
        KILLS.counterpart = GLOBAL_KILLS;
        WINS.counterpart = GLOBAL_WINS;
        WINSTREAK.counterpart = GLOBAL_WINSTREAK;
        EXPERIENCE.counterpart = GLOBAL_EXPERIENCE;
    }

    /**
     * @return the global variant of this leaderboard type
     * @throws IllegalArgumentException if called on a global type
     */
    public LeaderboardType toGlobal() {
        Preconditions.checkArgument(!this.global, "[Bolt] Already a global leaderboard type: " + this);
        return this.counterpart;
    }

    /**
     * @return the local (per-kit) variant of this leaderboard type
     * @throws IllegalArgumentException if called on a local type
     */
    public LeaderboardType toLocal() {
        Preconditions.checkArgument(this.global, "[Bolt] Already a local leaderboard type: " + this);
        return this.counterpart;
    }

    /**
     * Get the display name of this leaderboard type.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * Get the key representing this leaderboard type in the database.
     *
     * @return the database key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Check if this leaderboard type is global (across all kits).
     *
     * @return true if global, false if local (per-kit)
     */

    public boolean isGlobal() {
        return this.global;
    }

    /**
     * Get the counterpart leaderboard type.
     * If this is local, returns the global type, and vice versa.
     *
     * @return the counterpart leaderboard type
     */
    public LeaderboardType getCounterpart() {
        return this.counterpart;
    }
}
