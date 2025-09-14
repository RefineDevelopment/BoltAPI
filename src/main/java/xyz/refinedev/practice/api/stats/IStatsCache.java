package xyz.refinedev.practice.api.stats;

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

public interface IStatsCache {

    int getWins();
    void setWins(int wins);
    void incrementWins();

    int getLosses();
    void setLosses(int losses);
    void incrementLosses();

    int getKills();
    void setKills(int kills);
    void incrementKills();

    int getDeaths();
    void setDeaths(int deaths);
    void incrementDeaths();

    int getWinstreak();
    void setWinstreak(int winstreak);

    int getHighestWinstreak();
    void setHighestWinstreak(int highestWinstreak);

    int getRankedWins();
    void setRankedWins(int rankedWins);
    void incrementRankedWins();

    int getRankedLosses();
    void setRankedLosses(int rankedLosses);
    void incrementRankedLosses();

    int getRankedWinstreak();
    void setRankedWinstreak(int rankedWinstreak);

    int getRankedHighestWinstreak();
    void setRankedHighestWinstreak(int rankedHighestWinstreak);

    int getTournamentWins();
    void setTournamentWins(int tournamentWins);

    int getElo();
    void setElo(int elo);

    /**
     * Increments the winstreak, and ranked winstreak if applicable.
     * Updates the highest win streaks if needed.
     *
     * @param ranked whether this is a ranked winstreak
     */
    void incrementWinstreak(boolean ranked);

    /**
     * Resets winstreak(s) to 0.
     *
     * @param ranked whether to reset ranked winstreak as well
     */
    void destroyWinstreak(boolean ranked);

    /**
     * Calculates the ranked WLR (Win/Loss Ratio).
     *
     * @return ranked WLR rounded to nearest whole number
     */
    double getRankedWLR();

    /**
     * Calculates the WLR (Win/Loss Ratio).
     *
     * @return WLR rounded to nearest whole number
     */
    double getWLR();

    /**
     * Calculates the KDR (Kill/Death Ratio).
     *
     * @return KDR rounded to nearest whole number
     */
    double KDR();
}

