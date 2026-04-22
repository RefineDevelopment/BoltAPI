# Bolt API
Bolt's public API for profiles, queues, kits, matches, parties, tournaments, duels, stats, leaderboards, and knockback hooks.

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
    compileOnly("xyz.refinedev.practice:BoltAPI:VERSION")
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
        <version>VERSION</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## plugin.yml
Bolt is loaded through Retention, so your plugin should soft-depend on it.

```yml
softdepend:
  - Retention
```

## Getting Started
```java
import xyz.refinedev.practice.api.BoltAPI;

BoltAPI api = BoltAPI.INSTANCE;
```

## Match API
```java
import org.bukkit.entity.Player;
import xyz.refinedev.practice.api.kit.IKit;
import xyz.refinedev.practice.api.match.IMatch;
import xyz.refinedev.practice.api.match.MatchAPI;
import xyz.refinedev.practice.api.match.enums.MatchEndReason;

MatchAPI matchAPI = api.getMatchAPI();

IMatch currentMatch = matchAPI.getMatchByPlayer(player);
IMatch sameMatch = matchAPI.getMatch(player); // alias

matchAPI.end(currentMatch, MatchEndReason.NORMAL);
matchAPI.terminateMatch(currentMatch);

IMatch ranked = matchAPI.createSoloRankedMatch(playerA, playerB, kit);
IMatch unranked = matchAPI.createSoloUnrankedMatch(playerA, playerB, kit);
IMatch teamMatch = matchAPI.createTeamMatch(teamAPlayers, teamBPlayers, kit, true);

matchAPI.handleRespawn(currentMatch, player);
int fighting = matchAPI.getFightingCount();
int botFights = matchAPI.getBotMatchesCount();
```

Useful `IMatch` runtime methods:

```java
List<Player> spectators = match.getSpectatingPlayers();
List<Player> alive = match.getAlivePlayers();
List<? extends IMatchPlayer> players = match.getMatchPlayers();
List<? extends IMatchTeam> teams = match.getMatchTeams();

IMatchPlayer winner = match.getWinningPlayer();
IMatchTeam winningTeam = match.getWinningTeam();

String duration = match.getDuration();
String lasted = match.getLasted();
```

## Party API
```java
import xyz.refinedev.practice.api.party.IParty;
import xyz.refinedev.practice.api.party.IPartySettings;
import xyz.refinedev.practice.api.party.PartyAPI;

PartyAPI partyAPI = api.getPartyAPI();

IParty party = partyAPI.createParty(leader);
partyAPI.invite(leader, invitedPlayer);
partyAPI.join(invitedPlayer, party);
partyAPI.promote(leader, newLeader);
partyAPI.kick(newLeader, kickedMember);
partyAPI.leave(member);
partyAPI.disband(newLeader);

boolean canQueueRanked = partyAPI.canQueue(party, true);

IParty currentParty = partyAPI.getParty(player);
IPartySettings settings = currentParty.getSettings();
```

Useful `IParty` runtime methods:

```java
String name = party.getName();
PartyState state = party.getState();
boolean busy = party.isBusy();

List<UUID> invites = party.getInvites();
boolean invited = party.isInvited(player.getUniqueId());
boolean member = party.isMember(player.getUniqueId());

IQueue queue = party.getQueue();
IMatch partyMatch = party.getMatch();
party.reloadHotbar();
party.reloadNameTag();
```

## Duel API
```java
import xyz.refinedev.practice.api.duel.DuelAPI;
import xyz.refinedev.practice.api.duel.IDuelRequest;
import xyz.refinedev.practice.api.duel.IPartyDuelRequest;
import xyz.refinedev.practice.api.duel.IProfileDuelRequest;

DuelAPI duelAPI = api.getDuelAPI();

IProfileDuelRequest soloRequest = duelAPI.request(playerA, playerB, kit);
IProfileDuelRequest sameSoloRequest = duelAPI.getRequest(playerA, playerB);

IPartyDuelRequest partyRequest = duelAPI.request(partyA, partyB, kit);
IPartyDuelRequest samePartyRequest = duelAPI.getRequest(partyA, partyB);

Collection<IDuelRequest> activeRequests = duelAPI.getActiveRequests();

if (soloRequest != null && soloRequest.isActive()) {
    soloRequest.accept();
}

if (partyRequest != null && partyRequest.isActive()) {
    duelAPI.cancel(partyRequest);
}
```

Bolt handles arena selection internally for API-created duel requests.

## Tournament API
```java
import org.bukkit.command.CommandSender;
import xyz.refinedev.practice.api.tournament.ITournament;
import xyz.refinedev.practice.api.tournament.TournamentAPI;
import xyz.refinedev.practice.api.tournament.TournamentEndReason;
import xyz.refinedev.practice.api.tournament.TournamentType;

TournamentAPI tournamentAPI = api.getTournamentAPI();

ITournament soloTournament = tournamentAPI.startTournament(sender, kit, TournamentType.SOLO);
ITournament teamTournament = tournamentAPI.startTournament(sender, kit, TournamentType.TEAM, 2);

tournamentAPI.join(player);
tournamentAPI.leave(player);
tournamentAPI.forceStart();
tournamentAPI.cancelTournament();
tournamentAPI.end(TournamentEndReason.CANCELLED);
```

Useful `ITournament` runtime methods:

```java
List<? extends IMatch> matches = tournament.getMatches();
List<Player> players = tournament.getPlayerParticipants();
List<IParty> parties = tournament.getPartyParticipants();

Player winningPlayer = tournament.getWinningPlayer();
IParty winningParty = tournament.getWinningParty();
Object winningSubject = tournament.getWinningSubject();
```

## Other APIs
```java
ProfileAPI profileAPI = api.getProfileAPI();
QueueAPI queueAPI = api.getQueueAPI();
KitAPI kitAPI = api.getKitAPI();
StatsAPI statsAPI = api.getStatsAPI();
LeaderboardAPI leaderboardAPI = api.getLeaderboardAPI();
IKnockbackHandler knockbackHandler = api.getKnockbackHandler();
```

## Events
Solo-only match events:

```java
@EventHandler
public void onSoloWin(MatchWinEvent event) {
    IMatchPlayer winner = event.getWinner();
}
```

Team-safe match events:

```java
@EventHandler
public void onTeamWin(MatchTeamWinEvent event) {
    IMatchTeam winningTeam = event.getWinningTeam();
}

@EventHandler
public void onTeamLose(MatchTeamLoseEvent event) {
    IMatchTeam losingTeam = event.getLosingTeam();
}

@EventHandler
public void onTeamPreEnd(MatchTeamPreEndEvent event) {
    if (event.getMatch().isPartyMode()) {
        // Optional cancellation hook
    }
}

@EventHandler
public void onTeamRoundEnd(MatchTeamRoundEndEvent event) {
    int round = event.getRound();
}
```

Party and tournament lifecycle events:

```java
@EventHandler
public void onPartyCreate(PartyCreateEvent event) {
    IParty party = event.getParty();
}

@EventHandler
public void onTournamentStart(TournamentStartEvent event) {
    ITournament tournament = event.getTournament();
}
```
