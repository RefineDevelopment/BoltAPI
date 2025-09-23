package xyz.refinedev.practice.api.match.events.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.match.IMatch;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2024, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * This event is fired when a player successfully respawns in a match.
 *
 * @author Drizzy
 * @version Bolt
 * @since 9/16/2024
 */

@Getter
@RequiredArgsConstructor
public class MatchRespawnEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final Player player;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
