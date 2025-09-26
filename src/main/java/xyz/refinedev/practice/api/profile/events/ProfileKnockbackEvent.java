package xyz.refinedev.practice.api.profile.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * It is recommended to use this event to handle custom knockback support for players.
 * This event will be called whenever a player's knockback/combat settings need to be applied.
 * If you want to override bolt's listener, set the priority of your listener to above NORMAL.
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/26/2025
 */
@Getter @Setter
@AllArgsConstructor
public class ProfileKnockbackEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private String knockbackProfile;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
