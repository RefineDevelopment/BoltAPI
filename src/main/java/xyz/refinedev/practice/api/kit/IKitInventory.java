package xyz.refinedev.practice.api.kit;

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

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.List;

/**
 * Represents a player's custom inventory for a specific kit.
 */
public interface IKitInventory {

    /**
     * Returns the custom name of this inventory, or the default kit name if not set.
     *
     * @return Custom name in {@link String}
     */
    String getCustomName();

    /**
     * Returns the contents of the player's inventory.
     *
     * @return Contents in {@link ItemStack}
     */
    ItemStack[] getContents();

    /**
     * Returns the slot index of this inventory.
     * Each kit can have 5 custom inventories, indexed from 0 to 4.
     *
     * @return Slot index in {@link Integer}
     */
    int getSlot();
}
