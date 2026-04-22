package xyz.refinedev.practice.api.tournament;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.party.IParty;

import java.util.Collections;
import java.util.List;

/**
 * Represents the currently active Bolt tournament.
 */
public interface ITournament {

    IKit getKit();

    TournamentState getState();

    TournamentType getType();

    String getHost();

    int getRound();

    int getSize();

    int getLimit();

    boolean isCancelled();

    boolean isParticipating(Player player);

    List<?> getSubjects();

    default List<? extends IMatch> getMatches() {
        return Collections.emptyList();
    }

    @Nullable
    default Player getWinningPlayer() {
        return null;
    }

    @Nullable
    default IParty getWinningParty() {
        return null;
    }

    @Nullable
    default Object getWinningSubject() {
        return null;
    }

    default List<Player> getPlayerParticipants() {
        return Collections.emptyList();
    }

    default List<IParty> getPartyParticipants() {
        return Collections.emptyList();
    }

    default void broadcastMessage(String msg, boolean onlyParticipants) {
    }

    default void broadcastSound(Sound sound) {
    }

    default boolean hasStarted() {
        return this.getState() != TournamentState.WAITING && this.getState() != TournamentState.STARTING;
    }
}
