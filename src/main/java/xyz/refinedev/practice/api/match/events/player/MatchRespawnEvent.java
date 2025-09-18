package xyz.refinedev.practice.api.match.events.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.utils.BaseEvent;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2024, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * This event is fired when a player successfully respawns in a match.
 *
 * @author Drizzy
 * @version Bolt
 * @since 9/16/2024
 */

@Getter
@RequiredArgsConstructor
public class MatchRespawnEvent extends BaseEvent {

    private final IMatch match;
    private final Player player;

}
