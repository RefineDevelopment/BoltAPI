package xyz.refinedev.practice.api.match.meta;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
public interface IMatchTeam {

    /**
     * If the match is a bed fight match, this will return
     * the both locations of the bed block of this player's team.
     * If this match is not a bed fight match, this will return null.
     * This can also return null if the map was not setup properly.
     *
     * @return {@link List} of {@link Location} or null
     */
    @Nullable List<Location> getBedLocation();

    /**
     * Does this team still have their bed?
     *
     * @return true if the team has their bed
     */
    boolean hasBed();

    /**
     * The points scored by this team in the match.
     *
     * @return int of points
     */
    int getPoints();

    /**
     * All team players in this team
     *
     * @return {@link List players}
     */
    List<Player> getPlayers();

    /**
     * List of all match players in this match team.
     *
     * @return List of {@link IMatchPlayer}
     */
    List<IMatchPlayer> getMatchPlayers();

    /**
     * Total count of this team
     *
     * @return The count of team players that are in this team
     */
    int getCount();

    /**
     * Use this method rather than calling {@link List#size()} on the result of {@code getAliveMatchPlayers}.
     *
     * @return The count of team players that are alive.
     */
    int getAliveCount();

    /**
     * Broadcast a message to all players
     *
     * @param message {@link String message}
     */
    void broadcastMessage(String message);

    /**
     * Broadcast a sound to all players
     *
     * @param sound {@link Sound message}
     * @param volume The volume of the sound
     * @param pitch The pitch of the sound
     */
    void broadcastSound(Sound sound, float volume, float pitch);

    /**
     * Does this team contain this player
     *
     * @param player {@link Player player}
     * @return       {@link Boolean contains}
     */
    boolean containsPlayer(Player player);

    /**
     * The display name of this team.
     * If team is based on a party then this will be the party name. (Leader name)
     * Otherwise it will be the player names joined by commas.
     *
     * @return {@link String display-name}
     */
    String getName();

}
