package io.gametrack.competition;

import io.gametrack.player.Side;

/**
 * @author Kevin Sutton
 */
public class Game extends Contest {

    public Game() {
        scores = new int [2];
    }

    @Override
    public void incrementScore(Side side) {
        scores[sideScoreIndex(side)]++;
        if (evaluator.isWon()) {
            this.state = ContestState.WON;
            end();
        }
    }
}
