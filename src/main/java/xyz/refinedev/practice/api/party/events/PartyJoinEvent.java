package xyz.refinedev.practice.api.party.events;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.party.IParty;

/**
 * Called when a player joins a party.
 */
@Getter
public class PartyJoinEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IParty party;
    private final Player player;

    public PartyJoinEvent(IParty party, Player player) {
        this.party = party;
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
