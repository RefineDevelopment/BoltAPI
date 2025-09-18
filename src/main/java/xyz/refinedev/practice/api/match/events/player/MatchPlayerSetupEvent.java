package xyz.refinedev.practice.api.match.events.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.meta.IMatchPlayer;
import xyz.refinedev.practice.api.utils.BaseEvent;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * This event is fired before a player is set up in a match.
 *
 * @author Drizzy
 * @version Bolt
 * @since 9/3/2022
 */

@Getter
@RequiredArgsConstructor
public class MatchPlayerSetupEvent extends BaseEvent {

    private final IMatch match;
    private final IMatchPlayer player;
}
