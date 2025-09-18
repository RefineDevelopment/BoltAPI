package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.MatchAPI;
import xyz.refinedev.practice.api.utils.BaseEvent;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * This event will always fire after a match has ended, regardless of the reason.
 * See {@link MatchAPI#terminateMatch(IMatch)} for more information.
 *
 * @author Drizzy
 * @version Bolt
 * @since 10/2/2022
 */

@Getter
@RequiredArgsConstructor
public class MatchTerminateEvent extends BaseEvent {

    private final IMatch match;
}
