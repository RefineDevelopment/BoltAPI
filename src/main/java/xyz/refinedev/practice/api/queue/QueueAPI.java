package xyz.refinedev.practice.api.queue;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.practice.api.kit.IKit;
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
     * @return    {@link IQueue} or null if none is found.
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
}
