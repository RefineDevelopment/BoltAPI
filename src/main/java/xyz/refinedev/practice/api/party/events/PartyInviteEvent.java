package xyz.refinedev.practice.api.party.events;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.party.IParty;

/**
 * Called when a player is invited to a party.
 */
@Getter
public class PartyInviteEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IParty party;
    private final Player invited;

    public PartyInviteEvent(IParty party, Player invited) {
        this.party = party;
        this.invited = invited;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
