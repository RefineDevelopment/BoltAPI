package xyz.refinedev.practice.api.tournament.events;

import lombok.Getter;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.tournament.ITournament;

/**
 * Called when a new tournament round starts.
 */
@Getter
public class TournamentRoundStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final ITournament tournament;
    private final int round;

    public TournamentRoundStartEvent(ITournament tournament, int round) {
        this.tournament = tournament;
        this.round = round;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
