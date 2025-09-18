package xyz.refinedev.practice.api.match.events.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.MatchAPI;
import xyz.refinedev.practice.api.match.enums.MatchEndReason;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;
import xyz.refinedev.practice.api.utils.BaseEvent;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * This is called when a match ends normally and successfully.
 * For more information, see {@link MatchAPI#end(IMatchPlayer, MatchEndReason)}
 *
 * @author Drizzy
 * @version Bolt
 * @since 10/2/2022
 */

@Getter
@RequiredArgsConstructor
public class MatchEndEvent extends BaseEvent {

    private final IMatch match;
}
