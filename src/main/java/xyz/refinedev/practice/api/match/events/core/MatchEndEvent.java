package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.MatchAPI;
import xyz.refinedev.practice.api.match.enums.MatchEndReason;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * This is called when a match ends normally and successfully.
 * For more information, see {@link MatchAPI#end(IMatch, MatchEndReason)}
 *
 * @author Drizzy
 * @version Bolt
 * @since 10/2/2022
 */

@Getter
@RequiredArgsConstructor
public class MatchEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
    
}
