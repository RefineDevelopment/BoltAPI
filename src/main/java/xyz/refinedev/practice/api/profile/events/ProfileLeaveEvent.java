package xyz.refinedev.practice.api.profile.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.profile.IProfile;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 10/25/2023
 */

@Getter
@RequiredArgsConstructor
public class ProfileLeaveEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final IProfile profile;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
