package xyz.refinedev.practice.api.profile.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.bukkit.entity.Player;

import xyz.refinedev.practice.api.profile.IProfile;
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
 * @since 10/25/2023
 */

@Getter
@RequiredArgsConstructor
public class ProfileLeaveEvent extends BaseEvent {

    private final Player player;
    private final IProfile profile;

}
