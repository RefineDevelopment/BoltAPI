package xyz.refinedev.practice.api.duel;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.BoltAPI;
import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.party.IParty;

/**
 * Represents an active duel invite tracked by Bolt.
 */
public interface IDuelRequest {

    DuelRequestType getType();

    IKit getKit();

    boolean isActive();

    default boolean accept() {
        return BoltAPI.INSTANCE.getDuelAPI().accept(this);
    }

    default boolean cancel() {
        return BoltAPI.INSTANCE.getDuelAPI().cancel(this);
    }

    @Nullable
    default Player getSenderPlayer() {
        return null;
    }

    @Nullable
    default Player getTargetPlayer() {
        return null;
    }

    @Nullable
    default IParty getSenderParty() {
        return null;
    }

    @Nullable
    default IParty getTargetParty() {
        return null;
    }

    default boolean isPlayerRequest() {
        return this.getType() == DuelRequestType.PLAYER;
    }

    default boolean isPartyRequest() {
        return this.getType() == DuelRequestType.PARTY;
    }
}
