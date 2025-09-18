package xyz.refinedev.practice.api.profile.events;

import lombok.Getter;
import lombok.Setter;
import xyz.refinedev.practice.api.utils.BaseEvent;

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
 * @since 12/18/2023
 */

@Getter @Setter
public class ProfileLoginEvent extends BaseEvent {

    private final String name;
    private final UUID uuid;
    private String kickMessage;

    public ProfileLoginEvent(String name, UUID uuid) {
        super(true);
        this.name = name;
        this.uuid = uuid;
    }

}
