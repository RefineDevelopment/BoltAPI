package xyz.refinedev.practice.api.profile.parkour;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.time.Instant;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * @author Drizzy
 * @version BoltRecode
 * @since 9/14/2025
 */
public interface IProfileParkour {

    long getBestParkourTime();

    void setBestParkourTime(long time);

    Instant getCurrentParkourStartTime();

    void setCurrentParkourStartTime(Instant startTime);

    Location getLastCheckpoint();

    void setLastCheckpoint(Location checkpoint);

    Location getStartLocation();

    void setStartLocation(Location startLocation);

    void startSession(Player player);

    void endSession(Player player, long completionTime, ParkourEndReason reason);

}
