package xyz.refinedev.practice.api.kit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.refinedev.practice.api.queue.IQueue;
import xyz.refinedev.practice.api.utils.ServiceUtil;

import java.util.List;
import java.util.Map;
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
public interface KitAPI {

    KitAPI BRIDGE = ServiceUtil.findFirst(KitAPI.class).orElse(null);

    static KitAPI instance() {
        if (BRIDGE == null) {
            throw new IllegalStateException("No implementation found");
        }
        return BRIDGE;
    }

    /**
     * Create a new Kit Builder instance
     *
     * @return {@link IKitBuilder} instance
     */
    IKitBuilder builder();

    /**
     * Save all kits to the storage asynchronously.
     */
    void save();

    /**
     * Register a kit to the storage. This will also handle
     * creation of the {@link IQueue}s for all valid types.
     *
     * @param kit  {@link IKit} to register
     * @param save Should the kit also be saved?
     */
    void registerKit(@NotNull IKit kit, boolean save);

    /**
     * Unregister a kit from the storage. This will also handle
     * removal of all {@link IQueue}s associated with the kit.
     *
     * @param kit {@link IKit}
     */
    void unregisterKit(@NotNull IKit kit);

    /**
     * Get a kit by name
     *
     * @param name of the kit
     * @return {@link IKit} if found, null otherwise
     */
    @Nullable IKit getKit(@NotNull String name);

    /**
     * Get all registered kits
     *
     * @return {@link List} of {@link IKit}
     */
    List<IKit> getKits();

    /**
     * Check if a player has any custom inventories for a specific kit.
     *
     * @param player to check
     * @param kit    to check
     * @return true if the player has custom inventories, false otherwise
     */
    boolean hasCustomInventories(@NotNull Player player, @NotNull IKit kit);

    /**
     * Get all custom inventories a player has for a specific kit.
     * Returns null if the player has no custom inventories for the kit.
     *
     * @param player to get for
     * @param kit    to get for
     * @return       {@link IKitInventory} array if the player has custom inventories, empty array
     *                                    if none exist, null if the player has no custom inventories for the kit
     */
    @Nullable IKitInventory[] getKitInventories(@NotNull Player player, @NotNull IKit kit);

    /**
     * Wipe all custom inventories a player has for a specific kit.
     * This will remove all custom inventories from memory and storage.
     *
     * @param player to wipe for
     * @param kit    to wipe for
     */
    void wipeCustomInventories(@NotNull Player player, @NotNull IKit kit);

    /**
     * Wipe all custom inventories for all players for a specific kit.
     * This will remove all custom inventories from memory and storage.
     *
     * @param kit to wipe for
     * @return    {@link CompletableFuture} with the number of wiped inventories
     */
    CompletableFuture<Long> wipeKitsForKit(@NotNull IKit kit);

    /**
     * Get the selection items for a player for a specific kit.
     * This will return the items that will be given to the player.
     * If not custom inventories exist, it will return the default item on the 0 index.
     * Otherwise, the default item will appear on 8th index.
     *
     * @param player to get for
     * @param kit    to get for
     * @return       {@link Map} of slot to {@link ItemStack}
     */
    Map<Integer, ItemStack> getSelectionItems(@NotNull Player player, @NotNull IKit kit);
}
