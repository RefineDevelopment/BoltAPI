package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.profile.history.IProfileHistory;

/**
 * Fired when Bolt finishes recalculating match statistics.
 */
@Getter
@RequiredArgsConstructor
public class MatchStatsUpdateEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final @Nullable IProfileHistory history;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
