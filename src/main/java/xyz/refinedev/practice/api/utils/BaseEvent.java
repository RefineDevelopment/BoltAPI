package xyz.refinedev.practice.api.utils;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BaseEvent extends Event {

    public BaseEvent() {
        super();
    }

    public BaseEvent(boolean isAsync) {
        super(isAsync);
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
