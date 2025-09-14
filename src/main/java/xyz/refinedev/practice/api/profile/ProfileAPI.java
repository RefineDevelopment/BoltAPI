package xyz.refinedev.practice.api.profile;

import org.bukkit.entity.Player;
import xyz.refinedev.practice.api.util.ServiceUtil;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/14/2025
 */
public interface ProfileAPI {

    ProfileAPI BRIDGE = ServiceUtil.findFirst(ProfileAPI.class).orElse(null);

    static ProfileAPI instance() {
        if (BRIDGE == null) {
            throw new IllegalStateException("No implementation found");
        }
        return BRIDGE;
    }

    /**
     * Get the profile of a player
     *
     * @param player {@link Player} to get the profile of
     * @return {@link IProfile} of the player
     */
    IProfile getProfile(Player player);

    /**
     * Get the profile of a player
     *
     * @param uniqueId {@link UUID} to get the profile of
     * @return {@link IProfile} of the player
     */
    IProfile getProfile(UUID uniqueId);

    /**
     * Fetch the profile of a player by their UUID.
     * If the player is online, this will return the same instance as {@link #getProfile(Player)}.
     * Otherwise, it will fetch the data from the database asynchronously.
     *
     * @param uniqueId {@link UUID} to get the profile of
     * @return {@link CompletableFuture<IProfile>} of the player
     */
    CompletableFuture<IProfile> fetchProfile(UUID uniqueId);

    /**
     * Save the profile of a player.
     *
     * @param profile {@link IProfile} to save
     * @param async   whether to save the profile asynchronously or not
     */
    void saveProfile(IProfile profile, boolean async);

    /**
     * Refresh the hotbar of a player based on their profile state.
     *
     * @param profile {@link IProfile} of the player to refresh the hotbar for
     */
    void refreshHotbar(IProfile profile);

    /**
     * Refresh the visibility of others for you based on their profile state.
     *
     * @param profile {@link IProfile} of the player to refresh the visibility for
     */
    void refreshVisibility(IProfile profile);

    /**
     * Refresh your visibility for others based on your profile state.
     *
     * @param profile {@link IProfile} of the player to refresh the visibility for
     */
    void refreshVisibilityOthers(IProfile profile);

}
