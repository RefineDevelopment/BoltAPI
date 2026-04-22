package xyz.refinedev.practice.api.tournament.events;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.tournament.ITournament;

/**
 * Called when a player or party is eliminated from a tournament
 * (lost their match and are removed from the bracket).
 */
@Getter
public class TournamentEliminateEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final ITournament tournament;
    private final Player eliminated;

    public TournamentEliminateEvent(ITournament tournament, Player eliminated) {
        this.tournament = tournament;
        this.eliminated = eliminated;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
