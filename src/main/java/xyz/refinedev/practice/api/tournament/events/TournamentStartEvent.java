package xyz.refinedev.practice.api.tournament.events;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.tournament.ITournament;

/**
 * Called when a tournament is created and announced.
 */
@Getter
public class TournamentStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final ITournament tournament;

    public TournamentStartEvent(ITournament tournament) {
        this.tournament = tournament;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
