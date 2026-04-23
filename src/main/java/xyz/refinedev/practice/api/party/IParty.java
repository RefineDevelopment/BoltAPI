package xyz.refinedev.practice.api.party;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.queue.IQueue;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Represents an active Bolt party.
 */
public interface IParty {

    UUID getUniqueId();

    UUID getLeader();

    String getLeaderName();

    Set<UUID> getMembers();

    List<Player> getPlayers();

    boolean isInMatch();

    boolean isInQueue();

    boolean isInLobby();

    boolean isInTournament();

    void broadcastMessage(String message);

    default void broadcastSound(Sound sound) {
    }

    default String getName() {
        return this.getLeaderName() + "'s Party";
    }

    default PartyState getState() {
        return PartyState.LOBBY;
    }

    default boolean isBusy() {
        return this.isInMatch() || this.isInQueue() || this.isInTournament();
    }

    default boolean isDisbanded() {
        return false;
    }

    default List<UUID> getInvites() {
        return Collections.emptyList();
    }

    default boolean isInvited(UUID uuid) {
        return this.getInvites().contains(uuid);
    }

    default boolean isMember(UUID uuid) {
        return this.getMembers().contains(uuid);
    }

    default boolean isLeader(UUID uuid) {
        return this.getLeader().equals(uuid);
    }

    @Nullable
    default IQueue getQueue() {
        return null;
    }

    @Nullable
    default IMatch getMatch() {
        return null;
    }

    default void reloadHotbar() {
    }

    default void reloadNameTag() {
    }

    @Nullable
    Object getPartySettings();

    @Nullable
    default IPartySettings getSettings() {
        Object settings = this.getPartySettings();
        return settings instanceof IPartySettings ? (IPartySettings) settings : null;
    }
}
