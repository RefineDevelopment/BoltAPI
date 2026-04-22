package xyz.refinedev.practice.api.tournament.events;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.tournament.ITournament;

/**
 * Called when a player joins a tournament.
 */
@Getter
public class TournamentJoinEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final ITournament tournament;
    private final Player player;

    public TournamentJoinEvent(ITournament tournament, Player player) {
        this.tournament = tournament;
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
