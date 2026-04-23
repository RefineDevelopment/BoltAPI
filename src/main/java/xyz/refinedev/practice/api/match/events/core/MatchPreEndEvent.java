package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;

import org.bukkit.event.Cancellable;
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
 * Called when a match is about to end (all opponents are dead or
 * the winning condition has been met), but BEFORE stats are distributed
 * and the match is terminated. This event is cancellable — if cancelled,
 * the match will not proceed to end and will continue running.
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/14/2025
 */
@Getter
public class MatchPreEndEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final IMatchPlayer winner;
    private boolean cancelled;

    public MatchPreEndEvent(IMatch match, IMatchPlayer winner) {
        this.match = match;
        this.winner = winner;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
