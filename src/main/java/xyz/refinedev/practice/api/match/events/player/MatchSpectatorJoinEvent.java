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
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 3/3/2023
 */

@Getter
@RequiredArgsConstructor
public class MatchSpectatorJoinEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final Player spectator;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
