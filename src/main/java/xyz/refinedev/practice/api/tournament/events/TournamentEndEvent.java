package xyz.refinedev.practice.api.tournament.events;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.tournament.ITournament;
import xyz.refinedev.practice.api.tournament.TournamentEndReason;

/**
 * Called when a tournament ends for any reason.
 */
@Getter
public class TournamentEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final ITournament tournament;
    private final TournamentEndReason reason;

    public TournamentEndEvent(ITournament tournament, TournamentEndReason reason) {
        this.tournament = tournament;
        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
