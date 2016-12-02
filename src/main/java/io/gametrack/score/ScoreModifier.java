package io.gametrack.score;

import io.gametrack.competition.domain.entity.Contest;

/**
 * @author Kevin Sutton
 */
public interface ScoreModifier<T extends Contest> {
    void modifyScore(T t, ScorePair scorePair);
}
