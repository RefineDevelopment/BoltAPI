package xyz.refinedev.practice.api.duel;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.party.IParty;

/**
 * A duel invite sent from one party to another.
 */
public interface IPartyDuelRequest extends IDuelRequest {

    IParty getSender();

    IParty getTarget();

    @Override
    default DuelRequestType getType() {
        return DuelRequestType.PARTY;
    }

    @Override
    default IParty getSenderParty() {
        return this.getSender();
    }

    @Override
    default IParty getTargetParty() {
        return this.getTarget();
    }

    @Override
    @Nullable
    default Player getSenderPlayer() {
        return Bukkit.getPlayer(this.getSender().getLeader());
    }

    @Override
    @Nullable
    default Player getTargetPlayer() {
        return Bukkit.getPlayer(this.getTarget().getLeader());
    }
}
