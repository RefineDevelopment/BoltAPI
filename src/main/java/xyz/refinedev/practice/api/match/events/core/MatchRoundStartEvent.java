package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.match.IMatch;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * Called when a new round starts in a best-of match.
 * Round 0 is the first round.
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/14/2025
 */
@Getter
public class MatchRoundStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final int round;

    public MatchRoundStartEvent(IMatch match, int round) {
        this.match = match;
        this.round = round;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
