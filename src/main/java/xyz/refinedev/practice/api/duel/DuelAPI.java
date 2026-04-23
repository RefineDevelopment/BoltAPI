package xyz.refinedev.practice.api.duel;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.party.IParty;

import java.util.Collection;
import java.util.Collections;

/**
 * Public access to Bolt's duel request lifecycle.
 */
public interface DuelAPI {

    @Nullable
    IProfileDuelRequest request(Player sender, Player target, IKit kit);

    @Nullable
    IPartyDuelRequest request(IParty sender, IParty target, IKit kit);

    @Nullable
    IProfileDuelRequest getRequest(Player sender, Player target);

    @Nullable
    IPartyDuelRequest getRequest(IParty sender, IParty target);

    boolean accept(IDuelRequest request);

    boolean cancel(IDuelRequest request);

    default Collection<IDuelRequest> getActiveRequests() {
        return Collections.emptyList();
    }
}
