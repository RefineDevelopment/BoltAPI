package xyz.refinedev.practice.api.tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TournamentState {

    WAITING("Waiting"),
    STARTING("Starting"),
    FIGHTING("Fighting"),
    ENDED("Ended");

    private final String name;
}
