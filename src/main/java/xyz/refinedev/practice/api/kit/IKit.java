package xyz.refinedev.practice.api.kit;

import com.cryptomorin.xseries.XMaterial;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;
import java.util.List;
import java.util.Set;
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
public interface IKit {

    /**
     * The unique identifier for this kit.
     * This is used internally for storage and retrieval.
     *
     * @return The unique identifier for this kit
     */
    String getName();

    /**
     * The display name for this kit.
     * This is the name that is displayed in menus and messages.
     *
     * @return The display name for this kit
     */
    String getDisplayName();

    /**
     * Sets the display name for this kit.
     *
     * @param displayName The new display name for this kit
     */
    void setDisplayName(String displayName);

    /**
     * The knockback profile name which will be used
     * to access custom spigot forks' knockback API
     * and apply the appropriate profile on a player.
     *
     * @return The knockback profile name
     */
    String getKnockbackProfile();

    /**
     * Sets the knockback profile name for this kit.
     *
     * @param knockbackProfile The new knockback profile name
     */
    void setKnockbackProfile(String knockbackProfile);

    /**
     * The knockback profile name which will be used
     * to access custom spigot forks' knockback API
     * and apply the appropriate profile on a bot.
     *
     * @return The bot knockback profile name
     */
    String getBotKnockbackProfile();

    /**
     * Sets the bot knockback profile name for this kit.
     *
     * @param botKnockbackProfile The new bot knockback profile name
     */
    void setBotKnockbackProfile(String botKnockbackProfile);

    /**
     * The display icon for this kit.
     * This is the icon that is displayed in menus.
     *
     * @return The display icon for this kit
     */
    ItemStack getDisplayIcon();

    /**
     * Sets the display icon for this kit.
     *
     * @param displayIcon The new display icon for this kit
     */
    void setDisplayIcon(ItemStack displayIcon);

    /**
     * Items which will be available for players to grab in the kit
     * editor, when making kits for this kit type.
     *
     * @return The editor items for this kit
     */
    ItemStack[] getEditorItems();

    /**
     * Sets the editor items for this kit.
     *
     * @param editorItems The new editor items for this kit
     */
    void setEditorItems(ItemStack[] editorItems);

    /**
     * The armor that will be applied to players for this kit type.
     * Currently, players are not allowed to edit their armor, they are
     * always given this armor. The contents returned by this method
     * will not be colored, if this is a colored kit.
     *
     * @return The default armor for this kit
     */
    ItemStack[] getDefaultArmor();

    /**
     * Sets the default armor for this kit.
     *
     * @param defaultArmor The new default armor for this kit
     */
    void setDefaultArmor(ItemStack[] defaultArmor);

    /**
     * The default inventory that will be applied to players for this kit type.
     * This will not contain colored items, if this is a colored kit.
     *
     * @return The default inventory for this kit
     */
    ItemStack[] getDefaultInventory();

    /**
     * Sets the default inventory for this kit.
     *
     * @param defaultInventory The new default inventory for this kit
     */
    void setDefaultInventory(ItemStack[] defaultInventory);

    /**
     * The potion effects that will be applied to players
     * for this kit type. These potion effects are reapplied
     * every time the kit is applied to the player.
     *
     * @return The potion effects for this kit
     */
    Collection<PotionEffect> getPotionEffects();

    /**
     * Sets the potion effects for this kit.
     *
     * @param potionEffects The new potion effects for this kit
     */
    void setPotionEffects(Collection<PotionEffect> potionEffects);

    /**
     * Whether or not the disclaimer is enabled for this kit.
     *
     * @return true if the disclaimer is enabled, false otherwise
     */
    boolean isDisclaimerEnabled();

    /**
     * Sets whether or not the disclaimer is enabled for this kit.
     *
     * @param disclaimerEnabled true to enable the disclaimer, false to disable it
     */
    void setDisclaimerEnabled(boolean disclaimerEnabled);

    /**
     * The disclaimer that will be shown to players when a
     * match with this kit starts, if the disclaimer is enabled.
     *
     * @return The disclaimer for this kit
     */
    List<String> getDisclaimer();

    /**
     * Sets the disclaimer for this kit.
     *
     * @param disclaimer The new disclaimer for this kit
     */
    void setDisclaimer(List<String> disclaimer);

    /**
     * The description of this kit. This is usually a short
     * description of the kit's play style or mechanics.
     *
     * @return {@link List} of {@link String} description lines
     */
    List<String> getDescription();

    /**
     * Sets the description for this kit.
     *
     * @param description The new description for this kit
     */
    void setDescription(List<String> description);

    /**
     * The commands that will be executed when a match
     * starts. The format for the commands is as follows: "EXECUTOR:COMMAND"
     * Where EXECUTOR is either "CONSOLE" or "PLAYER". The COMMAND is the command
     * to be executed (without the '/').
     *
     * @return {@link List} of {@link String} commands to be executed on match start
     */
    List<String> getMatchStartCommands();

    /**
     * The commands that will be executed when a match
     * ends. The format for the commands is as follows: "EXECUTOR:COMMAND"
     * Where EXECUTOR is either "CONSOLE" or "PLAYER". The COMMAND is the command
     * to be executed (without the '/').
     *
     * @return {@link List} of {@link String} commands to be executed on match end
     */
    List<String> getMatchEndCommands();

    /**
     * The blocks that are allowed to be broken even if
     * they are a part of the map.
     *
     * @return {@link Set} of {@link XMaterial} that are allowed to be broken
     */
    Set<XMaterial> getAllowedBlocks();

    /**
     * The blocks that are not allowed to be broken
     * even if they are in the allowed list or explosion list.
     *
     * @return {@link Set} of {@link XMaterial} that are not allowed to be broken
     */
    Set<XMaterial> getDisallowedBlocks();

    /**
     * The blocks that are not allowed to be exploded. This is useful
     * for blocks that you want to allow breaking but not allow exploding,
     * like blast proof glass in bed fight.
     *
     * @return {@link Set} of {@link XMaterial} that are not allowed to be exploded
     */
    Set<XMaterial> getExplosionBlacklist();

    /**
     * The blocks that are allowed to be dropped
     * when broken. This won't contain the hardcoded blocks for the kit
     * logic itself (e.g. snow for spleef).
     *
     * @return {@link Set} of {@link XMaterial} that are allowed to be dropped
     */
    Set<XMaterial> getDroppableBlocks();

    /**
     * Get the unranked solo queue id for this kit.
     *
     * @return The unranked solo queue for this kit
     */
    UUID getSoloUnrankedQueue();

    /**
     * Get the ranked solo queue id for this kit.
     *
     * @return The ranked solo queue for this kit
     */
    UUID getSoloRankedQueue();

    /**
     * Get the unranked duo queue id for this kit.
     *
     * @return The unranked duo queue for this kit
     */
    UUID getDuoUnrankedQueue();

    /**
     * Get the ranked duo queue id for this kit.
     *
     * @return The ranked duo queue for this kit
     */
    UUID getDuoRankedQueue();

    /**
     * Applies the kit to the given player.
     * This includes setting their inventory, armor, and potion effects.
     *
     * @param player The player to apply the kit to
     */
    void apply(Player player);

    /**
     * Applies the kit to the given player with a custom inventory.
     * This includes setting their inventory, armor, and potion effects.
     *
     * @param player The player to apply the kit to
     * @param kitInventory The custom inventory to apply to the player
     */
    void apply(Player player, IKitInventory kitInventory);

    /**
     * Applies the kit to the given player with a custom inventory and color options.
     * This includes setting their inventory, armor, and potion effects.
     *
     * @param player The player to apply the kit to
     * @param kitInventory The custom inventory to apply to the player
     * @param red Whether to apply red color to applicable items
     * @param wool Whether to apply wool color to applicable items
     */
    void applyColored(Player player, IKitInventory kitInventory, boolean red, boolean wool);

    /**
     * Is building allowed in this kit? This is different from the
     * {@link #isBuild()} rule, which is a toggleable kit rule. This
     * method is used to determine if building is allowed at all,
     * regardless of the kit rule.
     *
     * @return true if building is allowed, false otherwise
     */
    boolean allowedBuild();

    /**
     * Is fall damage enabled in this kit? This is different from the
     * {@link #isNoFall()} rule, which is a toggleable kit rule. This
     * method is used to determine if fall damage is enabled at all,
     * regardless of the kit rule.
     *
     * @return true if fall damage is enabled, false otherwise
     */
    boolean isFallDamage();

    /**
     * Is hunger disabled in this kit? This is different from the
     * {@link #isNoHunger()} rule, which is a toggleable kit rule. This
     * method is used to determine if hunger is disabled at all.
     *
     * @return true if hunger is disabled, false otherwise
     */
    boolean isHungerDisabled();

    /**
     * Is item dropping disabled in this kit? This is different from the
     * {@link #isNoDrop()} rule, which is a toggleable kit rule. This
     * method is used to determine if item dropping is disabled at all.
     * For example, in battle rush, you cannot drop items.
     *
     * @return true if item dropping is disabled, false otherwise
     */
    boolean isAntiDrop();

    /**
     * Is damage disabled in this kit? Used for kits like spleef,
     * sumo, boxing, etc.
     *
     * @return true if damage is disabled, false otherwise
     */
    boolean isAntiDamage();

    /**
     * Is movement denial enabled in this kit? This is different from
     * the {@link #isStickSpawn()} rule. This method is used to determine
     * if movement denial is enabled at all, regardless of the kit rule.
     *
     * @return true if movement denial is enabled, false otherwise
     */
    boolean isDenyMovement();

    /**
     * Does this kit use colored items?
     * Like wool, leather armor, etc.
     *
     * @return true if colored items are used, false otherwise
     */
    boolean isColored();

    /**
     * Does this kit use wool instead of clay?
     * Like in bed fight, fireball fight, battle rush, etc.
     *
     * @return true if wool is used, false otherwise
     */
    boolean usesWool();

    /**
     * Is spawn protection enabled in this kit? Gives the player a grace
     * period of invulnerability after spawning for a few seconds.
     *
     * @return true if spawn protection is enabled, false otherwise
     */
    boolean isSpawnProtection();

    /**
     * Should the blocks placed during a round be cleared
     * at the end of the round?
     *
     * @return true if round blocks should be cleared, false otherwise
     */
    boolean clearRoundBlocks();

    /**
     * Is this kit a bed fight style kit? Returns true for
     * fireball fight and bed fight kits.
     *
     * @return true if this is a bed fight style kit, false otherwise
     */
    boolean isBedFight();

    /**
     * Is an FFA match possible with this kit?
     *
     * @return true if FFA is possible, false otherwise
     */
    boolean isFFA();

    /**
     * Is a Party Split match possible with this kit?
     * Party split is basically a standard team match.
     *
     * @return true if Party Split is possible, false otherwise
     */
    boolean isPartySplit();

    /**
     * Is this kit a portal kit? Portal kits are kits that
     * use portals for scoring points.
     *
     * @return true if this is a portal kit, false otherwise
     */
    boolean isPortal();

    // Boolean rules
    boolean isEnabled();
    void setEnabled(boolean enabled);

    boolean isRanked();
    void setRanked(boolean ranked);

    boolean isBuild();
    void setBuild(boolean build);

    boolean isShowHP();
    void setShowHP(boolean showHP);

    boolean isSpleef();
    void setSpleef(boolean spleef);

    boolean isBattleRush();
    void setBattleRush(boolean battleRush);

    boolean isFireballFight();
    void setFireballFight(boolean fireballFight);

    boolean isPearlFight();
    void setPearlFight(boolean pearlFight);

    boolean isBridges();
    void setBridges(boolean bridges);

    boolean isPearlDamage();
    void setPearlDamage(boolean pearlDamage);

    boolean isNoDrop();
    void setNoDrop(boolean noDrop);

    boolean isNoRegen();
    void setNoRegen(boolean noRegen);

    boolean isNoFall();
    void setNoFall(boolean noFall);

    boolean isNoHunger();
    void setNoHunger(boolean noHunger);

    boolean isBlockRemoval();
    void setBlockRemoval(boolean blockRemoval);

    boolean isRespawnMode();
    void setRespawnMode(boolean respawnMode);

    boolean isLegacyCombat();
    void setLegacyCombat(boolean legacyCombat);

    boolean isBuildHeightDamage();
    void setBuildHeightDamage(boolean buildHeightDamage);

    boolean isTopFight();
    void setTopFight(boolean topFight);

    void setBedFight(boolean bedFight);

    boolean isStickFight();
    void setStickFight(boolean stickFight);

    boolean isStickSpawn();
    void setStickSpawn(boolean stickSpawn);

    boolean isPartyFFA();
    void setPartyFFA(boolean partyFFA);

    void setPartySplit(boolean partySplit);

    boolean isVoidSpawn();
    void setVoidSpawn(boolean voidSpawn);

    boolean isBoxing();
    void setBoxing(boolean boxing);

    boolean isCombo();
    void setCombo(boolean combo);

    boolean isSumo();
    void setSumo(boolean sumo);

    boolean isLiquidKill();
    void setLiquidKill(boolean liquidKill);

    boolean isMlgRush();
    void setMlgRush(boolean mlgRush);

    boolean isCrystalPvP();
    void setCrystalPvP(boolean crystalPvP);

    boolean isTntDamageEnabled();
    void setTntDamageEnabled(boolean cartPvP);

    boolean isTntSumo();
    void setTntSumo(boolean tntSumo);

    boolean isWindChargeMode();
    void setWindChargeMode(boolean windChargeMode);

    boolean isOitq();
    void setOitq(boolean oitq);

    boolean isPreSplash();
    void setPreSplash(boolean preSplash);

    boolean isBreakMap();
    void setBreakMap(boolean breakMap);

    boolean isPearlCooldown();
    void setPearlCooldown(boolean pearlCooldown);

    boolean isEditable();
    void setEditable(boolean editable);

    int getBestOf();
    void setBestOf(int bestOf);

    int getNoDamageTicks();
    void setNoDamageTicks(int noDamageTicks);

    int getRespawnTicks();
    void setRespawnTicks(int respawnTicks);

    int getCountdownTicks();
    void setCountdownTicks(int countdownTicks);

    int getBlockTimer();
    void setBlockTimer(int blockTimer);

    int getTntFuseTicks();
    void setTntFuseTicks(int tntFuseTicks);

    int getTntSumoAmount();
    void setTntSumoAmount(int tntSumoAmount);

    int getSortPriority();
    void setSortPriority(int sortPriority);

    int getQueueSlot();
    void setQueueSlot(int queueSlot);
}
