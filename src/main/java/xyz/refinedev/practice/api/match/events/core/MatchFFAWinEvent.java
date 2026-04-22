package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;

/**
 * Fired when an FFA match resolves with a winning player (the last one alive).
 */
@Getter
@RequiredArgsConstructor
public class MatchFFAWinEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final IMatchPlayer winner;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
