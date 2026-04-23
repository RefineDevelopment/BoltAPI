package xyz.refinedev.practice.api.tournament;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.kit.IKit;

/**
 * Public access to Bolt tournaments.
 */
public interface TournamentAPI {

    @Nullable
    ITournament getCurrentTournament();

    boolean isInactive();

    boolean hasStarted();

    @Nullable
    default ITournament startTournament(CommandSender sender, IKit kit, TournamentType type) {
        return this.startTournament(sender, kit, type, 2);
    }

    @Nullable
    default ITournament startTournament(CommandSender sender, IKit kit, TournamentType type, int teamSize) {
        return null;
    }

    default boolean join(Player player) {
        return false;
    }

    default boolean leave(Player player) {
        return false;
    }

    default void cancelTournament() {
    }

    default void end(TournamentEndReason reason) {
    }

    default boolean forceStart() {
        return false;
    }
}
