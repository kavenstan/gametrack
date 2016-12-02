package io.gametrack.competition.service;

import io.gametrack.competition.domain.entity.Game;
import io.gametrack.competition.domain.entity.Score;
import io.gametrack.player.Side;

import java.util.Optional;

/**
 * @author Kevin Sutton
 */
public class GameEvaluator implements ContestEvaluator {

    private Game game;

    public GameEvaluator(Game game) {
        this.game = game;
    }

    public boolean isDraw() {
        return false;
    }

    @Override
    public Optional<Side> getWinner() {

        Score scoreOne = game.getScores().get(0);
        Score scoreTwo = game.getScores().get(1);

        return Optional.of(
                scoreOne.getScore() > scoreTwo.getScore()
                ? scoreOne.getSide()
                : scoreTwo.getSide());
    }

}
