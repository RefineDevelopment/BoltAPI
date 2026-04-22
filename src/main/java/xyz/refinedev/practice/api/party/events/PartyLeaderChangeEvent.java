package xyz.refinedev.practice.api.party.events;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import xyz.refinedev.practice.api.party.IParty;

import java.util.UUID;

/**
 * Called when the leader of a party is changed.
 */
@Getter
public class PartyLeaderChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final IParty party;
    private final UUID oldLeader;
    private final Player newLeader;

    public PartyLeaderChangeEvent(IParty party, UUID oldLeader, Player newLeader) {
        this.party = party;
        this.oldLeader = oldLeader;
        this.newLeader = newLeader;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
