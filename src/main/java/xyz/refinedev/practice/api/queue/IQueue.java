package xyz.refinedev.practice.api.queue;

import java.util.UUID;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 10/3/2022
 */

public interface IQueue {

    /**
     * Returns the Queue's ID
     *
     * @return Queue ID in {@link UUID}
     */
    UUID getUniqueId();

    /**
     * Returns the Queue's Formatted Name
     *
     * @return Formatted Name in {@link String}
     */
    String getName();

    /**
     * @return The {@link QueueType} of this queue.
     */
    QueueType getType();

    /**
     * Get amount of players in this queue
     *
     * @return amount of players in the queue
     */
    int getInQueue();

    /**
     * Get amount of players in fight from this queue
     *
     * @return amount of players in fight with the queue
     */
    int getInFights();

    /**
     * Check if a player or party is in this queue
     *
     * @param uuid of the participant
     * @return true if the participant is in the queue
     */
    boolean isInQueue(UUID uuid);

    /**
     * Remove all participants from this queue safely.
     * This will also handle removing parties and sending messages.
     */
    void removeAll();
}
