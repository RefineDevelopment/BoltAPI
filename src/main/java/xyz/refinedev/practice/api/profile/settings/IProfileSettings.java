package xyz.refinedev.practice.api.profile.settings;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 5/31/2022
 */
public interface IProfileSettings {

    boolean isShowPlayers();
    void setShowPlayers(boolean value);

    boolean isVanillaTab();
    void setVanillaTab(boolean value);

    boolean isDuelRequests();
    void setDuelRequests(boolean value);

    boolean isDuelSounds();
    void setDuelSounds(boolean value);

    boolean isPlayAgain();
    void setPlayAgain(boolean value);

    boolean isPartyRequests();
    void setPartyRequests(boolean value);

    boolean isTournamentMessages();
    void setTournamentMessages(boolean value);

    boolean isSpectatorMessages();
    void setSpectatorMessages(boolean value);

    boolean isAllowSpectators();
    void setAllowSpectators(boolean value);

    boolean isSidebarEnabled();
    void setSidebarEnabled(boolean value);

    boolean isPlayAgainRematch();
    void setPlayAgainRematch(boolean value);

    int getPingFactor();
    void setPingFactor(int value);

    boolean isFlyMode();
    void setFlyMode(boolean value);

    boolean isDeathAnimation();
    void setDeathAnimation(boolean value);

    boolean isDropItems();
    void setDropItems(boolean value);

    boolean isClearInventory();
    void setClearInventory(boolean value);

    boolean isSilent();
    void setSilent(boolean value);

    boolean isAutoSilent();
    void setAutoSilent(boolean value);

    boolean isFollowing();

    boolean isEditMode();
    void setEditMode(boolean value);

    boolean isShowSpectator();
    void setShowSpectator(boolean value);

    boolean isPartyChat();
    void setPartyChat(boolean value);

    boolean isKitEditor();
    void setKitEditor(boolean value);

    boolean isParkour();
}
