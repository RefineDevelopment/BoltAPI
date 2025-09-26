package xyz.refinedev.practice.api;

import com.google.common.base.Preconditions;

import xyz.refinedev.practice.api.kit.KitAPI;
import xyz.refinedev.practice.api.leaderboard.LeaderboardAPI;
import xyz.refinedev.practice.api.match.MatchAPI;
import xyz.refinedev.practice.api.profile.ProfileAPI;
import xyz.refinedev.practice.api.queue.QueueAPI;
import xyz.refinedev.practice.api.stats.StatsAPI;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/23/2025
 */

@SuppressWarnings("unused")
public enum BoltAPI {

    INSTANCE;

    private ProfileAPI profileAPI;
    private QueueAPI queueAPI;
    private KitAPI kitAPI;
    private MatchAPI matchAPI;
    private StatsAPI statsAPI;
    private LeaderboardAPI leaderboardAPI;

    public ProfileAPI getProfileAPI() {
        Preconditions.checkNotNull(profileAPI, "ProfileAPI has not been initialized yet.");
        return profileAPI;
    }

    public void setProfileAPI(ProfileAPI profileAPI) {
        this.profileAPI = profileAPI;
    }

    public QueueAPI getQueueAPI() {
        Preconditions.checkNotNull(queueAPI, "QueueAPI has not been initialized yet.");
        return queueAPI;
    }

    public void setQueueAPI(QueueAPI queueAPI) {
        this.queueAPI = queueAPI;
    }

    public KitAPI getKitAPI() {
        Preconditions.checkNotNull(kitAPI, "KitAPI has not been initialized yet.");
        return kitAPI;
    }

    public void setKitAPI(KitAPI kitAPI) {
        this.kitAPI = kitAPI;
    }

    public MatchAPI getMatchAPI() {
        Preconditions.checkNotNull(matchAPI, "MatchAPI has not been initialized yet.");
        return matchAPI;
    }

    public void setMatchAPI(MatchAPI matchAPI) {
        this.matchAPI = matchAPI;
    }

    public StatsAPI getStatsAPI() {
        Preconditions.checkNotNull(statsAPI, "StatsAPI has not been initialized yet.");
        return statsAPI;
    }

    public void setStatsAPI(StatsAPI statsAPI) {
        this.statsAPI = statsAPI;
    }

    public LeaderboardAPI getLeaderboardAPI() {
        Preconditions.checkNotNull(leaderboardAPI, "LeaderboardAPI has not been initialized yet.");
        return leaderboardAPI;
    }

    public void setLeaderboardAPI(LeaderboardAPI leaderboardAPI) {
        this.leaderboardAPI = leaderboardAPI;
    }
}
