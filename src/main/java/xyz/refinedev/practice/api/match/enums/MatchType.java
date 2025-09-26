package xyz.refinedev.practice.api.match.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MatchType {

    SOLO("Solo"),
    SOLO_BED_FIGHT("Solo Bed Fight"),
    SOLO_BOT("Solo Bot"),
    SOLO_BOXING("Solo Boxing"),
    SOLO_BRIDGE("Solo Bridge"),
    SOLO_BATTLE_RUSH("Solo Battle Rush"),
    //SOLO_EMERALD_RUSH,

    TEAM("Team"),
    TEAM_BED_FIGHT("Team Bed Fight"),
    TEAM_BOT("Team Bot"),
    TEAM_BOXING("Team Boxing"),
    TEAM_BRIDGE("Team Bridge"),
    TEAM_BATTLE_RUSH("Team Battle Rush"),
    //TEAM_EMERALD_RUSH,

    FFA("FFA"),
    LIVES("Lives"),
    MLG_RUSH("MLG Rush");

    private final String displayName;
}
