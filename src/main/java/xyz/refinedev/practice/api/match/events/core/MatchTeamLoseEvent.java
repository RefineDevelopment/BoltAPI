package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.meta.IMatchTeam;

/**
 * Fired when a team match resolves with a losing team.
 */
@Getter
@RequiredArgsConstructor
public class MatchTeamLoseEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final IMatchTeam losingTeam;

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
