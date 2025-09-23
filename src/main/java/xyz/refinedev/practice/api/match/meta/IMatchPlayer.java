package xyz.refinedev.practice.api.match.meta;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import xyz.refinedev.api.skin.data.CachedSkin;
import xyz.refinedev.practice.api.kit.IKitInventory;

import java.util.List;
import java.util.UUID;

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
public interface IMatchPlayer {

    /**
     * UUID-based identifier for the player.
     * This refers to the player's uuid
     *
     * @return UUID of the player
     */
    UUID getUniqueId();

    /**
     * This is usually equivalent to {@link Player#getName}
     * but this is cached and saved along with match data, so
     * it can be different if the player changed their name.
     *
     * @return The username of the player
     */
    String getUsername();

    /**
     * The skin data of this player
     * This skin is used for bots and spectators
     * to see the correct skin of the player
     *
     * @return CachedSkin of the player
     */
    CachedSkin getSkin();

    /**
     * The entities launched or thrown by this player.
     *
     * @return List of entities
     */
    List<Entity> getEntities();

    /**
     * If the match is a bed fight match, this will return
     * the both locations of the bed block of this player's team.
     * If this match is not a bed fight match, this will return null.
     * This can also return null if the map was not setup properly.
     *
     * @return {@link List} of {@link Location} or null
     */
    @Nullable List<Location> getBedLocations();

    /**
     * The spawn location of this player in the match.
     * This is usually the spawn point of their team.
     * Can be null if the player has not spawned yet.
     *
     * @return {@link Location} of the spawn point
     */
    @Nullable Location getSpawn();

    /**
     * Returns true if the player is alive in the match.
     * This can be false while the player is respawning.
     *
     * @return true if the player is alive
     */
    boolean isAlive();

    /**
     * Returns true if the player has disconnected from the match.
     * This can be either from leaving the server or executing /leave.
     *
     * @return true if the player has disconnected
     */
    boolean isDisconnected();

    /**
     * Returns true if the player has forfeited the match.
     * This is set to true when the player executes /leave.
     *
     * @return true if the player has forfeited
     */
    boolean isForfeited();

    /**
     * Has the player selected a player kit?
     * This will always return false if the player does not have any custom kits.
     *
     * @return true if the player has selected a kit
     */
    boolean isKitSelected();

    /**
     * Is this player a bot?
     * Can also be checked if the {@link Player} object has a "boltNPC" metadata.
     *
     * @return true if the player is a bot
     */
    boolean isBot();

    /**
     * Does the player still have their bed?
     *
     * @return true if the player has their bed
     */
    boolean isHasBed();

    /**
     * The coins earned by this player during the match.
     * This is calculated based on kills, wins, and other factors.
     *
     * @return int of coins earned
     */
    int getCoinsEarned();

    /**
     * Sets the coins earned by this player during the match.
     *
     * @param coinsEarned int of coins earned
     */
    void setCoinsEarned(int coinsEarned);

    /**
     * The kit selected by this player.
     * This can be null if the player has not selected a kit.
     * If the player does not have any custom kits, this will always be null.
     *
     * @return {@link IKitInventory} or null
     */
    @Nullable IKitInventory getSelectedKit();

    /**
     * Sets the kit selected by this player. When the player spawns
     * in the match, if this is not null then this kit will always be applied.
     * Coloring of the contents if automatically handled, if the kit is a color based kit.
     *
     * @param kitInventory {@link IKitInventory} or null
     */
    void setSelectedKit(@Nullable IKitInventory kitInventory);

    /**
     * Points scored by this player in the match.
     * This is usually used for goal based game modes.
     * Like portal kits or mlg rush.
     *
     * @return int of points scored
     */
    int getPoints();

    /**
     * Sets the points scored by this player in the match.
     *
     * @param points int of points scored
     */
    void setPoints(int points);

    /**
     * Lives remaining for this player in the match.
     * This is usually used for matches with limited lives
     * like Pearl Fight.
     *
     * @return int of lives remaining
     */
    int getLives();

    /**
     * Sets the lives remaining for this player in the match.
     *
     * @param lives int of lives remaining
     */
    void setLives(int lives);

    /**
     * The period of ticks after which player starts to take
     * damage due to being above the build height.
     *
     * @return int of damage grace period
     */
    int getDamageGrace();

    /**
     * Sets the period of ticks after which player starts to take
     * damage due to being above the build height.
     *
     * @param damageGrace int of damage grace period
     */
    void setDamageGrace(int damageGrace);

    /**
     * The ping of this player in milliseconds.
     * This can also return the bot's ping according to it's preset.
     *
     * @return int of ping in milliseconds
     */
    int getPing();
    /**
     * The current CPS of this player.
     *
     * @return int of CPS
     */
    int getCPS();

    /**
     * Get the bukkit craft player instance of this match player
     *
     * @return {@link Player player}
     */
    @Nullable Player getPlayer();

    /**
     * The display name of this player.
     * This is usually the same as {@link Player#getDisplayName()}
     * but this is cached and saved along with match data. It also
     * the disguised name if the player is disguised.
     *
     * @return The display name of the player
     */
    String getDisplayName();

    double getPotionAccuracy();
    int getPotionsThrown();
    int getPotionsMissed();
    int getHits();
    int getBlockedHits();
    int getCriticalHits();
    int getCombo();
    int getLongestCombo();
    int getKills();
    int getDeaths();
    long getLastBlocked();
}
