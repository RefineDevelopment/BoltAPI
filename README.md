# Bolt API
A simple and easy to use API for Bolt version 1.6 and above.

## Installation
### Gradle
```kotlin
repositories {
    maven {
        name = "refine-public"
        url = uri("https://maven.refinedev.xyz/public-repo/")
    }
}

dependencies {
    compileOnly("xyz.refinedev.practice:BoltAPI:VERSION") // Replace VERSION with the latest version
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>refine-public</id>
        <url>https://maven.refinedev.xyz/public-repo/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>xyz.refinedev.practice</groupId>
        <artifactId>BoltAPI</artifactId>
        <version>VERSION</version> <!-- Replace VERSION with the latest version -->
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## Usage

To hook into Bolt properly with the API, you need to set your plugin.yml to soft-depend on Retention (Refine's dynamic plugin loader system).

```yml
name: TestPlugin
version: 1.0.0
description: "xyz"
author: "xyz"
main: "xyz"
api-version: "1.13"
softdepend:
  - Retention # Define here
```

The BoltAPI provides a comprehensive set of APIs for interacting with Bolt practice server functionality. All APIs are accessed through the main `BoltAPI` singleton instance.

### Getting Started
```java
import xyz.refinedev.practice.api.BoltAPI;

// Get the main API instance
BoltAPI api = BoltAPI.INSTANCE;
```

### Profile API

```java
import xyz.refinedev.practice.api.profile.ProfileAPI;
import xyz.refinedev.practice.api.profile.IProfile;

ProfileAPI profileAPI = api.getProfileAPI();

// Get a player's profile
IProfile profile = profileAPI.getProfile(player);

// Fetch a profile asynchronously (useful for offline players)
CompletableFuture<IProfile> profileFuture = profileAPI.fetchProfile(playerUUID);

// Save a profile
profileAPI.saveProfile(profile, true); // async save

// Refresh player's hotbar based on their state
profileAPI.refreshHotbar(profile);

// Get profile histories
CompletableFuture<List<IProfileHistory>> histories = profileAPI.getProfileHistories(profile);
```

### Match API

```java
import xyz.refinedev.practice.api.match.MatchAPI;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.enums.MatchEndReason;

MatchAPI matchAPI = api.getMatchAPI();

// End a match properly (handles stats, ELO, etc.)
matchAPI.end(match, MatchEndReason.PLAYER_DISCONNECT);

// Terminate a match (cleanup only)
matchAPI.terminateMatch(match);

// Get a player's current match
IMatch playerMatch = matchAPI.getMatch(player);

// Get all active matches
Collection<IMatch> matches = matchAPI.getMatches();
```

### Queue API

```java
import xyz.refinedev.practice.api.queue.QueueAPI;
import xyz.refinedev.practice.api.queue.IQueue;

QueueAPI queueAPI = api.getQueueAPI();

// Get a queue by ID
IQueue queue = queueAPI.getQueue(queueUUID);

// Get all solo queues
List<IQueue> soloQueues = queueAPI.getSoloQueues();

// Get all duo queues
List<IQueue> duoQueues = queueAPI.getDuoQueues();

// Add player to queue
queueAPI.addToQueue(player, queue);

// Remove player from queue
queueAPI.removeFromQueue(player);
```

### Kit API

```java
import xyz.refinedev.practice.api.kit.KitAPI;
import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.kit.IKitBuilder;

KitAPI kitAPI = api.getKitAPI();

// Create a new kit
IKitBuilder builder = kitAPI.createBuilder();
IKit kit = builder
    .name("nodebuff")
    .displayName("&cNo Debuff")
    .displayIcon(new ItemStack(Material.POTION))
    .build();

kit.setDefaultInventory(new ItemStack[] { /* items */ });
kit.setDefaultArmor(new ItemStack[] { /* armor */ });

kitAPI.registerKit(kit, true); // register and save the kit

// Apply kit to player
kit.applyKit(player);

// Get all kits
List<IKit> allKits = kitAPI.getAllKits(); // Immutable list

// Get a kit by name
IKit kit = kitAPI.getKit("nodebuff");
```

### Stats API

```java
import xyz.refinedev.practice.api.stats.StatsAPI;
import xyz.refinedev.practice.api.stats.IStatsProfile;

StatsAPI statsAPI = api.getStatsAPI();

// Get player's stats profile
IStatsProfile stats = statsAPI.getStatsProfile(player);

// Get stats asynchronously from the database
CompletableFuture<IStatsProfile> statsFuture = statsAPI.getStatsProfile(playerUUID);

// Save stats profile
statsAPI.saveStatsProfile(stats, true); // async save
```

### Leaderboard API

```java
import xyz.refinedev.practice.api.leaderboard.LeaderboardAPI;
import xyz.refinedev.practice.api.leaderboard.meta.IKitLeaderboard;

LeaderboardAPI leaderboardAPI = api.getLeaderboardAPI();

// Get leaderboard for a specific kit
CompletableFuture<IKitLeaderboard> leaderboard = leaderboardAPI.getKitLeaderboard(kit, 10);

// Get global leaderboard
CompletableFuture<IKitLeaderboard> globalLeaderboard = leaderboardAPI.getGlobalLeaderboard(10);

// Update leaderboards (should be called asynchronously)
leaderboardAPI.update();

// Clear cached leaderboard data
leaderboardAPI.clearCache();
```

### Knockback API

```java
import xyz.refinedev.api.knockback.IKnockbackHandler;
import xyz.refinedev.api.knockback.KnockbackHook;

IKnockbackHandler knockbackHandler = api.getKnockbackHandler();

// Implement custom knockback
KnockbackHook customHook = new KnockbackHook() {
    
    @Override
    public String getName() {
        return "Paper";
    }
    
    @Override
    public boolean isApplicable() {
        return true;
    }

    @Override
    public void setKnockback(@NotNull Player player, @NotNull String knockbackProfile) {
        // Custom knockback logic here
    }
};

// Set your custom knockback implementation
knockbackHandler.setHook(customHook);
```

### Events
The API provides several events you can listen to:

```java
import xyz.refinedev.practice.api.profile.events.*;

@EventHandler
public void onProfileJoin(ProfileJoinEvent event) {
    IProfile profile = event.getProfile();
    // Handle profile join
}

@EventHandler
public void onProfileLeave(ProfileLeaveEvent event) {
    IProfile profile = event.getProfile();
    // Handle profile leave
}

@EventHandler
public void onProfileKnockback(ProfileKnockbackEvent event) {
    Player player = event.getPlayer();
    // Triggered when knockback is applied, use priority above NORMAL to override behavior
}
```
