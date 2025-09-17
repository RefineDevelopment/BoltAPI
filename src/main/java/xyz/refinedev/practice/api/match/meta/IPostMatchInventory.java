package xyz.refinedev.practice.api.match.meta;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * <p>
 * This code is the property of Refine Development.<br>
 * Copyright © 2025, All Rights Reserved.<br>
 * </p>
 *
 * <p>
 * Making changes here can reflect in the post match inventory shown to players. <br>
 * However, it will not change anything in the actual match.
 * </p>
 *
 * @author Drizzy
 * @version BoltAPI
 * @since 9/14/2025
 **/
public interface IPostMatchInventory {

    /**
     * The match player this inventory belongs to.
     *
     * @return {@link IMatchPlayer}
     */
    IMatchPlayer getMatchPlayer();

    /**
     * If the match was a solo match, this will return the opponent of this player.
     *
     * @return {@link IMatchPlayer} or null if not a solo match
     */
    @Nullable IMatchPlayer getSwitchTo();

    /**
     * Sets the match player instance of the next inventory to switch to.
     *
     * @param switchTo {@link IMatchPlayer} or null if not a solo match
     */
    void setSwitchTo(@Nullable IMatchPlayer switchTo);

    /**
     * The amount of hearts this player had at the end of the match.
     *
     * @return int of hearts (1 heart = 2 health)
     */
    int getHearts();
    /**
     * Sets the amount of hearts this player had at the end of the match.
     *
     * @param hearts int of hearts (1 heart = 2 health)
     */
    void setHearts(int hearts);

    /**
     * The amount of health this player had at the end of the match.
     *
     * @return double of health
     */
    double getHealth();

    /**
     * Sets the amount of health this player had at the end of the match.
     *
     * @param health double of health
     */
    void setHealth(double health);

    /**
     * The hunger level this player had at the end of the match.
     *
     * @return int of hunger
     */
    int getHunger();
    /**
     * Sets the hunger level this player had at the end of the match.
     *
     * @param hunger int of hunger
     */
    void setHunger(int hunger);

    /**
     * The total hits this player landed during the match.
     *
     * @return int of total hits
     */
    int getTotalHits();
    /**
     * Sets the total hits this player landed during the match.
     *
     * @param totalHits int of total hits
     */
    void setTotalHits(int totalHits);

    /**
     * The total blocked hits this player had during the match.
     *
     * @return int of blocked hits
     */
    int getBlockedHits();
    /**
     * Sets the total blocked hits this player had during the match.
     *
     * @param blockedHits int of blocked hits
     */
    void setBlockedHits(int blockedHits);

    /**
     * The total critical hits this player landed during the match.
     *
     * @return int of critical hits
     */
    int getCriticalHits();
    /**
     * Sets the total critical hits this player landed during the match.
     *
     * @param criticalHits int of critical hits
     */
    void setCriticalHits(int criticalHits);

    /**
     * The total missed pots this player had during the match.
     *
     * @return int of missed pots
     */
    int getMissedPots();
    /**
     * Sets the total missed pots this player had during the match.
     *
     * @param missedPots int of missed pots
     */
    void setMissedPots(int missedPots);

    /**
     * The total pots thrown this player had during the match.
     *
     * @return int of pots thrown
     */
    int getPotsThrown();
    /**
     * Sets the total pots thrown this player had during the match.
     *
     * @param potsThrown int of pots thrown
     */
    void setPotsThrown(int potsThrown);

    /**
     * The ping this player had during the match.
     *
     * @return int of ping
     */
    int getPing();

    /**
     * The longest combo this player had during the match.
     *
     * @return int of longest combo
     */
    int getLongestCombo();
    /**
     * Sets the longest combo this player had during the match.
     *
     * @param longestCombo int of longest combo
     */
    void setLongestCombo(int longestCombo);

    /**
     * The current combo this player had during the match.
     *
     * @return int of current combo
     */
    int getCombo();
    /**
     * Sets the current combo this player had during the match.
     *
     * @param combo int of current combo
     */
    void setCombo(int combo);

    /**
     * The total kills this player had during the match.
     *
     * @return int of kills
     */
    int getKills();

    /**
     * Sets the total kills this player had during the match.
     *
     * @param kills int of kills
     */
    void setKills(int kills);

    /**
     * The total deaths this player had during the match.
     *
     * @return int of deaths
     */
    int getDeaths();

    /**
     * Sets the total deaths this player had during the match.
     *
     * @param deaths int of deaths
     */
    void setDeaths(int deaths);

    /**
     * The points this player had during the match.
     *
     * @return int of points
     */
    int getPoints();

    /**
     * Sets the points this player had during the match.
     *
     * @param points int of points
     */
    void setPoints(int points);

    /**
     * The lives this player had during the match.
     *
     * @return int of lives
     */
    int getLives();

    /**
     * Sets the lives this player had during the match.
     *
     * @param lives int of lives
     */
    void setLives(int lives);

    /**
     * The armor contents this player had at the end of the match.
     *
     * @return {@link ItemStack[]} of armor
     */
    ItemStack[] getArmor();

    /**
     * Sets the armor contents this player had at the end of the match.
     *
     * @param armor {@link ItemStack[]} of armor
     */
    void setArmor(ItemStack[] armor);

    /**
     * The inventory contents this player had at the end of the match.
     *
     * @return {@link ItemStack[]} of contents
     */
    ItemStack[] getContents();

    /**
     * Sets the inventory contents this player had at the end of the match.
     *
     * @param contents {@link ItemStack[]} of contents
     */
    void setContents(ItemStack[] contents);

    /**
     * The potion effects this player had at the end of the match.
     *
     * @return {@link Collection<PotionEffect>} of effects
     */
    Collection<PotionEffect> getEffects();

    /**
     * Sets the potion effects this player had at the end of the match.
     *
     * @param effects {@link Collection<PotionEffect>} of effects
     */
    void setEffects(Collection<PotionEffect> effects);
}
