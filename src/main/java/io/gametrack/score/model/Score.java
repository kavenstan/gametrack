package io.gametrack.score.model;

import io.gametrack.competition.model.Contest;

/**
 * @author Kevin Sutton
 */
public interface Score {
    int getValue();
    void setValue(int value);
}
