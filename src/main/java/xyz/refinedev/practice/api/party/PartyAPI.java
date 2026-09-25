package xyz.refinedev.practice.api.party;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.match.IMatch;

import java.util.Collection;
import java.util.UUID;

/**
 * Public access to Bolt's party system.
 */
public interface PartyAPI {

    /**
     * Looks a party up by its own uniqueId. This is <b>not</b> a player lookup —
     * for "which party is this player in" use {@link #getPartyByMember(UUID)}.
     *
     * @param uuid the <b>party</b> uniqueId
     */
    @Nullable
    IParty getParty(UUID uuid);

    @Nullable
    IParty getParty(Player player);

    /**
     * Finds the party the given player is currently a member of.
     * Works for offline members too, unlike {@link #getParty(Player)}.
     *
     * @param memberId the <b>player</b> uniqueId
     * @return the party containing this player, or {@code null}
     */
    @Nullable
    default IParty getPartyByMember(UUID memberId) {
        return null;
    }

    /**
     * Installs a feedback hook that owns party chat messaging (invite/join/leave/kick/promote/
     * disband/create). Bolt asks the hook first and stays silent for events the hook handles.
     * Pass {@code null} to clear. Default is a no-op so consumers without Bolt's implementation
     * are unaffected. Additive since 1.0.8.
     */
    default void setFeedbackHook(PartyFeedbackHook hook) {
    }

    @Nullable
    default PartyFeedbackHook getFeedbackHook() {
        return null;
    }

    Collection<IParty> getParties();

    int getPartyCount();

    @Nullable
    default IParty createParty(Player leader) {
        return null;
    }

    default boolean invite(Player sender, Player target) {
        return false;
    }

    /**
     * Silent variants suppress Bolt's own chat feedback so the calling plugin can send its own
     * messages. These default to the normal (non-silent) behaviour; the Bolt implementation overrides
     * them to actually run silently. Adding them as defaults keeps existing API consumers
     * binary-compatible — old clients keep calling the normal methods and still hear Bolt's messages.
     */
    default boolean inviteSilent(Player sender, Player target) {
        return invite(sender, target);
    }

    default boolean joinSilent(Player player, IParty party) {
        return join(player, party);
    }

    default boolean leaveSilent(Player player) {
        return leave(player);
    }

    default boolean kickSilent(Player sender, Player target) {
        return kick(sender, target);
    }

    default boolean promoteSilent(Player sender, Player target) {
        return promote(sender, target);
    }

    default boolean disbandSilent(Player leader) {
        return disband(leader);
    }

    @Nullable
    default IParty createPartySilent(Player leader) {
        return createParty(leader);
    }

    /**
     * Reason-returning, always-silent variants. They never send chat feedback; the caller owns
     * all player-facing messaging. Defaults delegate to the silent boolean methods and can only
     * distinguish success from {@link PartyOpResult#UNKNOWN_FAILURE}; the Bolt implementation
     * overrides them with precise reasons. Additive since 1.0.7 — existing consumers are
     * unaffected.
     */
    default PartyOpResult tryInvite(Player sender, Player target) {
        return inviteSilent(sender, target) ? PartyOpResult.SUCCESS : PartyOpResult.UNKNOWN_FAILURE;
    }

    default PartyOpResult tryJoin(Player player, IParty party) {
        return joinSilent(player, party) ? PartyOpResult.SUCCESS : PartyOpResult.UNKNOWN_FAILURE;
    }

    default PartyOpResult tryLeave(Player player) {
        return leaveSilent(player) ? PartyOpResult.SUCCESS : PartyOpResult.UNKNOWN_FAILURE;
    }

    default PartyOpResult tryKick(Player sender, Player target) {
        return kickSilent(sender, target) ? PartyOpResult.SUCCESS : PartyOpResult.UNKNOWN_FAILURE;
    }

    default PartyOpResult tryPromote(Player sender, Player target) {
        return promoteSilent(sender, target) ? PartyOpResult.SUCCESS : PartyOpResult.UNKNOWN_FAILURE;
    }

    default PartyOpResult tryDisband(Player leader) {
        return disbandSilent(leader) ? PartyOpResult.SUCCESS : PartyOpResult.UNKNOWN_FAILURE;
    }

    /**
     * Controls whether party mutations executed by the current thread may emit Bolt's own
     * player-facing feedback. Integrations must restore {@code false} in a {@code finally}
     * block after the operation. The flag is thread-local, so it never mutes other players'
     * concurrent party actions.
     */
    default void setSilent(boolean silent) {
    }

    default boolean isSilent() {
        return false;
    }

    default boolean isInvited(IParty party, Player target) {
        return party != null && target != null && party.isInvited(target.getUniqueId());
    }

    default boolean revokeInvite(IParty party, Player target) {
        return false;
    }

    default int clearInvites(Player target) {
        return 0;
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

    @Nullable
    default IMatch startFFA(IParty party, IKit kit) {
        return null;
    }

    @Nullable
    default IMatch startSplit(IParty party, IKit kit) {
        return null;
    }

    @Nullable
    default IMatch startMatch(IParty partyA, IParty partyB, IKit kit, boolean ranked) {
        return null;
    }

    default boolean spectatePartyMatch(Player spectator, IParty party) {
        return false;
    }

    default boolean setOpen(IParty party, boolean open) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null) {
            return false;
        }

        settings.setOpen(open);
        return settings.isOpen() == open;
    }

    default boolean setAllInvite(IParty party, boolean allInvite) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null) {
            return false;
        }

        settings.setAllInvite(allInvite);
        return settings.isAllInvite() == allInvite;
    }

    default boolean setMute(IParty party, boolean mute) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null) {
            return false;
        }

        settings.setMute(mute);
        return settings.isMute() == mute;
    }

    default boolean setDuelRequests(IParty party, boolean duelRequests) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null) {
            return false;
        }

        settings.setDuelRequests(duelRequests);
        return settings.isDuelRequests() == duelRequests;
    }

    default boolean setLimit(IParty party, int limit) {
        IPartySettings settings = party == null ? null : party.getSettings();
        if (settings == null || limit < 2 || limit < party.getMembers().size()) {
            return false;
        }

        settings.setLimit(limit);
        return settings.getLimit() == limit;
    }
}
