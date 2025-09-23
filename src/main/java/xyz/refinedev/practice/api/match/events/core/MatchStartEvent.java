package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.match.IMatch;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * This event fires when a match is either started or restarted.
 * Restarts can occur when there are multiple rounds in a match.
 *
 * @author Drizzy
 * @version Bolt
 * @since 9/3/2022
 */

@Getter
@RequiredArgsConstructor
public class MatchStartEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
