package xyz.refinedev.practice.api.party;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

/**
 * Public access to Bolt's party system.
 */
public interface PartyAPI {

    @Nullable
    IParty getParty(UUID uuid);

    @Nullable
    IParty getParty(Player player);

    Collection<IParty> getParties();

    int getPartyCount();

    @Nullable
    default IParty createParty(Player leader) {
        return null;
    }

    default boolean invite(Player sender, Player target) {
        return false;
    }

    default boolean join(Player player, IParty party) {
        return false;
    }

    default boolean leave(Player player) {
        return false;
    }

    default boolean kick(Player sender, Player target) {
        return false;
    }

    default boolean promote(Player sender, Player target) {
        return false;
    }

    default boolean disband(Player leader) {
        return false;
    }

    default boolean canQueue(IParty party, boolean ranked) {
        return false;
    }
}
