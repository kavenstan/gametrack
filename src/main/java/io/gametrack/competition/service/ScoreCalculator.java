package io.gametrack.competition.service;

import io.gametrack.competition.domain.entity.Match;
import io.gametrack.competition.domain.entity.Score;
import io.gametrack.player.Side;

/**
 * @author Kevin Sutton
 */
public class ScoreCalculator {

    public static int gamePointsWonInMatchForSide(Match match, Side side) {
        return match.getGames().stream()
                .flatMap(g -> g.getScores().stream())
                .filter(s -> s.getSide().equals(side))
                .mapToInt(Score::getScore).sum();
    }

}
