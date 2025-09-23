package xyz.refinedev.practice.api.profile.events;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 12/18/2023
 */

@Getter @Setter
public class ProfileLoginEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final String name;
    private final UUID uuid;
    private String kickMessage;

    private boolean cancelled;

    public ProfileLoginEvent(String name, UUID uuid) {
        super(true);
        this.name = name;
        this.uuid = uuid;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
