package io.gametrack.competition.service;

import io.gametrack.competition.domain.entity.Match;
import io.gametrack.player.Side;

import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public class MatchEvaluator implements ContestEvaluator {

    private Match match;

    public MatchEvaluator(Match match) {
        this.match = match;
    }

    @Override
    public boolean isDraw() {
        return false;
    }

    @Override
    public Optional<Side> winner() {
        return null;
    }

/*    @Override
    public boolean isDraw() {
        if (!match.getRules().drawAllowed()) {
            return false;
        }

        return !getWinner().isPresent();
    }

    @Override
    public Optional<Side> getWinner() {
        Score scoreOne = match.getScores().get(0);
        Score scoreTwo = match.getScores().get(1);

        if (scoreOne.getScore() == scoreTwo.getScore()) {
            if (match.getRules().drawAllowed()) {
                return Optional.empty();
            }
            int gamePointsOne = ScoreCalculator.gamePointsWonInMatchForSide(match, scoreOne.getSide());
            int gamePointsTwo = ScoreCalculator.gamePointsWonInMatchForSide(match, scoreTwo.getSide());

            if (gamePointsOne == gamePointsTwo) {
                throw new GametrackException(GametrackExceptionType.INVALID_SCORE);
            }
            return Optional.of(
                    gamePointsOne > gamePointsTwo
                            ? scoreOne.getSide()
                            : scoreTwo.getSide()
            );
        }

        return Optional.of(
                scoreOne.getScore() > scoreTwo.getScore()
                ? scoreOne.getSide()
                : scoreTwo.getSide()
        );
    }*/


}
