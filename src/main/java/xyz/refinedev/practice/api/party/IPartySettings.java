package xyz.refinedev.practice.api.party;

/**
 * Typed access to party settings.
 */
public interface IPartySettings {

    boolean isOpen();

    void setOpen(boolean open);

    boolean isMute();

    void setMute(boolean mute);

    boolean isAllInvite();

    void setAllInvite(boolean allInvite);

    boolean isDuelRequests();

    void setDuelRequests(boolean duelRequests);

    int getLimit();

    void setLimit(int limit);

    int getPingFactor();

    void setPingFactor(int pingFactor);
}
