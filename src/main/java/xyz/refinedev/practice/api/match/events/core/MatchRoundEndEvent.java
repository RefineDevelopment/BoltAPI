package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * Called when a round ends in a best-of match, but the match
 * itself has not ended yet (more rounds remain).
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/14/2025
 */
@Getter
public class MatchRoundEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final int round;
    private final IMatchPlayer roundWinner;

    public MatchRoundEndEvent(IMatch match, int round, IMatchPlayer roundWinner) {
        this.match = match;
        this.round = round;
        this.roundWinner = roundWinner;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
