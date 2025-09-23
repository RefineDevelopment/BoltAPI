package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * This event is only useful for when {@link IMatch#isSoloMatch()} returns true.
 * It will not fire for any other match types. This was internally used for win commands,
 * xp and coins distribution.
 *
 * @author Drizzy
 * @version Bolt
 * @since 12/31/2023
 */

@Getter
@RequiredArgsConstructor
public class MatchWinEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final IMatchPlayer winner;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
