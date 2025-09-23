package xyz.refinedev.practice.api.match.events.player;

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
 * This event is fired before a player is set up in a match.
 *
 * @author Drizzy
 * @version Bolt
 * @since 9/3/2022
 */

@Getter
@RequiredArgsConstructor
public class MatchPlayerSetupEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final IMatchPlayer player;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
