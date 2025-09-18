package xyz.refinedev.practice.api.queue;

import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.profile.IProfile;
import xyz.refinedev.practice.api.utils.ServiceUtil;

import java.util.List;
import java.util.UUID;

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

public interface QueueAPI {

    QueueAPI BRIDGE = ServiceUtil.findFirst(QueueAPI.class).orElse(null);

    static QueueAPI instance() {
        if (BRIDGE == null) {
            throw new IllegalStateException("No implementation found");
        }
        return BRIDGE;
    }

    /**
     * Get a {@link IQueue} by its associated {@link UUID}.
     * If none is found, it returns null. The queue ID can be
     * found in the {@link IKit} class.
     *
     * @param queueId The UUID of the queue to retrieve.
     * @return        {@link IQueue} or null if none is found.
     */
    @Nullable IQueue getQueue(@NotNull UUID queueId);

    /**
     * Get a list of all solo queues. This includes both ranked and unranked.
     * The list returned by this method is immutable.
     *
     * @return List of all solo queues.
     */
    List<IQueue> getSoloQueues();

    /**
     * Get a list of all duo queues. This includes both ranked and unranked.
     * The list returned by this method is immutable.
     *
     * @return List of all duo queues.
     */
    List<IQueue> getDuoQueues();

    /**
     * Get a count of all participants currently queued across all queues.
     *
     * @return Total number of participants queued.
     */
    int getQueuedCount();

    /**
     * Get a count of all participants currently queued in a specific type of queue.
     *
     * @param queueType The type of queue to get the count for.
     * @return Total number of participants queued in the specified queue type.
     */
    int getQueuedCount(@NotNull QueueType queueType);

    /**
     * Force a player into a specific queue. There are certain checks that must
     * be passed for a player to be successfully queued, otherwise this method
     * will return false. Here are the checks:
     *
     * <ul>
     *     <li>The player must not already be in a queue.</li>
     *     <li>The kit must be enabled.</li>
     *     <li>If the queue type is ranked, the kit must support ranked queues.</li>
     *     <li>If the queue type is unranked, the kit must support unranked queues.</li>
     *     <li>The player must be in lobby state, see {@link IProfile#isInLobby()}.</li>
     *     <li>The player should pass network core checks like freeze, vanish, staff mode, comp ban.</li>
     *     <li>If the player is in a party, they must be the leader and the party should only have one other member.</li>
     * </ul>
     *
     * @param target The player to be queued.
     * @param kit    The kit associated with the queue.
     * @param type   The type of queue (e.g., ranked, unranked).
     * @return True if the player was successfully queued, false otherwise.
     */
    boolean joinQueue(@NotNull Player target, @NotNull IKit kit, @NotNull QueueType type);

    /**
     * Force a player to leave their current queue, if they are in one.
     * If the player is not in a queue, this method will return false.
     *
     * @param target The player to be removed from their queue.
     * @return True if the player was successfully removed from their queue, false otherwise.
     */
    boolean leaveQueue(@NotNull Player target);
}
