package io.gametrack.competition.domain;

/**
 * @author Kevin Sutton
 */
public interface ContestRules {
    int bestOf();
    boolean playAll();
    boolean drawAllowed();
}
