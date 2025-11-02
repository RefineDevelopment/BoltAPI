package xyz.refinedev.practice.api.kit;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import xyz.refinedev.practice.api.queue.IQueue;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Builder interface for constructing {@link IKit} instances.
 * Allows for a fluent API to set properties and then call {@link #build()}.
 */
public interface IKitBuilder {

    IKitBuilder name(String name);
    IKitBuilder displayName(String displayName);
    IKitBuilder knockbackProfile(String knockbackProfile);
    IKitBuilder botKnockbackProfile(String botKnockbackProfile);
    IKitBuilder displayIcon(ItemStack displayIcon);
    IKitBuilder editorItems(ItemStack[] editorItems);
    IKitBuilder defaultArmor(ItemStack[] defaultArmor);
    IKitBuilder defaultInventory(ItemStack[] defaultInventory);
    IKitBuilder potionEffects(Collection<PotionEffect> potionEffects);
    IKitBuilder disclaimerEnabled(boolean disclaimerEnabled);
    IKitBuilder disclaimer(List<String> disclaimer);
    IKitBuilder description(List<String> description);
    IKitBuilder matchStartCommands(List<String> matchStartCommands);
    IKitBuilder matchEndCommands(List<String> matchEndCommands);
    IKitBuilder allowedBlocks(Set<XMaterial> allowedBlocks);
    IKitBuilder disallowedBlocks(Set<XMaterial> disallowedBlocks);
    IKitBuilder explosionBlacklist(Set<XMaterial> explosionBlacklist);
    IKitBuilder droppableBlocks(Set<XMaterial> droppableBlocks);
    IKitBuilder soloUnrankedQueue(IQueue soloUnrankedQueue);
    IKitBuilder soloRankedQueue(IQueue soloRankedQueue);
    IKitBuilder duoUnrankedQueue(IQueue duoUnrankedQueue);
    IKitBuilder duoRankedQueue(IQueue duoRankedQueue);

    // Boolean kit rules
    IKitBuilder enabled(boolean enabled);
    IKitBuilder ranked(boolean ranked);
    IKitBuilder buildAllowed(boolean build);
    IKitBuilder showHP(boolean showHP);
    IKitBuilder spleef(boolean spleef);
    IKitBuilder battleRush(boolean battleRush);
    IKitBuilder fireballFight(boolean fireballFight);
    IKitBuilder pearlFight(boolean pearlFight);
    IKitBuilder bridges(boolean bridges);
    IKitBuilder pearlDamage(boolean pearlDamage);
    IKitBuilder noDrop(boolean noDrop);
    IKitBuilder noRegen(boolean noRegen);
    IKitBuilder noFall(boolean noFall);
    IKitBuilder noHunger(boolean noHunger);
    IKitBuilder blockRemoval(boolean blockRemoval);
    IKitBuilder respawnMode(boolean respawnMode);
    IKitBuilder legacyCombat(boolean legacyCombat);
    IKitBuilder buildHeightDamage(boolean buildHeightDamage);
    IKitBuilder topFight(boolean topFight);
    IKitBuilder bedFight(boolean bedFight);
    IKitBuilder stickFight(boolean stickFight);
    IKitBuilder stickSpawn(boolean stickSpawn);
    IKitBuilder partyFFA(boolean partyFFA);
    IKitBuilder partySplit(boolean partySplit);
    IKitBuilder voidSpawn(boolean voidSpawn);
    IKitBuilder boxing(boolean boxing);
    IKitBuilder combo(boolean combo);
    IKitBuilder sumo(boolean sumo);
    IKitBuilder liquidKill(boolean liquidKill);
    IKitBuilder mlgRush(boolean mlgRush);
    IKitBuilder crystalPvP(boolean crystalPvP);
    IKitBuilder tntEnabled(boolean tntEnabled);
    IKitBuilder tntSumo(boolean tntSumo);
    IKitBuilder windChargeMode(boolean windChargeMode);
    IKitBuilder oitq(boolean oitq);
    IKitBuilder preSplash(boolean preSplash);
    IKitBuilder breakMap(boolean breakMap);
    IKitBuilder pearlCooldown(boolean pearlCooldown);
    IKitBuilder editable(boolean editable);

    // Integer kit rules
    IKitBuilder bestOf(int bestOf);
    IKitBuilder noDamageTicks(int noDamageTicks);
    IKitBuilder respawnTicks(int respawnTicks);
    IKitBuilder countdownTicks(int countdownTicks);
    IKitBuilder blockTimer(int blockTimer);
    IKitBuilder tntFuseTicks(int tntFuseTicks);
    IKitBuilder tntSumoAmount(int tntSumoAmount);
    IKitBuilder sortPriority(int sortPriority);
    IKitBuilder queueSlot(int queueSlot);

    /**
     * Builds the final {@link IKit} instance.
     *
     * @return a fully constructed IKit
     */
    IKit build();
}
