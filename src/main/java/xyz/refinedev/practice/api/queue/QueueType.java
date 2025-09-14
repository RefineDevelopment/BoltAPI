package xyz.refinedev.practice.api.queue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 5/1/2022
 */

@Getter
@RequiredArgsConstructor
public enum QueueType {

    PROFILE_UNRANKED("Solo Unranked", false),
    PROFILE_RANKED("Solo Ranked", true),
    DUO_UNRANKED("Duo Unranked", false),
    DUO_RANKED("Duo Ranked", true);

    private final String displayName;
    private final boolean ranked;
}
