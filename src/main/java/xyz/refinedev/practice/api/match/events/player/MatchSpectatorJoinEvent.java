package xyz.refinedev.practice.api.match.events.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.utils.BaseEvent;

/**
 * <p>
 * This Project is property of Refine Development.<br>
 * Copyright © 2023, All Rights Reserved.<br>
 * Redistribution of this Project is not allowed.<br>
 * </p>
 *
 * @author Drizzy
 * @version Bolt
 * @since 3/3/2023
 */

@Getter
@RequiredArgsConstructor
public class MatchSpectatorJoinEvent extends BaseEvent {

    private final IMatch match;
    private final Player spectator;
}
