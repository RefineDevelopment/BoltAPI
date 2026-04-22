package xyz.refinedev.practice.api.party.events;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import xyz.refinedev.practice.api.party.IParty;

/**
 * Called when a party is disbanded.
 */
@Getter
public class PartyDisbandEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IParty party;

    public PartyDisbandEvent(IParty party) {
        this.party = party;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
