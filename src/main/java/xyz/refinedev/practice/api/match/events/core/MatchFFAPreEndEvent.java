package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;

/**
 * Fired before an FFA match ends (when only 1 player remains alive).
 * Cancelling this event will prevent the match from ending.
 */
@Getter
@RequiredArgsConstructor
public class MatchFFAPreEndEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final IMatchPlayer lastAlive;
    private boolean cancelled;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
