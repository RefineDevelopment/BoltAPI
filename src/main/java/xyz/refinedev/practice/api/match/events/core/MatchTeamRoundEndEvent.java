package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.meta.IMatchTeam;

/**
 * Team-safe equivalent of {@link MatchRoundEndEvent}.
 */
@Getter
public class MatchTeamRoundEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IMatch match;
    private final int round;
    private final IMatchTeam roundWinner;

    public MatchTeamRoundEndEvent(IMatch match, int round, IMatchTeam roundWinner) {
        this.match = match;
        this.round = round;
        this.roundWinner = roundWinner;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
