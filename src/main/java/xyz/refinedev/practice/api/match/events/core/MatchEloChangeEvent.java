package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2026, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * Fired once per ranked solo match, after the winner's ranked winstreak has been
 * incremented for this win but before either player's new elo is applied. Changing
 * {@link #setWinnerEloChange(int)} changes the elo the winner actually gains, and the
 * end-of-match elo message reports the adjusted value.
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/18/2026
 */

@Getter
public class MatchEloChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final IMatchPlayer winner;
    private final IMatchPlayer loser;
    private final int winnerOldElo;
    private final int loserOldElo;
    private final int loserEloChange;

    @Setter
    private int winnerEloChange;

    public MatchEloChangeEvent(IMatch match, IMatchPlayer winner, IMatchPlayer loser,
                               int winnerOldElo, int loserOldElo, int winnerEloChange, int loserEloChange) {
        this.match = match;
        this.winner = winner;
        this.loser = loser;
        this.winnerOldElo = winnerOldElo;
        this.loserOldElo = loserOldElo;
        this.winnerEloChange = winnerEloChange;
        this.loserEloChange = loserEloChange;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
