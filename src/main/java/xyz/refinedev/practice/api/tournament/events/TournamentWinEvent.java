package xyz.refinedev.practice.api.tournament.events;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.tournament.ITournament;

/**
 * Called when a tournament winner is determined.
 */
@Getter
public class TournamentWinEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final ITournament tournament;
    private final Player winner;

    public TournamentWinEvent(ITournament tournament, Player winner) {
        this.tournament = tournament;
        this.winner = winner;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
