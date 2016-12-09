package io.gametrack.competition.domain;

import io.gametrack.score.domain.entity.Score;
import io.gametrack.score.ScorePair;

import java.util.List;

/**
 * @author Kevin Sutton
 */
public interface ScoreLister {
    List<? extends Score> getScores();
    ScorePair getScorePair();
}
