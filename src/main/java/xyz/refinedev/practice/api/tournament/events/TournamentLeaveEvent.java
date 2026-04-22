package xyz.refinedev.practice.api.tournament.events;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.tournament.ITournament;

/**
 * Called when a player leaves a tournament.
 */
@Getter
public class TournamentLeaveEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final ITournament tournament;
    private final Player player;

    public TournamentLeaveEvent(ITournament tournament, Player player) {
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
